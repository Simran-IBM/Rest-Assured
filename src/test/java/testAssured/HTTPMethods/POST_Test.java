package testAssured.HTTPMethods;

import org.testng.annotations.Test;

import testAssured.configReader.ConfigReader;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class POST_Test {
	
	String host = ConfigReader.getValueFromPropertyFile("DummyRest_Host");
	
	public HashMap map = new HashMap();  // Crete generic HashMap to accommodate different data types 
	
	public void postData() {
		
		map.put("name", "Simran");
        map.put("salary",140000);
        map.put("age",30);
        
        System.out.println(map);
	}
	
	@Test
	public void testPost() {
		
		given()
		   .contentType("application/json")
		   .body(map)
		
		.when()
		   .post(host+"/api/v1/create")
		
		.then()
			.statusCode(200)
			.log().all()
			.assertThat().body("message", equalTo("Successfully! Record has been added."))
			.header("Content-Type", "application/json");
				
		
	}

}
