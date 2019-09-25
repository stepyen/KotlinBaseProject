package com.stepyen.commonsdk.entity

import java.io.Serializable

/**
 * 服务端返回封装基础类
 * @param <T>
</T> */
class BaseResponse<T> {

    var result: T? = null
    var code: Int = 0
    var message: String? = null
    var success = false
    var timestamp: Long? = 0L



    override fun toString(): String {
        return "BaseResponse{" +
                "result=" + result +
                ", code=" + code +
                ", message='" + message + '\''.toString() +
                ", success=" + success +
                ", timestamp=" + timestamp +
                '}'.toString()
    }
}
