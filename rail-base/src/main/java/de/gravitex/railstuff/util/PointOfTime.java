package de.gravitex.railstuff.util;

import java.util.Calendar;

import de.gravitex.railstuff.DateUtil;

public class PointOfTime {

	private Calendar cal;
	
	public PointOfTime() {
		super();
		this.cal = Calendar.getInstance();
		floor();
	}

	public PointOfTime(int day, int month, int year) {
		super();
		this.cal = Calendar.getInstance();
		cal.set(year, month, day);
		floor();
	}

	public PointOfTime(int day, int month, int year, int hour, int minute) {
		this(day, month, year);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
	}

	public Calendar floor() {
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

	public long millis() {
		return cal.getTimeInMillis();
	}
	
	public String toString() {
		return getClass().getSimpleName() + "["+DateUtil.formatDateTime(cal.getTime())+"]";
	}

	public Calendar cal() {
		return cal;
	}
}
