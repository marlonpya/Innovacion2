package application.ucweb.innovacion;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import application.ucweb.innovacion.aplication.BaseActivity;
import application.ucweb.innovacion.fragment.UsuarioTabFragment;

public class MenuUsuarioActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
        iniciarPrimerFragment();

    }

    private void iniciarPrimerFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedor, new UsuarioTabFragment());
        fragmentTransaction.commit();
    }

}
