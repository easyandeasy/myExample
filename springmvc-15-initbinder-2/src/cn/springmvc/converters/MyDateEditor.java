package cn.springmvc.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class MyDateEditor extends PropertiesEditor {


	@Override
	public void setAsText(String source) throws IllegalArgumentException {
		SimpleDateFormat sdf = getSimpleDateFormat(source);
		try {
			Date date = sdf.parse(source);
			this.setValue(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private SimpleDateFormat getSimpleDateFormat(String source){
		SimpleDateFormat sdf = new SimpleDateFormat();
		if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", source)) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		} else if(Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$", source)) {
			sdf = new SimpleDateFormat("yyyy/MM/dd");
		} else if(Pattern.matches("^\\d{4}\\d{2}\\d{2}$", source)) {
			sdf = new SimpleDateFormat("yyyyMMdd");
		}
		return sdf;
	}

}
