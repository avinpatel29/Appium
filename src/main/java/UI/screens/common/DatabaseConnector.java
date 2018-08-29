package UI.screens.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Avinash Patel
 *
 */
public class DatabaseConnector {

	public WebDriver driver;
	public static Connection conn = null;

	/**
	 * Constructor of the class.
	 * 
	 * @param driver
	 *            - driver
	 */
	public DatabaseConnector(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	
	/** Method to connect to a database.
	 * 
	 * @param dbURL - Database URL
	 * @param user -  username 
	 * @param password - Password
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public void getConnection(String dbURL,String user, String password) throws SQLException, ClassNotFoundException {
//		Properties parameters = new Properties();
//		parameters.put("user", user);
//		parameters.put("password", password);
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection(dbURL, user,password);
		if (conn != null) {
			System.out.println("Connected to the database...");
		} else {
			System.out.println("Database connection failed to Environment");
		}
	}

	/** Method to execute the database query.
	 * 
	 * @param SQL - Query to be executed
	 * @return 
	 * @return ArrayList where the resultset is stored
	 * @throws SQLException
	 */
	public ResultSet dbQueryExecution(String SQL) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery(SQL);
//		while(rs.next())
//		{
//		    System.out.println(rs.getString("odometer")); 
//		}
//		printResultSet(rs);
		return resultSet;
	}
	
	
	public int dbQueryUpdate(String SQL) throws SQLException {
		Statement stmt = conn.createStatement();
		int resultSet = stmt.executeUpdate(SQL);
//		while(rs.next())
//		{
//		    System.out.println(rs.getString("odometer")); 
//		}
//		printResultSet(rs);
		return resultSet;
	}

	
	public String getColumnValue(ResultSet rs, String colName) throws SQLException {
		String colvalue = null;
		while(rs.next())
			{
//			    System.out.println(rs.getString(colName)); 
			    colvalue=rs.getString(colName);
			}
		return colvalue;
	}
	
	
	public static void printResultSet(ResultSet rs) throws SQLException
	{
	    ResultSetMetaData rsmd = rs.getMetaData();
	    int columnsNumber = rsmd.getColumnCount();
	    while (rs.next()) {
	        for (int i = 1; i <= columnsNumber; i++) {
	        	
	            if (i > 1) System.out.print(" | ");
	            System.out.print(rsmd.getColumnName(i)+" - "+rs.getString(i));
	        }
	        System.out.println("");
	    }
	}
	/** Method to close the database connection.
	 * 
	 * @throws SQLException
	 */
	public void closeDBConnection() throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}

	public void fetchValuesFromUI() {
	
		
	}
	
	public void updateBikeLatLong(String latLon, String bikeID) throws SQLException {
		 String latLong[]= latLon.split(",");
		 //System.out.println("update bike set lat="+latLong[0]+",lon="+latLong[1]+" where id="+bikeID);
		 String SQL="update bike set lat="+latLong[0]+",lon="+latLong[1]+" where id="+bikeID;
		 dbQueryUpdate(SQL);
	}

	public String getBikeStatus(String bikeId) throws SQLException {
		Statement stmt = conn.createStatement();
		//System.out.println("select * from bike where id="+bikeId);
		ResultSet rs = stmt.executeQuery("select * from bike where id="+bikeId);
		return getColumnValue(rs, "status");
	}
}