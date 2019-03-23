package homepage.menubar.dropdowns;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class News {
   @FindBy (css = ".navigation-wrapper > div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.homepage.menu-large:nth-child(3) > ul.dropdown-homepage.menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(1) > a:nth-child(1)")
   private WebElement link_africa;

   @FindBy (css = ".navigation-wrapper > div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.homepage.menu-large:nth-child(3) ul.dropdown-homepage.menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(2) > a:nth-child(1)")
   private WebElement link_asia;

   @FindBy (css = ".navigation-wrapper > div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.homepage.menu-large:nth-child(3) ul.dropdown-homepage.menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(3) > a:nth-child(1)")
   private WebElement link_usAndCa;

   @FindBy (css = ".navigation-wrapper > div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.homepage.menu-large:nth-child(3) ul.dropdown-homepage.menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(4) > a:nth-child(1)")
   private WebElement link_latinAmerica;

   @FindBy (css = ".navigation-wrapper > div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.homepage.menu-large:nth-child(3) ul.dropdown-homepage.menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(5) > a:nth-child(1)")
   private WebElement link_europe;

   @FindBy (css = ".navigation-wrapper > div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.homepage.menu-large:nth-child(3) ul.dropdown-homepage.menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(6) > a:nth-child(1)")
   private WebElement link_asiaPacific;

   @FindBy (css = ".navigation-wrapper > div.navbar-collapse.collapse ul.nav.navbar-nav li.dropdown.homepage.menu-large:nth-child(3) ul.dropdown-homepage.menu.megamenu.row li.col-sm-4 ul:nth-child(1) li:nth-child(7) > a:nth-child(1)")
   private WebElement link_all;


   public void blah() {

   }


}
