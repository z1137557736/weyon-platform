package com.weyon.framework.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author liuxu
 * @description 递归树形工具类
 * @date 2019-07-18
 **/
public class RecursionTreeUtil {

    private static final String ID = "id";

    private static final String PID = "pid";

    private static final String CHILDREN = "children";


    /**
     * listToTree
     * 将JSONArray数组转为树状结构
     * @return JSONArray
     */
    private static <T> List<T> listToTree(List<T> list, Class<T> pojoClass, String id, String pid, String children) {
        JSONArray arr = JSONArray.parseArray(JSON.toJSONString(list));
        JSONArray r = new JSONArray();
        JSONObject hash = new JSONObject();
        //将数组转为Object的形式，key为数组中的id
        for (int i = 0; i < arr.size(); i++) {
            JSONObject json = (JSONObject) arr.get(i);
            hash.put(json.getString(id), json);
        }
        //遍历结果集
        for (int j = 0; j < arr.size(); j++) {
            //单条记录
            JSONObject aVal = (JSONObject) arr.get(j);
            //在hash中取出key为单条记录中pid的值
            JSONObject hashVP = (JSONObject) hash.get(aVal.get(pid).toString());
            //如果记录的pid存在，则说明它有父节点，将她添加到孩子节点的集合中
            if (hashVP != null) {
                //检查是否有child属性
                if (hashVP.get(children) != null) {
                    JSONArray ch = (JSONArray) hashVP.get(children);
                    ch.add(aVal);
                    hashVP.put(children, ch);
                } else {
                    JSONArray ch = new JSONArray();
                    ch.add(aVal);
                    hashVP.put(children, ch);
                }
            } else {
                r.add(aVal);
            }
        }
        return r.toJavaList(pojoClass);
    }

    /**
     * 使用默认参数转换树形结构
     * @param list
     * @param pojoClass
     * @param <T>
     * @return
     */
    public static <T> List<T> defaultChangeTree(List<T> list, Class<T> pojoClass) {
        return listToTree(list, pojoClass, ID, PID, CHILDREN);
    }

    /**
     * 使用指定参数转换树形结构
     * @param list
     * @param pojoClass
     * @param <T>
     * @return
     */
    public static <T> List<T> customChangeTree(List<T> list, Class<T> pojoClass, String id, String pid, String children) {
        return listToTree(list, pojoClass, id, pid, children);
    }
}
