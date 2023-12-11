package com.tests;

import com.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
    public void testFirstDescriptionWithAssertJ() {
        assertThat(
                new LoginPage(context)
                        .loginAsStandardUser()
                        .getFirstDescription()
        )
                .startsWith("carry.allTheThings()")
                .endsWith("laptop and tablet protection.");
    }
    @Test
    public void testFirstDescriptionSequelWithAssertJ() {
        assertThat(
                new LoginPage(context)
                        .loginAsStandardUser()
                        .getFirstDescription()
        )
                .doesNotContain("Water-resistant");
    }
}
