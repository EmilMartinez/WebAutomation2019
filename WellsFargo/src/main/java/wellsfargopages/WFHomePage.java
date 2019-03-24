package wellsfargopages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class WFHomePage {

    @FindBy(css = "#destination")
    private WebElement accountSummaryDropDown;

    @FindBy(name = "q")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id='mainContent']/div[2]/div[1]/li")
    private List<WebElement> homePageTabs;

    @FindBy(css = "#nbaDefaultPanels1 > div > div > h3")
    private WebElement textForTab1;

    @FindBy(css = "#nbaDefaultPanels2 > div > div > h3")
    private WebElement textForTab2;

    @FindBy(css = "#nbaDefaultPanels3 > div > div > h3")
    private WebElement textForTab3;

    @FindBy(css = "#nbaDefaultPanels4 > div > div > h3")
    private WebElement textForTab4;

    @FindBy(css = "#nbaDefaultPanels5 > div > div > h3")
    private WebElement textForTab5;

    @FindBy(css = "#nbaDefaultPanels6 > div > div > h3")
    private WebElement textForTab6;

    @FindBy(css = "#nbaDefaultPanels7 > div > div > h3")
    private WebElement textForTab7;

    @FindBy(id = "tabNavCommercial")
    private WebElement commercialLink;

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

    public List<String> homePageTabs(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePageTabs);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        List<String> tabText = new ArrayList<String>();
        for (int i = 0; i < homePageTabs.size(); i++) {
            homePageTabs.get(i).click();
            switch (i) {
                case 0:
                    tabText.add(textForTab1.getText());
                    break;
                case 1:
                    tabText.add(textForTab2.getText());
                    break;
                case 2:
                    tabText.add(textForTab3.getText());
                    break;
                case 3:
                    tabText.add(textForTab4.getText());
                    break;
                case 4:
                    tabText.add(textForTab5.getText());
                    break;
                case 5:
                    tabText.add(textForTab6.getText());
                    break;
                case 6:
                    tabText.add(textForTab7.getText());
                    break;
            }
        }
        return tabText;
    }
}
