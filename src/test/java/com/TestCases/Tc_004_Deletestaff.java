package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Deletestaff;
import com.ScreenFunctions.Login;

public class Tc_004_Deletestaff extends GenericFunctions {

	@Test
	
	public static void deletestaff1()
	{
	
		launchApplication("firefox");
		
		Login lgn = PageFactory.initElements(driver,Login.class);
		lgn.Admin_Login(); 
		
		
		Deletestaff dstf = PageFactory.initElements(driver, Deletestaff.class);
		dstf.delete_staff();   
	
}	
	    
}
