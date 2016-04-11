package com.swacorp.training.constanst;

public enum MessageType {
	EMPTY_MSG(""),
	ERROR_NOT_MESSAGE("Could not send Message."), 
	SERVER_EX_ERROR("EX_ERROR"), 
	BAD_REQUEST_TYPE("BAD_REQUEST_ERROR"), 
	BUSINESS_ERROR_TYPE("BUSINESS_ERROR"), 
	SERVER_ERROR_TYPE("SERVER_ERROR"), 
	COMPLETE_TYPE("COMPLETE"), 
	TWO_POINTS_SEPARATOR(":"), 
	COMMA_SEPARATOR(","), 
	CRLF_SEPARATOR("\n"), 
	FLINE_NULL_POINTER("java.lang.NullPointerException"),
	FLINE_ERRORS("Errors"), 
	FLINE_XPATH_NULL("xpath=null"),;

	private final String message;

	MessageType(String message) {
		this.message = message;

	}

	public String getMessage() {
		return this.message;
	}

}
