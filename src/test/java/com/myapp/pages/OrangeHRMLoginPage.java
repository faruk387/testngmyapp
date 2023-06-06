package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {
    //ALL PAGE Classes must have a constructor to use page factory
    public OrangeHRMLoginPage(){
        //page factory is used to initiate the object
        //if we dont use this ,we get null pointer exception
        PageFactory.initElements(Driver.getDriver(),this);
    }
  //  public WebElement username= driver.findElement(By.ByName("username"));//Traditional
    //POM
    //@FindBy : Used to locate web elements.

    @FindBy(name="username") public WebElement username;
    @FindBy(xpath = "//input[@type='password']") public WebElement password;
    @FindBy(xpath = "//button[@type='submit']") public WebElement submitButton;
}
