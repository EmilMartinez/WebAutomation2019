package testhomepage;

import base.CommonAPI;
import homepage.TopStory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

public class TestTopStory extends CommonAPI {
   TopStory newTopStory;

   @BeforeMethod
   public void init() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newTopStory = PageFactory.initElements(driver, TopStory.class);
   }

   @Test(description = "Test #59")
   public void clickOnTag() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newTopStory.clickOnTag();
   }

   @Test(description = "Test #60")
   public void clickOnTitle() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newTopStory.clickOnTitle();
   }
}
