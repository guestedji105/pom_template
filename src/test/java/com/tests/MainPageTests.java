package com.tests;

import com.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("MainPages tests")
public class MainPageTests extends TestBase {

    @Test
    @Story("Positive test")
    @Description("Adding all products on the page to cart")
    public void testAddItemsToCart() {
        assertEquals(
                6,
                new LoginPage(context)
                        .loginAsStandardUser()
                        .clickAllAddToCartButtons()
                        .getInternalPageComponentCart()
                        .getShoppingCartItemsAmount()
        );
        context.logs.append("The test was a success");
    }

    @Test
    @Story("Positive test")
    @Description("Product inspection")
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
    @Story("Positive test")
    public void shoppingCartQuantity() {
        assertEquals(
                1,
                new LoginPage(context)
                        .loginAsStandardUser()
                        .goToProductPage("Sauce Labs Fleece Jacket")
                        .addProductToCart()
                        .getInternalPageComponentCart()
                        .getShoppingCartItemsAmount()
        );
        System.out.println(context.logs);
    }

    @Test
    @Story("Positive test")
    public void goFromProductPageToMainPage() {
        assertEquals(
                6,
                new LoginPage(context)
                        .loginAsStandardUser()
                        .goToProductPage("Sauce Labs Fleece Jacket")
                        .getInternalPageComponentBurgerMenu()
                        .goToMainPage()
                        .numberProductsOnMainPage()
        );
    }

    @Test
    @Story("Positive test")
    public void goToLoginPage() {
        assertEquals(
                "Username",
                new LoginPage(context)
                        .loginAsStandardUser()
                        .getInternalPageComponentBurgerMenu()
                        .goToLoginPage()
                        .getUsernamePlaceholderText()
        );
    }
}