package com.sephora.qa.pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.jetty9.server.PushBuilder;

import javax.print.DocFlavor;
import javax.xml.xpath.XPath;

public class RegisterPage {

    //Page Factory / OR
    @FindBy(xpath = "//button[contains(text(),'Register')] ")
    WebElement registerBttn;

    @FindBy(id = "modalTitle")
    WebElement modalTitle;

    @FindBy(xpath = "//p[contains(@class,'css-jpaqcb')]")
    WebElement  requiredInfo;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "register_email")
    WebElement register_email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//div[@class='css-fc30t7 Checkbox-box']")
    WebElement checkBox;

    @FindBy(id = "biRegMonth")
    WebElement bdayMonth;

    @FindBy(id = "biRegDay")
    WebElement bDay;

    @FindBy(id = "biRegYear")
    WebElement bdayYear;

    @FindBy(css = ".css-1cf8bj1 ")
    WebElement subscribeTextBox;

    @FindBy (id = "zipCode")
    WebElement inputZipCode;

    @FindBy(xpath = "//button[@type='submit'][contains(text(),'Register')]")
    WebElement registerBtton;


    //initializing WebElements
    public RegisterPage(){

        PageFactory.initElements(CommonAPI.driver, this);
    }

    //Actions

    public boolean validateTitleIsDisplayed(){return modalTitle.isDisplayed();}

    public boolean validateRequiredInfoDisplayed(){return requiredInfo.isDisplayed();}

    public boolean  validateSubscirbeTextBox(){ return subscribeTextBox.isDisplayed(); }

    public void validateCheckBox(){ checkBox.click(); }

    public HomePage validateRegistration(String fName, String lName, String mail, String pword) throws InterruptedException {

            Thread.sleep(3000);
            registerBttn.click();
            firstName.clear();
            firstName.sendKeys(fName);
            lastName.clear();
            lastName.sendKeys(lName);
            register_email.clear();
            register_email.sendKeys(mail);
            password.clear();
            password.sendKeys(pword);
            registerBtton.click();
            Thread.sleep(5000);

            return new HomePage();

        }

    public void validateZipCode(String zCode){

        inputZipCode.sendKeys(zCode);
    }

}
