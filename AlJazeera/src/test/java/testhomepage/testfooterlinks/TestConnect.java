package testhomepage.testfooterlinks;

import base.CommonAPI;
import homepage.footerlinks.Connect;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

public class TestConnect extends CommonAPI {
   Connect newConnect;

   @BeforeMethod
   public void init() {
      newConnect = PageFactory.initElements(driver, Connect.class);
   }

   @Test(description = "Test #72")
   public void clickOnContactUs() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newConnect.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newConnect.scrollToFooterField();
      newConnect.clickContactUs();
   }

   @Test(description = "Test #73")
   public void clickOnApps() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newConnect.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newConnect.scrollToFooterField();
      newConnect.clickApps();
   }

   @Test(description = "Test #74")
   public void clickOnSocial() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newConnect.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newConnect.scrollToFooterField();
      newConnect.clickSocial();
   }

   @Test(description = "Test #75")
   public void clickOnChannelFinder() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newConnect.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newConnect.scrollToFooterField();
      newConnect.clickChannelFinder();
   }

   @Test(description = "Test #76")
   public void clickOnTVSched() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newConnect.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newConnect.scrollToFooterField();
      newConnect.clickTVSched();
   }

   @Test(description = "Test #77")
   public void clickOnPodcasts() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newConnect.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newConnect.scrollToFooterField();
      newConnect.clickPod();
   }

   @Test(description = "Test #78")
   public void clickOnNewsletter() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newConnect.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newConnect.scrollToFooterField();
      newConnect.clickNewsletter();
   }

   @Test(description = "Test #79")
   public void clickOnSubmitATip() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newConnect.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newConnect.scrollToFooterField();
      newConnect.clickSubmitATip();
   }
}
