package com.dyx.aca.module.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author：dayongxin
 * Function：
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void intentToForName(Context context, String name) {
        try {
            Class cla = Class.forName(name);
            Intent intent = new Intent(context, cla);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void intentToForName(Context context, String name, String key, String value) {
        try {
            Class cla = Class.forName(name);
            Intent intent = new Intent(context, cla);
            Bundle bundle = new Bundle();
            bundle.putString(key, value);
            intent.putExtras(bundle);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void intentTo(Class<?> cla) {
        startActivity(new Intent(getActivity(), cla));
    }
}
