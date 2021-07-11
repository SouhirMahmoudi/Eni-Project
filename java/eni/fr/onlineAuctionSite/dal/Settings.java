/**
 * 
 */
package eni.fr.onlineAuctionSite.dal;

/**
 * @author smahmoudi2021
 *
 */
import java.util.Properties;



/**
 * @author Eni Ecole
 *
 */
public class Settings {
	private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			properties.load(Settings.class.getResourceAsStream("Settings.properties"));
			//properties.loadFromXML(Settings.class.getResourceAsStream("settings.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		String parametre = properties.getProperty(key,null);
		return parametre;
	}

}