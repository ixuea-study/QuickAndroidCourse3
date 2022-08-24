package com.ixuea.courses.kanmeitu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ixuea.courses.kanmeitu.MainActivity;
import com.ixuea.courses.kanmeitu.R;
import com.ixuea.courses.kanmeitu.util.Constant;
import com.ixuea.courses.kanmeitu.util.PreferencesUtil;
import com.ixuea.courses.kanmeitu.util.RegularUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usernameView;
    private EditText passwordView;
    private Button primaryView;
    private PreferencesUtil sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //找控件
        usernameView = findViewById(R.id.username);
        passwordView = findViewById(R.id.password);
        primaryView = findViewById(R.id.primary);

        primaryView.setOnClickListener(this);

        sp = PreferencesUtil.getInstance(this);
    }

    @Override
    public void onClick(View v) {
        //获取用户名
        String username = usernameView.getText().toString().trim();

        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, R.string.hint_enter_username, Toast.LENGTH_SHORT).show();
            return;
        }

        //判断是否是手机号
        if (!RegularUtil.isPhone(username)) {
            Toast.makeText(this, R.string.error_phone_format, Toast.LENGTH_SHORT).show();
            return;
        }


        //获取输入的密码
        String password = passwordView.getText().toString().trim();

        //判断密码长度
        if (password.length() < 6 || password.length() > 15) {
            Toast.makeText(this, R.string.error_password_format, Toast.LENGTH_SHORT).show();
            return;
        }

        //TODO 在这里就调用调用服务端的登录接口
        //我们这里就简单实现，将密码和用户名都写到本地了

        if (Constant.PHONE.equals(username) && Constant.PASSWORD.equals(password)) {
            //登录完成后保存一个标记，下次就不用在登录了
            sp.setLogin(true);

            //登录成功
            finish();

            //进入首页
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else {
            //登录失败，进行提示
            //用户提示友好了对攻击你的人来说，就更方便了，所以这里大家做一个权衡
            Toast.makeText(this, R.string.error_username_or_password, Toast.LENGTH_SHORT).show();
        }
    }
}