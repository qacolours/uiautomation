package uiautomation.main;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

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
	
	ExtentReports extent_report = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Resources\\Reports\\Reports.html");
	
	testcases() {
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Blaze Automation Suite");
		extent_report.attachReporter(spark);
	}
	
	public String TestCase_1(int iRowIterator,Logger logger) {
		
		String TCExecutionStatus = null;
		
		ExtentTest ex_tc1 = extent_report.createTest("TestCase_1");
		
		try {
            String strtDate =  oUA.getCurrentDate("no");
			
            ex_tc1.log(Status.INFO,"Test Case 1 started at " + strtDate);
			logger.info("Test Case 1 started at " + strtDate);
			
			oBrowser = oBA.openApplication(iRowIterator,ex_tc1,logger);
			oLogin.clickOnLogin(oBrowser,ex_tc1,logger);
			oLogin.loginToApplication(oBrowser,ex_tc1,logger);
			oLogin.validateLogin(oBrowser,ex_tc1,logger);
			oHome.LogoutFromApplication(oBrowser,ex_tc1,logger);
			oHome.ValidateLogout(oBrowser,ex_tc1,logger);
			oBA.closeApplication(oBrowser,ex_tc1,logger);
            
            String endDate =  oUA.getCurrentDate("no");
            
            ex_tc1.log(Status.INFO,"Test Case 1 completed at " + endDate);
			logger.info("Test Case 1 completed at " + endDate);
			
			ex_tc1.log(Status.PASS,"Test Case 1 passed successfully");
			logger.info("Test Case 1 passed successfully");
			
			TCExecutionStatus = "Pass";
			
		} catch (Exception e) {
			ex_tc1.log(Status.FAIL,"TestCase_1 ran with failure");
			logger.error("TestCase_1 ran with failure");
			
			TCExecutionStatus = "Fail";
		}
		
		extent_report.flush();
		return TCExecutionStatus;
	}
	
	public String TestCase_2(int iRowIterator,Logger logger) {
		String TCExecutionStatus = null;
		
		ExtentTest ex_tc2 = extent_report.createTest("TestCase_2");
		
		try {
			String strtDate = oUA.getCurrentDate("no");
			
            ex_tc2.log(Status.INFO,"Test Case 2 started at " + strtDate);
			logger.info("Test Case 2 started at " + strtDate);
			
			oBrowser = oBA.openApplication(iRowIterator,ex_tc2,logger);
			oHome.ValidateLogout(oBrowser,ex_tc2,logger);
			oBA.closeApplication(oBrowser,ex_tc2,logger);
			
			String endDate = oUA.getCurrentDate("no");
            
			ex_tc2.log(Status.INFO,"Test Case 2 completed at " + endDate);
			logger.info("Test Case 2 completed at " + endDate);
			
			ex_tc2.log(Status.PASS,"Test Case 2 passed successfully");
			logger.info("Test Case 2 passed successfully");
			
			TCExecutionStatus = "Pass";
			
		} catch (Exception e) {			
			ex_tc2.log(Status.FAIL,"TestCase_2 ran with failure");
			logger.error("TestCase_2 ran with failure");
			
			TCExecutionStatus = "Fail";
		}
		
		extent_report.flush();
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
		
		extent_report.flush();
		return TCExecutionStatus;
	}
	
	public String TestCase_4(int iRowIterator,Logger logger) {
		String TCExecutionStatus = null;
		
		ExtentTest ex_tc4 = extent_report.createTest("TestCase_4");
		
		try {
			String strtDate = oUA.getCurrentDate("no");
			
            ex_tc4.log(Status.INFO,"Test Case 4 started at " + strtDate);
			logger.info("Test Case 4 started at " + strtDate);
			
			oBrowser = oBA.openApplication(iRowIterator,ex_tc4,logger);
			oLogin.clickOnLogin(oBrowser,ex_tc4,logger);
			oLogin.loginToApplicationWithoutInputs(oBrowser, ex_tc4, logger);
			oBA.closeApplication(oBrowser,ex_tc4,logger);
			
			String endDate = oUA.getCurrentDate("no");
            
            ex_tc4.log(Status.INFO,"Test Case 4 completed at " + endDate);
			logger.info("Test Case 4 completed at " + endDate);
			
			ex_tc4.log(Status.PASS,"Test Case 4 passed successfully");
			logger.info("Test Case 4 passed successfully");
			
			TCExecutionStatus = "Pass";
			
		} catch (Exception e) {
			ex_tc4.log(Status.FAIL,"TestCase_4 ran with failure");
			logger.error("TestCase_4 ran with failure");
			
			TCExecutionStatus = "Fail";
		}
		
		extent_report.flush();
		return TCExecutionStatus;
	}
	
	public String TestCase_5(int iRowIterator,Logger logger) {
		String TCExecutionStatus = null;
		
		ExtentTest ex_tc5 = extent_report.createTest("TestCase_5");
		
		try {
			String strtDate = oUA.getCurrentDate("no");
			
            ex_tc5.log(Status.INFO,"Test Case 5 started at " + strtDate);
			logger.info("Test Case 5 started at " + strtDate);
			
			oBrowser = oBA.openApplication(iRowIterator,ex_tc5,logger);
			oUA.flashElementInUI(oBrowser, "lnk_Login");
			oBA.closeApplication(oBrowser, ex_tc5, logger);
			
			String endDate = oUA.getCurrentDate("no");
            
			ex_tc5.log(Status.INFO,"Test Case 5 completed at " + endDate);
			logger.info("Test Case 5 completed at " + endDate);
			
			ex_tc5.log(Status.PASS,"Test Case 5 passed successfully");
			logger.info("Test Case 5 passed successfully");
			
			TCExecutionStatus = "Pass";
		} catch (Exception e) {
			ex_tc5.log(Status.FAIL,"TestCase_5 ran with failure");
			logger.error("TestCase_5 ran with failure");
			
			TCExecutionStatus = "Fail";
		}
		
		extent_report.flush();
		return TCExecutionStatus;
	}
	
	
	public String TestCase_6(int iRowIterator,Logger logger) {
		
		String TCExecutionStatus = null;
		
		ExtentTest ex_tc6 = extent_report.createTest("TestCase_6");
		
		try {
			
			String strtDate =  oUA.getCurrentDate("no");
			
			ex_tc6.log(Status.INFO,"Test Case 6 started at " + strtDate);
			logger.info("Test Case 6 started at " + strtDate);
			
			oBrowser = oBA.openApplication(iRowIterator,ex_tc6,logger);
			oLogin_php.loginToApplication_phptravels(oBrowser,ex_tc6,logger);
			oLogin_php.validateLogin_phptravels(oBrowser,ex_tc6,logger);
			oHome_php.LogoutFromApplication_phptravels(oBrowser,ex_tc6,logger);
			oHome_php.ValidateLogout_phptravels(oBrowser,ex_tc6,logger);
			oBA.closeApplication(oBrowser,ex_tc6,logger);
            
            String endDate =  oUA.getCurrentDate("no");
            
            ex_tc6.log(Status.INFO,"Test Case 6 completed at " + endDate);
			logger.info("Test Case 6 completed at " + endDate);
			
			ex_tc6.log(Status.PASS,"Test Case 6 passed successfully");
			logger.info("Test Case 6 passed successfully");
			
			TCExecutionStatus = "Pass";
			
		} catch (Exception e) {
			ex_tc6.log(Status.FAIL,"TestCase_6 ran with failure");
			logger.error("TestCase_6 ran with failure");
			
			TCExecutionStatus = "Fail";
		}
		
		extent_report.flush();
		return TCExecutionStatus;
	}
	
	
	public String TestCase_7(int iRowIterator,Logger logger) {
		
		String TCExecutionStatus = null;
		
		ExtentTest ex_tc7 = extent_report.createTest("TestCase_7 : Book Hotel @ PHPTravels");
		
		try {
			String strtDate =  oUA.getCurrentDate("no");
			
			ex_tc7.log(Status.INFO,"Test Case 7 started at " + strtDate);
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
            
            ex_tc7.log(Status.INFO,"Test Case 7 completed at " + endDate);
			logger.info("Test Case 7 completed at " + endDate);
			
			ex_tc7.log(Status.PASS,"Test Case 7 passed successfully");
			logger.info("Test Case 7 passed successfully");
			
			TCExecutionStatus = "Pass";
			
		} catch (Exception e) {
			ex_tc7.log(Status.FAIL,"TestCase_7 ran with failure");
			logger.error("TestCase_7 ran with failure");
			
			TCExecutionStatus = "Fail";
		}
		
		extent_report.flush();
		return TCExecutionStatus;
	}

}
