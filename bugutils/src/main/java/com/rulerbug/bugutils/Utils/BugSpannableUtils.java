package com.rulerbug.bugutils.Utils;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

public class BugSpannableUtils {
    //设置文本部分文本颜色
    public static SpannableStringBuilder setColor(String text, int start, int end, int color) {
        SpannableStringBuilder ssb = new SpannableStringBuilder(text);
        ssb.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    public static SpannableStringBuilder setColor(SpannableStringBuilder text, int start, int end, int color) {
        SpannableStringBuilder ssb = new SpannableStringBuilder(text);
        ssb.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    public static SpannableStringBuilder setBolder(String text, int start, int end, int t) {
        //        t=Typeface.BOLD
        SpannableStringBuilder ssb = new SpannableStringBuilder(text);
        ssb.setSpan(new StyleSpan(t), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    public static SpannableStringBuilder setBolder(SpannableStringBuilder text, int start, int end, int t) {
//        t=Typeface.BOLD
        SpannableStringBuilder ssb = new SpannableStringBuilder(text);
        ssb.setSpan(new StyleSpan(t), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    public static SpannableStringBuilder setSp(String text, int start, int end, Object what) {
        SpannableStringBuilder ssb = new SpannableStringBuilder(text);
        ssb.setSpan(what, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    public static SpannableStringBuilder setSp(SpannableStringBuilder text, int start, int end, Object what) {
        SpannableStringBuilder ssb = new SpannableStringBuilder(text);
        ssb.setSpan(what, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }
}
