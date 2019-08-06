package com.weyon.framework.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author liuxu
 * @description MD5加密工具类
 * @date 2019-05-17
 **/
public class MD5Util {
    public static String encode(String string){
        try {
            // 确定计算方法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(string.getBytes());
            // 加密字符串
            return new BigInteger(1, md5.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(encode("123456"));
    }
}
