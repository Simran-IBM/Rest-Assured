package com.tutorial.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Listeners(com.test.restAssured.restAssured.Listener.ListenerTest.class)
public class Test1_JSON_GET {
	
	// Checking status code
	//@Test
	public void testStatusCode() {
		given().
		get("http://jsonplaceholder.typicode.com/posts/3").
		then().
		statusCode(200);
	}
	
	//Checking code and print response
	
	//@Test
	public void testLogging() {
		given().
		get("http://jsonplaceholder.typicode.com/posts/3").
		then().
		statusCode(200).
		log().all();
	}
	
	//Checking single content using org.hamcrest.Matchers
	
	//@Test
	public void testEqualToFunction() {
		given().
		get("http://jsonplaceholder.typicode.com/posts/3").
		then().
		body("id", equalTo(3));
	}
	
	
	//Checking multiple content using org.hamcrest.Matchers
	//@Test
	public void testHasItemFunction() {
		given().
		get("http://jsonplaceholder.typicode.com/posts").
		then().
		body("id", hasItems(3,2,100));
	}
	
	//parameters and headers can be set
	//@Test
	public void testParametersandHeaders() {
		given().
		param("Key1","Value1").
		header("HeaderKey1","HeaderValue1").
		when().
		get("http://jsonplaceholder.typicode.com/posts/3").
		then().
		statusCode(200).   
		log().all();
	}
	
	//Using and to increase readability
	
	//@Test
	public void testParametersandHeadersWithAnd() {
		given().param("Key1","Value1").and().header("HeaderKey1","HeaderValue1").when().get("http://jsonplaceholder.typicode.com/posts/3").then().statusCode(200).and().body("id", equalTo(3));
	}

	//Using is
	//Not setting root
	
	//@Test
	public void testWithoutRoot() {
		given().
		get("http://ergast.com/api/f1/2017/circuits.json").
		then().
		body("MRData.CircuitTable.Circuits[0].Location.locality", is("Melbourne"));
	}
	
	//Using is
	// Setting root
	
	//@Test
	public void testWithRoot() {
		given().
		get("http://ergast.com/api/f1/2017/circuits.json").
		then().
		root("MRData.CircuitTable").
		body("Circuits[0].Location.locality", is("Melbourne"));
	}
	
	//Detach Root
	
	@Test
	public void testDetachRoot() {
		given().
		get("http://ergast.com/api/f1/2017/circuits.json").
		then().
		root("MRData.CircuitTable").
		body("Circuits[0].Location.locality", is("Melbourne")).
		detachRoot("CircuitTable").
		body("CircuitTable.Circuits[0].Location.locality", is("Melbourne"));
	}
	
	
	
	
	
	
	
	
	
	
	
}
