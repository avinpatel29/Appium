package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class getQueries {
	
	public static String getProperties(String key) {
		Properties p = new Properties();
		String FilePath = System.getProperty("user.dir") + "/src/main/resources/queries.properties";
		FileInputStream fi = null;
		try {
		fi = new FileInputStream(FilePath);
		p.load(fi);
		return (String) p.getProperty(key);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
