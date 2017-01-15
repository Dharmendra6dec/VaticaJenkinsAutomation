package com.vaticahealth.vatica.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vaticahealth.vatica.config.Configuration;
import com.vaticahealth.vatica.utils.Button;
import com.vaticahealth.vatica.utils.CommonCode;
import com.vaticahealth.vatica.utils.Elements;
//import com.vaticahealth.vatica.utils.Button;

public class Login {
	CommonCode common = new CommonCode();
	WebDriver driver = Configuration.driver;
	PHP home = new PHP();
	// String url = Configuration.invokeUrl();

	@FindBy(xpath = Elements.loginId)
	public WebElement loginId;

	@FindBy(xpath = Elements.loginPassword)
	public WebElement loginPassword;

	@FindBy(xpath = Button.Login_Login_Btn)
	public WebElement Login_Login_Btn;

	@FindBy(xpath = Elements.webSiteOption)
	public WebElement webSiteOption;

	@FindBy(xpath = Button.Login_SelectWebsite_Btn)
	public WebElement Login_SelectWebsite_Btn;

	@FindBy(xpath = Button.Login_Reset_Btn)
	public WebElement Login_Reset_Btn;

	@FindBy(xpath = Elements.resetEmailId)
	public WebElement resetEmailId;

	@FindBy(xpath = Button.Login_SubmitRequest_Btn)
	public WebElement Login_SubmitRequest_Btn;

	@FindBy(xpath = Elements.resetPasswordMessage)
	public WebElement resetPasswordMessage;

	@FindBy(xpath = Elements.rememberMeCheckBox)
	public WebElement rememberMeCheckBox;

	@FindBy(xpath = Elements.privacyPolicy)
	public WebElement privacPolicyLink;

	@FindBy(xpath = Elements.techSupport)
	public WebElement techSupportLink;

	@FindBy(xpath = Elements.PRIVACYTITLE)
	public WebElement privacyTitle;

	@FindBy(xpath = Elements.TECHSUPPORTITLE)
	public WebElement techSupportTitle;

	@FindBy(xpath = Button.Login_PrivacyPolicyClose_Btn)
	public WebElement Login_PrivacyPolicyClose_Btn;

	@FindBy(xpath = Elements.CANCELTECHSUPPORT)
	public WebElement cancelTechSupport;

	@FindBy(xpath = Button.Login_OK_Btn)
	public WebElement Login_OK_Btn;

	@FindBy(xpath = Elements.inValidLoginMessgae)
	public WebElement invalidLoginMess;
	
	@FindBy(xpath = Elements.Login_PrivacyPolicy_text)
	public WebElement Login_PrivacyPolicy_text;

	@FindBy(xpath = Elements.Login_PrivacyPolicy_Close_Btn)
	public WebElement Login_PrivacyPolicy_Close_Btn;

	@FindBy(xpath = Elements.Login_TechSupport_text)
	public WebElement Login_TechSupport_text;

	public Login() {
		PageFactory.initElements(driver, this);
	}

	public void loginWithCorrectCredentials(String Id, String password) {
		String logId1 = Id;
		String logPassword1 = password;
		loginId.sendKeys(logId1);
		loginPassword.sendKeys(logPassword1);
	}

	public void Login_Login_Btn() {
		Login_Login_Btn.click();
	}

	public void Login_Reset_Btn() {
		Login_Reset_Btn.click();
	}

	public void websiteDropDown(int websiteSelectionSupp) throws InterruptedException {
		common.implictWait(10);
		Thread.sleep(3000);
		//webSiteOption.click();
		Select select = new Select(webSiteOption);
		//Thread.sleep(5000);
		select.selectByIndex(websiteSelectionSupp);
	}

	public void selectWebsiteButton() {
		common.explictWaitClickable(20, Login_SelectWebsite_Btn);
		Login_SelectWebsite_Btn.click();
	}

	public void resetPassword(String emailId, String passwordResetMessage) {
		common.implictWait(10);
		Login_Reset_Btn.click();
		resetEmailId.sendKeys(emailId);
		Login_SubmitRequest_Btn.click();
		Assert.assertEquals(resetPasswordMessage.getText(), passwordResetMessage);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Login_OK_Btn.click();

	}

	public void rememberMeOption() {

		rememberMeCheckBox.click();

	}

	public void privacyPolicy(String privacyTitleInput) {
		common.implictWait(10);
		privacPolicyLink.click();
		common.explictWaitPresence(5, By.xpath(Elements.PRIVACYTITLE));
		Assert.assertTrue(privacyTitle.getText().equals(privacyTitleInput),"Privacy policy title doesnot match");
		closePrivacyPolicy();
	}

	public void closePrivacyPolicy() {
		Login_PrivacyPolicyClose_Btn.click();
	}

	public void technicalSupportLink(String techSupportInputText) throws InterruptedException {
		common.implictWait(10);
		Thread.sleep(5000);
		techSupportLink.click();
		common.explictWaitPresence(5, By.xpath(Elements.TECHSUPPORTITLE));
		//Assert.assertTrue(techSupportTitle.getText().equals(techSupportTitle),"Technical Support title does not match");
		Assert.assertEquals(techSupportTitle.getText(), techSupportInputText);
		cancelTechSupport.click();
	}

	public void cancelTechSupport() {
		cancelTechSupport.click();
	}

	public void clearInputField() {
		common.implictWait(10);
		loginId.clear();
		loginPassword.clear();
	}

	public void loginFiller() {
		common.implictWait(10);
		loginId.sendKeys(common.readExcel("hra", "EmailId"));
		System.out.println(loginId.getText());
		loginPassword.sendKeys(common.readExcel("hra", "Password"));
		System.out.println(loginPassword.getText());
	}

	public void rememberMeCheckClick() {
		common.implictWait(10);
		if(rememberMeCheckBox.isSelected()== false) {
			rememberMeCheckBox.click();
			
		}
	}

	public void checkEmailId(String emailid) throws InterruptedException {
		common.implictWait(10);
		Thread.sleep(5000);
		Assert.assertTrue(loginId.getAttribute("value").equals(emailid), "Remember me check failed");
	}

}
