package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ReusableUtils;

public class CartPage extends ReusableUtils {

	public WebDriver driver;
	public String pageTitle;
	public String pageURL;

	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		this.pageTitle = "Swag Labs";
		this.pageURL = "https://www.saucedemo.com/cart.html";
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "checkout")
	WebElement checkoutButton;

	@FindBy(id = "continue-shopping")
	WebElement continueShoppingButton;

	@FindBy(xpath = "//div[@class='cart_item_label']/a/div")
	WebElement addedItem;

	public boolean isTitleDisplayed() {

//	String pageTitle = "Swag Labs";

		return this.pageTitle.equalsIgnoreCase(driver.getTitle());
	}

	public boolean isUserNavigatedtoURL() {

//	String pageTitle = "Swag Labs";

		return this.pageURL.equalsIgnoreCase(driver.getCurrentUrl());
	}

	public boolean isItemDisplayed(String prodname) {

		
		return waitForElement(By.xpath("//div[@class='cart_item_label']/a/div")).getText().replace('-', ' ').equalsIgnoreCase(prodname);
	}

	public void checkOut() {

		moveToElementAndClick(checkoutButton);
	}

}
