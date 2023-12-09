package com.tests;

import com.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTests extends TestBase {

    @Test
    public void testAddItemsToCart() {
        assertEquals(
                6,
                new LoginPage(context)
                        .loginAsStandardUser()
                        .clickAllAddToCartButtons()
                        .internalPageComponentCart
                        .getShoppingCartItemsAmount()
        );
    }

    @Test
    public void testGoToPageJacket() {
        assertEquals(
                "$49.99",
                new LoginPage(context)
                        .loginAsStandardUser()
                        .goToProductPage("Sauce Labs Fleece Jacket")
                        .priceProductText()
        );
    }

    @Test
    public void shoppingCartQuantity() {
        assertEquals(
                1,
                new LoginPage(context)
                        .loginAsStandardUser()
                        .goToProductPage("Sauce Labs Fleece Jacket")
                        .addProductToCart()
                        .internalPageComponentCart
                        .getShoppingCartItemsAmount()

        );
    }

    @Test
    public void goFromProductPageToMainPage() {
        assertEquals(
                6,
                new LoginPage(context)
                        .loginAsStandardUser()
                        .goToProductPage("Sauce Labs Fleece Jacket")
                        .internalPageComponentBurgerMenu
                        .goToMainPage()
                        .numberProductsOnMainPage()
        );
    }

    @Test
    public void goToLoginPage() {
        assertEquals(
                "Username",
                new LoginPage(context)
                        .loginAsStandardUser()
                        .internalPageComponentBurgerMenu
                        .goToLoginPage()
                        .getUsernamePlaceholderText()
        );
    }
}