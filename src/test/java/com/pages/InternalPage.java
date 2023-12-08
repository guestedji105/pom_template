package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InternalPage extends BasePage {

    @FindBy(css = ".footer_copy")
    public WebElement footer;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement menu;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItemLink;

    @FindBy(css = ".shopping_cart_link")
    public WebElement shoppingCartLink;

    InternalPage(TestContext context) {
        super(context);
    }

    public String getFooterText() {
        return footer.getText();
    }

    public ShoppingCartPage openCart() {
        shoppingCartLink.click();
        return new ShoppingCartPage(context);
    }

    public MainPage goToMainPage() {
        menu.click();
        context.wait.until(ExpectedConditions.elementToBeClickable(allItemLink));
        allItemLink.click();
        return new MainPage(context);
    }

    public LoginPage goToLoginPage() {
        menu.click();
        context.wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
        return new LoginPage(context);
    }

    public int getShoppingCartItemsAmount() {
        return !shoppingCartLink.getText().isEmpty() ? Integer.parseInt(shoppingCartLink.getText()) : 0;
    }
}
