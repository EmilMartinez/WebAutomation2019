package com.kiehls.qa.pages.Homepage;

import base.CommonAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reporting.TestLogger;

public class ExternalLinks {

    @FindBy(xpath="//a[contains(text(),'Explore More')]")
    WebElement exploreMoreText;

    @FindBy(css=".b-footer_footerpromo")
    WebElement footerField;

    @FindBy(xpath = "//div[@id='mobile_tel']//li[@class='messenger']")
    WebElement messengerLink;

    @FindBy(xpath = "//li[@class ='facebook']//a")
    WebElement faceboookLink;

    @FindBy(xpath = "//a[contains(text(),'Twitter')]")
    WebElement twitterLink;

    @FindBy(xpath= "//a[contains(text(),'YouTube')]")
    WebElement youtubeLink;

    @FindBy(xpath = "//a[contains(text(),'Instagram')]")
    WebElement instagramLink;

    @FindBy(xpath="//a[contains(text(),'Pinterest')]")
    WebElement pintersLink;

    public ExternalLinks(){
        PageFactory.initElements(CommonAPI.driver, this);
    }

    public void verifyExploreMoreLink() throws Exception {
        scrollToExternalLinksField();
        exploreMoreText.click();
    }

    public boolean verifyFooterField(){ return footerField.isDisplayed(); }

    public void verifyMessengerLink() throws Exception {
        scrollToExternalLinksField();
        Actions actions = new Actions(CommonAPI.driver);
        actions.moveToElement(messengerLink).click().perform();
        Thread.sleep(1000);

    }

    public void verifyFacebookLink() throws Exception {
        scrollToExternalLinksField();
        Actions actions = new Actions(CommonAPI.driver);
        actions.moveToElement(faceboookLink).click().perform();
        Thread.sleep(1000);
    }

    public void verifyTwitterLink() throws Exception {
        scrollToExternalLinksField();
        twitterLink.click();
    }

    public void verifyYTLink() throws Exception {
        scrollToExternalLinksField();
        youtubeLink.click();
    }

    public void verifyInstagramLink() throws Exception {
        scrollToExternalLinksField();
        instagramLink.click();
    }

    public void  verifyPintersLink() throws Exception {
        scrollToExternalLinksField();
        pintersLink.click();

    }


    public void scrollToExternalLinksField() throws Exception {

        JavascriptExecutor js = (JavascriptExecutor) CommonAPI.driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void waitDom() {
        JavascriptExecutor js = (JavascriptExecutor) CommonAPI.driver;
        js.executeScript("window.onload = null;");
    }

}
