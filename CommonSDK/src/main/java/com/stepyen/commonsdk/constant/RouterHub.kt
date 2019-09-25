package com.stepyen.commonsdk.constant

/**
 * date：2019/5/18
 * author：stepyen
 * description：ARouter 路由地址
 */
interface RouterHub {
    companion object {

        /**
         * 组名
         */
        const val APP  = "/app"//宿主 App 组件
        /**
         * 服务组件, 用于给每个组件暴露特有的服务
         */
        const val SERVICE = "/service"

        /**
         * 自定义解析json类
         */
        const val JsonServiceImpl = "/APP/json"

        /**
         * 宿主 App 分组
         */
        /**
         * 宿主 App 分组
         */
        const val CopyActivity = "/APP/CopyActivity"
        const val SplashActivity = "/APP/SplashActivity"
        const val MainActivity = "/APP/MainActivity"
        const val LoginActivity = "/APP/LoginActivity"
        const val EvaluateActivity = "/APP/EvaluateActivity"





        const val ZHIHU = "/zhihu"//知乎组件
        const val GANK = "/gank"//干货集中营组件


        /**
         * 知乎分组
         */
        const val ZHIHU_SERVICE_ZHIHUINFOSERVICE = "/zhihu/service/ZhihuInfoService"

        const val ZHIHU_HOMEACTIVITY = "/zhihu/HomeActivity"
        const val ZHIHU_DETAILACTIVITY = "/zhihu/DetailActivity"

        /**
         * 干货集中营分组
         */
        const val GANK_SERVICE_GANKINFOSERVICE = "/gank/service/GankInfoService"

        const val GANK_HOMEACTIVITY = "/gank/HomeActivity"
    }


}
