package uiautomation.main;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import uiautomation.listners.listnerfunctions;
import uiautomation.pages.home_page;
import uiautomation.pages.login_page;
import uiautomation.pages.phptravel_home_page;
import uiautomation.pages.phptravel_hotel_booking_page;
import uiautomation.pages.phptravel_login_page;
import uiautomation.utils.business_actions;
import uiautomation.utils.reusable_user_actions;

public class testcases {
	
	WebDriver oBrowser;
	
	business_actions oBA = new business_actions();
	login_page oLogin = new login_page();
	home_page oHome = new home_page();
	phptravel_login_page oLogin_php = new phptravel_login_page();
	phptravel_home_page oHome_php = new phptravel_home_page();
	phptravel_hotel_booking_page oHotels_php = new phptravel_hotel_booking_page();
	listnerfunctions oLF = new listnerfunctions();
	reusable_user_actions oUA = new reusable_user_actions();
	
	ExtentReports reports;
	
	
	testcases() throws Exception {
		reports = new ExtentReports(System.getProperty("user.dir") + oUA.getProperty("extent_report_path"), true);
	}
	
	public String TestCase_1(int iRowIterator,Logger logger) {
		
		String TCExecutionStatus = null;
		
		ExtentTest ex_tc1 = reports.startTest("TestCase_1");
		
		try {
            String strtDate =  oUA.getCurrentDate("no");
			
            ex_tc1.log(LogStatus.INFO,"Test Case 1 started at " + strtDate);
			logger.info("Test Case 1 started at " + strtDate);
			
			oBrowser = oBA.openApplication(iRowIterator,ex_tc1,logger);
			oLogin.clickOnLogin(oBrowser,ex_tc1,logger);
			oLogin.loginToApplication(oBrowser,ex_tc1,logger);
			oLogin.validateLogin(oBrowser,ex_tc1,logger);
			oHome.LogoutFromApplication(oBrowser,ex_tc1,logger);
			oHome.ValidateLogout(oBrowser,ex_tc1,logger);
			oBA.closeApplication(oBrowser,ex_tc1,logger);
            
            String endDate =  oUA.getCurrentDate("no");
            
            ex_tc1.log(LogStatus.INFO,"Test Case 1 completed at " + endDate);
			logger.info("Test Case 1 completed at " + endDate);
			
			ex_tc1.log(LogStatus.PASS,"Test Case 1 passed successfully");
			logger.info("Test Case 1 passed successfully");
			
			TCExecutionStatus = "Pass";
			
		} catch (Exception e) {
			ex_tc1.log(LogStatus.FAIL,"TestCase_1 ran with failure");
			logger.error("TestCase_1 ran with failure");
			
			TCExecutionStatus = "Fail";
		}
		
		reports.endTest(ex_tc1);
		reports.flush();
		return TCExecutionStatus;
	}
	
	public String TestCase_2(int iRowIterator,Logger logger) {
		String TCExecutionStatus = null;
		
		ExtentTest ex_tc2 = reports.startTest("TestCase_2");
		
		try {
			String strtDate = oUA.getCurrentDate("no");
			
            ex_tc2.log(LogStatus.INFO,"Test Case 2 started at " + strtDate);
			logger.info("Test Case 2 started at " + strtDate);
			
			oBrowser = oBA.openApplication(iRowIterator,ex_tc2,logger);
			oHome.ValidateLogout(oBrowser,ex_tc2,logger);
			oBA.closeApplication(oBrowser,ex_tc2,logger);
			
			String endDate = oUA.getCurrentDate("no");
            
			ex_tc2.log(LogStatus.INFO,"Test Case 2 completed at " + endDate);
			logger.info("Test Case 2 completed at " + endDate);
			
			ex_tc2.log(LogStatus.PASS,"Test Case 2 passed successfully");
			logger.info("Test Case 2 passed successfully");
			
			TCExecutionStatus = "Pass";
			
		} catch (Exception e) {			
			ex_tc2.log(LogStatus.FAIL,"TestCase_2 ran with failure");
			logger.error("TestCase_2 ran with failure");
			
			TCExecutionStatus = "Fail";
		}
		
		reports.endTest(ex_tc2);
		reports.flush();
		return TCExecutionStatus;
		
	}
	
	public String TestCase_3(int iRowIterator,Logger logger) {
		String TCExecutionStatus = null;
		
		try {
			
			logger.info("Information Message Test Case 3");
			logger.warn("Warning Message Test Case 3");
			logger.error("Error Message Test Case 3");
			logger.fatal("Fatal Message Test Case 3");
			
			TCExecutionStatus = "Pass";
			
		} catch (Exception e) {
			System.out.println("TestCase_2_23Mar2022 not run successfully");
			
			TCExecutionStatus = "Fail";
		}
		
		reports.flush();
		return TCExecutionStatus;
	}
	
	public String TestCase_4(int iRowIterator,Logger logger) {
		String TCExecutionStatus = null;
		
		ExtentTest ex_tc4 = reports.startTest("TestCase_4");
		
		try {
			String strtDate = oUA.getCurrentDate("no");
			
            ex_tc4.log(LogStatus.INFO,"Test Case 4 started at " + strtDate);
			logger.info("Test Case 4 started at " + strtDate);
			
			oBrowser = oBA.openApplication(iRowIterator,ex_tc4,logger);
			oLogin.clickOnLogin(oBrowser,ex_tc4,logger);
			oLogin.loginToApplicationWithoutInputs(oBrowser, ex_tc4, logger);
			oBA.closeApplication(oBrowser,ex_tc4,logger);
			
			String endDate = oUA.getCurrentDate("no");
            
            ex_tc4.log(LogStatus.INFO,"Test Case 4 completed at " + endDate);
			logger.info("Test Case 4 completed at " + endDate);
			
			ex_tc4.log(LogStatus.PASS,"Test Case 4 passed successfully");
			logger.info("Test Case 4 passed successfully");
			
			TCExecutionStatus = "Pass";
			
		} catch (Exception e) {
			ex_tc4.log(LogStatus.FAIL,"TestCase_4 ran with failure");
			logger.error("TestCase_4 ran with failure");
			
			TCExecutionStatus = "Fail";
		}
		
		reports.endTest(ex_tc4);
		reports.flush();
		return TCExecutionStatus;
	}
	
	public String TestCase_5(int iRowIterator,Logger logger) {
		String TCExecutionStatus = null;
		
		ExtentTest ex_tc5 = reports.startTest("TestCase_5");
		
		try {
			String strtDate = oUA.getCurrentDate("no");
			
            ex_tc5.log(LogStatus.INFO,"Test Case 5 started at " + strtDate);
			logger.info("Test Case 5 started at " + strtDate);
			
			oBrowser = oBA.openApplication(iRowIterator,ex_tc5,logger);
			oUA.flashElementInUI(oBrowser, "lnk_Login");
			oBA.closeApplication(oBrowser, ex_tc5, logger);
			
			String endDate = oUA.getCurrentDate("no");
            
			ex_tc5.log(LogStatus.INFO,"Test Case 5 completed at " + endDate);
			logger.info("Test Case 5 completed at " + endDate);
			
			ex_tc5.log(LogStatus.PASS,"Test Case 5 passed successfully");
			logger.info("Test Case 5 passed successfully");
			
			TCExecutionStatus = "Pass";
		} catch (Exception e) {
			ex_tc5.log(LogStatus.FAIL,"TestCase_5 ran with failure");
			logger.error("TestCase_5 ran with failure");
			
			TCExecutionStatus = "Fail";
		}
		
		reports.endTest(ex_tc5);
		reports.flush();
		return TCExecutionStatus;
	}
	
	
	public String TestCase_6(int iRowIterator,Logger logger) {
		
		String TCExecutionStatus = null;
		
		ExtentTest ex_tc6 = reports.startTest("TestCase_6");
		
		try {
			
			String strtDate =  oUA.getCurrentDate("no");
			
			ex_tc6.log(LogStatus.INFO,"Test Case 6 started at " + strtDate);
			logger.info("Test Case 6 started at " + strtDate);
			
			oBrowser = oBA.openApplication(iRowIterator,ex_tc6,logger);
			oLogin_php.loginToApplication_phptravels(oBrowser,ex_tc6,logger);
			oLogin_php.validateLogin_phptravels(oBrowser,ex_tc6,logger);
			oHome_php.LogoutFromApplication_phptravels(oBrowser,ex_tc6,logger);
			oHome_php.ValidateLogout_phptravels(oBrowser,ex_tc6,logger);
			oBA.closeApplication(oBrowser,ex_tc6,logger);
            
            String endDate =  oUA.getCurrentDate("no");
            
            ex_tc6.log(LogStatus.INFO,"Test Case 6 completed at " + endDate);
			logger.info("Test Case 6 completed at " + endDate);
			
			ex_tc6.log(LogStatus.PASS,"Test Case 6 passed successfully");
			logger.info("Test Case 6 passed successfully");
			
			TCExecutionStatus = "Pass";
			
		} catch (Exception e) {
			ex_tc6.log(LogStatus.FAIL,"TestCase_6 ran with failure");
			logger.error("TestCase_6 ran with failure");
			
			TCExecutionStatus = "Fail";
		}
		
		reports.endTest(ex_tc6);
		reports.flush();
		return TCExecutionStatus;
	}
	
	
	public String TestCase_7(int iRowIterator,Logger logger) {
		
		String TCExecutionStatus = null;
		
		ExtentTest ex_tc7 = reports.startTest("TestCase_7 : Book Hotel @ PHPTravels");
		
		try {
			String strtDate =  oUA.getCurrentDate("no");
			
			ex_tc7.log(LogStatus.INFO,"Test Case 7 started at " + strtDate);
			logger.info("Test Case 7 started at " + strtDate);
			
			oBrowser = oBA.openApplication(iRowIterator,ex_tc7,logger);
			oLogin_php.loginToApplication_phptravels(oBrowser,ex_tc7,logger);
			oLogin_php.validateLogin_phptravels(oBrowser,ex_tc7,logger);
			oHotels_php.navigateToHotelsPage(oBrowser, ex_tc7, logger);
			oHotels_php.searchForBestHotel(oBrowser, ex_tc7, logger);
			oHotels_php.getListOfHotels(oBrowser, ex_tc7, logger);
			oHotels_php.bookAvailableRooms(oBrowser, ex_tc7, logger);
			oHotels_php.provideBookingInformation(oBrowser, ex_tc7, logger);
			oHotels_php.selectPaymentMethod(oBrowser, ex_tc7, logger);
			oHotels_php.acceptTnCAndConfirmBooking(oBrowser, ex_tc7, logger);
			oHotels_php.getReservationNumber(oBrowser, ex_tc7, logger);
			oHotels_php.proceedPayment(oBrowser, ex_tc7, logger);
			oBA.closeApplication(oBrowser,ex_tc7,logger);
            
            String endDate =  oUA.getCurrentDate("no");
            
            ex_tc7.log(LogStatus.INFO,"Test Case 7 completed at " + endDate);
			logger.info("Test Case 7 completed at " + endDate);
			
			ex_tc7.log(LogStatus.PASS,"Test Case 7 passed successfully");
			logger.info("Test Case 7 passed successfully");
			
			TCExecutionStatus = "Pass";
			
		} catch (Exception e) {
			ex_tc7.log(LogStatus.FAIL,"TestCase_7 ran with failure");
			logger.error("TestCase_7 ran with failure");
			
			TCExecutionStatus = "Fail";
		}
		
		reports.endTest(ex_tc7);
		reports.flush();
		return TCExecutionStatus;
	}

}
