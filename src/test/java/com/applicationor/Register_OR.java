package com.applicationor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register_OR {
//************************* Header Section ***************************
	
	@FindBy(xpath="//h1[text()='Register']")
	public static WebElement txt_Register_Header;
	
//********************** Registration Section **********************
	
	@FindBy(xpath="//input[@id='gender-male']")
	public static WebElement rdo_GenderMale	;
	
	@FindBy(xpath="//input[@id='gender-female']")
	public static WebElement rdo_GenderFeMale	;
	
	
	@FindBy(xpath="//input[@id='FirstName']")
	public static WebElement edi_FirstName	;
	
	@FindBy(xpath="//input[@id='LastName']")
	public static WebElement edi_LastName	;
	
	@FindBy(xpath="//select[@name='DateOfBirthDay']")
	public static WebElement drp_Day	;
	
	@FindBy(xpath="//select[@name='DateOfBirthMonth']")
	public static WebElement drp_Month	;
	
	@FindBy(xpath="//select[@name='DateOfBirthYear']")
	public static WebElement drp_Year	;
	
	
	@FindBy(xpath="//input[@id='Email']")
	public static WebElement edi_Email	;
	
	@FindBy(xpath="//input[@id='Password']")
	public static WebElement edi_Password	;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	public static WebElement edi_ConfirmPassword	;
	
	
	@FindBy(xpath="//input[@id='register-button']")
	public static WebElement btn_RegisterAccount	;
	
}
