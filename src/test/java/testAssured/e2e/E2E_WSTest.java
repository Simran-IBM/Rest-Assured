package testAssured.e2e;

import java.util.ArrayList;
import static io.restassured.RestAssured.*;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import testAssured.configReader.ConfigReader;
import testAssured.excelReader.ExcelReader;

@Listeners(testAssured.Listener.ListenerTest.class)
public class E2E_WSTest {
	
	String host = ConfigReader.getValueFromPropertyFile("BooksAPI_Host");
	ExcelReader excel;
    String filepath=System.getProperty("user.dir") + "\\Resources\\Data\\";
    ArrayList<String> data = new ArrayList<String>();
	String contentType="";
	String uri="";
	String request="";
	String response="";
	int isbn = 103;
	
	@Test()
	public void e2e_GET(){
		
		excel = new ExcelReader();
		int rowNumber = 1;
		
		data=excel.getCellData(filepath,"testData.xlsx", "e2eData", rowNumber);
		System.out.println(data);
		uri = data.get(1);
		contentType = data.get(2);
		request = data.get(3);
		
		
		
				given().
				when().get(host+uri).
				then().
				statusCode(200).and().
				header("Content-Type", contentType).log().all().extract().response();
		
		
			
	}
	
	@Test(dependsOnMethods = "e2e_GET")
	public void e2e_POST() {
		excel = new ExcelReader();
		int rowNumber = 2;
		
		data=excel.getCellData(filepath,"testData.xlsx", "e2eData", rowNumber);
		uri = data.get(1);
		contentType = data.get(2);
		request = data.get(3);
		
		
		
				given().header("Content-Type", contentType).
				body(request).
				when().post(host+uri).
				then().
				statusCode(200).and().
				header("Content-Type", contentType).log().all().extract().response();
		
		
	}
	
	@Test(dependsOnMethods = "e2e_POST")
	public void e2e_PUT() {
		
		excel = new ExcelReader();
		int rowNumber = 3;
		
		data=excel.getCellData(filepath,"testData.xlsx", "e2eData", rowNumber);
		uri = data.get(1);
		contentType = data.get(2);
		request = data.get(3);
		
		
		
				given().header("Content-Type", contentType).
				body(request).
				when().put(host+uri+"/"+isbn).
				then().
				statusCode(200).and().
				header("Content-Type", contentType).log().all().extract().response();
		
	}
	
	@Test(dependsOnMethods = "e2e_PUT")
	public void e2e_DELETE() {
		
		excel = new ExcelReader();
		int rowNumber = 4;
		
		data=excel.getCellData(filepath,"testData.xlsx", "e2eData", rowNumber);
		uri = data.get(1);
		contentType = data.get(2);
		request = data.get(3);
		
		
		
				given().
				when().delete(host+uri+"/"+isbn).
				then().
				statusCode(200).and().log().all();
		
	}
}

