package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InternalPageComponentBurgerMenu extends BasePage {

    InternalPageComponentBurgerMenu(TestContext context) {
        super(context);
    }

    //TestContext context;
    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenu;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement burgerMenuAllItems;

    @FindBy(id = "logout_sidebar_link")
    public WebElement burgerMenuLogout;

    public MainPage goToMainPage() {
        burgerMenu.click();
        context.wait.until(ExpectedConditions.visibilityOf(burgerMenuAllItems));
        burgerMenuAllItems.click();
        context.logs.append(" Go to the main page ");
        return new MainPage(context);
    }

    public LoginPage goToLoginPage() {
        burgerMenu.click();
        context.wait.until(ExpectedConditions.visibilityOf(burgerMenuLogout));
        burgerMenuLogout.click();
        context.logs.append(" Go to the login page ");
        return new LoginPage(context);
    }
}


