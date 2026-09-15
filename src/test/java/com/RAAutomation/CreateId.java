package com.RAAutomation;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;


public class CreateId {

	public int postMethod() {
		
		String requestPayload= """
				{
    "firstname" : "MohanaPriya",
    "lastname" : "Thiru",
    "totalprice" : 1000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2026-09-01",
        "checkout" : "2026-09-01"
    },
    "additionalneeds" : "Breakfast"
}  	
	""";
		
		Response response=given()
			.contentType("application/json")
			.body(requestPayload)
		.when()
			.post("https://restful-booker.herokuapp.com/booking");
		
	int bookingID=	response.jsonPath().getInt("bookingid");
		return bookingID;
		
	}
	
	
}
