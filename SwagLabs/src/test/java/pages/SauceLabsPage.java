package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utility.ReusableUtils;

public class SauceLabsPage extends ReusableUtils {

	
	public WebDriver driver;
	
	public SauceLabsPage (WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getPageTitle() {
		
		return driver.getTitle();
	}
	

	public String getPageUrl() {
		
		return driver.getCurrentUrl();


	
}
	
}
