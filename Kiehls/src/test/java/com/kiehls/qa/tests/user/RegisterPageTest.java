package com.kiehls.qa.tests.user;

import base.CommonAPI;
import com.kiehls.qa.inputdata.ReadProperties;
import com.kiehls.qa.pages.Homepage.HomePage;
import com.kiehls.qa.pages.RegisterPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.Properties;


public class RegisterPageTest extends CommonAPI {
    RegisterPage registerPage;
    HomePage homePage;

    @BeforeMethod
    public void initialize() {
        registerPage = PageFactory.initElements(this.driver, RegisterPage.class);
    }

    @Test
    public void titleTest(){
        String title = registerPage.verifyTitle();
        Assert.assertEquals(title, "Kiehl’s – Naturally Inspired Skin Care, Body and Haircare");}

     @Test
     public void createAccountPageTitleTest(){
        String title = registerPage.verifyCreateAccountPageTitle();
        Assert.assertEquals(title, "Create Account");
     }

    @Test
   public void checkBoxTest() {
        boolean flag = registerPage.validateCheckBox();
        Assert.assertTrue(flag);}

   @Test
   public void newToKeihlsTextTest(){
       String text =  registerPage.validateNewToKeihlsText();
       Assert.assertEquals(text, "NEW TO KIEHL’S?");
    }

    @Test
    public void createAccountTextTest(){
        String text = registerPage.validateCreateAccountText();
        Assert.assertEquals(text, "CREATE ACCOUNT");
    }

    @Test
    public void forUSCustomerOnlyTextTest(){
        String text = registerPage.validateForUSCustomerOnlyText();
        Assert.assertEquals(text, "*For U.S. Consumers Only");}

    @Test
    public void kiehlsRewardsImgTest(){
        boolean flag = registerPage.validateKiehlsRewardsImg();
        Assert.assertTrue(flag);
    }

    @Test
    public void kiehlsRewardsTextTest(){
        boolean flag = registerPage.validateKiehlsRewardsText();
        Assert.assertTrue(flag);
    }

    @Test
    public void stayInTouchTest(){
        boolean flag = registerPage.vlaidateStayInTouchText();
        Assert.assertTrue(flag);
    }

    @Test
    public void registrationTest() throws IOException, InterruptedException {
       Properties prop = ReadProperties.loadProperties();
        String firstName = prop.getProperty("firstName");
        String lastName = prop.getProperty("lastName");
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        String confirmPassword = prop.getProperty("confirmPassword");
        String month = prop.getProperty("month");
        String day = prop.getProperty("day");
        String year = prop.getProperty("year");

        homePage = registerPage.validateRegistration(firstName, lastName, email,  password, confirmPassword, month, day, year);
    }


}

