package com.stepyen.module.gank;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.stepyen.commonsdk.constant.RouterHub;

import butterknife.ButterKnife;

/**
 * date：2019/6/13
 * author：stepyen
 * description：
 */
@Route(path = RouterHub.GANK_HOMEACTIVITY)
public class GankMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gank_activity_main);
        ButterKnife.bind(this);

    }
}
