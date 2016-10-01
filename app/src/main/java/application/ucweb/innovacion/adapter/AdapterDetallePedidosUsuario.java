package application.ucweb.innovacion.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import application.ucweb.innovacion.R;
import application.ucweb.innovacion.modelo.ItemPedido;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;

/**
 * Created by ucweb02 on 29/09/2016.
 */
public class AdapterDetallePedidosUsuario extends RealmBasedRecyclerViewAdapter<ItemPedido, AdapterDetallePedidosUsuario.ViewHolder> {

    public AdapterDetallePedidosUsuario(
            Context context,
            RealmResults<ItemPedido> realmResults,
            boolean automaticUpdate,
            boolean animateResults) {
        super(context, realmResults, automaticUpdate, animateResults);
    }

    @Override
    public ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(inflater.inflate(R.layout.row_detalle_servicio, viewGroup, false));
    }

    @Override
    public void onBindRealmViewHolder(ViewHolder viewHolder, int i) {
        final ItemPedido item = realmResults.get(i);
        viewHolder.icono.setColorFilter(item.getIcono());
        viewHolder.descripcion.setText(item.getDescripcion());
        viewHolder.precio.setText(String.valueOf(item.getPrecio()));
    }

    public class ViewHolder extends RealmViewHolder {
        @BindView(R.id.row_iv_icono) ImageView icono;
        @BindView(R.id.row_tv_descripcion_servicio) TextView descripcion;
        @BindView(R.id.row_tv_precio) TextView precio;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
