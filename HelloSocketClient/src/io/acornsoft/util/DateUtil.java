package io.acornsoft.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <PRE>
 * 1. ClassName: DateUtil
 * 2. FileName : DateUtil.java
 * 3. Package  : io.acornsoft.util
 * 4. Comment  : 날짜 처리 공통 UTIL
 * 5. 작성자   : bluedove
 * 6. 작성일   : 2023. 01. 16. 오후 2:35:47
 * 7. 변경이력
 *     이름    :    일자       : 변경내용
 * -------------------------------------------------------
 *     bluedove :    2023. 01. 16.    : 신규개발
 * </PRE>
 */
public class DateUtil {

    /** the logger. */
    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * <PRE>
     * 1. MethodName: getDateFormat
     * 2. ClassName : DateUtil
     * 3. Comment   : yyyyMMdd 형태의 문자열을 yyyy-MM-dd로 변환.
     * 4. 작성자    : bluedove
     * </PRE>
     *
     * @return String 변환 문자
     * @param yyyyMMdd 입력문자열
     */
    public static String getDateFormat(final String yyyyMMdd) {
        SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

        String ret = "";

        if (yyyyMMdd == null || yyyyMMdd.length() != 8) {
            return "";
        } else {
            try {
                ret = df2.format(df1.parse(yyyyMMdd));
            } catch (ParseException e) {
                logger.error("error", e);
            }
        }

        return ret;
    }

    /**
     * <PRE>
     * 1. MethodName: getLngDateFormat
     * 2. ClassName : DateUtil
     * 3. Comment   : yyyyMMdd 형태의 문자열을 yyyy-MM-dd로 변환.
     * 4. 작성자    : bluedove
     * </PRE>
     *
     * @return String 변환문자열
     * @param yyyyMMdd 입력문자열
     * @param lngTyp   언어코드
     * @return
     */
    public static String getLngDateFormat(final String yyyyMMdd, String lngTyp) {
        SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df3 = new SimpleDateFormat("MM/dd/yyyy");

        String ret = "";

        if (yyyyMMdd == null || yyyyMMdd.length() != 8) {
            return "";
        } else {
            try {
                if (lngTyp != null && lngTyp.equals("ko")) {
                    ret = df2.format(df1.parse(yyyyMMdd));
                } else if (lngTyp != null && lngTyp.equals("en")) {
                    ret = df3.format(df1.parse(yyyyMMdd));
                }
            } catch (ParseException e) {
                logger.error("error", e);
            }
        }

        return ret;
    }

    /**
     * <PRE>
     * 1. MethodName: getLngDateFormat_yymm
     * 2. ClassName : DateUtil
     * 3. Comment   : yyyyMM 형태의 문자열을 yyyy-MM로 변환.
     * 4. 작성자    : bluedove
     * </PRE>
     *
     * @return String 변환문자열
     * @param yyyyMM 입력문자
     * @param lngTyp 언어코드
     * @return
     */
    public static String getLngDateFormat_yymm(final String yyyyMM, String lngTyp) {
        SimpleDateFormat df1 = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat df3 = new SimpleDateFormat("MM/yyyy");

        String ret = "";

        if (yyyyMM == null || yyyyMM.length() != 6) {
            return "";
        } else {
            try {
                if (lngTyp != null && lngTyp.equals("ko")) {
                    ret = df2.format(df1.parse(yyyyMM));
                } else if (lngTyp != null && lngTyp.equals("en")) {
                    ret = df3.format(df1.parse(yyyyMM));
                }
            } catch (ParseException e) {
                logger.error("error", e);
            }
        }

        return ret;
    }

    /**
     * <PRE>
     * 1. MethodName: getTimeFormat
     * 2. ClassName : DateUtil
     * 3. Comment   : HHmmss 형태의 문자열을 HH:mm:ss 형태로 변환.
     * 4. 작성자    : bluedove
     * </PRE>
     *
     * @return String 변환문자열
     * @param HHmmss 입력문자
     */
    public static String getTimeFormat(final String HHmmss) {
        SimpleDateFormat df1 = new SimpleDateFormat("HHmmss");
        SimpleDateFormat df2 = new SimpleDateFormat("HH:mm:ss");

        String ret = "";

        if (HHmmss == null || HHmmss.length() != 6) {
            return "";
        } else {
            try {
                ret = df2.format(df1.parse(HHmmss));
            } catch (ParseException e) {
                logger.error("error", e);
            }
        }

        return ret;
    }

    /**
     * <PRE>
     * 1. MethodName: getDateStringYYYYMMDD
     * 2. ClassName : DateUtil
     * 3. Comment   :  n 값에 따라 날짜 계산를 계산하여 String으로 전달( n이 0=오늘, -1=어제, 1=내일)
     * 4. 작성자    : bluedove
     * </PRE>
     *
     * @return String 날짜
     * @param day 더하고 뺄 날짜수
     * @return
     */
    public static String getDateStringYYYYMMDD(int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, day);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(cal.getTime());
    }

    /**
     * <PRE>
     * 1. MethodName: getDateStringYYYYMMDDHH24MISS
     * 2. ClassName : DateUtil
     * 3. Comment   : n 값에 따라 날짜 계산를 계산하여 String으로 전달( n이 0=현재, -1=1초전, 1=1초)
     * 4. 작성자    : bluedove
     * </PRE>
     *
     * @return String 날짜
     * @param n 더하고 뺄 초수
     * @return
     */
    public static String getDateStringYYYYMMDDHH24MISS(int n) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.SECOND, n);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(cal.getTime());
    }

    /**
     * 오늘 날짜 DATE 객체
     *
     * @return String
     */
    public static Date sysdate() {
        Date date = new Date();
        return date;
    }

    public static Date getDateCalByDays(int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * n 값에 따라 날짜 계산를 계산하여 String으로 전달( n이 0=오늘, -1=어제, 1=내일)
     *
     * @param day fd
     * @return String
     */
    public static String getDateStringYYYYMM(int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, day);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        return dateFormat.format(cal.getTime());
    }

    public static String getTimeStampAsString() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(new Timestamp(date.getTime()));
    }
    
    public static String getTimeStampGMTAsString() {
        Date date = new Date();
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, 9);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(cal.getTime());
    }

    public static String getDateStringGMTAsYYYYMMDDHHMMSS() {
        Date date = new Date();
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, 9);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(cal.getTime());
    }

    /**
     * <PRE>
     * 1. MethodName: isValidDate
     * 2. ClassName : DateUtil
     * 3. Comment   : 데이터 유효성 검증
     * 4. 작성자    : bluedove
     * </PRE>
     *
     * @return boolean
     * @param dateString
     * @return
     */
    public static boolean isValidDate(String dateString) {
        try {
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    /**
     *
     * <PRE>
     * 1. MethodName: diffOfDate
     * 2. ClassName : DateUtil
     * 3. Comment   : 두개의 날짜 기간 계산
     * 4. 작성자    : bluedove
     * </PRE>
     *
     * @return long
     * @param begin
     * @param end
     * @return
     */
    public static long diffOfDate(String begin, String end) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = formatter.parse(begin);
            endDate = formatter.parse(end);
        } catch (ParseException e) {
            return -9999999;
        }

        long diff = endDate.getTime() - beginDate.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);

        return diffDays;

    }

    /**
     *
     * <PRE>
     * 1. MethodName: addMonthYYYYMMDD
     * 2. ClassName : DateUtil
     * 3. Comment   : 지정일로 부터 n개월 후 계산
     * 4. 작성자    : bluedove
     * </PRE>
     *
     * @return String
     * @param dt
     * @param months
     * @return
     */
    public static String addMonthYYYYMMDD(String dt, int months) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date;
        try {
            date = dateFormat.parse(dt);
        } catch (ParseException e) {
            date = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        cal.add(Calendar.DATE, -1);
        return dateFormat.format(cal.getTime());

    }

    /**
     *
     * <PRE>
     * 1. MethodName: addDayYYYYMMDD
     * 2. ClassName : DateUtil
     * 3. Comment   : 지정일로 부터 n 일자 계산
     * 4. 작성자    : bluedove
     * </PRE>
     *
     * @return String
     * @param dt
     * @param day
     * @return
     */
    public static String addDayYYYYMMDD(String dt, int day) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date;
        try {
            date = dateFormat.parse(dt);
        } catch (ParseException e) {
            date = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);
        return dateFormat.format(cal.getTime());

    }
    
    /**
     * <PRE>
     * 1. MethodName: getDateLastDayStringYYYYMMDD
     * 2. ClassName : DateUtil
     * 3. Comment   : 월, 일 계산하여 String으로 전달
     * 4. 작성자    : yong
     * </PRE>
     *
     * @return String 날짜
     * @param month 더하고 뺄 월
     * @param dayType 일 표시 타입. F : 해당 월 1일, L : 해당 월 마지막일, 빈값 : 현재 일
     * @return
     */
    public static String getDateLastDayStringYYYYMMDD(int month, String dayType) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, month);
		
		if("F".equals(dayType)) {
			cal.set(Calendar.DAY_OF_MONTH, 1);
		} else if("L".equals(dayType)) {
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		}
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
	    return dateFormatter.format(cal.getTime());
    }
    
    /**
     * <PRE>
     * 1. MethodName: getNowMonth
     * 2. ClassName : DateUtil
     * 3. Comment   : 현재 월 String으로 전달
     * 4. 작성자    : yong
     * </PRE>
     *
     * @return String
     */
	public static String getNowMonth() {
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.get(Calendar.MONTH)+1);
	}
	
	/**
     * <PRE>
     * 1. MethodName: getStringToDate
     * 2. ClassName : DateUtil
     * 3. Comment   : 날짜형식의 문자열을 Date 객체로 변환
	 * 4. 작성자    : yong
     * </PRE>
     *
     * @return String
     */
	public static Date convertStringToDateTime(String dateString) {
		Date rtnDate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(dateString != null){
			try {
				rtnDate = formatter.parse(dateString);
	        } catch (ParseException e) {
	        	rtnDate = null;
	        }
		}
		return rtnDate;
	}
	
	/*
	public static Date convertStringToDateTime(String dateString) throws ParseException{
		if(dateString != null){
			SimpleDateFormat	formatter	= new SimpleDateFormat(CommonConstants.DATE_TIME_FORMAT);
			return formatter.parse(dateString);
		}
		else{
			return null;
		}
	}*/
}
