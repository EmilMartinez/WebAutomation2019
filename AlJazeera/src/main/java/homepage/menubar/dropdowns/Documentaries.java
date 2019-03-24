package homepage.menubar.dropdowns;


import databases.ConnectToSqlDB;
import databases.ExcelData;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Documentaries {
   @FindBy(css = "div.site-sticky.article-main-header.sticky-float.slideDown:nth-child(2) div.container div.row div.col-sm-9.navigation-block div.navigation div.navbar.navbar-default div.container div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.menu-large:nth-child(5) > a.dropdown-toggle")
   private WebElement link_docs;

   @FindBy(xpath = "//body/form[@id='Default']/div[@id='sticky-header']/div/div/div/div[@class='container']/div[@class='row']/div[@class='col-sm-9 navigation-block']/div[@class='navigation']/div[@class='navbar navbar-default']/div[@class='container']/div[@class='navbar-collapse collapse']/ul[@class='nav navbar-nav']/li[4]")
   private WebElement field_docs;


   private ConnectToSqlDB conn = new ConnectToSqlDB();
   private String filepath = "../AlJazeera/src/test/resources/secret.properties";
   ExcelData excl = new ExcelData();
   String excelPath = "../AlJazeera/src/test/resources/newsdropdown.xlsx";

   public List<String> getListOfDropdownWebElem(WebDriver driver) {
      List<String> list = new ArrayList<String>();
      String xpath = "//div[@id='article-main-header']//li[4]//ul[1]//li[1]//ul[1]";

      WebElement w = driver.findElement(By.xpath(xpath));
      // Getting all elements in following that path.
      int total = w.findElements(By.tagName("li")).size();
      // First element is not present under the drop down so the total is one less.
      int counter = 0;

      while (counter < total) {
         list.add(xpath + "//li[" + (counter + 1) + "]");
         counter++;
      }
      return list;
   }

   public void hoverOverDocs(WebDriver driver) {
      Actions builder = new Actions(driver);
      builder.moveToElement(link_docs).perform();
   }

   public void hoverOverEachDropdownLink(WebDriver driver, String text) {
      Actions builder = new Actions(driver);
      WebElement w = driver.findElement(By.xpath(text));
      builder.moveToElement(w).perform();
   }

   public void clickDocs() throws NullPointerException {
      link_docs.click();
   }

   public List<String> getListOfNewsLinkNamesFromDB() throws Exception {
      return conn.readDataBase("docs_dd", "LinkTitle", filepath);
   }

   public String getLinkName(WebElement w) {
      return w.getText();
   }

   public boolean isDropdownVisible() {
      WebElement dropdown = field_docs.findElement(By.xpath("ul[1]"));
      if(dropdown.isDisplayed())
         return true;
      return false;
   }

   public void clickOnLink(WebDriver driver, String path) {
      driver.findElement(By.xpath(path)).click();
   }

   /**
    * @param featureName
    * @param driver
    * @throws IOException
    * @throws InterruptedException
    */
   public void selectFrom(String featureName, WebDriver driver) throws IOException, InterruptedException {
      switch (featureName) {
         case "Go Live":
            break;
         case "Send Investigation":
            break;
         case "Send Tip":
            break;
         case "Scroll Down":
            break;
         default:
            break;
      }
   }
}
