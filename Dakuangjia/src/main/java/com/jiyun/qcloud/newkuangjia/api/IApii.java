package com.jiyun.qcloud.newkuangjia.api;

import com.jiyun.qcloud.newkuangjia.mvp.model.Dieerlei;
import com.jiyun.qcloud.newkuangjia.mvp.model.Info;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by KING on 2017/9/7 08:02
 * 邮箱:992767879@qq.com
 */

public interface IApii {
    @GET("kehuduan/PAGE14501767715521482/index.json")
    Observable<Dieerlei> getDierci();
}
