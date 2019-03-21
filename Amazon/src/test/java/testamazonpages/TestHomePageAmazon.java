package testamazonpages;

import amazonpages.HomePageAmazon;
import base.CommonAPI;
import databases.ExcelData;
import datasource.MongoDbData;
import datasource.MySqlData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TestHomePageAmazon extends CommonAPI {
   HomePageAmazon homePageAmazon;
   MySqlData mySqlData;
   MongoDbData mongoDbData;
   ExcelData excelData = new ExcelData();
   String excelPath = "../Amazon/src/test/resources/testForSelenium.xls";

   @BeforeMethod
   public void initialize() {
      this.homePageAmazon = PageFactory.initElements(this.driver, HomePageAmazon.class);
      mySqlData = new MySqlData();
      mongoDbData = new MongoDbData();
      //excelData = new ExcelData();
   }
   //1
   //@Test
   public void testSearchForItems() {
      homePageAmazon.searchForItems("alexa");
   }
   //2
   //@Test
   public void testSearchItemsSql() {
      List<String> list = null;
      try {
         list = mySqlData.getItemsListFromDB();
      } catch (Exception e) {
         e.printStackTrace();
      }
      for (String s : list) {
         homePageAmazon.searchForItems(s);
      }
   }
   //3
   //@Test
   public void testSearchForItemsMongo() throws Exception, IOException, SQLException, ClassNotFoundException {
      List<String> list = mongoDbData.getItemsListFromDB();
      for (String s : list) {
         homePageAmazon.searchForItems(s);
      }
   }

   //@Test
   public void testSearchButton() {
      homePageAmazon.searchButton("scarf");
   }

   //@Test
   public void testSearchResults() {
      String item = "iphones";
      System.out.println(homePageAmazon.searchResults(item) + " " + item);
   }

   //There are at least 5 tests in here
   //@Test
   public void testSetDropdown() {
      boolean checkTitle = true;
      Assert.assertEquals(homePageAmazon.setDropdown().endsWith("AmazonFresh"), checkTitle);
   }

   //@Test
   public void testGetDropdownOptions() {
      List<WebElement> options = homePageAmazon.getDropdownOptions();
      for (WebElement element : options) {
         System.out.println(element.getText());
      }
   }

   //4
   //@Test
   public void testSignInLink() {
      homePageAmazon.signInLink();
      String signInPageTitle = "Amazon Sign In";
      //System.out.println(driver.getTitle() + " " + signInPageTitle);
      Assert.assertEquals(driver.getTitle(), signInPageTitle);
   }
   //at least 10 tests equivalent
   @DataProvider(name = "signInExcelData")
   public Object[][] signInData() throws IOException{
      Object[][] arrayExcelData = excelData.fileReader1(excelPath, "Sheet1");
      return arrayExcelData;
   }

   @Test(dataProvider = "signInExcelData")
   public void testInvalidAccountSignIn(String email, String pwd) {
      System.out.println(homePageAmazon.invalidAccountSignIn(email, pwd));
   }
   //5
   //@Test
   public void testNavigation() {
      String subUrl = "https://www.google.com/";
      driver.navigate().to(subUrl);
      driver.navigate().back();
      driver.navigate().forward();
      Assert.assertEquals(driver.getCurrentUrl(), subUrl);
   }

   //@Test
   public void testClickLangSettings() {
      homePageAmazon.clickLangSettings();
   }
   //6.Mouse Hover
   //@Test
   public void testYourLists() throws Exception {
      System.out.println(homePageAmazon.hoverOverAccountsAndSelect());

   }
   //7.checkboxes
   //@Test
   public void testCheckboxesInGiftCards() throws Exception {
      homePageAmazon.checkboxesInGiftCards();
   }

   //radio button test, text area test and pop up window
   //@Test
   public void testAdFeedbackWindow() {
      homePageAmazon.adFeedbackWindow();
   }

   //@Test - Not working
   public void testHandleWindows() {
      System.out.println(homePageAmazon.handleWindows());
   }

   //@Test
   public void testPrimePageTable() {
      homePageAmazon.primePageTable();
   }

   //@Test
   public void testGetPrimePageTabs() {
      homePageAmazon.getPrimePageTabs();
   }

   //@Test
   public void testYourAccountLists() {
      homePageAmazon.yourAccountLinks();
   }

   //@Test - Not working
   /*public void testSortByList() {
      homePageAmazon.sortByList();
   }*/

   //@Test
   public void testAddToCart() {
      homePageAmazon.addToCart();
   }

   //@Test
   public void testIFrameExample() {
      homePageAmazon.iFrameExample();
   }

   //@Test
   public void testUpperRightLink() {
      homePageAmazon.upperRightLink();
   }

}
