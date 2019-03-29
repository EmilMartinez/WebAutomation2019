package com.kiehls.qa.tests.user;
import base.CommonAPI;
import com.kiehls.qa.pages.SignInPage;
import com.kiehls.qa.pages.UserPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class UserPageTest extends CommonAPI {
    UserPage userPage;
    Properties prop;
    @BeforeMethod
    public void initialize(){
        this.userPage = PageFactory.initElements(this.driver, UserPage.class);
        SignInPage signInPage = new SignInPage();
        signInPage.verifySignIn(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test
    public void titleTest(){
        String title = userPage.verifyUserPageTitle();
        Assert.assertEquals(title, "My Account | Kiehl's");
    }

    @Test
    public void userAccountTest(){userPage.verifyUserAccountLink();}

    @Test
    public void joinNowTest(){userPage.verifyJoinNowLink(); }

    @Test
    public void dontMissTest(){
        boolean flag = userPage.verifyDontMissText();
        Assert.assertTrue(flag);
    }

}
