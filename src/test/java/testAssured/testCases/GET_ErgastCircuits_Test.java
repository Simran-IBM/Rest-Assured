package testAssured.testCases;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testAssured.configReader.ConfigReader;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Listeners(testAssured.Listener.ListenerTest.class)
public class GET_ErgastCircuits_Test {

	
	String host = ConfigReader.getValueFromPropertyFile("Ergast_Host");
	
	@Test
	public void getErgastCircuitsTest() {
		
		given().when().get(host+"/api/f1/2017/circuits.json").
		then().
		assertThat().
		statusCode(200).
		and().
		body("MRData.CircuitTable.Circuits.circuitid", hasSize(20)).
		and().
		header("content-length", equalTo("4551"));	;
	}
}
