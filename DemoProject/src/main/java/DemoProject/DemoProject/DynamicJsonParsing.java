package DemoProject.DemoProject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;

public class DynamicJsonParsing {

	@Test(dataProvider = "BookDetails")
	public void AddBook(String isbn, String aisle) {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "http://216.10.245.166";

		String add_response = given().log().all().header("Content-Type", "application/json")
				.body(Payload.AddBook(isbn, aisle))
				.when().post("Library/Addbook.php")
				.then().log().all().assertThat()
				.statusCode(200).body("Msg", equalTo("successfully added")).extract().response().asString();

		JsonPath jp = new JsonPath(add_response);
		JsonPath jp1 = new JsonPath(Payload.AddBook(isbn, aisle));
		String fetched_id = jp.getString("ID");
		String isbn1 = jp1.getString("isbn");
		String aisle1 = jp1.getString("aisle");
		String isbn_aisle = isbn1 + aisle1;
		Assert.assertEquals(fetched_id, isbn_aisle);

	}

	@Test(dataProvider = "BookDetails", dependsOnMethods = { "AddBook" })
	public void DeleteBook(String isbn, String aisle) {

		RestAssured.baseURI = "http://216.10.245.166";

		String id = isbn + aisle;
		given().log().all().header("Content-Type", "application/json")
				.body("{\r\n" + " \r\n" + "\"ID\" : \"" + id + "\"\r\n" + " \r\n" + "}\r\n" + "")
				.when().post("/Library/DeleteBook.php")
				.then().log().all().assertThat().statusCode(200)
				.body("msg", equalTo("book is successfully deleted"));

	}

	@DataProvider(name = "BookDetails")
	public Object[][] BookDetails() {
		String isbn = "SatishJ";
		return new Object[][] { { isbn, "4643453" }, { isbn, "564646" }, { isbn, "23456" } };

	}

}
