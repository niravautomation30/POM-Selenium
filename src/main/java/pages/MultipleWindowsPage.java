package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage {

	private WebDriver driver;
	private By triggerClick = By.linkText("Click Here");
	private By window_heading = By.xpath("//h3");
	private String parent_window_id;
	private String child_window_id;

	public MultipleWindowsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void triggerClick() {
		driver.findElement(triggerClick).click();
	}

	public String getPatentWindowID() {
		parent_window_id = driver.getWindowHandle();
		return parent_window_id;
	}

	public String getChildWindowID() {
		return child_window_id;
	}

	public void moveToChildWindow() {
		Set<String> windows = driver.getWindowHandles();
		System.out.println("windows====" + windows);
		for (String win : windows) {
			if (!win.equalsIgnoreCase(parent_window_id)) {
				child_window_id = win;
				driver.switchTo().window(child_window_id);
			}
		}

	}

	public void moveToParentWinow() {
		driver.switchTo().window(parent_window_id);		
	}

	public String getTitleOfWindow() {
		return driver.getTitle();
	}

	public String getWindowHeading() {
		return driver.findElement(window_heading).getText();
	}

	public void closeNewOpenWindow() {
		driver.close();
	}

}
