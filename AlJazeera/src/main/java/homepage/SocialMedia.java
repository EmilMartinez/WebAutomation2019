package homepage;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

public class SocialMedia extends CommonAPI {
   @FindBy(xpath = "//a[@class='icon-facebook']")
   private WebElement icon_facebook;

   @FindBy(xpath = "//a[@class='icon-twitter']")
   private WebElement icon_twitter;

   @FindBy(xpath = "//a[@class='icon-google']")
   private WebElement icon_gPlus;

   @FindBy(xpath = "//a[@class='icon-rss']")
   private WebElement icon_rss;

   @FindBy(xpath = "//a[@class='icon-pod']")
   private WebElement icon_podcasts;

   @FindBy(xpath = "//a[@class='icon-youtube']")
   private WebElement icon_youtube;

   public void clickOnFB() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      icon_facebook.click();
   }

   public void clickOnTwitter() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      icon_facebook.click();
   }

   public void clickOnGoogle() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      icon_facebook.click();
   }

   public void clickOnR() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      icon_facebook.click();
   }

   public void clickOnPod() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      icon_facebook.click();
   }

   public void clickOnYT() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      icon_facebook.click();
   }
}
