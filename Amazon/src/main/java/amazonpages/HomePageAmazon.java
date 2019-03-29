package amazonpages;

import base.CommonAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.TestLogger;

import java.util.List;
import java.util.Set;

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

    @FindBy(id = "nav-link-accountList")
    private WebElement signIn;

    @FindBy(id = "ap_email")
    private WebElement emailAccount;

    @FindBy(id = "ap_password")
    private WebElement password;

    @FindBy(id = "signInSubmit")
    private WebElement signInSubmitButton;

    @FindBy(id = "auth-warning-message-box")
    private WebElement signInWarning;

    @FindBy(xpath = "//span[@class='icp-nav-link-inner']")
    private WebElement langLink;

    @FindBy(css = "a-row.a-spacing-mini")
    private List<WebElement> langSettings;

    //@FindBy(name = "locationID")
    @FindBy(xpath = "//*[@id='nav-flyout-prime']/div[2]/div[1]/div[3]/form/span/span/input")
    private WebElement primeLink;

    @FindBy(css = "#pet_your_prime > div.pet_your_prime_content_container > a > img")
    private WebElement primeWithLogin;

    @FindBy(css = "#leftNav > ul:nth-child(3) > div > li")
    private List<WebElement> giftcardDeliveryTypes;

    @FindBy(css = "#ad-feedback-text-right-2")
    private WebElement adFeedback;

    @FindBy(xpath = "//input[@type='radio' and @name='sharedPlacementRelevanceButton' and @value='5']")
    private WebElement adFeedbackRelevantRadio5;

    @FindBy(xpath = "//*[@id='commentsSection']/span[2]/div/textarea")
    private WebElement adFeedbackComments;

    @FindBy(xpath = "//span[@id='da-feedback-send-feedback-button']/span/input")
    private WebElement adFeedbackSubmit;

    @FindBy(css = "#nav-link-prime > span.nav-line-2")
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

    /************************************ Image locators **************************************************************/

    @FindBy(xpath = "//img[@alt='Low-cost device accessories']")
    private WebElement bargainFindsImage;

    @FindBy(xpath = "//h2[contains(text(),'Bargain')]")
    private WebElement bargainFindsImageTitle;

    @FindBy(xpath = "//img[@alt='DREAM PAIRS']")
    private WebElement mensShoesImage;

    @FindBy(xpath = "//h2[contains(text(),'dress shoes')]")
    private WebElement mensShoesImageTitle;

    @FindBy(xpath = "//img[@alt='Dasein']")
    private WebElement totesImage;

    @FindBy(xpath = "//h2[contains(text(),'Candy-color')]")
    private WebElement totesImageTitle;

    @FindBy(xpath = "//img[@alt='Furniture sold exclusively on Amazon']")
    private WebElement furnitureImage;

    @FindBy(xpath = "//h2[contains(text(),'Lounge')]")
    private WebElement furnituresImageTitle;

    @FindBy(xpath = "//img[@alt='Women’s shoes']")
    private WebElement shoesImage;

    @FindBy(xpath = "//h2[contains(text(),'Women')]")
    private WebElement shoesImageTitle;

    @FindBy(xpath = "//img[@alt='Image of an Amazon Smart Plug.']")
    private WebElement smartPlugImage;

    @FindBy(xpath = "//h2[contains(text(),'Smart Plug')]")
    private WebElement smartPlugImageTitle;


    /********************************Internal Links on the home page ***************************************************/

    @FindBy(id = "nav-recently-viewed")
    private WebElement browsingHistory;

    @FindBy(id = "nav-your-amazon")
    private WebElement yourAmazon;

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

    @FindBy(css = "#nav-cart-count")
    private WebElement cartCount;

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
    @FindBy(css = "#nav-item-signout > span")
    private WebElement signOut;

    @FindBy(css = "#nav-al-your-account > a:nth-child(2)")
    private WebElement yourAccount;

    @FindBy(xpath = "//*[@id='nav_prefetch_yourorders']/span")
    private WebElement yourOrders;

    //@FindBy(css = "#nav-al-title")
    @FindBy(css = "#nav-al-your-account > a:nth-child(5)")
    private WebElement yourLists;

    @FindBy(xpath = "//div[@id='nav-al-your-account']/a[4]/span")
    private WebElement yourRecommendations;

    @FindBy(xpath = "//div[@id='nav-al-your-account']/a[5]/span")
    private WebElement yourSubscribe;

/************************************************************************************************/

    /**************************** Bottom Links *******************************************************/
    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[1]/td[1]")
    private WebElement amazonMusic;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[1]/td[3]")
    private WebElement amazonAdvertising;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[1]/td[5]")
    private WebElement amazonDrive;

    @FindBy(xpath = "//a[@href='http://www.6pm.com']")
    private WebElement sixpmDeals;

    @FindBy(xpath = "//a[@href='https://www.abebooks.com']")
    private WebElement abeBooks;

    @FindBy(xpath = "//a[@href='http://www.acx.com/']")
    private WebElement acx;

    @FindBy(xpath = "//a[@href='http://www.alexa.com']")
    private WebElement alexa;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[3]/td[1]")
    private WebElement amazonBusiness;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[3]/td[3]")
    private WebElement amazonFresh;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[3]/td[5]")
    private WebElement amazonGlobal;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[3]/td[7]")
    private WebElement homeService;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[3]/td[9]")
    private WebElement amazonInspire;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[3]/td[11]")
    private WebElement amazonRapids;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[3]/td[13]")
    private WebElement amazonRestaurants;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[5]/td[1]")
    private WebElement amazonWebServices;

    @FindBy(xpath = "//a[@href='https://www.audible.com']")
    private WebElement audible;

    @FindBy(xpath = "//a[@href='http://www.bookdepository.com']")
    private WebElement bookDepository;

    @FindBy(xpath = "//a[@href='http://www.boxofficemojo.com/?ref_=amzn_nav_ftr']")
    private WebElement boxOfficeMojo;

    @FindBy(xpath = "//a[@href='http://www.comixology.com']")
    private WebElement comixology;

    @FindBy(xpath = "//a[@href='http://www.createspace.com']")
    private WebElement createSpace;

    @FindBy(xpath = "//a[@href='http://www.dpreview.com']")
    private WebElement dpReview;

    @FindBy(xpath = "//a[@href='http://www.eastdane.com/welcome']")
    private WebElement eastDane;

    @FindBy(xpath = "//a[@href='http://www.fabric.com']")
    private WebElement fabric;

    @FindBy(xpath = "//a[@href='http://www.goodreads.com']")
    private WebElement goodReads;

    @FindBy(xpath = "//a[@href='http://www.imdb.com']")
    private WebElement imdb;

    @FindBy(xpath = "//a[@href='http://pro.imdb.com?ref_=amzn_nav_ftr']")
    private WebElement imdbPro;

    @FindBy(xpath = "//a[@href='http://www.junglee.com']")
    private WebElement junglee;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[7]/td[13]")
    private WebElement kindleDirectPublishing;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[9]/td[1]")
    private WebElement primeNow;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[9]/td[3]")
    private WebElement amazonPhotos;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[9]/td[5]")
    private WebElement primeVideoDirect;

    @FindBy(xpath = "//a[@href='http://www.shopbop.com/welcome']")
    private WebElement shopBop;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[9]/td[9]")
    private WebElement amazonWarehouse;

    @FindBy(xpath = "//a[@href='http://www.wholefoodsmarket.com']")
    private WebElement wholeFoodsMarket;

    @FindBy(xpath = "//a[@href='https://www.woot.com/']")
    private WebElement woot;

    @FindBy(xpath = "//a[@href='http://www.zappos.com']")
    private WebElement zappos;

    @FindBy(xpath = "//a[@href='https://www.souq.com?ref=footer_souq']")
    private WebElement souq;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[11]/td[5]")
    private WebElement amazonSubscribe;

    @FindBy(xpath = "//a[@href='http://www.pillpack.com']")
    private WebElement pillPack;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[11]/td[9]")
    private WebElement amazonRenewed;

    @FindBy(xpath = "//*[@class='navFooterMoreOnAmazon']/tbody//tr[11]/td[11]")
    private WebElement amazonSecondChance;

    /************************************End Bottom Links *****************************************************************/
    public void searchForItems(String item) {
        searchBox.clear();
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
        emailAccount.sendKeys(email, Keys.ENTER);
        password.sendKeys(pwd);
        try {
            signInSubmitButton.click();
            return signInWarning.getText();
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public void InvalidSignInScreenShot(String email, String pwd) {
        signInLink();
        emailAccount.sendKeys(email, Keys.ENTER);
        password.sendKeys(pwd);
        signInSubmitButton.click();
    }

    //radio buttons
    public void clickLangSettings() {
        langLink.click();
        for (WebElement w : langSettings) {
            w.click();
        }
    }

    public String hoverOverAccountsAndSelect() throws Exception {
        validSignIn();
        Actions action = new Actions(driver);
        action.moveToElement(signIn).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", yourLists);
        //action.moveToElement(yourLists).click().perform();
        return driver.getTitle();
    }

    public void checkboxesInGiftCards() throws Exception {
        giftCards.click();
        for (int i = 0; i < giftcardDeliveryTypes.size(); i++) {
            giftcardDeliveryTypes.get(i).click();
            TestLogger.log("Checkbox" + (i + 1) + ": " + driver.getTitle());
            System.out.println(driver.getTitle());
            giftCards.click();
        }
    }

    public void adFeedbackWindow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", adFeedback);
        //adFeedback.click();
        //wait.until(ExpectedConditions.elementToBeClickable(adFeedbackRelevantRadio5));
        adFeedbackRelevantRadio5.click();
        adFeedbackComments.sendKeys("Like this");
        adFeedbackSubmit.click();
    }

    public String handleWindows() {
        String otherWindowTitle = "";
        String parentHandle = driver.getWindowHandle();
        attWindow.click();
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
        for (WebElement w : primeTableRows) {
            TestLogger.log(w.getText());
        }
    }

    public void getPrimePageTabs() {
        tryPrime.click();
        for (WebElement element : primePageTabs) {
            element.click();
            TestLogger.log(element.getText());
        }
    }

    /////////////////////////////// Your Lists Methods ////////////////////////////////////////////
    public void validSignIn() {
        signIn.click();
        emailAccount.sendKeys("seltmasterME@gmail.com");
        password.sendKeys("Manage456$");
        signInSubmitButton.click();
    }

    public void signOut() {
        validSignIn();
        Actions action = new Actions(driver);
        action.moveToElement(signIn).perform();
        //action.moveToElement(signOut).click().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", primeWithLogin);
    }

    public void primeLink() {
        validSignIn();
        Actions action = new Actions(driver);
        action.moveToElement(tryPrime).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", primeWithLogin);
    }

    public String yourAccountLinks() {
        validSignIn();
        Actions action = new Actions(driver);
        action.moveToElement(signIn).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", yourAccount);
        return driver.getTitle();
    }

    public void addToCart() {
        validSignIn();
        searchBox.sendKeys("scarf", Keys.ENTER);
        chapStick.click();
        //wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCart.click();
        TestLogger.log("Number of items in cart: " + cartCount.getText());
    }

    public void iFrameExample() {
        String parentHandle = driver.getWindowHandle();
        driver.switchTo().frame(iframeTags.get(1));
        //wait.until(ExpectedConditions.elementToBeClickable(iframeLocator));
        iframeLocator.click();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.getTitle());
        driver.switchTo().parentFrame();
    }

    public void upperRightLink() {
        upperRightLink.click();
        System.out.println(driver.getTitle());
    }

    /************************************ Images check methods ****************************************************/

    public void imagePresent(List<String> imgInfo) {

        //imgInfo.add(imageInfo(bargainFindsImage, bargainFindsImageTitle));
        //imgInfo.add(imageInfo(mensShoesImage, mensShoesImageTitle));
        //imgInfo.add(imageInfo(totesImage, totesImageTitle));
        //imgInfo.add(imageInfo(furnitureImage, furnituresImageTitle));
        //imgInfo.add(imageInfo(shoesImage, shoesImageTitle));
        imgInfo.add(imageInfo(smartPlugImage, smartPlugImageTitle));
    }

    public String imageInfo(WebElement image, WebElement imageTitle) {
        Boolean imagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image);
        if (!imagePresent)
            return imageTitle.getText() + " image not present";
        else
            return imageTitle.getText() + " image present";
    }

    /**************************Internal Link check methods********************************************************/

    public void internalLinks(List<String> links) {

        validSignIn();
        if (browsingHistory.isDisplayed()) {
            browsingHistory.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (yourAmazon.isDisplayed()) {
            yourAmazon.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (todaysDeals.isDisplayed()) {
            todaysDeals.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (giftCards.isDisplayed()) {
            giftCards.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (wholeFoods.isDisplayed()) {
            wholeFoods.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (sell.isDisplayed()) {
            sell.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (registry.isDisplayed()) {
            registry.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (help.isDisplayed()) {
            help.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (upperRightLink.isDisplayed()) {
            upperRightLink.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonMusic.isDisplayed()) {
            amazonMusic.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonAdvertising.isDisplayed()) {
            amazonAdvertising.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonDrive.isDisplayed()) {
            amazonDrive.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonBusiness.isDisplayed()) {
            amazonBusiness.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonFresh.isDisplayed()) {
            amazonFresh.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonGlobal.isDisplayed()) {
            amazonGlobal.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (homeService.isDisplayed()) {
            homeService.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonInspire.isDisplayed()) {
            amazonInspire.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonRapids.isDisplayed()) {
            amazonRapids.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonRestaurants.isDisplayed()) {
            amazonRestaurants.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonWebServices.isDisplayed()) {
            amazonWebServices.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (kindleDirectPublishing.isDisplayed()) {
            kindleDirectPublishing.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (primeNow.isDisplayed()) {
            primeNow.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonPhotos.isDisplayed()) {
            amazonPhotos.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (primeVideoDirect.isDisplayed()) {
            primeVideoDirect.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonWarehouse.isDisplayed()) {
            amazonWarehouse.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonSubscribe.isDisplayed()) {
            amazonSubscribe.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonRenewed.isDisplayed()) {
            amazonRenewed.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        if (amazonSecondChance.isDisplayed()) {
            amazonSecondChance.click();
            links.add(driver.getTitle());
            driver.navigate().back();
        }

        //signOut();
    }

    public void externalLinks(List<String> links) {

        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dpReview);
        driver.navigate().to(dpReview.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        //sixpmDeals.click();
        driver.navigate().to(sixpmDeals.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(abeBooks.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(acx.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(alexa.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(audible.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(bookDepository.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(boxOfficeMojo.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(comixology.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(createSpace.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(eastDane.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(fabric.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(goodReads.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(imdb.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(imdbPro.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(junglee.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(shopBop.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(wholeFoodsMarket.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(woot.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(zappos.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(souq.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();

        driver.navigate().to(pillPack.getAttribute("href"));
        links.add(driver.getTitle());
        driver.navigate().back();
    }
}

