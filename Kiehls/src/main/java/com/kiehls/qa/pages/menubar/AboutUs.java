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

public class AboutUs {

    @FindBy(xpath="//a[@class='level_1_list_item_link category_link about_us class.navigation.list.link")
    WebElement aboutUsLink;

    @FindBy(xpath="//li[(@class = 'level_1_list_item menu_list_item_7 cat_about_us   class.navigation.item')]//li//a")
    List<WebElement> listOfLinksAboutUS;

    private ExcelData excelData = new ExcelData();

    public AboutUs(){
        PageFactory.initElements(CommonAPI.driver, this);

    }

    public AboutUs verifyAboutUsLink(){
        aboutUsLink.click();
        return new AboutUs();
    }

    public void hoverOverAboutUsLink() throws InterruptedException {
        Actions builder = new Actions(CommonAPI.driver);
        builder.moveToElement(aboutUsLink).perform();
        CommonAPI.sleepFor(1000);
    }

    public void hoverOverDropDownList(WebElement we) throws InterruptedException {
        hoverOverAboutUsLink();
        Actions builder = new Actions(CommonAPI.driver);
        builder.moveToElement(we).perform();
    }

    public List<WebElement> getListOfLinksAboutUS(){
        return listOfLinksAboutUS;
    }

    public void clickDropDownElem() throws InterruptedException {
        hoverOverAboutUsLink();
        for(WebElement we: listOfLinksAboutUS){
            we.click();
            CommonAPI.driver.navigate().back();
            CommonAPI.waitForPageLoad();
        }
    }

    public void setDropDownLink(String value) throws InterruptedException {
        hoverOverAboutUsLink();
        for(int i=0; i<listOfLinksAboutUS.size(); i++){
            if(listOfLinksAboutUS.get(i).getText().equalsIgnoreCase(value)){
                listOfLinksAboutUS.get(i).click();
                break;
            }
        }
    }

    public String[] getListOfTitleFromExcelFile() throws IOException {
        String [] arr = excelData.fileReader2(TestUtil.getKiehlsExcelDataPath(), 5);
        return arr;
    }

}
