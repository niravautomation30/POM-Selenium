package multiplewindow;

import org.testng.annotations.Test;

import basetest.BaseTest;
import pages.MultipleWindowsPage;

public class MultipleWindowTest extends BaseTest {

	@Test
	public void testMultipleWindow() {
		
		MultipleWindowsPage mulWinPage=homePage.clickOnMultipleWindows();	
		
		System.out.println("Parentwindow Title :"+mulWinPage.getTitleOfWindow());
		System.out.println("Parentwindow Heading :"+mulWinPage.getWindowHeading());
		System.out.println("Parentwindow ID :"+mulWinPage.getPatentWindowID());
		
		mulWinPage.triggerClick();
		mulWinPage.moveToChildWindow();
		
		System.out.println("Childwindow Title :"+mulWinPage.getTitleOfWindow());
		System.out.println("Childwindow Heading :"+mulWinPage.getWindowHeading());
		System.out.println("Childwindow ID :"+mulWinPage.getChildWindowID());
		
		mulWinPage.closeNewOpenWindow();
		System.out.println("-----Close Child window------");
		
		mulWinPage.moveToParentWinow();
		
		System.out.println("Parentwindow Title :"+mulWinPage.getTitleOfWindow());
		System.out.println("Parentwindow Heading :"+mulWinPage.getWindowHeading());
		System.out.println("Parentwindow ID :"+mulWinPage.getPatentWindowID());
		
	}
}
