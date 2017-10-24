package com.dyx.aca.lib.net;

import com.dyx.aca.lib.net.model.index.IndexBean;
import com.dyx.aca.lib.net.model.news.detail.NewsDetailBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Author：dayongxin
 * Function：
 */
public interface ApiService {
    /**
     * @param map
     * @return get/topics主题首页
     */
    @GET(ApiConstants.URL_TOPICS)
    Observable<IndexBean> getTopics(@QueryMap Map<String, String> map);

    @GET(ApiConstants.URL_TOPIC_BY_ID)
    Observable<NewsDetailBean> getTopicById(@Path("id") String id);
}
