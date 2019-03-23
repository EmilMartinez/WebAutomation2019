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

   @Test(priority = 1, description = "Test #40")
   public void checkDropdownLinkName() throws Exception {
      newNews.hoverOverNews(driver);
      CommonAPI.sleepForTwoSec();
   }
}