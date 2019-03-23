package com.sephora.qa.tests;

import base.CommonAPI;
import com.sephora.qa.inputdata.ReadProperties;
import com.sephora.qa.pages.HomePage;
import com.sephora.qa.pages.RegisterPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class RegisterPageTest extends CommonAPI {

    RegisterPage registerPage;
    ReadProperties rp  = new ReadProperties();
    HomePage homePage;

    @BeforeMethod
    public void initialize(){registerPage = PageFactory.initElements(this.driver, RegisterPage.class);}

    @Test

    public void singInPageTest(){ }

    @Test
    public void registrationTest() throws IOException, InterruptedException {

      String fName = rp.loadProperties().getProperty("firstName");
      String lName = rp.loadProperties().getProperty("lastName");
      String mail = rp.loadProperties().getProperty("email");
      String pword = rp.loadProperties().getProperty("password");
      homePage = registerPage.validateRegistration(fName,  lName, mail, pword);

      //homePage = registerPage.validateRegistration("Gina", "Bush", "gina.bush101@gmail.com", "loveSephora@");

    }


   /* @Test
    public void registerbuttonTest(){

        registerPage.validateRegisterButton();

        Assert.assertEquals(registerPage, ""); */


    }

