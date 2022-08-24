package com.ixuea.courses.kanmeitu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.ixuea.courses.kanmeitu.MainActivity;
import com.ixuea.courses.kanmeitu.R;
import com.ixuea.courses.kanmeitu.util.PreferencesUtil;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

/**
 * 启动界面
 */
public class SplashActivity extends AppCompatActivity {

    private PreferencesUtil sp;

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

        sp = PreferencesUtil.getInstance(this);
    }

    private void next() {
        finish();

        Intent intent;
        if (sp.isLogin()) {
            intent = new Intent(this, MainActivity.class);
        }else{
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
    }
}