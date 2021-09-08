package com.rulerbug.bugutils.Utils;

import android.view.View;

public class BugLocationUtils {
    public static int[] getLocationInWindow(View view) {
        int[] ints = new int[2];
        view.getLocationInWindow(ints);
        return ints;
    }

    public static int[] getLocationOnScreen(View view) {
        int[] ints = new int[2];
        view.getLocationOnScreen(ints);
        return ints;
    }
}
