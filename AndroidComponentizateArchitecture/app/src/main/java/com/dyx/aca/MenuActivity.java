package com.dyx.aca;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.dyx.aca.co.discover.DiscoverFragment;
import com.dyx.aca.co.index.IndexFragment;
import com.dyx.aca.co.my.MyFragment;
import com.dyx.aca.module.base.BaseActivity;

public class MenuActivity extends BaseActivity {
    private IndexFragment mIndexFragment;
    private DiscoverFragment mDiscoverFragment;
    private MyFragment mMyFragment;
    private FragmentManager mFragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            hideAllFragment(ft);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (mIndexFragment == null) {
                        mIndexFragment = new IndexFragment();
                        ft.add(R.id.content, mIndexFragment);
                    } else {
                        ft.show(mIndexFragment);
                    }
                    ft.commit();
                    return true;
                case R.id.navigation_dashboard:
                    if (mDiscoverFragment == null) {
                        mDiscoverFragment = new DiscoverFragment();
                        ft.add(R.id.content, mDiscoverFragment);
                    } else {
                        ft.show(mDiscoverFragment);
                    }
                    ft.commit();
                    return true;
                case R.id.navigation_notifications:
                    if (mMyFragment == null) {
                        mMyFragment = new MyFragment();
                        ft.add(R.id.content, mMyFragment);
                    } else {
                        ft.show(mMyFragment);
                    }
                    ft.commit();
                    return true;
            }
            return false;
        }

    };

    private void hideAllFragment(FragmentTransaction ft) {
        if (mIndexFragment != null) {
            ft.hide(mIndexFragment);
        }
        if (mDiscoverFragment != null) {
            ft.hide(mDiscoverFragment);
        }
        if (mMyFragment != null) {
            ft.hide(mMyFragment);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mFragmentManager = getSupportFragmentManager();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initView();
    }

    private void initView() {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        if (mIndexFragment == null) {
            mIndexFragment = new IndexFragment();
            ft.add(R.id.content, mIndexFragment);
        } else {
            ft.show(mIndexFragment);
        }
        ft.commit();
    }

}
