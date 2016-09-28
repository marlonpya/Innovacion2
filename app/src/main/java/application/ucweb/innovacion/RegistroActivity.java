package application.ucweb.innovacion;

import android.os.Bundle;
import android.view.MenuItem;

import application.ucweb.innovacion.aplication.BaseActivity;
import butterknife.OnClick;

public class RegistroActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    @OnClick(R.id.btnAceptarRegistro)
    public void aceptarRegistro() {
        onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) { onBackPressed(); }
        return super.onOptionsItemSelected(item);
    }
}
