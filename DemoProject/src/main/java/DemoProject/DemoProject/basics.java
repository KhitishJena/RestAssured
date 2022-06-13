package DemoProject.DemoProject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import org.testng.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payload;
import files.ResusableMethods;

public class basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * given method-- all input details 
		 * when method-- API is submitted 
		 * then method-- response is validated
		 */
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//ADD PLACE
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlace())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("status",equalTo("OK"))
		.extract().response().asString();
		
		System.out.println("************************REPONSE STARTS********************");
		System.out.println(response);
		System.out.println("************************REPONSE ENDS**********************");
		
		JsonPath jp =new JsonPath(response);		
		String place_id = jp.getString("place_id");
		//System.out.println(place_id);
		
		
		//UPDATE PLACE
		
		String new_Address = "ae 302, bhubaneswar, Odisha";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\": \""+place_id+"\",\r\n"
				+ "\"address\": \""+new_Address+"\",\r\n"
				+ "\"key\": \"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//GET PLACE
		
		String getPlace_response = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place_id)
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).body("address", equalTo(new_Address))
		.extract().response().asString();
		
		System.out.println(getPlace_response);
		JsonPath jp1 = ResusableMethods.rawToJson(getPlace_response);
		String place = jp1.getString("address");
		
		Assert.assertEquals(place, new_Address);
		//Assert.assertEquals(place, "pacific");  //line used to see the fail scenario
	}

}
