package com.kiehls.qa.tests.shopping;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPageTest extends CommonAPI {

    @FindBy(css = ".mini_cart_label ")
    WebElement miniCardLabel;

    public boolean validateminiCarLabel(){return miniCardLabel.isDisplayed();}

}
