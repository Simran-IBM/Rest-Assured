package testAssured.HTTPMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import testAssured.configReader.ConfigReader;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DELETE_Test {
	
	String host = ConfigReader.getValueFromPropertyFile("DummyRest_Host");
	
	@Test
	public void testDelete() {
		
		Response response =
		given()
		
		.when()
		  .delete(host+"/api/v1/delete/2")
		  
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.extract().response();
		
		String responseInStringFormat = response.asString();  // convert JSON to String
		
		Assert.assertEquals(responseInStringFormat.contains("Successfully! Record has been deleted"), true);
	}

}
