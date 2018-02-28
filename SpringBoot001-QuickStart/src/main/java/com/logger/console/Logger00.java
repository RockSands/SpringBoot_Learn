package com.logger.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Logger00 {
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	public void log() {
		logger.info("=={}.info==","logger00");
		logger.debug("==Logger00.debug==");
		logger.error("==Logger00.error==");
		logger.warn("==Logger00.warn==");
	}
}
