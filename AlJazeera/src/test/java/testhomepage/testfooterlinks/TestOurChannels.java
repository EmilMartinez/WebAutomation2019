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

    @Test(priority = 80)
   public void clickOnArabic() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newChannels.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newChannels.scrollToFooterField();
      newChannels.clickArabic();
   }

    @Test(priority = 81)
   public void clickOnEnglish() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newChannels.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newChannels.scrollToFooterField();
      newChannels.clickEnglish();
   }

    @Test(priority = 82)
   public void clickOnMubasher() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newChannels.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newChannels.scrollToFooterField();
      newChannels.clickMubasher();
   }

    @Test(priority = 83)
   public void clickOnDocumentary() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newChannels.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newChannels.scrollToFooterField();
      newChannels.clickDocs();
   }

    @Test(priority = 84)
   public void clickOnBalkans() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newChannels.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newChannels.scrollToFooterField();
      newChannels.clickBalkans();
   }

    @Test(priority = 85)
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