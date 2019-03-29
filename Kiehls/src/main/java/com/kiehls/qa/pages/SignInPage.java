package com.kiehls.qa.pages;

import base.CommonAPI;
import com.kiehls.qa.inputdata.ReadProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.jetty9.server.PushBuilder;

import java.io.IOException;
import java.util.Properties;

public class SignInPage extends CommonAPI {

    RegisterPage registerPage = new RegisterPage();

    @FindBy(xpath= "//input[@id='dwfrm_login_username_d0efurzlybkd']")
    WebElement emailInput;

    @FindBy(xpath= "//input[@id='dwfrm_login_password']")
            WebElement password;

    @FindBy(xpath ="//span[contains(text(),'Remember me')]")
    WebElement rememberMeText;

    @FindBy(xpath= "//*[@id=\"dwfrm_login\"]/fieldset/div[4]")
            WebElement rememberMeCheckBox;

    @FindBy(xpath = "//button[contains(@value, 'Sign In')]")
            WebElement submitBttn;

    @FindBy(css=".f_field_description.class.sendtofriend.input.description")
    WebElement orderConfirmationEmailTex;

    public SignInPage(){
        PageFactory.initElements(CommonAPI.driver, this);
    }

    public UserPage verifySignIn(String email, String password1){
       registerPage.singInButtn.click();
        emailInput.sendKeys(email);
        password.sendKeys(password1);
        submitBttn.click();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click();", submitBttn);
        return  new UserPage();
    }

    public boolean verifyRememberMeCheckBox(){
        registerPage.singInButtn.click();
        return rememberMeCheckBox.isEnabled();}

    public String verifyRememberMeText(){
        return rememberMeText.getText();
    }

    public String verifyOrderConfirmationEmailText(){
        return orderConfirmationEmailTex.getText();
    }



}
