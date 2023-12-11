package com.tests;

import com.pages.LoginPage;
import com.pages.ShoppingCartPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Web interface")
@Owner("Andrei Zola")
public class HWTest extends TestBase {

    @Test
    @Description("Проверка соответствия цены товара Sauce Labs Fleece Jacket")
    @Story("PriceOfItem")
    public void hwTest() {
        assertEquals("$49.99", new LoginPage(context).loginAsStandardUser().openJacket().priceJacket.getText());
        logs.append("Проверена цена жакета (успешно)");
    }

    @Test
    @Description("Проверка соответствия количества товаров в корзине после их добавления")
    @Story("AddToCartButton")
    public void hwTest2() {
        new LoginPage(context).loginAsStandardUser().openJacket().addToCart();
        assertEquals(1, new ShoppingCartPage(context).getShoppingCartItemsAmount());
        logs.append("Проверена работоспособность кнопки добавления жакета в корзину (успешно)");
    }

    @Test
    @Description("Проверка работоспособности ссылки выхода из системы в меню")
    @Story("LogoutLink")
    public void hwTest3() {
        new LoginPage(context).loginAsStandardUser().goToLoginPage();
        assertEquals("https://www.saucedemo.com/", context.driver.getCurrentUrl());
        logs.append("Проверена ссылка выхода из системы в меню (успешно)");
    }

    @Test
    @Description("Проверка работоспособности ссылки перехода на главную страницу в меню")
    @Story("AllItemsLink")
    public void hwTest4() {
        new LoginPage(context).loginAsStandardUser().goToMainPage();
        assertEquals("https://www.saucedemo.com/inventory.html", context.driver.getCurrentUrl());
        logs.append("Проверена ссылка перехода на главную страницу в меню (успешно)");
    }
}
