package com.test.restAssured.restAssured;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

@Listeners(com.test.restAssured.restAssured.Listener.ListenerTest.class)
public class GetData1 {
	
	@Test(priority=1)
	public void testResponseCode() {
		Response resp=get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");
		int code=resp.getStatusCode();
		int expectedcode=200;
		System.out.println("Status code is "+code);
		
		Assert.assertEquals(code,expectedcode);
		
	}
	
	@Test(priority=2)
	public void testResponseBody() {
		Response resp=get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");
		String data=resp.asString();
		System.out.println("Data is "+data);
		
		System.out.println("Response Time: "+resp.getTime());
		
	}

}


