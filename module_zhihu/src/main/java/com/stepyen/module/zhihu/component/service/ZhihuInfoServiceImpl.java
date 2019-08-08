package com.stepyen.module.zhihu.component.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.stepyen.commonsdk.constant.RouterHub;
import com.stepyen.commonservice.zhihu.bean.ZhihuInfo;
import com.stepyen.commonservice.zhihu.service.ZhihuInfoService;
import com.stepyen.xframe.utils.XFrameUtils;

/**
 * date：2019/6/14
 * author：stepyen
 * description：
 */
@Route(path = RouterHub.ZHIHU_SERVICE_ZHIHUINFOSERVICE, name = "知乎信息服务")
public class ZhihuInfoServiceImpl implements ZhihuInfoService {
    private Context mContext;

    @Override
    public ZhihuInfo getInfo() {
        return new ZhihuInfo(XFrameUtils.getString( "知乎日报"));
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}
