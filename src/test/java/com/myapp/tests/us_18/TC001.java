package com.myapp.tests.us_18;

import com.github.javafaker.Faker;
import com.myapp.pages.PearlyAccountPage;
import com.myapp.pages.PearlyHomePage;
import com.myapp.pages.PearlyManagerPage;
import com.myapp.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001 {
    @Test
    public void US18_TC001() {
        //   1. Login to the application.
        Driver.getDriver().get(ConfigReader.getProperty("pearly_market_url"));
        // 2. Navigate to "My Account" > "Account Details".
        PearlyHomePage pearlyHomePage = new PearlyHomePage();
        pearlyHomePage.signInButton.click();
        pearlyHomePage.userNameOrEmail.sendKeys(ConfigReader.getProperty("us_05_userNameOrEmail"));
        //  use us_05_password1   or us_05_password
        pearlyHomePage.password.sendKeys(ConfigReader.getProperty("us_05_password"));
        pearlyHomePage.loginButton.click();
        WaitUtils.waitFor(5);
        pearlyHomePage.accountButton.click();
        PearlyAccountPage pearlyAccountPage = new PearlyAccountPage();
        //click store manager button
        pearlyAccountPage.vendorButton.click();
        //click coupons button
        PearlyManagerPage pearlyManagerPage=new PearlyManagerPage();
        pearlyManagerPage.couponsButton.click();
        //click add new coupon button
        pearlyManagerPage.addNewCoupon.click();
       // 3. Enter a unique code for the coupon.
        Faker faker=new Faker();
        WaitUtils.waitFor(5);
        pearlyManagerPage.couponCode.sendKeys(faker.name().name());
        //4. Add a description for the coupon.
        pearlyManagerPage.couponDescription.sendKeys(faker.name().name());
       // 5. Select "Percentage discount" as the discount type.
        ReusableMethods.selectByIndex(pearlyManagerPage.discountType,0);
        //6. Enter the percentage discount amount.
        pearlyManagerPage.couponAmount.sendKeys("5");
        //7. Set an expiration date for the coupon.
pearlyManagerPage.expiryDate.sendKeys("2025-05-24");
        //8. Select the "Allow free shipping" option.
        JSUtils.clickWithTimeoutByJS(pearlyManagerPage.freeShipping);
        //9. Select the "Show on store" option.
       JSUtils.clickWithTimeoutByJS(pearlyManagerPage.showOnStore);
        //10. Click the "Save" button.
      JSUtils.clickWithTimeoutByJS(pearlyManagerPage.submitButton);
      //Assert coupon creation happens succesfully
        Assert.assertTrue(pearlyManagerPage.couponCreationMessage.isDisplayed());


    }
}
