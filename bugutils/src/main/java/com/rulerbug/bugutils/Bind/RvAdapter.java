package com.rulerbug.bugutils.Bind;

import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.nas.nasbaselibrary.config.GlideRoundTransform;
import com.rulerbug.bugutils.Utils.BugApp;

public class RvAdapter {

    @BindingAdapter(value = {"bindRv"})
    public static void bindLinear(RecyclerView rv, Object o) {
        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL));
    }

    @BindingAdapter(value = {"bindRvNoDiv"})
    public static void bindRvNoDiv(RecyclerView rv, Object o) {
        rv.setLayoutManager(new LinearLayoutManager(rv.getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @BindingAdapter(value = {"bindGRv"})
    public static void bindGridle(RecyclerView rv, int i) {
        rv.setLayoutManager(new GridLayoutManager(rv.getContext(), i));

    }

    @BindingAdapter(value = {"bind4GRv"})
    public static void bind4GRv(RecyclerView rv, Object o) {
        rv.setLayoutManager(new GridLayoutManager(rv.getContext(), 4));

    }

    @BindingAdapter(value = {"bind3GRv"})
    public static void bind3GRv(RecyclerView rv, Object o) {
        ;

    }

    @BindingAdapter(value = {"bindFlow"})
    public static void bindFlow(RecyclerView rv, Object o) {
        rv.setLayoutManager(new FlexboxLayoutManager(rv.getContext()));

    }


    @BindingAdapter(value = {"bindIvImg"})
    public static void bindIvImg(ImageView iv, int i) {
        Glide.with(iv).load(i).into(iv);
    }

    @BindingAdapter(value = {"bindIvImg"})
    public static void bindIvImg(ImageView iv, String i) {

        Glide.with(iv).load(i).into(iv);

    }

    @BindingAdapter(value = {"bindRoundIvImg"})
    public static void bindRoundIvImg(ImageView iv, int i) {

        Glide.with(iv).load(i).circleCrop().into(iv);

    }


    @BindingAdapter(value = {"bindRoundIvImg"})
    public static void bindRoundIvImg(ImageView iv, String i) {

        Glide.with(iv).load(i).circleCrop().into(iv);

    }

    @BindingAdapter(value = {"bindRadioIvImg"})
    public static void bindRadioIvImg(ImageView iv, String i) {
        RequestOptions myOptions = new RequestOptions()
                .transform(new GlideRoundTransform(BugApp.getContext(), 8));
        Glide.with(iv).load(i).apply(myOptions).into(iv);

    }

    @BindingAdapter(value = {"bindDelTv"})
    public static void bindDelTv(TextView iv, Object i) {
        iv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

    }


}
