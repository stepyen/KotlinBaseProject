package com.stepyen.kotlinbaseproject.util

import android.view.View
import android.widget.LinearLayout
import com.stepyen.kotlinbaseproject.R
import com.stepyen.xui.utils.ResUtils
import com.stepyen.xutil.display.DensityUtils

/**
 * date：2019/8/7
 * author：stepyen
 * description：
 *
 */
class OptionItemConfig {
    var width: Int = LinearLayout.LayoutParams.MATCH_PARENT
        set(value) {
            field = ResUtils.getDimensionPixelSize(value)
        }

    var height: Int = DensityUtils.dp2px(45f)
        set(value) {
            field = ResUtils.getDimensionPixelSize(value)
        }

    var key: String = ""
    var value: String = ""
    var keyColor: Int = ResUtils.getColor(R.color.public_big_title)
        set(value) {
            field = ResUtils.getColor(value)
        }
    var valueColor: Int = ResUtils.getColor(R.color.public_subtitle)
        set(value) {
            field = ResUtils.getColor(value)
        }
    var keySize: Int = ResUtils.getDimensionPixelSize(R.dimen.public_subtitle)
        set(value) {
            field = ResUtils.getDimensionPixelSize(value)
        }
    var valueSize: Int = ResUtils.getDimensionPixelSize(R.dimen.public_subtitle)
        set(value) {
            field = ResUtils.getDimensionPixelSize(value)
        }
    var hasArrow: Boolean = false
    var hasBottomLine: Boolean = false
    var isLeftKeyValue: Boolean = false
    lateinit var clickListener: View.OnClickListener


    companion object{

        fun getLeftKeyValue(): OptionItemConfig {
            return OptionItemConfig().apply {
                height = R.dimen.public_option_leftKeyValue_height
                isLeftKeyValue  = true
                keyColor = R.color.public_subtitle
                keySize = R.dimen.public_subtitle
                valueSize = R.dimen.public_subtitle
                valueColor = R.color.public_big_title
            }
        }


        fun getHasArrow(): OptionItemConfig {
            return OptionItemConfig().apply {
                hasArrow  = true
                hasBottomLine  = true
                keyColor = R.color.public_big_title
                keySize = R.dimen.public_subtitle
                valueSize = R.dimen.public_subtitle
                valueColor = R.color.public_big_title
            }
        }




    }

}