package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	@Given("^Add Place payload$")
	public void add_place_payload() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@When("^when user call \"([^\"]*)\" with http request$")
	public void when_user_call_with_http_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Then("^The API call is success with status code \"([^\"]*)\"$")
	public void the_api_call_is_success_with_status_code(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	@And("^\"([^\"]*)\" in response is \"([^\"]*)\"$")
	public void in_response_is(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@And("^\"([^\"]*)\" in the response body is \"([^\"]*)\"$")
	public void in_the_response_body_is(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}



	
}
