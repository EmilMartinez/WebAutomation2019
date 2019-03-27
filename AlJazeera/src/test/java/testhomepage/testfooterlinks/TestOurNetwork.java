package testhomepage.testfooterlinks;

import base.CommonAPI;
import homepage.footerlinks.OurNetwork;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

public class TestOurNetwork extends CommonAPI {
   OurNetwork newNetwork;
   
   @BeforeMethod
   public void init() {
      newNetwork = PageFactory.initElements(driver, OurNetwork.class);
   }

   @Test
   // @Test(priority = 84)
   public void clickOnJetty() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickJetty();
   }

   @Test
   // @Test(priority = 85)
   public void clickOnCentreOfStudies() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickCentreForHumanRights();
   }

   @Test
   // @Test(priority = 86)
   public void clickOnMediaInstitute() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickMediaInstitute();
   }

   @Test
   // @Test(priority = 87)
   public void clickOnLearnArabic() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickLearnArabic();
   }

   @Test
   // @Test(priority = 88)
   public void clickOnCenterForPublicLibertiesNHumanRights() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickCentreForHumanRights();
   }

   @Test
   // @Test(priority = 89)
   public void clickOnForum() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickForum();
   }

   @Test
   // @Test(priority = 90)
   public void clickOnFilmFestival() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickFilmFestival();
   }

   @Test
   // @Test(priority = 91)
   public void clickOnHotelPartners() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickHotelPartners();
   }
}
