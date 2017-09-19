package com.jiyun.qcloud.newkuangjia.api;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by chj on 2017/8/30.
 * 使用自定义拦截器设置请求头
 */

public class MashapeKeyInterceptor implements Interceptor{

    private Request.Builder builder;

    @Inject
    public MashapeKeyInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request=chain.request();
        Request.Builder builder=request.newBuilder();
        Request newRequest=builder.addHeader("X-Mashape-key","U4y8yvgRDUmshqUkNb1LJxmsRCBap1WWG0wjsnUj07GxYfsKUI")
                .addHeader("Accept","application/json")
                .build();
        return chain.proceed(newRequest);
    }
}
