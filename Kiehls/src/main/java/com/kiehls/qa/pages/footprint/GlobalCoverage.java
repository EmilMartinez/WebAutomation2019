package com.kiehls.qa.pages.footprint;

import base.CommonAPI;
import com.kiehls.qa.ExtenReportListener.ExtentReporterNG;
import databases.ExcelData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GlobalCoverage {

    @FindBy(xpath = "//ul[@class=\"orig-list hidden\"]//li")
    List<WebElement> countryList;

    @FindBy(xpath="//*[@id=\"index-page\"]/body/div[2]/div[1]/div/div/div[2]/ul/li[5]/p/span[1]")
    WebElement usaLink;

    private ExcelData excelData = new ExcelData();

    public GlobalCoverage(){
        PageFactory.initElements(CommonAPI.driver, this);

    }

    public void hoverOverUSA() throws InterruptedException {
        Actions builder = new Actions(CommonAPI.driver);
        builder.moveToElement(usaLink).click();
        CommonAPI.sleepFor(1000);
    }

    public List<String> getlistOfCounty(){
        List<String> list = new ArrayList<>();
        for(int i=0; i<countryList.size(); i++){
            list.add(countryList.get(i).getText());
        }
        return list;

    }

}
