package com.vaticahealth.vatica.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.text.Position;

import org.apache.bcel.generic.RETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.w3c.css.sac.Locator;

import com.google.common.base.Function;
import com.vaticahealth.vatica.config.Configuration;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
//import vatica_util.TestConfig;
//import vatica_util.monitoringMail.SMTPAuthenticator;

public class CommonCode {

	public WebDriver driver = Configuration.driver;
	String parentWindow; // Used for Multiple Window Handling
	int row, column, adjRow, adjCol;

	public static String value;
	public static String excelFilepath = Configuration.excelFilePath;// excel
																		// sheet
																		// path
																		// for
																		// importing
																		// and
																		// writing
																		// data

	// The function would allow to read and fetch the value for searched string
	// from excel file. The function requires the File path at which the excel
	// The function requires the string to be searched in the excel sheet

	public String readExcel(String sheetName, String searchedString) {
		try {

			Workbook book = Workbook.getWorkbook(new File(excelFilepath));
			Sheet sh = book.getSheet(sheetName);
			Cell c = sh.findCell(searchedString); // finding the cell containing
													// the searched string
			row = c.getRow(); // getting the last row in the sheet
			column = c.getColumn(); // getting the last column in the sheet
			Cell adjCell = sh.getCell(++column, row); // getting the adjacent
														// Cell

			String value = adjCell.getContents();
			return value;

		} catch (BiffException e) {
			StringWriter w = new StringWriter();
			e.printStackTrace(new PrintWriter(w));
			Reporter.log(w.toString());

		} catch (IOException e) {
			StringWriter w = new StringWriter();
			e.printStackTrace(new PrintWriter(w));
			Reporter.log(w.toString());
		}
		return value;
	}

	// Function allow to write data in the excel file. It requires the header
	// and the value corresponding to the header that we need to write in Excel
	public void writeExcel(String header, String value, String sheetName) {
		try {
			Workbook book = Workbook.getWorkbook(new File(excelFilepath));
			WritableWorkbook writeBoook = Workbook.createWorkbook(new File(excelFilepath), book);
			WritableSheet writeSheet = writeBoook.getSheet(sheetName);
			int row = writeSheet.getRows();// getting the last row in the
											// writable sheet
			Label lb = new Label(0, row, header);
			Label lb1 = new Label(1, row, value);

			writeSheet.addCell(lb);
			writeSheet.addCell(lb1);
			writeBoook.write();
			writeBoook.close();

		} catch (BiffException e) {
			StringWriter w = new StringWriter();
			e.printStackTrace(new PrintWriter(w));
			Reporter.log(w.toString());
			// TODO Auto-generated catch block

		} catch (IOException e) {
			// TODO Auto-generated catch block
			StringWriter w = new StringWriter();
			e.printStackTrace(new PrintWriter(w));
			Reporter.log(w.toString());

		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			StringWriter w = new StringWriter();
			e.printStackTrace(new PrintWriter(w));
			Reporter.log(w.toString());
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			StringWriter w = new StringWriter();
			e.printStackTrace(new PrintWriter(w));
			Reporter.log(w.toString());
		}

	}

	// function would implicitly wait for the element with time as passed in the
	// function
	public void implictWait(int timeInSeconds) {
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	// Generate a 7 day old date
	@Test
	public String recentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
		Date date = new Date();

		String date1 = dateFormat.format(date.getTime() - (7 * 24 * 3600000));
		return date1;
	}

	// Function would explicitly wait for the webelement to be present for
	// specific time. The function needs the webelment location for identifying
	// the webelement and the time in seconds upto which the function will wait
	// for the webelement

	public void explictWaitPresence(int timeInSecond, By by) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSecond);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void explictWaitClickable(int timeInSecond, WebElement webelement) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSecond);
		wait.until(ExpectedConditions.elementToBeClickable(webelement));
	}

	// HRA number generator
	public String tenDigitNumberGenerator() {
		Random rand = new Random();
		long num = rand.nextInt(900000000) + 1000000000;
		return String.valueOf(num);
	}

	public String firstNameGenerator() {
		Random rand = new Random();
		long num = rand.nextInt(90000) + 10000;
		String name = String.valueOf(num);
		String FirstName = "John".concat(name);
		return FirstName;
	}

	public String LastNameGenerator() {
		Random rand = new Random();
		long num = rand.nextInt(90000) + 10000;
		String name = String.valueOf(num);
		String LastName = "Doe".concat(name);
		return LastName;
	}

	// The function allows switch to new window having the title as passed

	public void windowHandler(String newWindowTitle) {
		parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String tempHandle : handles) {
			driver.switchTo().window(tempHandle);
			String title = driver.getTitle();
			if (title.equalsIgnoreCase(newWindowTitle)) {
				break;
			}
		}

	}

	// The function allows you to move the parent window while control is at any
	// child window
	public void mainwindow() {
		driver.switchTo().window(parentWindow);
	}
	/*
	 * public void email() { String to = "lakshg07@gmail.com"; String from
	 * ="l.akshg07@gmail.com"; String host ="smtp.journaldev.com"; try {
	 * Properties pro=System.getProperties();
	 * pro.setProperty("mail.smtp.host",host ); Session
	 * session=Session.getDefaultInstance(pro); MimeMessage message = new
	 * MimeMessage(session); message.setFrom(new InternetAddress(from));
	 * message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
	 * message.setSubject("hi this is header"); BodyPart bodyMessage=new
	 * MimeBodyPart(); bodyMessage.setText("hi this is text"); MimeBodyPart
	 * attchment=new MimeBodyPart(); String filePath=
	 * "C:/Users/Lakshya Grover/Desktop/view-bill.pdf"; DataSource
	 * fileSource=new FileDataSource(filePath); attchment.setDataHandler(new
	 * DataHandler(fileSource)); attchment.setFileName(filePath);
	 * 
	 * Multipart multi = new MimeMultipart(); multi.addBodyPart(bodyMessage);
	 * multi.addBodyPart(attchment);
	 * 
	 * message.setContent(multi);
	 * 
	 * Transport.send(message); System.out.println("send");
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * } catch (AddressException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (MessagingException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * }
	 */

	public void selectByValue(WebElement elle, int sel) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		Select select = new Select(elle);
		select.selectByIndex(sel);

	}

	public void pressTab(WebElement elle2) {
		elle2.sendKeys(Keys.TAB);

	}
	
	public void switchToNewWindow() {

		Set<String> handles = driver.getWindowHandles();
		String win1 = driver.getWindowHandle();
		handles.remove(win1);
		String win2 = handles.iterator().next();
		driver.switchTo().window(win2);
	}
	
	public void closeAndswitchToNewWindow() {

		Set<String> handles = driver.getWindowHandles();
		String win1 = driver.getWindowHandle();
		handles.remove(win1);
		String win2 = handles.iterator().next();
		driver.close();
		driver.switchTo().window(win2);
	}

	// Double Clicking on any webelement
	public void doubleClick(WebDriver driver, WebElement elle) throws InterruptedException {
		// common.implictWait(10);
		// Thread.sleep(10000);
		Actions builder = new Actions(driver);
		builder.doubleClick(elle).build().perform();
		Thread.sleep(7000);
	}

	public void keyboard_Ctrl_S(WebDriver driver) throws AWTException, InterruptedException {
		new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL, "s")).perform();

		Robot robot = new Robot();
		// press Ctrl+S the Robot's way
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Thread.sleep(5000);
		// press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	// To compare two arraylist<String> with same size.
	public void compareList(ArrayList<String> el, ArrayList<String> al) {
		System.out.println(el.size() + "  " + al.size());
		// TODO Auto-generated method stub
		for (int i = 0; i < al.size(); i++) {
			System.out.println(el.get(i) + "  " + al.get(i));
			Assert.assertTrue(el.get(i).toString().equalsIgnoreCase(al.get(i).toString()), "Not Matching");

		}
	}

	public void sendMail(String from, String to, String subject, String messageBody) {
		boolean debug = false;
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.debug", "true");

		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		// creating the session object
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Configuration.emailId, Configuration.emailPassword);
			}
		});

		try {

			Transport bus = session.getTransport("smtp");
			bus.connect();
			Message message = new MimeMessage(session);

			// X-Priority values are generally numbers like 1 (for highest
			// priority), 3 (normal) and 5 (lowest).

			message.addHeader("X-Priority", "1");
			message.setFrom(new InternetAddress(from));
			InternetAddress[] addressTo = new InternetAddress[to.length()];
			for (int i = 0; i < to.length(); i++)
				addressTo[i] = new InternetAddress(to);
			message.setRecipients(Message.RecipientType.TO, addressTo);
			message.setSubject(subject);

			BodyPart body = new MimeBodyPart();

			// body.setText(messageBody);
			body.setContent(messageBody, "text/html");

			BodyPart attachment = new MimeBodyPart();
			DataSource source = new FileDataSource("C:/Users/Lakshya Grover/Desktop/");
			attachment.setDataHandler(new DataHandler(source));
			attachment.setFileName("jin.xls");
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(body);
			multipart.addBodyPart(attachment);
			message.setContent(multipart);
			Transport.send(message);
			Reporter.log("Email has been sent");
			bus.close();

		} catch (MessagingException e) {
			StringWriter w = new StringWriter();
			e.printStackTrace(new PrintWriter(w));
			Reporter.log(w.toString());
		}
	}

}
