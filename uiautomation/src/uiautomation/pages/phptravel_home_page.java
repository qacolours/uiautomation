package uiautomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import uiautomation.listners.listnerfunctions;
import uiautomation.utils.reusable_user_actions;

public class phptravel_home_page {
	
	listnerfunctions oLF = new listnerfunctions();
	reusable_user_actions oUA = new reusable_user_actions();
	
	
	public void LogoutFromApplication_phptravels(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		if (param_Browser.getCurrentUrl().equalsIgnoreCase("https://www.phptravels.net/account/dashboard")) {
			oLF.waitUntilObjectExists(param_Browser, "lnk_Logout_php", logger);
			
			if (oLF.findElements(param_Browser, "lnk_Logout_php").size() != 0) {
				oLF.findElement(param_Browser, "lnk_Logout_php").click();
				
				String ssname = oUA.captureScreenshot(param_Browser,"LogoutFromApplication_phptravels");
				
				extent_report.log(LogStatus.PASS,"Step LogoutFromApplication_phptravels executed successfully", extent_report.addScreenCapture(ssname));
				logger.info("Step LogoutFromApplication_phptravels executed successfully");
			} else {
				String ssname = oUA.captureScreenshot(param_Browser,"LogoutFromApplication_phptravels");
				
				extent_report.log(LogStatus.FAIL,"Logout link is not visible in the page", extent_report.addScreenCapture(ssname));
				logger.error("Logout link is not visible in the page");
				
				throw new Exception("Logout link is not visible in the page");
			}
		} else {
			oLF.waitUntilObjectExists(param_Browser, "btn_Account", logger);
			
			if (oLF.findElements(param_Browser, "btn_Account").size() != 0) {
				oLF.findElement(param_Browser, "btn_Account").click();
				oLF.implicitWait(param_Browser, extent_report, 2);
				oLF.findElement(param_Browser, "lnk_Logout").click();
				
				String ssname = oUA.captureScreenshot(param_Browser,"LogoutFromApplication_phptravels");
				
				extent_report.log(LogStatus.PASS,"Step LogoutFromApplication_phptravels executed successfully", extent_report.addScreenCapture(ssname));
				logger.info("Step LogoutFromApplication_phptravels executed successfully");
			} else {
				String ssname = oUA.captureScreenshot(param_Browser,"LogoutFromApplication_phptravels");
				
				extent_report.log(LogStatus.FAIL,"Logout link is not visible in the page", extent_report.addScreenCapture(ssname));
				logger.error("Logout link is not visible in the page");
				
				throw new Exception("Logout link is not visible in the page");
			}
		}
		
	}
	
	public void ValidateLogout_phptravels(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		oLF.waitUntilObjectExists(param_Browser, "lnk_Login_php", logger);
		
		if (oLF.findElements(param_Browser, "lnk_Login_php").size() != 0) {
			
			String ssname = oUA.captureScreenshot(param_Browser,"ValidateLogout_phptravels");
			
			extent_report.log(LogStatus.PASS,"Step ValidateLogout_phptravels executed successfully", extent_report.addScreenCapture(ssname));
			logger.info("Step ValidateLogout_phptravels executed successfully");
			
		} else {
			String ssname = oUA.captureScreenshot(param_Browser,"ValidateLogout_phptravels");
			
			extent_report.log(LogStatus.FAIL,"User not logged out of the system", extent_report.addScreenCapture(ssname));
			logger.error("User not logged out of the system");
			
			throw new Exception("User not logged out of the system");
		}
		
	}

}
