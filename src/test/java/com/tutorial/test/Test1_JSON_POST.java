package com.tutorial.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;

@Listeners(com.test.restAssured.restAssured.Listener.ListenerTest.class)
public class Test1_JSON_POST {
	
	//POST Request
	
	@Test
	public void testPostRequest() {
		
		JSONObject json = new JSONObject();
		json.put("userId", "22");
		json.put("id", "22");
		json.put("title", "This is test");
		json.put("body", "This is the first test to create user");
		
		given().
		header("Content-Type", "application/json").
		request().body(json.toJSONString()).
		when().
		post("http://jsonplaceholder.typicode.com/posts").
		then().
		statusCode(201).log().all();
		
	}

}
