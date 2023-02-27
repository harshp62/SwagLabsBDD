package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import dependencyinjection.TestContextSetup;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InventoryPage;

public class InventoryPageSteps {

	public WebDriver driver;
	public TestContextSetup testContextSetup;
	public InventoryPage inventoryPage;

	public InventoryPageSteps(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;
		inventoryPage = testContextSetup.pageObjectManager.getInventoryPage();
	}

	@Then("^he is redirected to the Inventory page$")
	public void he_is_redirected_to_the_inventory_page() throws Throwable {

		assertTrue(inventoryPage.isInvMenuDisplayed());
	}

	@And("^the products tab is visible$")
	public void the_products_tab_is_visible() throws Throwable {

		assertTrue(inventoryPage.isproductsTabDisplayed());
	}

	@When("^user is on the Inventory Page and opens the menu tab$")
	public void user_is_on_the_inventory_page_and_opens_the_menu_tab() throws Throwable {

		inventoryPage.openMenuTab();
	}

	@When("^user clicks on the about link on the Inventory Page$")
	public void user_clicks_on_the_about_link_on_the_inventory_page() throws Throwable {
		inventoryPage.clickAboutLink();
	}

	@Then("^the about link should appear$")
	public void the_about_link_should_appear() throws Throwable {

		assertTrue(inventoryPage.isAboutLinkDisplayed());
	}

	@When("^user is on the Inventory Page and the products tab is displayed$")
	public void user_is_on_the_inventory_page_and_the_products_tab_is_displayed() throws Throwable {

		assertTrue(inventoryPage.isproductsTabDisplayed());
	}

	@Then("^the (.+) is present on the page$")
	public void the_is_present_on_the_page(String productname) throws Throwable {

		assertTrue(inventoryPage.getProductNames().contains(productname));

	}
	@When("User filters the products alphabetically is descending order \\(Z-A)")
	public void user_filters_the_products_alphabetically_is_descending_order_z_a() {
	    
		inventoryPage.filterResults("az");
	    
	}
	@Then("The products should be displayed in descending alphabetical order")
	public void the_products_should_be_displayed_in_descending_alphabetical_order() {
	    
	    assertTrue(inventoryPage.checkAlphaFilter("az"));
	}
	
	@When("User filters the products by price from low to high")
	public void user_filters_the_products_by_price_from_low_to_high() {
	    // Write code here that turns the phrase above into concrete actions
		inventoryPage.filterResults("hilo");

	}
	@Then("The products should be displayed by price from low to high")
	public void the_products_should_be_displayed_by_price_from_low_to_high() {
	    // Write code here that turns the phrase above into concrete actions

		assertTrue(inventoryPage.checkPriceFIlter("lohi"));
		
	}
	
	@When("^User adds (.+) to the cart$")
	public void user_adds_sauce_labs_backpack_to_the_cart(String product) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    inventoryPage.addProductToCart(product);
	}
	
	@When("goes to the cart page")
	public void goes_to_the_cart_page() {
	    // Write code here that turns the phrase above into concrete actions
		inventoryPage.goToCart();
	}

}