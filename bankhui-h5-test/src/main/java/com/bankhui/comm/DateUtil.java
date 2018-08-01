package com.bankhui.comm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getSysCurDateTime() {
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result=sf.format(new Date());
		return result;
	}
	
	public static String getSysCurTime() {
		SimpleDateFormat sf=new SimpleDateFormat("HH:mm:ss");
		String result=sf.format(new Date());
		return result;
	}
}
