package testhomepage.testfooterlinks;

import base.CommonAPI;
import homepage.footerlinks.OurChannels;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

public class TestOurChannels extends CommonAPI {
   OurChannels newChannels;

   @BeforeMethod
   public void init() {
      newChannels = PageFactory.initElements(driver, OurChannels.class);
   }

   @Test
   // @Test(priority = 78)
   public void clickOnArabic() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newChannels.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newChannels.scrollToFooterField();
      newChannels.clickArabic();
   }

   @Test
   // @Test(priority = 79)
   public void clickOnEnglish() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newChannels.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newChannels.scrollToFooterField();
      newChannels.clickEnglish();
   }

   @Test
   // @Test(priority = 80)
   public void clickOnMubasher() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newChannels.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newChannels.scrollToFooterField();
      newChannels.clickMubasher();
   }

   @Test
   // @Test(priority = 81)
   public void clickOnDocumentary() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newChannels.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newChannels.scrollToFooterField();
      newChannels.clickDocs();
   }

   @Test
   // @Test(priority = 82)
   public void clickOnBalkans() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newChannels.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newChannels.scrollToFooterField();
      newChannels.clickBalkans();
   }

   @Test
   // @Test(priority = 83)
   public void clickOnAJPlus() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newChannels.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newChannels.scrollToFooterField();
      newChannels.clickAJPlus();
   }
}