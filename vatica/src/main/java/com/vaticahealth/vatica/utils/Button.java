package com.vaticahealth.vatica.utils;

public class Button {	
	
	// Login Page	
	public static final String Login_Login_Btn = "//button[@id='btn-login']";
	public static final String Login_Reset_Btn="//button[@id='btn-reset-password']";
	public static final String Login_OK_Btn="//button[text()='OK']";
	public static final String Login_SelectWebsite_Btn="//button[text()='Select']";
	public static final String Login_SubmitRequest_Btn="//div[@class='modal-footer clearfix']//button[2]";
	public static final String Login_PrivacyPolicyClose_Btn="//button[@class='close']";
	
	// Hra Page
	public static final String Hra_WARNINGCLOSE_Btn = "//button[@class='btn btn-default ng-binding' and text()='Close']";
	public static final String Hra_SaveNext_Btn = "//*[text()='Save/Next']";
	
	//HRA page - Review of Symptoms(ROS)
	public static final String Hra_ReviewOfSymptomsAllNo_Button = "//button[contains(@ng-click,'Symptoms')]";
	
	//HRA page - Fall Risk
	public static final String Hra_FallRiskAllNo_Btn = "//button[contains(@ng-click,'Fall Risk')]";
	
	//Create Hra
	public static final String CreateHra_ConfirmHra_Btn = "//button[@class='btn btn-primary btn-sm' and text()='Confirm']";
	public static final String CreateHra_Next_Btn = "//input[@type='button' and @value='Next']";
	public static final String CreateHra_ConfirmPatient_Btn="//button[text()='Confirm Patient']";
	public static final String CreateHra_AddMedicine_Btn = "//a[@class='btn ng-binding' and @ng-click='addMedication()']";
	
	//ESign
	public static final String ESign_ESign_Btn = "//*[@id='mdSigning']/div/div/div[3]/button";
	public static final String ESign_SuccessOk_Btn = "//button[text()='OK' and @ng-click='close()']";
	
	//Meat 
	public static final String Meat_SaveChanges_Btn = "//*[text()='Save Changes']";
	
	//Diagnosis
	public static final String Diagnosis_SaveNext_Btn = "//*[text()='Save/Next']";
	
	// Diagnosis Accept page
	public static final String  Diagnosis_AcceptNext_Btn = "//*[text()='Next']";
	
	// Diagnosis Reject page
	public static final String Diagnosis_ConfirmReject_Btn = "//button[text()='Confirm Reject']";
	
	// Diagnosis Code Sheet
	public static final String Diagnosis_Disease1Accept_Btn = "//li[1][@class='ng-scope' and @ng-hide='dx.ConflictGroup']/div/div/div[2]/button[1]";
	public static final String Diagnosis_Disease2Accept_Btn = "//li[2][@class='ng-scope' and @ng-hide='dx.ConflictGroup']/div/div/div[2]/button[1]";
	public static final String Diagnosis_Disease3Accept_Btn = "//li[3][@class='ng-scope' and @ng-hide='dx.ConflictGroup']/div/div/div[2]/button[1]";
	public static final String Diagnosis_Disease4Reject_Btn = "//li[4][@class='ng-scope' and @ng-hide='dx.ConflictGroup']/div/div/div[2]/button[2]";
	public static final String Diagnosis_Disease5Reject_Btn = "//li[5][@class='ng-scope' and @ng-hide='dx.ConflictGroup']/div/div/div[2]/button[2]";
	public static final String Diagnosis_Disease6Reject_Btn = "//li[6][@class='ng-scope' and @ng-hide='dx.ConflictGroup']/div/div/div[2]/button[2]";
	
	//PPP Screen
	public static final String PPP_Print_btn = "//a[text()='Print']";
	
	//Test Screen
	public static final String Tests_AddTest_Btn = "//input[@id='btnSelectAdditionalTests']";
	
	//PHP Screen
	public static final String Php_Search_Btn="//button[@id='searchButton']";
	public static final String Php_Clear_Btn="//button[@id='clearButton']";
	public static final String Php_LastPage_Btn="//button[@class='ui-grid-pager-last']";
	public static final String Php_TraverseMonthYear_Btn="//button[@role='heading']";
	public static final String Php_FirstPage_Btn="//button[@class='ui-grid-pager-first']";
	public static final String Php_PrintFirstReport_Btn="//div[@class='ui-grid-contents-wrapper']/div[1]/div[2]/div/div[1]/div/div[5]/div/a[8]/i";
	public static final String Php_ExportData_Btn="//div[@id='mdExport']/div/div/div[3]/a";
	public static final String Php_Done_Btn="//div[@id='mdExport']/div/div/div[3]/button";
	public static final String Php_Settings_Btn="//*[@role='button'][@data-toggle='dropdown']";
	public static final String Php_PageToFirst_Btn = "//button[@title='Page to first']";
	public static final String Php_NextOnGrid_Btn="//button[@class='ui-grid-pager-next']";
	
	

}
