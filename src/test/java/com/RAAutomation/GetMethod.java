package com.RAAutomation;

import static io.restassured.RestAssured.*;   // correct static import

import org.testng.annotations.Test;
//import org.testng.annotations.Test; 

public class GetMethod {
	@Test
public void getUsers() {
		
		given()//precondition
		 	.baseUri("https://restful-booker.herokuapp.com/booking")
		.when()// action
			.get()
		.then()// assertion
			.statusCode(200)
			.log().body();
		
	}

}
