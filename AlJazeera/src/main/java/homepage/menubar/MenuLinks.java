package homepage.menubar;

import databases.ConnectToSqlDB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will handle the 8 links in the top navigation bar.
 * Menu Links:
 *    - News (drop-down)
 *    - Middle East
 *    - Documentaries (drop-down)
 *    - Shows (drop-down)
 *    - Investigations
 *    - Opinion
 *    - In Pictures
 *    - More (not a link, only a drop-down)
 *    - Live
 */
public class MenuLinks {
   @FindBy(css = ".navigation-wrapper > div.navbar-collapse.collapse > ul.nav.navbar-nav > li.dropdown.homepage.menu-large:nth-child(3) > a.dropdown-toggle")
   private WebElement link_newsDD;

   @FindBy(css = ".nav-item-140311071122120:nth-child(4) > a:nth-child(1)")
   private WebElement link_middleEast;

   @FindBy(css = ".navigation-wrapper > div.navbar-collapse.collapse > ul.nav.navbar-nav > li.dropdown.homepage.menu-large:nth-child(5) > a.dropdown-toggle")
   private WebElement link_documentariesDD;

   @FindBy(css = ".navigation-wrapper > div.navbar-collapse.collapse > ul.nav.navbar-nav > li.dropdown.homepage.menu-large:nth-child(6) > a.dropdown-toggle")
   private WebElement link_showsDD;

   @FindBy(css = ".nav-item-141105143951929:nth-child(7) > a:nth-child(1)")
   private WebElement link_investigations;

   @FindBy(css = ".nav-item-181119115524858:nth-child(8) > a:nth-child(1)")
   private WebElement link_opinion;

   @FindBy(css = ".nav-item-161027083327112:nth-child(9) > a:nth-child(1)")
   private WebElement link_inPictures;

   @FindBy(css = ".navigation-wrapper > div.navbar-collapse.collapse > ul.nav.navbar-nav > li.dropdown.homepage.menu-large:nth-child(10) > a.dropdown-toggle")
   private WebElement field_moreDD;

   @FindBy(css = ".search-btn-section.watchLive-pad ul:nth-child(1) li.watch-live-sticky a:nth-child(1) > span.watch-live--stickyWord")
   private WebElement link_live;

   private ConnectToSqlDB conn = new ConnectToSqlDB();
   private String filepath = "../AlJazeera/src/test/resources/secret.properties";

   /**
    * Gathers all the WebElements of the Menu bar, stores into a list and returns it.
    *
    * @return This is a list of all the clickable homepage.menu links (excludes 'More' because it is not clickable).
    */
   public List<WebElement> returnWebElemListOfMenuLinks() {
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
    * Grabs the page title of a Menu from the SQL table and returns it. All homepage.menu titles are in the 'menu_titles' table.
    *
    * @param filepath This is the file with the login credentials.
    * @param menuLink This is the specific homepage.menu link you are trying to get the title for.
    * @return The title of the page of your specified homepage.menu link.
    * @throws IOException If system.properties could not be found.
    * @throws SQLException If 'menu_titles' could not be found.
    * @throws ClassNotFoundException If class cannot be found in the classpath.
    */
   private String getTitleFromSpecificMenuLink(String filepath, String menuLink) throws IOException, SQLException, ClassNotFoundException {
      return conn.readCol2FromSpecifiedCol1FromDB(filepath, menuLink, "menu_titles", "MenuName", "Title");
   }

   public String getMainPageTitle() throws IOException, SQLException, ClassNotFoundException {
      return getTitleFromSpecificMenuLink(filepath, "Home");
   }

   /**
    * Adds all of the homepage.menu page's titles from a SQL table into a list and returns it.
    *
    * @return A list of all of the homepage.menu page's title.
    * @throws Exception If the file with the login credentials haven't been found, 'menu_titles' table doesn't exist
    * or class could not be fond in the classpath.
    */
   public List<String> getListOfTitlesFromMenuLinks() throws Exception {
      List<String> temp = conn.readDataBase("menu_titles", "Title", filepath);

      // Removing the first element which is the main page title.
      temp.remove(0);
      return temp;
   }

   public void clickNews() throws InterruptedException, NullPointerException {
      link_newsDD.click();
      Thread.sleep(2000);
   }


}
