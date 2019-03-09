package com.test.restAssured.restAssured;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

@Listeners(com.test.restAssured.restAssured.Listener.ListenerTest.class)
public class PostData1 {
	
	public static Map<String, String> map = new HashMap<String, String>();
	
	/*@BeforeTest
	public void postdata(){
		map.put("userId", "2");
		map.put("id", "19");
		map.put("title", "this is projectdebug.com");
		map.put("body", "this is REST-Assured Tutorial");	
		baseURI = "http://jsonplaceholder.typicode.com";
		basePath = "/posts/";
	} */
	
	@Test
	public void testPOST(){
		RequestSpecification request=given();
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("userId", "22");
		json.put("id", "22");
		json.put("title", "This is test");
		json.put("body", "This is the first test to create user");
		
		request.body(json.toJSONString());
			
		// Response response = request.delete("http://jsonplaceolder.typicode.com/posts/22");
		// Response response = request.put("http://jsonplaceholder.typicode.com/posts/22");
		
		int code = request.post("http://jsonplaceholder.typicode.com/posts").getStatusCode();
		
		String data = request.post("http://jsonplaceholder.typicode.com/posts").asString();
		System.out.println("Response is "+data);
		
		Assert.assertEquals(code, 201);
	}
}

