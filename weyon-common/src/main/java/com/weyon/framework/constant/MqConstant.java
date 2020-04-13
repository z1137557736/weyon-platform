package com.weyon.framework.constant;

/**
 * @author liuxu
 * @description 消息队列常量类
 * @date 2019-06-26
 **/
public class MqConstant {


    /** 数据上报 **/

    /**
     * 队列
     */
    public final static String REPORT_QUEUE = "report.queue";

    /**
     * 死信交换机 dlx
     */
    public final static String REPORT_DELAY_EXCHANGE = "report.delay.exchange";

    /**
     * 发送到该队列的message会在一段时间后过期进入到死信队列 ttl队列
     */
    public final static String REPORT_DELAY_QUEUE = "report.delay.queue";

    /**
     * 由死信交换机路由过来，实现延时消费的队列
     */
    public final static String REPORT_DELAY_PROCESS_QUEUE = "report.delay.process.queue";

}
