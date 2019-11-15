package com.stepyen.commonsdk.utils

import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.RelativeSizeSpan
import com.stepyen.commonsdk.R
import com.stepyen.commonsdk.extend.stringFormat
import kotlin.Double as Double1
/**
 * date：2019/8/16
 * author：stepyen
 * description：金钱配置工具
 *
 */
class MoneyConfig() {
    var moneySymbol = "￥"
    var prefix = ""     //  添加前缀 "-" 如：-￥20.00
    var postfix = ""     //  添加后缀 "起" 如：￥20.00 起
    var money:String = ""
    var isSymbolScale = false   // moneySymbol 符号是否缩放
    var isDecimalsScale = false   // 小数点后面数字是否缩放
    var isSave2DecimalsMoney = false

    fun build():CharSequence{
        return SpannableStringBuilder().apply {
            if (prefix.isNotEmpty()) {
                append(prefix)
            }

            if (moneySymbol.isNotEmpty()) {
               append(SpannableString(moneySymbol).apply {
                   if (isSymbolScale) {
                       setSpan(RelativeSizeSpan(0.8f),0,moneySymbol.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
                   }
               })
            }

            val split = handleMoney().split("\\.")   // 3.12
            for (i in split.indices) {
                when (i) {
                    0->append(split[0])
                    1->append(".").append(SpannableString(split[1]).apply {
                        if (isDecimalsScale) {
                            setSpan(RelativeSizeSpan(0.8f),0,split[1].length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
                        }
                    })
                }
            }

            if (postfix.isNotEmpty()) {
                append(postfix)
            }
        }
    }

    private fun handleMoney():CharSequence {
        if (money.isEmpty()) {
            money = "0"
        }

        return if (isSave2DecimalsMoney) {
            String.stringFormat(R.string.common_money,money.toDouble())
        }else{
            money.toInt().toString()
        }
    }

}