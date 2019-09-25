package com.stepyen.kotlinbaseproject.util

import android.widget.ImageView
import com.stepyen.commonsdk.http.Api
import com.stepyen.kotlinbaseproject.R
import com.stepyen.xframe.http.imageloader.ImageLoader
import com.stepyen.xframe.http.imageloader.glide.ImageConfigImpl

/**
 * date：2019-08-16
 * author：stepyen
 * description：
 *
 */
class CImageLoad {
    companion object{
        fun loadImage(imageLoader: ImageLoader, imageView: ImageView, url: String?) {
            val imageConfig = ImageConfigImpl
                .builder()
                .url(Api.APP_IMAGE + url)
                .errorPic(R.color.public_image_error)
                .placeholder(R.color.public_image_error)
                .fallback(R.color.public_image_error)
                .imageView(imageView)
                .build()
            imageLoader.loadImage(imageView.context, imageConfig)
        }
    }

}