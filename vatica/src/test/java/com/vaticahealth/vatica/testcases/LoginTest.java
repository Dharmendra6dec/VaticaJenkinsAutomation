package com.vaticahealth.vatica.testcases;

import java.lang.reflect.InvocationTargetException;

//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;

import com.vaticahealth.vatica.config.TestAnnotation;
//import com.vaticahealth.vatica.pages.Login;
//import com.vaticahealth.vatica.utils.CommonCode;

import junit.framework.Assert;

public class LoginTest extends TestAnnotation {
	// CommonCode common = new CommonCode();

	// Login in to the application with correct credentials and select the
	// website 'Plus' from the dropdown of sites.
	public void tc_Login_1() throws InterruptedException, InvocationTargetException {

		common.implictWait(20);
		login.loginWithCorrectCredentials(logIdSupp, logPassowrdSupp);
		login.Login_Login_Btn();
		Thread.sleep(5000);
		common.selectByValue(login.webSiteOption, 2);
		// Thread.sleep(3000);
		login.selectWebsiteButton();

	}

	// Clicking on privacy policy and confirming the page title
	public void tc_Login_2() {
		common.implictWait(40);
		login.privacPolicyLink.click();
		String ExpText = common.readExcel("get_values", "PrivacyPolicyTitle");
		Assert.assertTrue(login.Login_PrivacyPolicy_text.getText().equals(ExpText));
		login.Login_PrivacyPolicy_Close_Btn.click();

	}

	// Clicking on Technical Support / Get Help and confirming the page title
	public void tc_Login_3() throws InterruptedException {
		common.implictWait(40);
		login.techSupportLink.click();
		String ExpText = common.readExcel("get_values", "TechSupportTitle");
		System.out.println("ok"+ExpText+"ok");
		System.out.println(login.Login_TechSupport_text.getText());
		Assert.assertTrue(login.Login_TechSupport_text.getText().equals(ExpText));
		login.Login_PrivacyPolicy_Close_Btn.click();
	}

	// Login memory check
	public void tc_Login_4() throws InterruptedException {
		common.implictWait(40);
		login.loginFiller();
		login.rememberMeCheckClick();
		login.Login_Login_Btn();
		login.websiteDropDown(intff);
		Thread.sleep(2000);
		login.selectWebsiteButton();
		home.logOut();
		login.checkEmailId(common.readExcel("hra", "EmailId"));
	}
}
