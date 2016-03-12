package com.cit360.mpfinder.exception;

/**
*
* @author Eurico Costa
*/
public class DAOException extends Exception {
	
	private static final long serialVersionUID = 4918174105170331696L;

	public DAOException() {
	}

	public DAOException(String message) {
       super(message);
	}

	public DAOException(String message, Throwable cause) {
       super(message, cause);
	}

	public DAOException(Throwable cause) {
       super(cause);
	}

	public DAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
       super(message, cause, enableSuppression, writableStackTrace);
	}
}