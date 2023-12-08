package com.pages;

import com.context.TestContext;

public class MainPageComponentCart extends BasePage{
    public InternalPage internalPage;
    public MainPageComponentCart(TestContext context) {
        super(context);
        internalPage = new InternalPage(context);
    }
}
