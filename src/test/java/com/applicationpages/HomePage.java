package com.applicationpages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.applicationor.HomePage_OR;
import com.genericmethods.GenericMethods;

public class HomePage extends GenericMethods{
	public static HomePage_OR homePageOr;
	public HomePage()
	{
		if(homePageOr==null) homePageOr=PageFactory.initElements(driver, HomePage_OR.class);
	}
	
	
	public void navigateToRegisterPage()
	{
		boolean status=hoverAndClick("Register", "Home Page", homePageOr.lnk_Register);
		Assert.assertEquals(status, true,"Verify user is navigated to register page");
		
	}
	

}
