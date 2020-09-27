package com.rulerbug.bugutils.Utils;

import android.text.TextUtils;

import java.io.*;

public class BugCacheUtils {
    public static String absolutePath = BugDirUtils.getDiskCachePath();

    public static void saveStringCache(String str, String name) {
        saveStringCache(str, name, 1000 * 60 * 60 * 24 * 10);
    }

    public static void setFilePath(String path) {
        absolutePath = path;
    }

    public static void saveStringCache(String str, String name, long time) {
        saveStringCache(str, name, time, absolutePath);
    }

    public static void saveStringCache(String str, String name, long time, String dirpath) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
//        BugLogUtils.e("保存缓存");
        String path = dirpath + File.separator + name;
        File file = new File(path);
        try {
            if (!file.exists() || !file.isFile()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            //写入有效时间
            bw.write(System.currentTimeMillis() + time + "");
            bw.newLine();
            bw.flush();
            //写入数据
            bw.write(str);
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getStringCache(String name) {

        return getStringCache(name, absolutePath);
    }

    public static String getStringCache(String name, String dirpath) {
        String path = dirpath + File.separator + name;
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            long time = Long.parseLong(br.readLine());
            long now = System.currentTimeMillis();
//            BugLogUtils.e("距离有效期结束还有"+(time-now)+"毫秒");
            if (now > time) {
                file.delete();
                return null;
            }
            StringBuffer sb = new StringBuffer();
            int len = 0;
            char[] buf = new char[1024];
            while ((len = br.read(buf)) != -1) {
                sb.append(buf, 0, len);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void delCache(String name, String dirpath) {
        if (TextUtils.isEmpty(name)) {
            return;
        }
        String path = dirpath + File.separator + name;
        File file = new File(path);

        BugLogUtils.e("ishave" + file.exists());
        boolean delete = file.delete();
        BugLogUtils.e("del" + delete);
        BugLogUtils.e(" after del  ishave" + file.exists());
    }

    public static void delCache(String name) {
        delCache(name, absolutePath);
    }
}
