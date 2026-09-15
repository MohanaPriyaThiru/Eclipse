package com.RAAutomation;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class PutMethod {
    @Test
	public void putMethod() {
		
//		Creating object for createId
		
		CreateId post = new CreateId();
		
		
	int bookingID=	post.postMethod();
		
		
//		Creating object for AuthMethos
		AuthMethod auth = new AuthMethod();
		
		String token= auth.authMethod();
		
		String reqPutPayload= """
				{
    "firstname" : "Mohana",
    "lastname" : "Priya",
    "totalprice" : 1000,
    "depositpaid" : false,
    "bookingdates" : {
        "checkin" : "2026-09-01",
        "checkout" : "2026-09-02"
    },
    "additionalneeds" : "Breakfast"
}  	
	""";
		
		
		
		Response putResponse=given()
			.contentType("application/json")
			.accept("application/json")
			.cookie("token",token)
			.body(reqPutPayload)
		.when()
			.put("https://restful-booker.herokuapp.com/booking/"+bookingID);
		
		putResponse.prettyPrint();
		
//		Status Code
		Assert.assertEquals(putResponse.getStatusCode(), 200);
		
//		Firstname
		Assert.assertEquals(putResponse.jsonPath().getString("firstname"), "Mohana");
		
//	    deposite paid
		Assert.assertEquals(putResponse.jsonPath().getBoolean("depositpaid"),false);
		
		Assert.assertEquals(putResponse.jsonPath().getString("bookingdates.checkout"),"2026-09-02");
		
		System.out.println("Finished");

	}

   
	
}
