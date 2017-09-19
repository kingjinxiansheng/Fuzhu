package com.example.kuangjiamvpretrxjava.prestener;

import android.widget.Toast;

import com.example.kuangjiamvpretrxjava.Bean.ShiLei;
import com.example.kuangjiamvpretrxjava.ui.MainActivity;
import com.example.kuangjiamvpretrxjava.view.ViewI;

import dagger.Module;
import dagger.Provides;

/**
 * Created by KING on 2017/9/14 14:50
 * 邮箱:992767879@qq.com
 */
@Module
public class Kongzhiqi {
    private ViewI viewI;
    public Kongzhiqi(ViewI viewI){
        this.viewI=viewI;
    }

    @Provides
    public ViewI providerPerson(){

        return viewI;
    }
}
