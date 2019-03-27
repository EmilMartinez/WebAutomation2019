package homepage.footerlinks;

import base.CommonAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

public class Connect extends CommonAPI {
   @FindBy(id = "#footer-nav-social")
   private WebElement field_socialMediaLinks;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(2) ul.list:nth-child(2) li:nth-child(1) > a:nth-child(1)")
   private WebElement link_contactUs;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(2) ul.list:nth-child(2) li:nth-child(2) > a:nth-child(1)")
   private WebElement link_apps;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(2) ul.list:nth-child(2) li:nth-child(3) > a:nth-child(1)")
   private WebElement link_social;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(2) ul.list:nth-child(2) li:nth-child(4) > a:nth-child(1)")
   private WebElement link_channelFinder;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(2) ul.list:nth-child(2) li:nth-child(5) > a:nth-child(1)")
   private WebElement link_tvSched;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(2) ul.list:nth-child(2) li:nth-child(6) > a:nth-child(1)")
   private WebElement link_podcasts;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(2) ul.list:nth-child(2) li:nth-child(7) > a:nth-child(1)")
   private WebElement link_newsletter;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(2) ul.list:nth-child(2) li:nth-child(8) > a:nth-child(1)")
   private WebElement link_submitATip;

   @FindBy(xpath = "//div[@class='enstDismiss']")
   private WebElement button_cookieClose;

   public void clickContactUs() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_contactUs.click();
   }

   public void clickApps() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_apps.click();
   }

   public void clickSocial() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_social.click();
   }

   public void clickChannelFinder() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_channelFinder.click();
   }

   public void clickTVSched() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_tvSched.click();
   }

   public void clickPod() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_podcasts.click();
   }

   public void clickNewsletter() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_newsletter.click();
   }

   public void clickSubmitATip() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_submitATip.click();
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
