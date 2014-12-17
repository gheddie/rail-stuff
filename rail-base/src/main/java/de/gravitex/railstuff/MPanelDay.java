package de.gravitex.railstuff;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.Calendar;

import org.apache.log4j.Logger;

public class MPanelDay {
	
	private static final Logger logger = Logger.getLogger(MPanelDay.class);

	private static final int ELEMENT_INSET = 4;
	
	private int basicOffset;

	public void render(Graphics g, MaturityRenderMode renderMode, int height, int basicOffset, String dayKey) {
		logger.info("rendering day '"+dayKey+"' with offset '"+basicOffset+"'.");
		this.basicOffset = basicOffset;
		//render date
		g.drawString(dayKey, basicOffset+1, MaturityPanel.HEADER_HEIGHT-1);
		g.drawRect(basicOffset, 0, renderMode.getRenderWidth(), height);
		int renderSteps = renderMode.renderSteps();
		int xOffsetAdd = renderMode.hourOffset() * (24/renderSteps);
		int x = basicOffset + xOffsetAdd;
		Stroke oldStroke = ((Graphics2D) g).getStroke();
		float[] dash = { 10.0f };
		BasicStroke stroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
		((Graphics2D) g).setStroke(stroke);
		int hourDiff = 24 / renderSteps;
		int hour = hourDiff;
		Font oldFont = g.getFont();
		Font smallFont = new Font(oldFont.getFontName(), oldFont.getStyle(), 9);
		g.setFont(smallFont);
		for (int i = 0; i < renderSteps; i++) {
			g.drawLine(x, MaturityPanel.HEADER_HEIGHT, x, height - MaturityPanel.FOOTER_HEIGHT);
			//render hour
			if (hour != 24) {
				String str = hour+":00";
				int stringWidth = (int) g.getFontMetrics().getStringBounds(str, g).getWidth();
				g.drawString(str, x+1-stringWidth/2, height-1);	
			}
			x += xOffsetAdd;
			hour += hourDiff;
		}
		((Graphics2D) g).setStroke(oldStroke);
		g.setFont(oldFont);
	}

	public void renderElement(Graphics g, MaturityRenderMode renderMode, TimeRangeElement element, int height) {
		int hourOfDayFrom = element.getFrom().get(Calendar.HOUR_OF_DAY);
		long elementRenderWidth = (element.getTo().getTimeInMillis() - element.getFrom().getTimeInMillis()) / 1000 / 60 / 60 * renderMode.hourOffset();
		logger.info("rendering element (basicOffset:"+basicOffset+") for hour " + hourOfDayFrom + " (length=" + elementRenderWidth + ").");
		int xLeft = basicOffset + renderMode.hourOffset() * hourOfDayFrom;
		Color oldColor = g.getColor();
		g.setColor(Color.lightGray);
		g.fillRect(xLeft, MaturityPanel.HEADER_HEIGHT+ELEMENT_INSET, (int) elementRenderWidth, (height - MaturityPanel.HEADER_HEIGHT - MaturityPanel.FOOTER_HEIGHT) - 2*ELEMENT_INSET);
		g.setColor(oldColor);
	}
}
