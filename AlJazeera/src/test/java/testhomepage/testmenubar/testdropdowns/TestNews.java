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

   @Test(priority = 1, description = "Test #29")
//   @Test(priority = 29, description = "Test #29")
   public void clickOnNews() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNews.clickNews();
   }

   @Test(priority = 2, description = "Test #29")
//   @Test(priority = 30, description = "Test #30")
   public void checkIfDropdownIsVisible() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNews.hoverOverNews();
      Assert.assertTrue(newNews.isDropdownVisible());
   }

   @Test(priority = 3, description = "Test #29")
//   @Test(priority = 31, description = "Test #31")
   public void checkEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (WebElement w : newNews.getListOfDropdownWebElem()) {
         newNews.hoverOverEachDropdownLink(w);
      }
   }

   @Test(priority = 4, description = "Test #29")
//   @Test(priority = 32, description = "Test #32")
   public void clickOnEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (WebElement w : newNews.getListOfDropdownWebElem()) {
         newNews.hoverOverNews();
         newNews.clickOnElem(w);
      }
   }

   @Test(priority = 5, description = "Test #29")
//   @Test(priority = 33, description = "Uses SQL DB")
   public void checkEachLinkTitle() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> listOfDDWebElem = newNews.getListOfDropdownWebElem();
      List<String> listOfDDActualTitles = newNews.getListOfDropDownTitleFromDB();

      for (int i = 0; i < listOfDDActualTitles.size(); ++i) {
         // Hovering over the dropdown to see the links.
         newNews.hoverOverNews();
         String expectedTitle = listOfDDActualTitles.get(i);
         newNews.clickOnElem(listOfDDWebElem.get(i));

         Assert.assertEquals(expectedTitle, CommonAPI.driver.getTitle());
      }
   }
}
