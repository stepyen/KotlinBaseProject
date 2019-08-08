package com.stepyen.commonsdk.base;

import android.view.View;
import com.stepyen.xframe.base.BaseLoadActivity;
import com.stepyen.xframe.mvp.IPresenter;
import com.stepyen.xui.widget.actionbar.TitleUtils;
import com.stepyen.xui.widget.dialog.MiniLoadingDialog;

/**
 * date：2019-07-07
 * author：stepyen
 * description：
 */
public abstract class AppBaseActivity<P extends IPresenter> extends BaseLoadActivity<P> {

    protected MiniLoadingDialog mLoadingDialog;

    @Override
    protected View initTitleBar() {
        return TitleUtils.initTitleBarDynamic(this, (String) getTitle(), v -> {
            finish();
        });
    }

    public void showLoadDialog() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new MiniLoadingDialog(this);
        }
        mLoadingDialog.show();

    }

    public void dismissLoadDialog() {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }

    public void killMyself() {
        finish();
    }

}
