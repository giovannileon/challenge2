package com.swacorp.training.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientDemoTest {
	
	//1 Status=COMPLETE--> ResponseType() = SUCCESSFUL  and Description = ""
	//2 mensaje= contains salta de linea (\n)  la palabra Errors  y tiene comas y : 
	//-->ResponseType() = BUSINESS_ERROR 
	//-->Description =  tomo el mensaje cuando la coma esta antes de los :
	//-->Description = substring desde la poscion de los : hasta la coma
	//3 mensaje  tiene un /n y contiene la palabra xpath=null java.lang.NullPointerException
	//--->ResponseType() = BAD_REQUEST_ERROR
	//-->Descriptioon = mensaje  sin el salto de linea
	//4  mensaje tiene Could not send Message. o EX_ERROR
	//--> ResponseType() =SERVER_ERROR
	//--> Descriptioon =SERVER_ERROR
	
	
	

	@Test
	public void statusIsComplete() {
		//fail("Not yet implemented");
		//assertEquals(message, expected, actual, delta);
	}

}
