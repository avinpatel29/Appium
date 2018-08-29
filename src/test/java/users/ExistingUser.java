package users;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class ExistingUser {

	//	    AppiumDriver driver=null;
	    private AppiumDriver driver;
	    private WebDriverWait wait;
	    private long explicitWaitTimeoutInSeconds = 10L;
	    private static long INSTALL_DURATION_IN_SECONDS = 60L;
	    
	    
	    final String testAppName = "Metrobikes - Bike Rentals";
	    final String testAppPackage = "com.metrobikes.app";
	    final String testAppActivity = "com.metrobikes.app.activities.SplashActivity";

	    @Test(priority=0)
	   public void checkIfAppIsInstalled() throws IOException, InterruptedException{
	        //Set up desired capabilities and pass the Android app-activity
	        //and app-package to Appium 
	    	String device="phone";
	        
	    	DesiredCapabilities capabilities = new DesiredCapabilities();
	        
	        if(device=="emulator") {
	        	capabilities.setCapability("VERSION", "7.1.1");
	            capabilities.setCapability("device","Android");
	            capabilities.setCapability("deviceName","Android_7");
	            capabilities.setCapability("platformName","Android");
	            capabilities.setCapability("app", "D:\\Office\\softwares\\MB_TESTING-debug-66-1.9.10.apk");
	            capabilities.setCapability("appPackage", "com.metrobikes.app");
	            capabilities.setCapability("appActivity","com.metrobikes.app.activities.SplashActivity");
	            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	            this.wait = new WebDriverWait(driver, INSTALL_DURATION_IN_SECONDS);
	        }else if(device=="phone"){
	        	capabilities.setCapability("VERSION", "8.1.0");
	            capabilities.setCapability("device","Android");
	            capabilities.setCapability("deviceName","d8b823f1");
	            capabilities.setCapability("platformName","Android");
	            capabilities.setCapability("appPackage", "com.android.vending");
	            capabilities.setCapability("appActivity", ".AssetBrowserActivity");
	            capabilities.setCapability("deviceOrientation", "portrait");
	            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	            this.wait = new WebDriverWait(driver, INSTALL_DURATION_IN_SECONDS);
	        }
	      
	       if(driver.isAppInstalled("com.metrobikes.app"))
	    	{
	    	   uninstallApp("com.metrobikes.app");
	    		  
	    	}

	    }
	    
	    
	    @Test(priority=1)
	    public void installAppFromGooglePlayStore() throws Exception {
	    	
	    	Thread.sleep(5000);
	    	driver.findElementById("com.android.vending:id/search_box_idle_text").click();
	    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(MobileBy.className("android.widget.EditText")))).sendKeys(testAppName);
	    	Thread.sleep(5000);
	    	driver.findElementById("com.android.vending:id/suggest_text").click();	       
	    	Thread.sleep(5000);
	    	try {
	    	if(driver.findElementByXPath("//*[@text='INSTALL']").isDisplayed()) 
	    	{
	    		driver.findElementByXPath("//*[@text='INSTALL']").click();
	    		
//	    		driver.manage().timeouts().implicitlyWait(explicitWaitTimeoutInSeconds, TimeUnit.SECONDS);
	    		Thread.sleep(30000);
	    		driver.findElementByXPath("//*[@text='OPEN']").isDisplayed();
	    		
	    	} } catch(NoSuchElementException e) 
	    	{
	    		if(driver.findElementById("com.android.vending:id/li_overflow").isDisplayed()) {
	    			Thread.sleep(3000);
	 		       	driver.findElementById("com.android.vending:id/li_overflow").click();
	 		       	driver.findElementById("com.android.vending:id/title").click();
	 		       	Thread.sleep(30000);
	 		     //[@resource-id='com.android.vending:id/li_label' and contains[@contentDescription,'Installed']
//	 		       	driver.findElementByXPath("//[@resource-id='com.android.vending:id/li_label' and contains[@contentDescription,'Installed']");
//	 		       	wait.until(ExpectedConditions.attributeContains(By.id("com.android.vending:id/li_label"), "content-desc", "Installed"));
	    		}
	    	}
	    	
	        driver.quit();
	    }
	
	    @Test (priority=2)
	    public void invokeApp() throws MalformedURLException, Exception {
	    	
	    	Thread.sleep(3000);
	        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), installedAppCaps());
	        driver.launchApp();
	    }
	    
	    private DesiredCapabilities installedAppCaps() throws Exception {

	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("VERSION", "8.1.0");
            capabilities.setCapability("device","Android");
            capabilities.setCapability("deviceName","d8b823f1");
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("appPackage", "com.metrobikes.app");
            capabilities.setCapability("appActivity","com.metrobikes.app.activities.SplashActivity");
            capabilities.setCapability("deviceOrientation", "portrait");

	        return capabilities;
	    }
	 
	    
	    
	    
	    @Test(priority=3)
	    public void provide_permissions() throws Exception {
	    	
	    	if(driver.findElement(By.xpath("//*[@text='Allow MetroBikes to make and manage phone calls?']")).isDisplayed()) {
	    		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
	    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	}

	    	if(driver.findElement(By.xpath("//*[@text='Allow MetroBikes to send and view SMS messages?']")).isDisplayed()) {
	    		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
	    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	}
	    	
	    	if(driver.findElement(By.xpath("//*[@text=concat('Allow MetroBikes to access this device', \"'\", 's location?')]")).isDisplayed()) {
	    		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
	    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	}

//	    	driver.findElementById("com.metrobikes.app:id/mobileno").isDisplayed();
	    	
	    	Thread.sleep(3000);
	    	if(driver.findElementById("com.truecaller:id/confirm").isDisplayed()) {
	    		driver.findElementById("com.truecaller:id/confirm").click();
	    	}
	    	System.out.println("login");
	    	
	    	//Referal screen
	    	if(driver.findElementById("com.metrobikes.app:id/skip").isDisplayed()) {
	    		driver.findElementById("com.metrobikes.app:id/skip").click();
	    	}
	    
	    	
//	    	driver.closeApp();
	    	
//	    	If GPS is disabled
	    	try {
	    		if(driver.findElement(By.id("parentPanel")).isDisplayed()) 
		    	{
		    		driver.findElement(By.id("switch_target")).click();
		    		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton']"));
		    		driver.findElement(By.id("button1")).click();
		    		if(driver.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).isDisplayed()) {
		    			System.out.println("can see burger icon");
		    		}
		    	}
	    	}catch(NoSuchElementException e) {
	    		
	    	}
	    	
	    }

	    @Test(priority=4)
	    public void verifyLHNav() throws InterruptedException
	    { 	
	    	Thread.sleep(3000);
	    	try{
	    		
	    		driver.findElementByAccessibilityId("Close navigation drawer").click();
	    	}catch(Exception e) {
	    		driver.findElement(MobileBy.AccessibilityId("Close navigation drawer")).click();
	    	}
	    	Thread.sleep(2000);
	    	driver.findElementById("com.metrobikes.app:id/wallet_realtive").isDisplayed();
	    	driver.findElementById("com.metrobikes.app:id/mytrip_relative").isDisplayed();
	    	driver.findElementById("com.metrobikes.app:id/profile_relative").isDisplayed();
	    	driver.findElementById("com.metrobikes.app:id/vechile_pricing_realtive").isDisplayed();
	    	driver.findElementById("com.metrobikes.app:id/commute_plan").isDisplayed();
	    	driver.findElementById("com.metrobikes.app:id/textView80").isDisplayed();
	    	driver.findElementById("com.metrobikes.app:id/rate_app").isDisplayed();
	    	driver.findElementById("com.metrobikes.app:id/refer_earn").isDisplayed();
	    	driver.findElementById("com.metrobikes.app:id/terms_of_use").isDisplayed();
	    	driver.findElementById("com.metrobikes.app:id/textView82").isDisplayed();
	    	driver.findElementById("com.metrobikes.app:id/textView83").isDisplayed();	
	    }    

		
		 //uninstall the app if it's already installed
	    //credit where credit is due - code thanks to Craigo - http://stackoverflow.com/a/25735681

	    private void uninstallApp(String appPackage) throws IOException, InterruptedException {
	        final Process p = Runtime.getRuntime().exec("adb uninstall " + appPackage);

	        new Thread(new Runnable() {
	            public void run() {
	                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
	                String line = null;

	                try {
	                    while ((line = input.readLine()) != null)
	                        System.out.println(line);
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }).start();

	        p.waitFor();
	    }
	}
	
