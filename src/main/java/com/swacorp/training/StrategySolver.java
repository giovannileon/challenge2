/*
 * @(#)StrategySolver.java
 *
 * Copyright (c) 2016 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 */
package com.swacorp.training;

import org.springframework.beans.factory.annotation.Autowired;

public class StrategySolver {
	@Autowired
	private ResponseStrategyFactory responseStrategyFactory;

	private ResponseStrategy strategy;

	public StrategySolver(String status, String message) {
		initializeStrategies(status, message);
	}

	public StrategyResult messageDecode() {
		return strategy.decode();
	}

	private void initializeStrategies(String status, String message) {
		strategy = responseStrategyFactory.getResponseStrategy(status, message);
	}

}
