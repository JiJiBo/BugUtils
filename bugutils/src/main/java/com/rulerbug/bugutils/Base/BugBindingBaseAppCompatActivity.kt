package com.pinyue.zcf.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.rulerbug.bugutils.Base.BugBaseActivity
import com.rulerbug.bugutils.Base.BugBaseAppCompatActivity


/**
 * 公司：江苏再出发网络科技有限公司
 * 作者：Android 倪震宇
 * 创建时间：2020/11/27
 * 功能描述：
 */
abstract class BugBindingBaseAppCompatActivity<BINDING : ViewDataBinding> : BugBaseAppCompatActivity() {
    lateinit var mBinging: BINDING
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.mBinging =
            DataBindingUtil.setContentView<BINDING>(this, getLayoutId())
        main()
    }

    abstract fun main()
    abstract fun getLayoutId(): Int
}