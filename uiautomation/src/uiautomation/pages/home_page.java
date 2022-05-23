package uiautomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import uiautomation.listners.listnerfunctions;
import uiautomation.utils.reusable_user_actions;

public class home_page {
	
	listnerfunctions oLF = new listnerfunctions();
	reusable_user_actions oUA = new reusable_user_actions();
	
	
	public void LogoutFromApplication(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		oLF.waitUntilObjectExists(param_Browser, "lnk_Logout", logger);
		
		if (oLF.findElements(param_Browser, "lnk_Logout").size() != 0) {
			oLF.findElement(param_Browser, "lnk_Logout").click();
			
			String ssname = oUA.captureScreenshot(param_Browser,"LogoutFromApplication");
			
			extent_report.log(LogStatus.PASS,"Step LogoutFromApplication executed successfully", extent_report.addScreenCapture(ssname));
			logger.info("Step LogoutFromApplication executed successfully");
		} else {
			String ssname = oUA.captureScreenshot(param_Browser,"LogoutFromApplication");
			
			extent_report.log(LogStatus.FAIL,"Logout link is not visible in the page", extent_report.addScreenCapture(ssname));
			logger.error("Logout link is not visible in the page");
			
			throw new Exception("Logout link is not visible in the page");
		}
		
	}
	
	public void ValidateLogout(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		oLF.waitUntilObjectExists(param_Browser, "lnk_Login", logger);
		
		if (oLF.findElements(param_Browser, "lnk_Login").size() != 0) {
			
			String ssname = oUA.captureScreenshot(param_Browser,"ValidateLogout");
			
			extent_report.log(LogStatus.PASS,"Step ValidateLogout executed successfully", extent_report.addScreenCapture(ssname));
			logger.info("Step ValidateLogout executed successfully");
			
		} else {
			String ssname = oUA.captureScreenshot(param_Browser,"ValidateLogout");
			
			extent_report.log(LogStatus.FAIL,"User not logged out of the system", extent_report.addScreenCapture(ssname));
			logger.error("User not logged out of the system");
			
			throw new Exception("User not logged out of the system");
		}
		
	}

}
