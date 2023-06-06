package com.myapp.tests.us_05;

import com.myapp.pages.PearlyAccountPage;
import com.myapp.pages.PearlyHomePage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001 {
    /*
    Prod environmet: https://pearlymarket.com
    1. Login to the application.
2. Navigate to "My Account" > "Account Details".
The user should be able to see their account details, including first name, last name, display name, and email address.
     */
    @Test
    public void US05_TC001(){
     //   1. Login to the application.
        Driver.getDriver().get(ConfigReader.getProperty("pearly_market_url"));
       // 2. Navigate to "My Account" > "Account Details".
        PearlyHomePage pearlyHomePage=new PearlyHomePage();
        pearlyHomePage.signInButton.click();
        pearlyHomePage.userNameOrEmail.sendKeys(ConfigReader.getProperty("us_05_userNameOrEmail"));
        //  use us_05_password1   or us_05_password
        pearlyHomePage.password.sendKeys(ConfigReader.getProperty("us_05_password"));
        pearlyHomePage.loginButton.click();
 WaitUtils.waitFor(5);
        pearlyHomePage.accountButton.click();
        PearlyAccountPage pearlyAccountPage=new PearlyAccountPage();

        pearlyAccountPage.accountDetailsButton.click();
         //       The user should be able to see their account details, including first name, last name, display name, and email address.
        WebElement firstNameInput = Driver.getDriver().findElement(By.id("account_first_name"));
        String firstName = firstNameInput.getAttribute("value");
        Assert.assertTrue(!firstName.isEmpty());

        WebElement lastNameInput = Driver.getDriver().findElement(By.id("account_last_name"));
        String lastName = lastNameInput.getAttribute("value");
        Assert.assertTrue(!lastName.isEmpty());

        WebElement displayNameInput = Driver.getDriver().findElement(By.id("account_display_name"));
        String displayName = displayNameInput.getAttribute("value");
        Assert.assertTrue(!displayName.isEmpty());

        WebElement emailInput = Driver.getDriver().findElement(By.id("account_email"));
        String email = emailInput.getAttribute("value");
        Assert.assertTrue(!email.isEmpty());
        Driver.closeDriver();


    }

}
