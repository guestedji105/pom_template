package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPageComponentCart extends BasePage {

    //TestContext context;
    @FindBy(css = ".footer_copy")
    public WebElement footer;

    @FindBy(css = ".shopping_cart_link")
    public WebElement shoppingCartLink;


    InternalPageComponentCart(TestContext context) {
        super(context);
    }

    public String getFooterText() {
        return footer.getText();
    }

    public ShoppingCartPage openCart() {
        shoppingCartLink.click();
        return new ShoppingCartPage();
    }

    public int getShoppingCartItemsAmount() {
        return !shoppingCartLink.getText().isEmpty() ? Integer.parseInt(shoppingCartLink.getText()) : 0;
    }
}

