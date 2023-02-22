package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ReusableUtils;

public class InventoryPage extends ReusableUtils {

	public WebDriver driver;

	public InventoryPage(WebDriver driver) {
			
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
	@FindBy (id = "react-burger-menu-btn")
	WebElement menuButton;
	
	@FindBy(xpath="//div[@class='header_secondary_container']/span[text()='Products']")
	WebElement productsTab;
	
	@FindBy(id="about_sidebar_link")
	WebElement aboutLink;
	
	@FindBy (xpath="//a[contains (@id, 'title_link')]/div")
	List<WebElement> productNames;
	
	@FindBy (css="select.product_sort_container")
	WebElement filterOption;
	
	@FindBy (css="div[class='pricebar'] div")
	List<WebElement> prices;
	
	public boolean isInvMenuDisplayed () {
		
		return menuButton.isDisplayed();
	}
	
	public boolean isproductsTabDisplayed () {
		
		return productsTab.isDisplayed();
	}
	
	public void openMenuTab () {
		
		ReusableUtils.jsClick(menuButton);
	}
	
	public void clickAboutLink() {
		
		ReusableUtils.jsClick(aboutLink);
	}
	
	public boolean isAboutLinkDisplayed () {
		
		return aboutLink.isDisplayed();
		
	}
	
	public List<String> getProductNames (List<WebElement> productNames) {
		
		List<String> prodNames = new ArrayList<>();
		
		for(int i=0; i<productNames.size();i++) {
			
			prodNames.add(productNames.get(i).getText());
		}
		
		return prodNames;
	}
	

	public List<String> getProductNames () {
		
		List<String> prodNames = new ArrayList<>();
		
		for(int i=0; i<productNames.size();i++) {
			
			prodNames.add(productNames.get(i).getText());
		}
		
		return prodNames;
	}
	
	public void filterResults(String value) {
		
		ReusableUtils.dropdownSelect(filterOption, value);
	}
	
	public boolean checkZAFilter() {
		
//		filterResults("za");
		
		List<String> prodList = getProductNames(productNames);
		
		List<Character> firstLetter = new ArrayList<>();
		
		for(int i=0; i<prodList.size();i++) {
			
			firstLetter.add(prodList.get(i).charAt(0));
		}
		
		 List<Character> orderedList = new ArrayList<>(firstLetter);
		 
		 Collections.sort(orderedList, Collections.reverseOrder());
		 
		 System.out.println("Ordered List: "+orderedList);
		 System.out.println("Original List: "+firstLetter);
		 
		 return firstLetter.equals(orderedList);
				 
		 
		
		
		
	}
	
	public boolean checkHiLowFIlter() {
		
List<String> prodList = getProductNames(prices);
		
		List<Double> priceIntValue = new ArrayList<>();
		
		for(int i=0; i<prodList.size();i++) {
			
			priceIntValue.add(Double.parseDouble(prodList.get(i).substring(1)));
		
		}
		
		List<Double> orderedList = new ArrayList<>(priceIntValue);
		
		System.out.println("price_orderedList: "+ orderedList);
		System.out.println("price_priceIntValue: "+ priceIntValue);
		
		return priceIntValue.equals(orderedList);
	}
	
	
	

				 
		
	}
	

	

	

