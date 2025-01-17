package homepage.menubar;

import base.CommonAPI;
import databases.ConnectToSqlDB;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will handle the 8 links in the top navigation bar.
 * Menu Links:
 * - News (drop-down)
 * - Middle East
 * - Documentaries (drop-down)
 * - Shows (drop-down)
 * - Investigations
 * - Opinion
 * - In Pictures
 * - More (not a link, only a drop-down)
 * - Live
 */
public class MenuLinks extends CommonAPI {
   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav > li.dropdown.menu-large:nth-child(3)")
   private WebElement link_newsDD;

   @FindBy(css = ".nav-item-140311071122120:nth-child(4)")
   private WebElement link_middleEast;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav > li.dropdown.menu-large:nth-child(5)")
   private WebElement link_documentariesDD;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav > li.dropdown.menu-large:nth-child(6)")
   private WebElement link_showsDD;

   @FindBy(css = ".nav-item-141105143951929:nth-child(7)")
   private WebElement link_investigations;

   @FindBy(css = ".nav-item-181119115524858:nth-child(8)")
   private WebElement link_opinion;

   @FindBy(css = ".nav-item-161027083327112:nth-child(9)")
   private WebElement link_inPictures;

   @FindBy(css = ".navigation-wrapper div.navbar-collapse.collapse ul.nav.navbar-nav > li.dropdown.menu-large:nth-child(10)")
   private WebElement field_moreDD;

   @FindBy(css = ".search-btn-section.watchLive-pad ul:nth-child(1) li.watch-live-sticky a:nth-child(1) > span.watch-live--stickyWord")
   private WebElement link_live;

   @FindBy(xpath = "//img[@class='article-main-header-logo-Big']")
   private WebElement pic_logo;

   @FindBy(xpath = "//button[@id='ChangeToggleMobile']")
   private WebElement button_navDropdown;

   @FindBy(xpath = "//div[@class='navbar-header']//div[2]")
   private WebElement button_closeNavDropdown;

   @FindBy(xpath = "//li[@id='Li2']")
   private WebElement link_smallLive;

   private ConnectToSqlDB conn = new ConnectToSqlDB();
   private String filepath = "../AlJazeera/src/test/resources/secret.properties";

   public void clickOnLogo() {
      pic_logo.click();
   }

   /**
    * Gathers all the WebElements of the Menu bar, stores into a list and returns it.
    *
    * @return This is a list of all the clickable homepage.menu links (excludes 'More' because it is not clickable).
    */
   public List<WebElement> returnWebElemListOfMenuLinks() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> listOfMenuLinks = new ArrayList<WebElement>();

      listOfMenuLinks.add(link_newsDD);
      listOfMenuLinks.add(link_middleEast);
      listOfMenuLinks.add(link_documentariesDD);
      listOfMenuLinks.add(link_showsDD);
      listOfMenuLinks.add(link_investigations);
      listOfMenuLinks.add(link_opinion);
      listOfMenuLinks.add(link_inPictures);
      listOfMenuLinks.add(link_live);

      return listOfMenuLinks;
   }

   /**
    * Gathers all the WebElements of the Menu bar with a dropdown, stores into a list and returns it.
    *
    * @return This is a list of all the WebElements with dropdowns.
    */
   public List<WebElement> returnWebElemListOfMenuLinksWithDD() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<WebElement> list = new ArrayList<WebElement>();
      list.add(link_newsDD);
      list.add(link_documentariesDD);
      list.add(link_showsDD);
      list.add(field_moreDD);

      return list;
   }

   /**
    * Grabs the page title of a Menu from the SQL table and returns it. All homepage.menu titles are in the 'menu_titles' table.
    *
    * @param filepath This is the file with the login credentials.
    * @param menuLink This is the specific homepage.menu link you are trying to get the title for.
    * @return The title of the page of your specified homepage.menu link.
    * @throws IOException            If system.properties could not be found.
    * @throws SQLException           If 'menu_titles' could not be found.
    * @throws ClassNotFoundException If class cannot be found in the classpath.
    */
   private String getTitleFromSpecificMenuLink(String filepath, String menuLink) throws IOException, SQLException, ClassNotFoundException {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      return conn.readCol2FromSpecifiedCol1FromDB(filepath, menuLink, "menu_titles", "MenuName", "Title");
   }

   public String getMainPageTitle() throws IOException, SQLException, ClassNotFoundException {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      return getTitleFromSpecificMenuLink(filepath, "Home");
   }

   /**
    * Adds all of the homepage.menu page's titles from a SQL table into a list and returns it.
    *
    * @return A list of all of the homepage.menu page's title.
    * @throws Exception If the file with the login credentials haven't been found, 'menu_titles' table doesn't exist
    *                   or class could not be fond in the classpath.
    */
   public List<String> getListOfTitlesFromMenuLinks() throws Exception {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      List<String> temp = conn.readDataBase("menu_titles", "Title", filepath);

      // Removing the first element which is the main page title.
      temp.remove(0);
      return temp;
   }

   public boolean isDropDownVisible(WebElement webElement) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()) + " (" + webElement.getText() + ")");

      // Finding the WebElement of the dropdown modal.
      WebElement dropdown = webElement.findElement(By.cssSelector("ul.dropdown-menu.megamenu.row"));

      // Checks if dropdown is visible.
      if (dropdown.isDisplayed())
         return true;
      return false;
   }

   /**
    * Hovers over a menu link.
    *
    * @param webElement Menu's WebElement to be hovered over.
    */
   public void hoverOverMenuLink(WebElement webElement) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()) + " (" + webElement.getText() + ")");

      Actions builder = new Actions(CommonAPI.driver);
      builder.moveToElement(webElement).perform();
   }

   public void clickOnElem(WebElement w) {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()) + " (" + w.getText() + ")");

      w.click();
   }

   /**
    * Resizes the window to 400x400.
    */
   public void decreaseWindowSize() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      CommonAPI.driver.manage().window().setSize(new Dimension(400, 400));
   }

   public boolean isSmallNavbarVisible() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      if (button_navDropdown.isDisplayed())
         return true;
      return false;
   }

   public void clickOnSmallNavBar() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      button_navDropdown.click();
   }

   public boolean isSmallNavbarCloseButtonVisible() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      if (button_closeNavDropdown.isDisplayed())
         return true;
      return false;
   }

   public boolean isLiveVisibleAfterReducingWindowSize() {
      TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
      }.getClass().getEnclosingMethod().getName()));

      if (link_smallLive.isDisplayed())
         return true;
      return false;
   }
}
