package testhomepage;

import base.CommonAPI;
import homepage.TopStory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTopStory extends CommonAPI {
   TopStory newTopStory;

   @BeforeMethod
   public void init() {
      newTopStory = PageFactory.initElements(driver, TopStory.class);
   }

   @Test(priority = 59)
   public void clickOnTag() {
      newTopStory.clickOnTag();
   }

   @Test(priority = 60)
   public void clickOnTitle() {
      newTopStory.clickOnTitle();
   }
}
