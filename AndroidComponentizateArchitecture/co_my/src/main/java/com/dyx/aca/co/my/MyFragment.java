package com.dyx.aca.co.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyx.aca.module.base.BaseFragment;
import com.dyx.aca.module.constants.ClassConstants;

/**
 * Author：dayongxin
 * Function：
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {
    private TextView tvAboutMe;
    private TextView tvAll;
    private TextView tvAsk;
    private TextView tvShare;
    private TextView tvJob;
    private TextView tvGood;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.co_my_fragment_my, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tvAll = view.findViewById(R.id.tv_all);
        tvAsk = view.findViewById(R.id.tv_ask);
        tvShare = view.findViewById(R.id.tv_share);
        tvJob = view.findViewById(R.id.tv_job);
        tvGood = view.findViewById(R.id.tv_good);
        tvAboutMe = view.findViewById(R.id.tv_about_me);
        tvAll.setOnClickListener(this);
        tvAsk.setOnClickListener(this);
        tvShare.setOnClickListener(this);
        tvJob.setOnClickListener(this);
        tvGood.setOnClickListener(this);
        tvAboutMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_all) {
            intentToForName(getActivity(), ClassConstants.CLASS_ORDER_ACTIVITY, ClassConstants.BUNDLE_TAB, ClassConstants.BUNDLE_ALL);
        } else if (id == R.id.tv_ask) {
            intentToForName(getActivity(), ClassConstants.CLASS_ORDER_ACTIVITY, ClassConstants.BUNDLE_TAB, ClassConstants.BUNDLE_ASK);
        } else if (id == R.id.tv_share) {
            intentToForName(getActivity(), ClassConstants.CLASS_ORDER_ACTIVITY, ClassConstants.BUNDLE_TAB, ClassConstants.BUNDLE_SHARE);
        } else if (id == R.id.tv_job) {
            intentToForName(getActivity(), ClassConstants.CLASS_ORDER_ACTIVITY, ClassConstants.BUNDLE_TAB, ClassConstants.BUNDLE_JOB);
        } else if (id == R.id.tv_good) {
            intentToForName(getActivity(), ClassConstants.CLASS_ORDER_ACTIVITY, ClassConstants.BUNDLE_TAB, ClassConstants.BUNDLE_GOOD);
        } else if (id == R.id.tv_about_me) {
            intentTo(AboutMeActivity.class);
        }
    }


}
