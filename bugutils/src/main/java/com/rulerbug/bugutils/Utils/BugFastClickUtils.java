package com.rulerbug.bugutils.Utils;

public class BugFastClickUtils {
    private static long lastClickTime;

    public synchronized static boolean isFastClick() {
        return isFastClick(500);
    }
    public synchronized static boolean isFastClick(int wait) {
        long time = System.currentTimeMillis();
        long range = time - lastClickTime;
        if (range < wait && range > 0) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
