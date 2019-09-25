package com.stepyen.kotlinbaseproject.util

import com.stepyen.commonsdk.utils.MoneyConfig

/**
 * date：2019-08-16
 * author：stepyen
 * description：
 *
 */
class CMoney {
    companion object{
        fun common(
            moneySymbol:String = "￥",
            prefix:String = ""     ,//  添加前缀 "-" 如：-￥20.00
            postfix:String = ""  ,   //  添加后缀 "起" 如：￥20.00 起
            money:String= "",
            isSymbolScale :Boolean= false ,  // moneySymbol 符号是否缩放
            isDecimalsScale  :Boolean= false  , // 小数点后面数字是否缩放
            isSave2DecimalsMoney  :Boolean= false
        ): CharSequence {
            return MoneyConfig().apply {
                this.moneySymbol = moneySymbol
                this.prefix = prefix
                this.postfix = postfix
                this.money = money
                this.isSymbolScale = isSymbolScale
                this.isDecimalsScale = isDecimalsScale
                this.isSave2DecimalsMoney = isSave2DecimalsMoney
            }.build()
        }



        /**
         * ¥100 ，¥缩放
         */
        fun getIsSymbolScaleMoney(money: String): CharSequence = common(isSymbolScale = true, money = money)

        /**
         * 报名费 ¥100     ¥缩放
         */
        fun getApplyMoney(money: String): CharSequence  =common(prefix = "报名费 ",isSymbolScale = true, money = money)



    }

}