package com.stationary.store.report.exception;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoreException extends RuntimeException {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StoreException.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StoreException(Exception ex) {
		LOGGER.error("traceId: :"+ ThreadContext.get("traceid"), ex);
	}

}
