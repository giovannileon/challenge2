/*
 * @(#)CompleteStrategy.java
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
public class CompleteStrategy extends AbstractResponseTypeStrategy {

	public CompleteStrategy(String status, String message) {
		super(status, message);
	}

	// @Override
	public StrategyResult decode() {
		StrategyResult result = new StrategyResult();
		result.setResponseDescription(MessageType.EMPTY_MSG.getMessage());
		result.setResponseType(MessageType.COMPLETE_TYPE.getMessage());
		return result;
	}

}
