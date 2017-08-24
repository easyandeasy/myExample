package com.car.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 日期、字符串转换工具
 * @author tang
 *
 */
public class SimpleDateFormatUtil {

	public static SimpleDateFormat sdf = new SimpleDateFormat();
	
	/**
	 * 字符串转换成日期
	 * @param source
	 * @return
	 */
	public static Date getSimpleDateFormat(String source){
		if(Pattern.matches("^(\\d{4}-\\d{2}-\\d{2}) || (\\d{4}-\\d{1}-\\d{1}) $", source)) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		} else if(Pattern.matches("^(\\d{4}/\\d{2}/\\d{2}) || (\\d{4}/\\d{1}/\\d{1})$", source)) {
			sdf = new SimpleDateFormat("yyyy/MM/dd");
		} else if(Pattern.matches("^(\\d{4}\\d{2}\\d{2}) || (\\d{4}\\d{1}\\d{1})$", source)) {
			sdf = new SimpleDateFormat("yyyyMMdd");
		}
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * 日期转换成字符串
	 * @param date
	 * @return
	 */
	public static String getToString(Date date) {
		return sdf.format(date);
	}
}
