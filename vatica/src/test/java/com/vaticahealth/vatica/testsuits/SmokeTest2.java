package com.vaticahealth.vatica.testsuits;

//import javax.mail.MessagingException;
//import javax.mail.internet.AddressException;

//import org.openqa.selenium.Keys;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.vaticahealth.vatica.config.TestAnnotation;
import com.vaticahealth.vatica.config.VaticaInterface;
//import com.vaticahealth.vatica.utils.CommonCode;
//import com.vaticahealth.vatica.utils.MailConfig;
//import com.vaticahealth.vatica.utils.MonitoringMail;

public class SmokeTest2 extends TestAnnotation implements VaticaInterface {

	@Test(priority = 1)
	public void test1() throws Exception {
		common.implictWait(60);
		loginTest.tc_Login_1();

	}

	
	  @Test(priority = 2) 
	  public void test2() throws InterruptedException {
		  common.implictWait(60);
		  home.click_Training_Resources();
		  trainTest.verify_TR_Header();
		  trainTest.Verify_Links_TRtab_text();
		  trainTest.verify_FAQ_Link_Check();
	  
	  }
	 
}
