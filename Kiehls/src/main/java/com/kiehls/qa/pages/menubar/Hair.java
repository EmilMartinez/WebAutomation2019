package com.kiehls.qa.pages.menubar;

import base.CommonAPI;
import com.kiehls.qa.util.TestUtil;
import databases.ExcelData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class Hair {
    @FindBy(xpath="//a[@class='level_1_list_item_link category_link hair class.navigation.list.link']")
    WebElement hairLink;

    @FindBy(xpath = "//li[(@class = 'level_1_list_item menu_list_item_5 cat_hair   class.navigation.item')]//li//a")
    List<WebElement> listOfLinksHair;

    private ExcelData excelData = new ExcelData();

    public Hair(){
        PageFactory.initElements(CommonAPI.driver, this);
    }

    public Hair verifyHariLink(){
        hairLink.click();
        return new Hair();
    }

    public void hoverOverHairLink() throws InterruptedException {
        Actions builder = new Actions(CommonAPI.driver);
        builder.moveToElement(hairLink).perform();
        CommonAPI.sleepFor(1000);
    }

    public void hoverOverDropDownList(WebElement we) throws InterruptedException {
        hoverOverHairLink();
        Actions builder = new Actions(CommonAPI.driver);
        builder.moveToElement(we).perform();
    }

    public List<WebElement> getListOfLinksHair(){
        return listOfLinksHair;
    }

    public void clickDropDownElem() throws InterruptedException {
        hoverOverHairLink();
        for(WebElement we: listOfLinksHair){
            we.click();
            CommonAPI.driver.navigate().back();
            CommonAPI.waitForPageLoad();
        }
    }

    public void setDropDownLink(String value) throws InterruptedException {
        hoverOverHairLink();
        for(int i=0; i<listOfLinksHair.size(); i++){
            if(listOfLinksHair.get(i).getText().equalsIgnoreCase(value)){
                listOfLinksHair.get(i).click();
                break;
            }
        }
    }

    public String[] getListOfTitleFromExcelFile() throws IOException {
        String [] arr = excelData.fileReader2(TestUtil.getKiehlsExcelDataPath(), 4);
        return arr;
    }

}
