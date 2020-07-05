package com.rulerbug.bugutils.Utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Handler;


public class BugApp {
    private static Context mc;
    private static int myTid;
    private static Handler mHandler;


    public static void init(Context cx, Handler handler, int tid) {
        mc = cx;
        mHandler = handler;
        myTid = tid;
    }

    public static Handler getmHandler() {
        return mHandler;
    }

    public static int getMyTid() {
        return myTid;
    }

    public static Context getMc() {
        return mc;
    }


    // 3个基本操作
    public static Context getContext() {
        return getMc();
    }

    public static int getTheardId() {
        return getMyTid();
    }

    public static Handler getHandler() {
        return getmHandler();
    }

    // 其他操作
    public static String[] getStringArray(int id) {
        return getContext().getResources().getStringArray(id);
    }

    public static ColorStateList getColorStateListById(int id) {
        return getContext().getResources().getColorStateList(id);
    }


}
