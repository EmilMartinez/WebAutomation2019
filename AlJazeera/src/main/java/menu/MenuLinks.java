package menu;

import databases.ConnectToSqlDB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.thread.ThreadExecutionException;
import org.testng.internal.thread.ThreadTimeoutException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuLinks {
   @FindBy(css = ".navigation-wrapper > div.navbar-collapse.collapse > ul.nav.navbar-nav > li.dropdown.menu-large:nth-child(3) > a.dropdown-toggle")
   private WebElement link_newsDD;

   @FindBy(css = ".nav-item-140311071122120:nth-child(4) > a:nth-child(1)")
   private WebElement link_middleEast;

   @FindBy(css = ".navigation-wrapper > div.navbar-collapse.collapse > ul.nav.navbar-nav > li.dropdown.menu-large:nth-child(5) > a.dropdown-toggle")
   private WebElement link_documentariesDD;

   @FindBy(css = ".navigation-wrapper > div.navbar-collapse.collapse > ul.nav.navbar-nav > li.dropdown.menu-large:nth-child(6) > a.dropdown-toggle")
   private WebElement link_showsDD;

   @FindBy(css = ".nav-item-141105143951929:nth-child(7) > a:nth-child(1)")
   private WebElement link_investigations;

   @FindBy(css = ".nav-item-181119115524858:nth-child(8) > a:nth-child(1)")
   private WebElement link_opinion;

   @FindBy(css = ".nav-item-161027083327112:nth-child(9) > a:nth-child(1)")
   private WebElement link_inPictures;

   @FindBy(css = ".navigation-wrapper > div.navbar-collapse.collapse > ul.nav.navbar-nav > li.dropdown.menu-large:nth-child(10) > a.dropdown-toggle")
   private WebElement link_moreDD;

   @FindBy(css = ".search-btn-section.watchLive-pad ul:nth-child(1) li.watch-live-sticky a:nth-child(1) > span.watch-live--stickyWord")
   private WebElement link_live;

   private ConnectToSqlDB conn = new ConnectToSqlDB();
   private String filepath = "../AlJazeera/src/test/resources/secret.properties";

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

   public String getTitleFromSpecificMenuLink(String filepath, String menuLink) throws IOException, SQLException, ClassNotFoundException {
      return conn.readCol2FromSpecifiedCol1FromDB(filepath, menuLink, "menu_titles", "MenuName", "Title");
   }

   public String getMainPageTitle() throws IOException, SQLException, ClassNotFoundException{
      return getTitleFromSpecificMenuLink(filepath, "Home");
   }

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
