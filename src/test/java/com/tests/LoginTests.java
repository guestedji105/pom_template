package com.tests;

import com.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends TestBase {
    @Test
    public void successLoginTest() {
        assertTrue(new LoginPage(context).loginAsStandardUser().getFooterText().contains("Sauce Labs"));
        //assertEquals("https://www.saucedemo.com/inventory.html", context.driver.getCurrentUrl());
    }

    @Test
    public void emptyLoginTest() {
        assertEquals(
                "Epic sadface: Username is required",
                new LoginPage(context).incorrectLoginAs("", "")
        );
    }

    @Test
    public void blockedUserLoginTest() {
        assertEquals(
                "Epic sadface: Sorry, this user has been locked out.",
                new LoginPage(context).incorrectLoginAs("locked_out_user", "secret_sauce")
        );
    }
}
