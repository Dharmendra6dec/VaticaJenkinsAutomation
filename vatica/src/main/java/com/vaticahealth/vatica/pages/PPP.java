package com.vaticahealth.vatica.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sun.jna.platform.win32.OaIdl.ELEMDESC;
import com.vaticahealth.vatica.config.Configuration;
import com.vaticahealth.vatica.utils.CommonCode;
import com.vaticahealth.vatica.utils.Elements;
import com.vaticahealth.vatica.utils.Button;

public class PPP {

	WebDriver driver = Configuration.driver;
	CommonCode common = new CommonCode();

	@FindBy(xpath= Elements.PPP_Header_text)
	public WebElement PPP_Header_text;
	
	@FindBy(xpath = Button.PPP_Print_btn)
	public WebElement PPP_Print_btn;
	
	@FindBy(xpath = Elements.Introduction_link)
	public WebElement Introduction_link;
	
	@FindBy(xpath = Elements.Introduction_Header_img)
	public WebElement Introduction_Header_img;
	
	@FindBy(xpath = Elements.Patient_Name_On_Introduction_text)
	public WebElement Patient_Name_On_Introduction_text;

	@FindBy(xpath = Elements.Current_Health_Analysis_link)
	public WebElement Current_Health_Analysis_link;

	@FindBy(xpath = Elements.Personal_Health_Advice_link)
	public WebElement Personal_Health_Advice_link;

	@FindBy(xpath = Elements.Screening_Schedule_link)
	public WebElement Screening_Schedule_link;

	@FindBy(xpath = Elements.Community_Based_Resources_link)
	public WebElement Community_Based_Resources_link;

	@FindBy(xpath = Elements.Summary_Of_Test_Key_text)
	public List<WebElement> Summary_Of_Test_Key_text;
	
	@FindBy(xpath = Elements.Summary_Of_Test_Value_text)
	public List<WebElement> Summary_Of_Test_Value_text;
	
	@FindBy(xpath= Elements.Current_Health_Analysis_img)
	public WebElement Current_Health_Analysis_img;
	
	@FindBy(xpath= Elements.Personal_Health_Advice_img)
	public WebElement Personal_Health_Advice_img;
	
	@FindBy(xpath = Elements.Screening_Schedule_img)
	public WebElement Screening_Schedule_img;
	
	@FindBy(xpath= Elements.Community_Based_Resources_img)
	public WebElement Community_Based_Resources_img;
	
	@FindBy(xpath=Elements.PPP_Report_Header_text)
	public WebElement PPP_Report_Header_text;
	
	@FindBy(xpath=Elements.PPP_Report_PatientName_text)
	public WebElement PPP_Report_PatientName_text;
	
	@FindBy(xpath=Elements.Screening_Schedule_Suggested_Tests_text)
	public List<WebElement> Screening_Schedule_Suggested_Tests_text;
	
	@FindBy(xpath=Elements.Screening_Schedule_Colonoscopy_Next_Date_text)
	public WebElement Screening_Schedule_Colonoscopy_Next_Date_text;
	
	@FindBy(xpath=Elements.Screening_Schedule_Diabetes_Next_Date_text )
	public WebElement  Screening_Schedule_Diabetes_Next_Date_text ;
	
	
	public PPP() {
		PageFactory.initElements(driver, this);
	}
	
	

}
