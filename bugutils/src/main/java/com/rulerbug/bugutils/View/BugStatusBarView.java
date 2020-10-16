package com.rulerbug.bugutils.View;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * 公司：江苏刚刚好网络科技有限公司
 * 作者：Android 土三七
 * 文件名：StatusBarView
 * 创建时间：2020/6/29
 * 功能描述： 顶部状态栏的代替控件
 */
public class BugStatusBarView extends RelativeLayout {
    private static int mStatusBarHeight;

    public BugStatusBarView(Context context) {
        this(context, null);
    }

    public BugStatusBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mStatusBarHeight = getStatusBarHeight(context);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), mStatusBarHeight);
    }

    //此处代码可以放到StatusBarUtils
    public static int getStatusBarHeight(Context context) {
        if (mStatusBarHeight == 0) {
            Resources res = context.getResources();
            int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                mStatusBarHeight = res.getDimensionPixelSize(resourceId);
            }
        }
        return mStatusBarHeight;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
