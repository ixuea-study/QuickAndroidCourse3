package com.ixuea.courses.kanmeitu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ixuea.courses.kanmeitu.activity.BaseActivity;
import com.ixuea.courses.kanmeitu.activity.LoginActivity;
import com.ixuea.courses.kanmeitu.util.PreferencesUtil;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //退出登录
        findViewById(R.id.primary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //清除登录标记
                sp.setLogin(false);

                //退出后，跳转到登录界面
                //当然大家可以根据业务逻辑调整
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

                //关闭
                finish();
            }
        });
    }
}