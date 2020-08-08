package testAssured.testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import testAssured.configReader.ConfigReader;

import static io.restassured.RestAssured.*;

@Listeners(testAssured.Listener.ListenerTest.class)
public class GET_OpenWeather_City {
	
	String host = ConfigReader.getValueFromPropertyFile("OpenWeather_Host");
	
	@Test(priority=1)
	public void getOpenWeatherCity() {
		
		Response resp = get(host+"/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");
		
		int code=resp.getStatusCode();
		int expectedCode=200;
		String expectedContentType="application/json; charset=utf-8";
		System.out.println("Status code is "+code);
		
		String data=resp.asString();
		long time=resp.getTime();
		System.out.println("Data is "+data);
		System.out.println("Response Time: "+time);
		
		String contentType=resp.getContentType();
		System.out.println(contentType);
		
		Assert.assertEquals(code,expectedCode);
		Assert.assertTrue(time<3000); // less than 2000 ms
		Assert.assertEquals(contentType, expectedContentType);
		
		
	}
}

