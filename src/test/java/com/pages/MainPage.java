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

    public MainPage addToCartByPartialName(String namePart) {
        addToCartButtons.forEach( button -> {
            if(button.getAttribute("name").contains(namePart))
                button.click();
        } );
        return this;
    }

    public String getAddToCartButtonTextByPartialName(String namePart) {
        return addToCartButtons
                .stream()
                .filter(button -> button.getAttribute("name").contains(namePart))
                .findFirst()
                .map(WebElement::getText)
                .orElse(null);
    }
}
