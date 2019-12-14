package com.reporting;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.excelparser.ExcelParser;
import com.genericmethods.GenericMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporting extends ExcelParser {

	public static ExtentReports extent;
	public static ExtentTest test;

	//step 1
	public void intialzeReport() {
		System.out.println("Intialized Reporting feature.....");
		// check for results folder available with todays date
		String resultsPath=getResultsPath()+"\\TestCase_Summary.HTML";
		//intialize report
		
		extent=new ExtentReports(resultsPath);
		// if we want to provide execution details like, env,sprint etc
		extent.addSystemInfo("Environment","QA").
		addSystemInfo("Sprint","3")
		.addSystemInfo("Cycle","3");
		
		System.out.println("Extent Report is intilalized sucessfully .....");
		
	}
//step 2
	
	//start your test case to report in the html document
	public  void startTestCase(String testCase)
	{
		test=extent.startTest(testCase);
	}
	
//step 3
	//log your events
	
	public void logEvent(String status,String discription)
	{
		
		switch (status.toUpperCase()) {
		case "PASS":
			test.log(LogStatus.PASS, discription+test.addBase64ScreenShot(takeScreenShot()));
			break;
		case "FAIL":
			test.log(LogStatus.FAIL, discription+test.addBase64ScreenShot(takeScreenShot()));
			break;	
		case "WARNING":
			test.log(LogStatus.WARNING, discription+test.addBase64ScreenShot(takeScreenShot()));
			break;
		case "FATAL":
			test.log(LogStatus.FATAL, discription+test.addBase64ScreenShot(takeScreenShot()));
			break;

		default:
			break;
		}
				
		
	}
	//step 4:End Test
	
			public void endTest()
			{
				extent.endTest(test);
			}
			
//Step 5:Publish Report
			
			public void flushReport()
			{
				extent.flush();
				extent.close();
			}
	
	
	
	public String getResultsPath() {

		Date d = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		System.out.println(sdf.format(d));

		String currentDate = sdf.format(d);

		/*
		 * sdf=new SimpleDateFormat("HH:mm:SS");
		 * 
		 * sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");
		 * System.out.println(sdf.format(d));
		 */

		String path = System.getProperty("user.dir") + "\\Results\\" + currentDate;

		File f = new File(path);

		if (!f.exists())
			f.mkdirs();

		return path;
	}

	public String takeScreenShot()
	{
		TakesScreenshot sht=(TakesScreenshot) GenericMethods. driver;
		
		String screenShot=sht.getScreenshotAs(OutputType.BASE64);
		
		return "data:image/png;base64,"+screenShot;
	}
	
	
	
	
	
	
	
}
