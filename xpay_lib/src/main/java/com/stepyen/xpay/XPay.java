package com.stepyen.xpay;

import android.app.Activity;
import android.text.TextUtils;
import com.stepyen.xpay.alipay.Alipay;
import com.stepyen.xpay.unionpay.UPPay;
import com.stepyen.xpay.weixin.WeiXinPay;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 *
 * 微信、支付宝支付封装逻辑
 */
public class XPay {
    private static XPay mXPay;
    private Activity mContext;

    private XPay(Activity context) {
        mContext = context;
    }

    public static XPay getIntance(Activity context) {
        if (mXPay == null) {
            synchronized (XPay.class) {
                if (mXPay == null) {
                    mXPay = new XPay(context);
                }
            }
        }
        return mXPay;
    }

    public interface XPayListener {
        //支付成功
        void onPaySuccess();
        //支付失败
        void onPayError(int error_code, String message);
        //支付取消
        void onPayCancel();
        //银联支付结果回调
        void onUUPay(String dataOrg, String sign, String mode);
    }

    public enum PayMode {
        WXPAY, ALIPAY, UUPAY
    }

    public void toPay(PayMode payMode, String payParameters, XPayListener listener) {
        if (payMode.name().equalsIgnoreCase(PayMode.WXPAY.name())) {
            toWxPay(payParameters, listener);
        } else if (payMode.name().equalsIgnoreCase(PayMode.ALIPAY.name())) {
            toAliPay(payParameters, listener);
        } else if (payMode.name().equalsIgnoreCase(PayMode.UUPAY.name())) {
            toUUPay(payParameters,listener);
        }
    }


    public void toWxPay(String payParameters, XPayListener listener) {
        if (payParameters != null) {
            JSONObject param = null;
            try {
                param = new JSONObject(payParameters);
            } catch (JSONException e) {
                e.printStackTrace();
                if (listener != null) {
                    listener.onPayError(WeiXinPay.PAY_PARAMETERS_ERROE, "参数异常");
                }
                return;
            }
            if (TextUtils.isEmpty(param.optString("appId")) || TextUtils.isEmpty(param.optString("partnerId"))
                    || TextUtils.isEmpty(param.optString("prepayId")) || TextUtils.isEmpty(param.optString("nonceStr"))
                    || TextUtils.isEmpty(param.optString("timeStamp")) || TextUtils.isEmpty(param.optString("sign"))) {
                if (listener != null) {
                    listener.onPayError(WeiXinPay.PAY_PARAMETERS_ERROE, "参数异常");
                }
                return;
            }
            toWxPay(param.optString("appId"),
                    param.optString("partnerId"), param.optString("prepayId"),
                    param.optString("nonceStr"), param.optString("timeStamp"),
                    param.optString("sign"), listener);

        } else {
            if (listener != null) {
                listener.onPayError(WeiXinPay.PAY_PARAMETERS_ERROE, "参数异常");
            }
        }
    }

    public void toWxPay(String appId, String partnerId, String prepayId,
                        String nonceStr, String timeStamp, String sign, XPayListener listener) {
        if (TextUtils.isEmpty(appId) || TextUtils.isEmpty(partnerId)
                || TextUtils.isEmpty(prepayId) || TextUtils.isEmpty(nonceStr)
                || TextUtils.isEmpty(timeStamp) || TextUtils.isEmpty(sign)) {
            if (listener != null) {
                listener.onPayError(WeiXinPay.PAY_PARAMETERS_ERROE, "参数异常");
            }
            return;
        }
        WeiXinPay.getInstance(mContext).startWXPay(appId, partnerId, prepayId, nonceStr, timeStamp, sign, listener);
    }

    public void toAliPay(String payParameters, XPayListener listener) {
        if (payParameters != null) {
            if (listener != null) {
                Alipay.getInstance(mContext).startAliPay(payParameters, listener);
            }
        } else {
            if (listener != null) {
                listener.onPayError(Alipay.PAY_PARAMETERS_ERROE, "参数异常");
            }
        }
    }

    public void toUUPay(String payParameters, XPayListener listener) {
        if (payParameters != null) {
            JSONObject param = null;
            try {
                param = new JSONObject(payParameters);
            } catch (JSONException e) {
                e.printStackTrace();
                if (listener != null) {
                    listener.onPayError(UPPay.PAY_PARAMETERS_ERROE, "参数异常");
                }
                return;
            }
            if (TextUtils.isEmpty(param.optString("mode")) || TextUtils.isEmpty(param.optString("tn"))){
                if (listener != null) {
                    listener.onPayError(UPPay.PAY_PARAMETERS_ERROE, "参数异常");
                }
                return;
            }
            toUUPay(param.optString("mode"),
                    param.optString("tn"), listener);
        } else {
            if (listener != null) {
                listener.onPayError(WeiXinPay.PAY_PARAMETERS_ERROE, "参数异常");
            }
        }
    }

    public void toUUPay(String mode, String tn, XPayListener listener) {
        if (listener == null) {
            listener.onPayError(UPPay.PAY_PARAMETERS_ERROE, "参数异常");
            return;
        }
        if (TextUtils.isEmpty(mode)) {
            mode = "00";
        }
        if (TextUtils.isEmpty(tn)) {
            listener.onPayError(UPPay.PAY_PARAMETERS_ERROE, "参数异常");
            return;
        }
        UPPay.getInstance(mContext).startUPPay(mode, tn, listener);
    }
}
