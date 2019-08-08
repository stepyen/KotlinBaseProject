package com.stepyen.kotlinbaseproject.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import butterknife.ButterKnife
import com.stepyen.kotlinbaseproject.util.getImageLoader
import com.stepyen.xframe.http.imageloader.ImageLoader
import com.stepyen.xframe.utils.XFrameUtils

/**
 * date：2019/8/7
 * author：stepyen
 * description：
 *
 */
abstract class BaseFrameLayout : FrameLayout {

    lateinit var mContext: Context
    lateinit var mView: View
    val mImageLoader: ImageLoader by lazy {
        getImageLoader(mContext)
    }

    constructor(context: Context) : super(context, null)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        this.mContext = context

        mView = XFrameUtils.inflate(context, getLayoutId())
        addView(mView)
        ButterKnife.bind(this, mView)
        init(attrs, defStyle)
    }

    abstract fun getLayoutId(): Int
    abstract fun init(attrs: AttributeSet, defStyle: Int)

}