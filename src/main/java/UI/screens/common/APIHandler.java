package UI.screens.common;

import static com.jayway.restassured.RestAssured.given;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.minidev.json.JSONObject;

public class APIHandler extends PageBase{
	
	/**
	 * Constructor of the class.
	 * 
	 * @param driver - driver 
	 */
	public APIHandler(AppiumDriver driver) {
		super((AndroidDriver) driver);
	}
	
	
	/** Method to start the trip using API call (alert_v3).
	 * 
	 * @param bikeAccessCode - 16 Unique code of the bike
	 */
	public void api_startTrip(String bikeAccessCode) {
		given().when()
		.get("http://testing.metrobikes.in/wicked_ride/api/alert_v3/$$"+bikeAccessCode+"&A&1&12.456893&77.235689&1&3&1&012503&180516&300")
		.then().assertThat().statusCode(200);
	}
	
	
	
	/** Method to end the trip using API call (alert_v3).
	 * 
	 * @param bikeAccessCode - 16 Unique code of the bike
	 */
	public void api_endTrip(String bikeAccessCode) {
		given().when()
		.get("http://testing.metrobikes.in/wicked_ride/api/alert_v3/$$"+bikeAccessCode+"&A&0&12.456893&77.235689&1&3&1&012503&180516&300")
		.then().assertThat().statusCode(200);
	}

	
	/** Method to pause the in-trip using API call (alert_v3)..
	 * 
	 * @param bikeAccessCode - 16 Unique code of the bike
	 */
	public void api_pauseTrip(String bikeAccessCode) {
		given().when()
		.get("http://testing.metrobikes.in/wicked_ride/api/alert_v3/$$"+bikeAccessCode+"&B&1&12.456893&77.235689&1&3&1&012503&180516&300")
		.then().assertThat().statusCode(200);
	}
	
	
	/** Method to resume the in-trip using API call (alert_v3)..
	 * 
	 * @param bikeAccessCode - 16 Unique code of the bike
	 */
	public void api_resumeTrip(String bikeAccessCode) {
		given().when()
		.get("http://testing.metrobikes.in/wicked_ride/api/alert_v3/$$"+bikeAccessCode+"&B&0&12.456893&77.235689&1&3&1&012503&180516&300")
		.then().assertThat().statusCode(200);
	}
	
	
	/** Method to update the latitude & longitude of a bike via API (tracking_v3)
	 * 
	 * @param bikeAccessCode - 16 digit unique code of a bike
	 * @param latLong	- Latitude & Longitude of the bike		
	 * @param odometer	- Odometer reading of the bike
	 */
	public void api_sendLatLong(String bikeAccessCode, String latLong, String odometer) {
		String bodyContent ="\"##"+Long.parseLong(bikeAccessCode)+"&1&"+latLong+"|0.5|"+currentTime()+"-&"+getDate()+"&"+Long.parseLong(odometer)+"&4.027200&11.174400&1&2.308800&30\"";
//		System.out.println(bodyContent);
		given().body(bodyContent)
		.when()
		.post("http://testing.metrobikes.in/wicked_ride/api/tracking_v3")
		.then().assertThat().statusCode(200);
	}
	
	
	
//	public void cancelBooking() {
//	JSONObject requestParams = new JSONObject();
//	requestParams.put("bookingId", "Virender");
//	requestParams.put("cancelType", "HOLD CANCELLED/BOOKING CANCELLED");
//		given().body(requestParams.toJSONString())
//		.when()
//		.post("http://testing.metrobikes.in/static/swagger/index.html#/bike/cancelBooking")
//		.then().assertThat().statusCode(200);
//	}
	
	
	
	/** Method to get current time in HHMMSS format
	 * 
	 * @return Date Object in requested format
	 */
	public String currentTime() {
		DateFormat df = new SimpleDateFormat("HHmmss");
       Date dateobj = new Date();
       return df.format(dateobj);
	}

	/** Method to get today's date in YYDDMM format.
	 * 
	 * @return Date Object in requested format
	 */
	public String getDate() {
		DateFormat df = new SimpleDateFormat("yyMMdd");
       Date dateobj = new Date();
       return df.format(dateobj);
}
	
}

