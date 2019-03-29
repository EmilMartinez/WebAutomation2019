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

import java.io.IOException;
import java.util.List;

public class TestNews extends CommonAPI {
   News newNews;

   @BeforeMethod
   public void init() {
      newNews = PageFactory.initElements(driver, News.class);
   }

   @Test(alwaysRun = true, description = "Test #31")
   public void clickOnNews() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNews.clickNews();
   }

   @Test(alwaysRun = true, description = "Test #32")
   public void checkIfDropdownIsVisible() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newNews.hoverOverNews();
      Assert.assertTrue(newNews.isDropdownVisible());
   }

   @Test(alwaysRun = true, description = "Test #33")
   public void checkEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (WebElement w : newNews.getListOfDropdownWebElem()) {
         newNews.hoverOverEachDropdownLink(w);
      }
   }

   @Test(alwaysRun = true, description = "Test #34")
   public void clickOnEachDropdownLink() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      for (WebElement w : newNews.getListOfDropdownWebElem()) {
         newNews.hoverOverNews();
         newNews.clickOnElem(w);
      }
   }

   @Test(alwaysRun = true, description = "Test #35 - Uses SQL DB")
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

   @Test(alwaysRun = true, description = "Test #36 - Uses Excel Reader")
   public void checkDropdownText() throws IOException {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> listOfDDWebElem = newNews.getListOfDropdownWebElem();
      String [] listOfActualDDTexts = newNews.getNewsTitleFromExcelFile();

      for(int i = 0; i < listOfDDWebElem.size(); ++i) {
         // Hovering over the dropdown to see the links.
         newNews.hoverOverNews();
         String expectedText = listOfActualDDTexts[i];
         String actualText = listOfDDWebElem.get(i).getText();

         Assert.assertEquals(expectedText, actualText);
      }
   }
}
