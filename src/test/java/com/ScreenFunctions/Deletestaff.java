package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Deletestaff extends GenericFunctions {

	//Delete staff 
	@FindBy(how = How.XPATH, using = "//a[text()='Delete staff']")
	public static WebElement delete_staff;
	
	//@Delete staff 
	@FindBy(how = How.XPATH, using = "//input[@name='submit2_id']")
	public static WebElement delete_staff_details;

	//@Table of Staff Details
	@FindBy(how = How.XPATH, using = "//table[1]")
	public static WebElement delete_table;

		// delete staff function
		public static boolean delete_staff() {
		boolean status = true;

		//Click on delete staff button
		status = hoverAndClick(delete_staff);
		if (status) {
			status = true;

			//getting data for name field from Test data 
			String str1 = getdata("DeleteStaff", "name", 1);
			
			//getting data for email field from Test data
			String str2 = getdata("DeleteStaff", "email", 1);

			//deleting name and email for the particular record 
			status = getdeletedata(str1, str2);

		}
		//clicking on 'delete staff details' button
		status = hoverAndClick(delete_staff_details);
		System.out.println("Delete staff is clicked");
		return status;

	}
}
