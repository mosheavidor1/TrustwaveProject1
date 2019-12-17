package Utils.PropertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public  class PropertiesFile {
	//reads test properties from config.properties file

	    private static Properties properties;
	    private static InputStream inputStream = null;
	    private static PropertiesFile file=null;
	    

	    private PropertiesFile() throws IOException {
	        properties = new Properties();
	        loadProperties();
	    }

	    private static void loadProperties() throws IOException {
            inputStream = new FileInputStream("src/test/java/utils/PropertiesFile/config.properties");
            properties.load(inputStream);
	    }

	    public static String readProperty(String key) throws IOException {
	    	if(file==null)
	    		file=new PropertiesFile();
	        return properties.getProperty(key);
	    }
	

}
