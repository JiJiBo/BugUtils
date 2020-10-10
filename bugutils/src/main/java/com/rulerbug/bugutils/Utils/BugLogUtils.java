package com.rulerbug.bugutils.Utils;

import android.util.Log;

import com.google.gson.Gson;

import java.io.File;

public class BugLogUtils {
    public static final int v = 10;
    public static final int d = 11;
    public static final int i = 12;
    public static final int w = 13;
    public static final int e = 14;
    public static final int NULL = 20;
    public static String flagPath;

    public static int level = v;

    public static void v(String msg) {
        if (level <= v||isHaveFlag()) {
            Log.e("一条v级message", msg);
        }
    }

    public static void v(Object msg) {
        v(new Gson().toJson(msg));
    }

    public static void setLevel(int level) {
        BugLogUtils.level = level;
    }

    public static void d(String msg) {
        if (level <= d||isHaveFlag()) {
            Log.e("一条d级message", msg);
        }
    }

    public static void d(Object msg) {
        d(new Gson().toJson(msg));
    }

    public static void i(String msg) {
        if (level <= i||isHaveFlag()) {
            Log.e("一条i级message", msg);
        }
    }

    public static void i(Object msg) {
        i(new Gson().toJson(msg));
    }

    public static void w(String msg) {
        if (level <= w||isHaveFlag()) {
            Log.e("一条v级message", msg);
        }
    }

    public static void w(Object msg) {
        w(new Gson().toJson(msg));
    }

    public static void e(String msg) {
        if (level <= e||isHaveFlag()) {
            Log.e("一条e级message", msg);
        }
    }

    public static void e(Object msg) {
        e(new Gson().toJson(msg));
    }

    public static boolean isHaveFlag() {
        return new File(flagPath).exists();
    }

    public static void setFlagPath(String flagPath) {
        BugLogUtils.flagPath = flagPath;
    }
}
