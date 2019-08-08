package com.stepyen.commonsdk.gloading;
import android.view.View;
import com.billy.android.loading.Gloading;
import com.stepyen.commonsdk.widget.GloadingStatusView;

/**
 * date：2019/4/15
 * author：stepyen
 * description：
 */
public class GlobalAdapter implements Gloading.Adapter {

    @Override
    public View getView(Gloading.Holder holder, View convertView, int status) {

        GloadingStatusView loadingStatusView = null;
        //reuse the old view, if possible
        if (convertView != null && convertView instanceof GloadingStatusView) {
            loadingStatusView = (GloadingStatusView) convertView;
        }
        if (loadingStatusView == null) {
            loadingStatusView = new GloadingStatusView(holder.getContext(), holder.getRetryTask());
        }
        loadingStatusView.setStatus(status);

        return loadingStatusView;
    }

}
