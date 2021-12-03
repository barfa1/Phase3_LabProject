package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void PostCall() {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\n" + 
						"        \"email\": \"new1@gmail.com\",\n" + 
						"        \"first_name\": \"NewUser\",\n" + 
						"        \"last_name\": \"NewLastName\",\n" + 
						"        \"avatar\": \"https://reqres.in/img/faces/1-image.jpg\"\n" + 
						"    }")
				.post("/api/users");
		String ResponseBody = response.body().asString();
		System.out.println(ResponseBody);
		
//		Verify reponse code 
		int ActResponse = response.statusCode();
		int Expected = 201;
		Assert.assertEquals(ActResponse, Expected);
	}
}

