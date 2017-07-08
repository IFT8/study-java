package com.comodin.basic.util.ftp;

public class FTPClientException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FTPClientException() {
        super();
    }

    public FTPClientException(String message) {
        super(message);
    }

    public FTPClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public FTPClientException(Throwable cause) {
        super(cause);
    }

    protected FTPClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
