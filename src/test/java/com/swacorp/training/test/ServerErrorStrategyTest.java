package com.swacorp.training.test;

import com.swacorp.training.BusinnessExceptionStrategy;
import com.swacorp.training.ResponseStrategy;
import com.swacorp.training.ServerErrorStrategy;
import com.swacorp.training.StrategyResult;
import com.swacorp.training.constanst.MessageType;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;

public class ServerErrorStrategyTest {
	ResponseStrategy responseStrategy;
	StrategyResult result;

	@Test
	public void isServerErrorResponseTypeEmpty() {
		responseStrategy = new ServerErrorStrategy("", "");
		result = responseStrategy.decode();
		assertEquals(MessageType.SERVER_ERROR_TYPE.getMessage(), result.getResponseType());
	}

	public void isStatusAndMessageNotEmpty() {
		responseStrategy = new ServerErrorStrategy("Error", "Error...ereree");
		result = responseStrategy.decode();
		assertEquals(MessageType.SERVER_ERROR_TYPE.getMessage(), result.getResponseType());
	}

	@Test
	public void isResponsiveTypeServerErrorEqualsToDescription() {
		responseStrategy = new ServerErrorStrategy("EX_ERROR", "Error...ereree");
		result = responseStrategy.decode();
		assertTrue(result.getResponseType().equals(result.getResponseDescription()));
	}
	

}
