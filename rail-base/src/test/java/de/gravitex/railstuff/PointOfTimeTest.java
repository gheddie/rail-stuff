package de.gravitex.railstuff;

import de.gravitex.railstuff.util.PointOfTime;
import de.gravitex.railstuff.util.TimeRange;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PointOfTimeTest extends TestCase {
	
	public PointOfTimeTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(PointOfTimeTest.class);
	}

	public void testDaySpan() {
		PointOfTime pFrom = new PointOfTime(13, 12, 2014);
		PointOfTime pTo = new PointOfTime(14, 12, 2014);
		TimeRange timeRange = new TimeRange(pFrom, pTo);
		assertEquals(timeRange.getDaySpan(), 2);
	}
}
