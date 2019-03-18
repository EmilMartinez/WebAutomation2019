package testamazonpages;

import amazonpages.HomePageAmazon;
import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TestHomePageAmazon extends CommonAPI {
   HomePageAmazon homePageAmazon;
   @BeforeMethod
   public void initialize() {
      this.homePageAmazon = PageFactory.initElements(this.driver, HomePageAmazon.class);
   }

   @Test
   public void testSearchForItems() {
      homePageAmazon.searchForItems("alexa");
   }

}
