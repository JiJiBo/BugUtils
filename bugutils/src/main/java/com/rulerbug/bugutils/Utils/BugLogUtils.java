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


    public static void v(Object... msgs) {
        if (level <= v || isHaveFile) {
            Log.v("bug_msg", TOP_BORDER);
            for (Object msg : msgs) {
                Log.v("bug_msg", LEFT_BORDER + new Gson().toJson(msg));
            }
            Log.v("bug_msg", BOTTOM_BORDER);
        }
    }


    public static void setLevel(int l) {
        level = l;
    }

    public static void d(Object... msgs) {
        if (level <= d || isHaveFile) {
            Log.d("bug_msg", TOP_BORDER);
            for (Object msg : msgs) {
                Log.d("bug_msg", LEFT_BORDER + new Gson().toJson(msg));
            }
            Log.d("bug_msg", BOTTOM_BORDER);
        }
    }


    public static void i(Object... msgs) {
        if (level <= i || isHaveFile) {
            Log.i("bug_msg", TOP_BORDER);
            for (Object msg : msgs) {
                Log.i("bug_msg", LEFT_BORDER + new Gson().toJson(msg));
            }
            Log.i("bug_msg", BOTTOM_BORDER);
        }
    }


    public static void w(Object... msgs) {
        if (level <= w || isHaveFile) {
            Log.v("bug_msg", TOP_BORDER);
            for (Object msg : msgs) {
                Log.v("bug_msg", LEFT_BORDER + new Gson().toJson(msg));
            }
            Log.v("bug_msg", BOTTOM_BORDER);
        }
    }

    public static void e(Object... msgs) {
        if (level <= e || isHaveFile) {
            Log.e("bug_msg", TOP_BORDER);
            for (Object msg : msgs) {
                Log.e("bug_msg", LEFT_BORDER + new Gson().toJson(msg));
            }
            Log.e("bug_msg", BOTTOM_BORDER);
        }
    }

    public static void setFlagPath(String f) {
        isHaveFile = new File(f).exists();
    }

}
