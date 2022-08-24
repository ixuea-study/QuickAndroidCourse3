package com.ixuea.courses.kanmeitu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ixuea.courses.kanmeitu.R;
import com.ixuea.courses.kanmeitu.util.Constant;
import com.ixuea.courses.kanmeitu.util.ImageUtil;

public class ImageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        ImageView imageView = findViewById(R.id.image);

        //获取传递的参数
        String uri = getIntent().getStringExtra(Constant.ID);

        ImageUtil.show(imageView, uri);

    }
}