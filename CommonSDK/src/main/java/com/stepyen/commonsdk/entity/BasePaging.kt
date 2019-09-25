package com.stepyen.commonsdk.entity

/**
 * date：2019/9/5
 * author：stepyen
 * description：
 *
 */
class BasePaging<T> {
    val total: Int = 0
    val size: Int = 0
    val current: Int = 0
    val searchCount: Boolean = false
    val pages: Int = 0
    val records: List<T>? = null
}