package com.example.degger2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by KING on 2017/9/15 17:09
 * 邮箱:992767879@qq.com
 */

@Module   //提供依赖对象的实例
public class MainModule {

  @Provides // 关键字，标明该方法提供依赖对象
  Person providerPerson(){
    //提供Person对象
    return new Person();
  }


}
