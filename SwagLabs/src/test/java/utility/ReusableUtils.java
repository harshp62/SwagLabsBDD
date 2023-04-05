package utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableUtils {
	public WebDriver driver;
	public JavascriptExecutor js;
	public Actions actions;

	public ReusableUtils (WebDriver driver) {

		this.driver = driver;
	}

	public WebElement waitForElement(By by) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));



	}

	public List<WebElement> waitForElements(By by) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

	}

	public String getProperty(String filename, String key) throws IOException {

		Properties pr = new Properties();
		FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\" + filename);
		pr.load(fr);

		return pr.getProperty(key);
	}

	public void dropdownSelect(WebElement element, String value) {

		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void scroll(String pixels) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0," + pixels + ")");
	}

	public void switchToFrame(WebElement frameElement) {

		driver.switchTo().frame(frameElement);
	}

	public void switchToDefaultFrame() {

		driver.switchTo().defaultContent();
	}

	public void switchWindows(String windowtitle) throws InterruptedException {

		String defaultWindow = driver.getWindowHandle();
		System.out.println(driver.getWindowHandles().size());
		int count = 0;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		for (String handle : driver.getWindowHandles()) {

			driver.switchTo().window(handle);
//			wait.until(ExpectedConditions.titleContains(windowtitle));
//			Thread.sleep(3000);
			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase(windowtitle)) {

				break;
			}

			else {
				count++;

			}

		}
		System.out.println(count);

		if (count >= driver.getWindowHandles().size()) {

			driver.switchTo().window(defaultWindow);

		}

	}

	public void takesnapshot(String name) {
//		System.out.println("Taking screenshot method is called");
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "//SS//" + name + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void acceptAlert() {

		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {

		driver.switchTo().alert().dismiss();
	}
	
	public void jsClick(WebElement element) {
		
		js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
		
	}

	public void moveToElementAndClick(WebElement element) {

		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();


	}
	


}
