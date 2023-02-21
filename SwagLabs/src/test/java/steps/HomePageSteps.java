package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import dependencyinjection.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Homepage;

public class HomePageSteps {
	
	public WebDriver driver;
	public TestContextSetup testContextSetup;
	public Homepage homepage;
	
	public HomePageSteps(TestContextSetup testContextSetup) {
		
		this.testContextSetup = testContextSetup;
		this.homepage = testContextSetup.pageObjectManager.getHomePage();
		
	}

	@Given("^User is on the homepage and title is displayed$")
	public void user_is_on_the_homepage_and_title_is_displayed() throws Throwable {
		
		assertTrue(homepage.validateTitleLogo());
		
	}

	@When("^User inputs valid (.+) and (.+) and logs in$")
	public void user_inputs_valid_and_and_logs_in(String username, String password) throws Throwable {
		
		homepage.login(username, password);
	}

	@When("^User inputs valid (.+) and invalid (.+)$")
	public void user_inputs_valid_and_invalid(String username, String password) throws Throwable {
		homepage.login(username, password);
	}

	@When("^user inputs valid username as \"([^\"]*)\" and leaves the password field blank$")
	public void user_inputs_valid_username_as_something_and_leaves_the_password_field_blank(String strArg1)
			throws Throwable {
		
		homepage.login(strArg1, "");
		
	}

	@When("^User inputs invalid (.+) and valid password as \"([^\"]*)\"$")
	public void user_inputs_invalid_and_valid_password_as_something(String username, String strArg1) throws Throwable {
		
		homepage.login(username, strArg1);
	}

	@Then("^Appropriate error message is displayed$")
	public void appropriate_error_message_is_displayed() throws Throwable {
		
		assertEquals(homepage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
	}

	@Then("^Error message is displayed requiring the user to input a password$")
	public void error_message_is_displayed_requiring_the_user_to_input_a_password() throws Throwable {
		
		assertEquals(homepage.getErrorMessage(), "Epic sadface: Password is required");
	}

	@And("^User is still on the homepage$")
	public void user_is_still_on_the_homepage() throws Throwable {

		assertTrue(homepage.validateTitleLogo());
	}
	

    @Given("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        
    	homepage.login("standard_user", "secret_sauce");
    }

}
