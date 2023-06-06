package com.myapp.tests.smoketestsuite.logintests;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import com.myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_NegativeLogin {
    @Test
    public void US100208_NegativeLogin(){
        /*
        User should not be able login with incorrect credentials
Acceptance Criteria:
As customer, I should not be able to log in the application
Customer email: fake@bluerentalcars.com
Customer password: fakepass
Error: User with email fake@bluerentalcars.com not found
         */
        Driver.getDriver().get(ConfigReader.getProperty("BlueRentalCarsHomePage_URL"));
        RentalHomePage rentalHomePage=new RentalHomePage();
        RentalLoginPage rentalLoginPage=new RentalLoginPage();
        rentalHomePage.loginLink.click();
        rentalLoginPage.userMail.sendKeys(ConfigReader.getProperty("fake_email"));
        rentalLoginPage.userPassword.sendKeys(ConfigReader.getProperty("fake_password"));
        rentalLoginPage.loginButton.click();
     //     Without waiting, test case fails because the element pops up on a web alert page that cause sysnronization issue
//        WaitUtils.waitFor(3);//HARD WAIT. NOT RECOMMENDED

     //   WaitUtils.waitForVisibility(rentalLoginPage.errorMessage_incorrectEmailAndPass,3);//Explicit Wait RECOMMENDED
        //        Error: User with email fake@bluerentalcars.com not found
        //String errorText = rentalLoginPage.errorMessage_incorrectEmailAndPass.getText();

       // Assert.assertEquals(errorText,"User with email fake@bluerentalcars.com not found");
//With reusable methods
        ReusableMethods.verifyExpectedAndActualTextMatch("User with email fake@bluerentalcars.com not found",rentalLoginPage.errorMessage_incorrectEmailAndPass);
        Driver.closeDriver();
    }
}
