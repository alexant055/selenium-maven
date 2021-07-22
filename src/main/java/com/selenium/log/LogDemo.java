package com.selenium.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogDemo {
	
	private static final Logger logger =  LogManager.getLogger();

	public static void main(String[] args) {
		logger.debug("Debug message!");
		logger.error("Error message!");
		logger.info("Info message!");
	}

}
