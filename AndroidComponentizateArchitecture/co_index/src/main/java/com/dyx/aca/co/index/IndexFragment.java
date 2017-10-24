package com.dyx.aca.co.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dyx.aca.co.index.adapter.IndexAdapter;
import com.dyx.aca.lib.net.ApiConstants;
import com.dyx.aca.lib.net.ApiService;
import com.dyx.aca.lib.net.FieldConstants;
import com.dyx.aca.lib.net.model.index.IndexBean;
import com.dyx.aca.module.base.BaseFragment;
import com.dyx.aca.module.constants.ClassConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class IndexFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private IndexAdapter mIndexAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.co_index_fragment_index, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<IndexBean> call = apiService.getTopics(getTopicsReqData());
        call.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<IndexBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(IndexBean indexBean) {
                if (indexBean != null) {
                    if (indexBean.isSuccess()) {
                        initRv(indexBean.getData());
                    }
                }
            }
        });
    }

    private void initRv(List<IndexBean.DataEntity> data) {
        mIndexAdapter = new IndexAdapter(getActivity(), data);
        recyclerView.setAdapter(mIndexAdapter);
        if (mIndexAdapter != null) {
            mIndexAdapter.setOnItemClickListener(listener);
        }
    }

    IndexAdapter.OnItemClickListener listener = new IndexAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(String id) {
            intentToForName(getActivity(), ClassConstants.CLASS_NEWS_DETAIL_ACTIVITY, ClassConstants.BUNDLE_ID, id);
        }
    };

    private Map<String, String> getTopicsReqData() {
        Map<String, String> map = new HashMap<>();
        map.put(FieldConstants.FIELD_TAB, FieldConstants.FIELD_JOB);
        return map;
    }

}
