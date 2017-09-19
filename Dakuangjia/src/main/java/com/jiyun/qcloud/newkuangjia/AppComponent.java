package com.jiyun.qcloud.newkuangjia;

import com.jiyun.qcloud.newkuangjia.api.ApiModule;
import com.jiyun.qcloud.newkuangjia.api.NetworkModule;
import com.jiyun.qcloud.newkuangjia.ui.activitys.BaseActivity;
import com.jiyun.qcloud.newkuangjia.ui.fragments.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by chj on 017/8/30.
 */

@Singleton
@Component(modules = {NetworkModule.class, ApiModule.class, AppModule.class})
public interface AppComponent {
    void inject(MainApp app);

    void inject(BaseActivity baseActivity);

    void inject(BaseFragment baseFragment);
}
