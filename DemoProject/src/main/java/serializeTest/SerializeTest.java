package serializeTest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SerializeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pojo1 pj1 =new Pojo1();
		pj1.setAccuracy(50);
		pj1.setAddress("29, side layout, cohen 09");
		pj1.setLanguage("French-IN");
		
		Pojo2 pj2 =new Pojo2();
		pj2.setLat(-38.383494);
		pj2.setLng(33.427362);
		
		pj1.setLocation(pj2);
		pj1.setName("satish house");
		pj1.setPhone_number("983 893 3937");
		
		List<String> types = new ArrayList<String>();
		types.add("satish");
		types.add("khitish");
		types.add("linu");
		
		pj1.setTypes(types);
		pj1.setWebsite("http://google.com");
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response = given().log().all().queryParam("key", "qaclick123").body(pj1)
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println("******"+response);
		

	}

}
