package com.vaticahealth.vatica.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import com.vaticahealth.vatica.config.TestAnnotation;
import com.vaticahealth.vatica.pages.Hra;
import com.vaticahealth.vatica.utils.CommonCode;

public class HraTest extends TestAnnotation {

	CommonCode common = new CommonCode();
	String DateOfVisitCreated = common.recentDate();
	String NewFirstname = common.firstNameGenerator();
	String NewLastname = common.LastNameGenerator();
	String NewVisitdate = common.recentDate();

	// Completing the HRA by filling information in Background Information with
	// necessary info
	public void tc_Hra_Bi_1() throws InterruptedException {

		common.implictWait(10);
		Thread.sleep(5000);
		hra.BackgroundInformationLink.click();
		common.selectByValue(hra.Gender, Integer.parseInt(common.readExcel("hra", "Gender")));
		hra.AspirinYes.click();
		hra.HighBloodPressureMedYes.click();
		hra.CreateHra_AddMedicine_Btn.click();
		hra.AddMedicine_Name.sendKeys(common.readExcel("hra", "Medicine to add"));
		hra.AddMedicineDose.sendKeys(common.readExcel("hra", "Medicine dose"));
		common.selectByValue(hra.AddMedicineUnit, Integer.parseInt(common.readExcel("hra", "Medicine Unit")));
		common.selectByValue(hra.AddMedicineFrequency, Integer.parseInt(common.readExcel("hra", "Medicine Frequency")));
		hra.AddMedicineFrequency.sendKeys(Keys.TAB);

	}

	// Filling the Pre-Visit Work List information in the HRA
	public void tc_Hra_Pwl_1() throws InterruptedException {

		common.implictWait(10);
		hra.PreVisitWorkListLink.click();
		Thread.sleep(5000);
		hra.FluShotYes.click();
		hra.FluDate.sendKeys(common.recentDate());
		hra.HemoglobinA1cYes.click();
		hra.HemoglobinA1cDate.sendKeys(common.readExcel("hra", "Last Test Date"));
		hra.HemoglobinA1cValue.sendKeys(common.readExcel("hra", "Hemoglobin"));
		hra.PsaYes.click();
		hra.PsaDate.sendKeys(common.readExcel("hra", "Last Test Date"));
		hra.GlomerulerYes.click();
		hra.GlomerulerDate.sendKeys(common.readExcel("hra", "Last Test Date"));
		hra.GlomerulerTextBox.sendKeys(common.readExcel("hra", "Glomeruler"));
		// hra.AddMedicineFrequency.sendKeys(Keys.TAB);
		Thread.sleep(3000);

	}

	// Filling the Social History information in the HRA
	public void tc_Hra_Sh_1() throws InterruptedException {

		common.implictWait(10);
		hra.SocialHistoryLink.click();
		Thread.sleep(5000);
		hra.IllegalDrugsYes.click();
		hra.Cocaine.click();
		hra.DependencyCurrent.click();
		hra.DrugComplications.click();
		hra.AlcoholDependency.click();
		hra.AlcoholComplications.click();
		Thread.sleep(3000);

	}

	// Filling the Family History information in the HRA
	public void tc_Hra_fh_1() throws InterruptedException {

		common.implictWait(10);
		hra.FamilyHistoryLink.click();
		Thread.sleep(5000);
		hra.ColonYes.click();
		hra.StrokeYes.click();
		Thread.sleep(3000);

	}

	// Filling the Medical Conditions information in the HRA
	public void tc_Hra_MedicalConditions_1() throws InterruptedException {

		common.implictWait(20);
		hra.MedicalConditionsLink.click();
		Thread.sleep(15000);
		hra.Glaucoma.click();
		hra.GlaucomaPre.click();
		hra.HHD.click();
		hra.HHDWithHearthDisease.click();
		Thread.sleep(3000);

	}

	// Filling the Review of Symptoms information in the HRA
	public void tc_Hra_ROS_1() throws InterruptedException {

		common.implictWait(10);
		hra.ReviewOfSymptomsLink.click();
		Thread.sleep(5000);
		hra.Hra_ReviewOfSymptomsAllNo_Button.click();
		Thread.sleep(3000);

	}

	// Filling the Self Assessment information in the HRA
	public void tc_Hra_SelfAssessment_1() throws InterruptedException {

		common.implictWait(10);
		hra.SelfAssessmentLink.click();
		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//button[text()='Close']")).isDisplayed()) {
				driver.findElement(By.xpath("//button[text()='Close']")).click();
			}
		} catch (Exception e) {
			System.out.println("Everything is executing correctly.");
		}
		hra.FairHealth.click();
		hra.LittleDifficultyInWalking.click();
		Thread.sleep(3000);

	}

	// Filling the Fall Risk information in the HRA
	public void tc_Hra_FallRisk_1() throws InterruptedException {

		common.implictWait(10);
		hra.FallRiskLink.click();
		Thread.sleep(5000);
		hra.Hra_FallRiskAllNo_Btn.click();
		Thread.sleep(3000);

	}

	// Filling the Biometrics information in the HRA
	public void tc_Hra_Biometrics_1() throws InterruptedException {

		common.implictWait(10);
		hra.BiometricsLink.click();
		Thread.sleep(5000);
		hra.VisitDateBio.sendKeys(DateOfVisitCreated);
		// common.writeExcel("DOV", date, "hra");
		hra.VisitDateBio.sendKeys(Keys.TAB);
		Thread.sleep(3000);

	}

	// Filling the Cognitive Assessment information in the HRA
	public void tc_Hra_CognitiveAssessment_1() throws InterruptedException {

		common.implictWait(10);
		hra.CognitiveAssessmentLink.click();
		Thread.sleep(5000);
		hra.NumberOfItems2.click();
		hra.ClockDrawingTestNormal.click();
		Thread.sleep(10000);
		// hra.Save_NextBtn.click();

	}

	// Click on the 'T' button on the HRA page
	public void tTabClick() throws InterruptedException {
		common.implictWait(10);
		Thread.sleep(3000);
		hra.TestsTab.click();
	}

	// Click on the 'D' button on the HRA page
	public void dTabClick() throws InterruptedException {
		common.implictWait(10);
		Thread.sleep(3000);
		hra.DiagnosticsTab.click();
	}

	// Update the HRA's firstname, lastname, DOB and visit date
	public void upgradeHRA() throws InterruptedException {
		hra.updateBackgroundInfo();
		hra.updateVisitDate();
	}

}
