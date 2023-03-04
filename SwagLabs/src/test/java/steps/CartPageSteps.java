package steps;

import static org.testng.Assert.assertTrue;

import dependencyinjection.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;

public class CartPageSteps {
	
	public TestContextSetup testContextSetup;
	public CartPage cartPage;
	
	public CartPageSteps (TestContextSetup testContextSetup) {
		
		this.testContextSetup = testContextSetup;
		cartPage = testContextSetup.pageObjectManager.getCartPage();
	}
	
	@Then("user is navigated to the cart page")
	public void user_is_navigated_to_the_cart_page() {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(cartPage.isUserNavigatedtoURL());
	}
	
	@Then("cartpage title is displayed")
	public void cartpage_title_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(cartPage.isTitleDisplayed());
	}
	
	@Then("^(.+) is displayed in the cart$")
	public void sauce_labs_backpack_is_displayed_in_the_cart(String prod) {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(cartPage.isItemDisplayed(prod));
	}

	@When("user checks out")
	public void userChecksOut() {

		cartPage.checkOut();
	}


}
