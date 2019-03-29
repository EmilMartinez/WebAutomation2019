package com.kiehls.qa.tests.homepage;

import base.CommonAPI;
import com.kiehls.qa.inputdata.ReadProperties;
import com.kiehls.qa.pages.Homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends CommonAPI {
    HomePage homePage;
    ReadProperties rp = new ReadProperties();

    @BeforeMethod
    public void initialize(){ this.homePage = PageFactory.initElements(this.driver, HomePage.class); }

   @Test
    public void logoImageTest(){
       boolean flag= homePage.validateLogoImage();
        Assert.assertTrue(flag);
    }

    public void validateKiehlsNYCImgTest(){
        boolean flag= homePage.validateKiehlsNYCImg();
        Assert.assertTrue(flag);
    }

   @Test
   public void textTest(){
       boolean flag = homePage.validatedHealthySkinEventImg();
       Assert.assertTrue(flag);
   }

   @Test
   public void text2Test(){
        boolean flag = homePage.validateTopSeller();
        Assert.assertTrue(flag);
   }

   @Test(priority = 1)
    public void TitleTest(){
       String title = homePage.validateHomePageTitle();
       Assert.assertEquals(title, "Kiehl’s – Naturally Inspired Skin Care, Body and Haircare");
   }

   @Test(priority = 2)
   public void singUpEmailTest() throws IOException, InterruptedException {
      homePage = homePage.validateEmailSignUpInput(rp.loadProperties().getProperty("email"));
   }

}
