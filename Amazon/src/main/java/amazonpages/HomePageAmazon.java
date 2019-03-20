package amazonpages;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomePageAmazon extends CommonAPI {
   WebDriverWait wait = new WebDriverWait(driver, 1);

   @FindBy(id = "twotabsearchtextbox")
   private WebElement searchBox;

   @FindBy(xpath = "//input[@type='submit' and @value='Go']")
   private WebElement searchButton;

   @FindBy(id = "searchDropdownBox")
   private WebElement dropdown;

   @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']/span")
   private WebElement searchResults;

   @FindBy(id="nav-link-accountList")
   private WebElement signIn;

   @FindBy(id = "ap_email")
   private WebElement emailAccount;

   @FindBy(id = "ap_password")
   private WebElement password;

   @FindBy(id = "signInSubmit")
   private WebElement signInSubmitButton;

   @FindBy(id = "auth-warning-message-box")
   private WebElement signInWarning;

   //cssselector=a-row.a-spacing-mini title = Change Language Settings
   @FindBy(xpath = "//span[@class='icp-nav-link-inner']")
   private WebElement langLink;
   @FindBy(css = "a-row.a-spacing-mini")
   private List<WebElement> langSettings;

   @FindBy(xpath = "//*[@id='leftNav']//ul[1]//input")
   private List<WebElement> giftcardDeliveryTypes;

   @FindBy(xpath = "//*[@id='ad-feedback-sprite-right-7']")
   private WebElement adFeedback;

   @FindBy(xpath = "//input[@type='radio' and @name='sharedPlacementRelevanceButton' and @value='5']")
   private WebElement adFeedbackRelevantRadio5;

   @FindBy(xpath = "//*[@id='commentsSection']/span[2]/div/textarea")
   private WebElement adFeedbackComments;

   @FindBy(xpath = "//span[@id='da-feedback-send-feedback-button']/span/input")
   private WebElement adFeedbackSubmit;

   @FindBy(xpath = "//*[@id='nav-link-prime']/span[2]")
   private WebElement tryPrime;

   @FindBy(xpath = "//*[@id='primeComparisonTable']/tbody/tr")
   private List<WebElement> primeTableRows;

   @FindBy(xpath = "//*[@id='primeComparisonTable']//tr/td")
   private List<WebElement> primeTableAllData;

   @FindBy(xpath = "//*[@id='prime-benefit-cards']/div")
   private List<WebElement> primePageTabs;

   @FindBy(xpath = "//*[@id='s-c97eb555-0e3b-118e-b0cd-0dd82c9b0b63']")
   //@FindBy(id = "desktop-grid-1-D2")
   private WebElement attWindow;

   @FindBy(xpath = "//select[@id='s-result-sort-select']")
   private WebElement sortButton;

   @FindBy(xpath = "//*[@class='a-popover-inner']/ul/li")
   private List<WebElement> sortButtonOptions;

   @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[3]/div/div/div/div[2]/div[3]/div/div[1]/div/div/a")
   private WebElement chapStick;

   @FindBy(id = "add-to-cart-button")
   private WebElement addToCart;

   @FindBy(id = "ape_Gateway_right-2_desktop_iframe")
   private WebElement iframeExample;

   @FindBy(tagName = "iframe")
   private List<WebElement> iframeTags;

   @FindBy(xpath = "//img[@id='staticImage']")
   private WebElement iframeLocator;

   @FindBy(xpath = "//*[@id='navSwmHoliday']/a")
   private WebElement upperRightLink;

/*************************************************************************************************/
   /////All internal links on the home page
   @FindBy(id="nav-your-amazon")
   private WebElement yourAmazon;
    //a[@class='nav-a' and @tabindex='48']
   @FindBy(xpath = "//div[@id='nav-xshop']//a[2]")
   private WebElement todaysDeals;

   @FindBy(xpath = "//div[@id='nav-xshop']//a[3]")
   private WebElement giftCards;

   @FindBy(xpath = "//div[@id='nav-xshop']//a[4]")
   private WebElement wholeFoods;

   @FindBy(xpath = "//div[@id='nav-xshop']//a[5]")
   private WebElement sell;

   @FindBy(xpath = "//div[@id='nav-xshop']//a[6]")
   private WebElement registry;

   @FindBy(xpath = "//div[@id='nav-xshop']//a[7]")
   private WebElement help;

   @FindBy(xpath = "//*[@id='navSwmHoliday']/a/img")
   private WebElement supportArtisans;

   @FindBy(xpath = "//a[@id='nav-orders' and @class='nav-a nav-a-2 nav-single-row-link']")
   private WebElement cart;

   @FindBy(xpath = "//img[@alt='Low-cost device accessories']")
   private WebElement bargainFinds;

   @FindBy(xpath = "//*[@id='Q5fNEkjY3fPZB4TTSzfC2Q']/a")
   private WebElement bargainSeemore;

   @FindBy(xpath = "//img[@alt='Women’s shoes']")
   private WebElement womensShoes;

   @FindBy(linkText = "Shop now")
   private WebElement shopNow;

   @FindBy(xpath = "//a[@aria-label='Home décor']")
   private WebElement homeDecor;

   @FindBy(xpath = "//a[@aria-label='Jewelry']")
   private WebElement jewelry;

   @FindBy(xpath = "//a[@aria-label='Gifts']")
   private WebElement gifts;

   @FindBy(xpath = "//a[@aria-label='Kitchen']")
   private WebElement kitchen;

   @FindBy(linkText = "Sign in securely")
   private WebElement signInSecurely;

   @FindBy(xpath = "//*[@id='w-b38d296c-bdbc-5774-106f-48be1f8e005e']/div")
   private WebElement unlimitedPlan;

   @FindBy(partialLinkText = "Sign in to see personalized recommendations")
   private WebElement personalizedRecommondations;

   @FindBy(xpath = "//*[@id='div-gpt-ad']/a/img")
   private WebElement amazonGiftCards;

   @FindBy(xpath = "//*[@id='nav-orders']/span[2]")
   private WebElement orders;

////////////////////////////  Your Lists //////////////////////////////////////
   @FindBy(xpath = "//*[@id='nav-al-your-account']/a[1]/span")
   private WebElement yourAccount;

   @FindBy(xpath = "//*[@id='nav_prefetch_yourorders']/span")
   private WebElement yourOrders;

   @FindBy(id = "nav-al-title")
   private WebElement yourLists;

   @FindBy(xpath = "//div[@id='nav-al-your-account']/a[4]/span")
   private WebElement yourRecommendations;

   @FindBy(xpath = "//div[@id='nav-al-your-account']/a[5]/span")
   private WebElement yourSubscribe;

   //help-gateway-category-1

/************************************************************************************************/


   public void searchForItems(String item) {
      searchBox.clear();
      try {
         Thread.sleep(3000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      searchBox.sendKeys(item, Keys.ENTER);
   }

   public void searchButton(String stuff) {
      searchBox.sendKeys(stuff);
      searchButton.click();
   }

   public String searchResults(String item) {
      searchBox.sendKeys(item, Keys.ENTER);
      return searchResults.getText();
   }

   public List<WebElement> getDropdownOptions() {
      Select select = new Select(dropdown);
      return select.getOptions();
   }

   public String setDropdown() {
      String value = "search-alias=amazonfresh";
      Select select = new Select(dropdown);
      select.selectByValue(value);
      searchBox.sendKeys("fruits", Keys.ENTER);
      return driver.getTitle();
   }

   public void signInLink() {
      signIn.click();
   }

   public String invalidAccountSignIn(String email, String pwd) {
      signInLink();
      try {
         Thread.sleep(2000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      emailAccount.sendKeys(email, Keys.ENTER);
      password.sendKeys(pwd);
      try {
         signInSubmitButton.click();
         return signInWarning.getText();
      } catch (Exception e) {
         return e.getMessage();
      }

   }

   //radio buttons
   public void clickLangSettings() {
      langLink.click();
      for (WebElement w : langSettings) {
         w.click();
      }
   }

   //Check internal links under Account & Lists
   public void yourLists() {
      yourLists.click();
   }

   public String hoverOverAccountsAndSelect() throws Exception {
      Actions action = new Actions(driver);
      action.moveToElement(signIn).perform();
      action.moveToElement(yourLists).click().perform();
      Thread.sleep(4000);
      return driver.getTitle();
   }

   public void checkboxesInGiftCards() throws Exception {
      giftCards.click();
      for (int i = 0; i < giftcardDeliveryTypes.size(); i++) {
         giftcardDeliveryTypes.get(i).click();
         System.out.println(driver.getTitle());
         Thread.sleep(2000);
         giftCards.click();
      }
   }

   public void adFeedbackWindow() {
      adFeedback.click();
      adFeedbackRelevantRadio5.click();
      adFeedbackComments.sendKeys("Add more kid friendly programs");
      try {
         Thread.sleep(1500);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      adFeedbackSubmit.click();
   }

   public String handleWindows() {
      String otherWindowTitle = "";
      String parentHandle = driver.getWindowHandle();
      attWindow.click();
      try {
         Thread.sleep(1500);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      Set<String> handles = driver.getWindowHandles();
      for (String handle : handles) {
         if (!handle.equals(parentHandle)) {
            driver.switchTo().window(handle);
            otherWindowTitle = driver.getTitle();
            driver.close();
            break;
         }
      }
      driver.switchTo().window(parentHandle);
      return otherWindowTitle;
   }

   public void primePageTable() {
      tryPrime.click();
      System.out.println(primeTableRows.size());
      for (WebElement w : primeTableRows) {
         System.out.println(w.getText());
      }
      for (WebElement element : primeTableAllData) {
         System.out.println(element.getText());
      }
   }

   public void getPrimePageTabs() {
      tryPrime.click();
      for (WebElement element : primePageTabs) {
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         element.click();
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }

/////////////////////////////// Your Lists Methods ////////////////////////////////////////////
   public void validSignIn() {
      signIn.click();
      emailAccount.sendKeys("varija.kolagotla@gmail.com");
      password.sendKeys("varija92");
      signInSubmitButton.click();
   }

   public void yourAccountLinks() {
      validSignIn();
      Actions action = new Actions(driver);
      action.moveToElement(signIn).perform();
      wait.until(ExpectedConditions.visibilityOf(yourAccount));
      action.moveToElement(yourAccount).click().perform();
      System.out.println(driver.getTitle());
   }

   public void addToCart() {
      validSignIn();
      searchBox.sendKeys("scarf", Keys.ENTER);
      chapStick.click();
      wait.until(ExpectedConditions.elementToBeClickable(addToCart));
      addToCart.click();
   }

   public void iFrameExample() {
      String parentHandle = driver.getWindowHandle();
      driver.switchTo().frame(iframeTags.get(1));
      wait.until(ExpectedConditions.elementToBeClickable(iframeLocator));
      iframeLocator.click();
      try {
         Thread.sleep(1500);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println(driver.getTitle());
      System.out.println(driver.getPageSource());
      driver.switchTo().parentFrame();
   }

   ///// List method
   /*public void sortByList() {
      searchBox.sendKeys("sunscreen", Keys.ENTER);
      //wait.until(ExpectedConditions.elementToBeClickable(sortButton));
      Select select = new Select(sortButton);
      sortButton.click();
      for (int i = 0; i < sortButtonOptions.size(); i++) {
         select.selectByIndex(i);
         try {
            Thread.sleep(1500);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }*/

      public void upperRightLink() {
         upperRightLink.click();
         System.out.println(driver.getTitle());
   }

}

