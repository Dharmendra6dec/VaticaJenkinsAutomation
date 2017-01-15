package com.vaticahealth.vatica.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

//import com.sun.jna.platform.win32.OaIdl.ELEMDESC;
import com.vaticahealth.vatica.config.Configuration;
import com.vaticahealth.vatica.utils.CommonCode;
import com.vaticahealth.vatica.utils.Elements;
import com.vaticahealth.vatica.utils.Button;

public class CreateHRA {
	WebDriver driver = Configuration.driver;
	CommonCode common = new CommonCode();
	@SuppressWarnings("unused")
	private String FirstNameCreated;

	@FindBy(xpath = Elements.MEDICARENUMBER_CV)
	public WebElement MedicareNumber;

	@FindBy(xpath = Elements.FIRSTNAME_CV)
	public WebElement FirstName;

	@FindBy(xpath = Elements.LASTNAME_CV)
	public WebElement LastName;

	@FindBy(xpath = Elements.DOB_CV)
	public WebElement DOB;

	@FindBy(xpath = Button.CreateHra_Next_Btn)
	public WebElement CreateHra_Next_Btn;

	@FindBy(xpath = Elements.CONFIRMPATIENTINSUREANCE)
	public WebElement ConfirmPatientInsurance;

	@FindBy(xpath = Button.CreateHra_ConfirmPatient_Btn)
	public WebElement ConfirmPatientBtn;

	@FindBy(xpath = Button.CreateHra_ConfirmHra_Btn)
	public WebElement CreateHra_ConfirmHra_Btn;

	@FindBy(xpath = Elements.FIRSTNAMEVALUE)
	public WebElement FirstNameValue;

	@FindBy(xpath = Elements.LASTNAMEVALUE)
	public WebElement LastNameValue;

	@FindBy(xpath = Elements.DOBVALUE)
	public WebElement DobValue;

	@FindBy(xpath = Elements.MEDICAREVALUE)
	public WebElement MedicareValue;

	public CreateHRA() {
		PageFactory.initElements(driver, this);
	}

	/*public void selectByValue(WebElement elle, int sel) throws InterruptedException {
		common.implictWait(10);
		Thread.sleep(5000);
		Select select = new Select(elle);
		select.selectByIndex(sel);

	}*/
	
	public void fillMedicareNumber(String a) {
		MedicareNumber.sendKeys(a);
	}
	
	public void fillFirstName(String b) {
		FirstName.sendKeys(b);
	}
	
	public void fillLastName(String c) {
		LastName.sendKeys(c);
	}
	
	public void fillDOB(String d) {
		DOB.sendKeys(d);
	}
	
	public void clickConfirmPatientButton() {
		ConfirmPatientBtn.click();
	}
	
	public void clickConfirmNewHraButton() {
		CreateHra_ConfirmHra_Btn.click();
	}

	public void clickNextButton() {
		CreateHra_Next_Btn.click();
	}
	
	
}
