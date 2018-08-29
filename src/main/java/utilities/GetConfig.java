package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;


public class GetConfig {
	

	/** Method to get property from properties file.
	 * 
	 * @param key - Key name whose value is to be fetched 
	 * @return - Returns the value for the key given
	 */
	public static String getProperty(String key) {
		Properties p = new Properties();
		String FilePath = System.getProperty("user.dir")+"/src/main/resources/config.properties";
		FileInputStream fi= null;
		try {
			fi= new FileInputStream(FilePath);
			p.load(fi);
			return (String) p.getProperty(key);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/** Method to update a value of a  property in properties file.
	 * 
	 * @param userToken - Key name whose value is to be updated
	 * @return - returns the update value of the key 
	 */
	public static String updateProperties(String userToken) {
		Properties p = new Properties();
		String FilePath = System.getProperty("user.dir")+"/src/main/resources/config.properties";
		FileInputStream fi= null;
		FileOutputStream fo= null;
		try {
			fi= new FileInputStream(FilePath);
			p.load(fi);
			fi.close();
			
			fo=new FileOutputStream(FilePath);
			p.setProperty("userToken", userToken);
			p.store(fo, null);
			fo.close();
			return (String) p.getProperty(userToken);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
