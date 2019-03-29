package com.kiehls.qa.util;

import base.CommonAPI;
import databases.ExcelData;

import java.io.IOException;

public class TestUtil extends CommonAPI {

    public static void takeScreenshotAtEndOfTest() throws IOException {
    }

    public void swtichToFrame(){

        driver.switchTo().frame(". sr_iframe_hide");


    }

    public static String getKiehlsExcelDataPath(){

       String excelFilePath = "C:\\Users\\Mira\\Documents\\GitHub\\WebAutomation2019\\Kiehls\\src\\test\\resources\\TestData\\KiehlsMenuLinkList.xls";

               return excelFilePath;
    }

}
