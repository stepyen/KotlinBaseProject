package com.stepyen.commonsdk.constant;

/**
 * date：2019/5/18
 * author：stepyen
 * description：ARouter 路由地址
 */
public interface RouterHub {



//    服务



    /**
     * 组名
     */
    String APP = "/app";//宿主 App 组件
    String ZHIHU = "/zhihu";//知乎组件
    String GANK = "/gank";//干货集中营组件

    /**
     * 服务组件, 用于给每个组件暴露特有的服务
     */
    String SERVICE = "/service";

    /**
     *  自定义解析json类
     */
    String JsonServiceImpl = APP+"/json";


    /**
     * 宿主 App 分组
     */
    String SPLASHACTIVITY = APP + "/SplashActivity";
    String MAINACTIVITY = APP + "/MainActivity";

    String HomePlatHintDetailActivity = APP + "/HomePlatHintDetailActivity";



    /**
     * 知乎分组
     */
    String ZHIHU_SERVICE_ZHIHUINFOSERVICE = ZHIHU + SERVICE + "/ZhihuInfoService";

    String ZHIHU_HOMEACTIVITY = ZHIHU + "/HomeActivity";
    String ZHIHU_DETAILACTIVITY = ZHIHU + "/DetailActivity";

    /**
     * 干货集中营分组
     */
    String GANK_SERVICE_GANKINFOSERVICE = GANK + SERVICE + "/GankInfoService";

    String GANK_HOMEACTIVITY = GANK + "/HomeActivity";



}
