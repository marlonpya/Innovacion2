package application.ucweb.innovacion;

import android.content.Intent;
import android.os.Bundle;

import application.ucweb.innovacion.aplication.BaseActivity;
import butterknife.OnClick;

public class InicioActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    @OnClick(R.id.btnIngresar)
    public void ingresar() {
        startActivity(new Intent(this, MenuUsuarioActivity.class));
    }

    @OnClick(R.id.btnRegistrarse)
    public void registrarse() {
        startActivity(new Intent(this, RegistroActivity.class));
    }
}
