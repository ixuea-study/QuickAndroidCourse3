package com.ixuea.courses.kanmeitu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.ixuea.courses.kanmeitu.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

/**
 * 启动界面
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        QMUIStatusBarHelper.translucent(this);

        //设置状态栏文本颜色为黑色
        QMUIStatusBarHelper.setStatusBarLightMode(this);

        findViewById(R.id.copyright).postDelayed(new Runnable() {
            @Override
            public void run() {
                next();
            }
        }, 3000);
    }

    private void next() {
        finish();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}