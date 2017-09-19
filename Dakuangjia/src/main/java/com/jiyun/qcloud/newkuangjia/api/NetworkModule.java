package com.jiyun.qcloud.newkuangjia.api;

import com.jiyun.qcloud.newkuangjia.BuildConfig;

import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnull;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by chj on 2017/8/30.
 */
@Module
public class NetworkModule {
    @Provides
    @Nonnull
    @Singleton
    public OkHttpClient provideOkHttpClient(Cache cache,MashapeKeyInterceptor mashapeKeyInterceptor){
        OkHttpClient okHttpClient=new OkHttpClient();

        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG? HttpLoggingInterceptor.Level.BODY: HttpLoggingInterceptor.Level.NONE);

        OkHttpClient newClient=okHttpClient.newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(mashapeKeyInterceptor)
                .addNetworkInterceptor(new CacheInterceptor())
                .cache(cache)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        return newClient;
    }
}
