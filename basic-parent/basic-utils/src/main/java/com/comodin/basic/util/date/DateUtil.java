package com.comodin.basic.util.date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * The type Date util.
 */
@SuppressWarnings({"WeakerAccess", "Duplicates", "unused", "Convert2Diamond"})
public class DateUtil {
    private static final Logger log = Logger.getLogger(DateUtil.class);

    public static final String DATE_PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_PATTERN_HH_MM_SS = "HH:mm:ss";
    public static final String DATE_PATTERN_HH_MM = "HH:mm";
    public static final String DATE_PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String DATE_PATTERN_SS = "ss";
    public static final String DATE_TIMEZONE_UTC = "UTC";
    public static final String DATE_TIMEZONE_ES_MX = "America/Mexico_City";
    public static final String DATE_TIMEZONE_ZH_CN = "Asia/Shanghai";  //Asia/Shanghai //Asia/Hong_Kong    //Asia/Chongqing


    public static String getSpecifiedTimeZoneCurrentTime(String targetTimeZone) {
        return getSpecifiedTimeZoneCurrentTime(targetTimeZone, DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS);
    }

    public static String getSpecifiedTimeZoneCurrentTime(String targetTimeZone, String targetPattern) {
        Date date = new Date();
        SimpleDateFormat targetSimpleDateFormat = new SimpleDateFormat(targetPattern);
        targetSimpleDateFormat.setTimeZone(TimeZone.getTimeZone(targetTimeZone));
        //return targetSimpleDateFormat.format(date);

        SimpleDateFormat defaultTimeZoneSimpleDateFormat = new SimpleDateFormat(DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS);
        defaultTimeZoneSimpleDateFormat.setTimeZone(TimeZone.getDefault());
        SimpleDateFormat utcTimeZoneSimpleDateFormat = new SimpleDateFormat(DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS);
        utcTimeZoneSimpleDateFormat.setTimeZone(TimeZone.getTimeZone(DateUtil.DATE_TIMEZONE_UTC));
        SimpleDateFormat specifiedTimeZoneSimpleDateFormat = new SimpleDateFormat(DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS);
        specifiedTimeZoneSimpleDateFormat.setTimeZone(TimeZone.getTimeZone(targetTimeZone));

        //log.info("getSpecifiedTimeZoneCurrentTime method===> specifiedTimeZone: " + targetTimeZone +
        //        "\n defaultTimeZone: " + defaultTimeZoneSimpleDateFormat.getTimeZone().getID() + "[" + defaultTimeZoneSimpleDateFormat.format(date) + "]" +
        //        "\tUTC TimeZone: " + utcTimeZoneSimpleDateFormat.getTimeZone().getID() + "[" + utcTimeZoneSimpleDateFormat.format(date) + "]" +
        //        "\t specifiedTimeZone: " + specifiedTimeZoneSimpleDateFormat.getTimeZone().getID() + "[" + specifiedTimeZoneSimpleDateFormat.format(date) + "]");

        return targetSimpleDateFormat.format(date);
    }

    public static Date conversionDateTimeBySpecifiedTimeZoneReturnDate(String sourceDateTimeStr, String sourceTimeZone, String sourcePattern, String targetTimeZone, String targetPattern) {
        SimpleDateFormat sourceSdf = new SimpleDateFormat(sourcePattern);
        sourceSdf.setTimeZone(TimeZone.getTimeZone(sourceTimeZone));
        Date sourceDate;
        try {
            sourceDate = sourceSdf.parse(sourceDateTimeStr);
        } catch (ParseException e) {
            throw new RuntimeException("date format error!" + e.getMessage());
        }

        SimpleDateFormat targetSimpleDateFormat = new SimpleDateFormat(targetPattern);
        targetSimpleDateFormat.setTimeZone(TimeZone.getTimeZone(targetTimeZone));
        //return targetSimpleDateFormat.format(sourceDate);

        SimpleDateFormat defaultTimeZoneSimpleDateFormat = new SimpleDateFormat(DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS);
        defaultTimeZoneSimpleDateFormat.setTimeZone(TimeZone.getDefault());
        SimpleDateFormat utcTimeZoneSimpleDateFormat = new SimpleDateFormat(DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS);
        utcTimeZoneSimpleDateFormat.setTimeZone(TimeZone.getTimeZone(DateUtil.DATE_TIMEZONE_UTC));
        SimpleDateFormat specifiedTimeZoneSimpleDateFormat = new SimpleDateFormat(targetPattern);
        specifiedTimeZoneSimpleDateFormat.setTimeZone(TimeZone.getTimeZone(targetTimeZone));

        //log.info("conversionDateTimeBySpecifiedTimeZone method===> sourceTimeZone: " + sourceTimeZone + " sourceDateTimeStr[" + sourceDateTimeStr + "]\t" +
        //        "\n defaultTimeZone: " + defaultTimeZoneSimpleDateFormat.getTimeZone().getID() + "[" + defaultTimeZoneSimpleDateFormat.format(sourceDate) + "]" +
        //        "\tUTC TimeZone: " + utcTimeZoneSimpleDateFormat.getTimeZone().getID() + "[" + utcTimeZoneSimpleDateFormat.format(sourceDate) + "]" +
        //        "\t specifiedTimeZone: " + specifiedTimeZoneSimpleDateFormat.getTimeZone().getID() + "[" + specifiedTimeZoneSimpleDateFormat.format(sourceDate) + "]");

        return sourceDate;
    }

    public static String conversionDateTimeBySpecifiedTimeZone(String sourceDateTimeStr, String sourceTimeZone, String sourcePattern, String targetTimeZone, String targetPattern) {
        SimpleDateFormat targetSimpleDateFormat = new SimpleDateFormat(targetPattern);
        targetSimpleDateFormat.setTimeZone(TimeZone.getTimeZone(targetTimeZone));
        return targetSimpleDateFormat.format(conversionDateTimeBySpecifiedTimeZoneReturnDate(sourceDateTimeStr, sourceTimeZone, sourcePattern, targetTimeZone, targetPattern));
    }

    public static String conversionUTCTimestampBySpecifiedTimeZone(Date sourceDate, String sourcePattern, String targetTimeZone) {
        SimpleDateFormat sourceSdf = new SimpleDateFormat(sourcePattern);
        String sourceDateStr = sourceSdf.format(sourceDate);
        return conversionDateTimeBySpecifiedTimeZone(sourceDateStr, DateUtil.DATE_TIMEZONE_UTC, sourcePattern, targetTimeZone, sourcePattern);
    }

    public static String getCurrentUTCTimeStr() {
        return getSpecifiedTimeZoneCurrentTime(DateUtil.DATE_TIMEZONE_UTC, DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * by supeng
     * 2.获取当前UTC时间
     *
     * @param pattern 指定格式
     *
     * @return 返回 UTC时间，字符类型
     */
    public static String getCurrentUTCTimeStr(String pattern) {
        return getSpecifiedTimeZoneCurrentTime(DateUtil.DATE_TIMEZONE_UTC, pattern);
    }

    /**
     * @param sourceDateStr  字符串时间
     * @param sourceTimeZone 字符串时间,原时区
     * @param sourcePattern  字符串时间,原格式
     * @param newPattern     返回新的格式
     *
     * @return  //
     */
    public static String getUTCTimeStr(String sourceDateStr, String sourceTimeZone, String sourcePattern, String newPattern) {
        return conversionDateTimeBySpecifiedTimeZone(sourceDateStr, sourceTimeZone, sourcePattern, DateUtil.DATE_TIMEZONE_UTC, newPattern);
    }


    /**
     * by supeng
     * 转换
     * 4.时间戳,参数 ==> , ==> 返回 UTC时间，字符类型,可以指定格式
     *
     * @param sourceTimeStamp //
     * @param targetPattern   指定格式
     *
     * @return 返回 UTC时间，字符类型
     */
    public static String getUTCTimeStr(long sourceTimeStamp, String targetPattern) {
        SimpleDateFormat format = new SimpleDateFormat(targetPattern);
        format.setTimeZone(TimeZone.getTimeZone(DateUtil.DATE_TIMEZONE_UTC));
        return format.format(sourceTimeStamp);
    }


    /**
     * 转换
     * 2.日期      参数 , ==> 返回 UTC时间，返回字符,可以指定格式
     *
     * @param sourceDateTime //
     * @param targetPattern  指定格式
     *
     * @return 返回 UTC时间，字符类型
     */
    public static String getUTCTimeStr(Date sourceDateTime, String targetPattern) {
        SimpleDateFormat format = new SimpleDateFormat(targetPattern);
        format.setTimeZone(TimeZone.getTimeZone(DateUtil.DATE_TIMEZONE_UTC));
        return format.format(sourceDateTime);
    }

    /**
     * bu supeng
     * 1.获取当前UTC时间
     *
     * @return 返回UTC时间，日期类型
     */
    public static Date getCurrentUTCTime() {
        // 1、取得本地时间：
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        // 2、取得时间偏移量：
        int zoneOffset = calendar.get(java.util.Calendar.ZONE_OFFSET);
        // 3、取得夏令时差：
        int dstOffset = calendar.get(java.util.Calendar.DST_OFFSET);
        // 4、从本地时间里扣除这些差量,即可以取得UTC时间：
        calendar.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        calendar.setTimeZone(TimeZone.getTimeZone(DATE_TIMEZONE_UTC));
        return calendar.getTime();
    }

    /**
     * 转换
     * 3.时间戳    参数 , ==> 返回 UTC时间，日期类型
     *
     * @param sourceTimeStamp //
     *
     * @return 返回UTC时间，日期类型
     */
    public static Date getUTCTime(long sourceTimeStamp) {
        //SimpleDateFormat format = new SimpleDateFormat(DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS);
        //format.setTimeZone(TimeZone.getTimeZone(DateUtil.DATE_TIMEZONE_UTC));
        //String utcTimeStr = getUTCTimeStr(sourceTimeStamp, DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS);
        //try {
        //    return format.parse(utcTimeStr);
        //} catch (ParseException e) {
        //    e.printStackTrace();
        //}
        //return null;

        // 1、取得本地时间：
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(sourceTimeStamp);
        // 2、取得时间偏移量：
        int zoneOffset = calendar.get(java.util.Calendar.ZONE_OFFSET);
        // 3、取得夏令时差：
        int dstOffset = calendar.get(java.util.Calendar.DST_OFFSET);
        // 4、从本地时间里扣除这些差量,即可以取得UTC时间：
        calendar.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        calendar.setTimeZone(TimeZone.getTimeZone(DATE_TIMEZONE_UTC));
        return calendar.getTime();
    }


    /**
     * 转换
     * 1.日期参数 , ==> 返回 UTC时间，日期类型
     *
     * @param sourceDate //
     *
     * @return 返回UTC时间，日期类型
     */
    public static Date getUTCTime(Date sourceDate) {
        // 1、取得本地时间：
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sourceDate);
        // 2、取得时间偏移量：
        int zoneOffset = calendar.get(java.util.Calendar.ZONE_OFFSET);
        // 3、取得夏令时差：
        int dstOffset = calendar.get(java.util.Calendar.DST_OFFSET);
        // 4、从本地时间里扣除这些差量,即可以取得UTC时间：
        calendar.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        calendar.setTimeZone(TimeZone.getTimeZone(DATE_TIMEZONE_UTC));
        return calendar.getTime();
    }

    public static boolean isValidDate(String sourceDateStr, String pattern) {
        try {
            // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            dateFormat.setLenient(false);
            dateFormat.parse(sourceDateStr);
            return true;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

    public static boolean isValidDate(String sourceDateStr) {
        DateStyle oldDateStyle = getDateStyle(sourceDateStr);
        try {
            // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
            SimpleDateFormat dateFormat = new SimpleDateFormat(oldDateStyle.getValue());
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            dateFormat.setLenient(false);
            dateFormat.parse(sourceDateStr);
            return true;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

    public static Date stringToDate(String strSourceDate, String strSourceDatePattern, String strSourceDateTimeZone) {
        //log.info("date str conversion date--> strSourceDate:" + strSourceDate + " strSourceDatePattern: " + strSourceDatePattern + " strSourceDateTimeZone:" + strSourceDateTimeZone + " current system default TimeZone: " + TimeZone.getDefault().getID());
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(strSourceDatePattern);
            sdf.setTimeZone(TimeZone.getTimeZone(strSourceDateTimeZone));
            return sdf.parse(strSourceDate);
        } catch (ParseException e) {
            log.error("date str conversion date fail.", e);
        }
        return null;
    }


    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();
    private static final Object object = new Object();

    /**
     * 获取SimpleDateFormat
     *
     * @param pattern 日期格式
     *
     * @return SimpleDateFormat对象 date format
     *
     * @throws RuntimeException 异常：非法日期格式
     */
    @SuppressWarnings("DeprecatedIsStillUsed")
    @Deprecated
    public static SimpleDateFormat getDateFormat(String pattern) throws RuntimeException {
        SimpleDateFormat dateFormat = threadLocal.get();
        if (dateFormat == null) {
            synchronized (object) {
                dateFormat = new SimpleDateFormat(pattern);
                dateFormat.setLenient(false);
                threadLocal.set(dateFormat);
            }
        }
        dateFormat.applyPattern(pattern);
        return dateFormat;
    }


    /**
     * 获取日期中的某数值。如获取月份
     *
     * @param date     日期
     * @param dateType 日期格式
     *
     * @return 数值
     */
    private static int getInteger(Date date, int dateType) {
        int num = 0;
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
            num = calendar.get(dateType);
        }
        return num;
    }

    /**
     * 增加日期中某类型的某数值。如增加日期
     *
     * @param date     日期字符串
     * @param dateType 类型
     * @param amount   数值
     *
     * @return 计算后日期字符串
     */
    private static String addInteger(String date, int dateType, int amount) {
        String dateString = null;
        DateStyle dateStyle = getDateStyle(date);
        if (dateStyle != null) {
            Date myDate = StringToDate(date, dateStyle);
            myDate = addInteger(myDate, dateType, amount);
            dateString = DateToString(myDate, dateStyle);
        }
        return dateString;
    }

    /**
     * 增加日期中某类型的某数值。如增加日期
     *
     * @param date     日期
     * @param dateType 类型
     * @param amount   数值
     *
     * @return 计算后日期
     */
    private static Date addInteger(Date date, int dateType, int amount) {
        Date myDate = null;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(dateType, amount);
            myDate = calendar.getTime();
        }
        return myDate;
    }

    /**
     * 获取精确的日期
     *
     * @param timestamps 时间long集合
     *
     * @return 日期
     */
    private static Date getAccurateDate(List<Long> timestamps) {
        Date date = null;
        long timestamp = 0;
        Map<Long, long[]> map = new HashMap<Long, long[]>();
        List<Long> absoluteValues = new ArrayList<Long>();

        if (timestamps != null && timestamps.size() > 0) {
            if (timestamps.size() > 1) {
                for (int i = 0; i < timestamps.size(); i++) {
                    for (int j = i + 1; j < timestamps.size(); j++) {
                        long absoluteValue = Math.abs(timestamps.get(i) - timestamps.get(j));
                        absoluteValues.add(absoluteValue);
                        long[] timestampTmp = {timestamps.get(i), timestamps.get(j)};
                        map.put(absoluteValue, timestampTmp);
                    }
                }

                // 有可能有相等的情况。如2012-11和2012-11-01。时间戳是相等的。此时minAbsoluteValue为0  
                // 因此不能将minAbsoluteValue取默认值0  
                long minAbsoluteValue = -1;
                if (!absoluteValues.isEmpty()) {
                    minAbsoluteValue = absoluteValues.get(0);
                    for (int i = 1; i < absoluteValues.size(); i++) {
                        if (minAbsoluteValue > absoluteValues.get(i)) {
                            minAbsoluteValue = absoluteValues.get(i);
                        }
                    }
                }

                if (minAbsoluteValue != -1) {
                    long[] timestampsLastTmp = map.get(minAbsoluteValue);

                    long dateOne = timestampsLastTmp[0];
                    long dateTwo = timestampsLastTmp[1];
                    if (absoluteValues.size() > 1) {
                        timestamp = Math.abs(dateOne) > Math.abs(dateTwo) ? dateOne : dateTwo;
                    }
                }
            } else {
                timestamp = timestamps.get(0);
            }
        }

        if (timestamp != 0) {
            date = new Date(timestamp);
        }
        return date;
    }


    /**
     * 获取日期字符串的日期风格。失敗返回null。
     *
     * @param date 日期字符串
     *
     * @return 日期风格 date style
     */
    public static DateStyle getDateStyle(String date) {
        DateStyle dateStyle = null;
        Map<Long, DateStyle> map = new HashMap<>();
        List<Long> timestamps = new ArrayList<>();
        for (DateStyle style : DateStyle.values()) {
            if (style.isShowOnly()) {
                continue;
            }
            Date dateTmp = null;
            if (date != null) {
                try {
                    ParsePosition pos = new ParsePosition(0);
                    dateTmp = getDateFormat(style.getValue()).parse(date, pos);
                    if (pos.getIndex() != date.length()) {
                        dateTmp = null;
                    }
                } catch (Exception e) {
                }
            }
            if (dateTmp != null) {
                timestamps.add(dateTmp.getTime());
                map.put(dateTmp.getTime(), style);
            }
        }
        Date accurateDate = getAccurateDate(timestamps);
        if (accurateDate != null) {
            dateStyle = map.get(accurateDate.getTime());
        }
        return dateStyle;
    }

    /**
     * 将日期字符串转化为日期。失败返回null。
     *
     * @param date 日期字符串
     *
     * @return 日期 date
     */
    @Deprecated
    public static Date StringToDate(String date) {
        DateStyle dateStyle = getDateStyle(date);
        return StringToDate(date, dateStyle);
    }

    /**
     * 将日期字符串转化为日期。失败返回null。
     *
     * @param date    日期字符串
     * @param pattern 日期格式
     *
     * @return 日期 date
     */
    @Deprecated
    public static Date StringToDate(String date, String pattern) {
        Date myDate = null;
        if (date != null) {
            try {
                myDate = getDateFormat(pattern).parse(date);
            } catch (Exception e) {
            }
        }
        return myDate;
    }

    /**
     * 将日期字符串转化为日期。失败返回null。
     *
     * @param date      日期字符串
     * @param dateStyle 日期风格
     *
     * @return 日期 date
     */
    @Deprecated
    public static Date StringToDate(String date, DateStyle dateStyle) {
        Date myDate = null;
        if (dateStyle != null) {
            myDate = StringToDate(date, dateStyle.getValue());
        }
        return myDate;
    }

    /**
     * 将日期字符串转化为日期。失败返回null。
     *
     * @param date      日期
     * @param dateStyle 日期风格
     *
     * @return 日期 date
     */
    public static Date DateToDate(Date date, DateStyle dateStyle) {
        return StringToDate(DateToString(date, dateStyle.getValue()));
    }

    /**
     * 将日期字符串转化为日期。失败返回null。
     *
     * @param date    日期
     * @param pattern 日期风格
     *
     * @return 日期 date
     */
    public static Date DateToDate(Date date, String pattern) {
        return StringToDate(DateToString(date, pattern));
    }

    /**
     * 将日期转化为日期字符串。失败返回null。
     *
     * @param date    日期
     * @param pattern 日期格式
     *
     * @return 日期字符串 string
     */
    public static String DateToString(Date date, String pattern) {
        String dateString = null;
        if (date != null) {
            try {
                dateString = getDateFormat(pattern).format(date);
            } catch (Exception e) {
            }
        }
        return dateString;
    }

    /**
     * 将日期转化为日期字符串。失败返回null。
     *
     * @param date      日期
     * @param dateStyle 日期风格
     *
     * @return 日期字符串 string
     */
    public static String DateToString(Date date, DateStyle dateStyle) {
        String dateString = null;
        if (dateStyle != null) {
            dateString = DateToString(date, dateStyle.getValue());
        }
        return dateString;
    }

    /**
     * 将日期字符串转化为另一日期字符串。失败返回null。
     *
     * @param date       旧日期字符串
     * @param newPattern 新日期格式
     *
     * @return 新日期字符串 string
     */
    public static String StringToString(String date, String newPattern) {
        DateStyle oldDateStyle = getDateStyle(date);
        return StringToString(date, oldDateStyle, newPattern);
    }

    /**
     * 将日期字符串转化为另一日期字符串。失败返回null。
     *
     * @param date         旧日期字符串
     * @param newDateStyle 新日期风格
     *
     * @return 新日期字符串 string
     */
    public static String StringToString(String date, DateStyle newDateStyle) {
        DateStyle oldDateStyle = getDateStyle(date);
        return StringToString(date, oldDateStyle, newDateStyle);
    }

    /**
     * 将日期字符串转化为另一日期字符串。失败返回null。
     *
     * @param date       旧日期字符串
     * @param oldPattern 旧日期格式
     * @param newPattern 新日期格式
     *
     * @return 新日期字符串 string
     */
    public static String StringToString(String date, String oldPattern, String newPattern) {
        return DateToString(StringToDate(date, oldPattern), newPattern);
    }

    /**
     * 将日期字符串转化为另一日期字符串。失败返回null。
     *
     * @param date        旧日期字符串
     * @param oldDteStyle 旧日期风格
     * @param newPattern  新日期格式
     *
     * @return 新日期字符串 string
     */
    public static String StringToString(String date, DateStyle oldDteStyle, String newPattern) {
        String dateString = null;
        if (oldDteStyle != null) {
            dateString = StringToString(date, oldDteStyle.getValue(), newPattern);
        }
        return dateString;
    }

    /**
     * 将日期字符串转化为另一日期字符串。失败返回null。
     *
     * @param date         旧日期字符串
     * @param oldPattern  旧日期格式
     * @param newDateStyle 新日期风格
     *
     * @return 新日期字符串 string
     */
    public static String StringToString(String date, String oldPattern, DateStyle newDateStyle) {
        String dateString = null;
        if (newDateStyle != null) {
            dateString = StringToString(date, oldPattern, newDateStyle.getValue());
        }
        return dateString;
    }

    /**
     * 将日期字符串转化为另一日期字符串。失败返回null。
     *
     * @param date         旧日期字符串
     * @param oldDteStyle  旧日期风格
     * @param newDateStyle 新日期风格
     *
     * @return 新日期字符串 string
     */
    public static String StringToString(String date, DateStyle oldDteStyle, DateStyle newDateStyle) {
        String dateString = null;
        if (oldDteStyle != null && newDateStyle != null) {
            dateString = StringToString(date, oldDteStyle.getValue(), newDateStyle.getValue());
        }
        return dateString;
    }

    /**
     * 增加日期的年份。失败返回null。
     *
     * @param date       日期
     * @param yearAmount 增加数量。可为负数
     *
     * @return 增加年份后的日期字符串 string
     */
    public static String addYear(String date, int yearAmount) {
        return addInteger(date, Calendar.YEAR, yearAmount);
    }

    /**
     * 增加日期的年份。失败返回null。
     *
     * @param date       日期
     * @param yearAmount 增加数量。可为负数
     *
     * @return 增加年份后的日期 date
     */
    public static Date addYear(Date date, int yearAmount) {
        return addInteger(date, Calendar.YEAR, yearAmount);
    }

    /**
     * 增加日期的月份。失败返回null。
     *
     * @param date        日期
     * @param monthAmount 增加数量。可为负数
     *
     * @return 增加月份后的日期字符串 string
     */
    public static String addMonth(String date, int monthAmount) {
        return addInteger(date, Calendar.MONTH, monthAmount);
    }

    /**
     * 增加日期的月份。失败返回null。
     *
     * @param date        日期
     * @param monthAmount 增加数量。可为负数
     *
     * @return 增加月份后的日期 date
     */
    public static Date addMonth(Date date, int monthAmount) {
        return addInteger(date, Calendar.MONTH, monthAmount);
    }

    /**
     * 增加日期的天数。失败返回null。
     *
     * @param date      日期字符串
     * @param dayAmount 增加数量。可为负数
     *
     * @return 增加天数后的日期字符串 string
     */
    public static String addDay(String date, int dayAmount) {
        return addInteger(date, Calendar.DATE, dayAmount);
    }

    /**
     * 增加日期的天数。失败返回null。
     *
     * @param date      日期
     * @param dayAmount 增加数量。可为负数
     *
     * @return 增加天数后的日期 date
     */
    public static Date addDay(Date date, int dayAmount) {
        return addInteger(date, Calendar.DATE, dayAmount);
    }

    /**
     * 增加日期的小时。失败返回null。
     *
     * @param date       日期字符串
     * @param hourAmount 增加数量。可为负数
     *
     * @return 增加小时后的日期字符串 string
     */
    public static String addHour(String date, int hourAmount) {
        return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
    }

    /**
     * 增加日期的小时。失败返回null。
     *
     * @param date       日期
     * @param hourAmount 增加数量。可为负数
     *
     * @return 增加小时后的日期 date
     */
    public static Date addHour(Date date, int hourAmount) {
        return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
    }

    /**
     * 增加日期的分钟。失败返回null。
     *
     * @param date         日期字符串
     * @param minuteAmount 增加数量。可为负数
     *
     * @return 增加分钟后的日期字符串 string
     */
    public static String addMinute(String date, int minuteAmount) {
        return addInteger(date, Calendar.MINUTE, minuteAmount);
    }

    /**
     * 增加日期的分钟。失败返回null。
     *
     * @param date         日期
     * @param minuteAmount 增加数量。可为负数
     *
     * @return 增加分钟后的日期 date
     */
    public static Date addMinute(Date date, int minuteAmount) {
        return addInteger(date, Calendar.MINUTE, minuteAmount);
    }

    /**
     * 增加日期的秒钟。失败返回null。
     *
     * @param date         日期字符串
     * @param secondAmount 增加数量。可为负数
     *
     * @return 增加秒钟后的日期字符串 string
     */
    public static String addSecond(String date, int secondAmount) {
        return addInteger(date, Calendar.SECOND, secondAmount);
    }

    /**
     * 增加日期的秒钟。失败返回null。
     *
     * @param date         日期
     * @param secondAmount 增加数量。可为负数
     *
     * @return 增加秒钟后的日期 date
     */
    public static Date addSecond(Date date, int secondAmount) {
        return addInteger(date, Calendar.SECOND, secondAmount);
    }

    /**
     * 获取日期的年份。失败返回0。
     *
     * @param date 日期字符串
     *
     * @return 年份 year
     */
    public static int getYear(String date) {
        return getYear(StringToDate(date));
    }

    /**
     * 获取日期的年份。失败返回0。
     *
     * @param date 日期
     *
     * @return 年份 year
     */
    public static int getYear(Date date) {
        return getInteger(date, Calendar.YEAR);
    }

    /**
     * 获取日期的月份。失败返回0。
     *
     * @param date 日期字符串
     *
     * @return 月份 month
     */
    public static int getMonth(String date) {
        return getMonth(StringToDate(date));
    }

    /**
     * 获取日期的月份。失败返回0。
     *
     * @param date 日期
     *
     * @return 月份 month
     */
    public static int getMonth(Date date) {
        return getInteger(date, Calendar.MONTH) + 1;
    }

    /**
     * 获取日期的天数。失败返回0。
     *
     * @param date 日期字符串
     *
     * @return 天 day
     */
    public static int getDay(String date) {
        return getDay(StringToDate(date));
    }

    /**
     * 获取日期的天数。失败返回0。
     *
     * @param date 日期
     *
     * @return 天 day
     */
    public static int getDay(Date date) {
        return getInteger(date, Calendar.DATE);
    }

    /**
     * 获取日期的小时。失败返回0。
     *
     * @param date 日期字符串
     *
     * @return 小时 hour
     */
    public static int getHour(String date) {
        return getHour(StringToDate(date));
    }

    /**
     * 获取日期的小时。失败返回0。
     *
     * @param date 日期
     *
     * @return 小时 hour
     */
    public static int getHour(Date date) {
        return getInteger(date, Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取日期的分钟。失败返回0。
     *
     * @param date 日期字符串
     *
     * @return 分钟 minute
     */
    public static int getMinute(String date) {
        return getMinute(StringToDate(date));
    }

    /**
     * 获取日期的分钟。失败返回0。
     *
     * @param date 日期
     *
     * @return 分钟 minute
     */
    public static int getMinute(Date date) {
        return getInteger(date, Calendar.MINUTE);
    }

    /**
     * 获取日期的秒钟。失败返回0。
     *
     * @param date 日期字符串
     *
     * @return 秒钟 second
     */
    public static int getSecond(String date) {
        return getSecond(StringToDate(date));
    }

    /**
     * 获取日期的秒钟。失败返回0。
     *
     * @param date 日期
     *
     * @return 秒钟 second
     */
    public static int getSecond(Date date) {
        return getInteger(date, Calendar.SECOND);
    }

    /**
     * 获取日期 。默认yyyy-MM-dd格式。失败返回null。
     *
     * @param date 日期字符串
     *
     * @return 日期 date
     */
    public static String getDate(String date) {
        return StringToString(date, DateStyle.YYYY_MM_DD);
    }

    /**
     * 获取日期。默认yyyy-MM-dd格式。失败返回null。
     *
     * @param date 日期
     *
     * @return 日期 date
     */
    public static String getDate(Date date) {
        return DateToString(date, DateStyle.YYYY_MM_DD);
    }

    /**
     * 获取日期的时间。默认HH:mm:ss格式。失败返回null。
     *
     * @param date 日期字符串
     *
     * @return 时间 time
     */
    public static String getTime(String date) {
        return StringToString(date, DateStyle.HH_MM_SS);
    }

    /**
     * 获取日期的时间。默认HH:mm:ss格式。失败返回null。
     *
     * @param date 日期
     *
     * @return 时间 time
     */
    public static String getTime(Date date) {
        return DateToString(date, DateStyle.HH_MM_SS);
    }

    public static int getWeekPressCalendar(String date) {
        int weekNumber = -1;

        DateStyle dateStyle = getDateStyle(date);
        if (dateStyle != null) {
            //noinspection deprecation
            Date myDate = StringToDate(date, dateStyle);
            weekNumber = getWeekPressCalendar(myDate);
        }
        return weekNumber;
    }

    public static int getWeekPressCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取日期的星期。失败返回null。
     *
     * @param date 日期字符串
     *
     * @return 星期 week
     */
    public static Week getWeek(String date) {
        Week week = null;
        DateStyle dateStyle = getDateStyle(date);
        if (dateStyle != null) {
            Date myDate = StringToDate(date, dateStyle);
            week = getWeek(myDate);
        }
        return week;
    }

    /**
     * 获取日期的星期。失败返回null。
     *
     * @param date 日期
     *
     * @return 星期 week
     */
    public static Week getWeek(Date date) {
        Week week = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        switch (weekNumber) {
            case 0:
                week = Week.SUNDAY;
                break;
            case 1:
                week = Week.MONDAY;
                break;
            case 2:
                week = Week.TUESDAY;
                break;
            case 3:
                week = Week.WEDNESDAY;
                break;
            case 4:
                week = Week.THURSDAY;
                break;
            case 5:
                week = Week.FRIDAY;
                break;
            case 6:
                week = Week.SATURDAY;
                break;
        }
        return week;
    }

    /**
     * 获取两个日期相差的天数
     *
     * @param date      日期字符串
     * @param otherDate 另一个日期字符串
     *
     * @return 相差天数 。如果失败则返回-1
     */
    public static int getIntervalDays(String date, String otherDate) {
        return getIntervalDays(StringToDate(date), StringToDate(otherDate));
    }

    /**
     * Gets interval days.
     *
     * @param date      日期
     * @param otherDate 另一个日期
     *
     * @return 相差天数 。如果失败则返回-1
     */
    public static int getIntervalDays(Date date, Date otherDate) {
        int num = -1;
        Date dateTmp = StringToDate(DateUtil.getDate(date), DateStyle.YYYY_MM_DD);
        Date otherDateTmp = StringToDate(DateUtil.getDate(otherDate), DateStyle.YYYY_MM_DD);
        if (dateTmp != null && otherDateTmp != null) {
            long time = Math.abs(dateTmp.getTime() - otherDateTmp.getTime());
            num = (int) (time / (24 * 60 * 60 * 1000));
        }
        return num;
    }


    /**
     * 当月第一天
     *
     * @return
     */
    public static String getFirstDay(Date date, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotBlank(pattern)) {
            df = new SimpleDateFormat(pattern);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date theDate = calendar.getTime();

        //上个月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        return day_first + " 00:00:00";
    }

    /**
     * 当月最后一天
     *
     * @return
     */
    public static String getLastDay(Date date, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotBlank(pattern)) {
            df = new SimpleDateFormat(pattern);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //上个月最后一天
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        String day_last = df.format(calendar.getTime());
        return day_last + " 23:59:59";
    }

    /**
     * 获取制定日期的凌晨00:00:00时间戳
     *
     * @param date
     *
     * @return
     */
    public static Date getStartTimeByAssignDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date start = calendar.getTime();

        return start;
    }

    /**
     * 获取制定日期的深夜23:59:59时间戳
     *
     * @param date
     *
     * @return
     */
    public static Date getEndTimeByAssignDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);


        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.SECOND, -1);

        Date end = calendar.getTime();

        return end;
    }


    public static String conversionBeanTimestamp(long timestamp, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);//初始化Formatter的转换格式。
        return formatter.format(timestamp);
    }

    public static Date getByPattern(String date, String tableSuffixPattern) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat(tableSuffixPattern);

        return format.parse(date);

    }
}