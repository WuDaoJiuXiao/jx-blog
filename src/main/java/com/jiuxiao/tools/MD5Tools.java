package com.jiuxiao.tools;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * md5加密工具类
 *
 * @Author: 悟道九霄
 * @Date: 2022年06月01日 10:14
 * @Version: 1.0.0
 */
public class MD5Tools {

    /**
     * 获取字符串的32位md5加密密码
     * @param str
     * @return
     */
    public static String getMD5(String str){
        return DigestUtils.md5Hex(str);
    }
}