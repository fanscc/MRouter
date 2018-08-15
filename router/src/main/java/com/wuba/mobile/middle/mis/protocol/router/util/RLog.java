package com.wuba.mobile.middle.mis.protocol.router.util;

import android.util.Log;

/**
 * Internal simple log.
 * <p>
 * Created by wangqiang on 2018/8/11.
 */
public class RLog {

    private static final String TAG = "Router";
    private static boolean sLoggable = false;

    public static void showLog(boolean loggable) {
        sLoggable = loggable;
    }

    public static void i(String msg) {
        if (sLoggable && msg != null) {
            Log.i(TAG, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (sLoggable && msg != null) {
            Log.i(tag, msg);
        }
    }

    public static void w(String msg) {
        if (sLoggable && msg != null) {
            Log.w(TAG, msg);
        }
    }

    public static void e(String msg) {
        if (msg != null)
            Log.e(TAG, msg);
    }

    public static void e(String msg, Throwable tr) {
        Log.e(TAG, msg, tr);
    }
}
