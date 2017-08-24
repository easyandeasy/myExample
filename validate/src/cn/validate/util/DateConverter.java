package cn.validate.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * 日期、字符串转换器
 * @author tang
 *
 */
public class DateConverter extends StrutsTypeConverter {

	private final SimpleDateFormat[] sdfs = {
		new SimpleDateFormat("yyyy-MM-dd"),
		new SimpleDateFormat("yyyy/MM/dd"),
		new SimpleDateFormat("yyyy年MM月dd日"),
		new SimpleDateFormat("yyyy.MM.dd"),
		new SimpleDateFormat("yyMMdd"),
		new SimpleDateFormat("yy/MM/dd"),
	};
	
	/**
	 * 将字符串转换成日期类型
	 */
	@Override
	public Object convertFromString(Map arg0, String[] values, Class arg2) {
		String strDate = values[0];
		for (int i = 0; i < sdfs.length; i++) {
			try {
				return sdfs[i].parse(strDate);
			} catch (ParseException e) {
				continue;
			}
		}
		throw new TypeConversionException("转换错误！");
	}

	/**
	 * 将日期类型转换成字符串
	 */
	@Override
	public String convertToString(Map arg0, Object obj) {
		Date d = (Date)obj;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d);
	}

}
