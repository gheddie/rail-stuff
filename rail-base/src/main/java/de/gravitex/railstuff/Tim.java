package de.gravitex.railstuff;

import java.io.IOException;

import org.apache.log4j.Logger;

public class Tim {
	
	private static final Logger logger = Logger.getLogger(Tim.class);

	public static void main(String[] args) {
//		logger.info("Hallo Tim !!");
		try {
			int val1 = System.in.read();
			int val2 = System.in.read();
			logger.info(val1 + val2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
