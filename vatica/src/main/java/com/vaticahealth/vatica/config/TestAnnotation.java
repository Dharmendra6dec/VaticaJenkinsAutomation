package com.vaticahealth.vatica.config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.vaticahealth.vatica.pages.CreateHRA;
import com.vaticahealth.vatica.pages.Diagnosis;
import com.vaticahealth.vatica.pages.PHP;
import com.vaticahealth.vatica.pages.PPP;
import com.vaticahealth.vatica.pages.Tests;
import com.vaticahealth.vatica.pages.TrainingResources;
//import com.vaticahealth.vatica.testcases.HraTest;
//import com.vaticahealth.vatica.testcases.LoginTest;
//import com.vaticahealth.vatica.testcases.PHPTest;
import com.vaticahealth.vatica.pages.Hra;
import com.vaticahealth.vatica.pages.Login;
import com.vaticahealth.vatica.utils.CommonCode;

public class TestAnnotation {

	public static WebDriver driver = Configuration.browser();
	public CommonCode common = new CommonCode();
		
	protected Login login = new Login();
	protected PHP home = new PHP();
	protected CreateHRA createHra = new CreateHRA();
	protected Tests test = new Tests();
	protected Hra hra = new Hra();
	protected Diagnosis diag = new Diagnosis();
	protected PPP ppp = new PPP();
	protected TrainingResources train = new TrainingResources();
	

	public String logIdSupp = common.readExcel("get_values", "loginId");
	public String logPassowrdSupp = common.readExcel("get_values", "loginPassword");
	public String logInvalidPasswordSupp = common.readExcel("get_values", "invalidPassword");
	public String websiteSelectionSupp = common.readExcel("get_values", "webSiteSelection");
	protected int intff = Integer.parseInt(websiteSelectionSupp);

	@BeforeTest
	public void invokeUrl() {

		driver.get(Configuration.invokeUrl());
	//	driver.manage().window().maximize();

	}
	/*
	 * @AfterSuite public void closeDriver() { driver.close(); }
	 */

}
