package com.applicationor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_OR {
	
	//=============================== Menu Section ==============================
	@FindBy(xpath="//a[text()='Register']")
	public static WebElement lnk_Register;
	
	@FindBy(xpath="//a[text()='Log in']")
	public static WebElement lnk_login;
	
	//**************************************************************************
	
	
	

}
