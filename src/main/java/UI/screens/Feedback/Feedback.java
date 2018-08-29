package UI.screens.Feedback;

import org.openqa.selenium.NoSuchElementException;

import UI.screens.common.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import junit.framework.Assert;

public class Feedback extends PageBase{
	
	public Feedback(AppiumDriver driver) {
		super((AndroidDriver) driver);
	}
	
	/*
	 * ========================================================================
	 * 							Locators
	 * ========================================================================
	 */
	
	@AndroidFindBy(xpath= "//*[@text='Short Ride']")
	private MobileElement shortRide_text;
	
	@AndroidFindBy(xpath= "//*[@text='Feedback']")
	private MobileElement feedback_text;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/arrow")
	private MobileElement down_arrow;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/drop_location")
	private MobileElement drop_location_value;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/amount")
	private MobileElement amount;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/hour")
	private MobileElement hours;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/submit")
	private MobileElement submit_button;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/ratingBar2")
	private MobileElement rating_bar;
	
	@AndroidFindBy(xpath= "//*[@text='Tell us what you liked…']")
	private MobileElement Tell_us_what_you_liked_text;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/comments")
	private MobileElement comments_section;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/ChargesandTarrifRootlayout")
	private MobileElement Charges_and_tariff_card;
	
	@AndroidFindBy(xpath= "//*[@text='Distance-wise Price']")
	private MobileElement distance_wise_price_text;
	
	@AndroidFindBy(xpath= "//*[@class='android.widget.RelativeLayout' and ./*[@text='Distance-wise Price']]/*[@resource-id='com.metrobikes.app:id/value']")
	private MobileElement distance_wise_price_value;
	
	@AndroidFindBy(xpath= "//*[@text='Duration-wise Price']")
	private MobileElement duration_wise_price_text;
	
	@AndroidFindBy(xpath= "//*[@class='android.widget.RelativeLayout' and ./*[@text='Duration-wise Price']]/*[@resource-id='com.metrobikes.app:id/value']")
	private MobileElement duration_wise_price_value;
	
	@AndroidFindBy(xpath= "//*[@text='Delivery Price']")
	private MobileElement delivery_price_text;
	
	@AndroidFindBy(xpath= "//*[@class='android.widget.RelativeLayout' and ./*[@text='Delivery Price']]/*[@resource-id='com.metrobikes.app:id/value']")
	private MobileElement delivery_price_value;
	
	@AndroidFindBy(xpath= "//*[@text='Promotional Balance Applied']")
	private MobileElement promo_bal_applied_text;
	
	@AndroidFindBy(xpath= "//*[@class='android.widget.RelativeLayout' and ./*[@text='Promotional Balance Applied']]/*[@resource-id='com.metrobikes.app:id/value']")
	private MobileElement promo_bal_applied_value;
	
	@AndroidFindBy(xpath= "//*[@text='MetroBikes Wallet applied']")
	private MobileElement metrobike_wallet_text;
	
	@AndroidFindBy(xpath= "//*[@class='android.widget.RelativeLayout' and ./*[@text='MetroBikes Wallet applied']]/*[@resource-id='com.metrobikes.app:id/value']")
	private MobileElement metrobike_wallet_value;
	
	@AndroidFindBy(xpath= "//*[@text='Tax']")
	private MobileElement tax_text;
	
	@AndroidFindBy(xpath= "//*[@class='android.widget.RelativeLayout' and ./*[@text='Tax']]/*[@resource-id='com.metrobikes.app:id/value']")
	private MobileElement tax_value;
	
	@AndroidFindBy(xpath= "(//*[@text='Total Amount']")
	private MobileElement total_amount_text;
	
	@AndroidFindBy(xpath= "//*[@class='android.widget.RelativeLayout' and ./*[@text='Total Amount']]/*[@resource-id='com.metrobikes.app:id/value']")
	private MobileElement total_amount_value;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/thankYou")
	private MobileElement thank_you_text;
	
	@AndroidFindBy(id= "com.metrobikes.app:id/dismissButton")
	private MobileElement dismiss_button;
	
	
	/*
	 * ========================================================================
	 * 							Methods
	 * ========================================================================
	 */
	
	
	/** Method to verify Feedback screen is present or not.
	 * 
	 * @return	True, if feedback screen is present
	 * 			False, If feedback screen is not present.
	 * @throws Exception
	 */
	public boolean verifyFeedbackText() throws Exception {
		return isElementPresent(feedback_text);
	}
	
	/**Method to click on down arrow to show breakup cost of the completed trip.
	 * 
	 * @throws Exception
	 */
	public void clickArrowButton() throws Exception {
		if(isElementPresent(feedback_text)) {
			waitForElementTobeClickable(down_arrow);
			click(down_arrow);
			try{
				if(!isElementPresent(Charges_and_tariff_card)) {}
			}catch(Exception e) {
				click(down_arrow);
			}				
		}
	}
	
	/** Method to get the Distance wise price for the completed trip.
	 * 
	 * @return Amount charged for "Distance-wise" for the completed trip.
	 * @throws Exception
	 */
	public String getDistanceWisePrice() throws Exception 
	{
		String price=getText(distance_wise_price_value);
		if(isElementPresent(Charges_and_tariff_card)){
			System.out.println(price.split(" ")[1]);
			return price.split(" ")[1];
		}else 
			return "";
		
	}
	
	/** Method to get the Duration wise price for the completed trip.
	 * 
	 * @return Amount charged for "Duration-wise" for the completed trip.
	 * @throws Exception
	 */
	public String getDurationWisePrice() throws Exception 
	{
		String price=getText(duration_wise_price_value);
		if(isElementPresent(Charges_and_tariff_card))
		{
		System.out.println(price.split(" ")[1]);
			return price.split(" ")[1];
		}else 
			return "";
		
	}
	
	/** Method to get the delivery price for the completed trip.
	 * 
	 * @return Amount charged for "Delivery Price" for the completed trip.
	 * @throws Exception
	 */
	public String getDeliveryPrice() throws Exception {
		String price=getText(delivery_price_value);
		if(isElementPresent(Charges_and_tariff_card)){
			System.out.println(price.split(" ")[1]);
			return price.split(" ")[1];
		}else 
			return "";
		
	}
	
	/** Method to get the Promotional Balance amount for the completed trip.
	 * 
	 * @return	Amount of "Promotional Balance Applied" for the completed trip
	 * @throws Exception
	 */
	public String getPromoBalApplied() throws Exception {
		String price=getText(promo_bal_applied_value);
		if(isElementPresent(Charges_and_tariff_card)){
			System.out.println(price.split(" ")[1]);
			return price.split(" ")[1];
		}else 
			return "";
	}
	
	/** Method to get the MetroBike Walled amount for the completed trip.
	 * 
	 * @return	Amount of the "MetroBike Walled Applied" for the completed trip 
	 * @throws Exception
	 */
	public String getMetroBikeWalletApplied() throws Exception {
		String price=getText(metrobike_wallet_value);
		if(isElementPresent(Charges_and_tariff_card)){
			System.out.println(price.split(" ")[1]);
			return price.split(" ")[1];
		}else 
			return "";
	}
	
	/**Method to get the tax for the completed trip.
	 * 
	 * @return	Value of the "Tax" for the trip completed.
	 * @throws Exception
	 */
	public String getTax() throws Exception {
		String price=getText(tax_value);
		if(isElementPresent(Charges_and_tariff_card)){
			System.out.println(price.split(" ")[1]);
			return price.split(" ")[1];
		}else 
			return "";
	}
	
	
	/** Method to get the total amount for the completed trip.
	 * 
	 * @return value of the "Total Amount" for the trip.
	 *  
	 * @throws Exception
	 */
	public String getTotalAmount() throws Exception {
		String price=getText(total_amount_value);
		if(isElementPresent(Charges_and_tariff_card)){
			System.out.println(price.split(" ")[1]);
			return price.split(" ")[1];
		}else 
			return "";
		
	}
	
	/** Method to get the values of the breakup components
	 * 
	 * @throws Exception
	 */
	public void getBreakdownAmount() throws Exception {
		getDistanceWisePrice();
		getDurationWisePrice();
		getDeliveryPrice();
		getPromoBalApplied();
		getMetroBikeWalletApplied();
		getTax();
		getTotalAmount();
		
	}
	
	/** Method to verify all the components are present or not in the breakup.
	 *  
	 * @throws Exception
	 */
	public void verifyBreakupComponents() throws Exception {
		Assert.assertEquals(isElementPresent(delivery_price_text), true);
		Assert.assertEquals(isElementPresent(distance_wise_price_text), true);
		Assert.assertEquals(isElementPresent(delivery_price_text), true);
		Assert.assertEquals(isElementPresent(promo_bal_applied_text), true);
		Assert.assertEquals(isElementPresent(metrobike_wallet_text), true);
		Assert.assertEquals(isElementPresent(tax_text), true);
		Assert.assertEquals(isElementPresent(total_amount_text), true);
	}
	
	
	/** Method to click on submit button on the feedback page.
	 * 
	 * @throws Exception
	 */
	public void clickSubmitButton() throws Exception {
		clickAndWait(down_arrow, submit_button);
		if(isElementPresent(submit_button)) {
			click(submit_button);
			try {
				waitForElementToBePresent(thank_you_text);
				clickAndWait(dismiss_button,shortRide_text);
			}catch (NoSuchElementException e) {
				
			}
		}
	}
}
