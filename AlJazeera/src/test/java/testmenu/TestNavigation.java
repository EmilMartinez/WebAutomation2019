package testmenu;
import base.CommonAPI;
import menu.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNavigation extends CommonAPI {
   Navigation newNav;

   @BeforeMethod
   public void initialize() {
      newNav =  PageFactory.initElements(driver, Navigation.class);
   }


   @Test (priority = 1, description = "Test #1 -- Checking main page title")
   public void testHomeTitle() throws IOException, SQLException, ClassNotFoundException {
      String temp = "";
      try {
         temp = newNav.getMainPageTitle();
      } catch (NullPointerException e) {
         System.out.println("String is null");
      }
      Assert.assertEquals(temp, driver.getTitle());
   }

   @Test (priority = 2, description = "Test #2 -- Checking Menu links.")
   public void clickAllMenuLinks() throws InterruptedException, NullPointerException {
      for (WebElement w : newNav.returnWebElemListOfMenuLinks()) {
         w.click();
         CommonAPI.sleepForTwoSec();
         driver.navigate().back();
      }
   }

   @Test (priority = 3, description = "Test #3 -- Checking the titles of all pages from Menu links.")
   public void clickAndCheckTitleOfMenuLinks() throws Exception {
      for (int i = 0; i < newNav.returnWebElemListOfMenuLinks().size(); i++) {
         newNav.returnWebElemListOfMenuLinks().get(i).click();
         Assert.assertEquals(newNav.getListOfTitlesFromMenuLinks().get(i),driver.getTitle());
         driver.navigate().back();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }
   }

}
