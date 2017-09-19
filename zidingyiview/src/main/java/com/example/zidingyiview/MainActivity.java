package com.example.zidingyiview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ViewZdingyi aaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        int i = 1 + 2 * 10;
//        Log.e("TAG",i+"");
    }

    private void initView() {
        aaa = (ViewZdingyi) findViewById(R.id.aaa);
        int a[]={160,2260,10,2282,189};
        aaa.upData(a);
    }
}
