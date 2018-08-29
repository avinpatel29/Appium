package LHNav;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import actionEngines.DriverBase;


public class LHNavLinksTests extends DriverBase{
	
	@BeforeClass
	public void launchTheApp() throws Exception
	{
		LaunchApp("Android", "emulator");
	}
	
	
	@Test(priority = 1)
	public void verifyLHNavLinksArePresent() throws Exception {
		container.lhNav.clickMenuButton();
		Assert.assertEquals(container.lhNav.verifyWalletIsPresent(),true);
		Assert.assertEquals(container.lhNav.verifyTripIsPresent(),true);
		Assert.assertEquals(container.lhNav.verifyProfileIsPresent(),true);
		Assert.assertEquals(container.lhNav.verifyVehiclePricingIsPresent(),true);
		Assert.assertEquals(container.lhNav.verifyCommutePlanIsPresent(),true);
		Assert.assertEquals(container.lhNav.verifyNotificationIsPresent(),true);
		Assert.assertEquals(container.lhNav.verifyRateTheAppIsPresent(),true);
		Assert.assertEquals(container.lhNav.verifyReferAndEarnIsPresent(),true);
		Assert.assertEquals(container.lhNav.verifyTermsofUseIsPresent(),true);
		Assert.assertEquals(container.lhNav.verifyCallUsIsPresent(),true);
		Assert.assertEquals(container.lhNav.verifyHelpIsPresent(),true);
	}
	
	@Test(priority = 2)
	public void verifyLHNavLinkTexts() {
		Assert.assertEquals(container.lhNav.getText_WalletLink(), "Wallet");
		Assert.assertEquals(container.lhNav.getText_MyTripsLink(), "Trips");
		Assert.assertEquals(container.lhNav.getText_ProfileLink(), "KYC");
		Assert.assertEquals(container.lhNav.getText_VehiclePricingLink(), "Vehicle Pricing");
		Assert.assertEquals(container.lhNav.getText_CommutePlanLink(), "Commute Plan");
		Assert.assertEquals(container.lhNav.getText_NotificationsLink(), "Notification");
		Assert.assertEquals(container.lhNav.getText_RateTheAppLink(), "Rate the app");
		Assert.assertEquals(container.lhNav.getText_ReferAndEarnWalletLink(), "Refer and Earn");
		Assert.assertEquals(container.lhNav.getText_TermsOfUseLink(), "Terms of Use");
		Assert.assertEquals(container.lhNav.getText_CallUsLink(), "Call Us");
		Assert.assertEquals(container.lhNav.getText_HelpLink(), "Help");
	}
	
	
	
	@Test(priority = 3)
	public void verifyWalletSection() throws Exception {
		container.lhNav.verify_RewardPoints_option();
		container.lhNav.verify_MetroBike_WalletBalance_option();
		container.lhNav.verify_PaytmBalance_option();
	}
	
	
	@Test(priority = 4)
	public void verifyTripsSection() throws Exception {
		container.lhNav.verifyTrips();
	}
	
	@Test(priority = 5)
	public void verifyKYCSection() throws Exception {
		container.lhNav.verifyKYCSection();
	}
	
	@Test(priority = 6)
	public void verifyVehiclePricingSection() throws Exception {
		String site=container.lhNav.vehiclePricing();
		Assert.assertEquals(site,"www.metrobikes.in/tariff/app");
	}
	
	@Test(priority = 7)
	public void verifyCommutePlanSection() throws Exception {
		container.lhNav.clickMenuButton();
		String site=container.lhNav.vehiclePricing();
		Assert.assertEquals(site,"www.metrobikes.in/commute-plan");
	}
	
	@Test(priority = 8)
	public void verifyNotificationSection() {
		container.lhNav.verifyNotification();
	}
	
	@Test(priority = 9)
	public void verifyRateTheAppSection() throws Exception {
		container.lhNav.verifyRateTheApp();
	}
	
	@Test(priority = 10)
	public void verifyReferAndEarnSection() throws Exception {
		container.lhNav.verifyReferAndEarn();
	}
	
	  @Test(priority = 11)
	public void verifyCallUsSection() throws Exception {
		Assert.assertEquals(container.lhNav.verifyCallUs(),"08039534346");
	}
	
	@AfterClass
	public void closeTheApp() {
		closeApp();
	}
}
