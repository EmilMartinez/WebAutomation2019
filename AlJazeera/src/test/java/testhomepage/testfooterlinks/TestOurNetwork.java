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

    @Test(priority = 86)
   public void clickOnJetty() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickJetty();
   }

    @Test(priority = 87)
   public void clickOnCentreOfStudies() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickCentreForHumanRights();
   }

    @Test(priority = 88)
   public void clickOnMediaInstitute() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickMediaInstitute();
   }

    @Test(priority = 89)
   public void clickOnLearnArabic() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickLearnArabic();
   }

    @Test(priority = 90)
   public void clickOnCenterForPublicLibertiesNHumanRights() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickCentreForHumanRights();
   }

    @Test(priority = 91)
   public void clickOnForum() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickForum();
   }

    @Test(priority = 92)
   public void clickOnFilmFestival() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNetwork.closeCookiePopup();
      // Icon is not visible to click. Must scroll down.
      newNetwork.scrollToFooterField();
      newNetwork.clickFilmFestival();
   }

    @Test(priority = 93)
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
