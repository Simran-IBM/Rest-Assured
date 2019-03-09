package com.test.restAssured.restAssured;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


@Listeners(com.test.restAssured.restAssured.Listener.ListenerTest.class)
public class GetData_XML {
	
	@Test
	public void checkCountryForFirstCar() {
	                         
	    given().
	    when().
	        get("http://www.thomas-bayer.com/sqlrest/INVOICE").
	    then().
	        assertThat().
	        body("INVOICEList.INVOICE[0]", equalTo("0"));
	}
}