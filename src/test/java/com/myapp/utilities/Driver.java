package com.myapp.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {
    //Driver Object
    private static WebDriver driver;
    //1. getDriver: set up and instantiate the driver objet
    public static WebDriver getDriver(){
        if(driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":

                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":

                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "safari":
                WebDriverManager.safaridriver().setup();
                driver=new SafariDriver();
                break;



            }




        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }
    //2. closeDriver: quits the drivedr
    public  static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
