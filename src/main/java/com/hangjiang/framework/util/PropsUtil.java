package com.hangjiang.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by jianghang on 2017/7/23.
 */
public class PropsUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loadProps(String fileName){
        Properties properties = null;
        InputStream is = null;
        is = ClassUtil.getClassLoader().getResourceAsStream(fileName);
        try {
            if(is == null){
                throw new FileNotFoundException(fileName + "file is not found");
            }
            properties = new Properties();
            properties.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("load properties file failure",e);
        } finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error("close input stream failure",e);
                }
            }
        }

        return properties;
    }

    public static String getString(Properties props,String key){
        return getString(props,key,"");
    }

    public static String getString(Properties props,String key,String defaultValue){
        String value = defaultValue;
        if(props.containsKey(key)){
            value = props.getProperty(key);
        }

        return value;
    }
}
