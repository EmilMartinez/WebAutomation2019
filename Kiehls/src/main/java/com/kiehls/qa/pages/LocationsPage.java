package com.kiehls.qa.pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocationsPage extends CommonAPI {

    @FindBy(xpath = "//ul[@class='utility_navigation_list']//a[@title='Store Locator'][contains(text(),'Store Locator')]")
    WebElement getStoreLocatorLink;

    @FindBy(css = ".main-title")
    WebElement findStroeNearYouText;

    @FindBy(css = ".main-subheading")
    WebElement mainSubheadingText;

    @FindBy(css = ".main-subheadingLink")
    WebElement storePickUpLink;

    @FindBy(css = ".search-input")
    WebElement searchInputBox;

    @FindBy(css = ".search-button-text")
    WebElement searchBttnText;

    @FindBy(css = ".search-button")
    WebElement searchBttn;

    @FindBy(css = ".filter-text")
    WebElement filterText;

    @FindBy(id = "dropdown-select")
    WebElement dropDownBttn;

    @FindBy(xpath = "//a[@class='Link Link--secondary']")
    WebElement allLocationsLink;

    @FindBy(css = "customer-service-link")
    WebElement customerServiceLink;

    @FindBy(css = ".desktop-phone")
    WebElement deskPhoneNum;

    public LocationsPage(){ PageFactory.initElements(CommonAPI.driver, this); }

    public LocationsPage validateStoreLocatorLink(){
        getStoreLocatorLink.click();
        return new LocationsPage();
    }

    public String verifyPageTitle(){
        validateStoreLocatorLink();
        return driver.getTitle();
    }

    public String verifyURL(){
        getStoreLocatorLink.click();
        return driver.getCurrentUrl();

    }

    public String verifyFindStoreText(){
        getStoreLocatorLink.click();
        return findStroeNearYouText.getText();
    }

    public String verifyMainSubHeading(){
        getStoreLocatorLink.click();
        return mainSubheadingText.getText();
    }

    public void verifyStorePickUpLink(){
        validateStoreLocatorLink();
        storePickUpLink.click();
    }

    public void verifySearchInputBox(String value){
        validateStoreLocatorLink();
        searchInputBox.sendKeys(value);
        verifySearchBttn();
    }

    public boolean verifySearchButtnText(){
        validateStoreLocatorLink();
        return searchBttnText.isDisplayed();}

    public void verifySearchBttn(){
        validateStoreLocatorLink();
        searchBttn.click();}

    public String verifyPhoneNum(){
        validateStoreLocatorLink();
        return deskPhoneNum.getText();}

    public void ValidateSelectStore(String value){
        validateStoreLocatorLink();
        dropDownBttn.click();
        CommonAPI.selectOptionByVisibleText(dropDownBttn, value);
    }

    public CustomerServicePage validateCustomerServiceLink(){
        validateStoreLocatorLink();
        customerServiceLink.click();
        return new CustomerServicePage();

    }
    public String verifyFilterText(){
        validateStoreLocatorLink();
      return filterText.getText();

    }


    public void verifyAllLocationsLink(){
        validateStoreLocatorLink();
        allLocationsLink.click();

    }


}
