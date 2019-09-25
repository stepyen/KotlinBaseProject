package com.stepyen.kotlinbaseproject.util

import android.content.Context
import android.os.Bundle
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import android.widget.LinearLayout
import com.alibaba.android.arouter.launcher.ARouter
import com.stepyen.xframe.http.imageloader.ImageLoader
import com.stepyen.xframe.utils.XFrameUtils
import com.stepyen.xui.widget.textview.supertextview.OptionItem
import com.stepyen.xutil.common.SpanUtils

/**
 * date：2019/8/7
 * author：stepyen
 * description：
 *
 */

fun navigation(path: String, context: Context? = null, bundle: Bundle? = null) {
    var postcard = ARouter
        .getInstance()
        .build(path)
        .with(bundle)
    if (context == null) {
        postcard.navigation()
    } else {
        postcard.navigation(context)
    }
}

fun getImageLoader(context: Context): ImageLoader {
    val appComponent = XFrameUtils.obtainAppComponentFromContext(context)
    return appComponent.imageLoader()
}



fun checkVisibility(view: View) {
    view.run {
        if (visibility == View.GONE) {
            visibility = View.VISIBLE
        }
    }
}

fun setVisibility(view: View?, visibility: Boolean) {
    view?.visibility = if (visibility) View.VISIBLE else View.GONE
}


fun dp2px(context: Context, dpValue: Float): Int {
    val scale = context.resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}


fun getLeftKeyValue(config: OptionItemConfig?): CharSequence {

    if (config == null) {
        return ""
    }

    return config.run {
        SpanUtils()
            .append(key)
            .setFontSize(keySize)
            .setForegroundColor(keyColor)

            .append(value)
            .setFontSize(valueSize)
            .setClickSpan(object : ClickableSpan() {
                override fun onClick(widget: View) {
                    clickListener.onClick(widget)
                }

                override fun updateDrawState(ds: TextPaint) {
                    ds.color = ds.linkColor
                    //去除超链接的下划线
                    ds.isUnderlineText = false
                }
            })
            .setForegroundColor(valueColor)
            .create()
    }

}
















