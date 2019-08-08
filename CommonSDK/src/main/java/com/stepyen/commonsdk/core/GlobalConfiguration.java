/*
 * Copyright 2018 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stepyen.commonsdk.core;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.stepyen.commonsdk.BuildConfig;
import com.stepyen.commonsdk.http.Api;
import com.stepyen.commonsdk.http.SSLSocketClient;
import com.stepyen.xframe.base.delegate.AppLifecycles;
import com.stepyen.xframe.di.module.ClientModule;
import com.stepyen.xframe.di.module.GlobalConfigModule;
import com.stepyen.xframe.http.imageloader.glide.GlideImageLoaderStrategy;
import com.stepyen.xframe.http.log.RequestInterceptor;
import com.stepyen.xframe.integration.ConfigModule;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.OkHttpClient;
import timber.log.Timber;


/**
 * ================================================
 * CommonSDK 的 GlobalConfiguration 含有有每个组件都可公用的配置信息, 每个组件的 AndroidManifest 都应该声明此 ConfigModule
 */
public class GlobalConfiguration implements ConfigModule {

    @Override
    public void applyOptions(Context context, GlobalConfigModule.Builder builder) {
        //Release 时,让框架不再打印 Http 请求和响应的信息
        if (!BuildConfig.LOG_DEBUG)
            builder.printHttpLogLevel(RequestInterceptor.Level.NONE);


        builder.baseurl(Api.APP_DOMAIN)
                .imageLoaderStrategy(new GlideImageLoaderStrategy())
                .globalHttpHandler(new GlobalHttpHandlerImpl(context))
                .responseErrorListener(new ResponseErrorListenerImpl())
                .gsonConfiguration((context1, gsonBuilder) -> {//这里可以自己自定义配置Gson的参数
                    gsonBuilder
                            .serializeNulls()//支持序列化null的参数
                            .enableComplexMapKeySerialization();//支持将序列化key为object的map,默认只能序列化key为string的map
                })
                .okhttpConfiguration(new ClientModule.OkhttpConfiguration() {
                    @Override
                    public void configOkhttp(Context context, OkHttpClient.Builder builder) {
                        builder.writeTimeout(10, TimeUnit.SECONDS);
                        builder.sslSocketFactory(SSLSocketClient.getSSLSocketFactory(), SSLSocketClient.getTrustManager());
                        builder.hostnameVerifier(SSLSocketClient.getHostnameVerifier());
                        //使用一行代码监听 Retrofit／Okhttp 上传下载进度监听,以及 Glide 加载进度监听, 详细使用方法请查看 https://github.com/JessYanCoding/ProgressManager
//                        ProgressManager.getInstance().with(okhttpBuilder);

                        // 多个baseurl
                        RetrofitUrlManager.getInstance().with(builder);
//                        RetrofitUrlManager.getInstance().putDomain(Api.KEY_APP_DOMAIN_NAME, AppService.APP_BASE_URL);
//                        RetrofitUrlManager.getInstance().putDomain(Api.KEY_EXPERT_DOMAIN_NAME, ExpertService.EXPERT_BASE_URL);
//                        RetrofitUrlManager.getInstance().putDomain(Api.KEY_RONG_DOMAIN_NAME, RongService.BASE_URL);
                    }
                })
                .rxCacheConfiguration((context1, rxCacheBuilder) -> {//这里可以自己自定义配置RxCache的参数
                    rxCacheBuilder.useExpiredDataIfLoaderNotAvailable(true);
                    return null;
                });
    }

    @Override
    public void injectAppLifecycle(Context context, List<AppLifecycles> lifecycles) {
        lifecycles.add(new AppLifecyclesImpl());
    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {
        lifecycles.add(new ActivityLifecycleCallbacksImpl());
    }

    @Override
    public void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {
        lifecycles.add(new FragmentLifecycleCallbacksImpl());
    }
}
