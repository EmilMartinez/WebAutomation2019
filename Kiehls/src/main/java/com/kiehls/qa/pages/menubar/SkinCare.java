package com.kiehls.qa.pages.menubar;

import base.CommonAPI;
import com.kiehls.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import databases.ExcelData;

public class SkinCare extends CommonAPI {

    @FindBy(xpath= "//a[contains(@class,'level_1_list_item_link category_link skincare class.navigation.list.link')]")
    WebElement skinCareLink;

    @FindBy(xpath="//*[@id='navigation_skippy']/div/ul/li[2]/div/div")
    WebElement dropDownField;

    @FindBy(xpath = "//li[(@class = 'level_1_list_item menu_list_item_2 cat_skincare   class.navigation.item')]//li//a")
    List<WebElement> listOfLinksSkinCare;

    private ExcelData excelData = new ExcelData();

    public SkinCare() {
        PageFactory.initElements(CommonAPI.driver, this);
    }

    public List<WebElement> getlistOfLinksSkinCare(){
        return listOfLinksSkinCare;
    }
    public void setDropDownSkinCare(String value) {
        for (int i = 0; i < listOfLinksSkinCare.size(); i++) {
            if (listOfLinksSkinCare.get(i).getText().equalsIgnoreCase(value)) {
                listOfLinksSkinCare.get(i).click();
                break;
            }
        }

    }

    public void clickOnElem(WebElement we){
        we.click();
    }

    public boolean hoverOverSkinCare() {
        Actions builder = new Actions(CommonAPI.driver);
        builder.moveToElement(skinCareLink).perform();
        return true;
    }

    public void clickSkinCare() {
        skinCareLink.click();
    }

    public void hoverOverDropDownLink(WebElement we) {
        hoverOverSkinCare();
        Actions builder = new Actions(CommonAPI.driver);
        builder.moveToElement(we).perform();
    }

    public boolean verifyDropDownVisibility(){
       return dropDownField.isDisplayed();
    }

    public String [] getListTitleFromExcelFile() throws IOException {
        String [] arr = excelData.fileReader2(TestUtil.getKiehlsExcelDataPath(), 2);
        return arr;
    }

}

