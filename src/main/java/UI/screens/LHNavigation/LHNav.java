package UI.screens.LHNavigation;

import UI.screens.common.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * @author Avinash Patel
 *
 */
public class LHNav extends PageBase{
 
	
	/**
	 * Constructor of the class.
	 * 
	 * @param driver - driver 
	 */
	public LHNav(AppiumDriver driver) {
		super((AndroidDriver) driver);
	}
	
	
	/*
	 * ========================================================================
	 * 							Locators
	 * ========================================================================
	 */
	
	@AndroidFindBy(id= "com.metrobikes.app:id/fragment_drawer")
	private MobileElement LHNav_frame;
	
	@AndroidFindBy(accessibility= "Close navigation drawer")
	private MobileElement Burger_icon;
	
	@AndroidFindBy(xpath= "//*[@text='Wallet']")
	private MobileElement Wallet_link;
	
	@AndroidFindBy(xpath= "//*[@text='Rewards Points']")
	private MobileElement Rewards_points;
	
	@AndroidFindBy(xpath= "//*[@text='MetroBike Wallet balance']")
	private MobileElement Metrobike_Wallet_balance;
	
	@AndroidFindBy(xpath= "//*[@text='Paytm balance']")
	private MobileElement PaytmBalance;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/addPaytmWallet")
	private MobileElement Paytm_link;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/back")
	private MobileElement Back_arrow;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/ib_refer_back")
	private MobileElement Refer_Back_arrow;
	
	@AndroidFindBy(xpath= "//*[@text='Refer & Earn']")
	private MobileElement ReferEarn_Text;
	
	@AndroidFindBy(xpath= "//*[@text='Refer & Earn']")
	private MobileElement Rs100_Text;
	
	@AndroidFindBy(xpath= "//*[@text='Refer friends and get Rs 100 credit to your wallet when they sign up using your referral code.']")
	private MobileElement ReferEarn_TextMsg;
	
	@AndroidFindBy(xpath= "//*[@text='REFER NOW']")
	private MobileElement ReferNow_button;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/paytm_mobileno")
	private MobileElement Paytm_mobileNo_Textfield;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/pay_continue")
	private MobileElement Paytm_Next_Button;
	
	@AndroidFindBy(xpath= "//*[@text='Trips']")
	private MobileElement MyTrips_link;

	@AndroidFindBy(xpath= "//android.widget.TextView[@text='My Trips']")
	private MobileElement MyTrips_Text;
	
	@AndroidFindBy(xpath= "//*[@text='No Active Trips']")
	private MobileElement NoActiveTrips_Text;
	
	//-------------KYC Section----------------------------------
	@AndroidFindBy(xpath= "//*[@text='KYC']")
	private MobileElement KYC_link;
	
	@AndroidFindBy(xpath= "//*[@text='Allow MetroBikes to access photos, media, and files on your device?']")
	private MobileElement Profile_DialogBox;
	
	@AndroidFindBy(id= "com.android.packageinstaller:id/permission_allow_button")
	private MobileElement Allow_Button;
	
	@AndroidFindBy(id= "com.android.packageinstaller:id/permission_deny_button")
	private MobileElement Deny_Button;

	@AndroidFindBy(id= "com.metrobikes.app:id/userDocumentsStatus")
	private MobileElement kyc_status_value;
	
	@AndroidFindBy(xpath= "//*[@text='Profile picture']")
	private MobileElement profile_picture_text;
	
	@AndroidFindBy(xpath= "//android.widget.TextView[contains(@text, 'Licence Front')]")
	private MobileElement driver_licenseFont_text;
	
	@AndroidFindBy(xpath= "//android.widget.TextView[contains(@text,'Licence Back')]")
	private MobileElement driver_licenseBack_text;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/constraintLayout")
	private MobileElement Having_trouble_section;
	
	@AndroidFindBy(id= "//*[@text='Allow MetroBikes to take pictures and record video?']")
	private MobileElement take_pictures_video_text;
	
	@AndroidFindBy(accessibility= "Navigate up")
	private MobileElement Navigate_Back_Button;
	
	@AndroidFindBy(xpath = "//*[@text='Vehicle Pricing']")
	private MobileElement VehiclePricing_link;
	
	@AndroidFindBy(id = "com.android.chrome:id/action_bar_root")
	private MobileElement chrome_browser_window;
	
	@AndroidFindBy(id = "com.android.chrome:id/url_bar")
	private MobileElement chrome_browser_url_value;
	
	@AndroidFindBy(xpath = "//*[@text='Commute Plan']")
	private MobileElement CommutePlan_link;
	
	@AndroidFindBy(xpath = "//*[@text='Notification']")
	private MobileElement Notification_Link;
	
	@AndroidFindBy(xpath = "//*[@text='Notifications']")
	private MobileElement Notifications_text;
	
	@AndroidFindBy(xpath = "//*[@text='No notifications found.']")
	private MobileElement No_NotificationsFound_text;

	@AndroidFindBy(xpath = "//*[@text='Rate the app']")
	private MobileElement RateTheApp_Link;
	
	@AndroidFindBy(xpath = "//*[@text='RATE US']")
	private MobileElement RateUS_text;
	
	@AndroidFindBy(id = "com.metrobikes.app:id/like")
	private MobileElement RateTheApp_like_Button;
	
	@AndroidFindBy(id = "com.metrobikes.app:id/un_like")
	private MobileElement RateTheApp_unlike_Button;
	
	@AndroidFindBy(id = "com.metrobikes.app:id/close")
	private MobileElement RateTheApp_close_Button;
	
	@AndroidFindBy(xpath = "//*[@text='Refer and Earn']")
	private MobileElement ReferEarn_Link;
	
	@AndroidFindBy(xpath = "//*[@text='Terms of Use']")
	private MobileElement TermsOfUse_link;
	
	@AndroidFindBy(xpath = "//*[@text='Call Us']")
	private MobileElement CallUs_link;
	
	@AndroidFindBy(id = "com.google.android.dialer:id/dialtacts_frame")
	private MobileElement Dial_Frame;
	
	@AndroidFindBy(id = "com.google.android.dialer:id/digits")
	private MobileElement Dialled_digits_textfield;
	
	@AndroidFindBy(xpath = "//*[@text='Help']")
	private MobileElement Help_link;
	
	@AndroidBy(xpath="//*[@text='Short Ride']")
	private MobileElement ShortRide;

	@AndroidBy(xpath="//*[@text='Long Ride']")
	private MobileElement LongRide;
	
	@AndroidBy(id="com.metrobikes.app:id/from_loc")
	private MobileElement location_textfield;
	
	
	/*
	 * ========================================================================
	 * 							Methods
	 * ========================================================================
	 */
	
	public boolean verifyLHNavFrameIsPresent() throws Exception {
		return isElementPresent(LHNav_frame);
	}
	 
	public boolean verifyWalletIsPresent() throws Exception {
		return isElementPresent(Wallet_link);
	}
	
	public boolean verifyTripIsPresent() throws Exception {
		return isElementPresent(MyTrips_link);
	}
	
	public boolean verifyProfileIsPresent() throws Exception {
		return isElementPresent(KYC_link);
	}
	
	public boolean verifyVehiclePricingIsPresent() throws Exception {
		return isElementPresent(VehiclePricing_link);
	}
	
	public boolean verifyCommutePlanIsPresent() throws Exception {
		return isElementPresent(CommutePlan_link);
	}
	
	public boolean verifyNotificationIsPresent() throws Exception {
		return isElementPresent(Notification_Link);
	}
	
	public boolean verifyRateTheAppIsPresent() throws Exception {
		return isElementPresent(RateTheApp_Link);
	}
	
	public boolean verifyReferAndEarnIsPresent() throws Exception {
		return isElementPresent(ReferEarn_Link);
	}
	
	public boolean verifyTermsofUseIsPresent() throws Exception {
		return isElementPresent(TermsOfUse_link);
	}
	
	public boolean verifyCallUsIsPresent() throws Exception {
		return isElementPresent(CallUs_link);
	}
	
	public boolean verifyHelpIsPresent() throws Exception {
		return isElementPresent(Help_link);
	}
	
	
	public String getText_WalletLink() {
		return getText(Wallet_link);
	}
	
	public String getText_MyTripsLink() {
		return getText(MyTrips_link);
	}
	
	public String getText_ProfileLink() {
		return getText(KYC_link);
	}
	
	public String getText_VehiclePricingLink() {
		return getText(VehiclePricing_link);
	}
	
	public String getText_CommutePlanLink() {
		return getText(CommutePlan_link);
	}
	
	public String getText_NotificationsLink() {
		return getText(Notification_Link);
	}
	
	public String getText_RateTheAppLink() {
		return getText(RateTheApp_Link);
	}
	
	public String getText_ReferAndEarnWalletLink() {
		return getText(ReferEarn_Link);
	}
	
	public String getText_TermsOfUseLink() {
		return getText(TermsOfUse_link);
	}
	
	public String getText_CallUsLink() {
		return getText(CallUs_link);
	}
	
	public String getText_HelpLink() {
		return getText(Help_link);
	}
	
	public void clickMenuButton() throws Exception {
		waitForElementTobeClickable(Burger_icon);
		if(isElementPresent(Burger_icon)) {
			clickAndWait(Burger_icon, LHNav_frame);
		}
	}
	
	public void verifyLHNavLinks() throws Exception {
		verifyWalletIsPresent();
		verifyTripIsPresent();
		verifyProfileIsPresent();
		verifyVehiclePricingIsPresent();
		verifyCommutePlanIsPresent();
		verifyNotificationIsPresent();
		verifyRateTheAppIsPresent();
		verifyReferAndEarnIsPresent();
		verifyTermsofUseIsPresent();
		verifyCallUsIsPresent();
		verifyHelpIsPresent();
	}
	
	public void verify_RewardPoints_option() throws Exception {
		click(Wallet_link);
		Thread.sleep(2000);
		tapOnElement(300, 300);
//		clickAndWait(Rewards_points,ReferEarn_Text);
		if (isElementPresent(ReferEarn_Text)) 
		{
			if (isElementPresent(Rs100_Text)) 
			{
				if(isElementPresent(ReferEarn_TextMsg)) {
					isElementPresent(ReferNow_button);
					click(Refer_Back_arrow);
				}
			}
		}
	}
	
	public void verify_MetroBike_WalletBalance_option() throws Exception {
		 isElementPresent(Metrobike_Wallet_balance);
	}
	
	public void verify_PaytmBalance_option() throws Exception {
		if(isElementPresent(PaytmBalance)) 
		 {
			 isElementPresent(Paytm_link);
		 }
		clickAndWait(Back_arrow, LHNav_frame);
	}
	
	
	public void verifyKYCSection() throws Exception {
		waitForElementTobeClickable(KYC_link);
		if(isElementPresent(KYC_link)) {
			click(KYC_link);
			try{
				if(isElementPresent(Profile_DialogBox)) {
					click(Allow_Button);
					Thread.sleep(2000);
					isElementPresent(profile_picture_text);
					isElementPresent(driver_licenseFont_text);
					isElementPresent(driver_licenseBack_text);
					isElementPresent(Having_trouble_section);
					clickAndWait(Navigate_Back_Button, LHNav_frame);
				}
			}catch(Exception e) {
				isElementPresent(profile_picture_text);
				isElementPresent(driver_licenseFont_text);
				isElementPresent(driver_licenseBack_text);
				isElementPresent(Having_trouble_section);
				clickAndWait(Navigate_Back_Button, LHNav_frame);
			}
		}
	}
	
	
	public void verifyTrips() throws Exception {
		waitForElementTobeClickable(MyTrips_link);
		if(isElementPresent(MyTrips_link)) {
			click(MyTrips_link);
			isElementPresent(MyTrips_Text);
			click(Back_arrow);
		}
	}
	
	public void verifyNotification() {
		clickAndWait(Notification_Link,Notifications_text);
		clickAndWait(Back_arrow, LHNav_frame);
	}
	
	public void verifyRateTheApp() throws Exception {
		clickAndWait(RateTheApp_Link, RateUS_text);
		if(isElementPresent(RateUS_text)) {
			isElementPresent(RateTheApp_like_Button);
			isElementPresent(RateTheApp_unlike_Button);
		}
		click(RateTheApp_close_Button);
		Thread.sleep(2000);
	}
	
	public void verifyReferAndEarn() throws Exception {
		tapOnElement(400, 1400);
		if (isElementPresent(Rs100_Text)) 
		{
			if(isElementPresent(ReferEarn_TextMsg)) {
				isElementPresent(ReferNow_button);
				click(Refer_Back_arrow);
			}
		}
	}
	
	public String verifyCallUs() throws Exception {
		String number = null;
		clickAndWait(CallUs_link, Dial_Frame);
		if(isElementPresent(Dial_Frame))
		{
			number= getText(Dialled_digits_textfield);
		}
		clickBackButton();
		clickBackButton();
		clickBackButton();
		isElementPresent(LHNav_frame);
		return number;
	}
	
	public String vehiclePricing() throws Exception {
		String siteValue = null;
		clickAndWait(VehiclePricing_link,chrome_browser_window);
		if(isElementPresent(chrome_browser_window))
			siteValue= getText(chrome_browser_url_value);
		clickBackButton();
		waitForElementTobeClickable(LHNav_frame);
		return siteValue;
	}
	
	public String commutePlan() throws Exception {
		String siteValue = null;
		clickAndWait(CommutePlan_link,chrome_browser_window);
		if(isElementPresent(chrome_browser_window))
			siteValue= getText(chrome_browser_url_value);
		clickBackButton();
		waitForElementTobeClickable(LHNav_frame);
		return siteValue;
	}
}
