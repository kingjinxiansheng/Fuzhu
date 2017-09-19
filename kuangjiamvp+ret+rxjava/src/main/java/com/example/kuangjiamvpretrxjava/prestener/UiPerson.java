package com.example.kuangjiamvpretrxjava.prestener;

import android.content.Context;
import android.util.Log;

import com.example.kuangjiamvpretrxjava.Bean.ShiLei;
import com.example.kuangjiamvpretrxjava.model.Modelchuandi;
import com.example.kuangjiamvpretrxjava.model.ShilihuaLei;
import com.example.kuangjiamvpretrxjava.view.ViewI;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by KING on 2017/9/16 14:44
 * 邮箱:992767879@qq.com
 */

public class UiPerson implements Modelchuandi {
    private ShilihuaLei shilihuaLei;
    private ViewI viewI;
    @Inject
    public UiPerson(ViewI viewI){
            shilihuaLei=new ShilihuaLei(this);
            this.viewI=viewI;
    }
    public void ss(Context context){
        shilihuaLei.qingqiu(context);
        Log.e("444444","22222222");
    }
    @Override
    public void duixiang(ShiLei shiLei) {
        viewI.aaa(shiLei);
    }
}
