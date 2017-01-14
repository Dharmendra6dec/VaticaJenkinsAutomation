package com.vaticahealth.vatica.testcases;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vaticahealth.vatica.config.TestAnnotation;
import com.vaticahealth.vatica.pages.Hra;
import com.vaticahealth.vatica.pages.PHP;
import com.vaticahealth.vatica.utils.CommonCode;
import com.vaticahealth.vatica.utils.Elements;

public class PHPTest extends TestAnnotation {

	CommonCode common = new CommonCode();
	PHP php = new PHP();

	// Check the presence of Vatica Logo
	public void logoCheck() throws Exception {
		Thread.sleep(5000);
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				home.VaticaLogo);

		Assert.assertTrue(ImagePresent, "Image displayed.");

	}

	// Clicking on 'Add New Visit' from the PHP
	public void tc_PHP_1() throws InterruptedException {
		common.implictWait(10);
		Thread.sleep(10000);
		home.clickAddNewVisitButton();

	}

	// Site check on PHP after logging in.
	public void siteCheck() throws InterruptedException {

		Thread.sleep(2000);
		String actualSite = home.siteOnPhp();
		String expectedSite = common.readExcel("get_values", "site");
		Assert.assertTrue(expectedSite.equals(actualSite), "Site check failed");

	}

	// Selection of Different sites and their confirmation
	public void differentSiteSelection() throws InterruptedException {
		Thread.sleep(2000);
		ArrayList<String> expectedSiteOptions = home.expectedSiteOptions();
		for (int i = 0; i < 8; i++) {
			home.clickSettings();
			Actions action = new Actions(driver);
			action.moveToElement(home.SettingsChangeSite).perform();
			String site = Elements.SETTINGSSITEOPTIONS;
			String site2 = Elements.SETTINGSSITEOPTIONS2;
			if (i == 0) {
				Thread.sleep(2000);
				System.out.println(site + "/li[" + (i + 1) + "]/a");
				driver.findElement(By.xpath(site + "/li[" + (i + 1) + "]/a")).click();
			} else {
				Thread.sleep(2000);
				driver.findElement(By.xpath(site2 + "/li[" + (i + 1) + "]/a")).click();
			}

			Thread.sleep(7000);
			String actualSite = home.siteOnPhp();
			System.out.println("ok" + expectedSiteOptions.get(i) + "ok");
			System.out.println("ok" + actualSite + "ok");
			Assert.assertTrue(expectedSiteOptions.get(i).equals(actualSite), actualSite + "  - site did not match.");

		}

		// Switching to Demo Hospital 1 (Plus) for further testing
		home.clickSettings();
		Actions action2 = new Actions(driver);
		action2.moveToElement(home.SettingsChangeSite).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Demo Hospital 1']")).click();
		Thread.sleep(7000);
	}

	// Columns check on PHP grid
	public void columnsOnGridCheck() throws InterruptedException {

		Thread.sleep(2000);
		java.util.List<WebElement> listOfColumns = home.getColumnsOnGrid();
		ArrayList<String> expectColumnsOnGrid = home.getColumnLabelsOnPHP();

		for (int i = 0; i < listOfColumns.size(); i++) {

			Assert.assertTrue(
					expectColumnsOnGrid.get(i).toString().equalsIgnoreCase((listOfColumns.get(i).getText().toString())),
					expectColumnsOnGrid.get(i).toString() + " - column is not a match");

			Thread.sleep(2000);
		}
	}

	// Login confirmation
	public void loginConf() throws InterruptedException {

		Thread.sleep(3000);
		String expectedWelcomeMessage = common.readExcel("hra", "welcomeMessage");
		String actualWelcomeMessage = home.welcomeMsg.getText().toString();
		Assert.assertTrue(actualWelcomeMessage.equalsIgnoreCase(expectedWelcomeMessage), "Login Unsuccessful");
	}

	// Logout and it's confirmation
	public void logout() throws InterruptedException {
		common.implictWait(10);
		home.logOut();
		Thread.sleep(7000);
		if (home.loginBtn.isDisplayed() == true)
			System.out.println("Logout Successful");
		else

			System.out.println("Logout failed");

	}

	// Execute one complete Search and Verify the one row in the PHP grid
	public void verifyOneRowOnPhp() throws InterruptedException {

		common.implictWait(10);
		Thread.sleep(5000);
		home.clearSearchField();
		Thread.sleep(2000);
		home.firstName(common.readExcel("hra", "First Name"));
		home.lastName(common.readExcel("hra", "Last Name"));
		home.dobText(common.readExcel("hra", "DOB"));
		home.visitDateText(common.readExcel("hra", "DOV"));
		common.selectByValue(home.selectStatus, Integer.parseInt(common.readExcel("hra", "Visit Status")));
		home.searchButton();
		Thread.sleep(5000);

		try {

			Assert.assertTrue(home.SearchGridFirstName.getText().equals(common.readExcel("hra", "First Name")),
					"First Names don't match");
			Assert.assertTrue(home.SearchGridLastName.getText().equals(common.readExcel("hra", "Last Name")),
					"Last Names don't match");
			Assert.assertTrue(home.SearchGridDOV.getText().toString().equals(common.readExcel("hra", "DOV")),
					"DOVs don't match");
			Assert.assertTrue(home.SearchGridDOB.getText().toString().equals("DOB 04/04/1945"), "DOBs don't match");
			Assert.assertTrue(home.GridPppBtn.isDisplayed() && home.GridPppBtn.isEnabled(),
					"P button on grid is not working.");
			Assert.assertTrue(home.GridTestBtn.isDisplayed() && home.GridTestBtn.isEnabled(),
					"T button on grid is not working.");
			Assert.assertTrue(home.GridDiagnosisBtn.isDisplayed() && home.GridDiagnosisBtn.isEnabled(),
					"D  button on grid is not working.");
			Assert.assertTrue(home.GridHraBtn.isDisplayed() && home.GridHraBtn.isEnabled(),
					"HRA button on grid is not working.");
			Assert.assertTrue(home.GridSnapshotBtn.isDisplayed() && home.GridSnapshotBtn.isEnabled(),
					"HRA button on grid is not working.");
			Assert.assertTrue(home.GridCommentBtn.isDisplayed() && home.GridCommentBtn.isEnabled(),
					"HRA button on grid is not working.");
			Assert.assertTrue(home.GridPrintformsbtn.isDisplayed() && home.GridPrintformsbtn.isEnabled(),
					"HRA button on grid is not working.");
			Assert.assertTrue(home.GridMedicalRecordsBtn.isDisplayed() && home.GridMedicalRecordsBtn.isEnabled(),
					"HRA button on grid is not working.");
			Assert.assertTrue(home.GridAdminBtn.isDisplayed() && home.GridAdminBtn.isEnabled(),
					"HRA button on grid is not working.");

		} catch (java.lang.AssertionError e) {
			e.printStackTrace();
		}
		home.clearSearchField();
	}

	// To verify all the site option available from the Settings button
	public void verifySiteOptions() throws InterruptedException {

		Thread.sleep(5000);
		ArrayList<String> expectedSiteOptions = home.expectedSiteOptions();
		home.clickSettings();

		Actions action = new Actions(driver);
		action.moveToElement(home.SettingsChangeSite).perform();
		// home.SettingsChangeSite.click();
		String site = Elements.SETTINGSSITEOPTIONS;
		for (int i = 0; i < 8; i++) {
			String ActualSite = driver.findElement(By.xpath(site + "/li[" + (i + 1) + "]/a")).getText();
			Assert.assertTrue(ActualSite.equalsIgnoreCase(expectedSiteOptions.get(i)),
					ActualSite + "  - site did not match.");
		}
		home.clickChangeSettings();

	}

	// To check the Sorting of First Names on Grid on PHP
	public void checkFirstNameSortingonPHPGrid() throws Exception {
		common.implictWait(20);
		ArrayList<String> ExpectedList = home.getSortedFirstNameOnPHPfromDB();
		ArrayList<String> ActualList = home.getSortedFirstNamesFromPHPGrid();
		common.compareList(ExpectedList, ActualList);
	}

	// To check the Sorting of Last Names on Grid on PHP
	public void checkLastNameSortingonPHPGrid() throws Exception {
		common.implictWait(20);
		ArrayList<String> ExpectedList = home.getSortedLastNameOnPHPfromDB();
		ArrayList<String> ActualList = home.getSortedLastNamesFromPHPGrid();
		common.compareList(ExpectedList, ActualList);
	}

	// To check the Sorting of Visit Dates on Grid on PHP
	public void checkVisitDateSortingonPHPGrid() throws Exception {
		common.implictWait(20);
		ArrayList<String> ExpectedList = home.getSortedVisitDatesOnPHPfromDB();
		PHP.show(ExpectedList);
		ArrayList<String> ActualList = home.getSortedVisitDatesFromPHPGrid();
		PHP.show(ActualList);
		common.compareList(ExpectedList, ActualList);
	}

	// Open and HRA from Searching with Last Name
	public void openRequiredHRA() throws InterruptedException {
		home.SearchWithLastName(common.readExcel("sites", "UserToChange"));
		home.updateHra();
	}

	// Look for Updated HRA and confirm the details like DOB, Last name, First
	// name and Visit date
	public void searchNewHraAndVerifyHraDetails() throws InterruptedException {
		home.SearchWithLastName(hra.getLastName());
		Assert.assertTrue(hra.getFirstName().equals(home.firstName.getText()), "First Name is incorrect");
		Assert.assertTrue(hra.getLastName().equals(home.lastName.getText()), "Last Name is incorrect");
		Assert.assertTrue(common.readExcel("sites", "new DOB").equals(home.DOBExtractOnPHP()), "DOB is incorrect");
		Assert.assertTrue(hra.getVisitDate().equals(home.visitDate.getText()), "Visit Date is incorrect");
	}

	// Look for a specific HRA from Excel and confirm the status of hra
	public void searchNewHraAndVerifyHraStatus() throws InterruptedException {
		common.implictWait(10);
		home.SearchWithLastName(common.readExcel("hra", "Last Name"));

		System.out.println("ok" + php.VisitStatusOnGrid.getText() + "ok");
		System.out.println("ok" + common.readExcel("hra", "Visit Status2") + "ok");
		System.out.println("ok" + php.VisitTypeOnGrid.getText() + "ok");
		System.out.println("ok" + common.readExcel("hra", "Visit Type") + "ok");
		System.out.println("ok" + php.VisitSignOnGrid.getCssValue("color") + "ok");
		System.out.println("ok" + common.readExcel("hra", "Visit Sign") + "ok");

		Assert.assertTrue(php.VisitStatusOnGrid.getText().equals(common.readExcel("hra", "Visit Status2")),
				"Visit Status is not matching");
		Assert.assertTrue(php.VisitTypeOnGrid.getText().equals(common.readExcel("hra", "Visit Type")),
				"Visit Type is not matching");
		Assert.assertTrue(php.VisitSignOnGrid.getCssValue("color").equals(common.readExcel("hra", "Visit Sign")),
				"Visit Sign is not matching");
		php.clearSearchField();
	}

	// Restore the record to Old Info
	public void restoreRecord() throws InterruptedException {
		common.doubleClick(driver, home.FirstHraOnGrid);
		Thread.sleep(5000);
		hra.LastName.clear();
		hra.LastName("DOE46387");
		hra.DOB.clear();
		hra.DOB("4 4 45");
		hra.FirstName.clear();
		hra.FirstName("John78965");
		hra.clickSaveButton();
		Thread.sleep(5000);
		hra.ErrorListClose.click();
		Thread.sleep(3000);
		hra.HomeTab.click();
	}

	public void colorcheck() {
		System.out.println(
				driver.findElement(By.xpath(".//*[contains(@id,'-grid-container')]/div[2]/div/div[1]/div/div[2]/div"))
						.getCssValue("class"));
		System.out.println("Color kaha hai?");
		System.out.println(
				driver.findElement(By.xpath(".//*[contains(@id,'-grid-container')]/div[2]/div/div[2]/div/div[2]/div"))
						.getCssValue("class"));

	}

	// Click for PDF report and download it to verify
	public void tc_php_pdf_Report() throws InterruptedException, AWTException {
		Thread.sleep(5000);

		home.Php_PrintFirstReport_Btn.click();
		common.explictWaitPresence(5, By.xpath(Elements.SELECTREPORT));
		common.selectByValue(home.selectReport, 0);
		home.Php_ExportData_Btn.click();
		Thread.sleep(20000);
		home.Php_Done_Btn.click();
		Thread.sleep(5000);

		Set<String> handles = driver.getWindowHandles();
		String win1 = driver.getWindowHandle();
		handles.remove(win1);
		String win2 = handles.iterator().next();
		driver.switchTo().window(win2);
		common.keyboard_Ctrl_S(driver);
		driver.close();
		driver.switchTo().window(win1);

	}
}
