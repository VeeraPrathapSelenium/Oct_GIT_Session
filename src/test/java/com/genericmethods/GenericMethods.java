package com.genericmethods;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.reporting.Reporting;

public class GenericMethods extends Reporting{
	
	public static WebDriver driver;
	
	
	public boolean  launchBrowser(String browser,String url)
	{
		boolean status=true;
		System.out.println("Launching browser :"+browser.toLowerCase());
		try
		{
			switch (browser.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver","chromedriver.exe" );
				driver=new ChromeDriver();
				break;
				
			case "ff":
				//System.setProperty("webdriver.chrome.driver","chromedriver.exe" );
				driver=new FirefoxDriver();
				break;

			default:
				break;
			}
			
			//driver.get(url);
			
			driver.navigate().to(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
			System.out.println("Browser "+browser+" is launched sucessfully");
			logEvent("Pass", "Browser "+browser+" is launched sucessfully");
		}catch(Exception e)
		{
			status=false;
			e.getStackTrace();
			System.out.println("Browser is not launched sucessfully "+e.getMessage());
			logEvent("Fail ", "Browser "+browser+" is not launched sucessfully");
		}
		return status;
		
		
		
		
	}
	
	public boolean checkElementExist(String elementName,String pageName,WebElement element)
	{
		boolean status=true;
		try
		{
			if(element.isDisplayed())
			{
				System.out.println("The Element "+elementName+" is displayed on "+pageName);
				logEvent("Pass", "The Element "+elementName+" is displayed on "+pageName);
			}
			
			
		}catch(Exception e)
		{
			status=false;
			System.out.println("The Element "+elementName+" is not displayed on "+pageName);
			logEvent("Fail ", "The Element "+elementName+" is not displayed on "+pageName);
		}
		return status;
		
		
	}
	
	
	public boolean clickAndSendData(String textBoxName,String pageName,WebElement textBox,String data)
	{
		boolean status=true;
		try
		{
			textBox.click();
			
			textBox.clear();
			
			textBox.sendKeys(data);
			
			System.out.println("The Text Box : "+textBoxName+" is typed  with data  "+data+" on the page "+pageName);
			logEvent("Pass", "The Text Box : "+textBoxName+" is typed  with data  "+data+" on the page "+pageName);
			
		}catch(Exception e)
		{
			status=false;
			System.out.println("The Text Box : "+textBoxName+" is not typed  with data  "+data+" on the page "+pageName);
			logEvent("Fail", "The Text Box : "+textBoxName+" is not typed  with data  "+data+" on the page "+pageName);
		}
		return status;
		
		
	}
	
	public boolean hoverAndClick(String buttonName,String pageName,WebElement button)
	{
		boolean status=true;
		try
		{
			Actions acc=new Actions(driver);
			acc.moveToElement(button).click(button).build().perform();
			System.out.println("The Element : "+buttonName+" is  clicked sucessfully on the page "+pageName);
			logEvent("Pass", "The Element : "+buttonName+" is  clicked sucessfully on the page "+pageName);
		}catch(Exception e)
		{
			status=false;
			System.out.println("The Element : "+buttonName+" is not clicked on the page "+pageName);
			logEvent("Fail", "The Element : "+buttonName+" is not clicked on the page "+pageName);
		}
		return status;
		
		
	}
	
	public boolean selectDropDownByVisibleText(String dropDownName,String pageName,WebElement dropDown,String option)
	{
		boolean status=true;
		try
		{
			Select select=new Select(dropDown);
			select.selectByVisibleText(option);
			System.out.println("The Element : "+dropDownName+" is  Selected sucessfully with the option : "+option+"on the page "+pageName);
			logEvent("Pass", "The Element : "+dropDownName+" is  Selected sucessfully with the option : "+option+"on the page "+pageName);
			
		}catch(Exception e)
		{
			status=false;
			System.out.println("The Element : "+dropDownName+" is  not Selected sucessfully with the option : "+option+"on the page "+pageName);
			logEvent("Fail", "The Element : "+dropDownName+" is not Selected sucessfully with the option : "+option+"on the page "+pageName);
		}
		return status;
		
		
	}
	
	
	
	public boolean selectDropDownByValue(String dropDownName,String pageName,WebElement dropDown,String option)
	{
		boolean status=true;
		try
		{
			Select select=new Select(dropDown);
			select.selectByValue(option);
			System.out.println("The Element : "+dropDownName+" is  Selected sucessfully with the option : "+option+"on the page "+pageName);
			logEvent("Pass", "The Element : "+dropDownName+" is  Selected sucessfully with the option : "+option+"on the page "+pageName);
		}catch(Exception e)
		{
			status=false;
			System.out.println("The Element : "+dropDownName+" is  not Selected sucessfully with the option : "+option+"on the page "+pageName);
			logEvent("Pass", "The Element : "+dropDownName+" is not Selected sucessfully with the option : "+option+"on the page "+pageName);
		}
		return status;
		
		
	}
	
	
	public boolean selectDropDownByIndex(String dropDownName,String pageName,WebElement dropDown,int option)
	{
		boolean status=true;
		try
		{
			Select select=new Select(dropDown);
			select.selectByIndex(option);
			System.out.println("The Element : "+dropDownName+" is  Selected sucessfully with the option : "+option+"on the page "+pageName);
			logEvent("Pass", "The Element : "+dropDownName+" is  Selected sucessfully with the option : "+option+"on the page "+pageName);
		}catch(Exception e)
		{
			status=false;
			System.out.println("The Element : "+dropDownName+" is  not Selected sucessfully with the option : "+option+"on the page "+pageName);
			logEvent("fail", "The Element : "+dropDownName+" is  not Selected sucessfully with the option : "+option+"on the page "+pageName);
		}
		return status;
		
		
	}
	
	public void forceClick(WebElement element){
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		
		
	}
	
	
	public void closeBrowser()
	{ driver.close();
	
	}
	
	public boolean waitForElement_Clickable(String elementName,WebElement element,int time)
	{boolean status=true;
		try
		{
			
			WebDriverWait wait=new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			logEvent("Pass", "The Element "+elementName+" is  clickable in time specified as "+time+" seconds");
			
		}catch(Exception e)
		{
			status=false;
			logEvent("Fail", "The Element "+elementName+" is not clickable in time specified as "+time+" seconds");
		}
		return status;
	}
	
	public boolean waitForElement_Visible(String elementName,WebElement element,int time)
	{boolean status=true;
		try
		{
			
			WebDriverWait wait=new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
			logEvent("Pass", "The Element "+elementName+" is  clickable in time specified as "+time+" seconds");
			
		}catch(Exception e)
		{
			status=false;
			logEvent("Fail", "The Element "+elementName+" is not clickable in time specified as "+time+" seconds");
		}
		return status;
	}
	
	
	public boolean fluentWait_Clickable(String elementName,WebElement element,int time){
		boolean status=true;
		try
		{
			FluentWait wait=new FluentWait(driver);
			wait.withTimeout(time,TimeUnit.SECONDS);
			wait.pollingEvery(5, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			
			
		}catch(Exception e){
			status=false;
		}
		return status;
	}
	
	
	
	
	

}
