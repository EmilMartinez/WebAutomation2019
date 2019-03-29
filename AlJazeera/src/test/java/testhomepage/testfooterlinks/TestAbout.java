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

   @Test(alwaysRun = true, description = "Test #61")
   public void clickOnAboutUs() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickAboutUs();
   }

   @Test(alwaysRun = true, description = "Test #62")
   public void clickOnPressOffice() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickPressOffice();
   }

   @Test(alwaysRun = true, description = "Test #63")
   public void clickOnAwards() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickAwards();
   }

   @Test(alwaysRun = true, description = "Test #64")
   public void clickOnCodeOfEthics() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickCodeOfEthics();
   }

   @Test(alwaysRun = true, description = "Test #65")
   public void clickOnTermsAndCond() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickTermsAndCond();
   }

   @Test(alwaysRun = true, description = "Test #66")
   public void clickOnPrivacyPolicy() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickPrivacyPolicy();
   }

   @Test(alwaysRun = true, description = "Test #67")
   public void clickOnCookiePolicy() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickCookiePolicy();
   }

   @Test(alwaysRun = true, description = "Test #68")
   public void clickOnCookiePref() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickCookiePref();
   }

   @Test(alwaysRun = true, description = "Test #69")
   public void clickOnCommGuidelines() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickCommGuidelines();
   }

   @Test(alwaysRun = true, description = "Test #70")
   public void clickOnWorkForUs() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newAbout.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newAbout.scrollToFooterField();
      newAbout.clickWorkForUs();
   }

   @Test(alwaysRun = true, description = "Test #71")
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