package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Admin;
import com.ScreenFunctions.Login;

public class Tc_002_AddCustomer extends GenericFunctions
{

	@Test

	public static void Addcustomer()
	{
				
		GenericFunctions.launchApplication("firefox");
		
		//Step2:Enter User Credentials
		
		Login lgn=PageFactory.initElements(driver, Login.class);		
		lgn.Admin_Login(); 
		
		
		Admin admin=PageFactory.initElements(driver, Admin.class);
		admin.add_customer();
		

	}
}
