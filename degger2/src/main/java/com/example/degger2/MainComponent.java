package com.example.degger2;

import dagger.Component;

/**
 * Created by KING on 2017/9/15 17:09
 * 邮箱:992767879@qq.com
 */
@Component(modules = MainModule.class)  // 作为桥梁，沟通调用者和依赖对象库
public interface MainComponent {

    //定义注入的方法
    void inject(MainActivity activity);

}