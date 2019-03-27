package testhomepage.testfooterlinks;

import base.CommonAPI;
import homepage.footerlinks.About;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

public class TestAbout extends CommonAPI {
   About newAbout;

   @BeforeMethod
   public void init() {
      newAbout = PageFactory.initElements(driver, About.class);
   }

   @Test
   // @Test(priority = 55)
   public void clickOnAboutUs() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickAboutUs();
   }

   @Test
   // @Test(priority = 56)
   public void clickOnPressOffice() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickPressOffice();
   }

   @Test
   // @Test(priority = 57)
   public void clickOnAwards() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickAwards();
   }

   @Test
   // @Test(priority = 58)
   public void clickOnCodeOfEthics() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickCodeOfEthics();
   }

   @Test
   // @Test(priority = 59)
   public void clickOnTermsAndCond() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickTermsAndCond();
   }

   @Test
   // @Test(priority = 60)
   public void clickOnPrivacyPolicy() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickPrivacyPolicy();
   }

   @Test
   // @Test(priority = 61)
   public void clickOnCookiePolicy() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickCookiePolicy();
   }

   @Test
   // @Test(priority = 62)
   public void clickOnCookiePref() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickCookiePref();
   }

   @Test
   // @Test(priority = 63)
   public void clickOnCommGuidelines() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickCommGuidelines();
   }

   @Test
   // @Test(priority = 64)
   public void clickOnWorkForUs() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickWorkForUs();
   }

   @Test
   // @Test(priority = 65)
   public void clickOnHRQuality() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickHRQuality();
   }
}