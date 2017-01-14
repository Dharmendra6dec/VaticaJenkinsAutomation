package com.vaticahealth.vatica.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vaticahealth.vatica.config.Configuration;
import com.vaticahealth.vatica.utils.Elements;

public class TrainingResources {
	WebDriver driver = Configuration.driver;

		
	@FindBy(xpath=Elements.TR_Training_Tools_text)
	public WebElement TR_Training_Tools_text;
	
	@FindBy(xpath=Elements.TR_FAQ_Link_link)
	public WebElement TR_FAQ_Link_link;

	@FindBy(xpath=Elements.TR_HRA_HardCopy_Link)
	public WebElement TR_HRA_HardCopy_Lin;

	@FindBy(xpath=Elements.TR_Patient_Questionaire_Link)
	public WebElement TR_Patient_Questionaire_Link;

	@FindBy(xpath=Elements.TR_Flyer1_Link)
	public WebElement TR_Flyer1_Link;

	@FindBy(xpath=Elements.TR_Flyer2_Link)
	public WebElement TR_Flyer2_Link;

	@FindBy(xpath=Elements.TR_UserManual_Link)
	public WebElement TR_UserManual_Link;

	@FindBy(xpath=Elements.TR_TechTips_Guide_Link)
	public WebElement TR_TechTips_Guide_Link;

	@FindBy(xpath=Elements.TR_QUickTips_Guide_Link)
	public WebElement TR_QUickTips_Guide_Link;

	@FindBy(xpath=Elements.TR_Release_Notes_Link)
	public WebElement TR_Release_Notes_Link;

	@FindBy(xpath=Elements.TR_FAQ_ExpectedText)
	public WebElement TR_FAQ_ExpectedText;
	
	
	
	
	public TrainingResources () {
		PageFactory.initElements(driver, this);
	}
	
}
