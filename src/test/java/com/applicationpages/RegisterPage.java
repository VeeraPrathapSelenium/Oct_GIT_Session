package com.applicationpages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.applicationor.HomePage_OR;
import com.applicationor.Register_OR;
import com.genericmethods.GenericMethods;

public class RegisterPage extends GenericMethods {
	public static Register_OR registerOr;
	public RegisterPage()
	{
		if(registerOr==null) registerOr=PageFactory.initElements(driver, Register_OR.class);
	}
	
	/**
	 * @Name= waitForRegisterPageLoad
	 * @Purpose= This method will wait till the Register Page is loaded
	 * @Return Type:NA
	 */
	
	
	public void waitForRegisterPageLoad()
	{
		//wait for page load
		boolean status=waitForElement_Visible("Register Page Header", registerOr.txt_Register_Header, 15);
		//if page is not loaded sucessfully , fail the test case
		Assert.assertEquals(status, true,"Verify Register page is loaded sucessfully");
		
		
	}
	
	/**
	 * @Name= createNewUser
	 */
	public void CreateNewUser()
	{
		
	}
	
	
	
	
	
	

}
