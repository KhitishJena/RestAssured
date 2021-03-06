package DemoProject.DemoProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;

public class StaticJsonPath {
	
	@Test
	public void AddPlace() throws IOException {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("D:\\sampleJson.json"))))
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("status",equalTo("OK"));
	}

}
