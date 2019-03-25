package menu;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;


public class Navigation extends CommonAPI {
   @FindBy(xpath = "//*[@id='en-US']/div[14]/header/div[2]/div/div[1]/div[1]/div/div[3]/div[1]/a")
   public static WebElement link_womenDD;

   @FindBy(xpath = "//*[@id='en-US']/div[14]/header/div[2]/div/div[1]/div[1]/div/div[3]/div[2]/a")
   public static WebElement link_accessoriesDD;

   @FindBy(xpath = "//*[@id='en-US']/div[14]/header/div[2]/div/div[1]/div[1]/div/div[3]/div[3]/a")
   public static WebElement link_plusSizeDD;

   @FindBy(xpath = "//*[@id='en-US']/div[14]/header/div[2]/div/div[1]/div[1]/div/div[3]/div[4]/a")
   public static WebElement link_menDD;

   @FindBy(xpath = "//*[@id='en-US']/div[14]/header/div[2]/div/div[1]/div[1]/div/div[3]/div[5]/a")
   public static WebElement link_girlDD;

   @FindBy(xpath = "//*[@id='en-US']/div[14]/header/div[2]/div/div[1]/div[1]/div/div[3]/div[6]/a")
   public static WebElement link_saleDD;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'View All')]")
   public static WebElement dd_women_viewAll;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'Best Sellers')]")
   public static WebElement dd_women_bestSeller;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'Bodysuits')]")
   public static WebElement dd_women_bodysuit;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'Dresses')]")
   public static WebElement dd_women_dresses;

   @FindBy(xpath = "//a[@href='/us/shop/catalog/category/f21/rompers-jumpsuits?dynamic=true']")
   public static WebElement dd_women_jumpsuits;

   @FindBy(xpath = "//a[@href='/us/shop/catalog/category/f21/top_blouses?dynamic=true']")
   public static WebElement dd_women_blouses;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'Swimwear')]")
   public static WebElement dd_women_swimwear;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'Shorts')]")
   public static WebElement dd_women_shorts;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'Sets')]" )
   public static WebElement dd_women_sets;

   @FindBy(xpath = "//a[@href='/us/shop/catalog/category/f21/activewear?dynamic=true']")
   public static WebElement dd_women_activewear;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'Bottoms')]")
   public static WebElement dd_women_bottoms;

   @FindBy(xpath = "//a[@href='/us/shop/catalog/category/f21/bottom_jeans?dynamic=true']")
   public static WebElement dd_women_jeans;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'Graphic Tees')]")
   public static WebElement dd_women_graphicTees;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'Hoodies + Sweatshirts')]")
   public static WebElement dd_women_hoodies;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'Intimates + Sleepwear')]")
   public static WebElement dd_women_sleepwear;

   @FindBy(xpath = "//a[@href='/us/shop/catalog/category/f21/outerwear_coats-and-jackets?dynamic=true']")
   public static WebElement dd_women_coats;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'Shoes')]")
   public static WebElement dd_women_shoes;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'Sweaters + Knits')]")
   public static WebElement dd_women_sweaters;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'Branded')]")
   public static WebElement dd_women_branded;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'Basics Shop')]")
   public static WebElement dd_women_basics;

   @FindBy(xpath = "//a[@href='/us/shop/catalog/category/f21/backinstock-women?dynamic=true']")
   public static WebElement dd_women_backInStock;

   @FindBy(xpath = "//div[@class='d_new_mega_menu hover_p bg_gray']//a[contains(text(),'Coming Soon')]")
   public static WebElement dd_women_comingSoon;

   @FindBy(xpath = "//div[@class='d_new_mega_menu hover_p bg_gray']//a[contains(text(),'Gift Cards')]")
   public static WebElement dd_women_giftCards;

   @FindBy(xpath = "//div[@class='vt']//a[contains(text(),'The Outlet')]")
   public static WebElement dd_women_outlet;

   @FindBy(xpath = "//div[@class='d_new_mega_menu hover_p bg_gray']//a[contains(text(),'Style Deals')]")
   public static WebElement dd_women_styleDeals;

   @FindBy(xpath = "//div[@class='d_new_mega_menu hover_p bg_gray']//a[contains(text(),'Sale')]")
   public static WebElement dd_women_sale;

   WebDriverWait wait = new WebDriverWait(driver, 1);

   public void clickOnWomensTab() throws Exception {
      link_womenDD.click();
   }
   public void clickOnAccessoriesTab() throws Exception{
      link_accessoriesDD.click();
   }
   public void clickOnPlusSizeTab() throws Exception{
      link_plusSizeDD.click();
   }
   public void clickMenTab() throws Exception{
      link_menDD.click();
   }
   public void clickGirlsTab() throws Exception{
      link_girlDD.click();
   }
   public void clickSaleTab() throws Exception{
      link_saleDD.click();
   }
   public void hoverOverViewAllTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_viewAll).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverBestSellerTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_bestSeller).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverBodysuitTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_bodysuit).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverDressesTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_dresses).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverJumpsuitsTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_jumpsuits).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverBlousesTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_blouses).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverSwimwearTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_swimwear).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverShortsTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_shorts).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverSetsTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_sets).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverActivewearTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_activewear).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverBottomsTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_bottoms).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverJeansTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_jeans).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverGraphicTeesTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_graphicTees).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverHoodiesTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_hoodies).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverSleepwearTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_sleepwear).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverCoatsTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_coats).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverShoesTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_shoes).click().perform();
      CommonAPI.sleepForTwoSec();
   }
   public void hoverOverSweatersTab() throws Exception, InterruptedException {
      Actions action = new Actions(driver);
      action.moveToElement(link_womenDD).perform();
      action.moveToElement(dd_women_sweaters).click().perform();
      CommonAPI.sleepForTwoSec();
   }
}