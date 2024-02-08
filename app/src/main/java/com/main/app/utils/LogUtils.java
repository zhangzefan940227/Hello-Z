package com.main.app.utils;

import android.util.Log;

public class LogUtils {

    public static String tagPrefix = "Hello_Z_";
    public static boolean isDebug = true;

    public static void v(String tag, String msg) {
        if (isDebug) {
            Log.v(tagPrefix + tag, msg);
        }

    }

    public static void v(String tag, String msg, Throwable tr) {
        if (isDebug) {
            Log.v(tagPrefix + tag, msg, tr);

        }

    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tagPrefix + tag, msg);

        }

    }

    public static void d(String tag, String msg, Throwable tr) {
        if (isDebug) {
            Log.d(tagPrefix + tag, msg, tr);

        }

    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tagPrefix + tag, msg);

        }

    }

    public static void i(String tag, String msg, Throwable tr) {
        if (isDebug) {
            Log.i(tagPrefix + tag, msg, tr);

        }

    }

    public static void w(String tag, String msg) {
        if (isDebug) {
            Log.w(tagPrefix + tag, msg);

        }

    }

    public static void w(String tag, String msg, Throwable tr) {
        if (isDebug) {
            Log.w(tagPrefix + tag, msg, tr);

        }

    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tagPrefix + tag, msg);

        }

    }

    public static void e(String tag, String msg, Throwable tr) {
        if (isDebug) {
            Log.e(tagPrefix + tag, msg, tr);
        }

    }
}
