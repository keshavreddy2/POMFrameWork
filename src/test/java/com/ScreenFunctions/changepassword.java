package com.ScreenFunctions;





import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class changepassword extends GenericFunctions
{
	//change password
	@FindBy(how = How.XPATH, using="//*[text()='Change password']")
	public static  WebElement chg_pass_linl;
	
	//old password
	@FindBy(how=How.XPATH, using="//*[@name='old_password']")
	public static WebElement enter_old_password;

	//new password
	@FindBy(how= How.XPATH, using="//*[@name='new_password']")
     public static WebElement enter_new_password;
	
	//enter password again
	@FindBy(how=How.XPATH,using="//*[@name='again_password']")
	public static WebElement enter_password_again;
	
	//change password button
	@FindBy(how= How.XPATH,using ="//*[@*='change_password']")
	public static WebElement change_password;
	
	
	public static boolean chg_pass()
	
	{
	
	boolean status = true;
	
	//clicking on change password link under Admin.
	 status = hoverAndClick(chg_pass_linl);
	 
	 
	List<WebElement> lst= driver.findElements(By.cssSelector("input:invalid")); 

	System.out.println("Before enter the data from the Password invalid fields::  "+lst.size());
	
	 //enter old password
//	 String oldpswd = getdata("Changepassword", "Enter_old_password", 1);
//	 status = setdata(enter_old_password, oldpswd);
	 
	 
	 //enter new password
	 String newpswd = getdata("Changepassword", "Enter_new_password", 2);
	 status = setdata(enter_new_password,newpswd);
	 
	 //enter new password again
	 String conpswd = getdata("Changepassword","Enter_password_again",2 );
	 status = setdata(enter_password_again,conpswd);
	 	 
	 //clicking on change password button.
	  status = hoverAndClick(change_password);
	  
	 lst= driver.findElements(By.cssSelector("input:invalid")); 
	
	
	  int Password_invalid=lst.size();
	  System.out.println("After enter the data from the Password invalid fields::  "+Password_invalid);
	  
	 if (Password_invalid==0) {
		
		 System.out.println("User able to change the password");
		 
		 
	} else {

		System.out.println("User unable to change the password");
	}
	 
	 	 
	 return status;
		
	}
	
}
