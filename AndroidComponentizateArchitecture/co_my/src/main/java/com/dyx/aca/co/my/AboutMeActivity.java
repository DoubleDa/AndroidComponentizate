package com.dyx.aca.co.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;

import com.dyx.aca.lib.utils.ToastUtils;
import com.dyx.aca.lib.view.CustomTitleBar;
import com.dyx.aca.module.base.BaseActivity;

/**
 * Author：dayongxin
 * Function：
 */
public class AboutMeActivity extends BaseActivity {
    private CustomTitleBar customTitleBar;
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.co_my_activity_about_me);
        initView();
    }

    private void initView() {
        customTitleBar = (CustomTitleBar) findViewById(R.id.custom_title_bar);
        webView = (WebView) findViewById(R.id.web_view);
        if (customTitleBar != null) {
            customTitleBar.setLeftClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            customTitleBar.setRightClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtils.showShort(AboutMeActivity.this, getString(R.string.co_my_str_share_not_finish));
                }
            });
        }
        webView.loadUrl("file:///android_asset/AboutMe.html");
    }
}
