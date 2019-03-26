package com.kiehls.qa.pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends CommonAPI {


    //Page Factory / OR

    @FindBy(xpath = "//title[contains(text(),'Create Account')]")
    WebElement title;

    @FindBy(css = ".account_navigation_link.login_link")
    WebElement singInButtn;

    @FindBy(xpath = "//h2[@class='section_header']")
    WebElement newToKeihlsText;

    @FindBy(xpath ="//p[contains(text(),'*For U.S. Consumers Only')]")
    WebElement forUSCustomerOnlyText;

    @FindBy(xpath = "//h1[contains(text(),'Create Account')]")
    WebElement createAccountText;

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

    @FindBy(css = ".button.submit_button")
    WebElement getCreateAccountButtn;

    @FindBy(id = "dwfrm_profile_customer_loyalty")
    WebElement joinCheckBox;

    @FindBy(css = "b-registration_rewards")
    WebElement KiehlsRewardsImg;

    @FindBy(xpath = "//h2[contains(text(),'KIEHL’S REWARDS')]")
    WebElement KiehlsRewardsText;

    @FindBy(css = "b-registration_newsletter_title")
    WebElement stayInTouch;

    @FindBy(id = "reg_sfk_btn_ggl")
    WebElement googleLink;

    //initializing WebElements
    public RegisterPage() {

        PageFactory.initElements(CommonAPI.driver, this);
    }

    //Actions

    public String verifyTitle(){ return driver.getTitle(); }

    public void validateSignInButtn(){singInButtn.click();}

    public void validateCreateAccountButtn(){createAccountButtn.click();}

    public String verifyCreateAccountPageTitle(){
        validateSignInButtn();
        validateCreateAccountButtn();
        return driver.getTitle();
    }

    public String validateNewToKeihlsText(){
        validateSignInButtn();
        return newToKeihlsText.getText();
    }

    public String validateCreateAccountText(){
        validateSignInButtn();
        validateCreateAccountButtn();
        return createAccountText.getText();
    }

    public String validateForUSCustomerOnlyText(){
        validateSignInButtn();
        validateCreateAccountButtn();
        return forUSCustomerOnlyText.getText();
    }

    public boolean validateCheckBox(){
        validateSignInButtn();
        validateCreateAccountButtn();
        return joinCheckBox.isDisplayed();
    }

    public boolean validateKiehlsRewardsImg(){
        validateSignInButtn();
        validateCreateAccountButtn();
        return KiehlsRewardsImg.isDisplayed();
    }

    public boolean validateKiehlsRewardsText(){
        validateSignInButtn();
        validateCreateAccountButtn();
        return KiehlsRewardsText.isDisplayed();
    }

    public boolean vlaidateStayInTouchText(){
        validateSignInButtn();
        validateCreateAccountButtn();
        return stayInTouch.isDisplayed();
    }

    public HomePage validateRegistration(String fName, String lName, String mail, String pword, String cpword, String month1, String day1, String year1) throws InterruptedException {
        singInButtn.click();
        validateCreateAccountButtn();
        firstName.clear();
        firstName.sendKeys(fName);
        lastName.clear();
        lastName.sendKeys(lName);
        Thread.sleep(3000);
        email.clear();
        email.sendKeys(mail);
        Thread.sleep(2000);
        password.clear();
        password.sendKeys(pword);
        Thread.sleep(2000);
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


