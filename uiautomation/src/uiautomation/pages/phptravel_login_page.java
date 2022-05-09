package uiautomation.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import javax.print.attribute.standard.OutputDeviceAssigned;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import uiautomation.listners.listnerfunctions;
import uiautomation.utils.reusable_user_actions;

public class phptravel_login_page {
	
	listnerfunctions oLF = new listnerfunctions();
	reusable_user_actions oUA = new reusable_user_actions();
	
	public void clickOnLogin_phptravels(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		oLF.waitUntilObjectExists(param_Browser, "lnk_Login_php", logger);
		
		if (oLF.findElements(param_Browser, "lnk_Login_php").size() != 0) {
			oLF.findElement(param_Browser, "lnk_Login_php").click();
			
			extent_report.log(Status.PASS,"Step clickOnLogin_phptravels executed successfully");
			logger.info("Step clickOnLogin_phptravels executed successfully");
			
		} else {
			extent_report.log(Status.FAIL,"Login link is not visible in the page");
			logger.error("Login link is not visible in the page");
			
			throw new Exception("Login link is not visible in the page");
		}
	}
	
	public void loginToApplication_phptravels(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		oLF.waitUntilObjectExists(param_Browser, "txtbx_Username_php", logger);
		
		if (oLF.findElements(param_Browser, "txtbx_Username_php").size() != 0) {
			
			oLF.findElement(param_Browser, "txtbx_Username_php").sendKeys("user@phptravels.com");
			oLF.findElement(param_Browser, "txtbx_Password_php").sendKeys("demouser");
			oLF.findElement(param_Browser, "btn_Login_php").click();
			
			//Thread.sleep(5000);
			oUA.implicitWait(param_Browser, extent_report, 5000);
			
			extent_report.log(Status.PASS,"Step loginToApplication_phptravels executed successfully");
			logger.info("Step loginToApplication_phptravels executed successfully");
			
		} else {
			extent_report.log(Status.FAIL,"UserName field is not visible in the page");
			logger.error("UserName field is not visible in the page");
			
			throw new Exception("UserName field is not visible in the page");
		}
		
	}
	
	public void validateLogin_phptravels(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		oLF.waitUntilObjectExists(param_Browser, "lnk_LoggedInUserName_php", logger);
		
		if (oLF.findElements(param_Browser, "lnk_LoggedInUserName_php").size() != 0) {
						
			/*NOTE:: if getText() does not work in some case, specially for object type link with tag a, then use the function getAttribute("innerHTML").
			param_Browser.findElement(By.id("nameofuser")).getAttribute("innerHTML") instead of param_Browser.findElement(By.id("nameofuser")).getText()*/
			
			if (oLF.findElement(param_Browser, "lnk_LoggedInUserName_php").getText().equalsIgnoreCase("Demo")) {
				
				String ssname = oUA.captureScreenshot(param_Browser,"ValidateLogin_php");
				//extent_report.log(Status.PASS,"User has been logged in successfully " + extent_report.addScreenCaptureFromPath(ssname));
				extent_report.log(Status.PASS,"User has been logged in successfully", MediaEntityBuilder.createScreenCaptureFromPath(ssname).build());
				logger.info("User has been logged in successfully");
				
				extent_report.log(Status.PASS,"Step validateLogin_phptravels executed successfully");
				logger.info("Step validateLogin_phptravels executed successfully");
				
			} else {
				
				extent_report.log(Status.FAIL,"User not logged in successfully");
				logger.error("User not logged in successfully");
			}
			
		} else {
			
			extent_report.log(Status.FAIL,"Logged in user name link is not visible in the page");
			logger.error("Logged in user name link is not visible in the page");
			
			throw new Exception("Logged in user name link is not visible in the page");
		}
		
	}
	
	/**
	 *Javadoc comment
	 * @param param_Browser
	 * @param extent_report
	 * @param logger
	 * @throws Exception
	 */
	public void loginToApplicationWithoutInputs_phptravels(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		oLF.waitUntilObjectExists(param_Browser, "txtbx_Username_php", logger);
		
		if (oLF.findElements(param_Browser, "txtbx_Username_php").size() != 0) {
			
			oLF.findElement(param_Browser, "txtbx_Username_php").sendKeys("");
			oLF.findElement(param_Browser, "btn_Login_php").click();
			
			if (oLF.findElement(param_Browser, "txtbx_Username_php").getAttribute("validationMessage").equalsIgnoreCase("Please fill out this field.")) {
				extent_report.log(Status.INFO,"Error message for email field getting showed successfully");
				logger.info("Error message for email field getting showed successfully");
			} else {
				extent_report.log(Status.FAIL,"Error message for email field not getting showed properly");
				logger.info("Error message for email field not getting showed properly");
			}
			
			oUA.implicitWait(param_Browser, extent_report, 5000);
			
			oLF.findElement(param_Browser, "txtbx_Username_php").sendKeys("user@phptravels.com");
			oLF.findElement(param_Browser, "btn_Login_php").click();
			
			if (oLF.findElement(param_Browser, "txtbx_Password_php").getAttribute("validationMessage").equalsIgnoreCase("Please fill out this field.")) {
				extent_report.log(Status.INFO,"Error message for password field getting showed successfully");
				logger.info("Error message for password field getting showed successfully");
			} else {
				extent_report.log(Status.FAIL,"Error message for password field not getting showed properly");
				logger.info("Error message for password field not getting showed properly");
			}
			
			oLF.validateWindowAlertMessage(param_Browser, "Please fill out Username and Password.", logger);
			oLF.acceptWindowAlert(param_Browser, logger);
			
			oUA.implicitWait(param_Browser, extent_report, 5000);
			
			extent_report.log(Status.PASS,"PHPTravels Login UserName and Password error scenario validated successfully");
			logger.info("PHPTravels Login UserName and Password error scenario validated successfully");
			
		} else {
			extent_report.log(Status.FAIL,"PHPTravels Login UserName and Password error scenario validated with error");
			logger.error("PHPTravels Login UserName and Password error scenario validated with error");
			
			throw new Exception("PHPTravels Login UserName and Password error scenario validated with error");
		}
		
	}

}
