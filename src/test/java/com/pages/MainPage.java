package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends InternalPage {

    @FindBy(css = ".btn_inventory")
    public List<WebElement> addToCartButtons;

    @FindBy(css = "#item_5_title_link > div")
    public WebElement fleeceJacket;

    public MainPage(TestContext context) {
        super(context);
    }

    public MainPage clickAllAddToCartButtons() {
        addToCartButtons.forEach(WebElement::click);
        return this;
    }

    public JacketPage openJacket() {
        fleeceJacket.click();
        return new JacketPage(context);
    }
}
