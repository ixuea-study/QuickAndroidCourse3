package com.ixuea.courses.helloixuea.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ixuea.courses.helloixuea.R;

public class IxueaActivity extends AppCompatActivity {
    // 一定要注意：
    // 要用onCreate的方法参数是Bundle的这个方法
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //将activity_ixuea布局设置当前Activity的界面
        //很明显，也设置为其他布局文件
        setContentView(R.layout.activity_ixuea);
    }
}
