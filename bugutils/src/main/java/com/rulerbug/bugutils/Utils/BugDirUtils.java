package com.rulerbug.bugutils.Utils;

import android.os.Environment;

import java.io.File;

public class BugDirUtils {


    public static String getStoreRootPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static String getDirPathByDirName(String dirName) {
        String path = getStoreRootPath() + File.separator + dirName;
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }

    /**
     * 获取cache路径
     */
    public static String getDiskCachePath() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            return BugApp.getContext().getExternalCacheDir().getPath();
        } else {
            return BugApp.getContext().getCacheDir().getPath();
        }
    }
}