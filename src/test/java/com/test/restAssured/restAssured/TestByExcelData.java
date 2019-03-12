package com.test.restAssured.restAssured;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import io.restassured.response.*;

import com.test.restAssured.restAssured.ExcelReader.*;

@Listeners(com.test.restAssured.restAssured.Listener.ListenerTest.class)
public class TestByExcelData {
	
	ExcelReader excel;
    String filepath=System.getProperty("user.dir") + "\\src\\\\main\\java\\com\\test\\restAssured\\restAssured\\Data\\";
    ArrayList<String> data = new ArrayList<String>();
	String host="https://jsonplaceholder.typicode.com/";
	int rows;
	@Test
	public void test() {
		excel = new ExcelReader(); //Excel_Reader Class
		
		for (int i=1;i<=4;i++) {
		data=excel.getCellData(filepath,"testData.xlsx", "testdata",i);
		String id=data.get(0);
		String name=data.get(1);
		String username=data.get(2);
		String email=data.get(3);
		
	Response response=given().
	get(host+id).
	then().
	extract().response();
	
	String resp=response.asString();
    System.out.println("Response is:" +resp);
	
	given().
	get(host+id).
	then().
	statusCode(200).
	body("name", equalTo(name)).body("username", equalTo(username)).and().
	body("email", equalTo(email));
		}
}
}
