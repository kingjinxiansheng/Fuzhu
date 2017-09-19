package com.example.degger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject   //标明需要注入的对象
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 构造桥梁对象
        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        //注入
        component.inject(this);

    }
}
