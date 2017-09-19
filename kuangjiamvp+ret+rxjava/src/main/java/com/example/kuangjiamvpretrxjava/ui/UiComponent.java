package com.example.kuangjiamvpretrxjava.ui;

import com.example.kuangjiamvpretrxjava.prestener.Kongzhiqi;

import dagger.Component;

/**
 * Created by KING on 2017/9/16 14:45
 * 邮箱:992767879@qq.com
 */
@Component(modules =Kongzhiqi.class )
public interface UiComponent {
    void inject(MainActivity activity);
}
