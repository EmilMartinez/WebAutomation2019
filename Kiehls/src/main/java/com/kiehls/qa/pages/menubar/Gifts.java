package com.kiehls.qa.pages.menubar;

import base.CommonAPI;
import com.kiehls.qa.util.TestUtil;
import databases.ExcelData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gifts extends CommonAPI {
    private ExcelData excelData = new ExcelData();
    private String excelPath = "C:\\Users\\Mira\\Documents\\GitHub\\WebAutomation2019\\Kiehls\\src\\test\\" +
            "resources\\TestData\\KiehlsMenuLinkList.xls";


    @FindBy(xpath = "//a[@class='level_1_list_item_link category_link gifts_and_more class.navigation.list.link']")
    WebElement giftsLink;

    @FindBy(xpath = "//a[contains(text(),'Gifts for All')]")
    WebElement giftsForAllLink;

    @FindBy(xpath = "//a[contains(text(),'Gifts for Her')]")
    WebElement giftsForHerLink;

    @FindBy(xpath = "//a[contains(text(),'Gifts for Him')]")
    WebElement gistsForHimLink;

    @FindBy(xpath = "//a[contains(text(),'E-Gift Card')]")
    WebElement eGiftCardLink;

    @FindBy(xpath = "//a[contains(text(),'Gifts for Pets')]")
    WebElement giftsForPetsLink;



    public Gifts() {
        PageFactory.initElements(CommonAPI.driver, this);
    }

    public String verifyTitle() {
        giftsLink.click();
        return driver.getTitle();
    }

    public List<WebElement> getListOfLinks() {
        List<WebElement> list = new ArrayList<>();
        list.add(giftsForAllLink);
        list.add(giftsForHerLink);
        list.add(gistsForHimLink);
        list.add(eGiftCardLink);
        list.add(giftsForPetsLink);

        return list;
    }

    public void hoverOverGifts() {
        Actions builder = new Actions(CommonAPI.driver);
        builder.moveToElement(giftsLink).perform();
    }

    public void hoverOverDropDownLink(WebElement webElement) {
        Actions builder = new Actions(CommonAPI.driver);
        builder.moveToElement(webElement).perform();
    }

    public Gifts clickGifts() {
        giftsLink.click();
        return new Gifts();
    }

    public void clickOnElem(WebElement w) {
        w.click();
    }

    public String[] getGiftsLinkTitleFromExcelFile() throws IOException {
        String[] list = excelData.fileReader2(TestUtil.getKiehlsExcelDataPath(), 0);
        return list;

    }

}

