package com.beingmate.monitorcenter.rule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2017/8/28 0028.
 */
public class DateUtil {


    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static Date parse(String date, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(date);
        } catch (ParseException e) {
        }
        return null;
    }

    public static Date parseDateTime(String date){
        return parse(date, DATETIME_PATTERN);
    }

    public static Date parseDate(String date){
        return parse(date, DATE_PATTERN);
    }

    public static String formatDate(Date date){
        return new SimpleDateFormat(DATE_PATTERN).format(date);
    }

    public static String formatDateTime(Date date){
        return new SimpleDateFormat(DATETIME_PATTERN).format(date);
    }

    public static String format(Date date, String pattern){
        return new SimpleDateFormat(pattern).format(date);
    }

    public static String unix2Date(String timestamp, String pattern) {
        return new SimpleDateFormat(pattern, Locale.CHINA).format(new Date(Long.valueOf(timestamp) * 1000));
    }

    public static Date unix2Date(String timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_PATTERN, Locale.CHINA);
        try {
            return sdf.parse(sdf.format(new Date(Long.valueOf(timestamp) * 1000)));
        } catch (NumberFormatException | ParseException e) {
            return null;
        }
    }

    public static Date unix2Date(Integer timestamp) {
        return unix2Date(timestamp.toString());
    }

    public static String date2Unix(String date, String pattern) throws ParseException {
        return String.valueOf(new SimpleDateFormat(pattern).parse(date).getTime() / 1000);
    }

    public static String getUnix(){
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    /**
     * 获取指定小时的date
     * @param hour
     * @return
     */
    public static Date getHourDate(Integer hour){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        return cal.getTime();
    }
}
