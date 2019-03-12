package com.test.restAssured.restAssured;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.test.restAssured.restAssured.ExcelReader.*;

import io.restassured.response.Response;


@Listeners(com.test.restAssured.restAssured.Listener.ListenerTest.class)
public class PostData_ExcelRead {
	ExcelReader excel;
    String filepath=System.getProperty("user.dir") + "\\src\\main\\java\\com\\test\\restAssured\\restAssured\\Data\\";
    ArrayList<String> data = new ArrayList<String>();
	
	@Test
	public void testPOST(){
		
		excel = new ExcelReader(); //Excel_Reader Class
		data=excel.getCellData(filepath,"testData.xlsx", "postdataUser",1);
		System.out.println(data);
		
		String userid=data.get(0);
		String id=data.get(1);
		String title=data.get(2);
		String body=data.get(3);
		
		JSONObject json = new JSONObject();
		json.put("userId", userid);
		json.put("id", id);
		json.put("title", title);
		json.put("body", body);
		
		String jsonstr=json.toJSONString();
		System.out.println(jsonstr);
		given().
		header("Content-Type","application/json").
		body(json.toJSONString()).
		post("http://jsonplaceholder.typicode.com/posts").
		then().
		statusCode(201).log().all();
	}
}


