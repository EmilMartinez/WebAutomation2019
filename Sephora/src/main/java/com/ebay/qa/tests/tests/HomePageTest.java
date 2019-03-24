package com.ebay.qa.tests.tests;

import base.CommonAPI;
import com.sephora.qa.inputdata.ReadProperties;
import com.sephora.qa.pages.HomePage;
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

   @Test
   public void textTest(){
       boolean flag = homePage.validateText();
       Assert.assertTrue(flag);
   }

   @Test
   public void text1Test(){
       boolean flag = homePage.validateText1();
       Assert.assertTrue(flag);
   }

   @Test
   public void text2Test(){
        boolean flag = homePage.validateText2();
        Assert.assertTrue(flag);
   }

   @Test
   public void text3Test(){
        boolean flag = homePage.validateText3();
        Assert.assertTrue(flag);
   }

    @Test
    public void text4Test(){
        boolean flag = homePage.validateText4();
        Assert.assertTrue(flag);
    }

   @Test(priority = 1)
    public void TitleTest(){
       String title = homePage.validateHomePageTitle();
       Assert.assertEquals(title, "Cosmetics, Beauty Products, Fragrances & Tools | Sephora");
   }

   @Test(priority = 2)
   public void singUpEmailTest() throws IOException {
       homePage.validateEmailSignUpInput(rp.loadProperties().getProperty("email"));
   }

}
