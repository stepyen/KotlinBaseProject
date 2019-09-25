package com.stepyen.commonsdk.extend

import android.content.Context
import androidx.annotation.StringRes
import com.stepyen.xui.utils.ResUtils

/**
 * date：2019-08-11
 * author：stepyen
 * description：
 *
 */



fun String.Companion.stringFormat(resId: Int, vararg args: Any?) = String.format(ResUtils.getString(resId), *args)
