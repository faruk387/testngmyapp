package com.myapp.tests.us_05;

import com.github.javafaker.Faker;
import com.myapp.pages.PearlyAccountPage;
import com.myapp.pages.PearlyHomePage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.JSUtils;
import com.myapp.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003 {
    @Test
    public void US05_TC003() {

        //   1. Login to the application.
        Driver.getDriver().get(ConfigReader.getProperty("pearly_market_url"));

        PearlyHomePage pearlyHomePage = new PearlyHomePage();
        pearlyHomePage.signInButton.click();
        pearlyHomePage.userNameOrEmail.sendKeys(ConfigReader.getProperty("us_05_userNameOrEmail"));
        //  use us_05_password1   or us_05_password
        pearlyHomePage.password.sendKeys(ConfigReader.getProperty("us_05_password"));
        pearlyHomePage.loginButton.click();
        WaitUtils.waitFor(5);
        pearlyHomePage.accountButton.click();
        PearlyAccountPage pearlyAccountPage = new PearlyAccountPage();
//2. Navigate to "My Account" > "Account Details".
        pearlyAccountPage.accountDetailsButton.click();

       // 4. Enter a new biography in the provided input field or textarea.
        Faker faker=new Faker();
     //   pearlyAccountPage.biography.clear();
        WaitUtils.waitFor(3);

        pearlyAccountPage.biography.sendKeys(faker.regexify("[A-Za-z0-9]{200}"));
        //5. Click the "Save" button.

        JSUtils.clickWithTimeoutByJS(pearlyAccountPage.saveButton);
        WebElement accountDetailsChangedSuccessfully = Driver.getDriver().findElement(By.xpath("//div[contains(@class, 'woocommerce-message')]"));
        String accountDetailsChanged = accountDetailsChangedSuccessfully.getText();
        Assert.assertEquals("Account details changed successfully.",accountDetailsChanged);
        Driver.closeDriver();
    }
}
