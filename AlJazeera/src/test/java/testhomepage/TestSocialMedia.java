package testhomepage;

import base.CommonAPI;
import homepage.SocialMedia;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

public class TestSocialMedia extends CommonAPI {
   SocialMedia newSocial;

   @BeforeMethod
   public void init() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial = PageFactory.initElements(driver, SocialMedia.class);
   }

   @Test(priority = 1, description = "Test #39")
   public void testClickOnFacebook() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnFB();
   }

   @Test(priority = 2, description = "Test #40")
   public void testClickOnTwitter() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnTwitter();
   }

   @Test(priority = 3, description = "Test #41")
   public void testClickOnGooglePlus() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnGoogle();
   }

   @Test(priority = 4, description = "Test #42")
   public void testClickOnRSS() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnR();
   }

   @Test(priority = 5, description = "Test #43")
   public void testClickOnPodcasts() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnPod();
   }

   @Test(priority = 6, description = "Test #44")
   public void testClickOnYouTube() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnYT();
   }

   @Test(priority = 7, description = "Test #45")
   public void checkFBTitle() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnFB();
      Assert.assertEquals("Al Jazeera English - Home | Facebook", driver.getTitle());
   }

   @Test(priority = 8, description = "Test #46")
   public void checkTwitterTitle() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnTwitter();
      Assert.assertEquals("Al Jazeera English (@AJEnglish) | Twitter", driver.getTitle());
   }

   @Test(priority = 9, description = "Test #47")
   public void checkGooglePlusTitle() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnGoogle();
      Assert.assertEquals("Al Jazeera English - Google+", driver.getTitle());
   }

   @Test(priority = 10, description = "Test #48")
   public void checkRSSTitle() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnR();
      Assert.assertEquals("https://www.aljazeera.com/xml/rss/all.xml", driver.getTitle());
   }

   @Test(priority = 11, description = "Test #49")
   public void checkPodcastTitle() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnPod();
      Assert.assertEquals("Podcasts - Al Jazeera English", driver.getTitle());
   }

   @Test(priority = 12, description = "Test #50")
   public void checkYouTubeTitle() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnYT();
      Assert.assertEquals("Al Jazeera English - YouTube", driver.getTitle());
   }

   @Test(priority = 13, description = "Test #51")
   public void checkFacebookURL() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnFB();
      Assert.assertEquals("https://www.facebook.com/aljazeera", driver.getCurrentUrl());
   }

   @Test(priority = 14, description = "Test #52")
   public void checkTwitterURL() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnTwitter();
      Assert.assertEquals("https://twitter.com/ajenglish", driver.getCurrentUrl());
   }

   @Test(priority = 15, description = "Test #53")
   public void checkGooglePlusURL() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnGoogle();
      Assert.assertEquals("https://plus.google.com/118055372303098301843", driver.getCurrentUrl());
   }

   @Test(priority = 16, description = "Test #54")
   public void checkRSSURL() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnR();
      Assert.assertEquals("https://www.aljazeera.com/xml/rss/all.xml", driver.getCurrentUrl());
   }

   @Test(priority = 17, description = "Test #55")
   public void checkPodcastsURL() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnPod();
      Assert.assertEquals("https://www.aljazeera.com/podcasts/", driver.getCurrentUrl());
   }

   @Test(priority = 18, description = "Test #56")
   public void checkYouTubeURL() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSocial.clickOnYT();
      Assert.assertEquals("https://www.youtube.com/user/AlJazeeraEnglish?sub_confirmation=1", driver.getCurrentUrl());
   }
}
