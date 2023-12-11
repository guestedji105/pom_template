package com.tests;

import com.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Login tests")
@Owner("Andrei Zola")
public class LoginTests extends TestBase {

    @Test
    @Story("Positive login test")
    @Description("Logging as a valid user and checking footer text")
    public void successLoginTest() {
        assertTrue(new LoginPage(context).loginAsStandardUser().getFooterText().contains("Sauce Labs"));
        logs.append("I logged as a standard user (successfully)");
    }

    @Test
    @Story("Negative login test - empty credentials")
    @Description("Logging with empty credentials and checking validation message")
    public void emptyLoginTest() {
        assertEquals(
                "Epic sadface: Username is required",
                new LoginPage(context).incorrectLoginAs("","")
        );
        logs.append("I had empty username or password");
    }

    @Test
    @Story("Negative login test - blocked user")
    @Description("Logging as a blocked user and checking error message")
    @Disabled("Disabled because I must repair it")
    public void blockedUserLoginTest() {
        assertEquals(
                "Epic sadface: Sorry, this user has been locked out.",
                new LoginPage(context).incorrectLoginAs("locked_out_user","secret_sauce")
        );
        logs.append("I can't logging, because this user is blocked");
    }
}
