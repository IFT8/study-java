package com.comodin.basic.exception;

public class ParameterException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String [] strings;
	
    public String[] getStrings() {
		return strings;
	}

	public void setStrings(String[] strings) {
		this.strings = strings;
	}

	/**
     * Instantiates a new paramexception.
     *
     * @param message the message
     */
    public ParameterException(String message,String[] strings) {
    	super(message);
    	this.strings = strings;
    }
	
	
	/**
     * Instantiates a new paramexception.
     */
    public ParameterException() {
        super();
    }
    
    /**
     * Instantiates a new paramexception.
     *
     * @param message the message
     */
    public ParameterException(String message) {
    	super(message);
    }
    
    /**
     * Instantiates a new paramexception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new paramexception.
     *
     * @param cause the cause
     */
    public ParameterException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new paramexception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected ParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
