package uiautomation.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.OutputDeviceAssigned;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uiautomation.listners.listnerfunctions;

public class business_actions {
	
	String sURL = "https://www.demoblaze.com/#";
	WebDriver oBrowser;
	
	reusable_user_actions oUA = new reusable_user_actions();
	listnerfunctions oLF = new listnerfunctions();
	
	
	public WebDriver openApplication(int iRowIterator,ExtentTest extent_report,Logger logger) {
		
		try {
			
			Properties oprop = new Properties();
			InputStream inputstrm = new FileInputStream(System.getProperty("user.dir") + "/src/configuration/config.properties");
			oprop.load(inputstrm);
			
			String TCFilePath = System.getProperty("user.dir") + "/" + oprop.getProperty("testcase_location");
			String sNavigationURL = oLF.getCellValue(TCFilePath, "TestCases", "URL", iRowIterator);
			String sBrowserType = oLF.getCellValue(TCFilePath, "TestCases", "Browser", iRowIterator);
			
			if (sBrowserType.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/" + oprop.getProperty("chromedriverpath"));
				oBrowser = new ChromeDriver();
				
				oBrowser.manage().window().maximize();
				oBrowser.manage().deleteAllCookies();
				
				/*NOTE:: both driver.get("URL") and driver.navigate().to("URL") will launch a URL but driver.navigate().to("URL") is generally used to navigate to an internal or
				external URL from an existing URL */
				oBrowser.get(sNavigationURL);
				oBrowser.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
				
				extent_report.log(Status.INFO,"The browser to be launched is : " + sBrowserType);
				logger.info("The browser to be launched is : " + sBrowserType);
				
			} else if (sBrowserType.equalsIgnoreCase("ie")) {
				
				System.setProperty("webdriver.internet.explorer.driver", System.getProperty("user.dir") + "/" + oprop.getProperty("iedriverpath"));
				oBrowser = new InternetExplorerDriver();
				
				oBrowser.manage().window().maximize();
				oBrowser.manage().deleteAllCookies();
				
				oBrowser.get(sNavigationURL);
				oBrowser.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
				
				extent_report.log(Status.INFO,"The browser to be launched is : " + sBrowserType);
				logger.info("The browser to be launched is : " + sBrowserType);
				
			} else if (sBrowserType.equalsIgnoreCase("firefox")) {
				
				System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/" + oprop.getProperty("geckodriverpath"));
				oBrowser = new FirefoxDriver();
				
				oBrowser.manage().window().maximize();
				oBrowser.manage().deleteAllCookies();
				
				oBrowser.get(sNavigationURL);
				oBrowser.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
				
				oUA.implicitWait(oBrowser, extent_report, 5000);
				
				extent_report.log(Status.INFO,"The browser to be launched is : " + sBrowserType);
				logger.info("The browser to be launched is : " + sBrowserType);
				
			} else if (sBrowserType.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/" + oprop.getProperty("edgedriverpath"));
				oBrowser = new EdgeDriver();
				
				oBrowser.manage().window().maximize();
				oBrowser.manage().deleteAllCookies();
				
				oBrowser.get(sNavigationURL);
				oBrowser.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
				
				oUA.implicitWait(oBrowser, extent_report, 5000);
								
				extent_report.log(Status.INFO,"The browser to be launched is : " + sBrowserType);
				logger.info("The browser to be launched is : " + sBrowserType);
				
			} else {
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/" + oprop.getProperty("chromedriverpath"));
				oBrowser = new ChromeDriver();
				
				oBrowser.manage().window().maximize();
				oBrowser.manage().deleteAllCookies();
				
				oBrowser.get(sNavigationURL);
				oBrowser.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
				
				oUA.implicitWait(oBrowser, extent_report, 5000);
				
				extent_report.log(Status.INFO,"The browser to be launched is : " + sBrowserType);
				logger.info("The browser to be launched is : " + sBrowserType);
	
			}
			
		} catch (Exception e) {
			extent_report.log(Status.FAIL,"Browser did not launch properly. Failed with error message - " + e.getMessage());
			logger.error("Browser did not launch properly. Failed with error message - " + e.getMessage());
		}
		
		return oBrowser;
	}
	
	public void closeApplication(WebDriver param_Driver,ExtentTest extent_report,Logger logger) {
		
		try {
			oUA.implicitWait(oBrowser, extent_report, 5000);
			
			param_Driver.close();
			param_Driver.quit();
			
			extent_report.log(Status.INFO,"The Browser has been closed successfully");
			logger.info("The Browser has been closed successfully");
			
		} catch(Exception e) {
			extent_report.log(Status.FAIL,"Browser did not get closed properly. Failed with error message - " + e.getMessage());
			logger.error("Browser did not get closed properly. Failed with error message - " + e.getMessage());
		}
		
	}

}
