/*
 * @(#)BadRequestStrategy.java
 *
 * Copyright (c) 2016 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 */
package com.swacorp.training;

import org.springframework.stereotype.Component;

import com.swacorp.training.constanst.MessageType;

@Component
public class BadRequestStrategy extends AbstractResponseTypeStrategy {

	public BadRequestStrategy(String status, String message) {
		super(status, message);
	}

	public StrategyResult decode() {
		StrategyResult result = new StrategyResult();

		result.setResponseDescription(getMessage());
		result.setResponseType(MessageType.BAD_REQUEST_TYPE.getMessage());

		return result;
	}

}
