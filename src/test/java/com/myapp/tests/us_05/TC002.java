package com.myapp.tests.us_05;

import com.github.javafaker.Faker;
import com.myapp.pages.PearlyAccountPage;
import com.myapp.pages.PearlyHomePage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.JSUtils;
import com.myapp.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002 {
    @Test
    public void US05_TC002(){

        //   1. Login to the application.
        Driver.getDriver().get(ConfigReader.getProperty("pearly_market_url"));

        PearlyHomePage pearlyHomePage=new PearlyHomePage();
        pearlyHomePage.signInButton.click();
        pearlyHomePage.userNameOrEmail.sendKeys(ConfigReader.getProperty("us_05_userNameOrEmail"));
        //  use us_05_password1   or us_05_password
        pearlyHomePage.password.sendKeys(ConfigReader.getProperty("us_05_password"));
        pearlyHomePage.loginButton.click();
        WaitUtils.waitFor(5);
        pearlyHomePage.accountButton.click();
        PearlyAccountPage pearlyAccountPage=new PearlyAccountPage();
//2. Navigate to "My Account" > "Account Details".
        pearlyAccountPage.accountDetailsButton.click();

        //3. Click on the "Edit" button next to the First Name field.
        //4. Modify the first name.
        Faker faker=new Faker();
        pearlyAccountPage.firstName.clear();
        pearlyAccountPage.firstName.sendKeys(faker.name().firstName());
        //5. Click on the "Edit" button next to the Last Name field.
        //6. Modify the last name.
        pearlyAccountPage.lastName.clear();
        pearlyAccountPage.lastName.sendKeys(faker.name().lastName());
        //7. Click on the "Edit" button next to the Display Name field.
        //8. Modify the display name.
        pearlyAccountPage.displayName.clear();
        pearlyAccountPage.displayName.sendKeys(faker.name().username());
        //9. Click on the "Edit" button next to the Email Address field.
        //10. Modify the email address.

        //11. Click the "Save" button.
        JSUtils.clickWithTimeoutByJS(pearlyAccountPage.saveButton);
        WebElement accountDetailsChangedSuccessfully = Driver.getDriver().findElement(By.xpath("//div[contains(@class, 'woocommerce-message')]"));
        String accountDetailsChanged = accountDetailsChangedSuccessfully.getText();
        Assert.assertEquals("Account details changed successfully.",accountDetailsChanged);
Driver.closeDriver();
    }
}
