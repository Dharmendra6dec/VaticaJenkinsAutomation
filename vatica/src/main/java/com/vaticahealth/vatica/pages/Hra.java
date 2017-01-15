package com.vaticahealth.vatica.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import com.vaticahealth.vatica.config.Configuration;
import com.vaticahealth.vatica.utils.CommonCode;
import com.vaticahealth.vatica.utils.Elements;
import com.vaticahealth.vatica.utils.Button;

public class Hra {

	static CommonCode common = new CommonCode();
	WebDriver driver = Configuration.driver;
	String DateOfVisitCreated = common.recentDate();
	static String NewFirstname = common.firstNameGenerator();
	static String NewLastname = common.LastNameGenerator();
	static String NewVisitdate = common.recentDate();

	// Tabs

	@FindBy(xpath = Elements.HOMETAB)
	public WebElement HomeTab;

	@FindBy(xpath = "//*[@id='dlErrorList']/div/div/div[1]/button")
	public WebElement ErrorListClose;

	@FindBy(xpath = Elements.HRATAB)
	public WebElement HraTab;

	@FindBy(xpath = Elements.TESTSTAB)
	public WebElement TestsTab;

	@FindBy(xpath = Elements.DIAGNOSTICSTAB)
	public WebElement DiagnosticsTab;

	@FindBy(xpath = Elements.SNAPSHOTTAB)
	public WebElement SnapshotTab;

	@FindBy(xpath = Elements.COMMENTSTAB)
	public WebElement CommentsTab;

	@FindBy(xpath = Elements.BACKGROUNDINFOLINK)
	public WebElement BackgroundInformationLink;

	@FindBy(xpath = Elements.PREVISITWORKLISTLINK)
	public WebElement PreVisitWorkListLink;

	@FindBy(xpath = Elements.SOCIALHISTORYLINK)
	public WebElement SocialHistoryLink;

	@FindBy(xpath = Elements.FAMILYHISTORYLINK)
	public WebElement FamilyHistoryLink;

	@FindBy(xpath = Elements.MEDICALCONDITIONSLINK)
	public WebElement MedicalConditionsLink;

	@FindBy(xpath = Elements.REVIEWOFSYMTOMSLINK)
	public WebElement ReviewOfSymptomsLink;

	@FindBy(xpath = Elements.SELFASSESSLINK)
	public WebElement SelfAssessmentLink;

	@FindBy(xpath = Elements.FALLRISKLINK)
	public WebElement FallRiskLink;

	@FindBy(xpath = Elements.BIOMETRICSLINK)
	public WebElement BiometricsLink;

	@FindBy(xpath = Elements.COGNITIVEASSESSLINK)
	public WebElement CognitiveAssessmentLink;

	// Background Information Page

	@FindBy(xpath = Elements.MEDICARENUMBER)
	public WebElement MedicareNumber;

	@FindBy(xpath = Elements.FIRSTNAME_BI)
	public WebElement FirstName;

	@FindBy(xpath = Elements.LASTNAME_BI)
	public WebElement LastName;

	@FindBy(xpath = Elements.MEDICALRECORDNUMBER)
	public WebElement MedicalRecordNumber;

	@FindBy(xpath = Elements.GENDER)
	public WebElement Gender;

	@FindBy(xpath = Elements.DOB_BI)
	public WebElement DOB;

	@FindBy(xpath = Elements.ASPIRINYES)
	public WebElement AspirinYes;

	@FindBy(xpath = Elements.HIGHBLOODPRESSUREMEDYES)
	public WebElement HighBloodPressureMedYes;

	@FindBy(xpath = Button.CreateHra_AddMedicine_Btn)
	public WebElement CreateHra_AddMedicine_Btn;

	@FindBy(xpath = Elements.ADDMEDICINENAME)
	public WebElement AddMedicine_Name;

	@FindBy(xpath = Elements.ADDMEDICINEDOSE)
	public WebElement AddMedicineDose;

	@FindBy(xpath = Elements.ADDMEDICINEUNIT)
	public WebElement AddMedicineUnit;

	@FindBy(xpath = Elements.ADDMEDICINEFREQUENCY)
	public WebElement AddMedicineFrequency;

	// Pre-Visit Work List Page

	@FindBy(xpath = Elements.FLUSHOTYES)
	public WebElement FluShotYes;

	@FindBy(xpath = Elements.FLUDATE)
	public WebElement FluDate;

	@FindBy(xpath = Elements.HEMOGLOBINA1CYES)
	public WebElement HemoglobinA1cYes;

	@FindBy(xpath = Elements.HEMOGLOBINA1CDATE)
	public WebElement HemoglobinA1cDate;

	@FindBy(xpath = Elements.HEMOGLOBINA1CVALUE)
	public WebElement HemoglobinA1cValue;

	@FindBy(xpath = Elements.PSAYES)
	public WebElement PsaYes;

	@FindBy(xpath = Elements.PSADATE)
	public WebElement PsaDate;

	@FindBy(xpath = Elements.GLOMERULERYES)
	public WebElement GlomerulerYes;

	@FindBy(xpath = Elements.GLOMERULERDATE)
	public WebElement GlomerulerDate;

	@FindBy(xpath = Elements.GLOMERULERTEXTBOX)
	public WebElement GlomerulerTextBox;

	// Social History Page

	@FindBy(xpath = Elements.ILLEGALDRUGUSEYES)
	public WebElement IllegalDrugsYes;

	@FindBy(xpath = Elements.COCAINE)
	public WebElement Cocaine;

	@FindBy(xpath = Elements.DEPENDENCYCURRENT)
	public WebElement DependencyCurrent;

	@FindBy(xpath = Elements.DRUGCOMPLICATIONS)
	public WebElement DrugComplications;

	@FindBy(xpath = Elements.ALCOHOLDEPENDENCYCURRENT)
	public WebElement AlcoholDependency;

	@FindBy(xpath = Elements.ALCOHOLCOMPLICATIONS)
	public WebElement AlcoholComplications;

	// Family History Page

	@FindBy(xpath = Elements.COLONPOLYPSYES)
	public WebElement ColonYes;

	@FindBy(xpath = Elements.STROKEYES)
	public WebElement StrokeYes;

	// Medical Conditions Page

	@FindBy(xpath = Elements.GLAUCOMA)
	public WebElement Glaucoma;

	@FindBy(xpath = Elements.GLAUCOMAPRE)
	public WebElement GlaucomaPre;

	@FindBy(xpath = Elements.HHD)
	public WebElement HHD;

	@FindBy(xpath = Elements.HHDWITHHEARTDISEASE)
	public WebElement HHDWithHearthDisease;

	// Review of Symptoms(ROS) Page

	@FindBy(xpath = Button.Hra_ReviewOfSymptomsAllNo_Button)
	public WebElement Hra_ReviewOfSymptomsAllNo_Button;

	// Self-Assessment Page

	@FindBy(xpath = Elements.HEALTHFAIR)
	public WebElement FairHealth;

	@FindBy(xpath = Elements.LITTLEDIFFICULTYINWALKING)
	public WebElement LittleDifficultyInWalking;

	// Fall Risk Page

	@FindBy(xpath = Button.Hra_FallRiskAllNo_Btn)
	public WebElement Hra_FallRiskAllNo_Btn;

	// Cognitive Assessment Page

	@FindBy(xpath = Elements.NUMBEROFITEMS2)
	public WebElement NumberOfItems2;

	@FindBy(xpath = Elements.CLOCKDRAWINGTESTNORMAL)
	public WebElement ClockDrawingTestNormal;

	// Biometrics Page

	@FindBy(xpath = Elements.VISITDATEBIO)
	public WebElement VisitDateBio;

	@FindBy(xpath = Button.Hra_SaveNext_Btn)
	public WebElement Hra_SaveNext_Btn;

	@FindBy(xpath = Button.Hra_WARNINGCLOSE_Btn)
	public WebElement Hra_WARNINGCLOSE_Btn;

	public Hra() {
		PageFactory.initElements(driver, this);
	}

	public void clickSaveButton() {
		Hra_SaveNext_Btn.click();
	}

	public void FirstName(String name) {
		FirstName.sendKeys(name);
	}

	public void LastName(String name) {
		LastName.sendKeys(name);
	}

	public void DOB(String date) {
		DOB.sendKeys(date);
		common.pressTab(DOB);

	}

	public void VisitDateBio(String newVisitdate) {
		VisitDateBio.sendKeys(newVisitdate);
		common.pressTab(VisitDateBio);
	}

	// Closing the Warning on HRA if it appears
	public void warningPopUpClose() throws InterruptedException {
		Thread.sleep(5000);
		if (Hra_WARNINGCLOSE_Btn.isDisplayed()) {
			Hra_WARNINGCLOSE_Btn.click();
		}
	}

	// Update Background Information
	public void updateBackgroundInfo() throws InterruptedException {
		common.implictWait(10);
		BackgroundInformationLink.click();
		Thread.sleep(5000);
		FirstName.clear();
		LastName.clear();
		FirstName(NewFirstname);
		LastName(NewLastname);
		DOB.clear();
		DOB(common.readExcel("sites", "new DOB"));
		Thread.sleep(2000);
	}

	public String getFirstName() {
		return NewFirstname;
	}

	public String getLastName() {
		return NewLastname;
	}

	public String getVisitDate() {
		return NewVisitdate;
	}

	// Update Visit Date
	public void updateVisitDate() throws InterruptedException {
		common.implictWait(10);
		BiometricsLink.click();
		Thread.sleep(5000);
		VisitDateBio.clear();
		VisitDateBio(NewVisitdate);
		Hra_SaveNext_Btn.click();
		Thread.sleep(5000);
		ErrorListClose.click();
		Thread.sleep(2000);
		HomeTab.click();
		Thread.sleep(5000);
	}

}
