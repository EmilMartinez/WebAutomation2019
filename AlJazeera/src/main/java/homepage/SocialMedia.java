package homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SocialMedia {
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
      icon_facebook.click();
   }

   public void clickOnTwitter() {
      icon_facebook.click();
   }

   public void clickOnGoogle() {
      icon_facebook.click();
   }

   public void clickOnR() {
      icon_facebook.click();
   }

   public void clickOnPod() {
      icon_facebook.click();
   }

   public void clickOnYT() {
      icon_facebook.click();
   }
}
