package com.swacorp.training.test;

import org.testng.annotations.Test;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.swacorp.training.ResponseStrategy;
import com.swacorp.training.ResponseStrategyFactory;
import com.swacorp.training.constanst.MessageType;
import static org.testng.AssertJUnit.assertTrue;

public class ResponseStrategyFactoryTest {
	private ResponseStrategyFactory responseStrategyFactory = new ResponseStrategyFactory();
	private ResponseStrategy response;
	

	@Test
	public void isItACompleteStrategy() {
		response = responseStrategyFactory.getResponseStrategy("COMPLETE", "");
		assertTrue(response.decode().getResponseType().equals(MessageType.COMPLETE_TYPE.getMessage()));

	}

	@Test
	public void isItABadRequestStrategy() {
		response = responseStrategyFactory.getResponseStrategy("Bad Request",
				" xpath=null , java.lang.NullPointerException");
		assertTrue(response.decode().getResponseType().equals(MessageType.BAD_REQUEST_TYPE.getMessage()));

	}

	@Test
	public void isItABusinnesStrategy() {
		response = responseStrategyFactory.getResponseStrategy("Bad Request",
				"Errors\n 1.Error Description\n2.Error Description");
		assertTrue(response.decode().getResponseType().equals(MessageType.BUSINESS_ERROR_TYPE.getMessage()));
	}
	
	@Test
	public void isItAServerErrorStrategy(){
		response = responseStrategyFactory.getResponseStrategy("",
				"Server:Could not send Message.\n");
		assertTrue(response.decode().getResponseType().equals(MessageType.SERVER_ERROR_TYPE.getMessage()));	
	}
	
	@Test
	public void isItAServerErrorStrategyWithStatus(){
		response = responseStrategyFactory.getResponseStrategy(MessageType.SERVER_EX_ERROR.getMessage(),
				"");
		assertTrue(response.decode().getResponseType().equals(MessageType.SERVER_ERROR_TYPE.getMessage()));	
	}
	
	@Test
	public void isItAServerErrorStrategyErrorNotMessage(){
		response = responseStrategyFactory.getResponseStrategy("",
				"Could not send Message.\n");
		assertTrue(response.decode().getResponseType().equals(MessageType.SERVER_ERROR_TYPE.getMessage()));	
	}

}
