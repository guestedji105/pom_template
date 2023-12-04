package com.pages;
import com.context.TestContext;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    TestContext context;

    public BasePage(TestContext context) {
        this.context = context;
        PageFactory.initElements(context.driver, this);
    }
}
