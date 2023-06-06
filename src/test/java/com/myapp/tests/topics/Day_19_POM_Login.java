package com.myapp.tests.topics;

import com.myapp.pages.OrangeHRMDashboardPage;
import com.myapp.pages.OrangeHRMLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day_19_POM_Login {
    //Create a test case to login the https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    //using page object model

    @Test(groups = "regression1")
    public void loginTest(){
        /*
        1-Locate page objects in page class
        2-Create page objects and call those page objects
         */
        OrangeHRMLoginPage orangeHRMLoginPage=new OrangeHRMLoginPage();
        OrangeHRMDashboardPage orangeHRMDashboardPage=new OrangeHRMDashboardPage();
        Driver.getDriver().get(ConfigReader.getProperty("orange_app_url"));
       orangeHRMLoginPage.username.sendKeys("Admin");
       orangeHRMLoginPage.password.sendKeys("admin123");
       orangeHRMLoginPage.submitButton.click();
       //Verify the login is succesfull
     //  Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
       Assert.assertTrue(orangeHRMDashboardPage.profile.isDisplayed());
        //Then logout the application
orangeHRMDashboardPage.profile.click();
orangeHRMDashboardPage.logout.click();
        //Then verify logout is succesfull

Assert.assertTrue(orangeHRMLoginPage.submitButton.isDisplayed());


    }
}
