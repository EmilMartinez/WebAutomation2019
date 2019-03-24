package com.kiehls.qa.pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends CommonAPI {


    //Page Factory / OR
    @FindBy(css = ".account_navigation_link.login_link")
    WebElement singInButtn;

    @FindBy(css= ".gsection_header")
    WebElement newToKeihlsText;

    @FindBy(css = ".button.create_account_button")
    WebElement  createAccountButtn;

    @FindBy(id = "dwfrm_profile_customer_firstName")
    WebElement firstName;

    @FindBy(id = "dwfrm_profile_customer_lastName")
    WebElement lastName;

    @FindBy(id = "dwfrm_profile_customer_email")
    WebElement email;

    @FindBy(id = "dwfrm_profile_login_password")
    WebElement password;

    @FindBy(id = "dwfrm_profile_login_passwordconfirm")
    WebElement confirmPassword;

    @FindBy(xpath = "//select[@name='dwfrm_profile_customer_birthdayfields_month']")
    WebElement month;

    @FindBy(xpath = "//select[@id='dwfrm_profile_customer_birthdayfields_day']")
    public static WebElement day;
    @FindBy(xpath = "//select[@id='dwfrm_profile_customer_birthdayfields_year']")
    public static WebElement year;

    @FindBy(css = ".button submit_button")
    WebElement submitButton;

    @FindBy(css = ".checkbox__control")
    WebElement checkBox;

    @FindBy(xpath = "//a[@title='link opens in new window'][contains(text(),'User Agreement')]")
    WebElement userAgreementLink;

    @FindBy(id = "reg_sfk_btn_fb")
    WebElement facebookLink;

    @FindBy(id = "reg_sfk_btn_ggl")
    WebElement googleLink;

    //initializing WebElements
    public RegisterPage(){

        PageFactory.initElements(CommonAPI.driver, this);
    }

    //Actions
    //public boolean validateTitleIsDisplayed(){return modalTitle.isDisplayed();}

   // public boolean validateRequiredInfoDisplayed(){return requiredInfo.isDisplayed();}

    //public boolean  validateSubscirbeTextBox(){ return subscribeTextBox.isDisplayed(); }

   // public void validateCheckBox(){ checkBox.click(); }

    public HomePage validateRegistration(String fName, String lName, String mail, String pword, String cpword) throws InterruptedException {
        singInButtn.click();
        createAccountButtn.click();
        firstName.clear();
        firstName.sendKeys(fName);
        lastName.clear();
        lastName.sendKeys(lName);
        Thread.sleep(3000);
        email.clear();
        email.sendKeys(mail);
        Thread.sleep(3000);
        password.clear();
        password.sendKeys(pword);
        confirmPassword.clear();
        Thread.sleep(3000);
        confirmPassword.sendKeys(cpword);
        submitButton.click();
        Thread.sleep(2000);

        return new HomePage();
        }

        public WebElement returnMonthWebElem() { return month; }

        public WebElement returnDayWebElement(){ return day; }

        public WebElement returnYearWebElement(){return year; }

        public void setDOB(String month, String day, String year) {
           WebElement month1 = returnMonthWebElem();
        }
//
//         public void setDateDropdown(String month, String day, String year, WebDriver driver) {
//            CommonAPI.selectOptionByVisibleText();
//         }
}