package uiautomation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uiautomation.listners.listnerfunctions;

public class reusable_user_actions extends listnerfunctions {
	
	Properties oprop = new Properties();
	
	public String getProperty(String property_name) throws Exception {
		//Properties oprop = new Properties();
		InputStream inputstrm = new FileInputStream(System.getProperty("user.dir") + "/src/configuration/config.properties");
		oprop.load(inputstrm);
		
		String property_value = oprop.getProperty(property_name);
		inputstrm.close();
		
		return property_value;
	}
	
	public void setProperty(String property_name,String property_value) throws Exception {
		//Properties oprop = new Properties();
		OutputStream outputstrm = new FileOutputStream(System.getProperty("user.dir") + "/src/configuration/config.properties");
		
		oprop.setProperty(property_name,property_value);
		oprop.store(outputstrm, "");
		outputstrm.close();
	}
	
	/*Method Name - getCurrentDate
	 * Method Function - To return the current date in form of string
	 */
	public String getCurrentDate(String sSpaceRemovalRequired) {
		
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String formattedDate = null;
        
        if (sSpaceRemovalRequired.equalsIgnoreCase("yes")) {
        	formattedDate = dateFormat.format(date).replace("-", "").replace(":", "").replace(" ", "");
        } else {
        	formattedDate = dateFormat.format(date);
        }
        
        return formattedDate;
	}
	
	
	public String captureScreenshot(WebDriver oBrowser,String SSFileName) {
		
		String SSFilePath = null;
		
		try {
			
			String strDate = this.getCurrentDate("yes");
			
			TakesScreenshot oTSS = (TakesScreenshot) oBrowser;
			File oSSFile = oTSS.getScreenshotAs(OutputType.FILE);
			SSFilePath = System.getProperty("user.dir") + "\\resources\\screenshots\\"+ SSFileName + "_" + strDate + ".jpg";
			File oDest = new File(SSFilePath);
			FileUtils.copyFile(oSSFile, oDest);
			
		} catch(Exception e) {
			System.out.println("There is an error while taking the screenshot - " + SSFileName);
		}
		
		return SSFilePath;
	}
	
	
	public String captureScreenshotWithElementHighlighted(WebDriver oBrowser,String sElementName,String SSFileName) {
		this.highlightElementInUI(oBrowser,sElementName);
		String SSFilePath = this.captureScreenshot(oBrowser, SSFileName);
		this.unhighlightElementInUI(oBrowser, sElementName);
		
		return SSFilePath;
	}
	
	
	/*NOTE: JavaScript Executor Methods*/
	public void clickUsingJavascript(WebDriver oBrowser,String sElementName) {
		try {
			WebElement oElement = super.findElement(oBrowser, sElementName);
			JavascriptExecutor oJE = ((JavascriptExecutor) oBrowser);
			oJE.executeScript("arguments[0].click();", oElement);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void clickUsingJavascript(WebDriver oBrowser,String sElementName,int iElementIterator) {
		try {
			WebElement oElement = super.findElement(oBrowser, sElementName,iElementIterator);
			JavascriptExecutor oJE = ((JavascriptExecutor) oBrowser);
			oJE.executeScript("arguments[0].click();", oElement);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void flashElementInUI(WebDriver oBrowser,String sElementName) {
		try {
			WebElement oElement = super.findElement(oBrowser, sElementName);
			JavascriptExecutor oJE = ((JavascriptExecutor) oBrowser);
			
			String bgColor = oElement.getCssValue("backgroundColor");
			
			for (int iRunIterator = 1; iRunIterator < 20; iRunIterator++) {
				oJE.executeScript("arguments[0].style.backgroundColor='#0093AB'", oElement);
				Thread.sleep(50);
				oJE.executeScript("arguments[0].style.backgroundColor='" + bgColor + "'", oElement);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public void flashElementInUI(WebDriver oBrowser,String sElementName,int iElementIterator) {
		try {
			WebElement oElement = super.findElement(oBrowser, sElementName,iElementIterator);
			JavascriptExecutor oJE = ((JavascriptExecutor) oBrowser);
			
			String bgColor = oElement.getCssValue("backgroundColor");
			
			for (int iRunIterator = 1; iRunIterator < 20; iRunIterator++) {
				oJE.executeScript("arguments[0].style.backgroundColor='#0093AB'", oElement);
				Thread.sleep(50);
				oJE.executeScript("arguments[0].style.backgroundColor='" + bgColor + "'", oElement);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public void highlightElementInUI(WebDriver oBrowser,String sElementName) {
		try {
			WebElement oElement = super.findElement(oBrowser, sElementName);
			JavascriptExecutor oJE = ((JavascriptExecutor) oBrowser);
			oJE.executeScript("arguments[0].style.border='3px solid red'", oElement);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void highlightElementInUI(WebDriver oBrowser,String sElementName,int iElementIterator) {
		try {
			WebElement oElement = super.findElement(oBrowser, sElementName,iElementIterator);
			JavascriptExecutor oJE = ((JavascriptExecutor) oBrowser);
			oJE.executeScript("arguments[0].style.border='3px solid red'", oElement);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void unhighlightElementInUI(WebDriver oBrowser,String sElementName) {
		try {
			WebElement oElement = super.findElement(oBrowser, sElementName);
			JavascriptExecutor oJE = ((JavascriptExecutor) oBrowser);
			oJE.executeScript("arguments[0].style.border='0px'", oElement);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void unhighlightElementInUI(WebDriver oBrowser,String sElementName,int iElementIterator) {
		try {
			WebElement oElement = super.findElement(oBrowser, sElementName,iElementIterator);
			JavascriptExecutor oJE = ((JavascriptExecutor) oBrowser);
			oJE.executeScript("arguments[0].style.border='0px'", oElement);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void scrollPageDown(WebDriver oBrowser,String sElementName) {
		try {
			WebElement oElement = super.findElement(oBrowser, sElementName);
			JavascriptExecutor oJE = ((JavascriptExecutor) oBrowser);
			oJE.executeScript("arguments[0].scrollTo(0,document.body.scrollHeight)", oElement);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void scrollPageDown(WebDriver oBrowser,String sElementName,int iElementIterator) {
		try {
			WebElement oElement = super.findElement(oBrowser, sElementName,iElementIterator);
			JavascriptExecutor oJE = ((JavascriptExecutor) oBrowser);
			oJE.executeScript("arguments[0].scrollTo(0,document.body.scrollHeight)", oElement);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void scrollIntoView(WebDriver oBrowser,String sElementName) {
		try {
			WebElement oElement = super.findElement(oBrowser, sElementName);
			JavascriptExecutor oJE = ((JavascriptExecutor) oBrowser);
			oJE.executeScript("arguments[0].scrollIntoView(true);", oElement);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void scrollIntoView(WebDriver oBrowser,String sElementName,int iElementIterator) {
		try {
			WebElement oElement = super.findElement(oBrowser, sElementName,iElementIterator);
			JavascriptExecutor oJE = ((JavascriptExecutor) oBrowser);
			oJE.executeScript("arguments[0].scrollIntoView(true);", oElement);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
 	
	
		
	
	
	/*Type of exceptions in Selenium like ElementNotFound Exception, StaleElement Exception etc*/

}
