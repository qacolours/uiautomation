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

public class login_page {
	
	listnerfunctions oLF = new listnerfunctions();
	reusable_user_actions oUA = new reusable_user_actions();
	
	public void clickOnLogin(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		oLF.waitUntilObjectExists(param_Browser, "lnk_Login", logger);
		
		if (oLF.findElements(param_Browser, "lnk_Login").size() != 0) {
			oLF.findElement(param_Browser, "lnk_Login").click();
			
			extent_report.log(Status.PASS,"Step clickOnLogin executed successfully");
			logger.info("Step clickOnLogin executed successfully");
			
		} else {
			extent_report.log(Status.FAIL,"Login link is not visible in the page");
			logger.error("Login link is not visible in the page");
			
			throw new Exception("Login link is not visible in the page");
		}
	}
	
	public void loginToApplication(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		oLF.waitUntilObjectExists(param_Browser, "txtbx_Username", logger);
		
		if (oLF.findElements(param_Browser, "txtbx_Username").size() != 0) {
			oLF.findElement(param_Browser, "txtbx_Username").sendKeys("qalabs");
			oLF.findElement(param_Browser, "txtbx_Password").sendKeys("test123");
			oLF.findElement(param_Browser, "btn_Login").click();
			
			oUA.implicitWait(param_Browser, extent_report, 5000);
			
			extent_report.log(Status.PASS,"Step loginToApplication executed successfully");
			logger.info("Step loginToApplication executed successfully");
			
		} else {
			extent_report.log(Status.FAIL,"UserName field is not visible in the page");
			logger.error("UserName field is not visible in the page");
			
			throw new Exception("UserName field is not visible in the page");
		}
		
	}
	
	public void validateLogin(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		oLF.waitUntilObjectExists(param_Browser, "lnk_LoggedInUserName", logger);
		
		if (oLF.findElements(param_Browser, "lnk_LoggedInUserName").size() != 0) {
			if (oLF.findElement(param_Browser, "lnk_LoggedInUserName").getText().equalsIgnoreCase("Welcome qalabs")) {
				
				String ssname = oUA.captureScreenshot(param_Browser,"ValidateLogin");
				extent_report.log(Status.PASS,"User has been logged in successfully", MediaEntityBuilder.createScreenCaptureFromPath(ssname).build());
				logger.info("User has been logged in successfully");
				
				extent_report.log(Status.PASS,"Step validateLogin executed successfully");
				logger.info("Step validateLogin executed successfully");
				
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
	public void loginToApplicationWithoutInputs(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		oLF.waitUntilObjectExists(param_Browser, "txtbx_Username", logger);
		
		if (oLF.findElements(param_Browser, "txtbx_Username").size() != 0) {
			
			oLF.findElement(param_Browser, "txtbx_Username").sendKeys("");
			oLF.findElement(param_Browser, "btn_Login").click();
			oLF.validateWindowAlertMessage(param_Browser, "Please fill out Username and Password.", logger);
			oLF.acceptWindowAlert(param_Browser, logger);
			
			oUA.implicitWait(param_Browser, extent_report, 5000);
			
			oLF.findElement(param_Browser, "txtbx_Username").sendKeys("qalabs");
			oLF.findElement(param_Browser, "btn_Login").click();
			oLF.validateWindowAlertMessage(param_Browser, "Please fill out Username and Password.", logger);
			oLF.acceptWindowAlert(param_Browser, logger);
			
			oUA.implicitWait(param_Browser, extent_report, 5000);
			
			oLF.findElement(param_Browser, "btn_Close").click();
			
			oUA.implicitWait(param_Browser, extent_report, 5000);
			
			extent_report.log(Status.PASS,"Login UserName and Password error scenario validated successfully");
			logger.info("Login UserName and Password error scenario validated successfully");
			
		} else {
			extent_report.log(Status.FAIL,"Login UserName and Password error scenario validated with error");
			logger.error("Login UserName and Password error scenario validated with error");
			
			throw new Exception("Login UserName and Password error scenario validated with error");
		}
		
	}

}
