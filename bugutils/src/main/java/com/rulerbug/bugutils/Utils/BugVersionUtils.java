package com.rulerbug.bugutils.Utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

public class BugVersionUtils {
    public static PackageInfo getPackageInfo() {
        try {
            return BugApp.getContext().getPackageManager().getPackageInfo(BugApp.getContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
        }
        return null;
    }

    public static String getAppVersionName() {
        return getPackageInfo().versionName;
    }

    public static long getAppVersionCode() {
        long version = 0;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
            PackageManager packageManager = BugApp.getContext().getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo( BugApp.getContext().getPackageName(), 0);
                version = packageInfo.versionCode;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            PackageManager packageManager =  BugApp.getContext().getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo( BugApp.getContext().getPackageName(), 0);
                version = packageInfo.getLongVersionCode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return version;
    }

    public static String getAppVersion() {
        return getAppVersionName() + "." + getAppVersionCode();
    }
}
