package com.ben.cd.exception;

import com.ben.cd.CDException;

public class BusinessException extends CDException{
	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(String message, Exception e) {
		super(message, e);
	}
}
