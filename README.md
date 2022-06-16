# BugUtils

## maven { url 'https://jitpack.io' }
## implementation 'com.github.JiJiBo:BugUtils:1.1.35'
## implementation 'com.google.code.gson:gson:2.8.6'
## BugApp.init(this,new Handler(),  android.os.Process.myTid());


# 这个框架全是我收集的乱七八糟的代码 
# 这是混淆代码
https://blog.csdn.net/sinat_40387150/article/details/122788849?spm=1001.2014.3001.5501
```
# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html
 
# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
 
# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable
 
# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#############################################
#
# 对于一些基本指令的添加
#
#############################################
# 代码混淆压缩比，在0~7之间，默认为5，一般不做修改
-optimizationpasses 5
 
# 混合时不使用大小写混合，混合后的类名为小写
-dontusemixedcaseclassnames
 
# 指定不去忽略非公共库的类
-dontskipnonpubliclibraryclasses
 
# 这句话能够使我们的项目混淆后产生映射文件
# 包含有类名->混淆后类名的映射关系
-verbose
 
# 指定不去忽略非公共库的类成员
-dontskipnonpubliclibraryclassmembers
 
# 不做预校验，preverify是proguard的四个步骤之一，Android不需要preverify，去掉这一步能够加快混淆速度。
-dontpreverify
 
# 保留Annotation不混淆
-keepattributes *Annotation*,InnerClasses
 
# 避免混淆泛型
-keepattributes Signature
 
# 抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable
 
# 指定混淆是采用的算法，后面的参数是一个过滤器
# 这个过滤器是谷歌推荐的算法，一般不做更改
-optimizations !code/simplification/cast,!field/*,!class/merging/*
 
 
#############################################
#
# Android开发中一些需要保留的公共部分
#
#############################################
 
# 保留我们使用的四大组件，自定义的Application等等这些类不被混淆
# 因为这些子类都有可能被外部调用
-keep public class * extends android.app.Activity
 
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
 
 
 
# 保留support下的所有类及其内部类
-keep class androidx.** {*;}
-keep class org.** {*;}
-keep class com.zzhoujay.** {*;}
-keep class com.google.** {*;}
 
-keep class com.github.** {*;}
-keep class com.rulerbug.** {*;}
-keep class com.alipay.** {*;}
-keep class com.tencent.** {*;}
-keep class com.huawei.** {*;}
-keep class com.unionpay.** {*;}
-keep class cn.gov.** {*;}
-keep class com.example.** {*;}
-keep class com.wang.** {*;}
-keep class com.blankj.** {*;}
-keep class com.google.zxing.** {*;}
-keep class io.reactivex.rxjava3.** {*;}
-keep class timber.** {*;}
-keep class me.jessyan.** {*;}
-keep class com.orhanobut.** {*;}
-keep class com.amap.** {*;}
-keep class com.nas.** {*;}
-keep class com.scwang.smartrefresh.** {*;}
-keep class com.scwang.smart.** {*;}
-keep class com.youth.banner.** {*;}
-keep class org.** {*;}
-keep class com.ggh.** {*;}
-keep class com.pinyue.** {*;}
-keep class com.blankj.** {*;}
-keep class com.squareup.** {*;}
-keep class com.pingerx.** {*;}
-keep class com.azhon.** {*;}
 
# Retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
# 保留继承的
-keep public class * extends aandroidx.**
 
 
# 保留R下面的资源
-keep class **.R$* {*;}
 
# 保留本地native方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}
 
# 保留在Activity中的方法参数是view的方法，
# 这样以来我们在layout中写的onClick就不会被影响
-keepclassmembers class * extends android.app.Activity{
    public void *(android.view.View);
}
 
# 保留枚举类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
 
# 保留我们自定义控件（继承自View）不被混淆
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
 
# 保留Parcelable序列化类不被混淆
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
 
# 保留Serializable序列化的类不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
 
# 对于带有回调函数的onXXEvent、**On*Listener的，不能被混淆
-keepclassmembers class * {
    void *(**On*Event);
    void *(**On*Listener);
}
# Gson
-keepattributes Signature
-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
# 使用Gson时需要配置Gson的解析对象及变量都不混淆。不然Gson会找不到变量。
# 将下面替换成自己的实体类
-keep class com.example.bean.** { *; }
 
# Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
# OkHttp3
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**
 
# EventBus
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
 
 
 
# 高德相关依赖
# 集合包:3D地图3.3.2 导航1.8.0 定位2.5.0
-dontwarn com.amap.api.**
-dontwarn com.autonavi.**
-keep class com.amap.api.**{*;}
-keep class com.autonavi.**{*;}
# 地图服务
-dontwarn com.amap.api.services.**
-keep class com.map.api.services.** {*;}
# 3D地图
-dontwarn com.amap.api.mapcore.**
-dontwarn com.amap.api.maps.**
-dontwarn com.autonavi.amap.mapcore.**
-keep class com.amap.api.mapcore.**{*;}
-keep class com.amap.api.maps.**{*;}
-keep class com.autonavi.amap.mapcore.**{*;}
# 定位
-dontwarn com.amap.api.location.**
-dontwarn com.aps.**
-keep class com.amap.api.location.**{*;}
-keep class com.aps.**{*;}
# 导航
-dontwarn com.amap.api.navi.**
-dontwarn com.autonavi.**
-keep class com.amap.api.navi.** {*;}
-keep class com.autonavi.** {*;}
 
 
 
# OkHttp3
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**
 
#PictureSelector 2.0
-keep class com.luck.picture.lib.** { *; }
 
-dontwarn com.yalantis.ucrop**
-keep class com.yalantis.ucrop** { *; }
-keep interface com.yalantis.ucrop** { *; }
#fasejson
-keepattributes Signature
-dontwarn com.alibaba.fastjson.**
-keep class com.alibaba.fastjson.**{*; }
#baidu
 
-keep class com.baidu.mapapi.** {*;}
-keep class com.baidu.** { *; }
-keep class vi.com.gdi.bgl.android.**{*;}
-keep class vi.com.gdi.bgl.android.**{*;}
 
#alibaba route
-keep public class com.alibaba.android.arouter.routes.**{*;}
-keep public class com.alibaba.android.arouter.facade.**{*;}
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe{*;}
 
# If you use the byType method to obtain Service, add the following rules to protect the interface:
-keep interface * implements com.alibaba.android.arouter.facade.template.IProvider
 
# If single-type injection is used, that is, no interface is defined to implement IProvider, the following rules need to be added to protect the implementation
# -keep class * implements com.alibaba.android.arouter.facade.template.IProvider
 
#
 
-keep class com.tencent.mm.opensdk.** {
    *;
}
 
-keep class com.tencent.wxop.** {
    *;
}
 
-keep class com.tencent.mm.sdk.** {
    *;
}
-keep class com.rulerbug.** {*;}
-keep class com.nas.** {*;}
-keep class com.ggh.** {*;}
-keep class com.personal.** {*;}
-keep class com.devilist.** {*;}
 
```