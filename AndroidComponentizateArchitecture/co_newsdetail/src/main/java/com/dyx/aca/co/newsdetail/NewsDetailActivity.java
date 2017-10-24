package com.dyx.aca.co.newsdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.dyx.aca.module.constants.ClassConstants;

/**
 * Author：dayongxin
 * Function：
 */
public class NewsDetailActivity extends AppCompatActivity {
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.co_newsdetail_activity_news_detail);
        initView();
    }

    private void initView() {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.add(R.id.fl_container, new NewsDetailFragment());
        ft.commit();
    }

    public String getTopicId() {
        return getIntent().getStringExtra(ClassConstants.BUNDLE_ID);
    }
}
