package com.iquantex.tspweb.common;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by leo on 2017/4/13.
 */
@Slf4j
public class DateUtil {

    public static final String CURRENT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String CURRENT_DATE = "yyyy-MM-dd";

    /**
     * 获取当前时间
     * 格式为yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getCurrentDateTime() {
        return getCurrentDateTime(CURRENT_DATE_TIME);
    }

    /**
     * 获取指定格式的当前时间
     *
     * @param pattern
     * @return
     */
    public static String getCurrentDateTime(String pattern) {
        if (StringUtils.isBlank(pattern)) {
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Long currentTime = System.currentTimeMillis();

        return dateFormat.format(currentTime);
    }

    /**
     * 根据时间戳获取格式化后的时间
     * 格式为yyyy-MM-dd HH:mm:ss
     *
     * @param timeMillis 时间戳
     * @return
     */
    public static String format(Long timeMillis) {
        return format(timeMillis, CURRENT_DATE_TIME);
    }

    /**
     * 根据时间戳获取指定格式格式化后的时间
     *
     * @param timeMillis 时间戳
     * @param pattern    日期格式
     * @return
     */
    public static String format(Long timeMillis, String pattern) {
        if (null == timeMillis) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(timeMillis);
    }

    /**
     * 获取日期格式字符串
     * 格式为 yyyy-MM-dd
     *
     * @param date Date对象
     * @return
     */
    public static String format(Date date) {
        return format(date, CURRENT_DATE);
    }

    /**
     * 获取指定格式的日期字符串
     *
     * @param date    Date对象
     * @param pattern 日期格式
     * @return
     */
    public static String format(Date date, String pattern) {
        if (null == date || StringUtils.isBlank(pattern)) {
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * 根据日期字符串获取时间戳
     * 格式为yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期字符串
     * @return
     */
    public static Long getDateTimeMill(String date) {
        return getDateTimeMill(date, CURRENT_DATE_TIME);
    }

    /**
     * 根据指定格式日期字符串获取时间戳
     *
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Long getDateTimeMill(String dateStr, String pattern) {
        Date date = getDate(dateStr, pattern);
        return null == date ? null : date.getTime();
    }

    /**
     * 根据日期字符串和默认日期格式获取日期对象
     * 默认字符串格式：yyyy-MM-dd
     *
     * @param dateStr 日期字符串
     * @return Date对象
     */
    public static Date getDate(String dateStr) {
        return getDate(dateStr, CURRENT_DATE);
    }

    /**
     * 根据日期字符串和指定日期格式获取日期对象
     *
     * @param dateStr 日期字符串
     * @param pattern 日期格式
     * @return Date对象
     */
    public static Date getDate(String dateStr, String pattern) {
        if (StringUtils.isBlank(dateStr) || StringUtils.isBlank(pattern)) {
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(String.format("日期【%s】格式【%s】错误", dateStr, pattern));
        }
    }

    /**
     * 获取当前系统时间
     *
     * @return
     */
    public static Date getSysDate() {
        return new Date();
    }

    /**
     * 获取只保留年月日的日期
     *
     * @param date
     * @return
     */
    public static Date toDate(Date date) {
        if (date == null) {
            return null;
        }

        // 将时分秒毫秒设置为0
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);

        return cal1.getTime();
    }


    public static String UrlEncode(String data, String encodeType) {
        try {
            data = URLEncoder.encode(data, encodeType);
            return data;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            log.error("UrlEncode error <{}>,data <{}>", e.getMessage(),data);
            return data;
        }
    }

    public static String stringToDate(String time){
        time=time.trim();
        if(time.length()==5)
            return format(new Date())+" "+new StringBuilder("0"+time).insert(2,":").insert(5,":");
        else
            return format(new Date())+" "+new StringBuilder(time).insert(2,":").insert(5,":");
    }


    /**
     * 将yyyyMMdd时间格式转换为时间戳
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static long dateToStamp(String dateString){
        return dateToStamp(dateString, "yyyyMMdd");
    }


    /**
     * 将yyyyMMdd时间格式转换为时间戳
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static long dateToStamp(long dateString){
        return dateToStamp(String.valueOf(dateString), "yyyyMMdd");
    }

    /**
     * 将formatStr时间格式转换为时间戳
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static long dateToStamp(String dateString, String formatStr){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
        try {
            Date date = simpleDateFormat.parse(dateString);
            return date.getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
