package com.myapp.tests.smoketestsuite.logintests;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class Day20_Bad_Credentials {
    /*
    Login screen error messages
Description:
User should see error message when user tries to login with incorrect credentials
Acceptance Criteria:
As admin or customer, I should be able to see error message,
when I provide a correct email address BUT incorrect password in a pop up window
Error Message: Bad credentials
     */
    @Test
    public void US413123_Bad_Credentials(){
        Driver.getDriver().get(ConfigReader.getProperty("BlueRentalCarsHomePage_URL"));
        RentalHomePage rentalHomePage=new RentalHomePage();
        RentalLoginPage rentalLoginPage=new RentalLoginPage();
        rentalHomePage.loginLink.click();
        rentalLoginPage.userMail.sendKeys(ConfigReader.getProperty("Admin_email"));
        rentalLoginPage.userPassword.sendKeys(ConfigReader.getProperty("fake_password"));
        rentalLoginPage.loginButton.click();
        ReusableMethods.verifyExpectedAndActualTextMatch("Bad credentials",rentalLoginPage.errorMessage_incorrectEmailAndPass);
Driver.closeDriver();
    }
}
