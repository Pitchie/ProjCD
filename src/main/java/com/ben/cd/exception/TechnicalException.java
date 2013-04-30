package com.ben.cd.exception;

import org.apache.log4j.Logger;

import com.ben.cd.CDException;
import com.ben.cd.exception.TechnicalException;

public class TechnicalException extends CDException{
	private static Logger logger = Logger.getLogger(TechnicalException.class);

	private static final long serialVersionUID = 1L;
	
	public TechnicalException(String message) {
		super(message);
	}
	
	public TechnicalException(Exception e) {
		super(e);
	}
	
	public TechnicalException(String message, Exception e) {
    	super(message, e);
    	logger.error(message, e);
    }
}
