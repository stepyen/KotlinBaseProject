package com.stepyen.commonsdk.extend

import com.stepyen.xui.utils.DensityUtils
import com.stepyen.xui.utils.ResUtils

/**
 * date：2019-08-11
 * author：stepyen
 * description：
 *
 */


fun Int.dp2px() :Int{
   return DensityUtils.dp2px(this.toFloat())
}

fun Int.dx2dp() :Int{
    return DensityUtils.px2dp(this.toFloat())
}

fun Int.sp2px() :Int{
    return DensityUtils.sp2px(this.toFloat())
}
