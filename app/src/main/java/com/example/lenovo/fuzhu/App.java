package com.example.lenovo.fuzhu;

import android.app.Application;

import com.orhanobut.logger.AndroidLogTool;
import com.orhanobut.logger.Logger;

/**
 * Created by KING on 2017/9/11 11:46
 * 邮箱:992767879@qq.com
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger
                .init("JIYUN")                 // default PRETTYLOGGER or use just init()
                .methodCount(3)                 // default 2
                //.hideThreadInfo()               // default shown
                // .logLevel(LogLevel.NONE)        // default LogLevel.FULL
                // .methodOffset(2)
                // default 0

                .logTool(new AndroidLogTool()); // custom log tool, option


        Logger.d("chj修改了这里");
    }
}
