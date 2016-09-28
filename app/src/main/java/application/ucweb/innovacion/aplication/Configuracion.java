package application.ucweb.innovacion.aplication;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ucweb02 on 27/09/2016.
 */
public class Configuracion extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration configuracionR = new RealmConfiguration
                .Builder(getApplicationContext())
                .name("proyectoipae.db")
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .initialData(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                    }
                })
                .build();
        Realm.setDefaultConfiguration(configuracionR);
    }
}
