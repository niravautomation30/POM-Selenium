package alerts;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pages.AlertPage;

public class AlertTest extends BaseTest {

	@Test
	public void testAlertAccept() {
		AlertPage alertPage = homePage.clickOnJSLink();
		alertPage.triggerAlert();
		String actual_alert_text = alertPage.getAlertText();
		alertPage.acceptJS();
		String result_text = alertPage.getResult();
		Assert.assertEquals(actual_alert_text, "I am a JS Alert", "actual_alert_text is incorrect");
		Assert.assertEquals(result_text, "You successfuly clicked an alert", "result_text is incorrect");
	}

	@Test
	public void testJSConfirmAccept() {
		AlertPage alertPage = homePage.clickOnJSLink();
		alertPage.triggerJSConfirm();
		String actual_jsconfirm_text = alertPage.getAlertText();
		alertPage.acceptJS();
		String result_confirm_text = alertPage.getResult();
		Assert.assertEquals(actual_jsconfirm_text, "I am a JS Confirm", "actual_jsconfirm_text is incorrect");
		Assert.assertEquals(result_confirm_text, "You clicked: Ok", "result_confirm_text is incorrect");

	}

	@Test
	public void testJSConfirmCancel() {
		AlertPage alertPage = homePage.clickOnJSLink();
		alertPage.triggerJSConfirm();
		String actual_jsconfirm_text = alertPage.getAlertText();
		alertPage.cancelJS();
		String result_confirm_text = alertPage.getResult();
		Assert.assertEquals(actual_jsconfirm_text, "I am a JS Confirm", "actual_jsconfirm_text is incorrect");
		Assert.assertEquals(result_confirm_text, "You clicked: Cancel", "result_confirm_text is incorrect");

	}

	@Test
	public void testPromptWithValueAndOK() {

		String str_promt_value="nirav";
		AlertPage alertPage = homePage.clickOnJSLink();
		alertPage.triggerJSPrompt();
		String actual_jspromt_text = alertPage.getAlertText();
		alertPage.passPromptValue(str_promt_value);
		alertPage.acceptJS();
		String result_prompt_text = alertPage.getResult();
		Assert.assertEquals(actual_jspromt_text, "I am a JS prompt", "actual_jspromt_text is incorrect");
		Assert.assertEquals(result_prompt_text, "You entered: "+str_promt_value, "result_prompt_text is incorrect");
		
	}
	
	@Test
	public void testPromptWithoutValueAndCancle() {

		AlertPage alertPage = homePage.clickOnJSLink();
		alertPage.triggerJSPrompt();
		String actual_jspromt_text = alertPage.getAlertText();
		alertPage.cancelJS();
		String result_prompt_text = alertPage.getResult();
		Assert.assertEquals(actual_jspromt_text, "I am a JS prompt", "actual_jspromt_text is incorrect");
		Assert.assertEquals(result_prompt_text, "You entered: null", "result_prompt_text is incorrect");
		
	}
}
