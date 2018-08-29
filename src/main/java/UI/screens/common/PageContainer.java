package UI.screens.common;

import UI.screens.Feedback.Feedback;
import UI.screens.LHNavigation.LHNav;
import UI.screens.UserRegistration.NewUser;
import UI.screens.ShortRides.ShortRide;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import testing.metrobikes.Bike;
import UI.screens.PayTM.LinkPayTMPage;
import UI.screens.PayTM.LinkPayTMPopUp;

/**
 * @author Avinash Patel
 *
 */
public class PageContainer {

	public AndroidDriver driver;
	public NewUser newUser;
	public LHNav lhNav;
	public ShortRide shortride;
	public APIHandler apiHandler;
	public DatabaseConnector databaseconnector;
	public Bike bike;
	public Feedback feedback;
	public LinkPayTMPopUp linkPayTMPopUp;
	public LinkPayTMPage linkPayTMPage;
	
	public PageContainer(AndroidDriver driver) {
		this.driver = driver;
		initPages();
	}

	public void initPages() {

		newUser= new NewUser(driver);
		lhNav= new LHNav(driver);
		shortride=new ShortRide(driver);
		apiHandler= new APIHandler(driver);
		databaseconnector= new DatabaseConnector(driver);
		feedback= new Feedback(driver);
		linkPayTMPopUp = new LinkPayTMPopUp(driver);
		linkPayTMPage = new LinkPayTMPage(driver);

	}

}
