package com.stepyen.kotlinbaseproject.copy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stepyen.kotlinbaseproject.MainActivity
import com.stepyen.kotlinbaseproject.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * date：2019/8/8
 * author：stepyen
 * description：
 *
 */

class Copy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*点击事件*/
        testTv.setOnClickListener {
            startActivity(Intent(this, MainActivity().javaClass))
        }




    }
}

