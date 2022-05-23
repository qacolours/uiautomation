package uiautomation.main;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import uiautomation.listners.listnerfunctions;
import uiautomation.pages.login_page;
import uiautomation.utils.business_actions;
import uiautomation.utils.reusable_user_actions;

public class initiator {
	
	reusable_user_actions oUA = new reusable_user_actions();
	
	@Test
	public void main() {
		
		try {
			
			//System.setProperty("log4j.configurationFile", "./resources/logs/log4j2.xml");
			//Logger logger = LogManager.getLogger(initiator.class.getName());
			
			Logger log = Logger.getLogger(login_page.class.getName());
			PropertyConfigurator.configure(oUA.getProperty("log4j_properties_file"));
			
			/*NOTE:: Logger Level Priority - TRACE < DEBUG < INFO < WARN < ERROR < FATAL < OFF
			Reference of log4j.xml file in below links - 
			https://stackoverflow.com/questions/49025937/not-able-to-create-a-log-file-using-log4j2
			https://howtodoinjava.com/log4j2/log4j2-xml-configuration-example/
			*/
			
			reusable_user_actions oUA = new reusable_user_actions();
			listnerfunctions oLF = new listnerfunctions();
			testcases oTC = new testcases();
			
			Properties oprop = new Properties();
			InputStream inputstrm = new FileInputStream(System.getProperty("user.dir") + "/src/configuration/config.properties");
			oprop.load(inputstrm);
			
			String TCExecutionStatus;
			
			String strtDate =  oUA.getCurrentDate("no");
			
			log.info("Test suite execution started at " + strtDate);
			
			
			String TCFilePath = System.getProperty("user.dir") + "/" + oprop.getProperty("testcase_location");
			
			int iTotalTestCaseCount = oLF.getTotalRowCount(TCFilePath, "TestCases");
			
			for (int iTCIterator = 2; iTCIterator <= iTotalTestCaseCount; iTCIterator++) {
				
				String sTCID = oLF.getCellValue(TCFilePath, "TestCases", "TestCaseID", iTCIterator);
				String sTCRunFlag = oLF.getCellValue(TCFilePath, "TestCases", "RunFlag", iTCIterator);
				
				if (sTCID.equalsIgnoreCase("TestCase_1") && sTCRunFlag.equalsIgnoreCase("Y")) {
					TCExecutionStatus = oTC.TestCase_1(iTCIterator,log);
				} else {
					// Do Nothing
				}
				
				if (sTCID.equalsIgnoreCase("TestCase_2") && sTCRunFlag.equalsIgnoreCase("Y")) {
					TCExecutionStatus = oTC.TestCase_2(iTCIterator,log);
				} else {
					// Do Nothing
				}
				
				if (sTCID.equalsIgnoreCase("TestCase_3") && sTCRunFlag.equalsIgnoreCase("Y")) {
					TCExecutionStatus = oTC.TestCase_3(iTCIterator,log);
				} else {
					// Do Nothing
				}
				
				if (sTCID.equalsIgnoreCase("TestCase_4") && sTCRunFlag.equalsIgnoreCase("Y")) {
					TCExecutionStatus = oTC.TestCase_4(iTCIterator,log);
				} else {
					// Do Nothing
				}
				
				if (sTCID.equalsIgnoreCase("TestCase_5") && sTCRunFlag.equalsIgnoreCase("Y")) {
					TCExecutionStatus = oTC.TestCase_5(iTCIterator,log);
					oLF.setCellValue(TCFilePath, "TestCases", "TCStatus", iTCIterator, TCExecutionStatus);
				} else {
					// Do Nothing
				}
				
				if (sTCID.equalsIgnoreCase("TestCase_6") && sTCRunFlag.equalsIgnoreCase("Y")) {
					TCExecutionStatus = oTC.TestCase_6(iTCIterator,log);
					oLF.setCellValue(TCFilePath, "TestCases", "TCStatus", iTCIterator, TCExecutionStatus);
				} else {
					// Do Nothing
				}
				
				if (sTCID.equalsIgnoreCase("TestCase_7") && sTCRunFlag.equalsIgnoreCase("Y")) {
					TCExecutionStatus = oTC.TestCase_7(iTCIterator,log);
					oLF.setCellValue(TCFilePath, "TestCases", "TCStatus", iTCIterator, TCExecutionStatus);
				} else {
					// Do Nothing
				}
				
			}
            
            String endDate =  oUA.getCurrentDate("no");
            
            log.info("Test suite execution completed at " + endDate);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}