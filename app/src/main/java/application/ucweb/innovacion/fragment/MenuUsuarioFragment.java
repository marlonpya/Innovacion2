package application.ucweb.innovacion.fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import application.ucweb.innovacion.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuUsuarioFragment extends Fragment {
    @BindView(R.id.tvTipoPedido) TextView tvTipoPedido;
    @BindView(R.id.tvLatitud) TextView tvLatitud;
    @BindView(R.id.tvLongitud) TextView tvLongitud;
    private LocationManager manager;
    private MyLocationListener listener;

    public MenuUsuarioFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_usuario, container, false);
        ButterKnife.bind(this, view);
        manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        listener = new MyLocationListener();
        comenzarLocacion();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        comenzarLocacion();
    }

    @OnClick(R.id.cbTipos)
    public void dialogoTipos() {
        final String[] array = new String[]{"Opción1", "Opción2","Opción3"};
        new AlertDialog.Builder(getActivity())
                .setTitle("Seleccione un Tipo de Pedido:")
                .setSingleChoiceItems(array, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvTipoPedido.setText(array[which]);
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    private class MyLocationListener implements LocationListener{

        @Override
        public void onLocationChanged(Location location) {
            utilLocation(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {
            tvLatitud.setText("-");
            tvLongitud.setText("-");
        }
    }

    private void utilLocation(Location location) {
        tvLatitud.setText(String.valueOf(location.getLatitude()));
        tvLongitud.setText(String.valueOf(location.getLongitude()));
    }

    private void comenzarLocacion() {
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener );
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
        manager.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 0, 0, listener);
    }

}
