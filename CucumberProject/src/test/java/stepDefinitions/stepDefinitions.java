package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

public class stepDefinitions {

	
	@Given("^User is on Landing page$")
	public void LandingPage() {
		
		System.out.println("User is on Landing page");
		
	}
	
	 @When("^User Logins with id \"([^\"]*)\" and password \"([^\"]*)\"$")
	    public void Login(String strArg1, String strArg2){
	        
	        System.out.println(strArg1);
	        System.out.println(strArg2);
	    }

	
	@And("^click sigin button$")
	public void Click() {
		
		System.out.println("User clicks sign up button");
		System.out.println("User clicks sign in button");
		
	}
	
	@Then("^Homepage is displayed$")
	public void HomePage() {
		
		System.out.println("User is on Home page");
		
	}
	
	@And("^All cards are \"([^\"]*)\"$")
	public void AllCards(String command) {
		
		System.out.println("All cards are "+command);
		
	}
}



