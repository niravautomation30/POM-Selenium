package multiplewindow;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pages.MultipleWindowsPage;

public class MultipleWindowTest extends BaseTest {

	Logger log = Logger.getLogger(MultipleWindowTest.class);
	
	@Test
	public void testMultipleWindow() {
		
		log.info("\n===========Start testMultipleWindow method============");
		logger = report.createTest("Multiple window test");
		logger.info("start mulwindow");
		
		MultipleWindowsPage mulWinPage=homePage.clickOnMultipleWindows();	
		
		String str_parent_win_title=mulWinPage.getTitleOfWindow();
		System.out.println("Parentwindow Title :"+str_parent_win_title);
		System.out.println("Parentwindow Heading :"+mulWinPage.getWindowHeading());
		System.out.println("Parentwindow ID :"+mulWinPage.getPatentWindowID());
		Assert.assertEquals(str_parent_win_title, "The Internet11111111", "str_parent_win_title is INCORRECT");
		mulWinPage.triggerClick();
		mulWinPage.moveToChildWindow();
		
		String str_child_win_title= mulWinPage.getTitleOfWindow();
		System.out.println("Childwindow Title :"+str_child_win_title);
		System.out.println("Childwindow Heading :"+mulWinPage.getWindowHeading());
		System.out.println("Childwindow ID :"+mulWinPage.getChildWindowID());
		Assert.assertEquals(str_child_win_title, "New Window", "str_child_win_title is INCORRECT");
		mulWinPage.closeNewOpenWindow();
		System.out.println("-----Close Child window------");
		
		mulWinPage.moveToParentWinow();
		
		System.out.println("Parentwindow Title :"+mulWinPage.getTitleOfWindow());
		System.out.println("Parentwindow Heading :"+mulWinPage.getWindowHeading());
		System.out.println("Parentwindow ID :"+mulWinPage.getPatentWindowID());
		
		log.info("\n===========End testMultipleWindow method============");
		logger.pass("pass Multiple window test");
	}
}
