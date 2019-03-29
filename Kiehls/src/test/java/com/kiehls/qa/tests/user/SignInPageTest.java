package com.kiehls.qa.tests.user;

import base.CommonAPI;
import com.kiehls.qa.inputdata.ReadProperties;
import com.kiehls.qa.pages.SignInPage;
import com.kiehls.qa.pages.UserPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class SignInPageTest extends CommonAPI {
    SignInPage signInPage = new SignInPage();

    UserPage userPage;

    @BeforeMethod
    public void initialize(){signInPage = PageFactory.initElements(this.driver,
            SignInPage.class);
    }

    @Test(priority = 1)
    public void signInTest() throws IOException {
        Properties prop = ReadProperties.loadProperties();
        userPage = signInPage.verifySignIn(prop.getProperty("email"),
                prop.getProperty("password"));
    }

    @Test
    public void rememberMeTest(){
        boolean flag = signInPage.verifyRememberMeCheckBox();
        Assert.assertTrue(flag);
    }

    @Test
    public void verifyRememberMeTextTest(){
        String text = signInPage.verifyRememberMeText();
        Assert.assertEquals(text, "Remember me");
    }

    @Test
    public void verifyOrderConfirmationEmailTextTest(){
        String text = signInPage.verifyOrderConfirmationEmailText();
        Assert.assertEquals(text, "Order confirmation will be sent to this email address.");
    }



}
