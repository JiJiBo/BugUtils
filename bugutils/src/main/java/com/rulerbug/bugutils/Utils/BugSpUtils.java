package com.rulerbug.bugutils.Utils;

import android.content.SharedPreferences;

public class BugSpUtils {
    private static String SPFILENAME = "SmartBeiJingSp";

    /**
     * @param key 根据此节点找值
     * @param def 默认值
     * @return 返回储存的值
     */
    public static int getSpInt(String key, int def) {
        SharedPreferences sp = BugApp.getContext().getSharedPreferences(SPFILENAME,
                BugApp.getContext().MODE_PRIVATE);
        return sp.getInt(key, def);
    }

    /**
     * @param key   数据所在节点名
     * @param value 保存的值
     */
    public static void putSpInt(String key, int value) {
        SharedPreferences sp = BugApp.getContext().getSharedPreferences(SPFILENAME,
                BugApp.getContext().MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }

    /**
     * @param key 根据此节点找值
     * @param def 默认值
     * @return 返回储存的值
     */
    public static String getSpString(String key, String def) {
        SharedPreferences sp = BugApp.getContext().getSharedPreferences(SPFILENAME,
                BugApp.getContext().MODE_PRIVATE);
        return sp.getString(key, def);
    }

    /**
     * @param key   数据所在节点名
     * @param value 保存的值
     */
    public static void putSpString(String key, String value) {
        SharedPreferences sp = BugApp.getContext().getSharedPreferences(SPFILENAME,
                BugApp.getContext().MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    /**
     * @param key 根据此节点找值
     * @param def 默认值
     * @return 返回储存的值
     */
    public static boolean getSpBoolean(String key,

                                       boolean def) {
        SharedPreferences sp = BugApp.getContext().getSharedPreferences(SPFILENAME,
                BugApp.getContext().MODE_PRIVATE);
        return sp.getBoolean(key, def);
    }

    /**
     * @param key   数据所在节点名
     * @param value 保存的值
     */
    public static void putSpBoolean(String key, boolean value) {
        SharedPreferences sp = BugApp.getContext().getSharedPreferences(SPFILENAME,
                BugApp.getContext().MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    /**
     * 移除一个节点
     *
     * @param key 要移除的节点
     */
    public static void remove(String key) {
        SharedPreferences sp = BugApp.getContext().getSharedPreferences(SPFILENAME,
                BugApp.getContext().MODE_PRIVATE);
        sp.edit().remove(key).commit();
    }

}
