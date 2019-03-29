package com.kiehls.qa.tests.menubar;
import base.CommonAPI;
import com.kiehls.qa.pages.menubar.Gifts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class GiftsTest extends CommonAPI {

    Gifts gifts;

    @BeforeMethod
    public void initialize(){
        gifts= PageFactory.initElements(this.driver, Gifts.class);

    }

    @Test
    public void titleTest(){
    String title = gifts.verifyTitle();
    Assert.assertEquals(title, "Skin Care, Hair Care & Body Gift Sets & Collections - Kiehl's");
    }

    @Test
    public void clickGiftsTest(){ gifts = gifts.clickGifts(); }

    @Test
    public void clickEachDropDowListTest(){
        for(WebElement w: gifts.getListOfLinks()) {
            gifts.hoverOverGifts();
            gifts.clickOnElem(w);
            driver.navigate().back();
            CommonAPI.waitForPageLoad();
        }
    }

    @Test
    public void hoverOverDropDownLinkTest(){
        gifts.hoverOverGifts();
        for(WebElement w : gifts.getListOfLinks()){
            gifts.hoverOverDropDownLink(w);
        }
    }

    @Test
    public void checkGiftsDropDownText() throws IOException {
        List<WebElement> list = gifts.getListOfLinks();
        String[] listOfActualTitles = gifts.getGiftsLinkTitleFromExcelFile();
        for(int i=0; i<list.size(); i++){
            gifts.hoverOverGifts();
        String  actualTitle = gifts.getListOfLinks().get(i).getText();
        String  expectedTitle = listOfActualTitles[i];

        Assert.assertEquals(expectedTitle, actualTitle);

        }


    }
}
