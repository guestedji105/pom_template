package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JacketPage extends MainPage {
    public JacketPage(TestContext context) {
        super(context);
    }

    @FindBy(xpath = "//*[text()=\"49.99\"]")
    public WebElement priceJacket;

    @FindBy(css = "#add-to-cart-sauce-labs-fleece-jacket")
    public WebElement addToCartButton;

    public void addToCart() {
        addToCartButton.click();
    }
}
