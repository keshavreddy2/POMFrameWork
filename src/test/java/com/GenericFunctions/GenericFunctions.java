
package com.GenericFunctions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class GenericFunctions extends TestNGListeners {

	public static WebDriver driver;

	/*************************************************
	 * 
	 * 
	 * Function Name:launchApplication
	 * 
	 * Purpose:-This Function is used to launch the HRM Application when ever
	 * the user is required
	 * 
	 * Input Parameters:-User must send in which browser does the application
	 * need to be launch
	 * 
	 * Output Parameters:-This method will return a boolean value stating
	 * whether the user logged into in the system
	 * 
	 * Author:-Veera Prathap Malepati
	 * 
	 * Creationn date:-12/30/2017
	 * 
	 * 
	 **************************************************/

	public static boolean launchApplication(String browser) {

		boolean status = true;

		switch (browser.toLowerCase()) {
		case "ie":

			break;

		case "firefox":

			driver = new FirefoxDriver();

			String url = getCommontestdata("Url");

			System.out.println(url);

			driver.get(url);

			driver.manage().window().maximize();

			// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\tm\\Downloads\\chromedriver.exe");

			driver = new ChromeDriver();
			String url1 = getCommontestdata("Url");
			System.out.println(url1);
			driver.manage().window().maximize();

			break;

		default:
			break;
		}

		return status;

	}

	/*************************************************
	 * 
	 * 
	 * Function Name:GetCommonTestdata
	 * 
	 * Purpose:-This Function is used to get the common test data which can be
	 * accessed commonly for each testcase such as
	 * Environment,Url,Username,Password
	 * 
	 * Input Parameters:-User must send an argument stating what data that is
	 * required
	 * 
	 * Output Parameters:-This method will return a string value for the User
	 * given input(If data is not found it will return a null)
	 * 
	 * Author:-Veera Prathap Malepati
	 * 
	 * Creationn date:-12/31/2017
	 * 
	 * 
	 **************************************************/

	public static String getCommontestdata(String data) {

		String strQuery = "Select " + data + " from CommonTestdata";

		System.out.println(strQuery);

		Recordset recordset;

		String fetcheddata = "";

		try {

			recordset = TestNGListeners.connection.executeQuery(strQuery);

			while (recordset.next()) {

				System.out.println("Data is found and the data is " + recordset.getField(data));

				fetcheddata = recordset.getField(data);
				break;

			}

			recordset.close();

		} catch (FilloException e) {

			System.out.println("No Records Found");
		}

		return fetcheddata;

	}

	/*************************************************
	 * 
	 * 
	 * Function Name:getdata
	 * 
	 * Purpose:-This Function is used to Get the data from Excel when ever the
	 * user is required
	 * 
	 * Input Parameters:- Excel
	 * 
	 * Output Parameters:-This method will give a String output
	 * 
	 * Author:-Veera Prathap Malepati
	 * 
	 * Creationn date:-12/30/2017
	 * 
	 * 
	 **************************************************/

	public static String getdata(String sheetname, String userdata, int itr) {

		String strQuery = "Select " + userdata + " from " + sheetname + " where Tc_Name='" + crntclass
				+ "' and Iteration=" + itr;
		System.out.println(strQuery);

		Recordset recordset;

		String fetcheddata = "";

		try {

			recordset = TestNGListeners.connection.executeQuery(strQuery);

			while (recordset.next()) {

				System.out.println("Data is found and the data is " + recordset.getField(userdata));

				fetcheddata = recordset.getField(userdata);
				break;

			}

			recordset.close();

		} catch (FilloException e) {

			System.out.println("No Records Found");
		}

		return fetcheddata;

	}

	/*************************************************
	 * 
	 * 
	 * Function Name:waitForElement
	 * 
	 * Purpose:-This Function is used to Wait for the element to procede further
	 * 
	 * Input Parameters:- Webelement
	 * 
	 * Output Parameters:-This method will return a boolean value stating
	 * whether the user logged into in the system
	 * 
	 * Author:-Veera Prathap Malepati
	 * 
	 * Creation date:-12/30/2017
	 * 
	 * 
	 **************************************************/

	public static boolean waitForElement(WebElement element) {
		boolean status = true;
		for (int i = 1; i <= 10; i++) {
			try {
				status = true;
				System.out.println("Wait is executing");
				Actions acc = new Actions(driver);
				acc.moveToElement(element).build().perform();

				System.out.println("Element Found");
				break;

			} catch (Exception e) {
				status = false;
				try {
					Thread.sleep(1000);

				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}

			}
		}
		return status;
	}

	/*************************************************
	 * 
	 * 
	 * Function Name:hoverAndClick
	 * 
	 * Purpose:-This Function is used to Mousehover and click
	 * 
	 * Input Parameters:- Webelement
	 * 
	 * Output Parameters:-This method will return a boolean value stating
	 * whether the user logged into in the system
	 * 
	 * Author:-Veera Prathap Malepati
	 * 
	 * Creation date:-12/30/2017
	 * 
	 * 
	 **************************************************/

	public static boolean hoverAndClick(WebElement element) {
		boolean status = true;

		try {
			waitForElement(element);
			Actions acc = new Actions(driver);
			acc.moveToElement(element).click().build().perform();

		} catch (Exception e) {

			status = false;

		}

		return status;
	}

	/*************************************************
	 * 
	 * 
	 * Function Name:forceClick
	 * 
	 * Purpose:-This Function is used to Force click element
	 * 
	 * Input Parameters:- Webelement
	 * 
	 * Output Parameters:-
	 * 
	 * Author:-Veera Prathap Malepati
	 * 
	 * Creation date:-12/30/2017
	 * 
	 * 
	 **************************************************/

	public static void forceClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);

	}

	/*************************************************
	 * 
	 * 
	 * Function Name: setdata
	 * 
	 * Purpose:-This Function is used to Set the data from excel
	 * 
	 * Input Parameters:- Excel Sheet
	 * 
	 * Output Parameters:-This method will return a boolean value whether the
	 * data is entered or not
	 * 
	 * Author:-K.Umakanth
	 * 
	 * Creation date:- 04/05/2018(dd/mm/yyyy)
	 * 
	 * 
	 **************************************************/

	public static boolean setdata(WebElement element, String data) {
		boolean status = true;

		try {
			waitForElement(element);
			element.click();
			element.clear();
			element.sendKeys(data);

		} catch (Exception e) {

			status = false;

		}

		return status;
	}

	/*************************************************
	 * 
	 * 
	 * Function Name: Selectlistbox
	 * 
	 * Purpose:-This Function is used to Mousehover and click
	 * 
	 * Input Parameters:- Webelement
	 * 
	 * Output Parameters:-This method will return a boolean value stating
	 * whether the user logged into in the system
	 * 
	 * Author:-Veera Prathap Malepati
	 * 
	 * Creation date:-12/30/2017
	 * 
	 * 
	 **************************************************/

	public static boolean Selectlistbox(WebElement element, String data) {
		boolean status = true;

		try {
			waitForElement(element);
			Select slct = new Select(element);
			slct.selectByVisibleText(data);

		} catch (Exception e) {

			status = false;

		}

		return status;
	}

	/*************************************************
	 * }
	 */

	/*************************************************
	 * 
	 * 
	 * Function Name: admin_logout
	 * 
	 * Purpose:-This Function is used to Add Staff details
	 * 
	 * Input Parameters:-
	 * 
	 * Output Parameters:-This method will return a boolean value whether the
	 * data is entered or not
	 * 
	 * Author:-K.Umakanth
	 * 
	 * Creation date:- 04/05/2018(dd/mm/yyyy)
	 * 
	 * 
	 **************************************************/

	public static boolean admin_logout(WebElement elemt) {
		boolean status = true;

		try {
			status = hoverAndClick(elemt);
		} catch (Exception e) {

			status = false;

		}

		return status;

	}

	public static boolean getdeletedata(String name, String email) {
		boolean status = true;
		WebElement lts = driver.findElement(By.xpath("//td[text()='" + name + "']/following-sibling::td[8]/preceding-sibling::td[9]"));
		status = hoverAndClick(lts);

		if (status)
		{
			System.out.println("Radio button is selected for perticuler record");
		}
		else
		{
			System.out.println("Radio button is not selected for perticuler record");
		}

		return status;

	}
}
