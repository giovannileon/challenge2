/*
 * @(#)ServerErrorStrategy.java
 *
 * Copyright (c) 2016 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 */
package com.swacorp.training;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.swacorp.training.constanst.MessageType;

//import com.swacorp.mx.s2s.out.integration.ResponseType;

@Component
public class ServerErrorStrategy extends AbstractResponseTypeStrategy {

	private Logger log = LogManager.getLogger("im-ITOPS_APPENDER");
	

	public ServerErrorStrategy(String status, String message) {
		super(status, message);
	}

	// @Override
	public StrategyResult decode() {
		StrategyResult result = new StrategyResult();
		result.setResponseDescription(MessageType.SERVER_ERROR_TYPE.getMessage());
		result.setResponseType(MessageType.SERVER_ERROR_TYPE.getMessage());
		log.error(MessageType.SERVER_ERROR_TYPE.getMessage());
		return result;
	}

}
