package com.stepyen.commonsdk.utils;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;
import com.stepyen.commonsdk.constant.RouterHub;

import java.lang.reflect.Type;

/**
 * date：2019/4/25
 * author：stepyen
 * description：传递自定义对象需要实现
 */
@Route(path = RouterHub.JsonServiceImpl)
public class JsonServiceImpl implements SerializationService {


    @Override
    public <T> T json2Object(String input, Class<T> clazz) {
        return new Gson().fromJson(input, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        return new Gson().toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        return new Gson().fromJson(input, clazz);
    }

    @Override
    public void init(Context context) {

    }
}
