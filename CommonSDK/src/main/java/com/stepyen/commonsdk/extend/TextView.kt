package com.stepyen.commonsdk.extend

import android.graphics.Paint
import android.widget.TextView
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG as STRIKE_THRU_TEXT_FLAG1

/**
 * date：2019-08-11
 * author：stepyen
 * description：
 *
 */
/**
 * 获取文本
 */
fun TextView.trim():String {
    return this.text.toString().trim()
}

/**
 * 设置删除线
 */
fun TextView.strickout() {
    this.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
}


fun TextView.setTextAndCheckVisibility(charSequence: CharSequence?) {
    charSequence?.let {
        if (it.isNotEmpty()) {
            text = charSequence
            checkVisibility()
        }
    }
}




