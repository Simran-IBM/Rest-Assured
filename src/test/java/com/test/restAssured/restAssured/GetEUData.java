package com.test.restAssured.restAssured;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

@Listeners(com.test.restAssured.restAssured.Listener.ListenerTest.class)
public class GetEUData {
	
	@Test(priority=1)
	public void testResponseCode() {
		int code=get("http://restcountries.eu/rest/v1/name/norway").getStatusCode();
		int expectedcode=200;
		System.out.println("Status code is "+code);
		
		Assert.assertEquals(code,expectedcode);
		
	}
	
	@Test(priority=2)
	public void testResponseBody() {
		String data=get("http://restcountries.eu/rest/v1/name/norway").asString();
		long time=get("http://restcountries.eu/rest/v1/name/norway").getTime();
		System.out.println("Data is "+data);
		
		System.out.println("Response Time: "+time);
		
	}

}



