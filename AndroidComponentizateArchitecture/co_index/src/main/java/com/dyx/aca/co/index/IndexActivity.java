package com.dyx.aca.co.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.dyx.aca.module.base.BaseActivity;

/**
 * Author：dayongxin
 * Function：
 */
public class IndexActivity extends BaseActivity {
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.co_index_activity_index);
        initView();
    }

    private void initView() {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.add(R.id.fl_container, new IndexFragment());
        ft.commit();
    }
}
