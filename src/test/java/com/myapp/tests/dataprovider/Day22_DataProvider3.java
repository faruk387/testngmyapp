package com.myapp.tests.dataprovider;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.DataProviderUtils;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day22_DataProvider3 {
    RentalHomePage rentalHomePage;
    RentalLoginPage rentalLoginPage;
    //Test login functionality  using customer service credentials
    //    We need 2 methods : ****@DataProvider ***@Test method
//    DATA SOURCE
    @Test(dataProvider="customerDataProvider",dataProviderClass = DataProviderUtils.class)
    public void customerLoginTest(String userName,String password){
        Driver.getDriver().get(ConfigReader.getProperty("BlueRentalCarsHomePage_URL"));
        //click on login
        rentalHomePage=new RentalHomePage();
        rentalHomePage.loginLink.click();
        //enter username
        rentalLoginPage=new RentalLoginPage();
        rentalLoginPage.userMail.sendKeys(userName);//get data from data provider
        //enter password
        rentalLoginPage.userPassword.sendKeys(password);//get data from data provider
        // click on login button
        rentalLoginPage.loginButton.click();
        //verify login
        ReusableMethods.verifyElementDisplayed(rentalHomePage.userID);
        // click on id
        rentalHomePage.userID.click();
        // click on logout
        rentalHomePage.logOut.click();
        //click on ok
        rentalHomePage.OK.click();
    }
}
