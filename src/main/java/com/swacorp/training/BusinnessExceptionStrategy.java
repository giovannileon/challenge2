/*
 * @(#)BunisessExceptionStrategy.java
 *
 * Copyright (c) 2016 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 */
package com.swacorp.training;

import com.swacorp.training.constanst.MessageType;

public class BusinnessExceptionStrategy extends AbstractResponseTypeStrategy {

	public BusinnessExceptionStrategy(String status, String message) {
		super(status, message);
	}

	// @Override
	public StrategyResult decode() {

		StrategyResult result = new StrategyResult();

		int points = getMessage().indexOf(MessageType.TWO_POINTS_SEPARATOR.getMessage());
		int comma = getMessage().indexOf(",");

		if (points == -1) {
			points = 0;
		}

		if (comma == -1) {
			comma = 0;
		}

		if (points > comma) {
			result.setResponseDescription(getMessage());
			result.setResponseType(MessageType.BUSINESS_ERROR_TYPE.getMessage());
		} else {
			result.setResponseDescription(getMessage().substring(points, comma));
			result.setResponseType(MessageType.BUSINESS_ERROR_TYPE.getMessage());
		}
		return result;
	}

}
