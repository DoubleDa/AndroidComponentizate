package com.dyx.aca.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Author：dayongxin
 * Function：
 */
public class CustomTitleBar extends RelativeLayout {
    private ImageView ivLeft;
    private TextView tvTitlle;
    private ImageView ivRight;
    private RelativeLayout rlRoot;
    private String mTitleBarText;
    private int mTitleBarTextColor;
    private int mTitleBarBgColor;

    public CustomTitleBar(Context context) {
        super(context);
        initView(context);
    }

    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        /**
         * 使用attrs.xml定义属性，在这个构造方法进行TypedArray获取
         */
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyCustomTitleBar);
        mTitleBarText = array.getString(R.styleable.MyCustomTitleBar_title_bar_text);
        mTitleBarTextColor = array.getColor(R.styleable.MyCustomTitleBar_title_bar_text_color, Color.WHITE);
        mTitleBarBgColor = array.getColor(R.styleable.MyCustomTitleBar_title_bar_text_bg, Color.BLUE);
        if (array != null) {
            array.recycle();
        }
        initView(context);
    }

    public CustomTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 使用styles.xml定义属性，在这个构造方法进行TypedArray获取
         */
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.lib_view_view_title_bar_layout, this, true);
        rlRoot = (RelativeLayout) view.findViewById(R.id.rl_root);
        ivLeft = (ImageView) view.findViewById(R.id.iv_left);
        tvTitlle = (TextView) view.findViewById(R.id.tv_titlle);
        ivRight = (ImageView) view.findViewById(R.id.iv_right);
        /**
         * 设置背景
         */
        rlRoot.setBackgroundColor(mTitleBarBgColor);
        /**
         * 设置文字颜色
         */
        tvTitlle.setTextColor(mTitleBarTextColor);
        /**
         * 设置title
         */
        if (tvTitlle != null && !TextUtils.isEmpty(mTitleBarText)) {
            tvTitlle.setText(mTitleBarText);
        }
    }

    public void setLeftClickListener(OnClickListener listener) {
        ivLeft.setOnClickListener(listener);
    }

    public void setRightClickListener(OnClickListener listener) {
        ivRight.setOnClickListener(listener);
    }

    public void setTitle(String title) {
        tvTitlle.setText(title);
    }
}
