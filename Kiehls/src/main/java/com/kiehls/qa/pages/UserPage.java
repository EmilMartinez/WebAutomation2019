package com.kiehls.qa.pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

    @FindBy(xpath = "//div[@class='b-header_customer_info']//span[@class='current_customer_first_name'][contains(text(),'Gina')]")
    WebElement userName;

    @FindBy(xpath ="//[contains(text(),'My Account')]")
    WebElement myAccountLink;

    @FindBy(css =".b-loyalty_dashboard-banner-name")
    WebElement nameOnBanner;

    @FindBy(css = ".b-loyalty_dashboard-banner_title")
    WebElement bannerTitle;

    @FindBy(css = ".b-account_button__joinnow")
    WebElement joinNowLink;

    @FindBy(xpath = "//span[contains(text(),'Don’t Miss Out On Your Rewards')]")
    WebElement dontMissText;

    public UserPage(){
        PageFactory.initElements(CommonAPI.driver, this);
    }

    public String verifyUserPageTitle(){
        userName.click();
        return CommonAPI.driver.getTitle();
    }

    public UserAccountPage verifyUserAccountLink(){
        userName.click();
        myAccountLink.click();
        return new UserAccountPage();}

    public void verifyJoinNowLink(){
        verifyUserAccountLink();
        joinNowLink.click();}

    public boolean verifyDontMissText(){
        verifyUserAccountLink();
    return dontMissText.isDisplayed();
    }

    }
