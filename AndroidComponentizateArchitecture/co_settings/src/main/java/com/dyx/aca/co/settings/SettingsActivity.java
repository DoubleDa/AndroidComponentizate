package com.dyx.aca.co.settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.dyx.aca.lib.utils.ToastUtils;
import com.dyx.aca.module.base.BaseActivity;
import com.github.mzule.activityrouter.annotation.Router;

/**
 * Author：dayongxin
 * Function：
 */
@Router("settings")
public class SettingsActivity extends BaseActivity {
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.co_settings_activity_settings);
        initView();
    }

    private void initView() {
        ToastUtils.showShort(this, getString(R.string.co_settings_from_data) + getIntent().getStringExtra("name"));
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.add(R.id.fl_container, new SettingsFragment());
        ft.commit();
    }
}
