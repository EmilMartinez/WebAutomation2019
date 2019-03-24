package com.sephora.qa.pages;

import base.CommonAPI;
import com.sephora.qa.inputdata.ReadProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Properties;


public class HomePage extends CommonAPI {
   RegisterPage registerPage;

   //Page Factory /OR

   @FindBy(css = ".css-1isu5f3")
   WebElement reorder;

   @FindBy(xpath = "//img[@class='css-13o7eu2']")
   WebElement logoImage;

   @FindBy(id = "footer_nav_title1")
   WebElement mySephora;

   @FindBy(xpath = "//div[contains(text(),'About Sephora')]")
   WebElement aboutSephora;

   @FindBy(id = "footer_nav_title2")
   WebElement help;

   @FindBy(id = "footer_nav_title3")
   WebElement wayToShop;

   @FindBy(id = "emailSignUpInput")
   WebElement emailSignUpInput;

   @FindBy(css = ".css-11dmm1a")
   WebElement signupBttn;

   @FindBy(xpath = "//div[contains(text(),'Just Arrived')]")
   WebElement justArrived;

   @FindBy(xpath = "//div[contains(text(),\"Editors' Picks\")]")
   WebElement editorsPick;

   @FindBy(xpath = "//div[contains(text(),'Top Rated Skincare')]")
   WebElement topRatedSkincare;

   @FindBy(xpath = "//div[contains(text(),'Recommended For You')]")
   WebElement recommedForYou;

   @FindBy(xpath = "//div[contains(@class,'css-ksbumn')]")
   WebElement spotItShopIt;


   public HomePage(){ PageFactory.initElements(CommonAPI.driver, this); }

   public boolean validateLogoImage(){ return logoImage.isDisplayed();}

   public String validateAboutSephora(){ String text1 = aboutSephora.getText(); return text1;  }

   public String validateHelp(){ return  help.getText(); }

   public String validateMySephora(){ return   mySephora.getText(); }

   public String validateWaysToShop(){ return wayToShop.getText(); }

   public boolean validateText1(){ return editorsPick.isDisplayed(); }

   public boolean validateText(){ return justArrived.isDisplayed(); }

   public boolean validateText2(){return topRatedSkincare.isDisplayed();}

   public boolean validateText3(){return recommedForYou.isDisplayed();}

   public boolean validateText4(){return spotItShopIt.isDisplayed();}

   public String validateHomePageTitle(){ return driver.getTitle(); }

   public void  validateEmailSignUpInput(String mail) throws IOException {
      emailSignUpInput.sendKeys(mail);
      signupBttn.click();
   }
}
