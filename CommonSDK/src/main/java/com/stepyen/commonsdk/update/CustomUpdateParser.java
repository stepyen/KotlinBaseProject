package com.stepyen.commonsdk.update;

import com.stepyen.commonsdk.entity.UpdateWrap;
import com.stepyen.xutil.app.AppUtils;
import com.stepyen.xutil.net.JsonUtil;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.proxy.IUpdateParser;

/**
 * date：2019-06-23
 * author：stepyen
 * description：自定义版本更新解析器
 */
public class CustomUpdateParser implements IUpdateParser {
    @Override
    public UpdateEntity parseJson(String json) throws Exception {

        UpdateWrap result = JsonUtil.fromJson(json, UpdateWrap.class);
        if (result != null) {
            return new UpdateEntity()
                    .setHasUpdate(AppUtils.getAppVersionCode()!=result.getVersioncode())
                    .setForce(result.getForceupdate())
                    .setVersionCode(result.getVersioncode())
                    .setVersionName(result.getVersionname())
                    .setUpdateContent(result.getContent())
                    .setDownloadUrl(result.getFilepath());
        }

        return null;
    }
}
