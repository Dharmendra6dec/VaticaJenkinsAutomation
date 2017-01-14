package com.vaticahealth.vatica.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class Configuration {
	public static Properties properties = new Properties();
	public static String filepath;
	public static String currentDirec = System.getProperty("user.dir");
	public static WebDriver driver;
	public static FileInputStream in;
	public static String URL;
	public static String browser;
	public static String env;
	public static String emailId;
	public static String emailPassword;
	public static String excelFilePath = currentDirec + "/src/test/resources/inputExcel.xls";

	// Initializing the browser driver
	public static WebDriver browser() {

		DesiredCapabilities cap = new DesiredCapabilities();

		// invoking mozilla firefox
		if (browser.equalsIgnoreCase("mozilla")) {

			// System.setProperty("webdriver.gecko.driver",
			// System.getProperty("user.dir") +
			// "/src/test/resources/geckodriver.exe");

			FirefoxProfile ffprofile = new FirefoxProfile();
			ffprofile.setPreference("browser.download.folderList",2);
			ffprofile.setPreference("browser.download.manager.showWhenStarting",false);
			ffprofile.setPreference("browser.download.dir",System.getProperty("user.dir")+"\\downloads");
			ffprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"text/csv,application/x-msexcel,application/excel,application/x-excel,"
					+ "application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");

			driver = new FirefoxDriver(ffprofile);
			Reporter.log("Mozilla is envoked");

		}
		// Invoking Internet Explorer browser
		else if (browser.equalsIgnoreCase("IE")) {

			cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			cap.setCapability(CapabilityType.BROWSER_NAME, "IE");
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			cap.setCapability("requireWindowFocus", true);

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "/src/test/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver(cap);
			Reporter.log("I.E is invoked");

		}
		// Invoking the Google Chrome browser
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("Chrome driver is invoked");

		}
		// Invoking the Safari browser
		else if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
			Reporter.log("Safari broswer is invoked");

		}

		// Invoking HTML unit driver
		else if (browser.equalsIgnoreCase("html")) {
			driver = new HtmlUnitDriver();
			Reporter.log("HTML Unit driver is invoked");

		}

		// Invoking Ghostdriver
		/*
		 * else if (broswer.equalsIgnoreCase("phantomjs")) {
		 * cap.setJavascriptEnabled(true);
		 * cap.setCapability(PhantomJSDriverService.
		 * PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir") +
		 * "/src/test/resources/phantomjs.exe");
		 * 
		 * System.setProperty("phantomjs.binary.path",
		 * System.getProperty("user.dir") +
		 * "/src/test/resources/phantomjs.exe");
		 * 
		 * driver = new PhantomJSDriver();
		 * Reporter.log("GhostDriver is invoked");
		 * 
		 * }
		 */
		/*
		 * else if (browser.equalsIgnoreCase("phantomjs")) {
		 * cap.setJavascriptEnabled(true);
		 * cap.setCapability(PhantomJSDriverService.
		 * PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir") +
		 * "/src/test/resources/phantomjs.exe");
		 * 
		 * System.setProperty("phantomjs.binary.path",
		 * System.getProperty("user.dir") +
		 * "/src/test/resources/phantomjs.exe");
		 * 
		 * driver = new PhantomJSDriver();
		 * Reporter.log("GhostDriver is invoked");
		 * 
		 * }
		 */

		return driver;

	}

	static {

		try {
			// getting the default Environment
			if (System.getProperty("env") == null) {
				filepath = "/src/test/resources/QA-Environment.properties";
				in = new FileInputStream(System.getProperty("user.dir") + filepath);
				properties.load(in);
			}

			// Getting the QA specific Environment
			else if (env.equalsIgnoreCase("qa")) {
				filepath = "/src/test/resources/QA-Environment.properties";
				in = new FileInputStream(System.getProperty("user.dir") + filepath);
				properties.load(in);
				env = properties.getProperty("env");

			}
			// getting the developer Specific Environment
			else if (env.equalsIgnoreCase("dev")) {
				filepath = "/src/test/resources/Dev-Environment.properties";
				in = new FileInputStream(System.getProperty("user.dir") + filepath);
				properties.load(in);
				env = properties.getProperty("env");

			}

			env = properties.getProperty("env"); // Env value from the
													// properties files
			URL = properties.getProperty("URL"); // URL from the properties
													// files
			browser = properties.getProperty("browser"); // browser from the
															// Properties files
			emailId = properties.getProperty("emailId");
			emailPassword = properties.getProperty("emailPassword");

			// System.out.println(URL);
			// System.out.println(browser);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	// function would return the website URL
	public static String invokeUrl() {
		Reporter.log("URL is " + URL);
		return URL;
	}

}
