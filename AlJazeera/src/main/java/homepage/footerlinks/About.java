package homepage.footerlinks;

import base.CommonAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

public class About extends CommonAPI {
   @FindBy(id = "#footer-nav-social")
   private WebElement field_socialMediaLinks;

   @FindBy(css = ".footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(1) ul.list:nth-child(2) li:nth-child(1) > a:nth-child(1)")
   private WebElement link_AboutUs;

   @FindBy(css = ".footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(1) ul.list:nth-child(2) li:nth-child(2) > a:nth-child(1)")
   private WebElement link_pressOffice;

   @FindBy(css = ".footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(1) ul.list:nth-child(2) li:nth-child(3) > a:nth-child(1)")
   private WebElement link_awards;

   @FindBy(css = ".footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(1) ul.list:nth-child(2) li:nth-child(4) > a:nth-child(1)")
   private WebElement link_codeOfEthics;

   @FindBy(css = ".footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(1) ul.list:nth-child(2) li:nth-child(5) > a:nth-child(1)")
   private WebElement link_termsAndCond;

   @FindBy(css = ".footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(1) ul.list:nth-child(2) li:nth-child(6) > a:nth-child(1)")
   private WebElement link_privacyPolicy;

   @FindBy(css = ".footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(1) ul.list:nth-child(2) li:nth-child(7) > a:nth-child(1)")
   private WebElement link_cookiePolicy;

   @FindBy(css = ".footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(1) ul.list:nth-child(2) li:nth-child(8) > a:nth-child(1)")
   private WebElement link_cookiePref;

   @FindBy(css = ".footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(1) ul.list:nth-child(2) li:nth-child(9) > a:nth-child(1)")
   private WebElement link_commGuidelines;

   @FindBy(css = ".footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(1) ul.list:nth-child(2) li:nth-child(10) > a:nth-child(1)")
   private WebElement link_workForUs;

   @FindBy(css = ".footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(1) ul.list:nth-child(2) li:nth-child(11) > a:nth-child(1)")
   private WebElement link_hrQuality;

   @FindBy(xpath = "//div[@class='enstDismiss']")
   private WebElement button_cookieClose;

   public void clickAboutUs() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_AboutUs.click();
   }

   public void clickPressOffice() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_pressOffice.click();
   }

   public void clickAwards() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_awards.click();
   }

   public void clickCodeOfEthics() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_codeOfEthics.click();
   }

   public void clickTermsAndCond() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_termsAndCond.click();
   }

   public void clickPrivacyPolicy() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_privacyPolicy.click();
   }

   public void clickCookiePolicy() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_cookiePolicy.click();
   }

   public void clickCookiePref() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_cookiePref.click();
   }

   public void clickCommGuidelines() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_commGuidelines.click();
   }

   public void clickWorkForUs() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_workForUs.click();
   }

   public void clickHRQuality() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_hrQuality.click();
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
