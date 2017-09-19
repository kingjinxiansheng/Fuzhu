package com.example.kuangjiamvpretrxjava.model;

import android.content.Context;
import android.util.Log;

import com.example.kuangjiamvpretrxjava.Bean.ShiLei;
import com.example.kuangjiamvpretrxjava.model.http.HttpUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by KING on 2017/9/14 14:25
 * 邮箱:992767879@qq.com
 *
 */
public class ShilihuaLei {
    private Modelchuandi modelchuandi;
    public ShilihuaLei(Modelchuandi modelchuandi){
        this.modelchuandi=modelchuandi;
    }
    public void qingqiu(Context context){
        HttpUtils.createWeatherService(context).getqingqiu()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0(){
                    @Override
                    public void call() {
                        Log.e("222","333");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ShiLei>() {
                    @Override
                    public void onCompleted() {
                        Log.e("111111","555555555555");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("111111","6666666");
                    }

                    @Override
                    public void onNext(ShiLei shiLei) {
                        modelchuandi.duixiang(shiLei);
                        Log.e("111111",shiLei.toString());
                        Log.e("TAG",shiLei.toString());
                    }
                });
    }
}
