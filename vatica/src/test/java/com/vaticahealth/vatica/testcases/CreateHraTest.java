package com.vaticahealth.vatica.testcases;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.vaticahealth.vatica.config.TestAnnotation;
import com.vaticahealth.vatica.utils.CommonCode;

public class CreateHraTest extends TestAnnotation{
	CommonCode common = new CommonCode();
	
		String MedicareNumberCreated = common.tenDigitNumberGenerator();
		String FirstNameCreated = common.firstNameGenerator();
		String LastNameCreated = 	common.LastNameGenerator();	
		String DOBCreated = common.readExcel("hra", "DOB");

	// Creating a Hra and filling the necessary information till HRA page
	public void tc_CreateHra_1 () throws InterruptedException {
		
		common.implictWait(10);
		Thread.sleep(15000);
		
		
		createHra.fillMedicareNumber(MedicareNumberCreated);;
		createHra.fillFirstName(FirstNameCreated);
		createHra.fillLastName(LastNameCreated);
		createHra.fillDOB(DOBCreated);
		common.pressTab(createHra.DOB);
		createHra.clickNextButton();
		
		
		// Click on confirm button and confirming details (first, last name, DOB and Medicare number)
		Thread.sleep(5000);
		Assert.assertTrue(FirstNameCreated.equalsIgnoreCase(createHra.FirstNameValue.getText().toString()), "First Name is different");
		Assert.assertTrue(LastNameCreated.equalsIgnoreCase(createHra.LastNameValue.getText().toString()), "Last Name is different");
		Assert.assertTrue(MedicareNumberCreated.equalsIgnoreCase(createHra.MedicareValue.getText().toString()), "Medicare number is different");
		Assert.assertTrue(DOBCreated.equalsIgnoreCase(createHra.DobValue.getText().toString()), "DOB is different");
		
	//	createHra.selectByValue(createHra.ConfirmPatientInsurance, Integer.parseInt(common.readExcel("hra", "Insurance")));
		common.selectByValue(createHra.ConfirmPatientInsurance, Integer.parseInt(common.readExcel("hra", "Insurance")));
		common.pressTab(createHra.ConfirmPatientInsurance);
		createHra.clickConfirmPatientButton();
		Thread.sleep(5000);
		createHra.clickConfirmNewHraButton();
		Thread.sleep(15000);
	}

}
