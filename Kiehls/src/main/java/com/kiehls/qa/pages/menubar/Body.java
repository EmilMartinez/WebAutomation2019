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

public class Body {
    @FindBy(xpath = "//a[contains(@class,'level_1_list_item_link category_link body class.navigation.list.link')]")
    WebElement bodyLink;

    @FindBy(xpath = "//li[(@class = 'level_1_list_item menu_list_item_3 cat_body   class.navigation.item')]//li//a")
    List<WebElement> listOfLinksBody;

    private ExcelData excelData = new ExcelData();

    public Body() {
        PageFactory.initElements(CommonAPI.driver, this);
    }

    public Body verifyBodyLink() {
        bodyLink.click();
        return new Body();
    }

    public void hoverOverBody() throws InterruptedException {
        Actions builder = new Actions(CommonAPI.driver);
        builder.moveToElement(bodyLink).perform();
        CommonAPI.sleepFor(2000);

    }

    public void clickOnElem(WebElement we) throws InterruptedException {
        hoverOverBody();
        we.click();
    }

    public boolean hoverOverDropDownLink(WebElement we) throws InterruptedException {
        bodyLink.click();
        Actions builder = new Actions(CommonAPI.driver);
        builder.moveToElement(we).perform();
        return true;
    }


    public List<WebElement> getListOfLinksBody() {
        return listOfLinksBody;
    }

    public boolean setDropDownBody(String value) {
        for (int i = 0; i < listOfLinksBody.size(); i++) {
          if (listOfLinksBody.get(i).getText().equalsIgnoreCase(value)){
                listOfLinksBody.get(i).click();
                break;
            }
        }

        return true;
    }

    public String[] getListTiltleFromExcelFile() throws IOException {
        String [] arr = excelData.fileReader2(TestUtil.getKiehlsExcelDataPath(), 2);
        return arr;
    }

}
