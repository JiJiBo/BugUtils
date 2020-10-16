package com.rulerbug.bugutils.Utils;

import android.text.Html;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class BugBindAdapter {
    @BindingAdapter("bindHtmlTextView")
    public static void bindHtmlTextView(TextView tv, String msg) {
        tv.setText(Html.fromHtml(msg));
    }
}
