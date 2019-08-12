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
     * 数据上报设置值
     */
    public static final String REPORT_SET_DATE_KEY = "report_set_date_key";

    /**
     * 数据字典
     */
    public static final String DICT_DATA_KEY = "ditc_data_key";

    public static final String DICT_DATA_MAP_KEY = "ditc_data_map_key";

    /**
     * 分组织字段信息
     */
    public static final String INAC_FIELD_INFO_MAP_KEY = "inac_field_info_map";

    /***************** token constant ******************/

    /**
     * 10分钟
     */
    public static final Long MINUTES_10 = 10 * 60 * 1000L;

    /**
     * 存放Token的Header Key
     */
    public static final String HEADER_TOKEN = "token";


    public static final String CORE_FIELD_INFO_MAP_KEY = "core_field_info_map";

}
