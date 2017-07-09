package com.comodin.basic.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * The type Properties util.
 */
@SuppressWarnings({"Duplicates", "WeakerAccess", "Convert2Diamond", "unused"})
public class PropertiesUtil {
    private static PropertiesUtil util = null;
    private static Map<String, Properties> maps = new HashMap<String, Properties>();
    private static final Logger log = Logger.getLogger(PropertiesUtil.class);

    private PropertiesUtil() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static PropertiesUtil getInstance() {
        if (util == null) {
            util = new PropertiesUtil();
            maps = new HashMap<String, Properties>();
        }
        return util;
    }

    /**
     * Load properties.
     *
     * @param name the name
     *
     * @return the properties
     */
    public Properties load(String name) {
        if (maps.get(name) != null) {
            return maps.get(name);
        } else {
            Properties prop = new Properties();
            try {
                prop.load(PropertiesUtil.class.getResourceAsStream("/" + name + ".properties"));
                prop.forEach((key, value) -> log.info("key=value:\t\t" + key + "=" + value));
                maps.put(name, prop);
                return prop;
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * @param propertiesName  //
     * @param inStream       路径的最后一定要增加/，xxx/
     *
     * @return  //
     */
    public Properties load(String propertiesName, InputStream inStream) {
        if (maps.get(propertiesName) != null) {
            return maps.get(propertiesName);
        } else {
            Properties prop = new Properties();
            try {
                prop.load(inStream);
            } catch (IOException e) {
                return null;
            }
            maps.put(propertiesName, prop);
            return prop;
        }
    }

    /**
     * @param propertiesName  //
     * @param propertiesFile 路径的最后一定要增加/，xxx/
     *
     * @return  //
     */
    public Properties load(String propertiesName, File propertiesFile) {
        if (maps.get(propertiesName) != null) {
            return maps.get(propertiesName);
        } else {
            Properties prop = new Properties();
            try {
                prop.load(new FileInputStream(propertiesFile));
            } catch (IOException e) {
                return null;
            }
            maps.put(propertiesName, prop);
            return prop;
        }
    }

    /**
     * Gets property value.
     *
     * @param propertiesFilePath the properties file path
     * @param key                the key
     *
     * @return the property value
     */
    public static String getPropertyValue(String propertiesFilePath, String key) {
        return getInstance().load(propertiesFilePath).getProperty(key);
    }

    /**
     * Gets property value int.
     *
     * @param propertiesFilePath the properties file path
     * @param key                the key
     *
     * @return the property value int
     */
    public static int getPropertyValueInt(String propertiesFilePath, String key) {
        return Integer.valueOf(getPropertyValue(propertiesFilePath, key));
    }

    /**
     * Gets property value boolean.
     *
     * @param propertiesFilePath the properties file path
     * @param key                the key
     *
     * @return the property value boolean
     */
    public static boolean getPropertyValueBoolean(String propertiesFilePath, String key) {
        return Boolean.valueOf(getPropertyValue(propertiesFilePath, key));
    }

    /**
     * Gets property value boolean.
     *
     * @param propertiesFilePath the properties file path
     * @param key                the key
     *
     * @return the property value boolean
     */
    public static Long getPropertyValueLong(String propertiesFilePath, String key) {
        return Long.valueOf(getPropertyValue(propertiesFilePath, key));
    }
}
