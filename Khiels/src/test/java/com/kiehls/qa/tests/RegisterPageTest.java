package com.kiehls.qa.tests;

import base.CommonAPI;
import com.kiehls.qa.inputdata.ReadProperties;
import com.kiehls.qa.pages.HomePage;
import com.kiehls.qa.pages.RegisterPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class RegisterPageTest extends CommonAPI {
    RegisterPage registerPage;
    ReadProperties rp = new ReadProperties();
    HomePage homePage;

    @BeforeMethod
    public void initialize() {
        registerPage = PageFactory.initElements(this.driver, RegisterPage.class);
    }

    @Test
    public void singInPageTest() {
    }

    @Test
    public void registrationTest() throws IOException, InterruptedException {

        String fName = rp.loadProperties().getProperty("firstName");
        String lName = rp.loadProperties().getProperty("lastName");
        String mail = rp.loadProperties().getProperty("email");
        String pword = rp.loadProperties().getProperty("password");
        String cpword = rp.loadProperties().getProperty("confirmPassword");
//        selectOptionByVisibleText(month, rp.loadProperties().getProperty("month"));
//        selectOptionByVisibleText(day, rp.loadProperties().getProperty("day"));
//        selectOptionByVisibleText(year, rp.loadProperties().getProperty("year"));

//        homePage = registerPage.validateRegistration(fName, lName, mail, pword, cpword, month1, day1, year1);
    }


}

