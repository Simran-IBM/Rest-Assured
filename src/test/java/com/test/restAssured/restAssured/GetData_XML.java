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
	        get("http://ergast.com/api/f1/2017/circuits").
	    then().
	        assertThat().
	        body("MRData.CircuitTable.Circuit[0].Location.Locality", equalTo(" Melbourne"));
	}
}