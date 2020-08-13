package testAssured.testCases;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testAssured.configReader.ConfigReader;

import static org.hamcrest.Matchers.equalTo;


@Listeners(testAssured.Listener.ListenerTest.class)
public class GET_ThomasBayer_XML {
	
	String host = ConfigReader.getValueFromPropertyFile("ThomasBayer_Host");
	
	@Test
	public void getThomasBayerXML() {
	                         
	    given().
	    when().
	        get(host+"/sqlrest/INVOICE").
	    then().
	        log().all(). // printing logs on the console
	        assertThat().
	        body("INVOICEList.INVOICE[10]", equalTo("10")); // part of assertion
	}
}