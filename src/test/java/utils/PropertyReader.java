package utils;

import enums.PropertyEnum;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertyReader {

    private static volatile Properties properties;
    private static String currentLanguage;

    private PropertyReader() {
    }

    public static void initProperties(String language) {
        currentLanguage = language;
        properties = null;
    }

    public static Properties readProperties() {
        if (properties != null) {
            return properties;
        }

        properties = new Properties();

        if (StringUtils.isNotBlank(currentLanguage)) {
            String languageFile = "/" + currentLanguage + ".properties";
            Properties languageProps = loadPropertiesFromFile(languageFile);
            properties.putAll(languageProps);
        }

        Properties configProperties = loadPropertiesFromFile("/config.properties");
        properties.putAll(configProperties);

        return properties;
    }

    private static Properties loadPropertiesFromFile(String path) {
        Properties props = new Properties();

        try (InputStream inputStream = PropertyReader.class.getResourceAsStream(path);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

            props.load(inputStreamReader);
            System.out.println("Loaded properties from: " + path);

        } catch (IOException ex) {
            System.err.println("Error loading properties from " + path + ": " + ex.getMessage());
            ex.printStackTrace();
        }

        return props;
    }

    public static Properties getProperties(String path) {
        return loadPropertiesFromFile(path);
    }

    public static String getProperty(String propertyName) {
        if (properties == null) {
            readProperties();
        }

        return properties.getProperty(propertyName);
    }

    public static String getProperty(PropertyEnum propertyEnum) {
        return getProperty(propertyEnum.getValue());
    }
}
