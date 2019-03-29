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

   @Test(alwaysRun = true, description = "Test #94")
   public void searchValues() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<String> listOfSearchVals = newSearch.getListOfSearchValues();

      for (String s : listOfSearchVals)
         newSearch.searchItem(s);
   }

   @Test(alwaysRun = true, description = "Test #95")
   public void searchValuesAndClick() throws Exception {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<String> listOfSearchVals = newSearch.getListOfSearchValues();

      for (String s : listOfSearchVals) {
         newSearch.searchItemAndClick(s);
         Thread.sleep(3000);
      }
   }

   @Test(alwaysRun = true, description = "Test #96")
   public void searchBrexitAndClickSubmitButton() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
   }

   @Test(alwaysRun = true, description = "Test #97")
   public void checkOnAllFilter() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxAll();
   }

   @Test(alwaysRun = true, description = "Test #98")
   public void checkOnAuthorProfile() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxAuthorProfile();
   }

   @Test(alwaysRun = true, description = "Test #99")
   public void checkOnRepNotebook() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxAll();
   }

   @Test(alwaysRun = true, description = "Test #100")
   public void checkOnFeature() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxFeatures();
   }

   @Test(alwaysRun = true, description = "Test #101")
   public void checkOnInfographic() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxInfographic();
   }

   @Test(alwaysRun = true, description = "Test #102")
   public void checkOnNews() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxNews();
   }

   @Test(alwaysRun = true, description = "Test #103")
   public void checkOnOpinion() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxOpinion();
   }

   @Test(alwaysRun = true, description = "Test #104")
   public void checkOnInPic() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxInPics();
   }

   @Test(alwaysRun = true, description = "Test #105")
   public void checkOnProgrammes() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.checkboxProgrammes();
   }

   @Test(alwaysRun = true, description = "Test #106")
   public void checkByLatest() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.sortByLatest();
   }

   @Test(alwaysRun = true, description = "Test #107")
   public void checkByRelevance() {
      ApplicationLog.epicLogger();
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      newSearch.searchItem("Brexit");
      newSearch.clickSearchButton();
      newSearch.sortByRelevance();
   }
}
