package application.ucweb.innovacion.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import application.ucweb.innovacion.R;
import application.ucweb.innovacion.adapter.TabAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsuarioTabFragment extends Fragment {
    @BindView(R.id.tab_layout) TabLayout tab_layout;
    @BindView(R.id.pager)ViewPager pager;

    public UsuarioTabFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_usuario_opciones, container, false);
        ButterKnife.bind(this, view);
        tab_layout.addTab(tab_layout.newTab());
        tab_layout.addTab(tab_layout.newTab());
        setupTabLayout();
        tab_layout.setTabGravity(TabLayout.GRAVITY_FILL);
        final TabAdapter adapter = new TabAdapter(getFragmentManager(),tab_layout.getTabCount());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));
        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }

    private void setupTabLayout() {
        TextView customTab1 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.textview_uno, null);
        TextView customTab2 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.textview_dos, null);
        customTab1.setText("Menu");
        tab_layout.getTabAt(0).setCustomView(customTab1);
        customTab2.setText("Lista");
        tab_layout.getTabAt(1).setCustomView(customTab2);
    }

}
