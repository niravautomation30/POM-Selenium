package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {

	private WebDriver driver;
	private By triggerAlert = By.xpath("//button[contains(text(),'Click for JS Alert')]");
	private By triggerJSConfirm = By.xpath("//button[text()='Click for JS Confirm']");
	private By triggerJSPrompt = By.xpath("//button[text()='Click for JS Prompt']");
	private By result = By.id("result");

	public AlertPage(WebDriver driver) {
		this.driver = driver;
	}

	public void triggerAlert() {
		driver.findElement(triggerAlert).click();
	}

	public void triggerJSConfirm() {
		driver.findElement(triggerJSConfirm).click();
	}

	public void triggerJSPrompt() {
		driver.findElement(triggerJSPrompt).click();
	}

	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public void acceptJS() {
		driver.switchTo().alert().accept();
	}

	public void cancelJS() {
		driver.switchTo().alert().dismiss();
	}

	public void passPromptValue(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public String getResult() {
		return driver.findElement(result).getText();
	}

}
