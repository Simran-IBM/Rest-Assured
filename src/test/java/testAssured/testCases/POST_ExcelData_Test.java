package testAssured.testCases;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testAssured.configReader.ConfigReader;
import testAssured.excelReader.ExcelReader;


@Listeners(testAssured.Listener.ListenerTest.class)
public class POST_ExcelData_Test {
	
	
	String host = ConfigReader.getValueFromPropertyFile("Typicode_Host");
	ExcelReader excel;
    String filepath=System.getProperty("user.dir") + "\\Resources\\Data\\";
    ArrayList<String> data = new ArrayList<String>();
	
	@Test
	public void postExcelDataTest(){
		
		excel = new ExcelReader(); //Excel_Reader Class
		data=excel.getCellData(filepath,"testData.xlsx", "postData",1);
		
		String userid=data.get(0);
		String title=data.get(2);
		String body=data.get(3);
		
		
		// Using JSONObject from json-simpole package
		
		JSONObject json = new JSONObject();
		json.put("userId", userid);
		json.put("title", title);
		json.put("body", body);
		
		String jsonstr=json.toJSONString();
		System.out.println("===============================================");
		System.out.println(jsonstr);
		System.out.print("===============================================");
		
		
		given().
		header("Content-Type","application/json").  // setting Content-Type for the POST request
		body(jsonstr).
		post(host+"/posts").
		then().
		statusCode(201).log().all();
	}
}


