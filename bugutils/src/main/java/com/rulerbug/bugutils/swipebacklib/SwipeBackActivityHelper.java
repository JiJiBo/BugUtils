package com.rulerbug.bugutils.swipebacklib;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

import com.rulerbug.bugutils.R;

/**
 * @author zh
 */
public class SwipeBackActivityHelper {
    private Activity mActivity;
    public SwipeBackLayout mSwipeBackLayout;

    public SwipeBackActivityHelper(Activity activity) {
        mActivity = activity;
    }

    @SuppressWarnings("deprecation")
    public void onActivityCreate(boolean isAnim) {
        mActivity.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mActivity.getWindow().getDecorView().setBackgroundDrawable(null);
        mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(mActivity).inflate(
             R.layout.swipeback_layout, null);
        mSwipeBackLayout.finishAnim = isAnim;
    }

    public void onPostCreate() {
        mSwipeBackLayout.attachToActivity(mActivity);
        mSwipeBackLayout.bind();
    }

    public void finish() {
        if(mSwipeBackLayout != null){
            mSwipeBackLayout.startFinishAnim();
        }
    }

    public View findViewById(int id) {
        if (mSwipeBackLayout != null) {
            return mSwipeBackLayout.findViewById(id);
        }
        return null;
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return mSwipeBackLayout;
    }
}
