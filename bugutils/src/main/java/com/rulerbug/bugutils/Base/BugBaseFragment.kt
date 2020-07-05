package com.rulerbug.qmuidemo.qmuidemo.Base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

open abstract class BugBaseFragment : androidx.fragment.app.Fragment() {
    var parent: ViewGroup? = null
    var mView: View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mView == null) {
            mView = inflater.inflate(getLayoutId(), null);
        }
        parent = mView!!.parent as ViewGroup?
        if (parent != null) {
            parent!!.removeView(mView);
        }
        return mView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(mView!!)
    }

    open abstract fun getLayoutId(): Int
    open abstract fun initViews(rootView: View)
}