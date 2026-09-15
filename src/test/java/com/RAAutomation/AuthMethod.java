package com.RAAutomation;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AuthMethod {
	@Test
	public String authMethod() {
		
		String authPayload ="""
				{
    "username" : "admin",
    "password" : "password123"
}
				""";
		
	Response authresponse = given()
			.contentType("application/json")
			.body(authPayload)
		.when()
			.post("https://restful-booker.herokuapp.com/auth");
	String token =authresponse.jsonPath().getString("token");
//	System.out.println(token);
		return token;
		
	
		
	}

}
