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
	        log().all().
	        assertThat().
	        body("INVOICEList.INVOICE[0]", equalTo("0"));
	}
}