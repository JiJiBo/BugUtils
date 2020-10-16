package com.rulerbug.bugutils.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rulerbug.bugutils.R;

public class BugTitleBar extends LinearLayout {
    private Context mContext;
    private String titleCenter;
    private String titleRight;
    private String titleLeft;
    private int titleCenterColor;
    private int titleRightColor;
    private int titleLeftColor;
    private int titleRightIcon;
    private int titleLeftIcon;

    private TextView tvTitleCenter;
    private TextView tvTitleRight;
    private TextView tvTitleLeft;
    private ImageView imgTitleLeft;
    private ImageView imgTitleRight;

    public BugTitleBar(Context context) {
        this(context, null);
    }

    public BugTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BugTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        titleRightIcon = ta.getResourceId(R.styleable.TitleBar_bar_titie_tv_right_icon, 0);
        titleLeftIcon = ta.getResourceId(R.styleable.TitleBar_bar_titie_tv_left_icon, 0);
        titleCenter = ta.getString(R.styleable.TitleBar_bar_title_tv_center);
        titleLeft = ta.getString(R.styleable.TitleBar_bar_titie_tv_left);
        titleRight = ta.getString(R.styleable.TitleBar_bar_titie_tv_right);
        titleCenterColor = ta.getColor(R.styleable.TitleBar_bar_title_tv_center_color, 0xffffffff);
        titleRightColor = ta.getColor(R.styleable.TitleBar_bar_title_tv_right_color, 0xffffffff);
        titleLeftColor = ta.getColor(R.styleable.TitleBar_bar_title_tv_left_color, 0xffffffff);
        initView(context, attrs);
        initData();
        ta.recycle();
    }

    private void initData() {
        tvTitleCenter.setText(titleCenter);
        tvTitleRight.setText(titleRight);
        tvTitleLeft.setText(titleLeft);
        tvTitleCenter.setTextColor(titleCenterColor);
        tvTitleRight.setTextColor(titleRightColor);
        tvTitleLeft.setTextColor(titleLeftColor);

        imgTitleLeft.setImageResource(titleLeftIcon);
        imgTitleRight.setImageResource(titleRightIcon);

    }

    private void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.layout_title_bar, this, true);
        tvTitleCenter = findViewById(R.id.title_bar_center);
        tvTitleRight = findViewById(R.id.title_bar_right_text);
        tvTitleLeft = findViewById(R.id.title_bar_left_text);
        imgTitleLeft = findViewById(R.id.title_bar_left_img);
        imgTitleRight = findViewById(R.id.title_bar_right_img);
    }

    public void setTitleCenter(String titleCenter) {
        this.titleCenter = titleCenter;
        tvTitleCenter.setText(titleCenter);
    }

    public void setImgTitleLeft(ImageView imgTitleLeft) {
        this.imgTitleLeft = imgTitleLeft;
        tvTitleLeft.setText(titleLeft);
    }

    public void setImgTitleRight(ImageView imgTitleRight) {
        this.imgTitleRight = imgTitleRight;
        tvTitleRight.setText(titleRight);
    }

    public void setTitleRightIcon(int titleRightIcon) {
        this.titleRightIcon = titleRightIcon;
        imgTitleRight.setImageResource(titleRightIcon);
    }

    public void setTitleLeftIcon(int titleLeftIcon) {
        this.titleLeftIcon = titleLeftIcon;
        imgTitleLeft.setImageResource(titleLeftIcon);
    }

    public void setTitleCenterColor(int titleCenterColor) {
        this.titleCenterColor = titleCenterColor;
        tvTitleCenter.setTextColor(titleCenterColor);
    }

    public void setTitleLeftColor(int titleLeftColor) {
        this.titleLeftColor = titleLeftColor;
        tvTitleLeft.setTextColor(titleLeftColor);
    }

    public void setTitleRightColor(int titleRightColor) {
        this.titleRightColor = titleRightColor;
        tvTitleRight.setTextColor(titleRightColor);
    }

    public TextView getTvTitleCenter() {
        return tvTitleCenter;
    }

    public TextView getTvTitleLeft() {
        return tvTitleLeft;
    }

    public TextView getTvTitleRight() {
        return tvTitleRight;
    }

    public ImageView getImgTitleLeft() {
        return imgTitleLeft;
    }

    public ImageView getImgTitleRight() {
        return imgTitleRight;
    }

}
