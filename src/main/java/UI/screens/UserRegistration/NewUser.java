package UI.screens.UserRegistration;

import UI.screens.common.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * @author Avinash Patel
 *
 */

public class NewUser extends PageBase{

	public NewUser(AppiumDriver driver) {
		super((AndroidDriver) driver);
	}

	/*
	 * ========================================================================
	 * 							Locators
	 * ========================================================================
	 */
	@AndroidFindBy(xpath= "//*[@text='Allow MetroBikes to make and manage phone calls?']")
	private MobileElement Manage_Phone_Calls_Popup;

	@AndroidFindBy(xpath= "//*[@text='Allow MetroBikes to send and view SMS messages?']")
	private MobileElement Send_View_SMS_Popup;

	@AndroidFindBy(xpath= "//*[@text=concat('Allow MetroBikes to access this device', \"'\", 's location?')]")
	private MobileElement Access_Location_Popup;

	@AndroidFindBy(id= "com.android.packageinstaller:id/permission_allow_button")
	private MobileElement Allow_Button;

	@AndroidFindBy(id= "com.android.packageinstaller:id/permission_deny_button")
	private MobileElement Deny_Button;
	
	@AndroidFindBy(id = "android:id/message")
	private MobileElement ALL_PRMSSN_RQRD_TEXT;
	
	@AndroidFindBy(id = "android:id/parentPanel")
	private MobileElement GPS_Not_Enabled;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement Location_OK_Button;
	
	@AndroidFindBy(id = "com.android.settings:id/switch_widget")
	private MobileElement Location_Switch_Button;

	@AndroidFindBy(accessibility = "Navigate up")
	private MobileElement Navigate_Back_Button;
	
	@AndroidFindBy(id = "com.metrobikes.app:id/mobileno")
	private MobileElement MobileNo_TextField;
	
	@AndroidFindBy(id = "com.metrobikes.app:id/email_id")
	private MobileElement Email_Textfield;
	
	@AndroidFindBy(id = "com.metrobikes.app:id/click_referal")
	private MobileElement Referral_Link;
	
	@AndroidFindBy(id = "com.metrobikes.app:id/Continue")
	private MobileElement Continue_button;
	
	@AndroidFindBy(id = "com.metrobikes.app:id/refer_code")
	private MobileElement referral_textfield;
	
	@AndroidFindBy(id = "com.metrobikes.app:id/pinView")
	private MobileElement Pin_textfield;
	
	@AndroidFindBy(accessibility= "Close navigation drawer")
	private MobileElement Burger_icon;
	
	@AndroidFindBy(xpath = "//*[@text='Signup & Get']")
	private MobileElement Sign_Up_Title;

	//Short Rides screen
	@AndroidFindBy(id="com.metrobikes.app:id/textItem")
	private MobileElement Short_Rides;

	@AndroidFindBy(id="com.metrobikes.app:id/textItem1")
	private MobileElement Short_Rides_Screen_Text_1;

	@AndroidFindBy(id="com.metrobikes.app:id/textItem")
	private MobileElement Long_Rides;

	@AndroidFindBy(id="com.metrobikes.app:id/textItem1")
	private MobileElement Long_Rides_Screen_Text;

	@AndroidFindBy(id="com.metrobikes.app:id/credit_text")
	private MobileElement Short_Rides_Credit_Text;

	@AndroidFindBy(xpath="//*[@text='+91']")
	private MobileElement Country_Code_Text;

	@AndroidFindBy(id="com.metrobikes.app:id/customTextView")
	private MobileElement Foot_Text_1;

	@AndroidFindBy(id="com.metrobikes.app:id/terms_textview")
	private MobileElement Terms_Of_Use_Link;

	@AndroidFindBy(id="com.metrobikes.app:id/customTextView2")
	private MobileElement Foot_Text_2;

	@AndroidFindBy(id="com.metrobikes.app:id/privacy_textview")
	private MobileElement Privacy_Policy_Link;

	@AndroidFindBy(id="com.metrobikes.app:id/DialogHeading")
	private  MobileElement Referral_PopUp_Invalid_Heading_Text;

	@AndroidFindBy(id="com.metrobikes.app:id/dialogMessage")
	private MobileElement Referral_PopUp_Invalid_Text;

	@AndroidFindBy(id="com.metrobikes.app:id/btn_yes")
	private MobileElement Referral_PopUp_Invalid_OK_Button;
	
	/*
	 * ========================================================================
	 * 							Methods
	 * ========================================================================
	 */
	
	
	/**
	 * Method to allow permissions for the first time user.
	 * @throws Exception 
	 */
	public void allowPermissions() throws Exception {
		if (isElementPresent(Manage_Phone_Calls_Popup))
			clickAndWait(Allow_Button, Send_View_SMS_Popup);
		if (isElementPresent(Send_View_SMS_Popup))
			clickAndWait(Allow_Button, Access_Location_Popup);
		if (isElementPresent(Access_Location_Popup)) {
			click(Allow_Button);
			try {
				if (isElementPresent(GPS_Not_Enabled)) {
					clickAndWait(Location_OK_Button, Location_Switch_Button);
					click(Location_Switch_Button);
					clickBackButton();
					waitForElementTobeClickable(MobileNo_TextField);
				}
			} catch (Exception e) {

			}
		}
	}
	
	
	/**
	 * Method to input mobile number 
	 * 
	 * @param mobileNo - Mobile number to be entered
	 * @throws Exception 
	 */
	public void inputMobileNo(String mobileNo) throws Exception {
//		waitForElementTobeClickable(MobileNo_TextField);
		inputText(MobileNo_TextField, mobileNo);
		clickBackButton();
		click(Continue_button);
		waitForElementTobeClickable(Pin_textfield);
	}
	
	
	/**
	 * Method to enter PIN/OTP number
	 * 
	 * @param pin - PIN/OTP recieved by the user
	 * @throws Exception 
	 */
	public void inputPin(String pin) throws Exception {
		inputText(Pin_textfield, pin);
		clickBackButton();
		click(Continue_button);
		waitForElementTobeClickable(Burger_icon);
		
	}
	
	
	public void accept_ManagePhoneCalls() throws Exception {
		if (isElementPresent(Manage_Phone_Calls_Popup))
			clickAndWait(Allow_Button, Send_View_SMS_Popup);
	}
	
	public void deny_ManagePhoneCalls() throws Exception {
		if (isElementPresent(Manage_Phone_Calls_Popup))
			clickAndWait(Deny_Button, Send_View_SMS_Popup);
	}
	
	public void accept_sendViewSMS() throws Exception {
		if (isElementPresent(Send_View_SMS_Popup))
			clickAndWait(Allow_Button, Access_Location_Popup);
	}
	
	public void deny_sendViewSMS() throws Exception {
		if (isElementPresent(Send_View_SMS_Popup))
			clickAndWait(Deny_Button, Access_Location_Popup);
	}
	
	public void accept_accessDeviceLoc() throws Exception {
		if (isElementPresent(Access_Location_Popup))
			clickAndWait(Allow_Button, MobileNo_TextField);
	}
	
	public void deny_accessDeviceLoc() throws Exception {
		if (isElementPresent(Access_Location_Popup))
			clickAndWait(Deny_Button,ALL_PRMSSN_RQRD_TEXT );
	}
	
	
	public void clickReferralLink() throws Exception {
		if(isElementPresent(Referral_Link)) {
			clickAndWait(Referral_Link, referral_textfield);
		}
	}
	
	public MobileElement getManage_Phone_Calls_Popup() {
		return Manage_Phone_Calls_Popup;
	}

	public MobileElement getSend_View_SMS_Popup() {
		return Send_View_SMS_Popup;
	}

	public MobileElement getAccess_Location_Popup() {
		return Access_Location_Popup;
	}

	public MobileElement getAllow_Button() {
		return Allow_Button;
	}

	public MobileElement getGPS_Not_Enabled() {
		return GPS_Not_Enabled;
	}

	public MobileElement getLocation_OK_Button() {
		return Location_OK_Button;
	}

	public MobileElement getLocation_Switch_Button() {
		return Location_Switch_Button;
	}

	public MobileElement getNavigate_Back_Button() {
		return Navigate_Back_Button;
	}

	public MobileElement getMobileNo_TextField() {
		return MobileNo_TextField;
	}

	public MobileElement getEmail_Textfield() {
		return Email_Textfield;
	}

	public MobileElement getReferral_Link() {
		return Referral_Link;
	}

	public MobileElement getContinue_button() {
		return Continue_button;
	}

	public MobileElement getReferral_textfield() {
		return referral_textfield;
	}

	public MobileElement getPin_textfield() {
		return Pin_textfield;
	}

	public MobileElement getBurger_icon() {
		return Burger_icon;
	}

	public MobileElement getDeny_Button() {
		return Deny_Button;
	}

	public MobileElement getSign_Up_Title() {
		return Sign_Up_Title;
	}

	public MobileElement getALL_PRMSSN_RQRD_TEXT() {
		return ALL_PRMSSN_RQRD_TEXT;
	}

	public MobileElement getShort_Rides() {
		return Short_Rides;
	}

	public MobileElement getShort_Rides_Screen_Text_1() {
		return Short_Rides_Screen_Text_1;
	}

	public MobileElement getLong_Rides() {
		return Long_Rides;
	}

	public MobileElement getLong_Rides_Screen_Text() {
		return Long_Rides_Screen_Text;
	}

	public MobileElement getShort_Rides_Credit_Text() {
		return Short_Rides_Credit_Text;
	}

	public MobileElement getCountry_Code_Text() {
		return Country_Code_Text;
	}


	public MobileElement getFoot_Text_1() {
		return Foot_Text_1;
	}

	public MobileElement getTerms_Of_Use_Link() {
		return Terms_Of_Use_Link;
	}

	public MobileElement getFoot_Text_2() {
		return Foot_Text_2;
	}

	public MobileElement getPrivacy_Policy_Link() {
		return Privacy_Policy_Link;
	}

	public MobileElement getReferral_PopUp_Invalid_Heading_Text() {
		return Referral_PopUp_Invalid_Heading_Text;
	}

	public MobileElement getReferral_PopUp_Invalid_Text() {
		return Referral_PopUp_Invalid_Text;
	}

	public MobileElement getReferral_PopUp_Invalid_OK_Button() {
		return Referral_PopUp_Invalid_OK_Button;
	}
}
