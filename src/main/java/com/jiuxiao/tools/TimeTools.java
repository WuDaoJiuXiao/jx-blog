package com.jiuxiao.tools;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * 时间工具类
 *
 * @Author: 悟道九霄
 * @Date: 2022年06月03日 10:52
 * @Version: 1.0.0
 */
public class TimeTools {

    /**
     * 获得当前的系统时间
     *
     * @return
     */
    public static Timestamp getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return Timestamp.valueOf(formatter.format(date));
    }
}