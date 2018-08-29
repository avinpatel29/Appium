package shortRides;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import org.testng.annotations.DataProvider;
import actionEngines.DriverBase;

public class ShortRides_DataProvider extends DriverBase {

	
	@DataProvider(name = "route_aswadHosp_audiHosur")
	public static Object[][] route_aswadHosp_audiHosur() throws Exception {
		
		HashMap<String,String> hm=new HashMap<String,String>();  
		hm.put("bikeID", readExcel.getCellDataUsingColNum("routes", 1, 2));
		hm.put("bikeLicensePlate", readExcel.getCellDataUsingColNum("routes", 2, 2));
		hm.put("bikeAccessCode", readExcel.getCellDataUsingColNum("routes", 3, 2));
		hm.put("startLoc", readExcel.getCellDataUsingColNum("routes", 4, 2));
		hm.put("endLoc", readExcel.getCellDataUsingColNum("routes", 5, 2));
		hm.put("startLatLong", readExcel.getCellDataUsingColNum("routes", 6, 2));
		hm.put("latLong1", readExcel.getCellDataUsingColNum("routes", 7, 2));
		hm.put("odometer1", readExcel.getCellDataUsingColNum("routes", 8, 2));
		hm.put("latLong2", readExcel.getCellDataUsingColNum("routes", 9, 2));
		hm.put("odometer2", readExcel.getCellDataUsingColNum("routes", 10, 2));
		hm.put("latLong3", readExcel.getCellDataUsingColNum("routes", 11, 2));
		hm.put("odometer3", readExcel.getCellDataUsingColNum("routes", 12, 2));
		hm.put("endLatLong", readExcel.getCellDataUsingColNum("routes", 13, 2));
		hm.put("endOdometer", readExcel.getCellDataUsingColNum("routes", 14, 2));
		
//		Set<Entry<String,String>> hashSet=hm.entrySet();
//        for(Entry entry:hashSet ) {
//
//            System.out.println("Key="+entry.getKey()+", Value="+entry.getValue());
//        }
		return new Object[][] { {hm} };
	}
	
	
	
	@DataProvider(name = "route_aswadHosp_audiHosur_auto12")
	public static Object[][] route_aswadHosp_audiHosur_auto12() throws Exception {
		
		HashMap<String,String> hm=new HashMap<String,String>();  
		hm.put("bikeID", readExcel.getCellDataUsingColNum("routes", 1, 3));
		hm.put("bikeLicensePlate", readExcel.getCellDataUsingColNum("routes", 2, 3));
		hm.put("bikeAccessCode", readExcel.getCellDataUsingColNum("routes", 3, 3));
		hm.put("startLoc", readExcel.getCellDataUsingColNum("routes", 4, 3));
		hm.put("endLoc", readExcel.getCellDataUsingColNum("routes", 5, 3));
		hm.put("startLatLong", readExcel.getCellDataUsingColNum("routes", 6, 3));
		hm.put("latLong1", readExcel.getCellDataUsingColNum("routes", 7, 3));
		hm.put("odometer1", readExcel.getCellDataUsingColNum("routes", 8, 3));
		hm.put("latLong2", readExcel.getCellDataUsingColNum("routes", 9, 3));
		hm.put("odometer2", readExcel.getCellDataUsingColNum("routes", 10, 3));
		hm.put("latLong3", readExcel.getCellDataUsingColNum("routes", 11, 3));
		hm.put("odometer3", readExcel.getCellDataUsingColNum("routes", 12, 3));
		hm.put("endLatLong", readExcel.getCellDataUsingColNum("routes", 13, 3));
		hm.put("endOdometer", readExcel.getCellDataUsingColNum("routes", 14, 3));
		
//		Set<Entry<String,String>> hashSet=hm.entrySet();
//        for(Entry entry:hashSet ) {
//
//            System.out.println("Key="+entry.getKey()+", Value="+entry.getValue());
//        }
		return new Object[][] { {hm} };
	}
}
