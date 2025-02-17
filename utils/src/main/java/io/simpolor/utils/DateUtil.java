package io.simpolor.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public final static String DATETIMEMILLIS = "yyyy-MM-dd HH:mm:ss:SSS";
	public final static String DATETIME = "yyyy-MM-dd HH:mm:ss";
	public final static String DATE = "yyyy-MM-dd";
	public final static String TIME = "HH:mm:ss";
	
	/**
	 * 입력된 Date형의 값을 "yyyy-MM-dd HH:mm:ss:SSS" 형태로 반환합니다.
	 * @param date
	 * @return String
	 */
	public static String getDateTimeMillis(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIMEMILLIS);
		try {
    		return sdf.format(date);
    	}catch (Exception e) { 
    		return null;
    	}
    }
	
	/**
	 * 입력된 Date형의 값을 "yyyy-MM-dd HH:mm:ss" 형태로 반환합니다.
	 * @param date
	 * @return String
	 */
    public static String getDateTime(Date date){
    	SimpleDateFormat sdf = new SimpleDateFormat(DATETIME);
    	try {
    		return sdf.format(date);
    	}catch( Exception e ) { 
    		return null;
    	}
    }
    
    /**
	 * 입력된 Date형의 값을 "yyyy-MM-dd" 형태로 반환합니다.
	 * @param date
	 * @return String
	 */
    public static String getDate(Date date){
    	SimpleDateFormat sdf = new SimpleDateFormat(DATE);
    	try {
    		 return sdf.format(date);
    	}catch( Exception e ) { 
    		return null;
    	}
    }
    
    /**
	 * 입력된 Date형의 값을 "HH:mm:ss" 형태로 반환합니다.
	 * @param date
	 * @return String
	 */
    public static String getTime(Date date){
    	SimpleDateFormat sdf = new SimpleDateFormat(TIME);
    	try {
    		return sdf.format(date);
    	}catch( Exception e ) { 
    		return null;
    	}
    }
    
    /**
	 * 입력된 Date형의 값을 format 형태로 반환합니다.
	 * @param date
	 * @return String
	 */
	public static String getDateFormat(Date date, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
    	try {
    		return sdf.format(date);
    	}catch (Exception e) { 
    		return null;
    	}
    }
    
    /**
	 * 입력된 Date형의 값을 long형으로 반환합니다.
	 * @param date
	 * @return long
	 */
    public static long getDateToLong(Date date){
    	long timeMillis = -1L;
    	try{
    		timeMillis = date.getTime();
    		
    	}catch (Exception e) { }
    	
    	return timeMillis;
    }
    
    /**
	 * 입력된 long형의 값을 Date형으로 반환합니다.
	 * @param date
	 * @return String
	 */
	public static Date getLongToDate(long timeMillis){
        try{
        	return new Date(timeMillis);
        }catch(Exception e){
        	return null;
        }
    }
	
    /**
	 * 입력된 String형("yyyy-MM-dd HH:mm:ss:SSS")의 값을 Date형으로 반환합니다.
	 * @param str
	 * @return Date
	 */
	public static Date toDateTimeMillis(String str){
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIMEMILLIS);
        try{
        		return sdf.parse(str);
        }catch(Exception e){
        		return null;
        }
    }
	
	/**
	 * 입력된 String형("yyyy-MM-dd HH:mm:ss")의 값을 Date형으로 반환합니다.
	 * @param str
	 * @return Date
	 */
	public static Date toDateTime(String str){
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME);
        try{
        	return sdf.parse(str);
        }catch(Exception e){
        	return null;
        }
    }
	
	/**
	 * 입력된 String형("yyyy-MM-dd")의 값을 Date형으로 반환합니다.
	 * @param str
	 * @return Date
	 */
	public static Date toDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        try{
        	return sdf.parse(str);
        }catch(Exception e){
        	return null;
        }
    }
	
	/**
	 * 입력 문자열이 입력 날짜 포맷인지 여부를 리턴한다.
     * @param str : 날짜 문자열
     * @param format : 날짜 포맷
     * @return 입력 문자열이 입력 날짜 포맷이면 ture, 이외 false
     */
	public static boolean isValid(String str, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try{
			date = sdf.parse( str );
		}catch(Exception e){
           return false;
		}
		return sdf.format(date).equals(str);
	}
    
}
