package com.lovo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static final String DATE_FORMAT="yyyy-MM-dd";
	
	public static Date StringToDate(String str) {
		Date d = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		
		try {
			if(str == null || str.equals("")) {
				d = new Date();
			}
			else {
				d = sdf.parse(str);
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return d;
	}
}
