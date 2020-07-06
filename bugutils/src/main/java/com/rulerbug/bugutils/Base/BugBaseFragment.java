package com.rulerbug.bugutils.Base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public abstract class BugBaseFragment extends Fragment {

    private ViewGroup parent;

    private View mView;


    public final ViewGroup getParent() {
        return this.parent;
    }

    public final void setParent(ViewGroup var1) {
        this.parent = var1;
    }


    public final View getMView() {
        return this.mView;
    }

    public final void setMView(View var1) {
        this.mView = var1;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (this.mView == null) {
            this.mView = inflater.inflate(this.getLayoutId(), (ViewGroup) null);
        }



        this.parent = (ViewGroup)  this.mView.getParent();
        if (this.parent != null) {
      ;


            this.parent.removeView(this.mView);
        }

        return this.mView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);


        this.initViews(this.mView);
    }

    public abstract int getLayoutId();

    public abstract void initViews(View var1);
}