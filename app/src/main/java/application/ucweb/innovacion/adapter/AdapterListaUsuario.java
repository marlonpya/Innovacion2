package application.ucweb.innovacion.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import application.ucweb.innovacion.R;
import application.ucweb.innovacion.modelo.Pedido;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;

/**
 * Created by ucweb02 on 27/09/2016.
 */
public class AdapterListaUsuario extends RealmBasedRecyclerViewAdapter<Pedido, AdapterListaUsuario.ViewHolder> {

    public AdapterListaUsuario(
            Context context,
            RealmResults<Pedido> realmResults,
            boolean automaticUpdate,
            boolean animateResults) {
        super(context, realmResults, automaticUpdate, animateResults);
    }

    @Override
    public ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.row_pedido, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindRealmViewHolder(ViewHolder viewHolder, int i) {
        final Pedido item = realmResults.get(i);
        viewHolder.fecha.setText(item.getFecha());
        viewHolder.precio.setText(String.valueOf(item.getPrecio()));
        viewHolder.tipo.setText(item.getTipo());
    }

    public class ViewHolder extends RealmViewHolder {
        @BindView(R.id.row_fecha) TextView fecha;
        @BindView(R.id.row_precio) TextView precio;
        @BindView(R.id.row_tipo) TextView tipo;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
