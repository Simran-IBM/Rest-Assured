package com.test.restAssured.restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import static io.restassured.RestAssured.given;

@Listeners(com.test.restAssured.restAssured.Listener.ListenerTest.class)
public class GetData_Assertion {

    public static Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

    @Test
    public static void startTest() {
        Response response = doGetRequest("https://jsonplaceholder.typicode.com/users");

        List<String> jsonResponse = response.jsonPath().getList("$");
        System.out.println("Response is:"+jsonResponse);
        System.out.println("Number of User Records:"+jsonResponse.size());
        String usernames = response.jsonPath().getString("username");
        System.out.println(usernames);
        String usernames0 = response.jsonPath().getString("username[0]");
        System.out.println(usernames0);
        
        Map<String, String> company = response.jsonPath().getMap("company[0]");
        System.out.println(company.get("name"));
        
        Set<Entry<String, String>> entryset=company.entrySet();
        
         for (Entry<String, String> entry:entryset) {
        	 System.out.println(entry.getKey() +":"+entry.getValue());
         }
         
        /*
         List<Map<String, String>> companies = response.jsonPath().getList("company");
        System.out.println(companies.get(0).get("name"));
         */
        
        Assert.assertEquals(jsonResponse.size(), 10);

    }
}