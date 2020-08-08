package testAssured.testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import testAssured.configReader.ConfigReader;

import static io.restassured.RestAssured.*;

@Listeners(testAssured.Listener.ListenerTest.class)
public class GET_EU_Test {
	
	String host = ConfigReader.getValueFromPropertyFile("EU_Host");
	
	@Test()
	public void getEUTest() {
		
		Response response = get(host+"/rest/v1/name/norway");
		
		int code=response.getStatusCode();
		int expectedcode=200;
		
		String data=response.asString();
		long time=response.getTime();
		
		System.out.println("Status code is "+code);
		System.out.println("Data is "+data);
		System.out.println("Response Time: "+time);
		
		Assert.assertEquals(code,expectedcode);
		Assert.assertTrue(time<3000);
		
	}
}



