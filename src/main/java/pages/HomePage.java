package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}

	public AlertPage clickOnJSLink() {
		clickLink("JavaScript Alerts");
		return new AlertPage(driver);
	}
	
	public MultipleWindowsPage clickOnMultipleWindows() {
		clickLink("Multiple Windows");
		return new MultipleWindowsPage(driver);
	}

}
