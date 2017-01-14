package com.vaticahealth.vatica.testcases;

import java.awt.AWTException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.vaticahealth.vatica.config.TestAnnotation;

public class PPPTest extends TestAnnotation {

	// Verify all the PPP page header including Patient Name, DOB and age
	public void verifyHeaderOf_PPPTab() {
		common.implictWait(40);
		Assert.assertTrue(ppp.PPP_Header_text.getText().equals(common.readExcel("ppp", "PPP Header")),
				"PPP header doesn't match");
	}

	public void verifyTextOfLinksOnPPP() {
		common.implictWait(20);

		Assert.assertTrue(ppp.Introduction_link.getText().equals(common.readExcel("ppp", "Tab 1")),
				"Introduction link doesn't match");
		Assert.assertTrue(ppp.Current_Health_Analysis_link.getText().equals(common.readExcel("ppp", "Tab 2")),
				"Current Health Analysis link doesn't match");

		Assert.assertTrue(ppp.Personal_Health_Advice_link.getText().equals(common.readExcel("ppp", "Tab 3")),
				"Personal Heatlh Advice link doesn't match");

		Assert.assertTrue(ppp.Screening_Schedule_link.getText().equals(common.readExcel("ppp", "Tab 4")),
				"Screening Schedule link doesn't match");

		Assert.assertTrue(ppp.Community_Based_Resources_link.getText().equals(common.readExcel("ppp", "Tab 5")),
				"Community Based Resources link doesn't match");

	}

	// Verification on the Introduction tab of the PPP.
	public void verifyDataOn_Introduction_TabOnPPP() throws InterruptedException {

		common.implictWait(60);
		ppp.Introduction_link.click();
		Thread.sleep(10000);
		Assert.assertTrue(
				ppp.Patient_Name_On_Introduction_text.getText().equals(common.readExcel("ppp", "Introduction Name")),
				"Names on Introduction tab of PPP page doesn't match");
		// System.out.println(ppp.Patient_Name_On_Introduction_text.getText());

		common.explictWaitClickable(10, ppp.Introduction_Header_img);
		try {
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					ppp.Introduction_Header_img);

			Assert.assertTrue(ImagePresent, "Introduction Image isn't displayed.");
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("PPP Introduction Image didn't load on time.");
		}

	}

	// Verification on the Current Health Analysis tab of the PPP.
	public void verifyDataOn_CurrentHealthAnalysis_TabOnPPP() {

		common.implictWait(60);
		ppp.Current_Health_Analysis_link.click();

		List<WebElement> elle = ppp.Summary_Of_Test_Key_text;
		List<WebElement> elle2 = ppp.Summary_Of_Test_Value_text;
		for (int i = 0; i < 6; i++) {
			System.out.println(elle.get(i).getText());
			System.out.println(common.readExcel("ppp", "PPP key " + (i + 1) + ""));
			Assert.assertTrue(elle.get(i).getText().equals(common.readExcel("ppp", "PPP key " + (i + 1) + "")),
					elle.get(i).getText() + " is not matching");

			// System.out.println(elle2.get(i).getText());
			// System.out.println(common.readExcel("ppp", "PPP value " + (i + 1)
			// + ""));
			Assert.assertTrue(elle2.get(i).getText().equals(common.readExcel("ppp", "PPP value " + (i + 1) + "")),
					elle2.get(i).getText() + " is not matching");
		}

		common.explictWaitClickable(10, ppp.Current_Health_Analysis_img);
		try {
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					ppp.Current_Health_Analysis_img);

			Assert.assertTrue(ImagePresent, "Current Health Analysis image isn't displayed.");
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("PPP Current Health Analysis image didn't load on time.");
		}

	}

	// Verification on the Personalized Health Advice tab of the PPP.
	public void verifyDataOn_PersonalisedHealthAdvice_TabOnPPP() {

		common.implictWait(60);
		ppp.Personal_Health_Advice_link.click();
		common.explictWaitClickable(10, ppp.Personal_Health_Advice_img);
		try {
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					ppp.Personal_Health_Advice_img);

			Assert.assertTrue(ImagePresent, "Personalised Health Advice image isn't displayed.");
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("PPP Personalised Health Advice image didn't load on time.");
		}

	}

	// Verification on the Screening Schedule tab of the PPP.
	public void verifyDataOn_ScreeningSchedule_TabOnPPP() {
		common.implictWait(60);
		ppp.Screening_Schedule_link.click();
		List<WebElement> elle = ppp.Screening_Schedule_Suggested_Tests_text;

		common.explictWaitClickable(10, ppp.Screening_Schedule_img);

		try {
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					ppp.Screening_Schedule_img);

			Assert.assertTrue(ImagePresent, "Screening Schedule image isn't displayed.");
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("PPP Screening Schedule image didn't load on time.");
		}

		for (int i = 0; i < 3; i++) {
			Assert.assertTrue(elle.get(i).getText().equals(common.readExcel("ppp", "Suggested Test " + (i + 1) + "")),
					elle.get(i).getText() + " is not matching");
		}

		Assert.assertTrue(ppp.Screening_Schedule_Colonoscopy_Next_Date_text.getText()
				.equals(common.readExcel("ppp", "Colonoscopy Next Date")), "Colonoscopy next date is not matching.");
		Assert.assertTrue(ppp.Screening_Schedule_Diabetes_Next_Date_text.getText()
				.equals(common.readExcel("ppp", "Diabetes Next Date")), "Diabetes next date is not matching.");
	}

	// Verification on the Community Based Resources tab of the PPP.
	public void verifyDataOn_CommunityBasedResources_TabOnPPP() {
		common.implictWait(60);
		ppp.Community_Based_Resources_link.click();

		common.explictWaitClickable(10, ppp.Community_Based_Resources_img);
		try {
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					ppp.Community_Based_Resources_img);

			Assert.assertTrue(ImagePresent, "Community Based Resources image isn't displayed.");
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("PPP Community Based Resources image didn't load on time.");
		}

	}

	// Verification of the PPP report of the PPP.
	public void verifyPPP_Report_TabOnPPP() throws InterruptedException, AWTException {
		common.implictWait(60);
		ppp.PPP_Print_btn.click();
		Thread.sleep(20000);

		Set<String> handles = driver.getWindowHandles();
		String win1 = driver.getWindowHandle();
		handles.remove(win1);
		String win2 = handles.iterator().next();
		driver.switchTo().window(win2);

		Assert.assertTrue(ppp.PPP_Report_Header_text.getText().equals(common.readExcel("ppp", "PPP Report Header")),
				"PPP Report's header is not matching");
		Assert.assertTrue(
				ppp.PPP_Report_PatientName_text.getText().equals(common.readExcel("ppp", "Introduction Name")),
				"PPP Report's header is not matching");

		common.keyboard_Ctrl_S(driver);
		driver.close();
		driver.switchTo().window(win1);
	}

}
