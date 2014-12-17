package de.gravitex.railstuff;

import org.apache.log4j.PropertyConfigurator;

import de.gravitex.railstuff.gui.MaturityTestFrame;


public class App {
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("C:\\eclipseWorkspaces\\LUNA_RAIL_STUFF\\log4j.properties");
		new MaturityTestFrame().setVisible(true);
		//---
		/*
		JFrame frame = new JFrame();
		frame.setSize(1200, 600);
		frame.setLocation(100, 100);
		frame.setLayout(new BorderLayout());
		Calendar from = Calendar.getInstance();
		from.set(2014, 11, 12, 0, 0, 0);
		Calendar until = Calendar.getInstance();
		until.set(2014, 11, 14, 0, 0, 0);
		MaturityPanel2 mp = new MaturityPanel2(from);
		List<TimeRangeElement> elements = new ArrayList<TimeRangeElement>();
		//05:00-03:30 (12.12.2014-13.12.2014)
		elements.add(new TimeRange(new PointOfTime(12, 11, 2014, 5, 0), new PointOfTime(13, 11, 2014, 3, 0)));
		//18:00-23:00 (13.12.2014)
		elements.add(new TimeRange(new PointOfTime(13, 11, 2014, 18, 0), new PointOfTime(13, 11, 2014, 23, 0)));
		mp.setElements(elements);
		frame.add(mp, BorderLayout.CENTER);
		frame.setVisible(true);
		*/
	}
}
