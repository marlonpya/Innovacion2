package application.ucweb.innovacion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import application.ucweb.innovacion.R;
import application.ucweb.innovacion.adapter.AdapterListaUsuario;
import application.ucweb.innovacion.modelo.Pedido;
import butterknife.BindView;
import butterknife.ButterKnife;
import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaUsuarioFragment extends Fragment {
    public static final String TAG = ListaUsuarioFragment.class.getSimpleName();
    @BindView(R.id.rrvListaUsuario) RealmRecyclerView recyclerView;
    private RealmResults<Pedido> listaPedidos;
    private AdapterListaUsuario adapter;
    private Realm realm;

    public ListaUsuarioFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_usuario, container, false);
        ButterKnife.bind(this, view);

        if (Pedido.getUltimoId() == 0) { cargarEjemplos(); }
        configuracionListaRealm();
        return view;
    }

    private void configuracionListaRealm() {
        realm = Realm.getDefaultInstance();
        listaPedidos = realm.where(Pedido.class).findAll();
        adapter = new AdapterListaUsuario(getActivity(), listaPedidos, true, true);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void cargarEjemplos() {
        realm = Realm.getDefaultInstance();
        for (int i = 0; i < 10; i++) {
            realm.beginTransaction();
            Pedido pedido = realm.createObject(Pedido.class);
            pedido.setId(Pedido.getUltimoId());
            pedido.setFecha("27/09/2016");
            pedido.setPrecio((double)200 + (double)i*10);
            pedido.setTipo("Mantenimiento " + String.valueOf(i));
            realm.commitTransaction();
            realm.copyToRealm(pedido);
            realm.close();
            Log.d(TAG, pedido.toString());
        }
    }

}
