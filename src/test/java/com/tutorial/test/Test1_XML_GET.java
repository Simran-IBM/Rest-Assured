package com.tutorial.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Listeners(com.test.restAssured.restAssured.Listener.ListenerTest.class)
public class Test1_XML_GET {
	
	//Checking XML Response for single body content
	//@Test
	public void testSingleContent() {
		given().
		get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").
		then().
		body("CUSTOMER.ID", equalTo("10")).
		log().all();
	}
	
	//Checking XML Response for multiple body content
		//@Test
		public void testMultipleContent() {
			given().
			get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").
			then().
			body("CUSTOMER.ID", equalTo("10")).
			body("CUSTOMER.FIRSTNAME", equalTo("Sue")).
			body("CUSTOMER.LASTNAME", equalTo("Fuller")).body("CUSTOMER.STREET", equalTo("135 Upland Pl.")).
			body("CUSTOMER.CITY", equalTo("Dallas")).
			log().all();
		}
		
		//Checking complete text in one go
		//@Test
		public void testCompleteTextInOneGo() {
			
			given().
			get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").
			then().
			body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas")).
			log().all();
		}
		
		//Xpath can also be used to find values
		//@Test
		public void testUsingXpath() {
			given().
			get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").
			then().
			body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Sue")));
		}
		
		// Xpath type 2
		
	@Test
	public void testXpath2() {
		given().
		get("http://www.thomas-bayer.com/sqlrest/INVOICE/").
		then().
		body(hasXPath("/INVOICEList/INVOICE[text()='40']")).log().all();
	}
		
		
		
		
		
		
		
		
		
		
		
		
		

}
