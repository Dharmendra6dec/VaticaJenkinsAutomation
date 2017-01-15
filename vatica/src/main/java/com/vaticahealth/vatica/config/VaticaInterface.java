package com.vaticahealth.vatica.config;

import com.vaticahealth.vatica.testcases.CreateHraTest;
import com.vaticahealth.vatica.testcases.DiagnosisTest;
import com.vaticahealth.vatica.testcases.HraTest;
import com.vaticahealth.vatica.testcases.LoginTest;
import com.vaticahealth.vatica.testcases.PHPTest;
import com.vaticahealth.vatica.testcases.PPPTest;
import com.vaticahealth.vatica.testcases.TestsTest;
import com.vaticahealth.vatica.testcases.TrainingResourcesTest;
//import com.vaticahealth.vatica.utils.CommonCode;

public interface VaticaInterface {
	
	
//	CommonCode commonCode = new CommonCode();
	LoginTest loginTest = new LoginTest();
	PHPTest phpTest = new PHPTest();
	CreateHraTest createHraTest = new CreateHraTest();
	HraTest hraTest = new HraTest();
	TestsTest testTest = new TestsTest();
	DiagnosisTest diagTest = new DiagnosisTest();
	PPPTest pppTest = new PPPTest();
	TrainingResourcesTest trainTest = new TrainingResourcesTest();

}
