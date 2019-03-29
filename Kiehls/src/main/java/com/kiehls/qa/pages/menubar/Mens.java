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

public class Mens {
    @FindBy(xpath="//a[contains(@class,'level_1_list_item_link category_link mens class.navigation.list.link')]")
    WebElement mensLink;

    @FindBy(xpath = "//li[(@class = 'level_1_list_item menu_list_item_4 cat_mens   class.navigation.item')]//li//a")
    List<WebElement> listOfLinksMens;

    private ExcelData excelData = new ExcelData();

    public Mens(){ PageFactory.initElements(CommonAPI.driver, this);}

    public Mens verifyMensLink(){
        mensLink.click();
        return new Mens();

    }
    public void hoverOverMensLink() throws InterruptedException {
        Actions builder = new Actions(CommonAPI.driver);
        builder.moveToElement(mensLink).perform();
        CommonAPI.sleepFor(1000);
    }

    public void hoverOverDropDownList(WebElement we) throws InterruptedException {
        hoverOverMensLink();
        Actions builder = new Actions(CommonAPI.driver);
        builder.moveToElement(we).perform();
    }

    public List<WebElement> getListOfMensLink(){
        return listOfLinksMens;
    }

    public void clickDropDownElem(WebElement we) throws InterruptedException {
        hoverOverMensLink();
        for(WebElement w : listOfLinksMens){
            w.click();
            CommonAPI.driver.navigate().back();
            CommonAPI.waitForPageLoad();
        }
    }

    public void setDropDownSkinCare(String value) throws InterruptedException {
        hoverOverMensLink();
        for (int i = 0; i < listOfLinksMens.size(); i++) {
            if (listOfLinksMens.get(i).getText().equalsIgnoreCase(value)) {
                listOfLinksMens.get(i).click();
                break;
            }
        }
    }

        public String[] getListOfTitleFromExcelFile() throws IOException {

        String[] arr = excelData.fileReader2(TestUtil.getKiehlsExcelDataPath(), 3);
        return arr;
    }

}
