package com.stepyen.commonsdk.extend

import com.stepyen.xui.utils.DensityUtils
import com.stepyen.xui.utils.ResUtils

/**
 * date：2019-08-11
 * author：stepyen
 * description：
 *
 */


fun Float.dp2px() :Int{
   return DensityUtils.dp2px(this)
}

fun Float.dx2dp() :Int{
    return DensityUtils.px2dp(this)
}


fun Float.sp2px() :Int{
    return DensityUtils.sp2px(this)
}
