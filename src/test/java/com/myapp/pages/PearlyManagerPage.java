package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PearlyManagerPage {
    public PearlyManagerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='wcfm_menu_items wcfm_menu_wcfm-coupons']//a[@class='wcfm_menu_item ']")
    public WebElement couponsButton;
    @FindBy(xpath = "//span[.='Add New']")
    public WebElement addNewCoupon;
    @FindBy(id = "title")
    public WebElement couponCode;
    @FindBy(id = "description")
    public WebElement couponDescription;
    @FindBy(id = "coupon_amount")
    public WebElement couponAmount;
    @FindBy(id = "discount_type")
    public WebElement discountType;
    @FindBy(id = "expiry_date")
    public WebElement expiryDate;
    @FindBy(id = "free_shipping")
    public WebElement freeShipping;
    @FindBy(id = "show_on_store")
    public WebElement showOnStore;
    @FindBy(id = "wcfm_coupon_manager_submit_button")
    public WebElement submitButton;
    @FindBy(xpath = "//h2[text()='Add Coupon']")
    public WebElement couponCreationMessage;







}
