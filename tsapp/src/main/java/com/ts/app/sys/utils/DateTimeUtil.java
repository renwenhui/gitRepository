package com.ts.app.sys.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class DateTimeUtil{
	
	/**
	 * @Title: getFormatTime
	 * @Description: 根据传入时间格式，获取当前时间
	 * @param: @param format
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public static String getFormatTime(String format) {
		return getFormatTime(new Date(), format);
	}
	
	/**
	 * @Title: getFormatTime
	 * @Description: 将Date转换所需要格式的日期字符串 
	 * @param: @param date
	 * @param: @param format
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public static String getFormatTime(Date date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	
	/**
	 * @Title: getDateString14
	 * @Description: 获取当前时间(yyyyMMddHHmmss)的时间
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public static String getDateString14() {
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMddHHmmss"); 
		return fm.format(new Date());
	}

	/**
	 * @Title: getTimeString
	 * @Description: 获取当前时间(HH:mm:ss)的时间
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public static String getTimeString() {
		SimpleDateFormat fm = new SimpleDateFormat("HH:mm:ss");
		return fm.format(new Date());
	}
	
	/**
	 * @Title: getDateString19
	 * @Description: 获取当前时间(yyyy-MM-dd HH:mm:ss)的时间
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public static String getDateString19() {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return fm.format(new Date());
	}
	
	public static String getYtDateString(){
		Calendar calendar = Calendar.getInstance(); 
		GregorianCalendar gc = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 
				calendar.get(Calendar.DAY_OF_MONTH)); 
		gc.add(Calendar.DATE,-1); 
		Date date= (Date)gc.getTime();
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd"); 
		return fm.format(date);
	}
	
	/**
	 * @Title: getNextDayString
	 * @Description: 得到+1天的日期
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public static String getNextDayString(){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return sf.format(calendar.getTime());
	}
	
	public static String getAnyDateString(int calType, int num){
		Calendar calendar = Calendar.getInstance(); 
		GregorianCalendar gc =new GregorianCalendar(calendar.get(Calendar.YEAR),   calendar.get(Calendar.MONTH), 
				calendar.get(Calendar.DAY_OF_MONTH)); 
		gc.add(calType,num); 
		Date date = (Date)gc.getTime();
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd");
		return fm.format(date);
	}
	
	/**
	 * 格式化时间戳为字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatTimestamp2String(Timestamp date,String format){
		if(null==date)return null;
		if(null==format||("").equals(format))return null;
		return new SimpleDateFormat(format).format(date);
	}
	/**
	 * 格式化Date为字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatTimestamp2String(Date date,String format){
		if(null==date)return null;
		if(null==format||("").equals(format))return null;
		return new SimpleDateFormat(format).format(date);
	}
	/**
	 * 格式化字符串为时间戳
	 * @param date
	 * @param format
	 * @return
	 */
	public static Timestamp formatString2Timestamp(String date,String format){
		if(null==date||("").equals(date))return null;
		if(null==format||("").equals(format))return null;
		return new Timestamp(formatStringToDate(date,format).getTime());
	}

	/** 获取当前时间的时间戳
	 * @param args
	 * @throws ParseException 
	 */
	public static String getTimestamp() throws ParseException {
		   String res;
		   String format = "yyyy-MM-dd HH:mm:ss";
	       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
	       String formatDate = formatTimestamp2String(new Date(),format);
	       Date date = simpleDateFormat.parse(formatDate);
	       long ts = date.getTime();
	       res = String.valueOf(ts);
	       return res;
	}
	

	/**
	 * 获取当指定时间的时间戳 yyyy-MM-dd HH:mm:ss
	 * @param args
	 * @throws ParseException 
	 */
	public static String getTimestamp(String dateStr) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = format.parse(dateStr);
		long ts = date.getTime();
		String res = String.valueOf(ts);
		return res;
	}
	
    /** 
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
	
	/**
	 * 将日期格式的字符串转换为日期
	 * @param date 源日期字符串
	 * @param format 源日期字符串格式
	 */
	public static Date formatStringToDate(String date,String format){
		if(null==date||("").equals(date))return null;
		if(null==format||("").equals(format))return null;
		SimpleDateFormat format2 = new SimpleDateFormat(format);
		try{
			Date newDate = format2.parse(date);
			return newDate;
		}catch(Exception ex){
			throw new RuntimeException(ex.getMessage());
		}
	}
	
	
	public static Timestamp addDay(Timestamp date,int day){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return new Timestamp(cal.getTimeInMillis());
	}
	
	/**
	 * 将日期格式的字符串格式化成指定的日期格式
	 * @param dateStr 源日期字符串
	 * @param formatStr1 源日期字符串日期格式
	 * @param formatStr2 新日期字符串日期格式
	 */
	public static String formatDateStringToString(String dateStr,String formatStr1,String formatStr2){
		SimpleDateFormat format = new SimpleDateFormat(formatStr1);
		SimpleDateFormat format2 = new SimpleDateFormat(formatStr2);
		try{
			if(null==dateStr||("").equals(dateStr))return "";
			Date date = format.parse(dateStr);
			return format2.format(date);
		}catch(Exception ex){
			ex.printStackTrace();
			return "";
		}
	}
	
	/**
	 * yyyyMMdd 与 yyyy-MM-dd日期格式转换
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String dateFormate(String date, String regex){
		SimpleDateFormat sdf_sim = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf_more = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf_target = new SimpleDateFormat(regex);
		try{
			if(date==null || "".equals(date)){
				return "";
			}else if(date.contains("-")){
				return sdf_target.format(sdf_more.parse(date));
			}else{
				return sdf_target.format(sdf_sim.parse(date));
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/***
	* 计算2个日期之间的天数
	* @param beginTime
	* @param endTime
	* @return 相差的天数
	 * @throws ParseException 
	* @throws BusinessException
	*/
	public float getDate(String beginTime,String endTime) throws ParseException 
	{
	SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	
	Date begin = s.parse(beginTime);
	Date end = s.parse(endTime);
	float time = (end.getTime()-begin.getTime())/1000/60/60/24;
	return time;	
	}
	
    /**
     * 两个时间相差距离多少天多少小时多少分多少秒
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00
     * @return long 返回值为：{天, 时, 分, 秒}
     */
    public static Map getDistanceTimes(String str1, String str2) {
    	Map map = Maps.newHashMap();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date one;
        Date two;
        long diffDay = 0;
        long diffHour = 0;
        long diffMin = 0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            diffDay = diff / (24 * 60 * 60 * 1000);
            diffHour = (diff / (60 * 60 * 1000) - diffDay * 24);
            diffMin = ((diff / (60 * 1000)) - diffDay * 24 * 60 - diffHour * 60);
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        map.put("diffDay", diffDay);
        map.put("diffHour", diffHour);
        map.put("diffMin", diffMin);
        return map;
    }	
    
    /*
     * 比较当前时间和 startDate、endDate的大小
     */
    public static int compare_date(String startDateStr,String endDateStr) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
        	Date cunrrentDate = new Date();
            Date startDate = df.parse(startDateStr);
            Date endDate = df.parse(endDateStr);
            long currentTime = cunrrentDate.getTime();
            long startTime = startDate.getTime();
            long endTime = endDate.getTime();
            if(currentTime < startTime){
            	System.out.println("currentTime早于startTime");
            	return 1;
            }else if(currentTime > endTime){
            	System.out.println("currentTime晚于endTime");
            	return -1;
            }else{
            	System.out.println("currentTime在startTime和endTime之间");
            	return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    
    public static int compare_date(String DATE1, String DATE2,String format) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    
    public static long getDistanceDays(String str1, String str2) {
    	Map map = Maps.newHashMap();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date one;
        Date two;
        long diffDay = 0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            diffDay = diff / (24 * 60 * 60 * 1000);
            
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diffDay;
    }	
  
	/**
	 * 计算两个日期区间的的全部日期（包括开始且不包括结束日期）
	 */
    public static List<String> countDateBetween(String startDate, String endDate) {
    	List<String> dateList = Lists.newArrayList();
    	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try{
            Calendar startDay = Calendar.getInstance();
            Calendar endDay = Calendar.getInstance();
            startDay.setTime(formatter.parse(startDate));
            endDay.setTime(formatter.parse(endDate));
            dateList.add(startDate);
            if(!startDate.equals(endDate)){
                if(startDay.compareTo(endDay)<=0){
                    //现在打印中的日期
                    Calendar currentPrintDay = startDay;
                    while (true){
                        // 日期加一
                        currentPrintDay.add(Calendar.DATE, 1);
                        // 日期加一后判断是否达到终了日，达到则终止打印
                        if (currentPrintDay.compareTo(endDay) == 0) {
                            break;
                        }
                        dateList.add(formatter.format(currentPrintDay.getTime()));
                    }
                    //dateList.add(endDate);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
		return dateList;
    }
    
    public static void main(String[] args) throws ParseException{
    	String stampToDate = stampToDate("1480499570111");
    	System.out.println(stampToDate);
    	getDistanceTimes("2017-06-20 15:40:00","2017-06-20 15:45:00");
    	
    	System.out.println(getDistanceDays("2017-06-01","2017-07-01"));
    }
}
