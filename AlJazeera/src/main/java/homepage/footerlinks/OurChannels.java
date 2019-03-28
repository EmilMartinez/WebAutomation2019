package homepage.footerlinks;

import base.CommonAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

public class OurChannels extends CommonAPI {
   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(3) ul.list:nth-child(2) li:nth-child(1) > a:nth-child(1)")
   private WebElement link_arabic;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(3) ul.list:nth-child(2) li:nth-child(2) > a:nth-child(1)")
   private WebElement link_english;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(3) ul.list:nth-child(2) li:nth-child(3) > a:nth-child(1)")
   private WebElement link_mubasher;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(3) ul.list:nth-child(2) li:nth-child(4) > a:nth-child(1)")
   private WebElement link_documentary;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(3) ul.list:nth-child(2) li:nth-child(5) > a:nth-child(1)")
   private WebElement link_balkans;

   @FindBy(css = "div.footer:nth-child(2) div.container div.row div.col-md-8.col-sm-12.footer-links div.col-md-3.col-sm-6:nth-child(3) ul.list:nth-child(2) li:nth-child(6) > a:nth-child(1)")
   private WebElement link_ajPlus;

   @FindBy(id = "#footer-nav-social")
   private WebElement field_socialMediaLinks;

   @FindBy(xpath = "//div[@class='enstDismiss']")
   private WebElement button_cookieClose;

   public void clickArabic() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_arabic.click();
   }

   public void clickEnglish() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_english.click();
   }

   public void clickMubasher() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_mubasher.click();
   }

   public void clickDocs() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_documentary.click();
   }

   public void clickBalkans() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_balkans.click();
   }

   public void clickAJPlus() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_ajPlus.click();
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
