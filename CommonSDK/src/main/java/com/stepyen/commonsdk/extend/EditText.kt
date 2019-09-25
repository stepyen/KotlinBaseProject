package com.stepyen.commonsdk.extend

import android.text.InputFilter
import android.text.InputType
import android.widget.EditText

/**
 * date：2019-08-11
 * author：stepyen
 * description：
 *
 */
/**
 * 设置文本，并且光标置于最后面
 */
fun EditText.setTextAndSelection(charSequence: CharSequence) {
    this.run {
        setText(charSequence)
        setSelection(text.length)
    }
}

/**
 * 设置输入类型为密码
 */
fun EditText.setInputTypePassword() {
    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
}

/**
 *
 * 配置电话类型
 *
 */
fun EditText.setupTypePhone() {
    filters = arrayOf(InputFilter.LengthFilter(11))
    inputType = InputType.TYPE_CLASS_NUMBER
}

/**
 *
 * 配置验证码类型
 *
 */
fun EditText.setupTypeVerificationCode() {
    filters = arrayOf(InputFilter.LengthFilter(6))
    inputType = InputType.TYPE_CLASS_NUMBER
}


