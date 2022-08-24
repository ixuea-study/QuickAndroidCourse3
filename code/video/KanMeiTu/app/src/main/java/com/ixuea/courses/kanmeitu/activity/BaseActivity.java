package com.ixuea.courses.kanmeitu.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ixuea.courses.kanmeitu.util.PreferencesUtil;

/**
 * 通用activity
 */
public class BaseActivity extends AppCompatActivity {
    /**
     * 访问修饰符改为protected
     */
    protected PreferencesUtil sp;

    /**
     * 重写了setContentView方法
     * 因为在子类调用了setContentView设置布局
     *
     * @param layoutResID
     */
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        //偏好设置工具类
        sp = PreferencesUtil.getInstance(this);

        //其他的公共逻辑也可以这样重构
        //详细的大家可以学习我们的《Android开发项目实战之我的云音乐》课程
        //http://www.ixuea.com/courses/22

    }
}
