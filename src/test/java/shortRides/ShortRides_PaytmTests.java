package shortRides;

import java.util.HashMap;
import org.testng.Assert;
import actionEngines.DriverBase;
import utilities.Logger;


/**
 * @author Akhilesh
 *
 */
public class ShortRides_PaytmTests extends DriverBase{
	
	
//	@Test(priority=6, dataProvider = "route_aswadHosp_audiHosur", dataProviderClass=ShortRides_DataProvider.class)
	public void tryBookingWithoutPayTM(HashMap<String, String> hm) throws Exception {
		
		//Retrieve the current status of the bike and assert with 'idle' & Set the bike to the location where the trip starts
		Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "idle");
		container.databaseconnector.updateBikeLatLong(hm.get("startLatLong"), hm.get("bikeID"));
		launchApp();
		
		container.shortride.inputStartLoc(hm.get("startLoc"));
		container.shortride.selectBike();
		container.shortride.inputDestinationLoc(hm.get("endLoc"));
		container.shortride.verifyPickUpLoc();
		Assert.assertEquals(container.shortride.verifyDestLoc(hm.get("endLoc")),true);
		container.shortride.clickConfirmPickupButton();
		Assert.assertTrue(container.linkPayTMPopUp.getLinkPayTMPopUpNo().isDisplayed());
		Assert.assertEquals(container.linkPayTMPopUp.getLinkPayTMPopUpText().getText(),container.linkPayTMPopUp.getLinkPayTMPopUpTextValue(),"Pay TM link pop up text verification");
		Assert.assertEquals(container.linkPayTMPopUp.getLinkPayTMPopUpNo().getText(),container.linkPayTMPopUp.getLinkPayTMPopUpNoTextValue(),"Pay TM link pop up No label is visible");
		Assert.assertEquals(container.linkPayTMPopUp.getLinkPayTMPopUpYes().getText(),container.linkPayTMPopUp.getLinkPayTMPopUpYesTextValue(),"Pay TM link pop up Yes label is visible");
		Logger.log("Verification of PayTM pop up is done");
		container.linkPayTMPopUp.getLinkPayTMPopUpYes().click();
		Logger.log("Get to PayTM PopUp page");
		Assert.assertTrue(container.linkPayTMPage.getLinkPayTMPageHeadingText().isDisplayed());
		Assert.assertEquals(container.linkPayTMPage.getLinkPayTMPageHeadingText().getText(),container.linkPayTMPage.getLinkPayTMPageHeadingTextValue(),"Compare heading text value");
		Assert.assertEquals(container.linkPayTMPage.getLinkPayTMPageMobileNumberTextBox().getText(),container.linkPayTMPage.getLinkPayTMPageMobileNumberTextValue());
		Assert.assertEquals(container.linkPayTMPage.getLinkPayTMPageNextButton().getText(),container.linkPayTMPage.getLinkPayTMPageNextTextValue());
		Logger.log("Done with verification of PayTM page");
	}
}
