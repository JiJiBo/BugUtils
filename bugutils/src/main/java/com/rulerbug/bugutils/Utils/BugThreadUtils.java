package com.rulerbug.bugutils.Utils;

import static com.rulerbug.bugutils.Utils.BugApp.getHandler;
import static com.rulerbug.bugutils.Utils.BugApp.getTheardId;

public class BugThreadUtils {
    public static boolean isRunOnUIThread() {
        int mTid = android.os.Process.myTid();
        if (mTid == getTheardId()) {
            return true;
        }
        return false;
    }

    public static void RunOnUIThread(Runnable r) {
        if (isRunOnUIThread()) {
            r.run();
        } else {
            getHandler().post(r);
        }
    }

    public static void RunOnUIThread(Runnable r, long delay) {
        getHandler().postDelayed(r, delay);
    }
}
