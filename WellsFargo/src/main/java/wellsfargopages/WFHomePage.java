package wellsfargopages;

import base.CommonAPI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.TestLogger;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WFHomePage extends CommonAPI {
    WebDriverWait wait = new WebDriverWait(driver, 5);

    @FindBy(css = "#destination")
    private WebElement accountSummaryDropDown;

    @FindBy(name = "q")
    private WebElement searchBar;

    @FindBy(xpath = "//ul[@class='c63controls' and @role='tablist']/li")
    private List<WebElement> carouselList;

    @FindBy(id = "tabNavCommercial")
    private WebElement commercialLink;

    @FindBy(xpath = "//img[contains(@src, 'wfic254_ph_g-186678901-cc002-ccd4975_489x234.jpg')]")
    private WebElement enjoyAprImage;

    @FindBy(xpath = "//img[@src='https://www01.wellsfargomedia.com/assets/images/homepage/wfi111_ph_hlp_default1_489x234.jpg']")
    private WebElement savingHabitImage;

    @FindBy(xpath = "//h3[contains(text(), 'Make saving')]")
    private WebElement savingHabitImageTitle;

    @FindBy(xpath = "//a[@data-tracking-id='21520-158536-3408-27']/img")
    private WebElement reachGoalsImage;

    @FindBy(xpath = "//*[contains(text(),'Want to reach')]")
    private WebElement reachGoalsImageTitle;

    @FindBy(css = "#zipCode")
    private WebElement zipCode;

    @FindBy(css = "#c28lastFocusable")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id='c28close']/img")
    private WebElement close;

    @FindBy(css = "#taskbar>div>ul>li:nth-child(1)>div>div>a>div>img")
    private WebElement checkingBonusLink;

    @FindBy(css = "#taskbar>div>ul>li:nth-child(1)>div>div>a")
    private WebElement homepagetab1;

    @FindBy(css = "#taskbar>div>ul>li:nth-child(2)>div>div>a")
    private WebElement homepagetab2;

    @FindBy(css = "#taskbar>div>ul>li:nth-child(3)>div>div>a")
    private WebElement homepagetab3;

    @FindBy(css = "#taskbar>div>ul>li:nth-child(4)>div>div.taskSecondstate")
    private WebElement homepagetab4;

    @FindBy(css = "#taskbar>div>ul>li:nth-child(5)>div>div.taskSecondstate")
    private WebElement homepagetab5;

    @FindBy(xpath = "//*[@id='check_rates_dropdown']")
    private WebElement todaysRatesDropdown;

    @FindBy(css = "#check_rates_dropdown>option:nth-child(1)")
    private WebElement mortgageLink;

    @FindBy(css = "#check_rates_dropdown>option:nth-child(2)")
    private WebElement homeEquityLink;

    @FindBy(css = "#check_rates_dropdown>option:nth-child(3)")
    private WebElement cdsLink;

    @FindBy(css = "#check_rates_dropdown>option:nth-child(4)")
    private WebElement creditCardLink;

    @FindBy(css = "#check_rates_dropdown>option:nth-child(5)")
    private WebElement autoLoansLink;

    @FindBy(css = "#check_rates_dropdown>option:nth-child(6)")
    private WebElement studentLoansLink;

    @FindBy(css = "#check_rates_dropdown>option:nth-child(7)")
    private WebElement personalLoansOption;

    @FindBy(css = "#check_rates_dropdown>option:nth-child(8)")
    private WebElement allRatesLink;

    @FindBy(id = "NID1_14_2_1_1_3")
    private WebElement todaysRatesSubmit;

    @FindBy(id = "tabNavPersonal")
    private WebElement personalLink;

    @FindBy(id = "tabNavSmallBusiness")
    private WebElement smallBusinessLink;

    @FindBy(xpath = "//a[contains(text(), 'Financial Education')]")
    private WebElement financialEducationLink;

    @FindBy(xpath = "//a[contains(text(), 'Checking Accounts')]" )
    private WebElement checkingAccountsLink;

    @FindBy(xpath = "//a[contains(text(), 'Savings Accounts and CDs')]" )
    private WebElement savingAccountsCDLink;

    @FindBy(xpath = "//a[contains(text(), 'Debit and Prepaid Cards')]" )
    private WebElement debitCardLink;

    @FindBy(xpath = "//*[@id='banking']/div[1]/div[1]/ul/li[4]/a" )
    private WebElement creditCardsLink;

    @FindBy(xpath = "//a[contains(text(), 'Foreign Exchange')]" )
    private WebElement foreignLink;

    @FindBy(xpath = "//a[contains(text(), 'Global Remittance Services')]" )
    private WebElement globalRemittanceLink;

    @FindBy(xpath = "//a[contains(text(), 'Online Banking')]" )
    private WebElement onlineBankingLink;

    @FindBy(xpath = "//a[contains(text(), 'Transfer and Pay')]" )
    private WebElement transferPayLink;

    @FindBy(xpath = "//a[contains(text(), 'Control Tower')]" )
    private WebElement controlTowerLink;
    /************************ Methods *********************************************/

    public void searchBar(String text) {
        searchBar.sendKeys(text, Keys.ENTER);
    }

    public List<WebElement> dropDownOptions() {
        Select select = new Select(accountSummaryDropDown);
        return select.getOptions();
    }

    public void commericialLink() {
        commercialLink.click();
    }

    public void carouselTabs(WebDriver wd) {
        String selector = "#nbaDefault";
        String textForTab = "#nbaDefaultPanels";
        for (int i = 1; i <= carouselList.size(); i++) {
            WebElement element = wd.findElement(By.cssSelector(selector + i));
            element.click();
            TestLogger.log(element.getText() + ": " + wd.findElement(By.cssSelector(textForTab + i + ">div>div>h3")).getText());
        }
    }

    public void tabBarLinks() {
        wait.until(ExpectedConditions.elementToBeClickable(checkingBonusLink));
        checkingBonusLink.click();
        driver.switchTo().activeElement().sendKeys("98029");
        continueButton.click();
    }

    public void closeWindow() {
        wait.until(ExpectedConditions.elementToBeClickable(checkingBonusLink));
        checkingBonusLink.click();
        wait.until(ExpectedConditions.elementToBeClickable(close));
        close.click();
    }

    public void popUpWindowSubmit() {
        String otherWindow = "";
        String parentHandle = driver.getWindowHandle();
        checkingBonusLink.click();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            otherWindow = iterator.next();
        }
        driver.switchTo().window(otherWindow);
        wait.until(ExpectedConditions.elementToBeClickable(zipCode));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        zipCode.sendKeys("98075");
        continueButton.click();
        driver.switchTo().window(parentHandle);
    }

    public void popUpWindowClose() {
        String otherWindow = "";
        String parentHandle = driver.getWindowHandle();
        checkingBonusLink.click();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            otherWindow = iterator.next();
        }
        driver.switchTo().window(otherWindow);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", close);
        driver.switchTo().window(parentHandle);
    }

    public void mortgageLink() {
        homepagetab5.click();
        wait.until(ExpectedConditions.invisibilityOf(todaysRatesDropdown));
        todaysRatesDropdown.click();
        mortgageLink.click();
        todaysRatesSubmit.click();
    }

    public void homeEquityLink() {
        homepagetab5.click();
        wait.until(ExpectedConditions.invisibilityOf(todaysRatesDropdown));
        todaysRatesDropdown.click();
        homeEquityLink.click();
        todaysRatesSubmit.click();
    }

    public void personalLoansLink() {
        homepagetab5.click();
        wait.until(ExpectedConditions.invisibilityOf(todaysRatesDropdown));
        todaysRatesDropdown.click();
        personalLoansOption.click();
        todaysRatesSubmit.click();
    }

    public void personalLink() {
        personalLink.click();
    }

    public void smallBusinessLink() {
        smallBusinessLink.click();
    }

    public String financialEducationLink() {
        Actions action = new Actions(driver);
        action.moveToElement(financialEducationLink).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", financialEducationLink);
        return driver.getTitle();
    }

    public String checkingAccountsLink() {
        Actions action = new Actions(driver);
        action.moveToElement(checkingAccountsLink).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", checkingAccountsLink);
        return driver.getTitle();
    }

    public String savingAccountsCDLink() {
        Actions action = new Actions(driver);
        action.moveToElement(savingAccountsCDLink).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", savingAccountsCDLink);
        return driver.getTitle();
    }

    public String debitCardsLink() {
        Actions action = new Actions(driver);
        action.moveToElement(debitCardLink).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", debitCardLink);
        return driver.getTitle();
    }

    public String creditCardsLink() {
        Actions action = new Actions(driver);
        action.moveToElement(creditCardsLink).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", creditCardsLink);
        return driver.getTitle();
    }

    public String foreignExchangeLink() {
        Actions action = new Actions(driver);
        action.moveToElement(foreignLink).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", foreignLink);
        return driver.getTitle();
    }

    public String globalremittanceLink() {
        Actions action = new Actions(driver);
        action.moveToElement(globalRemittanceLink).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", globalRemittanceLink);
        return driver.getTitle();
    }

    public String onlineBankingLink() {
        Actions action = new Actions(driver);
        action.moveToElement(onlineBankingLink).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", onlineBankingLink);
        return driver.getTitle();
    }

    public String transferPayLink() {
        Actions action = new Actions(driver);
        action.moveToElement(transferPayLink).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", transferPayLink);
        return driver.getTitle();
    }

    public String controlTowerLink() {
        Actions action = new Actions(driver);
        action.moveToElement(controlTowerLink).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", controlTowerLink);
        return driver.getTitle();
    }
}


