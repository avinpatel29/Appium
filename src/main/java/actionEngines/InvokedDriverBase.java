package actionEngines;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import UI.screens.common.PageContainer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import utilities.ExcelDP;


public class InvokedDriverBase {

	public static ExcelDP readExcel;
	protected static AppiumDriver driver;
	protected String env,device;
	public PageContainer container;

//	@BeforeClass(alwaysRun = true)
	@org.testng.annotations.Parameters(value = { "env", "device" })
	public void LaunchDriver(String env, String device) throws Exception {

		if (env.equals("Android")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			if (device == "emulator") {
				capabilities.setCapability("VERSION", "7.1.1");
				capabilities.setCapability("device", "Android");
				capabilities.setCapability("deviceName", "Android_7");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("appPackage", "com.metrobikes.app");
				capabilities.setCapability("appActivity", "com.metrobikes.app.activities.SplashActivity");
				capabilities.setCapability("noReset",true);
				capabilities.setCapability("fullReset",false);
			} else {
				capabilities.setCapability("VERSION", "8.1.0");
				capabilities.setCapability("device", "Android");
				capabilities.setCapability("deviceName", "d8b823f1");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("appPackage", "com.metrobikes.app");
				capabilities.setCapability("appActivity", "com.metrobikes.app.activities.SplashActivity");
			}
			try {
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} catch (WebDriverException e) {
				throw new Exception("Appium server not started");
			}

			// Initiate page driver, to initiates all page objects
			container = new PageContainer((AndroidDriver) driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (env == "ios") {
			// not implemented yet
		}
	}


	public static void maximize() {
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point position = new Point(0, 0);
		driver.manage().window().setPosition(position);
		Dimension maximizedScreenSize = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
		driver.manage().window().setSize(maximizedScreenSize);
		driver.manage().window().maximize();

	}
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

	@AfterClass(alwaysRun = true)
	public void afterTest() {
//		driver.quit();
	}

	public DesiredCapabilities installedAppCaps() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "7.1.1");
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("deviceName", "Android_7");
		capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.metrobikes.app");
//        capabilities.setCapability("app","D:\\Office\\eclipse-workspace\\Appium\\AppiumFramework\\apps\\MB_TESTING-debug-66-1.9.10.apk");
        capabilities.setCapability("appActivity","com.metrobikes.app.activities.SplashActivity");
        capabilities.setCapability("deviceOrientation", "portrait");

        return capabilities;
    }
	
	public void launchApp() throws Exception {
		driver.launchApp();
	}
}
