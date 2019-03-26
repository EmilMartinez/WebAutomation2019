package homepage;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.TestLogger;

import java.util.List;

public class SocialMedia extends CommonAPI {
   @FindBy(css = ".footer-top-socials:nth-child(1) div.container div.row div.col-md-12 div.col-md-6.footer-socials.pull-right:nth-child(2) ul:nth-child(2) li:nth-child(1) > a.icon-facebook")
   private WebElement icon_facebook;

   @FindBy(css = ".footer-top-socials:nth-child(1) div.container div.row div.col-md-12 div.col-md-6.footer-socials.pull-right:nth-child(2) ul:nth-child(2) li:nth-child(2) > a.icon-twitter")
   private WebElement icon_twitter;

   @FindBy(css = ".footer-top-socials:nth-child(1) div.container div.row div.col-md-12 div.col-md-6.footer-socials.pull-right:nth-child(2) ul:nth-child(2) li:nth-child(3) > a.icon-google")
   private WebElement icon_gPlus;

   @FindBy(css = ".footer-top-socials:nth-child(1) div.container div.row div.col-md-12 div.col-md-6.footer-socials.pull-right:nth-child(2) ul:nth-child(2) li:nth-child(4) > a.icon-rss")
   private WebElement icon_rss;

   @FindBy(css = ".footer-top-socials:nth-child(1) div.container div.row div.col-md-12 div.col-md-6.footer-socials.pull-right:nth-child(2) ul:nth-child(2) li:nth-child(5) > a.icon-pod")
   private WebElement icon_podcasts;

   @FindBy(css = ".footer-top-socials:nth-child(1) div.container div.row div.col-md-12 div.col-md-6.footer-socials.pull-right:nth-child(2) ul:nth-child(2) li:nth-child(6) > a.icon-youtube")
   private WebElement icon_youtube;

   @FindBy(id = "#footer-nav-social")
   private WebElement field_socialMediaLinks;

//   WebDriverWait wait = new WebDriverWait(CommonAPI.driver, 60);

   public void clickOnFB() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

//      wait.until(ExpectedConditions.elementToBeClickable(icon_facebook));
      icon_facebook.click();

//      ((JavascriptExecutor) driver).executeScript("window.open('https://www.facebook.com');");

   }

   public void clickOnTwitter() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

//      List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElements(icon_twitter));
//      list.get(0).click();

       icon_twitter.click();
   }

   public void clickOnGoogle() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

//      List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElements(icon_gPlus));
//      list.get(0).click();

       icon_gPlus.click();
   }

   public void clickOnR() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

//      List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElements(icon_rss));
//      list.get(0).click();

       icon_rss.click();
   }

   public void clickOnPod() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

//      List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElements(icon_podcasts));
//      list.get(0).click();

      icon_podcasts.click();
   }

   public void clickOnYT() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

//      List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElements(icon_youtube));
//      list.get(0).click();

      icon_youtube.click();
   }

   public void scrollToSocialMediaField() throws Exception {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

       JavascriptExecutor js = (JavascriptExecutor) CommonAPI.driver;
       js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
   }

   public void waitDom() {
      JavascriptExecutor js = (JavascriptExecutor) CommonAPI.driver;
      js.executeScript("window.onload = null;");
   }
}
