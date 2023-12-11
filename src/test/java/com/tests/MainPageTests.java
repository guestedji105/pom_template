package com.tests;

import com.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Main page tests")
@Owner("Andrei Zola")
public class MainPageTests extends TestBase {
    @Test
    @Description("Проверка работоспособности кнопок добавления товаров в корзину на основной странице")
    @Story("AddToCartButtons")
    public void testAddItemsToCart() {
        assertEquals(
                6,
                new LoginPage(context)
                        .loginAsStandardUser()
                        .clickAllAddToCartButtons()
                        .getShoppingCartItemsAmount()
        );
        logs.append("Проверена работоспособность кнопок добавления товаров в корзину (успешно)");
    }
}
