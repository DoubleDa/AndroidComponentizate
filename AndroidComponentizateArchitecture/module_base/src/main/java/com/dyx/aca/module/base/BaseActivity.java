package com.dyx.aca.module.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Author：dayongxin
 * Function：
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
