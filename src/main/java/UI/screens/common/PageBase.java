package UI.screens.common;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import actionEngines.DriverBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

/**
 * @author Avinash Patel
 */
public class PageBase extends DriverBase{

	public AndroidDriver driver;

	/**
	 * Constructor of the class.
	 * 
	 * @param driver
	 *            - driver
	 */
	public PageBase(AndroidDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	

	/**
	 * Method to clear and input the text for an WebElement.
	 * 
	 * @param element
	 *            - WebElement to be clickable
	 * @param value
	 *            - Value to be inserted
	 */
	public void inputText(WebElement element, String value) {
		waitForElementTobeClickable(element);
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * Method to click on an element.
	 * 
	 * @param element
	 *            - WebElement to be clicked.
	 * @throws Exception 
	 */
	public void click(MobileElement element) throws Exception {
		if (isElementPresent(element)) {
			waitForElementTobeClickable(element);
			element.click();
		} else {
			System.out.println("Element not visible" + element);
		}

	}
	

	/**
	 * Method to click on an element(click Element) and wait for other element
	 * (wait Element).
	 * 
	 * @param clickElement
	 *            - WebElement to be clicked
	 * @param waitElement
	 *            - WebElement to wait for after clicking
	 */
	public void clickAndWait(MobileElement clickElement, MobileElement waitElement) {
		clickElement.click();
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(waitElement));
	}

	
	/**
	 * Method to press back button in the android phone. 
	 */
	public void clickBackButton() {
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}

	
	/**
	 * Method to hide the keyboard in the app 
	 */
	public void hideKeyboard() {
		driver.hideKeyboard();
	}
	
	
	/**
	 * Method to verify whether the element is present or not.
	 * 
	 * @param element
	 *            - WebElement to be check whether present or not.
	 * 
	 * @return - TRUE, if element is present.
	 * @throws Exception 
	 */
	public boolean isElementPresent(MobileElement element) throws Exception {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			throw new Exception(element + " not found");
		}

	}

	public void enableLocationServices() {
		
	}
	
	/**
	 * Method to get text from the WebElement
	 * 
	 * @param element
	 *            - WebElement from which the text is to be fetched.
	 * 
	 * @return - Text, if present. - Null, if not present
	 */
	public String getText(WebElement element) {
		try {
			return element.getText();
		} catch (NoSuchElementException e) {
			return null;
		}

	}
	

	/**
	 * Method to verify if the string is present or not.
	 * 
	 * @param string
	 *            - to be check whether it is present or not.
	 * 
	 * @return TRUE, if string is present FALSE, if string is not present
	 */
	public boolean isStringPresent(String string) {
		try {
			return driver.getPageSource().contains(string);
		} catch (NoSuchElementException e) {
			return false;
		}

	}
	
	

	/**
	 * Method to perform mouse hover action on the element parameter
	 * 
	 * @param element
	 *            - WebElement to be hovered upon
	 * @throws IOException
	 *             throws IOException
	 */
	public void mouseHoverAndClickOnElement(WebElement element) throws IOException {

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	
	/**
	 * Method to select specified text from a dropdown(element)
	 * 
	 * @param element
	 *            - WebElement of the drop down
	 * @param textToBeSelected
	 *            - text value to be selected from the dropdown
	 */
	public void selectByVisibleText(WebElement element, String textToBeSelected) {
		waitForElementTobeClickable(element);
		Select select = new Select(element);
		select.selectByVisibleText(textToBeSelected);

	}

	/**
	 * Method to select specified Index from a dropdown(element)
	 * 
	 * @param element
	 *            - WebElement of the drop down
	 * 
	 * @param indexToBeSelected
	 *            - index value to be selected from the dropdown
	 */
	public void selectByIndex(WebElement element, int indexToBeSelected) {
		waitForElementTobeClickable(element);
		Select select = new Select(element);
		select.selectByIndex(indexToBeSelected);
	}



	/**
	 * Method to wait for the element on the web page to be clickable
	 * 
	 * @param element
	 *            - WebElement to be clickable
	 */
	public void waitForElementTobeClickable(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, 20);
		try {
			w.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void waitForElementTillnotPresent(MobileElement element) {
		WebDriverWait w = new WebDriverWait(driver, 20);
		try {
			w.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void waitForElementToBePresent(MobileElement element) {
		WebDriverWait w = new WebDriverWait(driver, 20);
		try {
			w.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method to click on an element using Javascript executer.
	 * 
	 * @param element
	 *            - WebElement to be clicked
	 */
	public void jsclick(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// from the specified container, click on the text that is passed as
	// parameter
	public void selectElementFromContainer(WebElement element, String tagName, String textToBeClicked)
			throws IOException {
		List<WebElement> list = element.findElements(By.tagName(tagName));
		for (WebElement webElement : list) {
			if (webElement.getText().equals(textToBeClicked)) {
				webElement.click();
			}
		}
	}

	/**
	 * Method to verify if Alert is present.
	 * 
	 * @return TRUE, if alert is present FALSE, if alert is not present.
	 */
	public boolean isAlertPresent() {

		try {
			Alert alert = driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Method to check if the element is selected or not.
	 * 
	 * @param element
	 *            - WebElement to be checked
	 * 
	 * @return TRUE, if WebElement is selected FALSE, if WebElement is not
	 *         selected
	 */
	public boolean isElementSelected(WebElement element) {

		try {
			return element.isSelected();
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	
	public boolean retryingFindClick(WebElement element) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				element.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	/**
	 * Method to wait(waitElement) till String(textToAppear) is present.
	 * 
	 * @param waitElement
	 *            - WebElement to wait for.
	 * @param textToAppear
	 *            - Text to be present in the expected element.
	 */
	public void waitTillTextPresent(WebElement waitElement, String textToAppear) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.textToBePresentInElement(waitElement, textToAppear));
	}
	
	
	
	/** MEthod to tap on the element using theri X,Y coordinates.
	 * 
	 * @param x - X-coordinate of the element
	 * @param y - Y-coordinate of the element
	 */
	public void tapOnElement(int x, int y) {
		tapOn.tap(PointOption.point(x, y)).perform();
	}
	
	public void sleep(int sec) throws InterruptedException {
		long secs=sec*1000;
        Thread.sleep(secs);
	}
}
