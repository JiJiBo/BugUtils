package com.rulerbug.bugutils.Utils;

import java.text.DecimalFormat;

public class BugFileSizeUtil {
    public static String renderFileSize(String fileSize) {
        String[] arr = {"Bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
        float srcsize = Float.valueOf(fileSize);
        int index = (int) (Math.floor(Math.log(srcsize) / Math.log(1024)));
        double size = srcsize / Math.pow(1024, index);
        size = Double.valueOf(new DecimalFormat("#.00").format(size));
        return size + arr[index];
    }


}
