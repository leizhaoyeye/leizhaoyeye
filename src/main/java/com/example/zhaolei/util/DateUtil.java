package com.example.zhaolei.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Auther: swy
 * @Date: 2018/9/25 16:02
 */
public class DateUtil extends DateUtils {

    //private final static Logger logger = LoggerFactory.getLogger(com.dbappsecurity.economy.util.DateUtil.class);

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_EXCEL = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_FORMAT_NO_DELIMITER = "yyyyMMdd";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String TIME_FORMAT_NO_SEC = "HH:mm";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss SSS";
    public static final String DATE_TIME_FORMAT_NO_SEC = "yyyy-MM-dd HH:mm";
    public static final String DATE_TIME_FORMAT_NO_DELIMITER = "yyyyMMddHHmmss";
    public static final String DATE_PRECISE_TO_MINUTE = "yyyyMMddHHmm";
    public static final String[] WEEKS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public static final String[] DEFAULT_FORMATS = {TIMESTAMP_FORMAT, DATE_TIME_FORMAT, DATE_FORMAT, TIME_FORMAT, DATE_PRECISE_TO_MINUTE};

    /**
     * 自动判断日期字符串的格式，返回Date对象
     *
     * @param dateString 日期字符串
     * @param dateFormat 格式字符串数组。为空时使用<code>DateUtil.DEFAULT_FORMATS</code>
     * @return 日期Date对象
     * @throws ParseException
     * @see DateUtils#parseDate
     */
    public static Date parse(String dateString, String... dateFormat) throws ParseException {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }

        if (dateFormat == null || dateFormat.length == 0) {
            return DateUtils.parseDate(dateString, DEFAULT_FORMATS);
        } else {
            return DateUtils.parseDate(dateString, dateFormat);
        }
    }

    /**
     *  时间戳转时间字符串
     * @return
     */
    public static String stringToDateString(String dateString){
        long l = Long.parseLong(dateString);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(l);
        return format;
    }


    public static String format(String s) throws ParseException {
        Date date = parse(s);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(date);
        return dateString;
    }



    /**
     * 取指定格式的当前时间字符串
     *
     * @param dateFormat
     * @return
     */
    public static String getCurrentTime(String dateFormat) {
        Date date = new Date();
        return format(date, dateFormat);
    }

    /**
     * 将字符串转换成Date类型
     *
     * @param dateString
     * @param dateFormat
     * @return
     */
    public static Date parse(String dateString, String dateFormat) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }
        try {
            return DateUtils.parseDate(dateString, dateFormat);
        } catch (ParseException e) {
            //logger.error("日期格式化异常", e);
            return null;
        }
    }

    /**
     * 将Date类型转化成字符串
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String format(Date date, String dateFormat) {
        if (date == null) {
            return "";
        } else {
            return DateFormatUtils.format(date, dateFormat);
        }
    }

    /**
     * 在传入的日期基础上往后加n天
     *
     * @param date
     * @param n    要加的天数
     * @return
     */
    public static Date addDay(Date date, int n) {
        return DateUtils.addDays(date, n);
    }

    /**
     * 判断当前时间是否在开始时间与结束时间之间
     *
     * @param time  当前时间
     * @param begin 开始时间
     * @param end   结束时间
     * @return boolen类型，true表示在两者间，false表示不在两者之间
     */
    public static boolean isTimeIn(Date time, Date begin, Date end) {
        return time.getTime() >= begin.getTime() && time.getTime() <= end.getTime();
    }

    /**
     * 判断指定日期是星期几
     *
     * @param time   要判断的日期
     * @param format 输入的日期格式
     * @return 返回数字[1:星期一，2：星期二，....，7：星期日]
     * @throws ParseException
     */
    public static int getWeek(String time, String format) throws ParseException {
        return getWeek(DateUtils.parseDate(time, format));
    }

    /**
     * 判断指定日期是星期几
     *
     * @param date 要判断的日期
     * @return 返回数字[1:星期一，2：星期二，....，7：星期日]
     * @throws ParseException
     */
    public static int getWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int week = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            week = 7;
        } else {
            week = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return week;
    }

    /**
     * 判断是否为有效的身份证日期
     *
     * @param date
     * @return
     */
    public static boolean isIdDate(String date) {
        return isDateFormat(date, "yyyyMMdd");
    }

    /**
     * 判断传入的字符串dateStr是否是日期格式patternStr的字符串 @author yejg
     *
     * @param dateStr
     * @param patternStr
     * @return
     */
    public static boolean isDateFormat(String dateStr, String patternStr) {
        Date date = null;
        try {
            date = parse(dateStr, patternStr);
        } catch (Exception e) {
        }

        return date == null ? false : true;
    }

    /**
     * 将字符串日期转成Timestamp类型
     *
     * @param dateString 字符串类型的时间
     * @param format     字符串类型的时间要转换的格式
     * @return Timestamp类型的时间戳
     * @throws ParseException
     */
    public static java.sql.Timestamp parse2Timestamp(String dateString, String format) throws ParseException {
        return new java.sql.Timestamp(DateUtils.parseDate(dateString, format).getTime());
    }

    /**
     * 获取两个时间的间隔,字符串表示
     *
     * @param start
     * @param end
     * @return
     */
    public static String getDiffTimeStr(Date start, Date end) {
        String time = "";
        if (start != null && end != null) {
            int t = (int) (end.getTime() - start.getTime()) / 1000;
            String h = "";
            String m = "";
            String s = "";
            h = (int) t / 3600 + "";
            m = (int) (t % 3600) / 60 + "";
            s = t % 60 + "";
            if (h.length() <= 1) {
                h = "0" + h;
            }
            if (m.length() <= 1) {
                m = "0" + m;
            }
            if (s.length() <= 1) {
                s = "0" + s;
            }
            time = h + ":" + m + ":" + s;
        }
        return time;
    }

    /**
     * 获取两个日期之间间隔的分钟数
     *
     * @param startDate
     * @param endDate
     * @return
     * @author zhougz
     */
    public static int getIntervalMinute(Date startDate, Date endDate) {
        int min = 0;
        if (null != startDate && null != endDate) {
            long end = endDate.getTime();
            long start = startDate.getTime();
            long betweenDate = (end - start) / (60 * 1000);
            min = Long.valueOf(betweenDate).intValue();
        }
        return min;
    }

    /**
     * 获取两个日期之间间隔的天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getIntervalDay(Date startDate, Date endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            startDate = sdf.parse(sdf.format(startDate));
            endDate = sdf.parse(sdf.format(endDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(endDate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }


    /**
     * 根据类型参数返回不同的日期
     *
     * @param type <pre>     </pre>
     * @return 返回yyyy-MM-dd格式字符串
     */
    public static String getSpecifiedDay(String type) {
        String time = "";
        if ("today".equals(type)) {
            time = getCurrentTime(DATE_FORMAT);
        } else if ("yesterday".equals(type)) {
            Date yesterday = addDay(new Date(), -1);
            time = format(yesterday, DATE_FORMAT);
        } else if ("less7".equals(type)) {
            Date yesterday = addDay(new Date(), -6);
            time = format(yesterday, DATE_FORMAT);
        } else if ("less30".equals(type)) {
            Date yesterday = addDay(new Date(), -29);
            time = format(yesterday, DATE_FORMAT);
        } else if ("all".equals(type)) {
            // 取全部就设置截至时间为30年以前
            Date yesterday = addYears(new Date(), -29);
            time = format(yesterday, DATE_FORMAT);
        }
        return time;
    }

    /**
     * 星期转换为星期索引
     *
     * @param week
     * @return
     */
    public static int weekToNum(String week) {
        int weekNum = -1;
        for (int i = 0, j = WEEKS.length; i < j; i++) {
            if (week != null && WEEKS[i].toLowerCase().contains(week.toLowerCase())) {
                weekNum = i + 1;
                break;
            }
        }
        return weekNum;
    }

    public static Date LocalDateToUdate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static Date zonedDateToUdate(ZonedDateTime dateTime) {
        return Date.from(dateTime.toInstant());
    }

    /**
     * 获取过去第几天的日期
     *
     * @param intervals
     * @return
     */
    public static List<String> getPastDateList(int intervals) {
        ArrayList<String> pastDaysList = new ArrayList<>();
        for (int i = intervals; i > 0; i--) {
            pastDaysList.add(getPastDate(i));
        }
        return pastDaysList;
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }






    /**
     * 获得某天最大时间 （示例：2020-04-02 23:59:59）
     */
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()),
                ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * 获得此时的时间戳字符串(13位)
     */
    public static String getDateString() {
        long time = new Date().getTime();
        String s = String.valueOf(time);
        return s;
    }


    /**
     * 获得12小时后的时间戳字符串(13位)
     */
    public static String getDateStringOneDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY,24);
        Date time = calendar.getTime();
        long l = time.getTime();
        String s = String.valueOf(l);
        return s;
    }

}
