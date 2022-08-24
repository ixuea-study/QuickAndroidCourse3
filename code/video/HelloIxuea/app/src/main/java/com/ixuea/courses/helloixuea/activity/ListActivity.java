package com.ixuea.courses.helloixuea.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ixuea.courses.helloixuea.R;
import com.ixuea.courses.helloixuea.adapter.ListAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //详细的使用我们在这门课程中也讲解了：http://www.ixuea.com/courses/8
        RecyclerView rv = findViewById(R.id.rv);

        //如果你知道你的RecyclerView的高度在使用期间不会变化
        // 使用此设置可以提高性能，后面会相应的文章分析为什么
        rv.setHasFixedSize(true);

        //设置一个布局管理器，所谓布局管理器就是告诉他如何显示布局，是横向还是纵向，还是其他方式
        //这里使用的是LinearLayoutManager，默认是垂直方向
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        //创建一个ArrayList
        //添加一些测试数据
        //如果是真实项目，这个部分数据可能来自网络，数据库等
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            strings.add("数据:" + i);
        }


        //设置一个适配器，简单来讲，就是通过适配器可以告诉RecyclerView显示什么数据
        //有多少个，每一个数据显示样式
        ListAdapter adapter = new ListAdapter(this, strings);
        rv.setAdapter(adapter);
    }
}