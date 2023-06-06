package com.myapp.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
    //This class reads the configuration file,configuration.properties file with using file
    //Create properties object
    private static Properties properties;
    static {
        //path of the configuration file
        String path="configuration.properties";

        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
           e.printStackTrace();
        }


    }
    //Create method that accepts key and returns the value
    public static String getProperty(String key){
        String value=properties.getProperty(key);
        return value;
    }

    //Test
    public static void main(String[] args) {
        System.out.println(ConfigReader.getProperty("amazon_prod_url"));
        System.out.println(ConfigReader.getProperty("amazon_qa_url"));
        System.out.println(ConfigReader.getProperty("browser"));
        System.out.println(ConfigReader.getProperty("browsr"));//null
    }
}
