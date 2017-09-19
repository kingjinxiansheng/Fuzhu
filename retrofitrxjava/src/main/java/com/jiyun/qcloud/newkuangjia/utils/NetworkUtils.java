package com.jiyun.qcloud.newkuangjia.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * Created by chj on 2017/8/30.
 *
 * 这里面的代码基本不用理会,属于一个工具类,判断当前网络是否连接,然后在判断当前网络状态是2g 3g  或者cdma  wifi
 */

public class NetworkUtils {
    public static String type="";

    //获取当前的网络类型
    public static String getCurrentNetTuype(Context context){
        //获取网络连接管理器
        ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //获取网络连接的详细信息
        NetworkInfo info=cm.getActiveNetworkInfo();

        if (info == null) {
            type="null";
        }else if (info.getType()==ConnectivityManager.TYPE_WIFI){
            type="wifi";
        }else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
            int subType=info.getSubtype();
            if (subType == TelephonyManager.NETWORK_TYPE_CDMA
                    || subType == TelephonyManager.NETWORK_TYPE_GPRS
                    || subType == TelephonyManager.NETWORK_TYPE_EDGE) {
                type="2g";

            }else if (subType == TelephonyManager.NETWORK_TYPE_UMTS
                    || subType == TelephonyManager.NETWORK_TYPE_HSDPA
                    || subType == TelephonyManager.NETWORK_TYPE_EVDO_A
                    || subType == TelephonyManager.NETWORK_TYPE_EVDO_0
                    || subType == TelephonyManager.NETWORK_TYPE_EVDO_B) {
                type="3g";

            }else if (subType == TelephonyManager.NETWORK_TYPE_LTE){//LTE是3g到4G的过度,是3.9G的全球标准
                type="4g";
            }

        }
        return type;

    }
    public static boolean networkIsAvailable(Context context){
        if (getCurrentNetTuype(context).equals(null)) {
            return false;
        }else{
            return true;
        }
    }
}
