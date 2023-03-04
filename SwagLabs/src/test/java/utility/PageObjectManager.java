package utility;

import org.openqa.selenium.WebDriver;

import pages.*;

public class PageObjectManager {
	
	public Homepage homepage;
	public InventoryPage inventorypage;
	public SauceLabsPage sauceLabsPage;
	public CartPage cartPage;
	public WebDriver driver;
	public CheckoutTwo checkoutTwo;
	public CheckoutOne checkoutOne;
	public CheckoutComplete checkoutComplete;
	
	public PageObjectManager (WebDriver driver) {
		
		this.driver=driver;
	}
	
	public Homepage getHomePage() {
		
		homepage = new Homepage(driver);
		return homepage;
	}
	
	public InventoryPage getInventoryPage() {
		
		inventorypage = new InventoryPage(driver);
		return inventorypage;
	}
	
	public SauceLabsPage getSauceLabsPage () {
		
		sauceLabsPage = new SauceLabsPage(driver);
		return sauceLabsPage;
	}
	
	public CartPage getCartPage () {
		
		cartPage = new CartPage(driver);
		return cartPage;
		
		
	}

	public CheckoutOne getCheckoutOne() {
		return checkoutOne = new CheckoutOne(driver);
	}

	public CheckoutTwo getCheckoutTwo() {

		return checkoutTwo = new CheckoutTwo(driver);
	}

	public CheckoutComplete getCheckoutComplete() {
		return checkoutComplete = new CheckoutComplete(driver);
	}
}
