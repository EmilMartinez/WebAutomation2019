package searchpage;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

import java.util.List;

public class Search extends CommonAPI {
   @FindBy(css = "#txtSimpleSearch")
   private WebElement input_searchBar;

   @FindBy(css = "#btSimpleSearch")
   private WebElement button_search;

   @FindBy(css = "section.middle-east.topics-section div.container div.row section.search-section:nth-child(1) div.container div.row div.col-lg-4.col-md-12 div.wrapper-sticky div.searchpage-left-sidebar div.search-results-filter div.checkbox-div:nth-child(2) label:nth-child(1) > input:nth-child(1)")
   private WebElement checkbox_all;

   @FindBy(css = "section.middle-east.topics-section div.container div.row section.search-section:nth-child(1) div.container div.row div.col-lg-4.col-md-12 div.wrapper-sticky div.searchpage-left-sidebar div.search-results-filter div.checkbox-div:nth-child(3) label:nth-child(1) > input:nth-child(1)")
   private WebElement checkbox_authorProfile;

   @FindBy(css = "section.middle-east.topics-section div.container div.row section.search-section:nth-child(1) div.container div.row div.col-lg-4.col-md-12 div.wrapper-sticky div.searchpage-left-sidebar div.search-results-filter div.checkbox-div:nth-child(4) label:nth-child(1) > input:nth-child(1)")
   private WebElement checkbox_repNotes;

   @FindBy(css = "section.middle-east.topics-section div.container div.row section.search-section:nth-child(1) div.container div.row div.col-lg-4.col-md-12 div.wrapper-sticky div.searchpage-left-sidebar div.search-results-filter div.checkbox-div:nth-child(4) label:nth-child(1) > input:nth-child(1)")
   private WebElement checkbox_features;

   @FindBy(css = "section.middle-east.topics-section div.container div.row section.search-section:nth-child(1) div.container div.row div.col-lg-4.col-md-12 div.wrapper-sticky div.searchpage-left-sidebar div.search-results-filter div.checkbox-div:nth-child(5) label:nth-child(1) > input:nth-child(1)")
   private WebElement checkbox_infographic;

   @FindBy(css = "section.middle-east.topics-section div.container div.row section.search-section:nth-child(1) div.container div.row div.col-lg-4.col-md-12 div.wrapper-sticky div.searchpage-left-sidebar div.search-results-filter div.checkbox-div:nth-child(6) label:nth-child(1) > input:nth-child(1)")
   private WebElement checkbox_news;

   @FindBy(css = "section.middle-east.topics-section div.container div.row section.search-section:nth-child(1) div.container div.row div.col-lg-4.col-md-12 div.wrapper-sticky div.searchpage-left-sidebar div.search-results-filter div.checkbox-div:nth-child(7) label:nth-child(1) > input:nth-child(1)")
   private WebElement checkbox_opinion;

   @FindBy(css = "section.middle-east.topics-section div.container div.row section.search-section:nth-child(1) div.container div.row div.col-lg-4.col-md-12 div.wrapper-sticky div.searchpage-left-sidebar div.search-results-filter div.checkbox-div:nth-child(8) label:nth-child(1) > input:nth-child(1)")
   private WebElement checkbox_inPictures;

   @FindBy(css = "section.middle-east.topics-section div.container div.row section.search-section:nth-child(1) div.container div.row div.col-lg-4.col-md-12 div.wrapper-sticky div.searchpage-left-sidebar div.search-results-filter div.checkbox-div:nth-child(9) label:nth-child(1) > input:nth-child(1)")
   private WebElement checkbox_programmes;

   @FindBy(css = "section.middle-east.topics-section div.container div.row section.search-section:nth-child(1) div.container div.row div.col-lg-8.col-md-12 div.search-results:nth-child(3) div.card div.search-result-tabs.hidden-xs ul.nav.nav-tabs li.active:nth-child(1) > a.order-by-latest")
   private WebElement link_SortByLatest;

   @FindBy(css = "section.middle-east.topics-section div.container div.row section.search-section:nth-child(1) div.container div.row div.col-lg-8.col-md-12 div.search-results:nth-child(3) div.card div.search-result-tabs.hidden-xs ul.nav.nav-tabs li:nth-child(2) > a.order-by-relevance")
   private WebElement link_SortByRelevance;

   @FindBy(xpath = "//div[@class='enstDismiss']")
   private WebElement button_cookieClose;

   ConnectToSqlDB conn = new ConnectToSqlDB();
   String filepath = "../AlJazeera/src/test/resources/secret.properties";

   public void sortByLatest() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_SortByLatest.click();
   }

   public void sortByRelevance() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      link_SortByRelevance.click();
   }

   public void checkboxAll() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      checkbox_all.click();
   }

   public void checkboxAuthorProfile() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      checkbox_authorProfile.click();
   }

   public void checkboxReportersNotes() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      checkbox_repNotes.click();
   }

   public void checkboxFeatures() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      checkbox_features.click();
   }

   public void checkboxInfographic() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      checkbox_infographic.click();
   }

   public void checkboxNews() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      checkbox_news.click();
   }

   public void checkboxOpinion() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      checkbox_opinion.click();
   }

   public void checkboxInPics() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      checkbox_inPictures.click();
   }

   public void checkboxProgrammes() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      checkbox_programmes.click();
   }

   public List<String> getListOfSearchValues() throws Exception {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      return conn.readDataBase("search_values", "SearchValues", filepath);
   }

   public void searchItem(String val) {
      input_searchBar.clear();
      input_searchBar.sendKeys(val);
   }

   public void searchItemAndClick(String val) {
      input_searchBar.clear();
      input_searchBar.sendKeys(val, Keys.ENTER);
   }

   public void closeCookiePopup() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      button_cookieClose.click();
   }

   public void clickSearchButton() {
      button_search.click();
   }
}