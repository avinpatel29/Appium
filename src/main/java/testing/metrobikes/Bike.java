package testing.metrobikes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utilities.GetConfig;
import utilities.Logger;

public class Bike{
	
	
	public static void setLatLongForBike(String bikeId,String startLatLong) throws Exception {
		ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+GetConfig.getProperty("chrome_driver"));
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("http://testing.metrobikes.in/login/");
    
        String latLong[]=startLatLong.split(",");
        webDriver.findElement(By.id("username")).sendKeys("rideAdmin");
        webDriver.findElement(By.id("password")).sendKeys("P_&$]8qh>Gxhp9PB");
        webDriver.findElement(By.xpath("//input[@value='Sign In']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//body/header[@class='top']/div[@class='navbar navbar-inverse']/div[@class='container']/div[@class='navbar-collapse collapse']/ul[@class='nav navbar-nav']/li[2]/a[1]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//li[@class='dropdown open']//ul[@class='dropdown-menu']//li[2]//a[1]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//a[@class='accordion-toggle']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//form[@id='filter_form']//button[@type='button']")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//a[@name='id']")).click();
        webDriver.findElement(By.xpath("//input[@id='id']")).sendKeys(bikeId);
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//i[@class='fa fa-edit']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//input[@id='lat']")).clear();
        webDriver.findElement(By.xpath("//input[@id='lat']")).sendKeys(latLong[0]);
        webDriver.findElement(By.xpath("//input[@id='lon']")).clear();
        webDriver.findElement(By.xpath("//input[@id='lon']")).sendKeys(latLong[1]);
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        try{
        if(webDriver.findElement(By.xpath("//title[@text='403 Forbidden']")).isDisplayed()) {
        	throw new Exception ("403 Forbidden - while updating bike's latitude & longitude");
        }
        }catch (NoSuchElementException e) {		
        	
        }
        finally {
        	Logger.log("Biker lat long has been set");
			webDriver.quit();
		}
        
	}

}
