package wellsfargopages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.TestLogger;

public class WFTodaysRatesPage extends CommonAPI {
    WebDriverWait wait = new WebDriverWait(driver, 3);

    //@FindBy(id = "zipCode")
    @FindBy(css = "#zipCode")
    private WebElement zipCode;

    @FindBy(id = "amount")
    private WebElement amount;

    @FindBy(id = "selTerm")
    private WebElement selectTerm;

    @FindBy(css = "#selTerm>option:nth-child(3)")
    private WebElement term3;

    @FindBy(id = "selRate")
    private WebElement selectRate;

    @FindBy(css = "#selRate>option:nth-child(3)")
    private WebElement rate3;

    @FindBy(xpath = "//*[@class='monthlypayment']")
    private WebElement montlyPayment;

    @FindBy(xpath = "//*[@class='apr']")
    private WebElement apr;

    public void calculateMonthlyPayment(String zip, String amt) {
        zipCode.sendKeys(zip);
        amount.sendKeys(amt);
        selectTerm.click();
        wait.until(ExpectedConditions.visibilityOf(term3));
        term3.click();
        selectRate.click();
        wait.until(ExpectedConditions.visibilityOf(rate3));
        rate3.click();
        wait.until(ExpectedConditions.visibilityOf(montlyPayment));
        wait.until(ExpectedConditions.visibilityOf(apr));
        TestLogger.log("Monthly payment for $"+amt+" loan: "+montlyPayment.getText()+" and APR: "+apr.getText());
    }
}
