package com.zyc.Date;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Calendar;

import java.util.Date;
/**
 * @author zhouyongcai
 * @create_time 2020/4/26 11:28
 * @note：
 */
//enum DATE_UNIT{
//        YEAR, MONTH, WEEK, DAY, HOUR, MINUTE, SECOND
//}
public class DateUtils {

    public static final int YEAR = 1;
    public static final int MONTH = 2;
    public static final int WEEK = 3;
    public static final int DAY = 4;
    public static final int HOUR = 5;
    public static final int MINUTE = 6;
    public static final int SECOND = 7;

    /**
     *
     * @param backNum
     * @param dateUnit
     * @param pattern
     * @return
     */
    public static String getBackDateStr(int backNum, int dateUnit, String pattern) {
        String backDateStr="";
        if(null == pattern) {
           return backDateStr;
        }
        Calendar ca = Calendar.getInstance();//得到一个Calendar的实例
        ca.setTime(new Date()); //设置时间为当前时间

        switch (dateUnit) {
            case YEAR:
                ca.add(Calendar.YEAR, -backNum); //年份减1
                backDateStr = FastDateFormat.getInstance(pattern).format(ca); // 结果
            break;
            case MONTH:
                ca.add(Calendar.MINUTE, -backNum); //年份减1
                backDateStr = FastDateFormat.getInstance(pattern).format(ca); // 结果
            break;
            case WEEK:
                ca.add(Calendar.WEEK_OF_MONTH, -backNum); //年份减1
                backDateStr = FastDateFormat.getInstance(pattern).format(ca); // 结果
            break;
            case DAY:
                ca.add(Calendar.DAY_OF_MONTH, -backNum); //年份减1
                backDateStr = FastDateFormat.getInstance(pattern).format(ca); // 结果
            break;
            case HOUR:
                ca.add(Calendar.HOUR, -backNum); //年份减1
                backDateStr = FastDateFormat.getInstance(pattern).format(ca); // 结果
            break;
            case MINUTE:
                ca.add(Calendar.MINUTE, -backNum); //年份减1
                backDateStr = FastDateFormat.getInstance(pattern).format(ca); // 结果
            break;
            case SECOND:
                ca.add(Calendar.SECOND, -backNum); //年份减1
                backDateStr = FastDateFormat.getInstance(pattern).format(ca); // 结果
            break;
        }
        return backDateStr;
    }
}
