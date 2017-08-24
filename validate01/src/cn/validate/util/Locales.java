package cn.validate.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class Locales {
	public static Map<String,Locale> locales =new HashMap<String,Locale>(2);
	public Map<String,Locale> getLocales() {
		locales.put("American English", Locale.US);
		locales.put("Simplified Chinese", Locale.CHINA);
		return locales;
	}
}

