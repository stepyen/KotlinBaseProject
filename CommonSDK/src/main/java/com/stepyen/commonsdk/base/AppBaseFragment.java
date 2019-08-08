package com.stepyen.commonsdk.base;

import android.view.View;

import com.stepyen.xframe.base.BaseLoadActivity;
import com.stepyen.xframe.base.BaseLoadFragment;
import com.stepyen.xframe.mvp.IPresenter;
import com.stepyen.xui.widget.actionbar.TitleUtils;
import com.stepyen.xui.widget.dialog.MiniLoadingDialog;

/**
 * date：2019-07-07
 * author：stepyen
 * description：
 */

public abstract class AppBaseFragment<P extends IPresenter> extends BaseLoadFragment<P> {

    protected MiniLoadingDialog mLoadingDialog;

    @Override
    protected View initTitleBar() {

        return TitleUtils.initTitleBarDynamic(getContext(), (String) getTitle(), v -> {
            getActivity().finish();
        });
    }


    public void showLoadDialog() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new MiniLoadingDialog(getContext());
        }
        mLoadingDialog.show();

    }

    public void dismissLoadDialog() {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }

    public void killMyself() {
        getActivity().finish();
    }

}