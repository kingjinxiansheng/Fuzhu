package com.jiyun.qcloud.newkuangjia;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.qcloud.newkuangjia.entity.WeatherEntity;
import com.jiyun.qcloud.newkuangjia.model.HttpUtils;
import com.jiyun.qcloud.newkuangjia.utils.NetworkUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_only_weather;
    private Button btn_weather;
    private TextView tv_weather;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        tv_only_weather = (TextView) findViewById(R.id.tv_only_weather);
        btn_weather = (Button) findViewById(R.id.btn_weather);
        tv_weather = (TextView) findViewById(R.id.tv_weather);

        mDialog = new ProgressDialog(this);
        btn_weather.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           case R.id.btn_weather:


                if (!NetworkUtils.networkIsAvailable(MainActivity.this)) {
                    Toast.makeText(this, "请先开启网络", Toast.LENGTH_SHORT).show();
                    return;
                }


                /**
                 * 创建了 Observable 和 Observer 之后，再用 subscribe() 方法将它们联结起来，整条链子就可以工作了。代码形式很简单：

                 observable.subscribe(observer);
                 // 或者：
                 observable.subscribe(subscriber);
                 */
            //    HttpUtils.createWeatherService(MainActivity.this).getRxMessage("北京").
                HttpUtils.createWeatherService(MainActivity.this).getRxMessage("北京")//在这里返回一个obserable就是被观察者
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Action0() {      //订阅前做的处理
                            @Override
                            public void call() {
                                mDialog.show();//发送网络请求前在主线程要做的事情,比方说在主线程要展示个dialog显示进度条等
                            }
                        }).subscribeOn(AndroidSchedulers.mainThread())//前面的所有代码都是用来创建一个被观察者对象Observable
                        .subscribe(new Subscriber<WeatherEntity>() {
                            @Override
                            public void onCompleted() {
                                mDialog.dismiss();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(MainActivity.this, "请求错误", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNext(WeatherEntity weatherEntity) {

                                System.out.println("========"+weatherEntity.toString());
                            }
                        });


                break;
        }
    }

    class A extends AsyncTask{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            return null;
        }
    }
}
