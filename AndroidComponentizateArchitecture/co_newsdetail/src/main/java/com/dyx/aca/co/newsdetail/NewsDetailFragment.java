package com.dyx.aca.co.newsdetail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dyx.aca.lib.net.ApiConstants;
import com.dyx.aca.lib.net.ApiService;
import com.dyx.aca.lib.net.model.news.detail.NewsDetailBean;
import com.dyx.aca.lib.utils.ToastUtils;
import com.dyx.aca.lib.view.CustomTitleBar;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author：dayongxin
 * Function：
 */
public class NewsDetailFragment extends Fragment {
    private CustomTitleBar customTitleBar;
    private WebView webView;
    private String topicId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.co_newsdetail_fragment_news_detail, container, false);
        initView(view);
        return view;
    }


    private void initView(View view) {
        customTitleBar = view.findViewById(R.id.custom_title_bar);
        webView = view.findViewById(R.id.web_view);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        if (customTitleBar != null) {
            customTitleBar.setLeftClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().onBackPressed();
                }
            });
            customTitleBar.setRightClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtils.showShort(getActivity(), getString(R.string.co_newsdetail_str_share_not_finish));
                }
            });
        }
        handleNetTask();
    }

    private void handleNetTask() {
        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<NewsDetailBean> call = apiService.getTopicById(topicId);
        call.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<NewsDetailBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(NewsDetailBean newsDetailBean) {
                if (newsDetailBean != null) {
                    if (newsDetailBean.isSuccess()) {
                        NewsDetailBean.DataEntity dataEntity = newsDetailBean.getData();
                        String content = dataEntity.getContent();
                        String title = dataEntity.getTitle();
                        loadContentByWebview(content);
                        showTitle(title);
                    }
                }
            }
        });
    }

    private void showTitle(String title) {
        if (null != customTitleBar && !TextUtils.isEmpty(title)) {
            customTitleBar.setTitle(title);
        }
    }

    private void loadContentByWebview(String content) {
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return super.shouldInterceptRequest(view, request);
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                return super.shouldInterceptRequest(view, url);
            }
        });
        //出现乱码
//        webView.loadData(content, "text/html", "utf-8");
        //解决乱码
        webView.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        topicId = ((NewsDetailActivity) context).getTopicId();
    }
}
