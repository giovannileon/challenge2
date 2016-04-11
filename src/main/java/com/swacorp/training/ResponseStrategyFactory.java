package com.swacorp.training;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.swacorp.training.constanst.MessageType;

@Component
public class ResponseStrategyFactory {

	public ResponseStrategy getResponseStrategy(String status, String message) {

		String fline = StringUtils.substringBefore(message, MessageType.CRLF_SEPARATOR.getMessage());

		if (status == null && message == null) {
			return null;
		}
		// Complete
		if (status.equals(MessageType.COMPLETE_TYPE.getMessage())) {
			return new CompleteStrategy(status, message);
		}
		// Bad Request
		if (fline.contains(MessageType.FLINE_XPATH_NULL.getMessage())
				&& fline.contains(MessageType.FLINE_NULL_POINTER.getMessage())) {
			return new BadRequestStrategy(status, message);
		}

		// Bunisess
		if (fline.contains(MessageType.FLINE_ERRORS.getMessage())) {
			return new BusinnessExceptionStrategy(status, message);
		}

		// ServerError
		if (StringUtils.substringAfterLast(fline, MessageType.TWO_POINTS_SEPARATOR.getMessage()).trim()
				.equals(MessageType.ERROR_NOT_MESSAGE.getMessage())
				|| fline.trim().equals(MessageType.ERROR_NOT_MESSAGE.getMessage())
				|| status.equals(MessageType.SERVER_EX_ERROR.getMessage())) {
			return new ServerErrorStrategy(status, message);
		}
		return null;
	}

}
