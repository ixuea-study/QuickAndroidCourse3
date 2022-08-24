package com.ixuea.courses.kanmeitu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ixuea.courses.kanmeitu.activity.BaseActivity;
import com.ixuea.courses.kanmeitu.activity.LoginActivity;
import com.ixuea.courses.kanmeitu.adapter.ImageAdapter;
import com.ixuea.courses.kanmeitu.util.PreferencesUtil;

import java.util.ArrayList;

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

        //初始化RecyclerView
        RecyclerView listView=findViewById(R.id.list);
        listView.setHasFixedSize(true);

        //显示2列，我们这里实现的是每个图片的宽高都是一样
        //最好的效果其实是根据图片高度和宽度来缩放
        //因为每一张图片大小不一样
        //但这样实现涉及到的知识点很多

        //这里使用了GridLayoutManager
        //他会显示类似9宫格布局效果

        //详细的可以学习这门课程
        //http://www.ixuea.com/courses/8
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        listView.setLayoutManager(layoutManager);

        //添加测试数据
        ArrayList<String> datum = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            //图片来自http://image.baidu.com
            datum.add(String.format("https://dev-courses-quick.oss-cn-beijing.aliyuncs.com/%d.jpg", i));
        }

        ImageAdapter adapter = new ImageAdapter(this, datum);
        listView.setAdapter(adapter);
    }
}