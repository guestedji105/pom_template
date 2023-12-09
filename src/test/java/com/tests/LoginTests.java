package com.tests;

import com.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.javadoc.doclet.Reporter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Login tests")
public class LoginTests extends TestBase {
    @Test
    @Story("Positive login test")
    @Description("Loggin as valid user and checking footer text")
    public void successLoginTest() {
        assertTrue(new LoginPage(context)
                .loginAsStandardUser()
                .internalPageComponentCart
                .getFooterText()
                .contains("Sauce Labs"));
        //assertEquals("https://www.saucedemo.com/inventory.html", context.driver.getCurrentUrl());
    }

    @Test
    @Story("Negative login test - empty credentials")
    @Description("Loggin with empty credentials and checking validation message")
    public void emptyLoginTest() {
        assertEquals(
                "Epic sadface: Username is required",
                new LoginPage(context)
                        .incorrectLoginAs("", "")
        );
        logs.append("Something we want to add from test");
    }

    @Test
    @Story("Negative login test - blocked user")
    @Description("Loggin as blocked user and checking error message")
    @Disabled("Disabled because I wanted to")
    public void blockedUserLoginTest() {
        assertEquals(
                "Epic sadface",
                new LoginPage(context).incorrectLoginAs("locked_out_user","secret_sauce")
        );
    }
}
