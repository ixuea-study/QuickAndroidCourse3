package com.ixuea.courses.kanmeitu.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.ixuea.courses.kanmeitu.R;

/**
 * 图片工具类
 */
public class ImageUtil {
    /**
     * 显示网络图片
     * @param view
     * @param data
     */
    public static void show(ImageView view, String data) {
        RequestOptions options=getCommonRequestOptions();
        Glide.with(view.getContext()).load(data).apply(options).into(view);
    }

    /**
     * 获取通用配置
     *
     * @return
     */
    private static RequestOptions getCommonRequestOptions() {
        RequestOptions options = new RequestOptions();

        //加载前占位图
        options.placeholder(R.drawable.placeholder);

        //加载错误图片
        options.error(R.drawable.placeholder_error);

        //测试，禁用所有缓存
//        options.diskCacheStrategy(DiskCacheStrategy.NONE);

        return options;
    }
}
