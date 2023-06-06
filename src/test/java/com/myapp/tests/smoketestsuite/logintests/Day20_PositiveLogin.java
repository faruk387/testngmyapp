package com.myapp.tests.smoketestsuite.logintests;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.MediaUtils;
import com.myapp.utilities.ReusableMethods;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_PositiveLogin {
    @Test
    public void US100201_Admin_Login(){
        /*
        Description:
        User should be able login as admin
        Acceptance Criteria:
        As admin, I should be able to log in the application
        https://www.bluerentalcars.com/
        Admin email: jack@gmail.com
        Admin password: 12345
                */
        Driver.getDriver().get(ConfigReader.getProperty("BlueRentalCarsHomePage_URL"));

        RentalHomePage rentalHomePage=new RentalHomePage();
        rentalHomePage.loginLink.click();

        RentalLoginPage rentalLoginPage=new RentalLoginPage();

        rentalLoginPage.userMail.sendKeys(ConfigReader.getProperty("Admin_email"));

        rentalLoginPage.userPassword.sendKeys(ConfigReader.getProperty("Admin_password"));
        rentalLoginPage.loginButton.click();
        ReusableMethods.verifyElementDisplayed(rentalHomePage.userID);
        Driver.closeDriver();
    }
}
