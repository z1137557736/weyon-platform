package com.weyon.framework.constant;

/**
 * @author liuxu
 * @description redis cache key静态常量类
 * @date 2019-05-20
 **/
public class RedisConstant {

    /**
     * 用户登录key值
     */
    public static final String USER_LOGIN_KEY = "user_login_key";

    /**
     * 登录失败最大次数
     */
    public static final Integer LOGIN_FAIL_CNT = 10;

    /**
     * 数据字典
     */
    public static final String DICT_DATA_KEY = "ditc_data_key";

    public static final String DICT_DATA_MAP_KEY = "ditc_data_map_key";


    /***************** token constant ******************/

    /**
     * 10分钟
     */
    public static final Long MINUTES_10 = 10 * 60 * 1000L;

    /**
     * 存放Token的Header Key
     */
    public static final String HEADER_TOKEN = "token";


}
