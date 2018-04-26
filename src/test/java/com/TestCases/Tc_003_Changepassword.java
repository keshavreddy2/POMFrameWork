package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Login;
import com.ScreenFunctions.changepassword;

public class Tc_003_Changepassword extends GenericFunctions{

	@Test
	
	public static void changpswd()
	{
		
		launchApplication("firefox");
		
		Login lgn = PageFactory.initElements(driver,Login.class);
		lgn.Admin_Login(); 
		
		changepassword chgpswd = PageFactory.initElements(driver, changepassword.class);
		chgpswd.chg_pass();
	}
}
