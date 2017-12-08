package com.bpet.xiaomo.bpet.utils;

import android.util.Log;

/**
 * Created by Stefan on 17/12/8.
 */

public class MyLog {

    public static void i(String msg){
        if (CGlobal.is_debug){
            Log.i("-xiaomo-",msg);
        }
    }

    public static void e(String msg,Throwable throwable){
            Log.e("-xiaomo-",msg,throwable);
    }

    public static void e(Throwable throwable){
            Log.e("-xiaomo-","no-message",throwable);
    }

    public static void e(String msg){
            Log.e("-xiaomo-",msg);
    }
}
