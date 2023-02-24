package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ReusableUtils;

public class Homepage extends ReusableUtils {

	public WebDriver driver;
	
	public Homepage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".login_logo")
	WebElement titleLogo;
	
	@FindBy(id="user-name")
	WebElement userInputBox;
	
	@FindBy(id="password")
	WebElement passwordInputBox;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement errorBox;
	
	
	public boolean validateTitleLogo() {
		
		return titleLogo.isDisplayed();
	}
	
	public void login(String username, String password) {
		
		userInputBox.sendKeys(username);
		passwordInputBox.sendKeys(password);
		jsClick(loginButton);
		
	}
	
	public String getErrorMessage () {
		
		return errorBox.getText();
	}
	
}
