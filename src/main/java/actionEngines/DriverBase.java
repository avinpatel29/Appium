package actionEngines;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import UI.screens.common.PageContainer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.offset.PointOption;
import utilities.ExcelDP;
import utilities.GetConfig;
import utilities.Logger;


/**
 * @author Avinash Patel
 *
 */
public class DriverBase {

	public static ExcelDP readExcel;
	private static AppiumDriver driver;
	protected String env,device;
	public PageContainer container;
	public static TouchAction tapOn;
	public static Actions action;
	
	/**Method to launch driver
	 * 
	 * @param env - Environment for which you want to create a driver (Android/ios)
	 * @param device - where do you want to run the tests (Emulator/device)
	 * @throws Exception
	 */
	public void LaunchDriver(String env, String device) throws Exception {

		if(env.equals("Android")) 
		{	
			DesiredCapabilities capabilities = new DesiredCapabilities();
			if (device == "emulator") {
				capabilities.setCapability("BROWSER_NAME", "Android");
				capabilities.setCapability("VERSION", "7.1.1");
				capabilities.setCapability("device", "Android");
				capabilities.setCapability("deviceName", "Android_7");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("app","D:\\Office\\eclipse-workspace\\Appium\\AppiumFramework\\apps\\MB_TESTING-release-69-1.11.4.apk");
				capabilities.setCapability("appPackage", "com.metrobikes.app");
				capabilities.setCapability("appActivity", "com.metrobikes.app.activities.SplashActivity");
			}else {
				capabilities.setCapability("VERSION", "8.1.0");
				capabilities.setCapability("device", "Android");
				capabilities.setCapability("deviceName", "d8b823f1");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("appPackage", "com.metrobikes.app");
				capabilities.setCapability("appActivity", "com.metrobikes.app.activities.SplashActivity");
			}
			try {
				Logger.log("Launching driver.....with desired capability...");
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				readExcel = new ExcelDP(System.getProperty("user.dir")+ GetConfig.getProperty("testData"));
				 
			}catch(WebDriverException e) {
				throw new Exception ("Appium server not started");
			}

			// Initiate page driver, to initiates all page objects
			container = new PageContainer((AndroidDriver) driver);
			tapOn= new TouchAction(driver);
			action = new Actions(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}else if(env=="ios") 
		{
			//not implemented yet
		}
	
	}



	/**
	 * Method to maximize the screen
	 */
	public static void maximize() {
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point position = new Point(0, 0);
		driver.manage().window().setPosition(position);
		Dimension maximizedScreenSize = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
		driver.manage().window().setSize(maximizedScreenSize);
		driver.manage().window().maximize();

	}
	
	/** Method to get the driver
	 * 
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		if (driver == null)
			throw new RuntimeException("We have not instantiated the driver.");
		return driver;
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult)
			throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			try {
				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(getImagePath(testResult)));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private String getImagePath(ITestResult testResult) {

		String path = System.getProperty("user.dir") + File.separator
				+ "test-output" + File.separator + "images";
		File filePath = new File(path);
		filePath.mkdirs();

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(new Date(testResult.getEndMillis()));
		String filePathName = filePath.getAbsolutePath() + File.separator
				+ testResult.getName() + timeStamp + ".png";
		return filePathName;
	}

//	@AfterClass(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}
	
	/**
	 * Method to close the app 
	 */
	public void closeApp(){
		driver.closeApp();
	}
	
	
	/** Method to launch the app
	 * 
	 * @throws Exception
	 */
	public void launchApp() throws Exception {
		driver.launchApp();
	}

	
	/** Method to run the driver with desired capabilities
	 * 
	 * @param device Emunlator/device
	 * @return Object of desired capabilities
	 * 
	 * @throws Exception
	 */
	public DesiredCapabilities installedAppCaps(String device) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (device == "emulator") 
        {
        capabilities.setCapability("VERSION", "7.1.1");
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("deviceName", "Android_7");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.metrobikes.app");
		capabilities.setCapability("appActivity", "com.metrobikes.app.activities.SplashActivity");
		capabilities.setCapability("noReset",true);
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("fullReset",false);
		capabilities.setCapability("newCommandTimeout", 10000);
        }else {
			capabilities.setCapability("VERSION", "8.1.0");
			capabilities.setCapability("device", "Android");
			capabilities.setCapability("deviceName", "d8b823f1");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appPackage", "com.metrobikes.app");
			capabilities.setCapability("appActivity", "com.metrobikes.app.activities.SplashActivity");
		}
        return capabilities;
    }
	
	
	/** Method to launch the app with new desired capabilities.
	 *  
	 * @param env - Android/ios
	 * @param device - Emulator/Phone
	 * @throws Exception
	 */
	public void LaunchApp(String env, String device) throws Exception {
		
		if(env.equals("Android")) 
		{	
			try {
				Logger.log("Launching app.....with desired capability...");
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), installedAppCaps(device));
				readExcel = new ExcelDP(System.getProperty("user.dir")+ GetConfig.getProperty("testData"));
				 
			}catch(WebDriverException e) {
				throw new Exception ("Appium server not started");
			}

			// Initiate page driver, to initiates all page objects
			tapOn= new TouchAction(driver);
			action = new Actions(driver);
			container = new PageContainer((AndroidDriver) driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Logger.log("Driver launched successfully!");
			
		}else if(env=="ios") 
		{
			//not implemented yet
		}
	}
	

	
	/** Uninstall the app
	 * 
	 * @param appPackage the package name of the app to be uninstalled
	 * @throws IOException
	 * @throws InterruptedException
	 */
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
