package amazonpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageAmazon {
   @FindBy(id = "twotabsearchtextbox")
   private WebElement searchBox;

   public void searchForItems(String item) {
      searchBox.clear();
      searchBox.sendKeys(item, Keys.ENTER);
   }
}
