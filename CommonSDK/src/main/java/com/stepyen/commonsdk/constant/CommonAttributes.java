package com.stepyen.commonsdk.constant;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 创建时间：2018/5/4
 * 作者：yfj
 * 描述：构建请求头参数 common
 * <p>
 * common: {
 * "cpu":"arm64-v8a",
 * "dm":"vivo X9i",
 * "imei":"864534031472700",
 * "mt":"android",
 * "nt":"10",
 * "osv":"7.1.1",
 * "rslt":"1080*1920",
 * "ts":"1525418710",
 * "vc":"1300",
 * "vn":"1.3.0"}
 */

public class CommonAttributes {

    private TreeMap<String, String> mCommonParams = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    });

    /**
     * 初始化 mCommonParams
     */
    public void initCommonAttributes() {
//        putCommon("mt", SystemConst.MT);
//        putCommon("vc", SystemVal.versionCode + "");
//        putCommon("vn", SystemVal.versionName);
//        putCommon("imei", SystemVal.imei);
//        putCommon("osv", SystemVal.firmwareVersion);
//        putCommon("nt", SystemVal.nt);
//        putCommon("dm", SystemVal.model);
//        putCommon("imsi", SystemVal.imsi);
//        putCommon("ts", SystemVal.ts + "");
//        putCommon("rslt", SystemVal.resolution);
//        putCommon("cpu", SystemVal.abi);
//        putCommon("gpu", SystemVal.getGPU());
    }

    private void putCommon(String key, String value) {
        if (!TextUtils.isEmpty(value)) {
            mCommonParams.put(key, value);
        }
    }

    /**
     * 拼接 map 为json 字符串
     *
     * @return
     */
    public String getCommonAttributesStr() {
        JSONObject jsonObject =  new JSONObject();
        try {
            for (Map.Entry<String, String> entry : mCommonParams.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }

}
