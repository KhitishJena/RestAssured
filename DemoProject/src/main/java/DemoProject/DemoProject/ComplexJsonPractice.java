package DemoProject.DemoProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonPractice {

	@Test
	public void courses_Json() {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(Payload.complexJsonInput());
		int courses_Count = js.getInt("courses.size()");
		System.out.println("The total number of courses bought are: " + courses_Count);

		String totalPurchase_Amount = js.getString("dashboard.purchaseAmount");
		System.out.println("The total Purchase amount is: " + totalPurchase_Amount);

		String title_firstCourse = js.getString("courses[0].title");
		System.out.println("The title of first course is: " + title_firstCourse);

		int calculated_TotalPurchaseAmount = 0;
		for (int i = 0; i < courses_Count; i++) {

			String title = js.getString("courses[" + i + "].title");
			int price = js.getInt("courses[" + i + "].price");
			int copies = js.getInt("courses[" + i + "].copies");

			System.out.println("The price of " + title + " is Rs." + price);

			if (title.equalsIgnoreCase("RPA")) {

				System.out.println("The number of copies sold by " + title + " is " + copies);
			}

			int individual_CoursePrice = price * copies;

			calculated_TotalPurchaseAmount = calculated_TotalPurchaseAmount + individual_CoursePrice;

			/*
			 * if(calculated_TotalPurchaseAmount == Integer.parseInt(totalPurchase_Amount))
			 * { System.out.println("***Total calculated Purchase Amount "
			 * +calculated_TotalPurchaseAmount); break; }
			 */

		}
		Assert.assertEquals(calculated_TotalPurchaseAmount, Integer.parseInt(totalPurchase_Amount));
		System.out.println("Total calculated Purchase Amount " + calculated_TotalPurchaseAmount);

	}
}
