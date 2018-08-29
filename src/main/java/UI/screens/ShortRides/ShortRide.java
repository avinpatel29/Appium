package UI.screens.ShortRides;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import UI.screens.common.PageBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ShortRide extends PageBase{

	public ShortRide(AndroidDriver driver) {
		super((AndroidDriver) driver);
	}

	/*
	 * ========================================================================
	 * 							Locators
	 * ========================================================================
	 */
	
	@AndroidFindBy(id= "com.metrobikes.app:id/from_loc")
	private MobileElement shortRide_loc_textfield;
	
	@AndroidFindBy(xpath= "//*[@text='Short Ride']")
	private MobileElement shortRide_text;
	
	@AndroidFindBy(xpath= "//*[@text='Rewards Points']")
	private MobileElement Rewards_points;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/locationTitle")
	private MobileElement select_location_text;
	
	@AndroidFindBy(xpath= "//*[@text='Select Destination']")
	private MobileElement select_destination_text;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/adressText")
	private MobileElement locality_landmark_textfield;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/back")
	private MobileElement back_arrow;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/cardview")
	private MobileElement initial_confirm_frame;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/first_recycler_view")
	private MobileElement bikeList;
	
	@AndroidFindBy(xpath= "(//*[@contentDescription='Google Map']/*[@class='android.view.View'])[2]")
	private MobileElement loading;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/bottom_sheet")
	private MobileElement final_confirm_frame;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/pickupLoc")
	private MobileElement confirm_pickLoc_value;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/destinatioText")
	private MobileElement confirm_destLoc_value;
	
	@AndroidFindBy(xpath= "//*[@text='PICKUP']")
	private MobileElement pickup_button;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/confirmpickup")
	private MobileElement confirm_pickup_button;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/closeBooking")
	private MobileElement close_booking_icon;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/bottom_sheet_title")
	private MobileElement short_ride_text_in_confirm_pickup_screen;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/location_rootlayout")
	private MobileElement loc_dropdown_1stvalue;
	
	@AndroidFindBy(xpath= "//*[@id='location_rootlayout']//*[@id='firsname']")
	private MobileElement dropdown_value_firstName;
	
	@AndroidFindBy(xpath= "//*[@id='location_rootlayout']//*[@id='secondaoryname']")
	private MobileElement dropdown_value_secndaryName;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/tv_address")
	private MobileElement bike_address;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/tv_price_per_hr")
	private MobileElement pricing_value;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/txt_title")
	private MobileElement bike_number;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/tv_bike_name")
	private MobileElement bike_model;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/perhour")
	private MobileElement confirmFrame_bike_number;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/bikemodel")
	private MobileElement confirmFrame_bike_model;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/distance")
	private MobileElement distance_value;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/approxtime")
	private MobileElement time_value;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/approxcharges")
	private MobileElement amount_value;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/custom")
	private MobileElement tips_panel;
	
	@AndroidFindBy(xpath= "//*[@text='Skip']")
	private MobileElement skip_button;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/relative_lay")
	private MobileElement otp_screen;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/CancelBookingRoot")
	private MobileElement cancel_booking_card_layout;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/CancelBooking")
	private MobileElement cancelButton;

	@AndroidFindBy(id= "com.metrobikes.app:id/dialogMessage")
	private MobileElement are_you_sure_you_want_to_cancel_text;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/btn_yes")
	private MobileElement yesButton;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/btn_no")
	private MobileElement noButton;
	
	@AndroidFindBy(xpath= "//*[@text='Changed my mind/destination']")
	private MobileElement Changed_my_mind_destination;
	
	@AndroidFindBy(xpath= "//*[@text='OTP/Keypad not working']")
	private MobileElement OTPKeypad_not_working;
	
	@AndroidFindBy(xpath= "//*[@text='Battery issues']")
	private MobileElement Battery_issues;
	
	@AndroidFindBy(xpath= "//*[@text='No helmet in the trunk']")
	private MobileElement No_helmet_in_the_trunk;
	
	@AndroidFindBy(xpath= "//*[@text='Bike not found in location']")
	private MobileElement Bike_not_found_in_location;
	
	@AndroidFindBy(xpath= "//*[@text='Bike not clean']")
	private MobileElement Bike_not_clean;
	
	@AndroidFindBy(xpath= "//*[@text='No fuel']")
	private MobileElement No_fuel;
	
	@AndroidFindBy(xpath= "//*[@text='Private parking']")
	private MobileElement Private_parking;
	
	@AndroidFindBy(xpath= "//*[@text='Other']")
	private MobileElement Other;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/otherreason']")
	private MobileElement comments_section;
	
	
	/*
	 * ========================================================================
	 * 							Methods
	 * ========================================================================
	 */
	
	
	public void inputStartLoc(String startLoc) throws Exception {
		waitForElementTobeClickable(shortRide_loc_textfield);
		if(isElementPresent(shortRide_loc_textfield))
		{
			clickAndWait(shortRide_loc_textfield, locality_landmark_textfield);
			inputText(locality_landmark_textfield, startLoc);
			Thread.sleep(5000);
			clickAndWait(loc_dropdown_1stvalue,shortRide_loc_textfield);
		}
	}
	
	public String getTextShortRideLocation() {
		return getText(shortRide_loc_textfield);
	}
	
	public boolean verifyShortRideLocation(String startLoc) {
		String loc= getTextShortRideLocation();
		if(loc.contains(startLoc)) {
			return true;
		}else
			return false;
	}
	
	public void selectBike() throws Exception 
	{
		Thread.sleep(3000);
//		waitForElementToBePresent(initial_confirm_frame);
		waitForElementTobeClickable(pickup_button);
		try 
		{
			if (isElementPresent(pickup_button)) {
				clickAndWait(pickup_button, select_destination_text);
			}
		} catch (NoSuchElementException e) {
			throw new Exception ("No bikes found");
		}
		
	}
	
	public void inputDestinationLoc(String destLoc) throws Exception
	{
		waitForElementToBePresent(locality_landmark_textfield);
		if(isElementPresent(locality_landmark_textfield)) {
			inputText(locality_landmark_textfield, destLoc);
			Thread.sleep(5000);
			clickAndWait(loc_dropdown_1stvalue, confirm_pickup_button);
		}
	}
	
	public void clickConfirmPickup() throws Exception {
		click(confirm_pickup_button);
	}
	
	public void verifyPickUpLoc() {
//		System.out.println(getText(bike_address));
//		System.out.println(getText(confirm_pickLoc_value));
		Assert.assertEquals(getText(bike_address),getText(confirm_pickLoc_value)); 
	}
	
	public boolean verifyDestLoc(String destLoc) {
		String loc=getText(confirm_destLoc_value);
		if(loc.contains(destLoc))
			return true;
		else
			return false;
	}
	
	public void clickConfirmPickupButton() throws Exception{
		waitForElementToBePresent(confirm_pickup_button);
		click(confirm_pickup_button);
		try {
			if(isElementPresent(tips_panel)) {
				clickAndWait(skip_button, otp_screen);
			}	
		}catch(Exception e) {
			
		}
	}
	
	public void clickDismissButton() throws Exception {
		waitForElementTobeClickable(confirm_pickup_button);
		if(isElementPresent(close_booking_icon)) {
			clickAndWait(close_booking_icon, pickup_button);
		}
		waitForElementTobeClickable(pickup_button);
	}
	
	
	public void verifyOTPScreenElements() {
	
	}
	
	public void clickCancelButton(String reason) throws Exception {
		waitForElementToBePresent(cancel_booking_card_layout);
		if(isElementPresent(cancel_booking_card_layout)) {
			clickAndWait(cancelButton,are_you_sure_you_want_to_cancel_text);
//			System.out.println("//[@text=\'"+reason+"\']");
			driver.findElementByXPath("//*[@text=\'"+reason+"\']").click();
			clickAndWait(yesButton, shortRide_text);
		}
		waitForElementTobeClickable(shortRide_loc_textfield);
	}
	
	
	public void verifyBikeCard() {
		List<MobileElement> parent=driver.findElementsByXPath("//*[@resource-id='com.metrobikes.app:id/first_recycler_view']/child:: * ");
		System.out.println(parent.size());
		for(MobileElement element:parent)
		{
		 
		System.out.println(element.getText());
		 
		}
	}
}
