package com.rulerbug.bugutils.Utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

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
}
