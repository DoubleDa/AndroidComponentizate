package com.dyx.aca.co.order;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dyx.aca.co.order.adapter.OrderAdapter;
import com.dyx.aca.lib.net.ApiConstants;
import com.dyx.aca.lib.net.ApiService;
import com.dyx.aca.lib.net.FieldConstants;
import com.dyx.aca.lib.net.model.index.IndexBean;
import com.dyx.aca.lib.utils.ToastUtils;
import com.dyx.aca.lib.view.CustomTitleBar;
import com.dyx.aca.lib.view.DividerItemDecoration;
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
public class OrderFragment extends BaseFragment {
    private CustomTitleBar customTitleBar;
    private RecyclerView recyclerView;
    private String tabIntent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.co_order_fragment_order, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        customTitleBar = view.findViewById(R.id.custom_title_bar);
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
                    ToastUtils.showShort(getActivity(), getString(R.string.co_order_str_share_not_finish));
                }
            });
            customTitleBar.setTitle(getTitleByTab(tabIntent));
        }
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

    private String getTitleByTab(String tabIntent) {
        if (tabIntent.equalsIgnoreCase("job")) {
            return getString(R.string.co_order_job);
        } else if (tabIntent.equalsIgnoreCase("ask")) {
            return getString(R.string.co_order_ask);
        } else if (tabIntent.equalsIgnoreCase("share")) {
            return getString(R.string.co_order_share);
        } else if (tabIntent.equalsIgnoreCase("good")) {
            return getString(R.string.co_order_good);
        } else if (tabIntent.equalsIgnoreCase("all")) {
            return getString(R.string.co_order_all);
        }
        return "";
    }

    private void initRv(List<IndexBean.DataEntity> data) {
        OrderAdapter orderAdapter = new OrderAdapter(getActivity(), data);
        recyclerView.setAdapter(orderAdapter);
        if (orderAdapter != null) {
            orderAdapter.setOnItemClickListener(listener);
        }
    }

    OrderAdapter.OnItemClickListener listener = new OrderAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(String id) {
            intentToForName(getActivity(), ClassConstants.CLASS_NEWS_DETAIL_ACTIVITY, ClassConstants.BUNDLE_ID, id);
        }
    };

    private Map<String, String> getTopicsReqData() {
        Map<String, String> map = new HashMap<>();
        map.put(FieldConstants.FIELD_TAB, tabIntent);
        return map;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        tabIntent = ((OrderActivity) context).getTabName();
    }
}
