package com.example.kuangjiamvpretrxjava.model;

import com.example.kuangjiamvpretrxjava.Bean.ShiLei;

import retrofit2.http.GET;
import rx.Observable;


/**
 * Created by KING on 2017/9/14 14:17
 * 邮箱:992767879@qq.com
 *
 * http://www.ipanda.com/kehuduan/PAGE14501749764071042/index.json
 */

public interface SeviserRec  {
    @GET("kehuduan/PAGE14501749764071042/index.json")
    Observable<ShiLei> getqingqiu();
}
