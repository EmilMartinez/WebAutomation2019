package testhomepage;

import base.CommonAPI;
import homepage.SocialMedia;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSocialMedia extends CommonAPI {
   SocialMedia newSocial;

   @BeforeMethod
   public void init() {
      newSocial = PageFactory.initElements(driver, SocialMedia.class);
   }

   @Test
   public void testClickOnFacebook() {
      newSocial.clickOnFB();
   }

   @Test
   public void testClickOnTwitter() {
      newSocial.clickOnTwitter();
   }

   @Test
   public void testClickOnGooglePlus() {
      newSocial.clickOnGoogle();
   }

   @Test
   public void testClickOnRSS() {
      newSocial.clickOnR();
   }

   @Test
   public void testClickOnPodcasts() {
      newSocial.clickOnPod();
   }

   @Test
   public void testClickOnYouTube() {
      newSocial.clickOnYT();
   }

   @Test
   public void checkFBTitle() {
      newSocial.clickOnFB();
      Assert.assertEquals("Al Jazeera English - Home | Facebook", driver.getTitle());
   }

   @Test
   public void checkTwitterTitle() {
      newSocial.clickOnTwitter();
      Assert.assertEquals("Al Jazeera English (@AJEnglish) | Twitter", driver.getTitle());
   }

   @Test
   public void checkGooglePlusTitle() {
      newSocial.clickOnGoogle();
      Assert.assertEquals("Al Jazeera English - Google+", driver.getTitle());
   }

   @Test
   public void checkRSSTitle() {
      newSocial.clickOnR();
      Assert.assertEquals("https://www.aljazeera.com/xml/rss/all.xml", driver.getTitle());
   }

   @Test
   public void checkPodcastTitle() {
      newSocial.clickOnPod();
      Assert.assertEquals("Podcasts - Al Jazeera English", driver.getTitle());
   }

   @Test
   public void checkYouTubeTitle() {
      newSocial.clickOnYT();
      Assert.assertEquals("Al Jazeera English - YouTube", driver.getTitle());
   }

   @Test
   public void checkFacebookURL() {
      newSocial.clickOnFB();
      Assert.assertEquals("https://www.facebook.com/aljazeera", driver.getCurrentUrl());
   }

   @Test
   public void checkTwitterURL() {
      newSocial.clickOnTwitter();
      Assert.assertEquals("https://twitter.com/ajenglish", driver.getCurrentUrl());
   }

   @Test
   public void checkGooglePlusURL() {
      newSocial.clickOnGoogle();
      Assert.assertEquals("https://plus.google.com/118055372303098301843", driver.getCurrentUrl());
   }

   @Test
   public void checkRSSURL() {
      newSocial.clickOnR();
      Assert.assertEquals("https://www.aljazeera.com/xml/rss/all.xml", driver.getCurrentUrl());
   }

   @Test
   public void checkPodcastsURL() {
      newSocial.clickOnPod();
      Assert.assertEquals("https://www.aljazeera.com/podcasts/", driver.getCurrentUrl());
   }

   @Test
   public void checkYouTubeURL() {
      newSocial.clickOnYT();
      Assert.assertEquals("https://www.youtube.com/user/AlJazeeraEnglish?sub_confirmation=1", driver.getCurrentUrl());
   }
}
