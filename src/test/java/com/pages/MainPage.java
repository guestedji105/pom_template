package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends InternalPage {
    @FindBy(css = ".btn_inventory")
    public List<WebElement> addToCartButtons;

    @FindBy(css = ".inventory_item_desc")
    public WebElement firstDescriptionContainer;

    public MainPage(TestContext context) {
        super(context);
    }

    public MainPage clickAllAddToCartButtons() {
        addToCartButtons.forEach(WebElement::click);
        return this;
    }

    public String getFirstDescription() {
        return firstDescriptionContainer.getText();
    }
}
