package com.swacorp.training;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientDemo {

	public static void main(String... args) {
		// StrategySolver solver = new StrategySolver("COMPLETE", "SOME MESSAGE:SUCCESFUL");

		// StrategySolver solver = new StrategySolver("BUSINESS", "Errors\nError1:Error2Error3,");
		
		//StrategySolver solver = new StrategySolver("BAD REQUEST", "i did a bad request xpath=null java.lang.NullPointerException\n");
		
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		//StrategySolver solver = context.getBean(StrategySolver.class);
		
		StrategySolver solver = new StrategySolver("SERVER ERROR", "ErrorServer1: Could not send Message.\n");

		StrategyResult result = solver.messageDecode();
		System.out.println(result.getResponseType());
		System.out.println(result.getResponseDescription());
	}
}
