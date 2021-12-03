package usingbdd;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	@Test
	public void PostCall() {
		Logger  logger  = Logger.getLogger("APILogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		logger.info("################## Started PostCall Method ################");
		
		Map<Object,String> PostBody = new HashMap<Object,String>();
		PostBody.put("email", "rest1@gmail.com");
		PostBody.put("first_name", "Rest");
		PostBody.put("last_name", "API");
		PostBody.put("avtar", "https://reqres.in/img/faces/1-image.jpg");
		RestAssured.given()
		.baseUri("https://reqres.in")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(PostBody)
		.when()
		.post("/api/users")
		.then()
		.statusCode(201)
		.log()
		.all();
	}
}
