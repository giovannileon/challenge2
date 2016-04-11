package com.swacorp.training.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import com.swacorp.training.BusinnessExceptionStrategy;
import com.swacorp.training.ResponseStrategy;
import com.swacorp.training.StrategyResult;
import com.swacorp.training.constanst.MessageType;

public class BusinnessExceptionStrategyTest {
	ResponseStrategy responseStrategy;
	StrategyResult result;

	@Test
	public void isResponseBusinnessErrorType() {
		responseStrategy = new BusinnessExceptionStrategy("", "");
		result = responseStrategy.decode();
		assertEquals(MessageType.BUSINESS_ERROR_TYPE.getMessage(), result.getResponseType());
	}

	@Test
	public void messageContainsTwoPointsSeparator() {
		responseStrategy = new BusinnessExceptionStrategy("", "message:Text");
		result = responseStrategy.decode();
		assertTrue(result.getResponseDescription().equals("message:Text")
				&& result.getResponseType().equals(MessageType.BUSINESS_ERROR_TYPE.getMessage()));

	}

	@Test
	public void messageContainsCommaSeparator() {
		responseStrategy = new BusinnessExceptionStrategy("", "message,Text");
		result = responseStrategy.decode();
		assertTrue(result.getResponseDescription().equals("message")
				&& result.getResponseType().equals(MessageType.BUSINESS_ERROR_TYPE.getMessage()));

	}

	@Test
	public void messageContainsCommaAndTwoPoints() {
		responseStrategy = new BusinnessExceptionStrategy("", "message,Text:");
		result = responseStrategy.decode();

		assertTrue(result.getResponseDescription().equals("message,Text:")
				&& result.getResponseType().equals(MessageType.BUSINESS_ERROR_TYPE.getMessage()));

	}

	@Test
	public void messageContainsTwoPointsAndComma() {
		responseStrategy = new BusinnessExceptionStrategy("", "message:Text,");
		result = responseStrategy.decode();

		assertTrue(result.getResponseDescription().equals(":Text")
				&& result.getResponseType().equals(MessageType.BUSINESS_ERROR_TYPE.getMessage()));

	}

}
