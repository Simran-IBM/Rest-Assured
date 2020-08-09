package testAssured.HTTPMethods;

import org.testng.annotations.Test;

import testAssured.configReader.ConfigReader;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GET_Test {
	
	String host = ConfigReader.getValueFromPropertyFile("BooksAPI_Host");
	
	@Test
	public void getAllBooks() {
		
       given()
         // NA
        .when()
          .get(host+"/books")
        .then()
          .statusCode(200)
          .statusLine("HTTP/1.0 200 OK")
          .assertThat().body("books[0].name", equalTo("Test Book 1"))
          .header("Content-Type", "application/json")
          .log().all();	
	}
	
	@Test
	public void getBookByISBN() {
		
       given()
         // NA
        .when()
          .get(host+"/books/100")
        .then()
          .statusCode(200)
          .statusLine("HTTP/1.0 200 OK")
          .assertThat().body("name", equalTo("Test Book 1"))
          .header("Content-Type", "application/json")
          .log().all();	
	}

}
