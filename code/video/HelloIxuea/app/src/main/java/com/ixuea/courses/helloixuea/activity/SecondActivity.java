package com.ixuea.courses.helloixuea.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ixuea.courses.helloixuea.R;

/**
 * 第二个界面
 */
public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView close_button = findViewById(R.id.close_button);
        close_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}