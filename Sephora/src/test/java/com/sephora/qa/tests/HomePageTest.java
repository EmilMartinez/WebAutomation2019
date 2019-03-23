package com.sephora.qa.tests;

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
    public void aboutSephoraTest(){
        String text = homePage.validateAboutSephora();

        Assert.assertEquals(text, "About Sephora" );

    }

    @Test
    public void helpTest(){
        String text = homePage.validateHelp();
        Assert.assertEquals(text, "Help & FAQs");
    }

    @Test
    public void mySephoraTest(){
        String text  = homePage.validateMySephora();
        Assert.assertEquals(text, "My Sephora");

    }

    @Test
    public void waysToShopTest(){

        String text = homePage.validateWaysToShop();

        Assert.assertEquals(text, "Ways to Shop");

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
