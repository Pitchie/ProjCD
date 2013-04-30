package com.ben.cd;

public class CDException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CDException(String message) {
    	super(message);
    }
	
	public CDException(String message, Exception e) {
    	super(message, e);
    }
	
	public CDException(Exception e) {
		super(e);
	}
}
