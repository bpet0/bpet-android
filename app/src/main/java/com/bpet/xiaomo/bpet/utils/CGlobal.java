package com.bpet.xiaomo.bpet.utils;

/**
 * Created by Stefan on 17/12/8.
 */

public class CGlobal {

    /*
        是生产还是调试，为日志输出统一管理功能
     */
    public static boolean is_debug = Status.DEBUG.status;

    enum Status{
        PRODUCT(false),
        DEBUG(true);

    private boolean status;

        private Status(boolean status){
            this.status = status;
        }
    }
}
