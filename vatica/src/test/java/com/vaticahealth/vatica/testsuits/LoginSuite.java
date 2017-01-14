package com.vaticahealth.vatica.testsuits;

import java.lang.reflect.InvocationTargetException;
import org.testng.annotations.Test;
import com.vaticahealth.vatica.config.TestAnnotation;
import com.vaticahealth.vatica.config.VaticaInterface;
import com.vaticahealth.vatica.testcases.LoginTest;

public class LoginSuite extends TestAnnotation implements VaticaInterface {
	
	LoginTest loginTest = new LoginTest();

	// Login in to the application with correct credentials and select the
	// website 'Plus' from the dropdown of sites.
	@Test(priority = 1)
	public void tc_Login_With_Correct_Creddentials_And_Verification() throws InterruptedException, InvocationTargetException {

		loginTest.tc_Login_1();
		phpTest.loginConf();
		phpTest.logout();

	}

	// Clicking on privacy policy on the Login Page and confirming the page title.
	@Test(priority = 2)
	public void tc_Login_2() {
		loginTest.tc_Login_2();
	}

	// Clicking on Technical Support / Get Help link on the login page and confirming the page title.
	@Test(priority = 3)
	public void tc_Login_3() throws InterruptedException {
		loginTest.tc_Login_3();
	}

	// Remember me check
	@Test(priority = 4, enabled=true)
	public void tc_Login_4() throws InterruptedException {
		loginTest.tc_Login_4();
	}
}
