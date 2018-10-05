package com.test.restAssured.restAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetCallBDD {
	
	@Test
	public void test_numberOfCircuits_2017()
	{
		
		given().
		when().
		get("http://ergast.com/api/f1/2017/circuits.json").
		
		then().
		assertThat().
		statusCode(200).
		
		and().
		
		body("MRData.CircuitTable.Circuits.circuitId", hasSize(20)).
		
		and().
		
		header("content-length", equalTo("4551"));	
	}

}
