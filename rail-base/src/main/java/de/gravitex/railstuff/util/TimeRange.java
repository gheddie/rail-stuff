package de.gravitex.railstuff.util;

import java.util.Calendar;

import de.gravitex.railstuff.TimeRangeElement;

public class TimeRange implements TimeRangeElement {

	private int daySpan = -1;
	
	private PointOfTime from;
	
	private PointOfTime to;

	public TimeRange(PointOfTime from, PointOfTime to) {
		super();
		this.from = from;
		this.to = to;
	}

	public int getDaySpan() {
		from.floor();
		to.floor();
		if (daySpan == -1) {
			long millis = to.millis() - from.millis();
			daySpan = (int) ((millis/1000/60/60/24) + 1);
		}
		return daySpan;
	}
	
	public String toString() {
		return getClass().getSimpleName() + "[from:"+from+"|to:"+to+"]";
	}

	public Calendar getFrom() {
		return from.cal();
	}

	public Calendar getTo() {
		return to.cal();
	}
}