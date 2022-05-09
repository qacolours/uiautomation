package uiautomation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uiautomation.listners.listnerfunctions;
import uiautomation.utils.reusable_user_actions;

public class phptravel_hotel_booking_page {
	
	listnerfunctions oLF = new listnerfunctions();
	reusable_user_actions oUA = new reusable_user_actions();
	
	public void navigateToHotelsPage(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		if (oLF.findElements(param_Browser,"lnk_Hotels").size() != 0) {
			
			extent_report.log(Status.INFO,"Hotels link is visible in page as expected");
			logger.info("Hotels link is visible in page as expected");
			
			oLF.findElement(param_Browser, "lnk_Hotels").click();
			
			oLF.implicitWait(param_Browser, extent_report, 15);
			
			if (oLF.findElements(param_Browser, "form_hotelSearch").size() != 0) {
				
				extent_report.log(Status.PASS,"User navigated to Hotel Search page successfully");
				logger.info("User navigated to Hotel Search page successfully");
				
			} else {
				
				extent_report.log(Status.FAIL,"Clicking on Hotels link user not navigated to Hotels link");
				logger.error("Clicking on Hotels link user not navigated to Hotels link");
				
				throw new Exception("Clicking on Hotels link user not navigated to Hotels link");
				
			}
			
		} else {
			extent_report.log(Status.FAIL,"Hotels link is not visible in the page");
			logger.error("Hotels link is not visible in the page");
			
			throw new Exception("Hotels link is not visible in the page");
		}
		
	}
	
	
	public void searchForBestHotel(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		//try {
			int iNumberOfRoomsRequired = 2;
			int iNumberOfAdultsRequired = 4;		
			int iNumberOfChildrensRequired = 2;
			
			String CityName= "Dubai";
			
			//select city
			if (oLF.isElementPresent(param_Browser, "span_SelectCity")) {
				//clicking on the element
				oLF.findElement(param_Browser, "span_SelectCity").click();
				
				//pass the value of city which we need to select
				oLF.findElement(param_Browser, "txtbox_SelectCity").sendKeys(CityName);
				Thread.sleep(2000);
				
				//select the first matching value from the list 
				if (oLF.isElementPresent(param_Browser, "lst_SelectCity")) {
					
					int iListOfRetrievedCity = oLF.findElements(param_Browser, "lst_AllAvailableCity").size();
					
					for (int iRetrievedCityIterator = 1; iRetrievedCityIterator <= iListOfRetrievedCity; iRetrievedCityIterator++) {
						
						if (oLF.findElement(param_Browser, "lst_AllAvailableCity", iRetrievedCityIterator).getText().contains(CityName)) {
							oLF.findElement(param_Browser, "lst_AllAvailableCity", iRetrievedCityIterator).click();
							break;
						}
					}
					
					extent_report.log(Status.PASS,"City has been selected successfully as " + CityName);
					logger.info("City has been selected successfully as " + CityName);
					
				} else {
					throw new Exception("Element lst_SelectCity not visible in the browser");
				}
			}
			
			//check-in
			if (oLF.findElements(param_Browser,"txtbox_Checkin").size() != 0) {
				
			}
			
			//checkout
			if (oLF.findElements(param_Browser,"txtbox_Checkout").size() != 0) {
				
			}
			
			//add travellers
			if (oLF.findElements(param_Browser,"lnk_Travellers").size() != 0) {
				
				oLF.findElement(param_Browser, "lnk_Travellers").click();
				
				int iNumberOfRooms = Integer.parseInt(oLF.findElement(param_Browser, "txtbox_TravellerRooms").getAttribute("value"));
				int iNumberOfAdults = Integer.parseInt(oLF.findElement(param_Browser, "txtbox_TravellerAdults").getAttribute("value"));
				int iNumberOfChildrens = Integer.parseInt(oLF.findElement(param_Browser, "txtbox_TravellerChilds").getAttribute("value"));
				
				System.out.println("No of Rooms showed is : " + Integer.toString(iNumberOfRooms));
				System.out.println("No of Adults showed is : " + Integer.toString(iNumberOfAdults));
				System.out.println("No of Childrens showed is : " + Integer.toString(iNumberOfChildrens));
				
				//select rooms
				if (iNumberOfRoomsRequired > iNumberOfRooms) {
					System.out.println("inside iNumberOfRoomsRequired > iNumberOfRooms block");
					int iRoomLoopIteratorCount = iNumberOfRoomsRequired - iNumberOfRooms;
					
					for (int iRoomLoopIterator = 1; iRoomLoopIterator <= iRoomLoopIteratorCount; iRoomLoopIterator++) {
						oLF.findElement(param_Browser, "btn_RoomIncrement").click();
						//oLF.implicitWait(param_Browser, extent_report, 2);
					}
				} else if (iNumberOfRoomsRequired < iNumberOfRooms) {
					System.out.println("inside iNumberOfRoomsRequired < iNumberOfRooms block");
					int iRoomLoopIteratorCount = iNumberOfRooms - iNumberOfRoomsRequired;
					
					for (int iRoomLoopIterator = 1; iRoomLoopIterator <= iRoomLoopIteratorCount; iRoomLoopIterator++) {
						oLF.findElement(param_Browser, "btn_RoomDecrement").click();
						oLF.implicitWait(param_Browser, extent_report, 2);
					}	
				}
				
				extent_report.log(Status.PASS,"No of Room has been selected successfully as " + Integer.toString(iNumberOfRoomsRequired));
				logger.info("No of Room has been selected successfully as " + Integer.toString(iNumberOfRoomsRequired));
				
				oLF.implicitWait(param_Browser, extent_report, 2);
				
				//select adults
				if (iNumberOfAdultsRequired > iNumberOfAdults) {
					int iAdultLoopIteratorCount = iNumberOfAdultsRequired - iNumberOfAdults;
					
					for (int iAdultLoopIterator = 1; iAdultLoopIterator <= iAdultLoopIteratorCount; iAdultLoopIterator++) {
						oLF.findElement(param_Browser, "btn_AdultIncrement").click();
						oLF.implicitWait(param_Browser, extent_report, 2);
					}
				} else if (iNumberOfAdultsRequired < iNumberOfAdults) {
					int iAdultLoopIteratorCount = iNumberOfAdults - iNumberOfAdultsRequired;
					
					for (int iAdultLoopIterator = 1; iAdultLoopIterator <= iAdultLoopIteratorCount; iAdultLoopIterator++) {
						oLF.findElement(param_Browser, "btn_AdultDecrement").click();
						oLF.implicitWait(param_Browser, extent_report, 2);
					}	
				}
				
				extent_report.log(Status.PASS,"No of Adult has been selected successfully as " + Integer.toString(iNumberOfAdultsRequired));
				logger.info("No of Adult has been selected successfully as " + Integer.toString(iNumberOfAdultsRequired));
				
				oLF.implicitWait(param_Browser, extent_report, 2);
				
				//select child
				if (iNumberOfChildrensRequired > iNumberOfChildrens) {
					int iChildLoopIteratorCount = iNumberOfChildrensRequired - iNumberOfChildrens;
					
					for (int iChildLoopIterator = 1; iChildLoopIterator <= iChildLoopIteratorCount; iChildLoopIterator++) {
						oLF.findElement(param_Browser, "btn_ChildIncrement").click();
						oLF.implicitWait(param_Browser, extent_report, 2);
					}
				} else if (iNumberOfChildrensRequired < iNumberOfChildrens) {
					int iChildLoopIteratorCount = iNumberOfChildrens - iNumberOfChildrensRequired;
					
					for (int iChildLoopIterator = 1; iChildLoopIterator <= iChildLoopIteratorCount; iChildLoopIterator++) {
						oLF.findElement(param_Browser, "btn_ChildDecrement").click();
						oLF.implicitWait(param_Browser, extent_report, 2);
					}	
				}
				
				oLF.implicitWait(param_Browser, extent_report, 2);
				
				if (iNumberOfChildrensRequired > 0) {
					for (int iFillChildAgeIterator = 1; iFillChildAgeIterator <= iNumberOfChildrensRequired; iFillChildAgeIterator++) {
						oLF.findElement(param_Browser, "drpdwn_ChildAge",iFillChildAgeIterator).sendKeys(Integer.toString(5+iFillChildAgeIterator));;
						oLF.implicitWait(param_Browser, extent_report, 2);
					}
				}
				
				extent_report.log(Status.PASS,"No of Child has been selected successfully as " + Integer.toString(iNumberOfChildrensRequired));
				logger.info("No of Child has been selected successfully as " + Integer.toString(iNumberOfChildrensRequired));
				
			}
			
			//search
			oLF.findElement(param_Browser, "btn_Search").click();
		/*} catch(Exception e) {
			e.printStackTrace();
		}*/
		
	}
	
	
	public void getListOfHotels(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		//try {
			
			String sToBeSearchedHotelName = "Jumeirah Beach Hotel";
			String sSearchedHotelName = null;
			
			String sHotelName = null;
			String sHotelDescription = null;
			String sHotelRating = null;
			String sHotelPrice = null;
			
			int iNoOfHotelsListed = oLF.findElements(param_Browser, "lst_HotelList").size();
			
			System.out.println("For the selected city " + Integer.toString(iNoOfHotelsListed) + " hotels has been retrieved");
			
			for (int iHotelListIterator = 1; iHotelListIterator <= iNoOfHotelsListed; iHotelListIterator++) {
				
				System.out.println("Iterator count " + Integer.toString(iHotelListIterator));
				
				sHotelName = oLF.findElement(param_Browser, "txt_HotelName", iHotelListIterator).getText().trim();
				sHotelDescription = oLF.findElement(param_Browser, "txt_HotelDescription", iHotelListIterator).getText();
				sHotelRating = oLF.findElement(param_Browser, "txt_HotelRating", iHotelListIterator).getText();
				sHotelPrice = oLF.findElement(param_Browser, "txt_HotelPrice", iHotelListIterator).getText();
				
				System.out.println("Hotel Detail are as follows : Hotel Name - " + sHotelName + "; Hotel Description - " + sHotelDescription + "; Hotel Rating - " + sHotelRating + "; Hotel Starting Price - " + sHotelPrice);
				
				if (sHotelName.contains(sToBeSearchedHotelName)) {
					
					oUA.scrollIntoView(param_Browser, "btn_Details",iHotelListIterator);
					
					Thread.sleep(5000);
					
					oUA.clickUsingJavascript(param_Browser, "btn_Details", iHotelListIterator);
					oLF.implicitWait(param_Browser, extent_report, 5);
					
					sSearchedHotelName = oLF.findElement(param_Browser, "txt_DetailHotelName").getText();
					
					if (sSearchedHotelName.equalsIgnoreCase(sToBeSearchedHotelName)) {
						
						extent_report.log(Status.PASS,"User navigated to the desired Hotel page successfully. Hotel selected is " + sHotelName);
						logger.info("User navigated to the desired Hotel page successfully. Hotel selected is " + sHotelName);
						
					} else {
						extent_report.log(Status.FAIL,"User not navigated to the desired Hotel page");
						logger.error("User not navigated to the desired Hotel page");
					}
					
					break;
				}
			}
			
		/*} catch(Exception e) {
			e.printStackTrace();
		}*/
		
	}
	
	
	public void bookAvailableRooms(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		//try {
			
			int iAvailableRoomCount = 0;
			String sAvailableRoomPrice = null;
			String sToBeSelectedRoomType = null;
			String sToBeSelectedRoomPrice = null;
			double iAvailableRoomPrice = 0;
			double iMaxPrice = 0;
			int iDesiredIterator = 0;
			
			if (oLF.isElementPresent(param_Browser, "panel_AvailableHotelRooms")) {
				
				iAvailableRoomCount = oLF.findElements(param_Browser, "lst_TypeOfHotelRoomsAvailable").size();
				
				for (int iAvailableRoomIterator = 1; iAvailableRoomIterator <= iAvailableRoomCount; iAvailableRoomIterator++) {
					
					sAvailableRoomPrice = oLF.findElement(param_Browser, "txt_TypeOfHotelRoomsAvailablePrice", iAvailableRoomIterator).getText().replace("USD ", "");
					
					iAvailableRoomPrice = Double.parseDouble(sAvailableRoomPrice);
					
					if (iAvailableRoomPrice > iMaxPrice) {
						iMaxPrice = iAvailableRoomPrice;
						iDesiredIterator = iAvailableRoomIterator;
					}
					
				}
				
				sToBeSelectedRoomType = oLF.findElement(param_Browser, "txt_TypeOfHotelRoomsAvailableName", iDesiredIterator).getText();
				sToBeSelectedRoomPrice = oLF.findElement(param_Browser, "txt_TypeOfHotelRoomsAvailablePrice", iDesiredIterator).getText();
				
				System.out.println("Hotel selected is : Room Type: " + sToBeSelectedRoomType + " and Room Price: " + sToBeSelectedRoomPrice);
				System.out.println("The hotel to be selected is present at " + Integer.toString(iDesiredIterator));
				
				//Select no of rooms
				Select roomNo = new Select(oLF.findElement(param_Browser, "lst_AvailableRooms",iDesiredIterator));
				//roomNo.selectByVisibleText("2 - USD " + Integer.toString((int)Double.parseDouble(sToBeSelectedRoomPrice)));
				roomNo.selectByIndex(1);
				
				extent_report.log(Status.PASS,"Room Type and Room Price has been decided successfully");
				logger.info("Room Type and Room Price has been decided successfully");
				
				//oLF.implicitWait(param_Browser, extent_report, 10);
				
				Thread.sleep(5000);
				
				if (oLF.findElements(param_Browser, "span_BookedOnSpecificDate",iDesiredIterator).size() > 0) {
					String sMessage = oLF.findElement(param_Browser, "span_BookedOnSpecificDate",iDesiredIterator).getText().trim();
					
					if (sMessage.equalsIgnoreCase("Booked on specific date")) {
						
						extent_report.log(Status.FAIL,"Hotel is booked on the specific date. Please select another date or another room");
						logger.error("Hotel is booked on the specific date. Please select another date or another room");
						
						throw new Exception("Hotel is booked on the specific date. Please select another date or another room");
					}
				} else if (oLF.findElements(param_Browser, "btn_HotelBookNow",iDesiredIterator).size() > 0) {
					oLF.findElement(param_Browser, "btn_HotelBookNow", iDesiredIterator).click();
					
					oLF.implicitWait(param_Browser, extent_report, 10);
					
					//System.out.println("Button clicked successfully");
					extent_report.log(Status.PASS,"User clicked on Book Now button successfully");
					logger.info("User clicked on Book Now button successfully");
				}
				
			}
			
		/*} catch(Exception e) {
			e.printStackTrace();
		}*/
		
	}
	
	
	public void provideBookingInformation(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		//try {
			
			String sTraveller = null;
			int iAdultNumber = 0;
			int iChildNumber = 0;
			
			if (oLF.isElementPresent(param_Browser, "panel_PersonInformation") && oLF.isElementPresent(param_Browser, "panel_TravellerInformation") && oLF.isElementPresent(param_Browser, "panel_PaymentMethod")) {
				
				extent_report.log(Status.PASS,"User navigated to the provide booking information page successfully");
				logger.info("User navigated to the provide booking information page successfully");
				
				int iTotalNoOfTraveller = oLF.findElements(param_Browser, "lst_NoOfTravellers").size();
				
				for (int iAllTravellerIterator = 1;iAllTravellerIterator <= iTotalNoOfTraveller;iAllTravellerIterator++) {
					sTraveller = oLF.findElement(param_Browser, "span_TravellerAge", iAllTravellerIterator).getText();
					
					if (sTraveller.equalsIgnoreCase("Adult")) {
						iAdultNumber = iAdultNumber + 1;
						
						Select oAdultTitle = new Select(oLF.findElement(param_Browser, "drpdwn_AdultTravellerTitle",iAdultNumber));
						oAdultTitle.selectByVisibleText("MR");
						oLF.findElement(param_Browser, "txtbox_AdultTravellerFirstName",iAdultNumber).sendKeys("Adlt_fname_" + iAllTravellerIterator);
						oLF.findElement(param_Browser, "txtbox_AdultTravellerLastName",iAdultNumber).sendKeys("Adlt_lname_" + iAllTravellerIterator);
					} else if (sTraveller.equalsIgnoreCase("Child")) {
						iChildNumber = iChildNumber + 1;
						
						Select oChildAge = new Select(oLF.findElement(param_Browser, "drpdwn_ChildTravellerAge",iChildNumber));
						WebElement element_ChildAge = oChildAge.getFirstSelectedOption();
						String sSelectedValue = element_ChildAge.getText();
						
						//String sChildAge = oLF.findElement(param_Browser, "drpdwn_ChildTravellerAge",iChildNumber).getText();
						
						if (Integer.parseInt(sSelectedValue) == 1) {
							//Select oChildAge = new Select(oLF.findElement(param_Browser, "drpdwn_ChildTravellerAge",iChildNumber));
							oChildAge.selectByVisibleText("6");
						}			
						oLF.findElement(param_Browser, "txtbox_ChildTravellerFirstName",iChildNumber).sendKeys("Chld_fname_" + iChildNumber);
						oLF.findElement(param_Browser, "txtbox_ChildTravellerLastName",iChildNumber).sendKeys("Chld_lname_" + iChildNumber);
					}
				}
				
				extent_report.log(Status.PASS,"Traveller details provided successfully");
				logger.info("Traveller details provided successfully");
				
				/*
				Select oAdultTitle1 = new Select(oLF.findElement(param_Browser, "drpdwn_AdultTravellerTitle",1));
				oAdultTitle1.selectByValue("MR");
				oLF.findElement(param_Browser, "txtbox_AdultTravellerFirstName",1).sendKeys("Rahul");
				oLF.findElement(param_Browser, "txtbox_AdultTravellerLastName",1).sendKeys("Sharma");
				
				Select oAdultTitle2 = new Select(oLF.findElement(param_Browser, "drpdwn_AdultTravellerTitle",1));
				oAdultTitle2.selectByValue("MRS");
				oLF.findElement(param_Browser, "txtbox_AdultTravellerFirstName",2).sendKeys("Janvi");
				oLF.findElement(param_Browser, "txtbox_AdultTravellerLastName",2).sendKeys("Kapoor");
				
				String sChildAge1 = oLF.findElement(param_Browser, "drpdwn_ChildTravellerAge",1).getText();
				String sChildAge2 = oLF.findElement(param_Browser, "drpdwn_ChildTravellerAge",2).getText();
				
				if (Integer.parseInt(sChildAge1) == 1) {
					Select oChildAge1 = new Select(oLF.findElement(param_Browser, "drpdwn_ChildTravellerAge",1));
					oChildAge1.selectByValue("6");
				}			
				oLF.findElement(param_Browser, "txtbox_ChildTravellerFirstName",1).sendKeys("Vickey");
				oLF.findElement(param_Browser, "txtbox_ChildTravellerLastName",1).sendKeys("Sharma");
				
				if (Integer.parseInt(sChildAge2) == 1) {
					Select oChildAge2 = new Select(oLF.findElement(param_Browser, "drpdwn_AdultTravellerTitle",1));
					oChildAge2.selectByValue("11");
				}
				oLF.findElement(param_Browser, "txtbox_ChildTravellerFirstName",2).sendKeys("Ricky");
				oLF.findElement(param_Browser, "txtbox_ChildTravellerLastName",2).sendKeys("Sharma");
				*/
			}
			
		/*} catch(Exception e) {
			e.printStackTrace();
		}*/
		
	}
	
	
	public void selectPaymentMethod(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		//try {
			
			String sPaymentMethod = "Bank Transfer";
			
			if (sPaymentMethod.equalsIgnoreCase("Bank Transfer")) {
				if (oLF.isElementPresent(param_Browser, "Rdbtn_HotelBookingPaymentBankTransfer")) {
					//oLF.findElement(param_Browser, "Rdbtn_HotelBookingPaymentBankTransfer").click();
					oUA.clickUsingJavascript(param_Browser, "Rdbtn_HotelBookingPaymentBankTransfer");
					
					extent_report.log(Status.PASS,"Payment method selected successfully as " + sPaymentMethod);
					logger.info("Payment method selected successfully as " + sPaymentMethod);
				}
			} else if (sPaymentMethod.equalsIgnoreCase("Pay Later")) {
				if (oLF.isElementPresent(param_Browser, "Rdbtn_HotelBookingPaymentPayLater")) {
					//oLF.findElement(param_Browser, "Rdbtn_HotelBookingPaymentPayLater").click();
					oUA.clickUsingJavascript(param_Browser, "Rdbtn_HotelBookingPaymentPayLater");
					
					extent_report.log(Status.PASS,"Payment method selected successfully as " + sPaymentMethod);
					logger.info("Payment method selected successfully as " + sPaymentMethod);
				}
			} else if (sPaymentMethod.equalsIgnoreCase("Wallet Balance")) {
				if (oLF.isElementPresent(param_Browser, "Rdbtn_HotelBookingPaymentWalletBalance")) {
					//oLF.findElement(param_Browser, "Rdbtn_HotelBookingPaymentWalletBalance").click();
					oUA.clickUsingJavascript(param_Browser, "Rdbtn_HotelBookingPaymentWalletBalance");
					
					extent_report.log(Status.PASS,"Payment method selected successfully as " + sPaymentMethod);
					logger.info("Payment method selected successfully as " + sPaymentMethod);
				}
			} else if (sPaymentMethod.equalsIgnoreCase("PayPal")) {
				if (oLF.isElementPresent(param_Browser, "Rdbtn_HotelBookingPaymentPayPal")) {
					//oLF.findElement(param_Browser, "Rdbtn_HotelBookingPaymentPayPal").click();
					oUA.clickUsingJavascript(param_Browser, "Rdbtn_HotelBookingPaymentPayPal");
					
					extent_report.log(Status.PASS,"Payment method selected successfully as " + sPaymentMethod);
					logger.info("Payment method selected successfully as " + sPaymentMethod);
				}
			} else if (sPaymentMethod.equalsIgnoreCase("Stripe")) {
				if (oLF.isElementPresent(param_Browser, "Rdbtn_HotelBookingPaymentStripe")) {
					//oLF.findElement(param_Browser, "Rdbtn_HotelBookingPaymentStripe").click();
					oUA.clickUsingJavascript(param_Browser, "Rdbtn_HotelBookingPaymentStripe");
					
					extent_report.log(Status.PASS,"Payment method selected successfully as " + sPaymentMethod);
					logger.info("Payment method selected successfully as " + sPaymentMethod);
				}
			} else {
				extent_report.log(Status.FAIL,"The provided payment method does not exist");
				logger.error("The provided payment method does not exist");
				
				throw new Exception("The provided payment method does not exist");
			}
			
		/*} catch(Exception e) {
			e.printStackTrace();
		}*/
		
	}
	
	
	public void acceptTnCAndConfirmBooking(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		
		//try {
			oLF.implicitWait(param_Browser, extent_report, 5);
			
			if (oLF.isElementPresent(param_Browser, "chkbox_TermsAndConditions")) {
				//oLF.findElement(param_Browser, "chkbox_TermsAndConditions").click();
				oUA.clickUsingJavascript(param_Browser, "chkbox_TermsAndConditions");
				
				extent_report.log(Status.PASS,"Terms and Conditions has been selected successfully");
				logger.info("Terms and Conditions has been selected successfully");
			}
			
			oLF.implicitWait(param_Browser, extent_report, 5);
			
			if (oLF.isElementPresent(param_Browser, "btn_ConfirmBooking")) {
				//oLF.findElement(param_Browser, "btn_ConfirmBooking").click();
				oUA.clickUsingJavascript(param_Browser, "btn_ConfirmBooking");
			}
			
			oLF.implicitWait(param_Browser, extent_report, 15);
			
		/*} catch(Exception e) {
			e.printStackTrace();
		}*/
		
	}
	
	
	public void getReservationNumber(WebDriver param_Browser,ExtentTest extent_report,Logger logger) {
		
		try {
			
			String sReservationNumber = null;
			String sBookingTax = null;
			String sTotalPrice = null;
			
			if (oLF.isElementPresent(param_Browser, "panel_BookingConfirmation")) {
				
				extent_report.log(Status.PASS,"User navigated to Booking Confirmation page successfully");
				logger.info("User navigated to Booking Confirmation page successfully");
				
				if (oLF.isElementPresent(param_Browser, "txt_ReservationNumber")) {
					sReservationNumber = oLF.findElement(param_Browser, "txt_ReservationNumber").getText().replace("Reservation Number:", "").trim();
					
					System.out.println("Booking successful. Booking reference number generated is : " + sReservationNumber);
					
					extent_report.log(Status.PASS,"Booking successful. Booking reference number generated is : " + sReservationNumber);
					logger.info("Booking successful. Booking reference number generated is : " + sReservationNumber);
					
					sBookingTax = oLF.findElement(param_Browser, "span_BookingTax").getText().replace(" USD Booking Tax: USD ", "").trim();
					sTotalPrice = oLF.findElement(param_Browser, "span_TotalBookingPrice").getText().replace("Total Price: USD ", "").trim();
					
					System.out.println("Booking Tax is : " + sBookingTax + " and Total Booking Price is : " + sTotalPrice);
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void proceedPayment(WebDriver param_Browser,ExtentTest extent_report,Logger logger) throws Exception {
		 
		//try {
			if (oLF.isElementPresent(param_Browser, "btn_ProceedPayment")) {
				oLF.findElement(param_Browser, "btn_ProceedPayment").click();
				
				oLF.implicitWait(param_Browser, extent_report, 10);
				
				if (param_Browser.getCurrentUrl().equalsIgnoreCase("https://www.phptravels.net/payment/bank-transfer")) {
					extent_report.log(Status.PASS,"Payment processed for the booking successfully");
					logger.info("Payment processed for the booking successfully");
				}
			}
		/*} catch(Exception e) {
			e.printStackTrace();
		}*/
		
	}

}
