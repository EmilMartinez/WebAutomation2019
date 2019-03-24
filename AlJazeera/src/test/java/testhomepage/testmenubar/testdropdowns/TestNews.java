package testhomepage.testmenubar.testdropdowns;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import databases.ExcelData;
import homepage.menubar.dropdowns.News;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNews extends CommonAPI {
   News newNews;
   ConnectToSqlDB conn = new ConnectToSqlDB();
   ExcelData excl = new ExcelData();
   String excelPath = "../AlJazeera/src/test/resources/newsdropdown.xlsx";

   @BeforeMethod
   public void init() {
      newNews = PageFactory.initElements(driver, News.class);
   }

   @Test
   public void clickOnNews() {
      newNews.clickNews();
   }

   @Test
   public void checkIfDropdownIsVisible() {
      newNews.hoverOverNews(driver);
      Assert.assertTrue(newNews.isDropdownVisible());
   }

   @Test
   public void checkEachDropdownLink() {
      newNews.hoverOverNews(driver);
      for (String s : newNews.getListOfDropdownWebElem(driver)) {
         newNews.hoverOverEachDropdownLink(driver, s);
      }
   }

   @Test
   public void clickOnEachDropdownLink() throws InterruptedException{
      newNews.hoverOverNews(driver);

      for (String s : newNews.getListOfDropdownWebElem(driver)) {
         newNews.clickOnLink(driver, s);
         // After each click, the drop down will go away. Need to hover again.
         newNews.hoverOverNews(driver);
      }
   }
}
