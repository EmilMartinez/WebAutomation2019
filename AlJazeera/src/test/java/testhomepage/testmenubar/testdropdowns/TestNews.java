package testhomepage.testmenubar.testdropdowns;

import base.CommonAPI;
import databases.ConnectToSqlDB;
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

   @BeforeMethod
   public void init()  {
      newNews = PageFactory.initElements(driver, News.class);
   }

   @Test (priority = 1, description = "Test #40")
   public void checkDropdownLinkName() throws Exception {
      newNews.hoverOverNews(driver);
      // 7 elements
      System.out.println(newNews.getListOfDropdownWebElem(driver).size());
      for(int i = 0; i < newNews.getListOfDropdownWebElem(driver).size(); i++) {
         WebElement w = driver.findElement(By.xpath(newNews.getListOfDropdownWebElem(driver).get(i)));
         newNews.hoverOverEachDropdownLink(w, driver);
         w.click();
      }
   }
}
