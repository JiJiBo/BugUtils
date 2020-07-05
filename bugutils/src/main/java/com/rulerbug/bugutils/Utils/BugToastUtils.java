package com.rulerbug.bugutils.Utils;

import android.widget.Toast;

public class BugToastUtils {
    private static Toast toast;
    private static BugToastUtils instance;

    private BugToastUtils() {

    }

    public static BugToastUtils getInstance() {
        synchronized (BugToastUtils.class) {
            if (instance == null) {
                instance = new BugToastUtils();
            }
        }
        return instance;
    }

    private void show(String msg, int durition) {
        if (toast == null) {
            toast = Toast.makeText(BugApp.getContext(), msg, durition);
        } else {
            toast.setText(msg);
            toast.setDuration(durition);
        }
        toast.show();
    }

    public void showShort(String msg) {
        show(msg, Toast.LENGTH_SHORT);
    }

    public void showLong(String msg) {
        show(msg, Toast.LENGTH_LONG);
    }

    public void cancle() {
        toast.cancel();
    }
}
