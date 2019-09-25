package com.stepyen.commonsdk.extend

import android.view.View

/**
 * date：2019-08-11
 * author：stepyen
 * description：
 *
 */
/**
 * 检查View的可见性，并设置为可见
 */
fun View.checkVisibility() {
    this.run {
        if (visibility == View.GONE) {
            visibility = View.VISIBLE
        }
    }
}

/**
 *
 * 设置View的可见性
 */
fun View.setVisibility(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.GONE
}
