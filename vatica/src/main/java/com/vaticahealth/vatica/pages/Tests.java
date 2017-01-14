package com.vaticahealth.vatica.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vaticahealth.vatica.config.Configuration;
import com.vaticahealth.vatica.utils.CommonCode;
import com.vaticahealth.vatica.utils.Elements;
import com.vaticahealth.vatica.utils.Button;

public class Tests {
	CommonCode common = new CommonCode();
	WebDriver driver = Configuration.driver;

	@FindBy(xpath = Elements.AWVRADIOBUTTON)
	public WebElement AwvRadioButton;

	@FindBy(xpath = Elements.IPPERADIOBUTTON)
	public WebElement IppeRadioButton;
	
	@FindBy(xpath = Elements.LIPIDPROFILETESTREJECT)
	public WebElement LipidProfileTestReject;
	
	@FindBy(xpath = Elements.HGBA1CTESTREJECT)
	public WebElement Hgb1acTestReject;

	@FindBy(xpath = Elements.PREVENTIVESERVSELECTALL)
	public WebElement PreventiveServiceSelectAll;

	@FindBy(xpath = Elements.OTHERCLINICALTEST)
	public WebElement OtherClinicalTestSelectAll;

	@FindBy(xpath = Elements.REJECTEDTAB)
	public WebElement RejectTab;

	@FindBy(xpath = Button.Tests_AddTest_Btn)
	public WebElement Tests_AddTest_Btn;

	@FindBy(xpath = Elements.VITAMINDTEST)
	public WebElement VitaminDTest;

	@FindBy(xpath = Elements.ADDSELECTEDTEST)
	public WebElement AddSelectedTest;


	public Tests() {
		PageFactory.initElements(driver, this);
	}
}