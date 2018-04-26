package com.ScreenFunctions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.asserts.SoftAssert;

import com.GenericFunctions.GenericFunctions;

public class Login extends GenericFunctions {

	// **************************** Login Panel Section Object
	// *********************************

	// Adminlink
	@FindBy(how = How.XPATH, using = "//*[text()='Admin ']")
	public static WebElement lnk_admin_Admin;

	// Usernme
	@FindBy(how = How.XPATH, using = "//*[@name='uname']")
	public static WebElement edi_admin_Username;

	// Password
	@FindBy(how = How.XPATH, using = "//*[@name='pwd']")
	public static WebElement edi_admin_password;

	// Login Button
	@FindBy(how = How.XPATH, using = "//*[@name='submitBtn']")
	public static WebElement btn_admin_Login;

	@FindBy(how = How.XPATH, using = "//*[text()='Admin']")
	public static WebElement admin_text;
	/*************************************************
	 * 
	 * 
	 * Function Name:Admin_Login
	 * 
	 * Purpose:-This Function is used to login into the Bank Application as a
	 * admin when ever the user is required
	 * 
	 * Input Parameters:- NA
	 * 
	 * Output Parameters:-This method will return a boolean value stating
	 * whether user is logined or not
	 * 
	 * Author:- K.Umakanth
	 * 
	 * Creation date:-04/05/2018(dd/mm/yyyy)
	 * 
	 * 
	 **************************************************/
	public static SoftAssert asrt = new SoftAssert();

	public static boolean Admin_Login() {
		boolean status = true;

		// Click on Admin link
		status = hoverAndClick(lnk_admin_Admin);

		// Enter Username

		String username = getCommontestdata("Username");
		status = setdata(edi_admin_Username, username);

		// Enter password
		String password = getCommontestdata("Password");
		status = setdata(edi_admin_password, password);

		// Based on the Password status Click on the Login Button
		status = hoverAndClick(btn_admin_Login);

		String str = admin_text.getText();

		asrt.assertEquals(str, "admin_text", "login success");

		return status;

	}

}
