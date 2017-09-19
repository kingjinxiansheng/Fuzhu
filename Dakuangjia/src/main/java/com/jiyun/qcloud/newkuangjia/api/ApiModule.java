package com.jiyun.qcloud.newkuangjia.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jiyun.qcloud.newkuangjia.mvp.model.Card;
import com.jiyun.qcloud.newkuangjia.mvp.model.Ceshi;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chj on 2017/8/30.
 */
@Module
public class ApiModule {
    public static final String BASE_URL="http://api.cntv.cn/";
    public static final String BASE_URL1="http://www.ipanda.com/";
    @Provides
    //单利注解
    @Singleton
    public IApi getCardsApi(OkHttpClient client){

        Retrofit CardsApiAdapter=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return CardsApiAdapter.create(IApi.class);

    }
    @Provides
    //单利注解
    @Singleton
    public IApii getCardsApi1(OkHttpClient client){
        Retrofit CardsApiAdapter=new Retrofit.Builder()
                .baseUrl(BASE_URL1)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return CardsApiAdapter.create(IApii.class);

    }
}
