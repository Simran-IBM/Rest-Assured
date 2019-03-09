package com.test.restAssured.restAssured;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Listeners(com.test.restAssured.restAssured.Listener.ListenerTest.class)
public class GetData {
	
	@Test(priority=1)
	public void testResponseCode() {
		Response resp=RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");
		int code=resp.getStatusCode();
		String contentType=resp.getContentType();
		int expectedcode=200;
		System.out.println("Status code is "+code);
		System.out.println("Content Type is "+contentType);
		
		Assert.assertEquals(code,expectedcode);
		
	}
	
	@Test(priority=2)
	public void testResponseBody() {
		Response resp=RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");
		String data=resp.asString();
		System.out.println("Data is "+data);
		
		System.out.println("Response Time: "+resp.getTime());
		
	}

}