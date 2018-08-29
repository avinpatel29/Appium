package users;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import actionEngines.DriverBase;

public class NewUserTests extends DriverBase{

	@Test(priority=0) 
	public void initiateDriver() throws Exception {
		LaunchDriver("Android", "emulator");
	}
	
	@Test(priority = 1)
	public void userRegistrationFromAPK() throws Exception {
		container.newUser.allowPermissions();
		container.newUser.inputMobileNo("9912345699");
		container.newUser.inputPin("4321");
	}

//	public void installAppFromGooglePlayStore() throws Exception {
//    	
//    	Thread.sleep(5000);
//    	driver.findElementById("com.android.vending:id/search_box_idle_text").click();
//    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(MobileBy.className("android.widget.EditText")))).sendKeys(testAppName);
//    	Thread.sleep(5000);
//    	driver.findElementById("com.android.vending:id/suggest_text").click();	       
//    	Thread.sleep(5000);
//    	try {
//    	if(driver.findElementByXPath("//*[@text='INSTALL']").isDisplayed()) 
//    	{
//    		driver.findElementByXPath("//*[@text='INSTALL']").click();
//    		
////    		driver.manage().timeouts().implicitlyWait(explicitWaitTimeoutInSeconds, TimeUnit.SECONDS);
//    		Thread.sleep(30000);
//    		driver.findElementByXPath("//*[@text='OPEN']").isDisplayed();
//    		
//    	} } catch(NoSuchElementException e) 
//    	{
//    		if(driver.findElementById("com.android.vending:id/li_overflow").isDisplayed()) {
//    			Thread.sleep(3000);
// 		       	driver.findElementById("com.android.vending:id/li_overflow").click();
// 		       	driver.findElementById("com.android.vending:id/title").click();
// 		       	Thread.sleep(30000);
// 		     //[@resource-id='com.android.vending:id/li_label' and contains[@contentDescription,'Installed']
//// 		       	driver.findElementByXPath("//[@resource-id='com.android.vending:id/li_label' and contains[@contentDescription,'Installed']");
//// 		       	wait.until(ExpectedConditions.attributeContains(By.id("com.android.vending:id/li_label"), "content-desc", "Installed"));
//    		}
//    	}
//        driver.quit();
//    }

	@AfterClass
	public void closeTheApp() {
		closeApp();
	}
}
