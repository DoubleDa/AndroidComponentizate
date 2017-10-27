package com.dyx.aca.co.settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dyx.aca.lib.utils.ToastUtils;
import com.dyx.aca.lib.view.CustomTitleBar;
import com.dyx.aca.module.base.BaseFragment;

/**
 * Author：dayongxin
 * Function：
 */
public class SettingsFragment extends BaseFragment {
    private CustomTitleBar mCustomTitleBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.co_settings_fragment_settings, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mCustomTitleBar = view.findViewById(R.id.custom_title_bar);
        if (mCustomTitleBar != null) {
            mCustomTitleBar.setLeftClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().onBackPressed();
                }
            });
            mCustomTitleBar.setRightClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtils.showShort(getActivity(), getString(R.string.co_settings_str_share_not_finish));
                }
            });
            mCustomTitleBar.setTitle(getString(R.string.co_settings_settings_title));
        }
    }
}
