package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPageComponentCart extends BasePage {

    InternalPageComponentCart(TestContext context) {
        super(context);
    }

    //TestContext context;
    @FindBy(css = ".footer_copy")
    public WebElement footer;

    @FindBy(css = ".shopping_cart_link")
    public WebElement shoppingCartLink;


    public String getFooterText() {
        return footer.getText();
    }

    public ShoppingCartPage openCart() {
        shoppingCartLink.click();
        context.logs.append(" Go to the Shopping Cart page ");
        return new ShoppingCartPage();
    }

    public int getShoppingCartItemsAmount() {
        return !shoppingCartLink.getText().isEmpty() ? Integer.parseInt(shoppingCartLink.getText()) : 0;
    }
}

