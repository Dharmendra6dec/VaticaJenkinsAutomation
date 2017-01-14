package com.vaticahealth.vatica.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vaticahealth.vatica.config.Configuration;
import com.vaticahealth.vatica.utils.CommonCode;
import com.vaticahealth.vatica.utils.Elements;
import com.vaticahealth.vatica.utils.Button;

public class Diagnosis {

	WebDriver driver = Configuration.driver;
	CommonCode common = new CommonCode();

	@FindBy(xpath = Elements.HOMECOUNT)
	public WebElement HomeCount;

	@FindBy(xpath = Elements.REJECTEDCOUNT)
	public WebElement RejectedCount;

	@FindBy(xpath = Elements.ACCEPTEDCOUNT)
	public WebElement AcceptedCount;

	@FindBy(xpath = Button.Diagnosis_Disease1Accept_Btn)
	public WebElement Diagnosis_Disease1Accept_Btn;

	@FindBy(xpath = Button.Diagnosis_Disease2Accept_Btn)
	public WebElement Diagnosis_Disease2Accept_Btn;

	@FindBy(xpath = Button.Diagnosis_Disease3Accept_Btn)
	public WebElement Diagnosis_Disease3Accept_Btn;

	@FindBy(xpath = Button.Diagnosis_Disease4Reject_Btn)
	public WebElement Diagnosis_Disease4Reject_Btn;

	@FindBy(xpath = Button.Diagnosis_Disease5Reject_Btn)
	public WebElement Diagnosis_Disease5Reject_Btn;

	@FindBy(xpath = Button.Diagnosis_Disease6Reject_Btn)
	public WebElement Diagnosis_Disease6Reject_Btn;

	@FindBy(xpath = Elements.CONDITIONNOTEXIST)
	public WebElement ConditionsNotExist;

	@FindBy(xpath = Elements.REJECTCOMMENTS)
	public WebElement RejectComments;

	@FindBy(xpath = Button.Diagnosis_ConfirmReject_Btn)
	public WebElement Diagnosis_ConfirmReject_Btn;

	@FindBy(xpath = Elements.FIRSTICDCODESELECTION)
	public WebElement FirstIcdCodeSelect;

	@FindBy(xpath = Button.Diagnosis_AcceptNext_Btn)
	public WebElement Diagnosis_AcceptNext_Btn;

	@FindBy(xpath = Elements.CONTINUETOMONITORCB)
	public WebElement ContinueToMonitorCB;

	@FindBy(xpath = Elements.EKGCB)
	public WebElement EkgCB;

	@FindBy(xpath = Elements.EKGDATE)
	public WebElement EkgDate;

	@FindBy(xpath = Elements.INREMISSIONCB)
	public WebElement InRemissionCB;

	@FindBy(xpath = Button.Diagnosis_SaveNext_Btn)
	public WebElement Diagnosis_SaveNext_Btn;

	@FindBy(xpath = Elements.CONTINUECURRENTTREATMENTCB)
	public WebElement ContinueCurrentTreatmentCB;

	@FindBy(xpath = Elements.MEATMEDICATIONCB)
	public WebElement MeatMedicationCB;

	@FindBy(xpath = Elements.MEATCOMMENTS)
	public WebElement MeatComments;

	@FindBy(xpath = Elements.ESIGNVERIFICATIONMSG)
	public WebElement EsignSuccessMsg;

	@FindBy(xpath = Button.ESign_SuccessOk_Btn)
	public WebElement ESign_SuccessOk_Btn;

	/*
	 * @FindBy(xpath= Elements.SIGNBTN) public WebElement SignBtn;
	 */

	@FindBy(xpath = Button.Meat_SaveChanges_Btn)
	public WebElement Meat_SaveChanges_Btn;

	public Diagnosis() {
		PageFactory.initElements(driver, this);
	}

	// Click on the Sign HRA button
	public void clickSignHra() throws InterruptedException {
		List<WebElement> lst = driver.findElements(By.xpath(Button.ESign_ESign_Btn));
		System.out.println(lst.size());

		for (int i = 0; i < lst.size(); i++) {
			try {
				lst.get(i).click();
				System.out.println("OK button clicked");
				break;
			} catch (org.openqa.selenium.NoSuchElementException e) {
				e.getMessage();
				System.out.println("Incorrect element : No such element");
			} catch (org.openqa.selenium.ElementNotVisibleException e) {
				System.out.println("Incorrect element : Element not visible");
			}

		}

		if (lst.size() == 2) {
			System.out.println("List returned 2.");

			Actions act = new Actions(driver);
			act.sendKeys(Keys.TAB).perform();
			act.sendKeys(Keys.TAB).perform();
			act.sendKeys(Keys.ENTER).perform();
		}

	}

	public void eSign_Success_OK_Btn_click() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Closing success pop up");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
	}

}
