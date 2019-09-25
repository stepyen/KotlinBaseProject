package com.stepyen.commonsdk.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * date：2019-08-21
 * author：stepyen
 * description：基础分页数据
 *
 */

class BasePageList<T>{
    var total: Int = 0
    var size: Int = 0
    var current: Int = 0
    var searchCount: Boolean = false
    var pages: Int = 0
    var records: List<T> = arrayListOf()
}