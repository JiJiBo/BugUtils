package com.pinyue.zcf.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * 公司：江苏再出发网络科技有限公司
 * 作者：Android 倪震宇
 * 创建时间：2020/11/27
 * 功能描述：
 */
abstract class BugBindingBaseFragment<DATA_BINDING : ViewDataBinding> : Fragment() {
    var parent: ViewGroup? = null
    var mView: View? = null
    lateinit var mBinging: DATA_BINDING
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (this.mView == null) {
            this.mView = inflater.inflate(layoutId, null as ViewGroup?)
        }
        parent = this.mView!!.parent as ViewGroup
        if (parent != null) {
            parent!!.removeView(this.mView)
        }
        return this.mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.mBinging =
            DataBindingUtil.bind<DATA_BINDING>(mView!!)!!
        initViews(this.mView)
    }

    abstract val layoutId: Int
    abstract fun initViews(var1: View?)
}