package com.test.base.zuul.fallBack.exc;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @Description: 对日期的处理的工具类
 * @author: renjun
 * @date: 2019年6月11日  下午3:55:24
 */
public class DateUtil {
	private static final Logger LOG = Logger.getLogger(DateUtil.class);
	//格式化模型
	public static final String NORMAL_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String NORMAL_DATE_FORMAR = "yyyy-MM-dd";
	public static final String NORMAL_DATE_FORMAR2 = "yyyy/MM/dd";
	public static final String HHMMSS = "HH:mm:ss";
	public static final String YEAR_FORMAT = "yyyy";
	public static final String YEAR_MONTH_SEP_FORMAT = "yyyy-MM";
	public static final String HOUR_MIN_SEP_FORMAT = "yyyy-MM-dd HH:mm";
	public static final String DAY_HOUR_SEP_FORMAT = "yyyy-MM-dd HH";
	public static final String YEAR_MONTH_FORMAT = "yyyyMM";
	public static final String MONTH_DAY_FORMAT = "yyyyMMdd";
	public static final String DAY_HOUR_FORMAT = "yyyyMMddHH";
	public static final String HOUR_MIN_FORMAT = "yyyyMMddHHmm";
	public static final String MIN_SECOND_FORMAT = "yyyyMMddHHmmss";
	
	/**
	* @Description: 按照格式转化字符串为时间类型
	*
	* @param:参数描述 字符串，格式
	* @return：返回结果描述 时间类型
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:24:40 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static Date parseDate(String dateString, String formate) {
		Date ret = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formate);
			sdf.setLenient(false);
			ret = sdf.parse(dateString);
		} catch (Exception e) {
			LOG.error(e, e);
		}
		return ret;
	}
	
	/**
	* @Description: 格式化日期
	*
	* @param:参数描述 java.util.Date
	* @return：返回结果描述 格式化日期
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:18:59 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String formatDate(Date date) {
		String ret = "";
		SimpleDateFormat sdf = new SimpleDateFormat(NORMAL_DATE_FORMAR);
		try {
			ret = sdf.format(date);
		} catch (Exception e) {
			LOG.error(e, e);
		}
		return ret;
	}
	
	/**
	* @Description: 格式化时间 精确到秒
	*
	* @param:参数描述 java.util.Date
	* @return：返回结果描述 格式化时间 精确到秒
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:20:21 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String formatTime(Date date) {
		String ret = "";
		SimpleDateFormat sdf = new SimpleDateFormat(NORMAL_TIME_FORMAT);
		try {
			ret = sdf.format(date);
		} catch (Exception e) {
			LOG.error(e, e);
		}
		return ret;
	}
	/**
	* @Description: 按传入格式 格式化日期或时间
	*
	* @param:参数描述 java.util.Date 格式
	* @return：返回结果描述 按传入格式 格式化日期或时间
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:21:44 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String formatDate(Date date, String format) {
		String ret = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			ret = sdf.format(date);
		} catch (Exception e) {
			LOG.error(e, e);
		}
		return ret;
	}
	/**
	* @Description: 当前时间向前或向后调整的多少
	*
	* @param:参数描述 调整幅度
	* @return：返回结果描述 调整后的结果
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:28:29 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static Date rollDate(int rollDateCount) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, rollDateCount);
		return cal.getTime();
	}
	/**
	* @Description: 指定时间向前或向后调整的多少
	*
	* @param:参数描述 指定时间 ，调整幅度
	* @return：返回结果描述 调整后的结果
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:30:02 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static Date rollDate(Date date, int rollDateCount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, rollDateCount);
		return cal.getTime();
	}
	
	/**
	* @Description: 根据格式获取当前时间的字符串
	*
	* @param:参数描述 格式 
	* @return：返回结果描述 格式为null 精确到秒  其他按格式返回
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:35:25 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String getNow(String format) {
		SimpleDateFormat sdf = null;
		if (format != null) {
			sdf = new SimpleDateFormat(format);
		} else {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		Calendar cal = Calendar.getInstance();
		return sdf.format(cal.getTime());
	}
	
	/**
	* @Description: 获取当前天的Date
	*
	* @param:参数描述
	* @return：返回结果描述 Date
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:37:44 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static Date getNowDate() {
		return new Date();
	}
	
	public static String getNowDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		return sdf.format(cal.getTime());
	}
	
	/**
	* @Description: 格式化当前天
	*
	* @param:参数描述 字符串时间
	* @return：返回结果描述 Date
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:40:00 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static Date parseDate(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(s);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	* @Description: 获取当前时间
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:29:23 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String getNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		return sdf.format(cal.getTime());
	}
	
	/**
	* @Description: 获取上一天的时间
	*
	* @param:参数描述
	* @return：返回结果描述 上一天时间元素的字符串数组
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:42:18 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String[] getLastDay() {
		String[] result = new String[2];
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		result[0] = formatDate(calendar.getTime());
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		result[1] = formatDate(calendar.getTime(), NORMAL_TIME_FORMAT);
		return result;
	}
	
	/**
	* @Description: 获取月末最后一日
	*
	* @param:参数描述 年 月
	* @return：返回结果描述 月末最后一日
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:44:19 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String getMonthLastDay(String year, String month) {
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month.startsWith("0") ? month.substring(1) : month) - 1;
		String result = "";
		Calendar calendar = Calendar.getInstance();
		calendar.set(y, m, 1);
		calendar.add(GregorianCalendar.MONTH, 1);
		calendar.add(GregorianCalendar.DATE, -1);
		result = formatDate(new java.sql.Date(calendar.getTime().getTime())) + " 23:59:59";
		return result;
	}
	
	/**
	* @Description: 获取上一周, 自然周(从周日到周六)
	*
	* @param:参数描述
	* @return：返回结果描述 获取上一周, 自然周(从周日到周六)
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:46:39 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String[] getLastWeek() {
		String[] result = new String[2];
		Calendar calendar = Calendar.getInstance();
		int minus = calendar.get(GregorianCalendar.DAY_OF_WEEK);
		calendar.add(GregorianCalendar.DATE, -minus);
		calendar.set(GregorianCalendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		result[0] = formatDate(calendar.getTime());
		calendar.add(GregorianCalendar.DATE, 6);
		result[1] = formatDate(calendar.getTime());
		return result;
	}
	
	/**
	* @Description: 获取上一周，倒推7天
	*
	* @param:参数描述
	* @return：返回结果描述 获取上一周，倒推7天
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:47:29 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String[] getLastNaturalWeek() {
		String[] result = new String[2];
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		result[1] = formatDate(calendar.getTime());
		calendar.add(GregorianCalendar.DATE, -7);
		result[0] = formatDate(calendar.getTime());
		return result;
	}
	
	/**
	* @Description: 获取一个月，自然月(1~月末)
	*
	* @param:参数描述
	* @return：返回结果描述 获取一个月，自然月(1~月末)
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:49:49 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String[] getMonth(String year, String month) {
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month.startsWith("0") ? month.substring(1) : month) - 1;
		String[] result = new String[2];
		Calendar calendar = Calendar.getInstance();
		calendar.set(y, m, 1);
		result[0] = formatDate(new java.sql.Date(calendar.getTime().getTime()));
		calendar.add(GregorianCalendar.MONTH, 1);
		calendar.add(GregorianCalendar.DATE, -1);
		result[1] = formatDate(new java.sql.Date(calendar.getTime().getTime())) + " 23:59:59";
		return result;
	}
	
	/**
	* @Description: 获取完整月区间，自然月(1~月末)
	*
	* @param:参数描述
	* @return：返回结果描述 获取完整月区间，自然月(1~月末)
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:50:50 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String[] getMonth(String startYear, String startMonth, String endYear, String endMonth) {
		
		int startY = Integer.parseInt(startYear);
		int startM = Integer.parseInt(startMonth.startsWith("0") ? startMonth.substring(1) : startMonth) - 1;
		
		String[] result = new String[2];
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(startY, startM, 1);
		result[0] = formatDate(new java.sql.Date(calendar.getTime().getTime()));
		
		int endY = Integer.parseInt(endYear);
		int endM = Integer.parseInt(endMonth.startsWith("0") ? endMonth.substring(1) : endMonth) - 1;
		
		calendar.set(endY, endM, 1);
		calendar.add(GregorianCalendar.MONTH, 1);
		calendar.add(GregorianCalendar.DATE, -1);
		result[1] = formatDate(new java.sql.Date(calendar.getTime().getTime())) + " 23:59:59";
		
		return result;
	}
	/**
	* @Description: 获取上一月，自然月(1~月末)
	*
	* @param:参数描述
	* @return：返回结果描述 获取上一月，自然月(1~月末)
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:51:43 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String[] getLastMonth() {
		String[] result = new String[2];
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(calendar.get(GregorianCalendar.YEAR), calendar.get(GregorianCalendar.MONTH), 1);
		calendar.add(GregorianCalendar.DATE, -1);
		result[1] = formatDate(new java.sql.Date(calendar.getTime().getTime()));
		
		calendar.add(GregorianCalendar.DATE, -(calendar.get(GregorianCalendar.DATE) - 1));
		result[0] = formatDate(new java.sql.Date(calendar.getTime().getTime()));
		return result;
	}
	/**
	* @Description: 获取上一月，倒推30天
	*
	* @param:参数描述
	* @return：返回结果描述 获取上一月，倒推30天
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:52:36 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String[] getLastNaturalMonth() {
		String[] result = new String[2];
		Calendar calendar = Calendar.getInstance();
		
		calendar.add(GregorianCalendar.DATE, -1);
		result[1] = formatDate(new java.sql.Date(calendar.getTime().getTime()));
		
		calendar.add(GregorianCalendar.DATE, -30);
		result[0] = formatDate(new java.sql.Date(calendar.getTime().getTime()));
		
		return result;
	}
	/**
	* @Description: 获取当前月初时间
	*
	* @param:参数描述
	* @return：返回结果描述 当前月初时间
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:15:32 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String getFirstDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return formatDate(calendar.getTime());
	}
	/**
	* @Description: 根据条件获取 日期  例如2001-9  获取：2001-09-1
	*
	* @param:参数描述 条件
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:16:27 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String getQueryFirstDayOfMonth(String query) {
		if (null != query && !query.trim().equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String[] day = query.split("-");
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, Integer.parseInt(day[0]));
			calendar.set(Calendar.MONTH, Integer.parseInt(day[1]) - 1);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			return sdf.format(calendar.getTime());
		}
		return "";
	}
	/**
	* @Description: 根据条件获取 日期  例如2001-9  获取：2001-09-30
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:17:56 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String getQueryLastDayOfMonth(String query) {
		if (null != query && !query.trim().equals("")) {
			String[] day = query.split("-");
			return getMonthLastDay(day[0], day[1]);
		}
		return "";
	}
	/**
	* @Description: 时间分割功能
	*
	* @param:参数描述 传入yyyy-MM-dd HH:mm:ss 
	* @return：返回结果描述  分割成1 yyyy-MM-dd      2 HH: 3 mm: 4 ss
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:18:52 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String[] splitDateTime(String time) {
		String[] result = {"", "", "", "" };
		if (time == null || time.length() < 1) {
			return result;
		}
		if (time.split(" ").length > 0) {
			result[0] = time.split(" ")[0];
			String hours = time.split(" ")[1];
			if (hours.split(":").length > 0) {
				result[1] = hours.split(":")[0];
				result[2] = hours.split(":")[1];
				result[3] = hours.split(":")[2];
			}
		}
		
		return result;
	}
	/**
	* @Description: 获取时间的年
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:23:00 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static Integer getYear(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat(NORMAL_DATE_FORMAR);
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(time));
			return cal.get(Calendar.YEAR);
		} catch (Exception e) {
			LOG.error(e, e);
			return null;
		}
	}
	/**
	* @Description: 获取时间的月（1-12）
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:24:06 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static Integer getMonth(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat(NORMAL_DATE_FORMAR);
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(time));
			return cal.get(Calendar.MONTH) + 1;
		} catch (Exception e) {
			LOG.error(e, e);
			return null;
		}
	}
	/**
	* @Description: 获取时间的小时数（24小时制）
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:25:36 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static Integer getHour(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat(NORMAL_TIME_FORMAT);
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(time));
			return cal.get(Calendar.HOUR_OF_DAY);
		} catch (Exception e) {
			LOG.error(e, e);
			return null;
		}
	}
	
	/**
	* @Description: 获取n个月前时间
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:27:37 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String getPreMonth(int monthNum) {
		if (monthNum - (DateUtil.getMonth(DateUtil.getNow()) - 1) > 0) {
			//跨年
			if ((monthNum - (DateUtil.getMonth(DateUtil.getNow()) - 1)) / 12 > 0) {
				//跨多年
				return (DateUtil.getYear(DateUtil.getNow())
				        - ((monthNum - (DateUtil.getMonth(DateUtil.getNow()) - 1)) % 12 == 0 ? 0 : 1)
				        - (monthNum - (DateUtil.getMonth(DateUtil.getNow()) - 1)) / 12) + "-"
				        + (12 - (monthNum - DateUtil.getMonth(DateUtil.getNow())) % 12);
			} else {
				return (DateUtil.getYear(DateUtil.getNow()) - 1) + "-"
				        + (12 - (monthNum - DateUtil.getMonth(DateUtil.getNow())));
			}
		} else {
			return DateUtil.getYear(DateUtil.getNow()) + "-" + ((DateUtil.getMonth(DateUtil.getNow()) - monthNum));
		}
	}
	
	/**
	* @Description: 两个时间相差的月数
	*
	* @param:参数描述 日期1 日期2
	* @return：返回结果描述 相差的月数
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:54:00 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static int getMonthSub(String date1, String date2) {
		String yearStr1 = date1.split("-")[0];
		String monthStr1 = date1.split("-")[1];
		String dayStr1 = date1.split("-")[2];
		int year1 = Integer.parseInt(yearStr1);
		int month1 = Integer.parseInt(monthStr1.startsWith("0") ? monthStr1.substring(1) : monthStr1);
		int day1 = Integer.parseInt(dayStr1.startsWith("0") ? dayStr1.substring(1) : dayStr1);
		
		String yearStr2 = date2.split("-")[0];
		String monthStr2 = date2.split("-")[1];
		String dayStr2 = date2.split("-")[2];
		int year2 = Integer.parseInt(yearStr2);
		int month2 = Integer.parseInt(monthStr2.startsWith("0") ? monthStr2.substring(1) : monthStr2);
		int day2 = Integer.parseInt(dayStr2.startsWith("0") ? dayStr2.substring(1) : dayStr1);
		
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(year1, month1, day1);
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(year2, month2, day2);
		
		int m = calendar2.get(Calendar.MONTH) - calendar1.get(Calendar.MONTH);
		int y = calendar2.get(Calendar.YEAR) - calendar1.get(Calendar.YEAR);
		
		return y * 12 + m;
	}
	
	public static int daysBetween(Date now, Date returnDate) {
		Calendar cNow = Calendar.getInstance();
		Calendar cReturnDate = Calendar.getInstance();
		cNow.setTime(now);
		cReturnDate.setTime(returnDate);
		setTimeToMidnight(cNow);
		setTimeToMidnight(cReturnDate);
		long todayMs = cNow.getTimeInMillis();
		long returnMs = cReturnDate.getTimeInMillis();
		long intervalMs = todayMs - returnMs;
		return millisecondsToDays(intervalMs);
	}
	
	/**
	* @Description: 两个时间的天数差
	*
	* @param:参数描述 时间0  时间1
	* @return：返回结果描述 天数差
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:56:44 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static Integer getDaySub(String date0, String date1) {
		int result = -1;
		try {
			Calendar startDay = Calendar.getInstance();
			Calendar endDay = Calendar.getInstance();
			startDay.setTime(DateUtil.parseDate(date0));
			endDay.setTime(DateUtil.parseDate(date1));
			
			if (startDay.get(Calendar.YEAR) == endDay.get(Calendar.YEAR)) {
				return endDay.get(Calendar.DAY_OF_YEAR) - startDay.get(Calendar.DAY_OF_YEAR);
			} else {
				Calendar tmp = Calendar.getInstance();
				result = startDay.getActualMaximum(Calendar.DAY_OF_YEAR) - startDay.get(Calendar.DAY_OF_YEAR);
				for (int i = startDay.get(Calendar.YEAR) + 1; i < endDay.get(Calendar.YEAR); i++) {
					tmp.set(i, tmp.get(Calendar.MONTH), tmp.get(Calendar.DAY_OF_MONTH));
					result += tmp.getActualMaximum(Calendar.DAY_OF_YEAR);
				}
				result += endDay.get(Calendar.DAY_OF_YEAR);
			}
			return result;
		} catch (Exception e) {
			LOG.error(e, e);
			return null;
		}
		
	}
	/**
	 * 
	* @Description: 获取两个日期之间的天数差 
	*                getDaySub() 方法当不是同一年的时候会返回正数。
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:58:19 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static int getDaySubReplace(String date0, String date1) {
		int result = -1;
		try {
			Calendar startDay = Calendar.getInstance();
			Calendar endDay = Calendar.getInstance();
			startDay.setTime(DateUtil.parseDate(date0));
			endDay.setTime(DateUtil.parseDate(date1));
			result = endDay.get(Calendar.DAY_OF_YEAR) - startDay.get(Calendar.DAY_OF_YEAR);
		} catch (Exception e) {
			
		}
		return result;
	}
	/**
	 * 
	* @Description: 获取小时差
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午5:59:51 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static int getHoureSub(String date0, String date1) {
		int result = -1;
		try {
			Calendar startDay = Calendar.getInstance();
			Calendar endDay = Calendar.getInstance();
			startDay.setTime(parseDate(date0, NORMAL_TIME_FORMAT));
			endDay.setTime(parseDate(date1, NORMAL_TIME_FORMAT));
			long res = (endDay.getTimeInMillis() - startDay.getTimeInMillis()) / (1000 * 60 * 60L);
			result = (int) res;
		} catch (Exception e) {
			
		}
		return result;
	}
	/**
	* @Description: 获取分钟差
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:00:14 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static int getMinuteSub(String date0, String date1) {
		int result = -1;
		try {
			Calendar startDay = Calendar.getInstance();
			Calendar endDay = Calendar.getInstance();
			startDay.setTime(parseDate(date0, NORMAL_TIME_FORMAT));
			endDay.setTime(parseDate(date1, NORMAL_TIME_FORMAT));
			long res = (endDay.getTimeInMillis() - startDay.getTimeInMillis()) / (1000 * 60L);
			result = (int) res;
		} catch (Exception e) {
			
		}
		return result;
	}
	/**
	* @Description: 获取两个时间的毫秒差
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:01:06 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static long getMilliseconds(Date now, Date returnDate) {
		Calendar cNow = Calendar.getInstance();
		Calendar cReturnDate = Calendar.getInstance();
		cNow.setTime(now);
		cReturnDate.setTime(returnDate);
		long todayMs = cNow.getTimeInMillis();
		long returnMs = cReturnDate.getTimeInMillis();
		long intervalMs = todayMs - returnMs;
		return intervalMs;
	}
	private static int millisecondsToDays(long intervalMs) {
		return (int) (intervalMs / (1000 * 86400));
	}
	private static void setTimeToMidnight(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
	}
	/**
	* @Description: 获取半小时前时间
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:04:08 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String getLastHalfHour() {
		Calendar cNow = Calendar.getInstance();
		cNow.add(Calendar.MINUTE, -30);
		return formatDate(cNow.getTime(), NORMAL_TIME_FORMAT);
	}
	/**
	* @Description: 获取某个minute的时间
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:04:53 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String getTimeBeforeMinutes(int minute) {
		Calendar cNow = Calendar.getInstance();
		cNow.add(Calendar.MINUTE, minute);
		return formatDate(cNow.getTime(), NORMAL_TIME_FORMAT);
	}
	/**
	 * 
	 * @Function: com.asiainfo.zdws.util
	 * @Description: 
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author:  renjun
	 * @date: 2015-1-16 下午1:02:13 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2015-1-16     renjun          v1.0.0             修改原因
	 */
	@SuppressWarnings("static-access")
	public static Date getBeforeDate(int n) {
		Calendar theCa = Calendar.getInstance();
		theCa.setTime(new Date());
		theCa.add(theCa.DATE, -n);
		Date date = theCa.getTime();
		return date;
	}
	
	/**
	 * 
	* @Description: 获取+day -day 格式化天
	*
	* @param:参数描述 +day/ -day
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:06:46 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static String getForwardFromDate(String date, int days) {
		String newDate = "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.parseDate(date));
		calendar.add(Calendar.DAY_OF_YEAR, days);
		newDate = DateUtil.formatDate(calendar.getTime());
		return newDate;
	}
	
	/**
	* @Description: 获取一个日期区间段内的所有日期
	*
	* @param:参数描述 时间1 时间2
	* @return：返回结果描述 一个日期区间段内的所有日期
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:08:59 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static List<String> getDates(String date0, String date1) {
		
		List<String> list = new ArrayList<String>();
		
		Calendar calendar0 = Calendar.getInstance();
		Calendar calendar1 = Calendar.getInstance();
		
		calendar0.setTime(DateUtil.parseDate(date0));
		calendar1.setTime(DateUtil.parseDate(date1));
		
		while (calendar0.compareTo(calendar1) <= 0) {
			String date = DateUtil.formatDate(calendar0.getTime());
			list.add(date);
			calendar0.add(Calendar.DAY_OF_YEAR, 1);
		}
		return list;
	}
	
	/**
	* @Description: 获取一个日期区间段内,每半小时时间间隔的所有时间段
	*
	* @param:参数描述 date0: 起始日期，date1:结束日期，startHour:每日起始小时，endHour：每日结束小时
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:10:29 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static List<String[]> getHalfHourDateList(String date0, String date1, int startHour, int endHour) {
		List<String[]> list = new ArrayList<String[]>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c1.setTime(sdf.parse(date0));
			c2.setTime(sdf.parse(date1));
		} catch (Exception e) {
			LOG.error(e, e);
			return null;
		}
		if (endHour == 0) {
			endHour = 24;
		}
		while (c2.after(c1)) {
			if (c1.get(Calendar.HOUR_OF_DAY) >= endHour || c1.get(Calendar.HOUR_OF_DAY) < startHour) {
				c1.add(Calendar.MINUTE, 30);
				continue;
			}
			String[] date = new String[2];
			String startDate = formatDate(c1.getTime(), "yyyy-MM-dd HH:mm");
			c1.add(Calendar.MINUTE, 30);
			String endDate = formatDate(c1.getTime(), "yyyy-MM-dd HH:mm");
			date[0] = startDate;
			date[1] = endDate;
			list.add(date);
		}
		return list;
	}
	
	/**
	* @Description: 比较时间
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:11:46 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static Integer compareTime(String time1, String time2) {
		Integer flag = null;
		try {
			Date dt1 = parseDate(time1, NORMAL_TIME_FORMAT);
			Date dt2 = parseDate(time2, NORMAL_TIME_FORMAT);
			if (dt1.getTime() > dt2.getTime()) {
				flag = 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				flag = -1;
			} else {
				flag = 0;
			}
		} catch (Exception e) {
			LOG.error(e, e);
		}
		return flag;
	}
	
	/**
	* @Function:com.esim.util.DateUtil
	* @Description: 转换为 yyyy-MM-dd HH:mm:ss
	* @param s
	* @return
	* @version: v1.0.0
	* @author: renjun
	* @date: 2016-9-19  上午10:35:03
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2016-9-19      renjun           v1.0.0             修改原因
	*/
	public static Date parseNormalTime(String s) {
		if (StringUtils.isEmpty(s)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(NORMAL_TIME_FORMAT);
		try {
			return sdf.parse(s);
		} catch (Exception e) {
			LOG.error(e, e);
			return null;
		}
	}
	/**
	* @Description: 判断时间是否在该范围
	*
	* @param:参数描述
	* @return：返回结果描述 是 true 否 false
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-3 下午6:21:10 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-3     songhongxu           v1.0.0               创建
	 */
	public static boolean isRangeTime(Calendar ca, int start, int end) {
		if (start <= ca.get(Calendar.HOUR_OF_DAY) && ca.get(Calendar.HOUR_OF_DAY) < end) {
			return true;
		}
		return false;
	}
	/**
	* @Description: Timestamp转化为String 
	*
	* @param:参数描述  timeStamp Timestamp时间  format格式化类型
	* @return：返回结果描述Timestamp转化为格式化的String 
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-12 上午10:38:04 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-12     songhongxu           v1.0.0               创建
	 */
	public static String timestamp2String(Timestamp timeStamp, String format) {
		String str = "";
		SimpleDateFormat sdf = null;
		if (format != null) {
			sdf = new SimpleDateFormat(format);
		} else {
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		}
		str = sdf.format(timeStamp);
		return str;
	}
	/**
	* @Description: String2Timestamp
	* @param:参数描述  timeStr 要转化的时间字符串
	* @return：返回结果描述
	* @throws：异常描述
	* @version: v1.0.0
	* @author: songhongxu
	* @date: 2014-6-12 上午10:49:42 
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2014-6-12     songhongxu           v1.0.0               创建
	 */
	public static Timestamp string2Timestamp(String timeStr) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			ts = Timestamp.valueOf(sdf.format(sdf.parse(timeStr)));
			return ts;
		} catch (Exception e) {
			LOG.error(e, e);
			return null;
		}
	}
	/**
	* @Description: 返回当前日期的
	* @param:
	* @return：返回结果描述
	* @throws：异常描述
	* @version: v1.0.0
	* @author: nanbo
	* @date: 2016-4-12 
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2016-4-12     nanbo           v1.0.0               创建
	 */
	public static String getLastDay(Date date) {
		SimpleDateFormat matter1 = new SimpleDateFormat("yyyyMMdd");
		String time = matter1.format(date);
		return time;
	}
	/**
	 * @Function: OrderImeiTest::getDateFromNow
	 * @Description: 取以基准时间往前或往后amount个时间单位的时间
	 * @param nowDate : 基准时间，以nowDate为基准取nowDate前一段时间或后一段时间
	 * @param field : 选择时间单位只能输入1到14间的数字
	 *               1：以年为单位
	 *               2：以月为单位
	 *           3，4，8：以周为单位
	 *           5，6，7：以天为单位
	 *               9：以半天(12小时)为单位
	 *          10，11：以小时为单位
	 *              12：以分钟为单位
	 *              13：以秒为单位
	 *              14：返回当前时间(没用)
	 * @param amount：正整数时：基准时间往后amount个时间单位
	 *                负整数：基准时间往前amount个时间单位
	 * @return
	 * @version: v1.0.0
	 * @author: chenkaixin
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2017-11-24     chenkaixin           v1.0.0               新建
	 */
	public static Date getDateFromNow(Date nowDate, int field, int amount) {
		if (field < 1 || field > 14) {
			return nowDate;
		}
		Calendar cl = Calendar.getInstance();
		cl.setTime(nowDate);
		cl.add(field, amount);
		Date beforeDate = cl.getTime();
		return beforeDate;
	}
	/**
	 * @Description: date01-date02 
	 * @param:date01  减数
	 * @param:date02  被减数
	 * @return：返回相差分钟数
	 * @throws：异常描述
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2015-3-18     renjun          v1.0.0             修改原因
	 */
	public static Long subtraction(Date date01, Date date02) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date01);
		Long l1 = c1.getTimeInMillis();
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date02);
		Long l2 = c2.getTimeInMillis();
		Long subResult = Math.abs((l1 - l2) / 1000 / 60);
		return subResult;
	}
	
	/**
	 * @param date
	 * @param month
	 * @description 获得传入日期前n个月
	 */
	public static Date getLastMonth(Date date, Integer month) {
		if (month < 0) {
			month = 1; //默认为1个月
		}
		if (date == null) {
			date = new Date(System.currentTimeMillis());
		}
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.MONTH, -month);
		Date dateFrom = cl.getTime(); //一个月前时间
		return dateFrom;
	}
	/**
	 * @param month
	 * @description 获得当前时间前1个月的时间
	 */
	public static Date getCurDateLastMonth(Integer month) {
		return getLastMonth(null, month);
	}
	
	/**
	 * @Description: 获取给定时间之前的时间
	 * @version: v1.0.0
	 * @author: ChenPing
	 */
	public static Date getLastDate(Date date, Integer type, Integer last) {
		if (date == null) {
			date = new Date(System.currentTimeMillis());
		}
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(type, -last);
		Date dateFrom = cl.getTime();
		return dateFrom;
	}
	public static List<String> getQuarterList() {
		List<String> bbList = new ArrayList<String>();
		for (int i = 1; i < 9; i++) {
			String period = DateUtil.getLastQuarterStartMonth(i)
					+ "-" + DateUtil.getLastQuarterEndMonth(i);
			bbList.add(period);
		}
		return bbList;
	}
	//获得季度的开端年-月份 列【201701】
	public static String getLastQuarterStartMonth(int interval) {
		Date sysDate = new Date();
		Calendar calTime = Calendar.getInstance();
		calTime.setTime(sysDate);
		calTime.add(Calendar.MONTH, -3 * interval);
		calTime.set(Calendar.MONTH, ((int) calTime.get(Calendar.MONTH) / 3) * 3);
		calTime.set(Calendar.DATE, 1);
		Date startCreateTime = calTime.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		return sdf.format(startCreateTime);
	}
	//获得季度的结束年-月份 列【201703】
	public static String getLastQuarterEndMonth(int interval) {
		Date sysDate = new Date();
		Calendar calTime = Calendar.getInstance();
		calTime.setTime(sysDate);
		calTime.add(Calendar.MONTH, -3 * interval);
		calTime.set(Calendar.MONTH, ((int) calTime.get(Calendar.MONTH) / 3) * 3 + 2);
		calTime.set(Calendar.DATE, 1);
		Date startCreateTime = calTime.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		return sdf.format(startCreateTime);
	}
	/**
	 * scm对账周期为上一周期时 前台必须在当季度10号一号可以查询
	 * @param period scm对账周期
	 * @return
	 */
	public static boolean hasPermission(String period) {
		if (StringUtils.isEmpty(period)) {
			return false;
		}
		String lastperiod = DateUtil.getLastQuarterStartMonth(1)
				+ "-" + DateUtil.getLastQuarterEndMonth(1);
		if (lastperiod.equals(period)) {
			Date sysDate = new Date();
			Calendar calTime = Calendar.getInstance();
			calTime.setTime(sysDate);
			calTime.set(Calendar.MONTH, ((int) calTime.get(Calendar.MONTH) / 3) * 3);
			calTime.set(Calendar.DATE, 10); //10号
			calTime.set(Calendar.HOUR_OF_DAY, 8);
			calTime.set(Calendar.MINUTE, 0);
			calTime.set(Calendar.SECOND, 0);
			Date startCreateTime = calTime.getTime();
			return sysDate.after(startCreateTime);
		} else {
			return true;
		}
	}
	/**
	 * scm对账周期为上一周期时 后台必须在当季度8号一号可以查询
	 * @param period scm对账周期
	 * @return boolean
	 */
	public static boolean hasPermissionAdmin(String period) {
		if (StringUtils.isEmpty(period)) {
			return false;
		}
		String lastperiod = DateUtil.getLastQuarterStartMonth(1)
				+ "-" + DateUtil.getLastQuarterEndMonth(1);
		if (lastperiod.equals(period)) {
			Date sysDate = new Date();
			Calendar calTime = Calendar.getInstance();
			calTime.setTime(sysDate);
			calTime.set(Calendar.MONTH, ((int) calTime.get(Calendar.MONTH) / 3) * 3);
			calTime.set(Calendar.DATE, 8); //8号
			calTime.set(Calendar.HOUR_OF_DAY, 8);
			calTime.set(Calendar.MINUTE, 0);
			calTime.set(Calendar.SECOND, 0);
			Date startCreateTime = calTime.getTime();
			return sysDate.after(startCreateTime);
		} else {
			return true;
		}
	}
	public static String dateToStr(Date date, String format) {
    	SimpleDateFormat formatter = new SimpleDateFormat(format);
    	return formatter.format(date);
    }
}
