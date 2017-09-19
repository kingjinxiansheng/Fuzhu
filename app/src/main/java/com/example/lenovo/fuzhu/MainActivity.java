package com.example.lenovo.fuzhu;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity implements AAAA.LOa {

    private Button tuchu;
    private AAAA aaaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aaaa = new AAAA(this);
        aaaa.s();
    }

    @Override
    public void aa() {
        Logger.e("你好世界");
    }
}
