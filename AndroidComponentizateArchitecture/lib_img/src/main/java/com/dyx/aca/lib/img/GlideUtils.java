package com.dyx.aca.lib.img;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Author：dayongxin
 * Function：
 */
public class GlideUtils {
    public static void displayImgDefault(Context mContext, String url, ImageView imageView) {
        Glide.with(mContext).load(url).into(imageView);
    }
}
