package com.kiehls.qa.pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends CommonAPI {


    //Page Factory / OR
    @FindBy(css = "body.pt_storefront.g-loyaltyslot:nth-child(2) div.l-header.header:nth-child(7) div.b-header_top_menu:nth-child(4) div.g-wrapper-main_content div.g-wrapper_inner-main_content div.b-header_column.m_info:nth-child(1) div.b-header_customer_info ul.account_navigation_list li.account_navigation_list_item.account_navigation_login > a.account_navigation_link.login_link")
    WebElement singInButtn;

    @FindBy(css = ".gsection_header")
    WebElement newToKeihlsText;

    @FindBy(css = ".button.create_account_button")
    WebElement createAccountButtn;

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

    @FindBy(id = "dwfrm_profile_customer_birthdayfields_month")
    WebElement month;

    @FindBy(xpath = "//select[@id = 'dwfrm_profile_customer_birthdayfields_month']//option")
    List<WebElement> monthList;

    @FindBy(id = "dwfrm_profile_customer_birthdayfields_day")
    WebElement day;

    @FindBy(xpath = "//select[@id ='dwfrm_profile_customer_birthdayfields_day']//optoin")
    List<WebElement> dayList;

    @FindBy(id = "dwfrm_profile_customer_birthdayfields_year")
    WebElement year;


    @FindBy(xpath = "//select[@id = 'dwfrm_profile_customer_birthdayfields_year']//option")
    List<WebElement> yearList;

    @FindBy(css = ".button submit_button")
    WebElement getCreateAccountButtn;

    @FindBy(css = ".checkbox__control")
    WebElement checkBox;

    @FindBy(xpath = "//a[@title='link opens in new window'][contains(text(),'User Agreement')]")
    WebElement userAgreementLink;

    @FindBy(id = "reg_sfk_btn_fb")
    WebElement facebookLink;

    @FindBy(id = "reg_sfk_btn_ggl")
    WebElement googleLink;

    //initializing WebElements
    public RegisterPage() {

        PageFactory.initElements(CommonAPI.driver, this);
    }

    //Actions
    //public boolean validateTitleIsDisplayed(){return modalTitle.isDisplayed();}

    // public boolean validateRequiredInfoDisplayed(){return requiredInfo.isDisplayed();}

    //public boolean  validateSubscirbeTextBox(){ return subscribeTextBox.isDisplayed(); }

    // public void validateCheckBox(){ checkBox.click(); }

    public HomePage validateRegistration(String fName, String lName, String mail, String pword, String cpword, String month1, String day1, String year1) throws InterruptedException {
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
        Thread.sleep(3000);
        confirmPassword.clear();
        confirmPassword.sendKeys(cpword);
        Thread.sleep(2000);
        month.click();
        setDropDownMonth(month1);
        Thread.sleep(2000);
        day.click();
        setDropDownDay(day1);
        Thread.sleep(2000);
        year.click();
        setDropDownYear(year1);
        Thread.sleep(2000);
        getCreateAccountButtn.click();

        return new HomePage();
    }

    public void setDropDownMonth(String value) {
        for (int i = 0; i < monthList.size(); i++) {
            if (monthList.get(i).getText().equalsIgnoreCase(value)) {
                monthList.get(i).click();
                break;
            }
        }

    }

    public void setDropDownDay(String value) {
        for (int i = 0; i < dayList.size(); i++) {
            if (dayList.get(i).getText().equalsIgnoreCase(value)) {
                dayList.get(i).click();
                break;
            }
        }
    }

        public void setDropDownYear(String value){
            for (int i = 0; i < yearList.size(); i++) {
                if (yearList.get(i).getText().equalsIgnoreCase(value)) {
                    yearList.get(i).click();
                    break;
                }
            }
        }

    }


