package testsearchpage;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ApplicationLog;
import reporting.TestLogger;
import searchpage.Search;

import java.util.List;

public class TestSearch extends CommonAPI {
   Search newSearch;

   @BeforeMethod
   public void init() {
      newSearch = PageFactory.initElements(driver, Search.class);
      driver.navigate().to("https://www.aljazeera.com/search/");
      newSearch.closeCookiePopup();
   }

   @Test (priority = 94)
   public void searchValues() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<String> listOfSearchVals = newSearch.getListOfSearchValues();

      for (String s : listOfSearchVals)
         newSearch.searchItem(s);
   }

   @Test (priority = 95)
   public void searchValuesAndClick() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<String> listOfSearchVals = newSearch.getListOfSearchValues();

      for(String s : listOfSearchVals) {
         newSearch.searchItemAndClick(s);
         Thread.sleep(3000);
      }
   }

   @Test (priority = 96)
   public void searchBrexitAndClickSubmitButton() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
   }

   @Test(priority = 97)
   public void checkOnAllFilter() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxAll();
   }

   @Test(priority = 98)
   public void checkOnAuthorProfile() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxAuthorProfile();
   }

   @Test(priority = 99)
   public void checkOnRepNotebook() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxAll();
   }

   @Test(priority = 100)
   public void checkOnFeature() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxFeatures();
   }

   @Test(priority = 101)
   public void checkOnInfographic() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxInfographic();
   }

   @Test(priority = 102)
   public void checkOnNews() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxNews();
   }

   @Test(priority = 103)
   public void checkOnOpinion() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxOpinion();
   }

   @Test(priority = 104)
   public void checkOnInPic() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxInPics();
   }

   @Test(priority = 105)
   public void checkOnProgrammes() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxProgrammes();
   }

   @Test(priority = 106)
   public void checkByLatest() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.sortByLatest();
   }

   @Test(priority = 107)
   public void checkByRelevance() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.sortByRelevance();
   }
}
