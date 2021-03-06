package jiraAPITest;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="http://localhost:6060";
		
		SessionFilter session = new SessionFilter();
		//********LOGIN********//
		
		
		String login_Response = given().log().all().header("Content-Type","application/json")
				.body(JiraPayloads.LoginPayload()).filter(session)
		.when().post("/rest/auth/1/session")
		.then().log().all().assertThat().statusCode(200).extract().response().asString(); 
		
		//Session filter class can be used to record session before when()
		  JsonPath js = new JsonPath(login_Response); 
		  String name = js.getString("session.name"); 
		  String value = js.getString("session.value");
		  String cookie = name+value; 
		  System.out.println("**************"+cookie);
		 
		
		  //****************ADD Comment*********//
		 String addComment_Response= given().log().all().pathParam("key", "IN-1").header("Content-Type","application/json")
		  .body(JiraPayloads.AddcommentPayload()).filter(session)
		  .when().post("/rest/api/2/issue/{key}/comment")
		  .then().log().all().assertThat().statusCode(201).extract().response().asString();
		 
		 JsonPath jp = new JsonPath(addComment_Response);
		 String comment_id = jp.getString("id");
		 System.out.println("^^^^^^*******"+comment_id);
		
		  //***********DELETE COMMENT**********//
		  given().log().all().pathParam("key", "IN-1").pathParam("commentId", comment_id)
		  .filter(session)
		  .when().delete("rest/api/2/issue/{key}/comment/{commentId}")
		  .then().log().all().assertThat().statusCode(204);
		  
		  //*****ADD ATTACHEMENT*******//
		  
		  File f = new File("D:\\sampleJson.json");
		  if(f.exists()) {
		  given().log().all().pathParam("key", "IN-1").header("X-Atlassian-Token","no-check")
		  .header("Content-Type","multipart/form-data")
		  .filter(session).multiPart("file",f)
		  .when().post("rest/api/2/issue/{key}/attachments")
		  .then().log().all().assertThat().statusCode(200);
		  } 
	}

}
