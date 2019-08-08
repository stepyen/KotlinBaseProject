package com.stepyen.commonsdk.widget;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.billy.android.loading.Gloading;
import com.stepyen.commonsdk.R;


/**
 * date：2019/4/18
 * author：stepyen
 * description：
 */
public class GloadingStatusView extends FrameLayout {
    private final Runnable mRetryTask;
    private View mLoadingView;
    private View mErrorView;
    private View mNetErrorView;
    private View mEmptyView;
    private Context mContext;

    public GloadingStatusView(Context context, Runnable retryTask ) {
        super(context);
        this.mContext = context;
        this.mRetryTask = retryTask;
    }

    public void setStatus(int status) {
        removeAllViews();
        boolean isShow = false;
        switch (status) {
            case Gloading.STATUS_LOADING:
                if (mLoadingView == null) {
                    mLoadingView = LayoutInflater.from(mContext).inflate(R.layout.public_view_loading, null);

                }
                addView(mLoadingView);
                break;
            case Gloading.STATUS_LOAD_SUCCESS:
                isShow = true;
                break;
            case Gloading.STATUS_LOAD_FAILED:
                if (isNetworkConnected(mContext)) {
                    if (mErrorView == null) {
                        mErrorView = LayoutInflater.from(mContext).inflate(R.layout.public_view_error, null);
                        Button errorBtn = (Button) mErrorView.findViewById(R.id.btn_error);
                        errorBtn.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (mRetryTask != null) {
                                    mRetryTask.run();
                                }
                            }
                        });
                    }

                    addView(mErrorView);
                }else{
                    if (mNetErrorView == null) {
                        mNetErrorView = LayoutInflater.from(mContext).inflate(R.layout.public_view_net_error, null);
                        Button netErrorBtn = (Button) mNetErrorView.findViewById(R.id.common_neterror_refresh);
                        netErrorBtn.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (mRetryTask != null) {
                                    mRetryTask.run();
                                }
                            }
                        });

                    }
                    addView(mNetErrorView);
                }

                break;
            case Gloading.STATUS_EMPTY_DATA:
                if (mEmptyView == null) {
                    mEmptyView = LayoutInflater.from(mContext).inflate(R.layout.public_view_empty, null);
                }

                addView(mEmptyView);
                break;
        }

        setVisibility(isShow ? View.GONE:View.VISIBLE);
    }

    public  Boolean isNetworkConnected(Context context) {
        try {
            context = context.getApplicationContext();
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo networkInfo = cm.getActiveNetworkInfo();
                return networkInfo != null && networkInfo.isConnected();
            }
        } catch (Exception ignored) {
        }
        return false;
    }

}
