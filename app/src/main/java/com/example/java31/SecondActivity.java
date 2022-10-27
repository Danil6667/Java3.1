package com.example.java31;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView  tvTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvTxt = findViewById(R.id.tv_txt);
        getBundle();
    }

    private void getBundle() {
        @Nullable Bundle argument = getIntent().getExtras();
        if (argument != null){
            String text = argument.getString("text");
            tvTxt.setText(text);
        }
    }
}