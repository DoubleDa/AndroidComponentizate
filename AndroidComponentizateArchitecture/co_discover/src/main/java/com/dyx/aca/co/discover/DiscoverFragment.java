package com.dyx.aca.co.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dyx.aca.co.discover.constants.Constants;
import com.dyx.aca.co.discover.vassonic.HostSonicRuntime;
import com.dyx.aca.co.discover.vassonic.SonicSessionClientImpl;
import com.tencent.sonic.sdk.SonicConfig;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicSession;
import com.tencent.sonic.sdk.SonicSessionConfig;

/**
 * Author：dayongxin
 * Function：
 */
public class DiscoverFragment extends Fragment {
    private WebView mWebView;
    private SonicSession mSonicSession;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.co_discover_fragment_discover, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mWebView = view.findViewById(R.id.web_view);
        //initVasSonic();
        initWebView();
    }

    private void initWebView() {
        initWebSettings();
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                return super.shouldInterceptRequest(view, url);
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return super.shouldInterceptRequest(view, request);
            }
        });
        mWebView.loadUrl(Constants.WEB_VIEW_URL);
    }

    private void initVasSonic() {
        /**
         * 1、
         */
        if (!SonicEngine.isGetInstanceAllowed()) {
            SonicEngine.createInstance(new HostSonicRuntime(getActivity()), new SonicConfig.Builder().build());
        }
        SonicSessionClientImpl sessionClient = null;
        /**
         * 2
         */
        mSonicSession = SonicEngine.getInstance().createSession(Constants.WEB_VIEW_URL, new SonicSessionConfig.Builder().build());
        if (null != mSonicSession) {
            mSonicSession.bindClient(sessionClient = new SonicSessionClientImpl());
        } else {
            throw new UnknownError("create session fail!");
        }
        /**
         * 3
         */
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (mSonicSession != null) {
                    mSonicSession.getSessionClient().pageFinish(url);
                }
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return shouldInterceptRequest(view, request.getUrl().toString());
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                if (mSonicSession != null) {
                    return (WebResourceResponse) mSonicSession.getSessionClient().requestResource(url);
                }
                return null;
            }
        });
        initWebSettings();
        /**
         * 5
         */
        if (sessionClient != null) {
            sessionClient.bindWebView(mWebView);
            sessionClient.clientReady();
        } else {
            mWebView.loadUrl(Constants.WEB_VIEW_URL);
        }
    }

    private void initWebSettings() {
        WebSettings webSettings = mWebView.getSettings();
        /**
         * 4
         */
        webSettings.setJavaScriptEnabled(true);
        mWebView.removeJavascriptInterface("searchBoxJavaBridge_");

        // init webview settings
        webSettings.setAllowContentAccess(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setSavePassword(false);
        webSettings.setSaveFormData(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
    }

    @Override
    public void onDestroy() {
        if (null != mSonicSession) {
            mSonicSession.destroy();
            mSonicSession = null;
        }
        super.onDestroy();
    }
}
