package com.tests;

import com.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTests extends TestBase {
    @Test
    public void testAddItemsToCart() {
        assertEquals(
                6,
                new LoginPage(context).loginAsStandardUser().clickAllAddToCartButtons().getShoppingCartItemsAmount()
        );
    }
}
