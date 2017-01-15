package com.vaticahealth.vatica.testsuits;

//import java.awt.AWTException;
import java.io.PrintWriter;
import java.io.StringWriter;
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vaticahealth.vatica.config.TestAnnotation;
import com.vaticahealth.vatica.config.VaticaInterface;
//import com.vaticahealth.vatica.testcases.LoginTest;
//import com.vaticahealth.vatica.testcases.PHPTest;
//import com.vaticahealth.vatica.utils.CommonCode;
//import com.vaticahealth.vatica.utils.Elements;

public class RegressionTest extends TestAnnotation implements VaticaInterface {

	public void regressionTest() throws Exception {

		loginTest.tc_Login_1();

		phpTest.logoCheck();
		phpTest.checkFirstNameSortingonPHPGrid();
		phpTest.checkLastNameSortingonPHPGrid();
		phpTest.checkVisitDateSortingonPHPGrid();
		phpTest.colorcheck();
		phpTest.columnsOnGridCheck();
		phpTest.loginConf();
		phpTest.searchNewHraAndVerifyHraDetails();
		phpTest.siteCheck();
		phpTest.verifyOneRowOnPhp();
		phpTest.verifySiteOptions();

	}

	@Test(alwaysRun = true, description = "Settings drop down displayed with different options")
	public void optionsInSettings() throws InterruptedException {

		Thread.sleep(2000);
		home.Php_Settings_Btn.click();

		java.util.List<WebElement> listOfColumns = home.getColumnsOnGrid();
		System.out.println(listOfColumns);
		for (WebElement elle : listOfColumns) {
			System.out.println(elle.getText());
		}
		System.out.println("columns Done");
	}

	@Test(alwaysRun = true, description = "Reset Password of Email Id as enterd", enabled = false)
	public void resetPassword() {
		String resetEmailId = common.readExcel("get_values", "passwordResetEmail");
		String resetPasswordMessage = common.readExcel("get_values", "passwordResetMessage");
		login.resetPassword(resetEmailId, resetPasswordMessage);
	}

	@Test(alwaysRun = true, description = "Techincal supprt/help", enabled = false)
	public void techSupportLink() throws InterruptedException {
		login.technicalSupportLink(common.readExcel("get_values", "TechSupportTitle"));
		login.cancelTechSupport();

	}

	@Test(alwaysRun = true, description = "Privacy policy Link", enabled = false)
	public void privacyPolicyLink() {
		invokeUrl();
		login.privacyPolicy(common.readExcel("get_values", "PrivacyPolicyTitle"));
		login.closePrivacyPolicy();
	}

	@Test(alwaysRun = true, description = "LogIn Application with Inavalid password", enabled = false)
	public void invalidPassword() {
		try {
			Thread.sleep(3000);
			invokeUrl();
			login.loginWithCorrectCredentials(logIdSupp, logInvalidPasswordSupp);
			login.Login_Login_Btn();
		} catch (InterruptedException e) {
			StringWriter w = new StringWriter();

			e.printStackTrace(new PrintWriter(w));
			Reporter.log(w.toString());
			Assert.assertEquals(login.invalidLoginMess.getText(),
					common.readExcel("get_values", "invalidLoginMessage"));
		}

	}
}