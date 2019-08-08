package com.stepyen.module.zhihu;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.stepyen.commonsdk.constant.RouterHub;

/**
 * date：2019/6/14
 * author：stepyen
 * description：
 */
@Route(path = RouterHub.ZHIHU_HOMEACTIVITY)
public class ZhihuMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhihu_activity_main);

    }
}
