package com.ixuea.courses.kanmeitu.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 偏好工具类
 */
public class PreferencesUtil {
    private static final String KEY_LOGIN = "LOGIN";

    private static PreferencesUtil instance;
    private final Context context;
    private final SharedPreferences preferences;

    private PreferencesUtil(Context context) {
        this.context = context;

        preferences = context.getSharedPreferences("ixuea", Context.MODE_PRIVATE);
    }

    /**
     * 获取偏好设置工具类（单例设计模式）
     *
     * @param context
     * @return
     */
    public synchronized static PreferencesUtil getInstance(Context context) {
        if (instance == null) {
            instance = new PreferencesUtil(context.getApplicationContext());
        }
        return instance;
    }

    /**
     * 设置是否登录
     *
     * @param data
     */
    public void setLogin(Boolean data) {
        preferences.edit().putBoolean(KEY_LOGIN, data).commit();
    }

    /**
     * 是否登录
     *
     * @return
     */
    public boolean isLogin() {
        return preferences.getBoolean(KEY_LOGIN, false);
    }
}
