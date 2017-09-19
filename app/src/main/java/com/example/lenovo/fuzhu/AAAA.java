package com.example.lenovo.fuzhu;

import android.util.Log;

/**
 * Created by KING on 2017/9/9 11:02
 * 邮箱:992767879@qq.com
 */

public class AAAA {
    private LOa lOa;
    public AAAA(LOa aa) {
        lOa=aa;
        Log.e("AAAA","aaaa");
    }
    public void s(){
        lOa.aa();
    }
    public interface LOa{
        void  aa();
    }
}
