package application.ucweb.innovacion.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import application.ucweb.innovacion.fragment.ListaUsuarioFragment;
import application.ucweb.innovacion.fragment.MenuUsuarioFragment;

/**
 * Created by ucweb02 on 27/09/2016.
 */
public class TabAdapter extends FragmentStatePagerAdapter {

    private int cantidad;

    public TabAdapter(FragmentManager fm, int cantidad) {
        super(fm);
        this.cantidad = cantidad;
    }

    @Override
    public Fragment getItem(int posicion) {
        switch (posicion){
            case 0 : return new MenuUsuarioFragment();
            case 1 : return new ListaUsuarioFragment();
            default: return new MenuUsuarioFragment();
        }
    }

    @Override
    public int getCount() {
        return cantidad;
    }
}
