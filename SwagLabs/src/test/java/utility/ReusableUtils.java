package utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableUtils {
	public static WebDriver driver;
	public static JavascriptExecutor js;

	public ReusableUtils (WebDriver driver) {

		this.driver = driver;
	}

	public static WebElement waitForElement(By by) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public static String getProperty(String filename, String key) throws IOException {

		Properties pr = new Properties();
		FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\" + filename);
		pr.load(fr);

		return pr.getProperty(key);
	}

	public static void dropdownSelect(WebElement element, String value) {

		Select s = new Select(element);
		s.selectByValue(value);
	}

	public static void scroll(String pixels) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0," + pixels + ")");
	}

	public static void switchToFrame(WebElement frameElement) {

		driver.switchTo().frame(frameElement);
	}

	public static void switchToDefaultFrame() {

		driver.switchTo().defaultContent();
	}

	public static void switchWindows(String windowtitle) {

		String defaultWindow = driver.getWindowHandle();
		int count = 0;

		for (String handle : driver.getWindowHandles()) {

			driver.switchTo().window(handle);

			if (driver.getTitle().equalsIgnoreCase(windowtitle)) {

				break;
			}

			else {
				count++;

			}

		}

		if (count >= driver.getWindowHandles().size()) {

			driver.switchTo().window(defaultWindow);

		}

	}

	public static void takesnapshot(String name) {
//		System.out.println("Taking screenshot method is called");
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "//SS//" + name + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void acceptAlert() {

		driver.switchTo().alert().accept();
	}

	public static void dismissAlert() {

		driver.switchTo().alert().dismiss();
	}
	
	public static void jsClick(WebElement element) {
		
		js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
		
	}
	


}
