package com.dyx.aca.co.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.dyx.aca.module.base.BaseActivity;
import com.dyx.aca.module.constants.ClassConstants;

/**
 * Author：dayongxin
 * Function：
 */
public class OrderActivity extends BaseActivity {
    public static final String TAB_INTENT = "tab_intent";
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.co_order_activity_order);
        initView();
    }

    private void initView() {
        OrderFragment orderFragment = new OrderFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TAB_INTENT, getIntent().getStringExtra(TAB_INTENT));
        orderFragment.setArguments(bundle);
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.add(R.id.fl_container, orderFragment);
        ft.commit();
    }

    public String getTabName() {
        return getIntent().getStringExtra(ClassConstants.BUNDLE_TAB);
    }
}
