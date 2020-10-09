package com.rulerbug.bugutils.Utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class BugPhoneUtils {


    /**
     * 获取有线的mac地址
     *
     * @return
     */
    public static String getLocalMacAddress() {
        String mac = "";
        try {
            Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();

            while (localEnumeration.hasMoreElements()) {
                NetworkInterface localNetworkInterface = (NetworkInterface) localEnumeration.nextElement();
                String interfaceName = localNetworkInterface.getDisplayName();

                if (interfaceName == null) {
                    continue;
                }

                if (interfaceName.equals("eth0")) {
                    // MACAddr = convertMac(localNetworkInterface
                    // .getHardwareAddress());
                    mac = convertToMac(localNetworkInterface.getHardwareAddress());
                    if (mac != null && mac.startsWith("0:")) {
                        mac = "0" + mac;
                    }
                    break;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return mac;
    }

    private static String convertToMac(byte[] mac) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            byte b = mac[i];
            int value = 0;
            if (b >= 0 && b <= 16) {
                value = b;
                sb.append("0" + Integer.toHexString(value));
            } else if (b > 16) {
                value = b;
                sb.append(Integer.toHexString(value));
            } else {
                value = 256 + b;
                sb.append(Integer.toHexString(value));
            }
            if (i != mac.length - 1) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    /**
     * 获取无线的mac地址
     *
     * @return
     */
    public static String getWifiMacAddress(Context context) {
        String mac = "";
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        if (null != info) {
            mac = info.getMacAddress();
        }
        return mac;
    }


    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机品牌
     *
     * @return 手机品牌
     */
    public static String getDeviceName() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机硬件制造商
     *
     * @return 手机硬件制造商
     */
    public static String getMakeName() {
        return android.os.Build.MANUFACTURER;
    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getFactoryName() {
        return android.os.Build.PRODUCT;
    }


    /**
     * 检查当前网络是否可用
     *
     * @param
     * @return
     */

    public static boolean isNetwork() {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) BugApp.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        } else {
            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
//                    System.out.println(i + "===状态===" + networkInfo[i].getState());
//                    System.out.println(i + "===类型===" + networkInfo[i].getTypeName());
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * @param filepathApk 文件路径
     */
    public static void installPackage(String filepathApk) {
        try {
            PackageInstaller pi = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                pi = BugApp.getContext().getPackageManager().getPackageInstaller();
            }
            //给定模式，创建新的参数，创建新安装会话，返回唯一 Id
            int sessionId = 0;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                sessionId = pi.createSession(new PackageInstaller.SessionParams(PackageInstaller.SessionParams.MODE_FULL_INSTALL));
            }
            //打开现有会话，主动执行工作
            PackageInstaller.Session session = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                session = pi.openSession(sessionId);
            }
            long sizeBytes = 0;
            final File file = new File(filepathApk);
            if (file.isFile()) {
                sizeBytes = file.length();
            }
            InputStream in = null;
            OutputStream out = null;
            in = new FileInputStream(filepathApk);
            //打开一个流，将一个APK文件写入会话
            //指定有效长度系统将预先分配底层磁盘空间以优化磁盘上的放置
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                out = session.openWrite("app_store_session", 0, sizeBytes);
            }
            int total = 0;
            byte[] buffer = new byte[65536];
            int len;
            while ((len = in.read(buffer)) != -1) {
                total += len;
                out.write(buffer, 0, len);
            }
            //根据需要调用，用来确保字节已保留到磁盘
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                session.fsync(out);
            }
            in.close();
            out.close();

            PendingIntent broadCastTest = PendingIntent.getBroadcast(BugApp.getContext(), sessionId, new Intent("action.install.success"), PendingIntent.FLAG_UPDATE_CURRENT);
            //提交之前必须关闭所有流
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                session.commit(broadCastTest.getIntentSender());
            }
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
