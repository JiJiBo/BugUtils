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
    public static int level = v;
    public static boolean isHaveFile = false;
    private static final String TOP_BORDER = "╔═══════════════════════════════════════════════════════════════════════════════════════════════════";
    private static final String LEFT_BORDER = "║ ";
    private static final String BOTTOM_BORDER = "╚═══════════════════════════════════════════════════════════════════════════════════════════════════";


    public static void v(String msg) {
        if (level <= v || isHaveFile) {
            Log.v("bug_msg", TOP_BORDER);
            Log.v("bug_msg", LEFT_BORDER + msg);
            Log.v("bug_msg", BOTTOM_BORDER);
        }
    }

    public static void v(Object msg) {
        v(new Gson().toJson(msg));
    }

    public static void setLevel(int l) {
        level = l;
    }

    public static void d(String msg) {
        if (level <= d || isHaveFile) {
            Log.d("bug_msg", TOP_BORDER);
            Log.d("bug_msg", LEFT_BORDER + msg);
            Log.d("bug_msg", BOTTOM_BORDER);
        }
    }

    public static void d(Object msg) {
        d(new Gson().toJson(msg));
    }

    public static void i(String msg) {
        if (level <= i || isHaveFile) {
            Log.i("bug_msg", TOP_BORDER);
            Log.i("bug_msg", LEFT_BORDER + msg);
            Log.i("bug_msg", BOTTOM_BORDER);
        }
    }

    public static void i(Object msg) {
        i(new Gson().toJson(msg));
    }

    public static void w(String msg) {
        if (level <= w || isHaveFile) {
            Log.v("bug_msg", TOP_BORDER);
            Log.v("bug_msg", LEFT_BORDER + msg);
            Log.v("bug_msg", BOTTOM_BORDER);
        }
    }

    public static void w(Object msg) {
        w(new Gson().toJson(msg));
    }

    public static void e(String msg) {
        if (level <= e || isHaveFile) {
            Log.e("bug_msg", TOP_BORDER);
            Log.e("bug_msg", LEFT_BORDER + msg);
            Log.e("bug_msg", BOTTOM_BORDER);
        }
    }

    public static void e(Object msg) {
        e(new Gson().toJson(msg));
    }
    public static void setFlagPath(String f) {
        isHaveFile = new File(f).exists();
    }

}
