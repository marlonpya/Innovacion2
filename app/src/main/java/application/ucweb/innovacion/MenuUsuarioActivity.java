package application.ucweb.innovacion;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.TextView;

import application.ucweb.innovacion.adapter.TabAdapter;
import application.ucweb.innovacion.aplication.BaseActivity;
import butterknife.BindView;

public class MenuUsuarioActivity extends BaseActivity {
    @BindView(R.id.tab_layout_admi) TabLayout tabLayout;
    @BindView(R.id.view_pager)ViewPager viewPager;
    @BindView(R.id.toolbar_principal) Toolbar toolbar;
    private TabAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
        setToolbarSon(toolbar, this, "Menu de Usuario");
        iniciarTab();
    }

    private void iniciarTab() {
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        setearTabs();
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        adapter = new TabAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setearTabs() {
        TextView customTab1 = (TextView) LayoutInflater.from(getApplicationContext()).inflate(R.layout.textview_uno, null);
        TextView customTab2 = (TextView) LayoutInflater.from(getApplicationContext()).inflate(R.layout.textview_uno, null);
        customTab1.setText("Menu");
        tabLayout.getTabAt(0).setCustomView(customTab1);
        customTab2.setText("Lista de Pedidos");
        tabLayout.getTabAt(1).setCustomView(customTab2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) { onBackPressed(); }
        return super.onOptionsItemSelected(item);
    }

}
