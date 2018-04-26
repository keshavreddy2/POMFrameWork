package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Admin extends GenericFunctions{

	
	
//Adminlink
	@FindBy(how=How.XPATH,using="//*[text()='Add Customer']")
	public static WebElement addcstrlink;

	
//Customername
	@FindBy(how=How.NAME, using ="customer_name")
	public static WebElement  add_customername;
			
//Gender	
	@FindBy(how=How.XPATH,using="//*[@name='customer_gender'][1]")
	public static WebElement add_Gender;
	
	
//DOB
	@FindBy(how=How.NAME,using="customer_dob")		
	public static WebElement add_DOB;
	
//Nominee
	@FindBy(how=How.NAME,using="customer_nominee")		
	public static WebElement add_Nominee;
		
//Branch
	@FindBy(how=How.XPATH, using ="//*[@name='branch']/option[3]")			
	public static WebElement  add_Branch;
				
//Account type
	@FindBy(how=How.XPATH,using="//*[@name='customer_account']/option[1]")
	public static WebElement add_Account_type;
		
		
//Minimum balance
	@FindBy(how=How.NAME,using="initial")
	public static WebElement add_Minimum_balance;	
		
//Address
	@FindBy(how=How.NAME,using="customer_address")
	public static WebElement add_Address;

		
//Mobile
	@FindBy(how=How.NAME, using ="customer_mobile")
	public static WebElement  add_Mobile;
				
//Email id		
	@FindBy(how=How.NAME,using="customer_email")
	public static WebElement add_Email_id	;
		
		
//Password
	@FindBy(how=How.NAME,using="customer_pwd")
	public static WebElement add_Password;	

//Add Customer button
	@FindBy(how=How.NAME,using="add_customer")
	public static WebElement Add_Customer_button;	
	
	
	
	
	
		
	public static boolean add_customer()
	{
		boolean status=true;
		
		//click on the Add Customer Link
		status=hoverAndClick(addcstrlink);
	    if( status)
	    {
		   System.out.println(" add customer link is clicked successfully");	
		   logEvent("pass", "add customer link is not clicked successfully");
	    }
	    
	    else
	    {
	    	System.out.println(" add customer link is not clicked successfully");	
	    	logEvent("fail", "add customer link is not clicked successfully");
	    }
	    		
									
	     //get the customer name from the testdata sheet	
		String cstrname = getdata("Testcases", "Customername", 1);
		status=setdata(add_customername, cstrname);		
		if( status)
	    {
		   System.out.println(" add customer name is entered successfully");	
		   logEvent("pass", "add customer name is entered successfully");
	    }
	    
	    else
	    {
	    	System.out.println(" add customer link is not entered successfully");	
	    	logEvent("fail", "add customer link is not entered successfully");
	    }
	    		
		
		
		//get the DOB  from the testdata sheet	
		String dob = getdata("Testcases", "DOB", 1);
		status=setdata(add_DOB, dob);				
		if( status)
	    {
		   System.out.println(" add customer dob is entered successfully");	
		   logEvent("pass", "add customer dob is entered successfully");
	    }
	    
	    else
	    {
	    	System.out.println(" aadd customer dob is not entered successfully");	
	    	logEvent("fail", "add customer dob is not entered successfully");
	    }
	    			
		
				
		//get the nominee  from the testdata sheet	
		String nominee = getdata("Testcases", "Nominee", 1);
		status=setdata(add_Nominee, nominee);			
		if( status)
	    {
		   System.out.println(" add customer Nominee is entered successfully");	
		   logEvent("pass", "add customer Nominee is entered successfully");
	    }
	    
	    else
	    {
	    	System.out.println(" aadd customer Nominee is not entered successfully");	
	    	logEvent("fail", "add customer Nominee is not entered successfully");
	    }	
		
		
		//get the Minimum_balance from the testdata sheet	
		String Min_balance = getdata("Testcases", "Minimum_balance", 1);
		status=setdata(add_Minimum_balance, Min_balance);			
		if( status)
	    {
		   System.out.println(" add customer Minimum_balance is entered successfully");	
		   logEvent("pass", "add customer Minimum_balance is entered successfully");
	    }
	    
	    else
	    {
	    	System.out.println(" aadd customer Minimum_balance is not entered successfully");	
	    	logEvent("fail", "add customer Minimum_balance is not entered successfully");
	    }	
		
		
		
		
		//get aAddress from the testdata sheet	
		String add_Addr = getdata("Testcases", "Address", 1);
		status=setdata(add_Address, add_Addr);
		if( status)
	    {
		   System.out.println(" add customer Address is entered successfully");	
		   logEvent("pass", "add customer Address is entered successfully");
	    }
	    
	    else
	    {
	    	System.out.println(" aadd customer Address is not entered successfully");	
	    	logEvent("fail", "add customer Address is not entered successfully");
	    }	
		
		
		//get Mobile from the testdata sheet	
		String add_Mobilenum = getdata("Testcases", "Mobile", 1);
		status=setdata(add_Mobile, add_Mobilenum);
		if( status)
	    {
		   System.out.println(" add customer Mobile is entered successfully");	
		   logEvent("pass", "add customer Mobile is entered successfully");
	    }
	    
	    else
	    {
	    	System.out.println(" aadd customer Mobile is not entered successfully");	
	    	logEvent("fail", "add customer Mobile is not entered successfully");
	    }	
		
		
		
		//get Email from the testdata sheet	
		String add_Email = getdata("Testcases", "Email_id", 1);
		status=setdata(add_Email_id, add_Email);
		if( status)
	    {
		   System.out.println(" add customer Email_id is entered successfully");	
		   logEvent("pass", "add customer Email_id is entered successfully");
	    }
	    
	    else
	    {
	    	System.out.println(" aadd customer Email_id is not entered successfully");	
	    	logEvent("fail", "add customer Email_id is not entered successfully");
	    }	
		
		
		//get Password from the testdata sheet	
		String add_Pw = getdata("Testcases", "Password", 1);
		status=setdata(add_Password, add_Pw);
		if( status)
	    {
		   System.out.println(" add customer Password is entered successfully");	
		   logEvent("pass", "add customer Password is entered successfully");
	    }
	    
	    else
	    {
	    	System.out.println(" aadd customer Password is not entered successfully");	
	    	logEvent("fail", "add customer Password is not entered successfully");
	    }	
		
		//click on the Add_Customer-button
		status=hoverAndClick(Add_Customer_button);
		if( status)
	    {
		   System.out.println(" add customer Customer_button is entered successfully");	
		   logEvent("pass", "add customer Customer_button is entered successfully");
	    }
	    
	    else
	    {
	    	System.out.println(" aadd customer Customer_button is not entered successfully");	
	    	logEvent("fail", "add customer Customer_button is not entered successfully");
	    }		
		return status;
	}
		
		
		
}
