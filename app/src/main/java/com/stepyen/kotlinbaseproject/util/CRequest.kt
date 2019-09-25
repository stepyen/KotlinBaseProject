package com.stepyen.kotlinbaseproject.util

import com.stepyen.commonsdk.entity.BaseResponse
import com.stepyen.xframe.mvp.ILoadView
import com.stepyen.xframe.utils.RxLifecycleUtils
import com.stepyen.xutil.tip.ToastUtils
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import timber.log.Timber

/**
 * date：2019-08-16
 * author：stepyen
 * description：
 *
 */
class CRequest {
    companion object{
        fun <T : BaseResponse<*>> request(
            iView: ILoadView,
            rxErrorHandler: RxErrorHandler,
            observable: Observable<T>,
            showStatusView: Boolean = false,
            showDialog: Boolean = false,
            failAction:((String)->Unit)? = null,
            succeedAction: (T) -> Unit
        ) {
            if (showStatusView) {
                iView.showLoading()
            }

            if (showDialog) {
                iView.showLoadDialog()
            }


            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(iView))
                .subscribe(object : ErrorHandleSubscriber<T>(rxErrorHandler) {
                    override fun onNext(response: T) {
                        if (response.success) {
                            if (showStatusView) {
                                iView.showLoadSuccess()
                            }
                            succeedAction(response)
                        } else {
                            Timber.e(response.toString())

                            if (showStatusView) {
                                iView.showLoadFailed()
                            }

                            if (failAction == null) {
                                if (showDialog) {
                                    ToastUtils.toast(response.message)
                                }
                            }else{
                                response?.message?.let {
                                    failAction(it)
                                }
                            }
                        }

                        if (showDialog) {
                            iView.dismissLoadDialog()
                        }

                    }

                    override fun onError(t: Throwable) {
                        if (showStatusView) {
                            iView.showLoadFailed()
                        }

                        if (showDialog) {
                            iView.dismissLoadDialog()
                            ToastUtils.toast("数据请求错误")
                        }

                        Timber.e(t.message)
                    }
                })
        }


    }
}