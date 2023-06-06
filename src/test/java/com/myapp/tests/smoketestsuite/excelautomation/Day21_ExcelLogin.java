package com.myapp.tests.smoketestsuite.excelautomation;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ExcelUtils;
import com.myapp.utilities.ReusableMethods;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day21_ExcelLogin {
    RentalHomePage rentalHomePage;
    RentalLoginPage rentalLoginPage;
    //    to call the Excel Util constructor and methods
    ExcelUtils excelUtils;
    //    will be used to store the data
    List<Map<String, String>> dataList;

    /*
    Test the log in functionality of the application with different user profiles(admin, manager, customer services, end user)
Test Data URL : https://www.bluerentalcars.com/
User Credentials : Excel Sheet
bluerentalcars.combluerentalcars.com
Blue Rental Cars | Cheap, Hygienic, VIP Car Hire
Blue Rental Cars makes the drive as enjoyable as the destination. Choose from Luxury Cars & Enjoy it.
     */
    @Test
    public void customerLoginTest(){
        /*
TRY LOOPING THIS CONTENT
go to home page
click on login
enter username
enter password
click on id
click on logout
click on ok
 */
String path="src/test/java/resources/mysmoketestdata.xlsx";
String sheetName="customer_info";
excelUtils=new ExcelUtils(path,sheetName);
dataList=excelUtils.getDataList();
        System.out.println(dataList);//returns all data as map of string
        //  TRY LOOPING THIS CONTENT
        for(Map<String, String> eachData:dataList){
            //go to home page
            Driver.getDriver().get(ConfigReader.getProperty("BlueRentalCarsHomePage_URL"));
            //click on login
            rentalHomePage=new RentalHomePage();
            rentalHomePage.loginLink.click();
            //enter username
            rentalLoginPage=new RentalLoginPage();
            rentalLoginPage.userMail.sendKeys(eachData.get("username"));
            //enter password
            rentalLoginPage.userPassword.sendKeys(eachData.get("password"));
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
Driver.closeDriver();





        /*
pseudo code:
***********
go to home page
---LOG IN---
click on home login link
enter username
enter password
click on login button
verify login is successful
---LOG OUT----
click on id
click on logout
click on ok
----LOG IN---
click on home login link
enter username
enter password
click on login button
verify login is successful
---LOG OUT---
click on id
click on logout
click on ok
---LOG IN ---
click on home login link
enter username
enter password
click on login button
verify login is successful
---LOG OUT---
click on id
click on logout
click on ok
 */
    }
}
