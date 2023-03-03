package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ReusableUtils;

public class InventoryPage extends ReusableUtils {

	public WebDriver driver;

	public InventoryPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "react-burger-menu-btn")
	WebElement menuButton;

	@FindBy(xpath = "//div[@class='header_secondary_container']/span[text()='Products']")
	WebElement productsTab;

	@FindBy(id = "about_sidebar_link")
	WebElement aboutLink;

	@FindBy(xpath = "//a[contains (@id, 'title_link')]/div")
	List<WebElement> productNames;

	@FindBy(css = "select.product_sort_container")
	WebElement filterOption;

	@FindBy(css = "div[class='pricebar'] div")
	List<WebElement> prices;

	@FindBy(css = "button.btn")
	List<WebElement> addToCart;

	@FindBy(css = "a.shopping_cart_link")
	WebElement goToCartButton;

	public boolean isInvMenuDisplayed() {

		return menuButton.isDisplayed();
	}

	public boolean isproductsTabDisplayed() {

		return productsTab.isDisplayed();
	}

	public void openMenuTab() {

		jsClick(menuButton);
	}

	public void clickAboutLink() {

		jsClick(aboutLink);
	}

	public boolean isAboutLinkDisplayed() {

		return aboutLink.isDisplayed();

	}

	public List<String> getProductNames(List<WebElement> productNames) {

		List<String> prodNames = new ArrayList<>();

		for (int i = 0; i < productNames.size(); i++) {

			prodNames.add(productNames.get(i).getText());
		}

		return prodNames;
	}

	public List<String> getProductNames() {

		List<String> prodNames = new ArrayList<>();

		prodNames = productNames.stream().map(n->n.getText()).collect(Collectors.toList());

//		for (int i = 0; i < productNames.size(); i++) {
//
//			prodNames.add(productNames.get(i).getText());
//		}

		return prodNames;
	}

	public void filterResults(String value) {

		dropdownSelect(filterOption, value);
	}

	public boolean checkAlphaFilter(String filter) {


		List<String> prodList = getProductNames(productNames);

		List<Character> firstLetter;
		List<Character> fLetter;
		List<Character> oList;

		fLetter =prodList.stream().map(n->n.charAt(0)).collect(Collectors.toList());
		oList = fLetter.stream().sorted().collect(Collectors.toList());
		


		if (filter.equalsIgnoreCase("za")) {
			oList = fLetter.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		}
		else {
			
			oList = fLetter.stream().sorted().collect(Collectors.toList());
		}
		
		System.out.println("Original List: "+fLetter);
		System.out.println("Ordered List: "+oList);

		return fLetter.equals(oList);

	}

	public boolean checkPriceFIlter(String filter) {

		List<String> prodList = getProductNames(prices);

		List<Double> priceIntValue;

		priceIntValue= prodList.stream().map(n -> Double.parseDouble(n.substring(1))).collect(Collectors.toList());

		List<Double> orderedList = new ArrayList<>(priceIntValue);

		if (filter.equalsIgnoreCase("hilo")) {


			Collections.sort(orderedList, Collections.reverseOrder());
		}
		else {

			orderedList = priceIntValue.stream().sorted().collect(Collectors.toList());

		}

		System.out.println("price_orderedList: " + orderedList);
		System.out.println("price_priceIntValue: " + priceIntValue);

		return priceIntValue.equals(orderedList);
	}

	public void addProductToCart(String productname) throws Exception {

		boolean found = false;
		for (int i = 0; i < addToCart.size(); i++) {

			if (addToCart.get(i).getAttribute("id").split("cart")[1].replace('-', ' ').trim()
					.equalsIgnoreCase(productname)) {

				addToCart.get(i).click();
				found = true;
				break;
			}

		}
		if(found == false) {
			
			throw new Exception ("No such product found");
		}
		

	}

	public void goToCart() {

		goToCartButton.click();

	}

}
