package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends InternalPage {
    @FindBy(css = ".btn_inventory")
    public List<WebElement> addToCartButtons;

    @FindBy(id = "item_5_title_link")
    public WebElement productPageJacket;


    public MainPage(TestContext context) {
        super(context);
    }

    public MainPage clickAllAddToCartButtons() {
        addToCartButtons.forEach(WebElement::click);
        return this;
    }

    public JacketPage goToPageJacket() {
        productPageJacket.click();
        return new JacketPage(context);
    }

    public MainPage addToCartByIndex(int index) {
        addToCartButtons.get(index).click();
        return this;
    }


}
