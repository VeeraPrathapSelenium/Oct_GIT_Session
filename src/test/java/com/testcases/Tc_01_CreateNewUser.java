package com.testcases;

import org.testng.annotations.Test;

import com.applicationor.HomePage_OR;
import com.applicationpages.HomePage;
import com.applicationpages.RegisterPage;
import com.testngannotations.CommonAnnotation;

public class Tc_01_CreateNewUser extends CommonAnnotation {
	
	@Test
	public static void Tc_01_CreateNewUser()
	{
		HomePage homePage=new HomePage();
		
		homePage.navigateToRegisterPage();
		
		RegisterPage registerPage=new RegisterPage();
		registerPage.waitForRegisterPageLoad();
		
	}
	
	

}
