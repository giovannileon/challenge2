package com.swacorp.training.test;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;

import com.swacorp.training.ResponseStrategy;
import com.swacorp.training.BadRequestStrategy;
import com.swacorp.training.StrategyResult;
import com.swacorp.training.constanst.MessageType;

public class BadRequestStrategyTest {

	ResponseStrategy responseStrategy = new BadRequestStrategy("BAD REQUEST", "Message");

	@Test
	public void isResponseBadRequestErrorType() {

		StrategyResult result = responseStrategy.decode();
		assertEquals(MessageType.BAD_REQUEST_TYPE.getMessage(), result.getResponseType());
	}

	@Test
	public void isMessageEqualToDescription() {
		StrategyResult result = responseStrategy.decode();
		assertEquals("Message", result.getResponseDescription());
	}

}
