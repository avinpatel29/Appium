package users;

import actionEngines.DriverBase;
import utilities.GetConfig;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerificationsTests extends DriverBase {

	@BeforeMethod
	public synchronized void initiateDriver() throws Exception {
		LaunchDriver("Android", "emulator");
	}


	/**================================================================================
	 * 					Test cases for Manage Phone calls 
	================================================================================ */
	@Test(priority=1)
	public void verify_text_ManagePhoneCallsPopup() {
		Assert.assertEquals(container.newUser.getManage_Phone_Calls_Popup().getText(),GetConfig.getProperty("MANAGE_PHONE_CALLS_TEXT"));
	}
	
	@Test(priority=2)
	public void verify_AllowText_on_ManagePhoneCallsPopup() {
		Assert.assertEquals(container.newUser.getAllow_Button().getText(),GetConfig.getProperty("ALLOW_TEXT"));
	}
	
	@Test(priority=3)
	public void verify_DenyText_on_ManagePhoneCallsPopup() {
		Assert.assertEquals(container.newUser.getDeny_Button().getText(),GetConfig.getProperty("DENY_TEXT"));
	}
	
	@Test(priority=4)
	public void verify_Accept_ManagePhoneCalls() throws Exception  {
		container.newUser.click(container.newUser.getAllow_Button());
		Assert.assertEquals(container.newUser.getSend_View_SMS_Popup().isDisplayed(),true);
	}
	
	@Test(priority=5)
	public void verify_Deny_ManagePhoneCalls() throws Exception  {
		container.newUser.click(container.newUser.getDeny_Button());
		Assert.assertEquals(container.newUser.getSend_View_SMS_Popup().isDisplayed(),true);
	}
	
	/**================================================================================
	 *					 Test cases for Send & view SMS
	 ================================================================================*/
	
	@Test(priority=6)
	public void verify_Text_SendAndViewSMS() throws Exception {
		container.newUser.accept_ManagePhoneCalls();
		Assert.assertEquals(container.newUser.getSend_View_SMS_Popup().getText(),GetConfig.getProperty("SEND_VIEW_SMS"));
	}
	
	@Test(priority=7)
	public void verify_AllowText_on_SendAndViewSMS() throws Exception {
		container.newUser.accept_ManagePhoneCalls();
		Assert.assertEquals(container.newUser.getAllow_Button().getText(),GetConfig.getProperty("ALLOW_TEXT"));
	}
	
	@Test(priority=8)
	public void verify_DenyText_on_SendAndViewSMS() throws Exception {
		container.newUser.accept_ManagePhoneCalls();
		Assert.assertEquals(container.newUser.getDeny_Button().getText(),GetConfig.getProperty("DENY_TEXT"));
	}
	
	@Test(priority=9)
	public void verify_Accept_SendAndViewSMS() throws Exception  {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		Assert.assertEquals(container.newUser.getAccess_Location_Popup().isDisplayed(),true);
	}
	
	@Test(priority=10)
	public void verify_Deny_SendAndViewSMS() throws Exception  {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.deny_sendViewSMS();
		Assert.assertEquals(container.newUser.getAccess_Location_Popup().isDisplayed(),true);
	}
	
	
	
	/**================================================================================
	 * 						Test cases for Access device location
	 *================================================================================*/
	
	@Test(priority=11)
	public void verify_Text_AccessDeviceLoc() throws Exception {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		Assert.assertEquals(container.newUser.getAccess_Location_Popup().getText(),GetConfig.getProperty("ACCESS_DEV_LOC"));
	}
	
	@Test(priority=12)
	public void verify_AllowText_on_AccessDeviceLoc() throws Exception {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		Assert.assertEquals(container.newUser.getAllow_Button().getText(),GetConfig.getProperty("ALLOW_TEXT"));
	}
	
	@Test(priority=13)
	public void verify_DenyText_on_AccessDeviceLoc() throws Exception {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		Assert.assertEquals(container.newUser.getDeny_Button().getText(),GetConfig.getProperty("DENY_TEXT"));
	}
	
	@Test(priority=14)
	public void verify_Accept_AccessDeviceLoc() throws Exception  {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		container.newUser.click(container.newUser.getAllow_Button());
		Assert.assertEquals(container.newUser.getSign_Up_Title().isDisplayed(),true);
	}
	
	@Test(priority=15)
	public void verify_Deny_AccessDeviceLoc() throws Exception  {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		container.newUser.click(container.newUser.getDeny_Button());
		Assert.assertEquals(container.newUser.getALL_PRMSSN_RQRD_TEXT().isDisplayed(),true);
	}
	
	/**================================================================================
	 * 						Test cases for Signup screen
	 *================================================================================*/

	@Test(priority=16)
	public void verify_shortRideText() throws Exception{
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		container.newUser.accept_accessDeviceLoc();
		Assert.assertEquals(container.newUser.getShort_Rides().getText(),GetConfig.getProperty("SHORT_RIDE_TEXT"));
	}
		
	@Test(priority=17)
	public void verify_textBelowShortRide() throws Exception{
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		container.newUser.accept_accessDeviceLoc();
		Assert.assertEquals(container.newUser.getShort_Rides().getText(),GetConfig.getProperty("TEXT_BELOW_SHORT_RIDE"));
	}
	
	@Test(priority=18)
	public void verify_signupTitle() throws Exception {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		container.newUser.accept_accessDeviceLoc();
		Assert.assertEquals(container.newUser.getSign_Up_Title().getText(),GetConfig.getProperty("SIGNUP_TEXT"));
	}

	@Test(priority=19)
	public void verify_creditText() throws Exception {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		container.newUser.accept_accessDeviceLoc();
		Assert.assertEquals(container.newUser.getShort_Rides_Credit_Text().getText(),"₹ 100 Credit");
	}
	
	@Test(priority=20)
	public void verify_countryCodeText() throws Exception {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		container.newUser.accept_accessDeviceLoc();
		Assert.assertEquals(container.newUser.getCountry_Code_Text().getText(),GetConfig.getProperty("COUNTRY_CODE"));
	}
	
	@Test(priority=21)
	public void verify_mobileNumberText() throws Exception {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		container.newUser.accept_accessDeviceLoc();
		Assert.assertEquals(container.newUser.getMobileNo_TextField().getText(),GetConfig.getProperty("MOBILE_NUMBER"));
	}
	
	@Test(priority=22)
	public void verify_emailText() throws Exception {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		container.newUser.accept_accessDeviceLoc();
		container.newUser.hideKeyboard();
		Assert.assertEquals(container.newUser.getEmail_Textfield().getText(),GetConfig.getProperty("EMAIL_TEXT"));
	}
	
	@Test(priority=23)
	public void verify_referralLink() throws Exception {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		container.newUser.accept_accessDeviceLoc();
		container.newUser.hideKeyboard();
		Assert.assertEquals(container.newUser.getReferral_Link().getText(),GetConfig.getProperty("REFERRAL_CODE_TEXT"));
	}
	
	@Test(priority=24)
	public void verify_continueButton() throws Exception {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		container.newUser.accept_accessDeviceLoc();
		container.newUser.hideKeyboard();
		Assert.assertEquals(container.newUser.getContinue_button().getText(),GetConfig.getProperty("CONTINUE_BUTTON_TEXT"));
	}
	
	@Test(priority=25)
	public void verify_footerText() throws Exception {
		container.newUser.accept_ManagePhoneCalls();
		container.newUser.accept_sendViewSMS();
		container.newUser.accept_accessDeviceLoc();
		container.newUser.hideKeyboard();
		Assert.assertEquals(container.newUser.getFoot_Text_1().getText(),"By signing up, you agree to Metrobike's");
		Assert.assertEquals(container.newUser.getTerms_Of_Use_Link().getText(),"Terms of Use");
		Assert.assertEquals(container.newUser.getFoot_Text_2().getText(),"and");
		Assert.assertEquals(container.newUser.getPrivacy_Policy_Link().getText(),"Privacy Policy");
	}
	
	@Test(priority=26)
	public void verify_referralCodeTextfield() throws Exception {
		container.newUser.allowPermissions();
		container.newUser.getMobileNo_TextField().sendKeys("9912345699");
		container.newUser.hideKeyboard();
		container.newUser.clickReferralLink();
		Assert.assertTrue(container.newUser.getReferral_textfield().isDisplayed());
		Assert.assertTrue(!container.newUser.getReferral_Link().isDisplayed());
	}
	
	@Test(priority=27)
	public void verify_invalidRefferalCode() throws Exception {
		container.newUser.allowPermissions();
		container.newUser.getMobileNo_TextField().sendKeys("9912345699");
		container.newUser.hideKeyboard();
		container.newUser.clickReferralLink();
		Assert.assertTrue(container.newUser.getReferral_textfield().isDisplayed());
		container.newUser.getReferral_textfield().sendKeys("AKAKK");
		container.newUser.hideKeyboard();
		container.newUser.getContinue_button().click();
		Assert.assertTrue(container.newUser.getReferral_PopUp_Invalid_Heading_Text().isDisplayed());
		Assert.assertEquals(container.newUser.getReferral_PopUp_Invalid_Heading_Text().getText(),"MetroBikes");
		Assert.assertEquals(container.newUser.getReferral_PopUp_Invalid_Text().getText(),"Entered Referral Code is Invalid.");
		Assert.assertEquals(container.newUser.getReferral_PopUp_Invalid_OK_Button().getText(),"OK");
		container.newUser.clickAndWait(container.newUser.getReferral_PopUp_Invalid_OK_Button(),container.newUser.getReferral_textfield());
		container.newUser.getReferral_textfield().clear();
	}
	
	@Test(priority=28)
	public void verify_validRefferalCode() throws Exception {
		container.newUser.allowPermissions();
		container.newUser.getMobileNo_TextField().sendKeys("9912345699");
		container.newUser.hideKeyboard();
		container.newUser.clickReferralLink();
		Assert.assertTrue(container.newUser.getReferral_textfield().isDisplayed());
		container.newUser.getReferral_textfield().sendKeys("DWHHJ");
		container.newUser.hideKeyboard();
		container.newUser.getContinue_button().click();
		Assert.assertTrue(container.newUser.getPin_textfield().isDisplayed());
	}
	
	
	public void noNumberEntered(){

	}

	public void numberLessThanTenDigits(){

	}
	
	public void verify_invalidMobileNumber() {
		
	}
	
	public void verify_validMobileNumber() {
		
	}
	
	
	@AfterMethod
	public void cleanUp() throws InterruptedException {
		closeApp();
	}

}
