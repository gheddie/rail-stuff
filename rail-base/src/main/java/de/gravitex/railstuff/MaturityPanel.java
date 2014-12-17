package de.gravitex.railstuff;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import de.gravitex.railstuff.util.PointOfTime;
import de.gravitex.railstuff.util.TimeRange;

public class MaturityPanel extends JPanel {
	
	private static final Logger logger = Logger.getLogger(MaturityPanel.class);

	private static final long serialVersionUID = 2342643827592184455L;
	
	private MaturityRenderMode renderMode;
	
	private HashMap<String, MPanelDay> days;

	private List<TimeRangeElement> elements;

	private Calendar from;
	
	public static final int HEADER_HEIGHT = 20;
	
	public static final int FOOTER_HEIGHT = 20;
	
	public MaturityPanel() {
		super();
		this.renderMode = MaturityRenderMode.PX_144;
		Calendar pFrom = Calendar.getInstance();
		pFrom.set(2014, 11, 12, 0, 0, 0);
		this.from = pFrom;
		List<TimeRangeElement> elements = new ArrayList<TimeRangeElement>();
		elements.add(new TimeRange(new PointOfTime(13, 11, 2014, 4, 0), new PointOfTime(13, 11, 2014, 8, 0)));
		elements.add(new TimeRange(new PointOfTime(14, 11, 2014, 12, 0), new PointOfTime(16, 11, 2014, 16, 0)));
		this.elements = elements;
	}

	public MaturityPanel(Calendar from) {
		super();
		this.renderMode = MaturityRenderMode.PX_144;
		this.from = from;
	}

	private void prepareDays() {
		days = new HashMap<String, MPanelDay>();
		Calendar cal = (Calendar) from.clone();
		int totalVisibleDays = getWidth() / renderMode.getRenderWidth() + 1;
		logger.info("totalVisibleDays : " + totalVisibleDays);
		for (int i=0;i<totalVisibleDays ;i++) {
			String dateKey = DateUtil.formatDate(cal.getTime());
//			logger.info("preparing day for calendar : " + dateKey);
			days.put(dateKey, new MPanelDay());
			cal.add(Calendar.HOUR, 24);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		//render background
		Color oldColor = g.getColor();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(oldColor);
		prepareDays();
		logger.info(" --------------------------------------- painting panel...");
//		renderElements(g);
		int basicOffset = 0;
		//render header border
		g.drawLine(0, HEADER_HEIGHT, getWidth(), HEADER_HEIGHT);
		//render footer border
		g.drawLine(0, getHeight() - FOOTER_HEIGHT, getWidth(), getHeight() - FOOTER_HEIGHT);
		//render days
		List<String> keyList = new ArrayList<String>(days.keySet());
		Collections.sort(keyList);
		for (String key : keyList) {
//			logger.info("rendering day '"+key+"'.");
			days.get(key).render(g, renderMode, getHeight(), basicOffset, key);
			basicOffset += renderMode.dayOffset();
		}
		renderElements(g);
	}

	private void renderElements(Graphics g) {
		if (elements != null && elements.size() > 0) {
			logger.info("rendering "+elements.size()+" elements...");
			for (TimeRangeElement element : elements) {
//				logger.info(element);
				int minutesElapsed = (int) ((element.getFrom().getTimeInMillis() - from.getTimeInMillis()) / 60 / 1000);
//				logger.info("minutesElapsed : " + minutesElapsed);
				String dateKey = DateUtil.formatDate(element.getFrom().getTime());
				MPanelDay day = days.get(dateKey);
				if (day != null) {
					day.renderElement(g, renderMode, element, getHeight());	
				} else {
					logger.info("no day found for key '"+dateKey+"'.");
				}
			}	
		}
	}

	public void setElements(List<TimeRangeElement> elements) {
		this.elements = elements;
	}
	
	//---

	public void increaseFocus() {
		MaturityRenderMode renderModeIncreased = renderMode.following();
		if (renderModeIncreased != null) {
			renderMode = renderModeIncreased;
			repaint();
		}
	}

	public void decreaseFocus() {
		MaturityRenderMode renderModeIncreased = renderMode.predecessing();
		if (renderModeIncreased != null) {
			renderMode = renderModeIncreased;
			repaint();
		}
	}
}