package oAuth;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OAuth {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//*************GOOGLE IS NOT ALLOWING AUTOMATION********//
		/*
		 * System.setProperty("webdriver.chrome.driver", "D:\\SDET\\chromedriver.exe");
		 * WebDriver driver = new ChromeDriver(); driver.get(
		 * "https://accounts.google.com/o/oauth2/v2/auth/identifier?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&flowName=GeneralOAuthFlow"
		 * ); driver.findElement(By.cssSelector("input[type='email']")).sendKeys(
		 * "satishj90");
		 * driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER
		 * ); Thread.sleep(4000);
		 * 
		 * driver.findElement(By.cssSelector("input[type='password']")).sendKeys(
		 * "Lulu@123");
		 * driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.
		 * ENTER); Thread.sleep(4000);
		 * String url = driver.getCurrentUrl();
		 */
		
		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWjcR8X2rjYYC_ZYJ4Rs1JiijnAk4O3_8TPo7YIcSQ8F6aGR8Z0gfW2frMJo3kaelw&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";
		String partial_Code = url.split("code=")[1];
		String code = partial_Code.split("&scope")[0];
		
		System.out.println(code);
		
		
		String accessToken_response = given().urlEncodingEnabled(false).queryParam("code", code)
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grant_type", "authorization_code")
		.when().post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath jp = new JsonPath(accessToken_response);
		String accessToken = jp.getString("access_token");
		
		String response = given().urlEncodingEnabled(false).queryParam("access_token", accessToken)
		.when().get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(response);
	}

}
