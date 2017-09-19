package com.jiyun.qcloud.newkuangjia;

import android.app.Application;
import android.content.Context;

import com.jiyun.qcloud.newkuangjia.api.ApiModule;
import com.jiyun.qcloud.newkuangjia.api.NetworkModule;

/**
 * Created by chj on 2017/8/30.
 */

public class MainApp extends Application {
    private Context mContext;
    private Context applicationContext;

    public AppComponent getmAppComponent(){
        return mAppComponent;
    }
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
        
        initializeInjector();
    }

    private void initializeInjector() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, mContext))
                .networkModule(new NetworkModule())
                .apiModule(new ApiModule())
                .build();
        mAppComponent.inject(this);
    }
}
