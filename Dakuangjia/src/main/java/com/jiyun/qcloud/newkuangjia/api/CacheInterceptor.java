package com.jiyun.qcloud.newkuangjia.api;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by chj on 2017/8/30.
 */

public class CacheInterceptor implements Interceptor {
    @Inject
    public CacheInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request=chain.request();
        Response response=chain.proceed(request);
        //不管服务器返回是否支持缓存,在这里都设置缓存
        Response response1 = response.newBuilder().removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .header("Cache-Control", "max-age=" + 3600 * 24 * 30)
                .build();


        return response1;
    }
}
