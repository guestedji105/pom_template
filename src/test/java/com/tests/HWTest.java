package com.tests;

import com.pages.LoginPage;
import com.pages.ShoppingCartPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HWTest extends TestBase {

    @Test
//    @Description("Проверка соответствия цены товара Sauce Labs Fleece Jacket")
//    @Owner("Andrei Zola")
//    @Epic("Web interface")
//    @Story("PriceOfItem")
    public void hwTest() {
        assertEquals("$49.99", new LoginPage(context).loginAsStandardUser().openJacket().priceJacket.getText());
    }

    @Test
//    @Description("Проверка соответствия количества товаров в корзине после их добавления")
//    @Owner("Andrei Zola")
//    @Epic("Web interface")
//    @Story("AddToCartButton")
    public void hwTest2() {
        new LoginPage(context).loginAsStandardUser().openJacket().addToCart();
        assertEquals(1, new ShoppingCartPage(context).getShoppingCartItemsAmount());
    }

    @Test
//    @Description("Проверка работоспособности ссылки выхода из системы в меню")
//    @Owner("Andrei Zola")
//    @Epic("Web interface")
//    @Story("LogoutLink")
    public void hwTest3() {
        new LoginPage(context).loginAsStandardUser().goToLoginPage();
        assertEquals("https://www.saucedemo.com/", context.driver.getCurrentUrl());
    }

    @Test
//    @Description("Проверка работоспособности ссылки перехода на главную страницу в меню")
//    @Owner("Andrei Zola")
//    @Epic("Web interface")
//    @Story("AllItemsLink")
    public void hwTest4() {
        new LoginPage(context).loginAsStandardUser().goToMainPage();
        assertEquals("https://www.saucedemo.com/inventory.html", context.driver.getCurrentUrl());
    }
}
