package utility;

import org.openqa.selenium.WebDriver;

import pages.CartPage;
import pages.Homepage;
import pages.InventoryPage;
import pages.SauceLabsPage;

public class PageObjectManager {
	
	public Homepage homepage;
	public InventoryPage inventorypage;
	public SauceLabsPage sauceLabsPage;
	public CartPage cartPage;
	public WebDriver driver;
	
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

}
