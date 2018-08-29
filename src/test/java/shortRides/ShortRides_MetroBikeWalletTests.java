package shortRides;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import actionEngines.DriverBase;
import utilities.DBCredentials;

/**
 * @author Avinash Patel
 *
 */
public class ShortRides_MetroBikeWalletTests extends DriverBase{

	@BeforeClass
	public void preRequisites() throws Exception
	{
		LaunchApp("Android", "emulator");
		String dbURL=DBCredentials.getProperties("DB_URL");
		String user=DBCredentials.getProperties("DB_Username");
		String password=DBCredentials.getProperties("DB_Password");
		container.databaseconnector.getConnection(dbURL, user, password);
	}
	
	@AfterMethod
	public void CloseApp() {
		closeApp();
	}
	
	

	//================================================================================================================//
	
	/**
	 * @param hm
	 * @throws Exception
	 */
	@Test(priority=4, dataProvider = "route_aswadHosp_audiHosur", dataProviderClass=ShortRides_DataProvider.class)
	public void bookARide(HashMap<String, String> hm) throws Exception {
		
		//Retrieve the current status of the bike and assert with 'idle' & Set the bike to the location where the trip starts
		Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "idle");
		container.databaseconnector.updateBikeLatLong(hm.get("startLatLong"), hm.get("bikeID"));

		container.shortride.inputStartLoc(hm.get("startLoc"));
		container.shortride.selectBike();
		container.shortride.inputDestinationLoc(hm.get("endLoc"));
		container.shortride.verifyPickUpLoc();
		Assert.assertEquals(container.shortride.verifyDestLoc(hm.get("endLoc")), true);
		container.shortride.clickConfirmPickupButton();
		container.apiHandler.api_startTrip(hm.get("bikeAccessCode"));
		Thread.sleep(2000);
		container.apiHandler.api_sendLatLong(hm.get("bikeAccessCode"), hm.get("latLong1"), hm.get("odometer1"));
		Thread.sleep(60000);
		container.apiHandler.api_sendLatLong(hm.get("bikeAccessCode"), hm.get("latLong2"), hm.get("odometer2"));
		Thread.sleep(60000);
		container.apiHandler.api_sendLatLong(hm.get("bikeAccessCode"), hm.get("latLong3"), hm.get("odometer3"));
		Thread.sleep(60000);
		container.apiHandler.api_sendLatLong(hm.get("bikeAccessCode"), hm.get("endLatLong"), hm.get("endOdometer"));
		container.apiHandler.api_endTrip(hm.get("bikeAccessCode"));
		closeApp();

		// Re-launch the app to get the feedback screen
		launchApp();
		Thread.sleep(10000);
		container.feedback.clickArrowButton();
		container.feedback.getBreakdownAmount();
		container.feedback.clickSubmitButton();
		
		//Check the status of the bike change from "oos" state to "idle" 
		Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "oos");
		Thread.sleep(130000);
		Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "idle");
	}

	//================================================================================================================//
	
	@Test(priority=5, dataProvider = "route_aswadHosp_audiHosur", dataProviderClass=ShortRides_DataProvider.class)
	public void pauseBike_checkBikeStatusInDB(HashMap<String,String> hm) throws Exception{
		
		//Set the bike to the location where the trip starts
		Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "idle");
		container.databaseconnector.updateBikeLatLong(hm.get("startLatLong"), hm.get("bikeID"));
		launchApp();				 
		
		container.shortride.inputStartLoc(hm.get("startLoc"));
		container.shortride.selectBike();
		container.shortride.inputDestinationLoc(hm.get("endLoc"));
		container.shortride.verifyPickUpLoc();
		Assert.assertEquals(container.shortride.verifyDestLoc(hm.get("endLoc")),true);
		container.shortride.clickConfirmPickupButton();
		container.apiHandler.api_startTrip(hm.get("bikeAccessCode"));
		Thread.sleep(10000);
		container.apiHandler.api_pauseTrip(hm.get("bikeAccessCode"));
		
		//Retrieve the current status of the bike and assert with 'Busy'
		Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "busy");
		container.apiHandler.api_resumeTrip(hm.get("bikeAccessCode"));
		container.apiHandler.api_endTrip(hm.get("bikeAccessCode"));
		closeApp();
		
		launchApp();
		container.feedback.clickSubmitButton();
		Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "oos");
		Thread.sleep(130000);
		Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "idle");
	}

}
