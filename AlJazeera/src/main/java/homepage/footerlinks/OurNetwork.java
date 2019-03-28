package homepage.footerlinks;

import base.CommonAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

public class OurNetwork extends CommonAPI {
   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(4) ul.list:nth-child(2) li:nth-child(1) > a:nth-child(1)")
   private WebElement link_jetty;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(4) ul.list:nth-child(2) li:nth-child(2) > a:nth-child(1)")
   private WebElement link_centreOfStudies;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(4) ul.list:nth-child(2) li:nth-child(3) > a:nth-child(1)")
   private WebElement link_mediaInstitute;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(4) ul.list:nth-child(2) li:nth-child(4) > a:nth-child(1)")
   private WebElement link_learnArabic;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(4) ul.list:nth-child(2) li:nth-child(5) > a:nth-child(1)")
   private WebElement link_centerForHumanRights;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(4) ul.list:nth-child(2) li:nth-child(6) > a:nth-child(1)")
   private WebElement link_forum;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(4) ul.list:nth-child(2) li:nth-child(7) > a:nth-child(1)")
   private WebElement link_filmFestival;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(4) ul.list:nth-child(2) li:nth-child(8) > a:nth-child(1)")
   private WebElement link_hotelPartners;

   @FindBy(id = "#footer-nav-social")
   private WebElement field_socialMediaLinks;

   @FindBy(xpath = "//div[@class='enstDismiss']")
   private WebElement button_cookieClose;

   public void clickJetty() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_jetty.click();
   }

   public void clickCentreOfStudies() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_centreOfStudies.click();
   }

   public void clickMediaInstitute() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_mediaInstitute.click();
   }

   public void clickLearnArabic() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_learnArabic.click();
   }

   public void clickCentreForHumanRights() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_centerForHumanRights.click();
   }

   public void clickForum() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_forum.click();
   }

   public void clickFilmFestival() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_filmFestival.click();
   }

   public void clickHotelPartners() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_hotelPartners.click();
   }

   public void scrollToFooterField() throws Exception {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      JavascriptExecutor js = (JavascriptExecutor) CommonAPI.driver;
      js.executeScript("window.scrollTo(0, 100000)");
      Thread.sleep(5000);
   }

   public void closeCookiePopup() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      button_cookieClose.click();
   }
}
