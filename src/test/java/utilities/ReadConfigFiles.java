package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class ReadConfigFiles {
    public static final Logger LOGGER = LogManager.getLogger(ReadConfigFiles.class);

    public static String getPropertyValues(String KeyName) {
        Properties prop;
        String propValue = null;
        try {
           prop = new LoadConfigFiles().readPropertyValues();
           propValue = prop.getProperty(KeyName);
           } catch (Exception e) {
            LOGGER.error("Exception is: " + e.getMessage());
        }
       return propValue;
    }
}
