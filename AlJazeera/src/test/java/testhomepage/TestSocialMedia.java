package testhomepage;

import base.CommonAPI;
import homepage.SocialMedia;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

import java.util.ArrayList;

public class TestSocialMedia extends CommonAPI {
   SocialMedia newSocial;

   @BeforeMethod
   public void init() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial = PageFactory.initElements(driver, SocialMedia.class);
   }

   @Test(description = "Test #39")
   // @Test(priority = 39)
   public void testClickOnFacebook() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnFB();
   }

   @Test(description = "Test #40")
   // @Test(priority = 40)
   public void testClickOnTwitter() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnTwitter();
   }

   @Test(description = "Test #41")
   // @Test(priority = 41)
   public void testClickOnGooglePlus() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnGoogle();
   }

   @Test(description = "Test #42")
   // @Test(priority = 42)
   public void testClickOnRSS() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnR();
   }

   @Test(description = "Test #43")
   // @Test(priority = 43)
   public void testClickOnPodcasts() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnPod();
   }

   @Test(description = "Test #44")
   // @Test(priority = 44)
   public void testClickOnYouTube() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnYT();
   }

   @Test(description = "Test #45")
   // @Test(priority = 45)
   public void checkFBTitle() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnFB();

      // Waiting for the the tab to load.
      Thread.sleep(5000);
      CommonAPI.switchToActiveTab();
      newSocial.waitDom();

      Assert.assertEquals("Al Jazeera English - Home | Facebook", driver.getTitle());
   }

   @Test(description = "Test #46")
   // @Test(priority = 46)
   public void checkTwitterTitle() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnTwitter();

      // Waiting for the the tab to load.
      Thread.sleep(4000);
      CommonAPI.switchToActiveTab();
      newSocial.waitDom();

      Assert.assertEquals("Al Jazeera English (@AJEnglish) | Twitter", driver.getTitle());
   }

   @Test(description = "Test #47")
   // @Test(priority = 47)
   public void checkGooglePlusTitle() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnGoogle();

      // Waiting for the the tab to load.
      Thread.sleep(4000);
      CommonAPI.switchToActiveTab();
      newSocial.waitDom();

      Assert.assertEquals("Al Jazeera English - Google+", driver.getTitle());
   }

   @Test(description = "Test #49")
   // @Test(priority = 48)
   public void checkPodcastTitle() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnPod();

      // Waiting for the the tab to load.
      Thread.sleep(4000);
      CommonAPI.switchToActiveTab();
      newSocial.waitDom();

      Assert.assertEquals("Podcasts - Al Jazeera English", driver.getTitle());
   }

   @Test(description = "Test #50")
   // @Test(priority = 49)
   public void checkYouTubeTitle() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnYT();

      // Waiting for the the tab to load.
      Thread.sleep(5000);
      CommonAPI.switchToActiveTab();
      newSocial.waitDom();

      Assert.assertEquals("Al Jazeera English - YouTube", driver.getTitle());
   }

   @Test(description = "Test #51")
   // @Test(priority = 50)
   public void checkFacebookURL() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnFB();

      // Waiting for the the tab to load.
      Thread.sleep(5000);
      CommonAPI.switchToActiveTab();
      newSocial.waitDom();

      Assert.assertEquals("https://www.facebook.com/aljazeera", driver.getCurrentUrl());
   }

   @Test(description = "Test #52")
   // @Test(priority = 51)
   public void checkTwitterURL() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnTwitter();

      // Waiting for the the tab to load.
      Thread.sleep(4000);
      CommonAPI.switchToActiveTab();
      newSocial.waitDom();

      Assert.assertEquals("https://twitter.com/ajenglish", driver.getCurrentUrl());
   }

   @Test(description = "Test #53")
   // @Test(priority = 52)
   public void checkGooglePlusURL() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnGoogle();

      // Waiting for the the tab to load.
      Thread.sleep(4000);
      CommonAPI.switchToActiveTab();
      newSocial.waitDom();

      Assert.assertEquals("https://plus.google.com/118055372303098301843", driver.getCurrentUrl());
   }

   @Test(description = "Test #55")
   // @Test(priority = 53)
   public void checkPodcastsURL() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnPod();

      // Waiting for the the tab to load.
      Thread.sleep(4000);
      CommonAPI.switchToActiveTab();
      newSocial.waitDom();

      Assert.assertEquals("https://www.aljazeera.com/podcasts/", driver.getCurrentUrl());
   }

   @Test(description = "Test #56")
   // @Test(priority = 54)
   public void checkYouTubeURL() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      // Icon is not visible to click. Must scroll down.
      newSocial.scrollToSocialMediaField();
      newSocial.clickOnYT();

      // Waiting for the the tab to load.
      Thread.sleep(4000);
      CommonAPI.switchToActiveTab();
      newSocial.waitDom();

      Assert.assertEquals("https://www.youtube.com/user/AlJazeeraEnglish?sub_confirmation=1", driver.getCurrentUrl());
   }
}