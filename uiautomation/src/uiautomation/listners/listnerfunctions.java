package uiautomation.listners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.model.InternalSheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.mk_latn.No;
import uiautomation.utils.reusable_user_actions;

public class listnerfunctions {
	
	Properties oprop = new Properties();
	
	public listnerfunctions() {
		try {
		InputStream inputstrm = new FileInputStream(System.getProperty("user.dir") + "/src/configuration/config.properties");
		oprop.load(inputstrm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readExcelFile(String FilePath, String SheetName) {
		
		try {
			File oFile = new File(FilePath);
			FileInputStream oFileIS = new FileInputStream(oFile);
			Workbook oWB = new XSSFWorkbook(oFileIS);
			Sheet oSheet = oWB.getSheet(SheetName);
			int rowCount = oSheet.getLastRowNum();
			
			System.out.println("Total number of rows in the excel sheet is " + Integer.toString(rowCount));
			
			for (int iterator_RowCount = 0; iterator_RowCount <= rowCount-1; iterator_RowCount++) {
				
				Row oRow = oSheet.getRow(iterator_RowCount);
				
				int columnCount = oRow.getLastCellNum();
				
				String param_ScenarioID = oSheet.getRow(iterator_RowCount).getCell(1).getStringCellValue();
				String param_ScenarioDesc = oSheet.getRow(iterator_RowCount).getCell(2).getStringCellValue();
				String param_TestSteps = oSheet.getRow(iterator_RowCount).getCell(3).getStringCellValue();
				String param_BrowserName = oSheet.getRow(iterator_RowCount).getCell(4).getStringCellValue();
				
				System.out.println("ScenarioID : " + param_ScenarioID);
				System.out.println("ScenarioDesc : " + param_ScenarioDesc);
				System.out.println("TestSteps : " + param_TestSteps);
				System.out.println("BrowserName : " + param_BrowserName);
				
				for (int iterator_ColumnCount = 1; iterator_ColumnCount <= columnCount-1; iterator_ColumnCount++) {
					
					
							
				}
			}
			
			oWB.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	public Sheet openExcelWorksheet(String ExcelFilePath,String SheetName) {
		
		Sheet oSheet = null;
		
		try {
			
			File oFile = new File(ExcelFilePath);
			FileInputStream oFileIS = new FileInputStream(oFile);
			Workbook oWB = new XSSFWorkbook(oFileIS);
			
			if (this.isSheetExists(oWB, SheetName).equalsIgnoreCase("True")) {
				oSheet = oWB.getSheet(SheetName);
			} else {
				throw new Exception("The sheet name provided does not exist");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return oSheet;
	}
	
	
	public void closeExcelWorkbook(Workbook oWB) {
		
		try {
			oWB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public String isSheetExists(Workbook oWB,String SheetName) {
		
		String sSheetExistsFlag = null;
		int iSteetIndex = oWB.getSheetIndex(SheetName);
		
		if (iSteetIndex == -1) {
			sSheetExistsFlag = "False";
		} else {
			sSheetExistsFlag = "True";
		}
		
		return sSheetExistsFlag;
		
	}
	
	
	
	public int getRow(String ExcelFilePath,String SheetName,String ColName,String sObjectName) {
		
		Sheet oSheet = this.openExcelWorksheet(ExcelFilePath, SheetName);
		
		int RowCount = oSheet.getLastRowNum();
		
		Row oRow = oSheet.getRow(0);
		int columnCount = oRow.getLastCellNum();
		
		int iRowNum = 0;
		String sObjectNameMatchedFlag = "No";
		
		for (int iterator_RowCount = 0; iterator_RowCount <= RowCount; iterator_RowCount++) {
			for (int iterator_ColumnCount = 0; iterator_ColumnCount <= columnCount-1; iterator_ColumnCount++) {
				if (oSheet.getRow(iterator_RowCount).getCell(iterator_ColumnCount).getStringCellValue().equalsIgnoreCase(sObjectName)) {
					iRowNum = iterator_RowCount;
					sObjectNameMatchedFlag = "Yes";
					break;
				} else {
					//do nothing
				}	
			}
			
			if (sObjectNameMatchedFlag.equalsIgnoreCase("yes")) {
				break;
			}
		}
		
		return iRowNum;
	}
	
	
	public String getCellValue(String ExcelFilePath,String SheetName,String ColName,int RowNum) {
		
		Sheet oSheet = this.openExcelWorksheet(ExcelFilePath, SheetName);
		
		Row oRow = oSheet.getRow(RowNum);
		int columnCount = oRow.getLastCellNum();
		
		String cellValue = null;
			
		for (int iterator_ColumnCount = 0; iterator_ColumnCount <= columnCount-1; iterator_ColumnCount++) {
			
			if (oSheet.getRow(0).getCell(iterator_ColumnCount).getStringCellValue().equalsIgnoreCase(ColName)) {
				
				cellValue = oSheet.getRow(RowNum).getCell(iterator_ColumnCount).getStringCellValue();
				break;
			} else {
				//do nothing
			}		
		}
		
		return cellValue;
	}
	
	
	public int getTotalRowCount(String ExcelFilePath,String SheetName) {
		
		Sheet oSheet = this.openExcelWorksheet(ExcelFilePath, SheetName);
		
		int RowCount = oSheet.getLastRowNum();
		
		return RowCount;
		
	}
	
	
	public int getColumnCountOfParticularRow(String ExcelFilePath,String SheetName,int RowNum) {
		
		Sheet oSheet = this.openExcelWorksheet(ExcelFilePath, SheetName);
		
		Row oRow = oSheet.getRow(RowNum);
		int columnCount = oRow.getLastCellNum();
		
		return columnCount;
		
	}
	
	
	public int getColumnNumberOfParticularColumn(String ExcelFilePath,String SheetName,String ColName,int RowNum) {
		
		Sheet oSheet = this.openExcelWorksheet(ExcelFilePath, SheetName);
		
		Row oRow = oSheet.getRow(RowNum);
		int columnCount = oRow.getLastCellNum();
		
		int cellIndex = 0;
		
		for (int iterator_ColumnCount = 0; iterator_ColumnCount <= columnCount-1; iterator_ColumnCount++) {
			
			if (oSheet.getRow(0).getCell(iterator_ColumnCount).getStringCellValue().equalsIgnoreCase(ColName)) {
				
				cellIndex = iterator_ColumnCount+1;
				break;
			} else {
				//do nothing
			}		
		}
		
		return cellIndex;
		
	}
	
	
	public void setCellValue(String ExcelFilePath,String SheetName,String ColName,int RowNum,String cellValue) {
		
		try {
			
			File oFile = new File(ExcelFilePath);
			FileInputStream oFileIS = new FileInputStream(oFile);
			Workbook oWB = new XSSFWorkbook(oFileIS);
			
			Sheet oSheet = null;
						
			if (this.isSheetExists(oWB, SheetName).equalsIgnoreCase("True")) {
				oSheet = oWB.getSheet(SheetName);
			} else {
				throw new Exception("The sheet name provided does not exist");
			}
			
			int columnIndex = this.getColumnNumberOfParticularColumn(ExcelFilePath, SheetName, ColName, RowNum);
			
			oSheet.getRow(RowNum).createCell(columnIndex-1).setCellValue(cellValue);
			
			oFileIS.close();
			
			FileOutputStream oFileOS = new FileOutputStream(oFile);
			oWB.write(oFileOS);
			oFileOS.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();			
		}
		
	}
	
	
	public void waitUntilObjectExists(WebDriver oBrowser,String sObjectName,Logger logger) {
		
		try {
			
			String ObjectRepositoryFilePath = System.getProperty("user.dir") + "/" + oprop.getProperty("objecrrepository_location");
			
			int iObjectNameRowNum = this.getRow(ObjectRepositoryFilePath, "ObjectRepository", "Object", sObjectName);
			
			String param_Locator = this.getCellValue(ObjectRepositoryFilePath, "ObjectRepository", "Locator", iObjectNameRowNum);
			String param_Value = this.getCellValue(ObjectRepositoryFilePath, "ObjectRepository", "Value", iObjectNameRowNum);
			
			if (param_Locator.equalsIgnoreCase("id")) {
				
				for (int iterator_wait = 0; iterator_wait <= 3; iterator_wait++) {
					if (oBrowser.findElements(By.id(param_Value)).size() == 0) {
						this.implicitWait(oBrowser, null, 5000);
					} else {
						logger.info("Object " + sObjectName + " is visible in the application");
						break;
					}
				}
				
			} else if (param_Locator.equalsIgnoreCase("name")) {
				
				for (int iterator_wait = 0; iterator_wait <= 3; iterator_wait++) {
					if (oBrowser.findElements(By.name(param_Value)).size() == 0) {
						this.implicitWait(oBrowser, null, 5000);
					} else {
						logger.info("Object " + sObjectName + " is visible in the application");
						break;
					}
				}
				
			} else if (param_Locator.equalsIgnoreCase("xpath")) {
				
				for (int iterator_wait = 0; iterator_wait <= 3; iterator_wait++) {
					if (oBrowser.findElements(By.xpath(param_Value)).size() == 0) {
						this.implicitWait(oBrowser, null, 5000);
					} else {
						logger.info("Object " + sObjectName + " is visible in the application");
						break;
					}
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public WebElement findElement(WebDriver oBrowser,String sObjectName) throws Exception {
		
		String ORFilePath = System.getProperty("user.dir") + "/" + oprop.getProperty("objecrrepository_location");
		
		WebElement oElement = null;
		
		int iObjectNameRowNum = this.getRow(ORFilePath, "ObjectRepository", "Object", sObjectName);
		
		String param_Locator = this.getCellValue(ORFilePath, "ObjectRepository", "Locator", iObjectNameRowNum);
		String param_Value = this.getCellValue(ORFilePath, "ObjectRepository", "Value", iObjectNameRowNum);
		
		if (param_Locator.equalsIgnoreCase("id")) {
			if (oBrowser.findElements(By.id(param_Value)).size() != 0) {
				oElement = oBrowser.findElement(By.id(param_Value));
			} else {
				throw new Exception("Object " + sObjectName + " is not visible in the application");
			}
		} else if (param_Locator.equalsIgnoreCase("name")) {
			if (oBrowser.findElements(By.name(param_Value)).size() != 0) {
				oElement = oBrowser.findElement(By.name(param_Value));
			} else {
				throw new Exception("Object " + sObjectName + " is not visible in the application");
			}
		} else if (param_Locator.equalsIgnoreCase("xpath")) {
			if (oBrowser.findElements(By.xpath(param_Value)).size() != 0) {
				oElement = oBrowser.findElement(By.xpath(param_Value));
			} else {
				throw new Exception("Object " + sObjectName + " is not visible in the application");
			}
		}
			
		return oElement;
	}
	
	
	public WebElement findElement(WebDriver oBrowser,String sObjectName,int iIteratorValue) throws Exception {
		
		String ORFilePath = System.getProperty("user.dir") + "/" + oprop.getProperty("objecrrepository_location");
		
		WebElement oElement = null;
		
		int iObjectNameRowNum = this.getRow(ORFilePath, "ObjectRepository", "Object", sObjectName);
		
		String param_Locator = this.getCellValue(ORFilePath, "ObjectRepository", "Locator", iObjectNameRowNum);
		String param_Value = this.getCellValue(ORFilePath, "ObjectRepository", "Value", iObjectNameRowNum);
		
		String updated_Param_Value = param_Value.replace("$$$", Integer.toString(iIteratorValue));
		
		if (param_Locator.equalsIgnoreCase("id")) {
			if (oBrowser.findElements(By.id(updated_Param_Value)).size() != 0) {
				oElement = oBrowser.findElement(By.id(updated_Param_Value));
			} else {
				throw new Exception("Object " + sObjectName + " is not visible in the application");
			}
		} else if (param_Locator.equalsIgnoreCase("name")) {
			if (oBrowser.findElements(By.name(updated_Param_Value)).size() != 0) {
				oElement = oBrowser.findElement(By.name(updated_Param_Value));
			} else {
				throw new Exception("Object " + sObjectName + " is not visible in the application");
			}
		} else if (param_Locator.equalsIgnoreCase("xpath")) {
			if (oBrowser.findElements(By.xpath(updated_Param_Value)).size() != 0) {
				oElement = oBrowser.findElement(By.xpath(updated_Param_Value));
			} else {
				throw new Exception("Object " + sObjectName + " is not visible in the application");
			}
		} else {
			throw new Exception("Locator type is not either of type ID,Name or XPATH, cannot use this method");
		}
			
		return oElement;
	}
	
	
	public List<WebElement> findElements(WebDriver oBrowser,String sObjectName) {
		
		String ORFilePath = System.getProperty("user.dir") + "/" + oprop.getProperty("objecrrepository_location");
		List<WebElement> oElements = null;
		
		int iObjectNameRowNum = this.getRow(ORFilePath, "ObjectRepository", "Object", sObjectName);
		
		String param_Locator = this.getCellValue(ORFilePath, "ObjectRepository", "Locator", iObjectNameRowNum);
		String param_Value = this.getCellValue(ORFilePath, "ObjectRepository", "Value", iObjectNameRowNum);
		
		if (param_Locator.equalsIgnoreCase("id")) {
			
			oElements = oBrowser.findElements(By.id(param_Value));
			
		} else if (param_Locator.equalsIgnoreCase("name")) {

			oElements = oBrowser.findElements(By.name(param_Value));
			
		} else if (param_Locator.equalsIgnoreCase("xpath")) {
			
			oElements = oBrowser.findElements(By.xpath(param_Value));
			
		} else if (param_Locator.equalsIgnoreCase("tagname")) {
			
			oElements = oBrowser.findElements(By.tagName(param_Value));
			
		}
			
		return oElements;
		
	}
	
	
	public List<WebElement> findElements(WebDriver oBrowser,String sObjectName,int iIteratorValue) {
		
		String ORFilePath = System.getProperty("user.dir") + "/" + oprop.getProperty("objecrrepository_location");
		List<WebElement> oElements = null;
		
		int iObjectNameRowNum = this.getRow(ORFilePath, "ObjectRepository", "Object", sObjectName);
		
		String param_Locator = this.getCellValue(ORFilePath, "ObjectRepository", "Locator", iObjectNameRowNum);
		String param_Value = this.getCellValue(ORFilePath, "ObjectRepository", "Value", iObjectNameRowNum);
		
		String updated_Param_Value = param_Value.replace("$$$", Integer.toString(iIteratorValue));
		
		if (param_Locator.equalsIgnoreCase("id")) {
			
			oElements = oBrowser.findElements(By.id(updated_Param_Value));
			
		} else if (param_Locator.equalsIgnoreCase("name")) {

			oElements = oBrowser.findElements(By.name(updated_Param_Value));
			
		} else if (param_Locator.equalsIgnoreCase("xpath")) {
			
			oElements = oBrowser.findElements(By.xpath(updated_Param_Value));
			
		} else if (param_Locator.equalsIgnoreCase("tagname")) {
			
			oElements = oBrowser.findElements(By.tagName(updated_Param_Value));
			
		}
			
		return oElements;
		
	}
	
	
	public boolean isElementPresent(WebDriver oBrowser,String sObjectName) throws Exception {
		
		boolean elementPresent = false;
		
		if (this.findElements(oBrowser, sObjectName).size() != 0) {
			elementPresent = true;
		} else {
			elementPresent = false;
			throw new Exception("Element searched: " + sObjectName + " is not present in the page.");
		}
			
		return elementPresent;
	}
	
	
	/*NOTE:: implicitwait, pageloadtimeout, explicitwaits are known as dynamic waits as if the element is loaded before that then it will not wait for the rest of the time but proceed
	to the next steps
	pageloadtimeout --> will wait for page to load, if loaded before the wait time it will proceed to next step else will give error - 
	oBrowser.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
	implicitwait --> deals with the element in page. will wait for the element inside page to load, if loaded before the wait time it will proceed to next step 
	else will give error - oBrowser.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));*/
	public void implicitWait(WebDriver oBrowser,ExtentTest extent_report,int waitInSeconds) {
		oBrowser.manage().timeouts().implicitlyWait(Duration.ofMillis(waitInSeconds));
		extent_report.log(Status.INFO,"Implicitly waited for " + Integer.toString(waitInSeconds) + " seconds during TC execution");
	}
	
	/*public void explicitWaitUntilElementClickable(WebDriver oBrowser,ExtentTest extent_report,int waitInSeconds) {
		oBrowser.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitInSeconds));
		extent_report.log(Status.INFO,"Implicitly waited for " + Integer.toString(waitInSeconds) + " seconds during TC execution");
		
		WebDriverWait ewait = new WebDriverWait(oBrowser,Duration.ofSeconds(waitInSeconds));
		ewait.until(ExpectedConditions.elementToBeClickable(""));
	}*/
	
	
	/*NOTE:: THERE ARE 2 PROCESSES OF HANDLING POPUPS. HANDLING JAVASCRIPT POP-UPS LIKE ALERT,WINDOW-POPUP AND HANDLING BROWSER POP-UPS LIKE BROWSER WINDOW
	 * JavaScript Alerts are handled by Alert API. Browser Pop-Ups are handled by WindowHandles API*/
	public String validateWindowAlertMessage(WebDriver oBrowser,String refText,Logger logger) {
		
		String textMatched = null;
		Alert oAlert = oBrowser.switchTo().alert();
		
		if (oAlert.getText().equalsIgnoreCase(refText)) {
			textMatched = "true";
			logger.info("Alert message matched successfully with provided text");
		} else {
			textMatched = "false";
			logger.error("Alert message not matched with provided text");
		}
		
		return textMatched;
		
	}
	
	
	public void acceptWindowAlert(WebDriver oBrowser,Logger logger) {
		
		Alert oAlert = oBrowser.switchTo().alert();
		oAlert.accept();
		logger.info("Alert message accepted successfully");
		
	}
	
	
	public void dismissWindowAlert(WebDriver oBrowser,Logger logger) {
		
		Alert oAlert = oBrowser.switchTo().alert();
		oAlert.dismiss();
		logger.info("Alert message dismissed successfully");
		
	}
	
	
	public String getAlertMessage(WebDriver oBrowser,Logger logger) {
		
		Alert oAlert = oBrowser.switchTo().alert();
		String sMessage = oAlert.getText();
		logger.info("Alert message is shown as : " + sMessage);
		
		return sMessage;
		
	}
	
		
	public void sendTextInAlertMessage(WebDriver oBrowser,Logger logger,String sText) {
		
		Alert oAlert = oBrowser.switchTo().alert();
		oAlert.sendKeys(sText);
		logger.info("Text entered in alert message successfully");
		
	}
	
	
	/*NOTE:: In case of uploading of any document. if we click on the Browse button a window appears which is known as Window Alert. This alert cannot be handled by Selenium.
	For that we need not click on the Browse button and handle the situation by 'SendKeys' function. Post SendKeys function we need to click on the submit button and
	complete the scenario of uploading document.*/
	public void selectDocumentForUploding(WebDriver oBrowser,String sObjectName,String DocumentFilePath,Logger logger) {
		
		this.waitUntilObjectExists(oBrowser, sObjectName, logger);
		
		try {
			if (this.findElements(oBrowser, sObjectName).size() > 0) {
				this.findElement(oBrowser, sObjectName).sendKeys(DocumentFilePath);
				
				logger.info("Document has been selected successfully for uploading");
			} else {
				logger.error("Object " + sObjectName + " is not visible in the page");
				throw new Exception("Object " + sObjectName + " is not visible in the page");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//NOTE:: Frame is identified by iframe tag. If in a page frame is present then on right clicking on the element an option will be shown as 'Frame'
	public WebDriver switchToFrameByFrameID(WebDriver oBrowser,int FrameIndex) {
		
		WebDriver oSwitchedFrame = null;
		
		oSwitchedFrame = oBrowser.switchTo().frame(FrameIndex);
		
		return oSwitchedFrame;
		
	}
	
	
	public WebDriver switchToFrameByFrameName(WebDriver oBrowser,String FrameName) {
		
		WebDriver oSwitchedFrame = null;
		
		oSwitchedFrame = oBrowser.switchTo().frame(FrameName);
		
		return oSwitchedFrame;
		
	}
	
	
	public WebDriver switchToDefaultFrameContent(WebDriver oBrowser) {
		
		WebDriver oDefaultContent = null;
		
		oDefaultContent = oBrowser.switchTo().defaultContent();
		
		return oDefaultContent;
		
	}
	
	
	public int getNoOfFramesInPage(WebDriver oBrowser) {
		
		int NoOfFrames = this.findElements(oBrowser, "iframe").size();
		
		return NoOfFrames;
		
	}
	
	
	/*NOTE:: for mousehover use action classes - movetoelement and pass the object
	for actions class we need to use build().perform() at the end for the action to get the function executed*/
	public void mouseHoverOnElement(WebDriver oBrowser,String sObjectName) {
		
		try {
			Actions oAction = new Actions(oBrowser);
			oAction.moveToElement(this.findElement(oBrowser, sObjectName)).build().perform();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*NOTE:: for draganddrop use action classes - first clickandhold and pass the source object and then movetheelement to target object and release() the object.
	for actions class we need to use build().perform() at the end for the action to get the function executed*/
	public void dragAndDropElement(WebDriver oBrowser,String sSourceObjectName,String sTargetObjectName) {
		
		try {
			Actions oAction = new Actions(oBrowser);
			oAction.clickAndHold(this.findElement(oBrowser, sSourceObjectName)).moveToElement(this.findElement(oBrowser, sTargetObjectName)).release().build().perform();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//NOTE:: simulation of back and forward buttons of browser
	public void navigateBetweenPages(WebDriver oBrowser,String sNavigationDirection) {
		
		try {
			if (sNavigationDirection.equalsIgnoreCase("forward")) {
				oBrowser.navigate().forward();
			} else if (sNavigationDirection.equalsIgnoreCase("backward")) {
				oBrowser.navigate().back();
			} else {
				throw new Exception("Navigation direction is not passed properly while calling navigateBetweenPages methon in ListnerFunctions class");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public String getBrowserWindowID(WebDriver oBrowser,String sWindowToCheck) {
		
		String sWindowID = null;
		
		Set<String> windowHandler = oBrowser.getWindowHandles();
		Iterator<String> windowIterator = windowHandler.iterator();
		
		String parentWindowHandle = windowIterator.next();
		
		String childWindowHandle = windowIterator.next();
		
		if (sWindowToCheck.equalsIgnoreCase("parent")) {
			sWindowID = parentWindowHandle;
		} else if (sWindowToCheck.equalsIgnoreCase("child")) {
			sWindowID = childWindowHandle;
		}
		
		return sWindowID;
	}
	
	
	public void navigateToBrowserWindowWithBrowserID(WebDriver oBrowser,String sWindowID) {
		
		oBrowser.switchTo().window(sWindowID);
		
	}
	
	
	public void refreshBrowser(WebDriver oBrowser) {
		
		oBrowser.navigate().refresh();
		
	}
	
}
