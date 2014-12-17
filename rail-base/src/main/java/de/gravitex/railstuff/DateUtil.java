package de.gravitex.railstuff;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static SimpleDateFormat dfDateTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	
	private static SimpleDateFormat dfDate = new SimpleDateFormat("dd.MM.yyyy");

	public static String formatDateTime(Date date) {
		return dfDateTime.format(date);
	}
	
	public static String formatDate(Date date) {
		return dfDate.format(date);
	}
}
