package com.tests;

import com.pages.JacketPage;
import com.pages.LoginPage;
import com.pages.MainPage;
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
                        .getShoppingCartItemsAmount()
        );
    }

    @Test
    public void testGoToPageJacket() {
        assertEquals(
                "$49.99",
                new LoginPage(context).
                        loginAsStandardUser().
                        goToPageJacket().
                        priceJacketText()
        );
    }

    @Test
    public void shoppingCartQuantity() {
        assertEquals(
                "1",
                new LoginPage(context).loginAsStandardUser().addToCartByIndex(0).numberOfItemsInTheCart()

        );
    }
}