package com.rulerbug.bugutils.config

import android.app.Activity
import android.text.TextUtils
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView


import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import com.rulerbug.bugutils.Bind.GlideRoundTransform
import com.rulerbug.bugutils.R

import com.rulerbug.bugutils.Utils.*
import com.xuexiang.xui.widget.toast.XToast
import com.zzhoujay.richtext.RichText
import org.greenrobot.eventbus.EventBus
import java.io.File
import java.lang.Exception


inline fun <reified T> String.toBean(): T {
    return Gson().fromJson<T>(this, T::class.java)
}


fun String.log() {
    BugLogUtils.e(this)
}

fun String.toRitch(tv: TextView) {
    RichText.fromHtml(this).into(tv)
}

fun TextView.toRitch(str: String) {
    RichText.fromHtml(str).into(this)
}

fun String.success(activity: Activity?) {
    if (BugThreadUtils.isRunOnUIThread()) {
        val success = XToast.success(BugApp.getContext(), this)
        success.setGravity(Gravity.CENTER, 0, 0)
        success.show()
    } else {
        BugThreadUtils.RunOnUIThread {
            val success = XToast.success(BugApp.getContext(), this)
            success.setGravity(Gravity.CENTER, 0, 0)
            success.show()
        }
    }
}

fun String.error(activity: Activity?) {
    if (BugThreadUtils.isRunOnUIThread()) {
        val error = XToast.error(BugApp.getContext(), this)
        error.setGravity(Gravity.CENTER, 0, 0)
        error.show()
    } else {
        BugThreadUtils.RunOnUIThread {
            val error = XToast.error(BugApp.getContext(), this)
            error.setGravity(Gravity.CENTER, 0, 0)
            error.show()
        }
    }
}

fun String.info(activity: Activity?) {
    if (BugThreadUtils.isRunOnUIThread()) {
        val info = XToast.info(BugApp.getContext(), this)
        info.setGravity(Gravity.CENTER, 0, 0)
        info.show()
    } else {
        BugThreadUtils.RunOnUIThread {
            val info = XToast.info(BugApp.getContext(), this)
            info.setGravity(Gravity.CENTER, 0, 0)
            info.show()
        }
    }
}

fun String.loadImg(imageView: ImageView) {
    try {
        if (BugThreadUtils.isRunOnUIThread()) {
            Glide.with(imageView).load(this).error(R.drawable.ic_placeholder).into(imageView)
        } else {
            BugThreadUtils.RunOnUIThread {
                Glide.with(imageView).load(this).error(R.drawable.ic_placeholder).into(imageView)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun String.loadGifImg(imageView: ImageView) {
    try {
        if (BugThreadUtils.isRunOnUIThread()) {
            Glide.with(imageView).asGif().load(this).error(R.drawable.ic_placeholder)
                .into(imageView)
        } else {
            BugThreadUtils.RunOnUIThread {
                Glide.with(imageView).asGif().load(this).error(R.drawable.ic_placeholder)
                    .into(imageView)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun Int.loadGifImg(imageView: ImageView) {
    try {
        if (BugThreadUtils.isRunOnUIThread()) {
            Glide.with(imageView).asGif().load(this).error(R.drawable.ic_placeholder)
                .into(imageView)
        } else {
            BugThreadUtils.RunOnUIThread {
                Glide.with(imageView).asGif().load(this).error(R.drawable.ic_placeholder)
                    .into(imageView)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun String.loadImgByRect(imageView: ImageView) {
    try {
        if (BugThreadUtils.isRunOnUIThread()) {
            Glide.with(imageView).load(this).centerCrop().error(R.drawable.ic_placeholder)
                .into(imageView)
        } else {
            BugThreadUtils.RunOnUIThread {
                Glide.with(imageView).load(this).centerCrop().error(R.drawable.ic_placeholder)
                    .into(imageView)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun Int.loadImgByRect(imageView: ImageView) {
    try {
        if (BugThreadUtils.isRunOnUIThread()) {
            Glide.with(imageView).load(this).centerCrop().error(R.drawable.ic_placeholder)
                .into(imageView)
        } else {
            BugThreadUtils.RunOnUIThread {
                Glide.with(imageView).load(this).centerCrop().error(R.drawable.ic_placeholder)
                    .into(imageView)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun String.loadImgByRound(imageView: ImageView) {
    try {
        if (BugThreadUtils.isRunOnUIThread()) {
            Glide.with(imageView).load(this).circleCrop()
                .into(imageView)
        } else {
            BugThreadUtils.RunOnUIThread {
                Glide.with(imageView).load(this).circleCrop()
                    .into(imageView)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }


}

fun String.loadImgByRadius(imageView: ImageView, radius: Int) {
    try {
        val myOptions = RequestOptions()
            .transform(GlideRoundTransform(BugApp.getContext(), radius))
        if (BugThreadUtils.isRunOnUIThread()) {
            Glide.with(imageView).load(this).circleCrop().apply(myOptions).into(imageView)
        } else {
            BugThreadUtils.RunOnUIThread {
                Glide.with(imageView).load(this).circleCrop().apply(myOptions).into(imageView)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun String.nasList(split: String): ArrayList<String> {
    var imgs = ArrayList<String>()
    for (s in this.split(split)) {
        imgs.add(s)
    }
    return imgs
}

fun String.toDingDanBianHao(): String {
    try {
        return this.substring(0, 3) + "***" + this.substring(6)
    } catch (e: Exception) {
        return "***"
    }

}

fun String.dealName(): String {
    try {
        var datas = StringBuffer()
        for (c in 1..this.length - 1) {
            datas.append("*")
        }
        datas.append(this.substring(this.length - 1))

        return datas.toString()
    } catch (e: Exception) {
        return "***"
    }

}

fun String.dealIdNum(): String {
    try {


        return this.substring(0, 6) + "********" + this.substring(this.length - 4)
    } catch (e: Exception) {
        return "***"
    }

}

fun String.toMD5(): String {
    return BugMD5Encoder.encode(this)
}

////view
//fun View.singleClick(code: () -> Unit?) {
//    "点击".log()
//    if (BugFastClickUtils.isFastClick()) {
//        return
//    }
//    this.setOnClickListener {
//        code()
//    }
//}
//any
fun <T : Any> T.log(str: String? = null) {
    str?.let {
        BugLogUtils.e(str, Gson().toJson(this))
        return
    }
    BugLogUtils.e(this)
}

fun <T : Any> T.sendEventBus() {

    EventBus.getDefault().post(this)
}

fun <T : Any> T.toJson(): String? {
    return Gson().toJson(this)
}

//list
fun ArrayList<String>.toNasStr(sp: String): String {
    if (this.size == 0) {
        return ""
    }
    val sb = StringBuffer()
    for (s in this) {
        if (TextUtils.isEmpty(s)) {
            continue
        }
        sb.append(s)
        sb.append(sp)
    }

    return sb.toString().substring(0, sb.length - 1)
}

fun Long.logLongTime() {
    BugLogUtils.e(BugTimeUtils.LongTimeToStringTime(this), "logLongTime")
}

fun String.ParseTel(): String {
    return this
        .replace(" ", "")
        .replace(" ", "")
        .replace("(", "")
        .replace("（", "")
        .replace(")", "")
        .replace("）", "")
        .replace("-", "")
}

fun String.dealPhone(): String {
    try {
        return this.substring(0, 3) + "****" + this.substring(7)
    } catch (e: Exception) {
        return "***"
    }
}


fun Long.toTimeByLong(reg: String): String? {
    return BugTimeUtils.LongTimeToStringTime(this, reg)
}

fun Int.toTimeByShort(reg: String): String? {
    return BugTimeUtils.LongTimeToStringTime(this * 1000L, reg)
}

fun Double.add(num: Double): Double {
    return BugBigNumberUtils.add(this, num)
}

fun Float.add(num: Float): Double {
    return BugBigNumberUtils.add(this, num)
}

fun Double.reduce(num: Double): Double {
    return BugBigNumberUtils.reduce(this, num)
}

fun Float.reduce(num: Float): Double {
    return BugBigNumberUtils.reduce(this, num)
}

fun String.isHaveThisFile(): Boolean {
    if (this.isNullOrEmpty()) {
        return false
    }
    return File(this).exists()
}