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
public class ShortRides_ValidationTests extends DriverBase{

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
	
	
	//@Test(priority=1, dataProvider = "route_aswadHosp_audiHosur", dataProviderClass=ShortRides_DataProvider.class)
	public void selectABike_cancelBeforeConfirmPickup(HashMap<String,String> hm) throws Exception{
		
		// prerequisite: Set the bike to the location where the trip starts
		 container.databaseconnector.updateBikeLatLong(hm.get("startLatLong"), hm.get("bikeID")); 
		 
		// Retrieve the current status of the bike and assert with 'idle'
		 Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "idle");

		container.shortride.inputStartLoc(hm.get("startLoc"));
		container.shortride.selectBike();
		container.shortride.inputDestinationLoc(hm.get("endLoc"));
		Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "busy");
		container.shortride.clickDismissButton();
		
		// Retrieve the current status of the bike and assert with 'idle'
		Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "idle");
	}
	
	
	//@Test(priority=2, dataProvider = "route_aswadHosp_audiHosur", dataProviderClass=ShortRides_DataProvider.class)
	public void bookABike_cancelImmediately(HashMap<String,String> hm) throws Exception{
		
		//Retrieve the current status of the bike and assert with 'idle' & Set the bike to the location where the trip starts
		Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "idle");
		container.databaseconnector.updateBikeLatLong(hm.get("startLatLong"), hm.get("bikeID"));
		launchApp();		 

		container.shortride.inputStartLoc(hm.get("startLoc"));
		container.shortride.selectBike();
		container.shortride.inputDestinationLoc(hm.get("endLoc"));
		container.shortride.verifyPickUpLoc();
		Assert.assertEquals(container.shortride.verifyDestLoc(hm.get("endLoc")), true);
		container.shortride.clickConfirmPickupButton();
		Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "busy");
		container.shortride.clickCancelButton("No fuel");
		
		Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "idle");
	}
	
	
	//@Test(priority=3, dataProvider = "route_aswadHosp_audiHosur", dataProviderClass=ShortRides_DataProvider.class)
	public void dest_timeout_bookingExpiredCancelled(HashMap<String, String> hm) throws Exception {
		
		//Retrieve the current status of the bike and assert with 'idle' & Set the bike to the location where the trip starts
		Assert.assertEquals(container.databaseconnector.getBikeStatus( hm.get("bikeID")), "idle");
		container.databaseconnector.updateBikeLatLong(hm.get("startLatLong"), hm.get("bikeID"));
		launchApp();

		container.shortride.inputStartLoc(hm.get("startLoc"));
		container.shortride.selectBike();
		Thread.sleep(180000);
		container.shortride.inputDestinationLoc(hm.get("endLoc"));
		container.shortride.clickDismissButton();
		
	}

	@Test(priority=4, dataProvider = "route_aswadHosp_audiHosur", dataProviderClass=ShortRides_DataProvider.class)
	public void bikeCardScrollWorks(HashMap<String, String> hm) throws Exception {
		launchApp();
		container.shortride.inputStartLoc("Barbeque Nation Bengaluru");
		container.shortride.verifyBikeCard();
	}
}
