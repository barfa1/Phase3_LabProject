package test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	@Test
	public void GetCall() {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/api/users?page=2");
		String ResponseBody = response.body().asString();
		System.out.println(ResponseBody);
	}
}
