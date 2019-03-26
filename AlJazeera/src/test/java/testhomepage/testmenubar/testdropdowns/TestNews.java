package testhomepage.testmenubar.testdropdowns;

import base.CommonAPI;
import homepage.menubar.dropdowns.News;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;

import java.util.List;

public class TestNews extends CommonAPI {
   News newNews;

   @BeforeMethod
   public void init() {
      newNews = PageFactory.initElements(driver, News.class);
   }

   @Test(priority = 1, description = "Test #19")
   public void clickOnNews() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNews.clickNews();
   }

   @Test(priority = 2, description = "Test #20")
   public void checkIfDropdownIsVisible() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNews.hoverOverNews();
      Assert.assertTrue(newNews.isDropdownVisible());
   }

   @Test(priority = 3, description = "Test #21")
   public void checkEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNews.hoverOverNews();
      for (WebElement w : newNews.getListOfDropdownWebElem()) {
         newNews.hoverOverEachDropdownLink(w);
      }
   }

   @Test(priority = 4, description = "Test #22")
   public void clickOnEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (WebElement w : newNews.getListOfDropdownWebElem()) {
         newNews.hoverOverNews();
         w.click();
      }
   }

   @Test(priority = 5, description = "Test #23 - Uses SQL DB")
   public void checkEachLinkText() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> listOfDDWebElem = newNews.getListOfDropdownWebElem();
      List<String> listOfDDActualText = newNews.getListOfDropDownTextFromDB();

      for (int i = 0; i < listOfDDActualText.size(); ++i) {
         // Hovering over the dropdown to see the links.
         newNews.hoverOverNews();
         String expectedTitle = listOfDDActualText.get(i);
         listOfDDWebElem.get(i).click();

         Assert.assertEquals(expectedTitle, CommonAPI.driver.getCurrentUrl());
      }
   }
}
