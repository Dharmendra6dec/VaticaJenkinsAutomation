package com.vaticahealth.vatica.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.vaticahealth.vatica.config.TestAnnotation;
import com.vaticahealth.vatica.config.VaticaInterface;

public class TrainingResourcesTest extends TestAnnotation implements VaticaInterface {

	// WebDriver driver = Configuration.driver;

	// To verify the texts of the links on Training Resources tab
	public void Verify_Links_TRtab_text() {
		common.implictWait(40);

		for (int i = 1; i <= 14; i++) {

			if (i == 2 || i == 7 || i == 9 || i == 11 || i == 13) {

			} else {
				String TempText = driver.findElement(By.xpath("//*[@id='training']/dl/dt[" + i + "]/a")).getText();
				// System.out.println(TempText);
				Assert.assertTrue(TempText.equals(common.readExcel("train", "TR Link " + i + "")),
						TempText + " is not matching.");
			}
		}

	}

	// To verify the text of the Training Resources Header text
	public void verify_TR_Header() {
		common.implictWait(40);
		System.out.println("ok" + train.TR_Training_Tools_text.getText() + "ok");
		System.out.println("ok" + common.readExcel("train", "TR Header") + "ok");
		Assert.assertTrue(
				train.TR_Training_Tools_text.getText().equalsIgnoreCase(common.readExcel("train", "TR Header")),
				"Training Header's text doesn't match.");
	}

	public void verify_FAQ_Link_Check() throws InterruptedException {
		common.implictWait(40);
		train.TR_FAQ_Link_link.click();
		Thread.sleep(10000);
		common.switchToNewWindow();
		System.out.println("ok"+train.TR_FAQ_ExpectedText.getText()+"ok");
		System.out.println("ok"+common.readExcel("train", "FAQ text")+"ok");
	//	Assert.assertTrue(train.TR_FAQ_ExpectedText.getText().toString().equalsIgnoreCase(common.readExcel("train", "FAQ text")), "FAQ's text didn't match.");
		common.closeAndswitchToNewWindow();
	}
}
