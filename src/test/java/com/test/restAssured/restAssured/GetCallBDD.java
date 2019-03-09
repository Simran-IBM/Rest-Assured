package com.test.restAssured.restAssured;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Listeners(com.test.restAssured.restAssured.Listener.ListenerTest.class)
public class GetCallBDD {

	@Test
	public void test_numberOfCircuitsfor2017() {
		
		given().when().get("http://ergast.com/api/f1/2017/circuits.json").
		then().
		assertThat().
		statusCode(200).
		and().
		body("MRData.CircuitTable.Circuits.circuitid", hasSize(20)).
		and().
		header("content-length", equalTo("4551"));	;
	}
}
