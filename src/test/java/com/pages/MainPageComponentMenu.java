package com.pages;

import com.context.TestContext;

public class MainPageComponentMenu extends BasePage{
    public InternalPage internalPage;
    public MainPageComponentMenu(TestContext context) {
        super(context);
        internalPage = new InternalPage(context);
    }
}
