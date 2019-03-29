package wellsfargopages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.TestLogger;

public class WFTodaysRatesPage extends CommonAPI {
    WebDriverWait wait = new WebDriverWait(driver, 10);

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

    @FindBy(id = "loanPurpose")
    private WebElement loanPurpose;

    @FindBy(css = "#loanPurpose>option:nth-child(3)")
    private WebElement homeEquity;

    @FindBy(css = "#loanPurpose>option:nth-child(1)")
    private WebElement purchase;

    @FindBy(id = "homeValue")
    private WebElement homeValue;

    @FindBy(id = "downPayment")
    private WebElement downPayment;

    @FindBy(id = "mortgageBalance")
    private WebElement mortgageBalance;

    @FindBy(id = "p_loanAmount")
    private WebElement loanAmount;

    @FindBy(id = "creditScore")
    private WebElement creditScore;

    @FindBy(css = "#creditScore>option:nth-child(4)")
    private WebElement fairScore;

    @FindBy(id = "propertyState")
    private WebElement propertyState;

    @FindBy(css = "#propertyState>option:nth-child(36)")
    private WebElement propertyStateNY;

    @FindBy(id = "propertyCounty")
    private WebElement propertyCounty;

    @FindBy(css = "#propertyCounty>option:nth-child(42)")
    private WebElement propertyCountyQueens;

    @FindBy(name = "submitButton")
    private WebElement calculateButton;

    @FindBy(id = "#hdr4")
    private WebElement paymentLabel;

    @FindBy(id = "APR")
    private WebElement aprLabel;

    @FindBy(css = "#contentBody>table>tbody >tr>td:nth-child(3)")
    private WebElement aprForHomePurchase;

    @FindBy(css = "#contentBody>table>tbody>tr>td:nth-child(4)")
    private WebElement paymentForHomePurchase;

    public void calculateMonthlyPaymentForPersonalLoans(String zip, String amt) {
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

    public String calculateLoanAmount(String value, String downpay) {
        loanPurpose.click();
        purchase.click();
        homeValue.sendKeys(value);
        downPayment.sendKeys(downpay);
        creditScore.click();
        return loanAmount.getText();
    }

    public void calculatePaymentsForHomePurchase() throws Exception {
        loanPurpose.click();
        purchase.click();
        homeValue.sendKeys("500000");
        downPayment.sendKeys("10000");
        creditScore.click();
        fairScore.click();
        propertyState.click();
        propertyStateNY.click();
        propertyCounty.click();
        propertyCountyQueens.click();
        calculateButton.click();
        wait.until(ExpectedConditions.visibilityOf(aprForHomePurchase));
        wait.until(ExpectedConditions.visibilityOf(paymentForHomePurchase));
        String path = CommonAPI.getBase64Screenshot(driver, "Payments");
        TestLogger.screenShot(path, "Payments for Home Purchase");
        TestLogger.log("Monthly Payment: "+paymentForHomePurchase.getText()+" & APR: "+aprForHomePurchase.getText());
    }
}
