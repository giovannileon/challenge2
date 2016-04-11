package com.swacorp.training.test;

import org.testng.annotations.Test;

import com.swacorp.training.CompleteStrategy;
import com.swacorp.training.ResponseStrategy;
import com.swacorp.training.StrategyResult;
import com.swacorp.training.constanst.MessageType;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CompleteStrategyTest {

	ResponseStrategy responseStrategy;
	StrategyResult result;

	@Test
	public void isResponseCompleteWhenEmpty() {
		responseStrategy = new CompleteStrategy("", "");
		result = responseStrategy.decode();
		assertEquals(MessageType.COMPLETE_TYPE.getMessage(), result.getResponseType());

	}

	@Test
	public void isResponseCompleteWhenNotEmpty() {
		responseStrategy = new CompleteStrategy("Complete", "Success");
		result = responseStrategy.decode();
		assertEquals(MessageType.COMPLETE_TYPE.getMessage(), result.getResponseType());

	}

	@Test
	public void isResponseCompleteAndDesriptionEmpty() {
		responseStrategy = new CompleteStrategy("Complete", "Success");
		result = responseStrategy.decode();
		assertTrue(result.getResponseType().equals(MessageType.COMPLETE_TYPE.getMessage())
				&& result.getResponseDescription().isEmpty());

	}

}
