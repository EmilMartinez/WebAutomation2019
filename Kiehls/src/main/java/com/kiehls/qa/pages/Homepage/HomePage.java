package com.kiehls.qa.pages.Homepage;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class HomePage extends CommonAPI {

   //Page Factory /OR
   @FindBy(xpath = "//img[@class='logo_image class.header.logoimage']")
   WebElement logoImage;

   @FindBy(xpath = "//img[@alt='Healthy Skin Event']")
   WebElement healthySkinEventImg;

   @FindBy(css = ".newsletterSignUp")
   WebElement emailSignUpButton;

   @FindBy(id = "dwfrm_newsletter_email")
   WebElement inputEmail;

   @FindBy(xpath = "//button[contains(text(),'sign up now')]")
   WebElement signupNowBtton;

   @FindBy(xpath = "//span[contains(text(),'Top Sellers')]")
   WebElement topSeller;

   @FindBy(xpath = "//img[contains(@alt,'#KiehlsNYC')]")
   WebElement kiehlsNYC;

   @FindBy(xpath = "//div[contains(text(),'Top Rated Skincare')]")
   WebElement topRatedSkincare;

   public HomePage(){ PageFactory.initElements(CommonAPI.driver, this); }

   public boolean validatedHealthySkinEventImg(){ return healthySkinEventImg.isDisplayed();}

   public boolean validateLogoImage(){ return logoImage.isDisplayed();}

   public void validateLogoImageClick(){logoImage.click();}

   public boolean validateKiehlsNYCImg(){ return kiehlsNYC.isDisplayed(); }

   public boolean validateTopSeller(){ return topSeller.isDisplayed(); }

   public String validateHomePageTitle(){ return this.driver.getTitle();}
   public HomePage  validateEmailSignUpInput(String mail) throws IOException, InterruptedException {
      emailSignUpButton.click();
      inputEmail.clear();
      inputEmail.sendKeys(mail);
      Thread.sleep(1000);
      signupNowBtton.click();

      return new HomePage();

   }
}
