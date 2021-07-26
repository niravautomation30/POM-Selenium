package basetest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class BaseTest {

	private WebDriver driver;
	protected HomePage homePage;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {

		// log through testNG Reporter class
		Reporter.log("setting up suite", true);
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/ExtentReport"+getDate()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("setting end suite", true);
	}

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	@BeforeMethod
	public void goHome() {
		driver.get("https://the-internet.herokuapp.com/");
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void takeScreenshotWhenFail(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String path = System.getProperty("user.dir") + "/Screenshots/" + getDate() + ".png";
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();		
	}
	
	@AfterSuite
	public void tearDownSuite() {
		report.flush();
	}
	
	public static String getDate()
	{
		long time=System.currentTimeMillis();
		
		SimpleDateFormat userformat=new SimpleDateFormat("MMM-dd-yyyy-HH-mm-ss");
		
		Date date=new Date(time);
		
		String newDate=userformat.format(date);

	    return newDate;
		
	}
}
