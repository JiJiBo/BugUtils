package com.rulerbug.bugutils.Utils;

import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import static android.content.Context.WINDOW_SERVICE;

public class BugWindowUtils {
    public static WindowSize getWindowSize() {
        WindowSize size = new WindowSize();
        DisplayMetrics outMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) (BugApp.getContext().getSystemService(WINDOW_SERVICE));
        Display defaultDisplay = wm.getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            defaultDisplay.getRealMetrics(outMetrics);
            size.width = outMetrics.widthPixels;
            size.height = outMetrics.heightPixels;
            return size;
        }
        size.width = defaultDisplay.getWidth();
        size.height = defaultDisplay.getHeight();
        return size;
    }

    public static class WindowSize {
        public int width;
        public int height;
    }
}
