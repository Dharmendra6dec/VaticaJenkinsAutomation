package com.vaticahealth.vatica.utils;

public class MailConfig {
	
	public static String server="smtp.gmail.com";
	public static String from = "dharamtest14@gmail.com";
	public static String password = "QWERTY!@#$%^&";
	public static String[] to ={"dharmendra@quovantis.com", "nitun.pachauri@quovantis.com", "shantanu.nayak@quovantis.com"};
	public static String subject = "Test Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath=(System.getProperty("user.dir")+"\\test-output\\emailable-report.html");
	public static String attachmentName="emailable-report.html";

}
