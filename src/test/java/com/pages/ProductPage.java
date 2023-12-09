package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public InternalPageComponentCart internalPageComponentCart;
    public InternalPageComponentBurgerMenu internalPageComponentBurgerMenu;

    ProductPage(TestContext context) {
        super(context);
        internalPageComponentCart = new InternalPageComponentCart(context);
        internalPageComponentBurgerMenu = new InternalPageComponentBurgerMenu(context);
    }

    @FindBy(xpath = "//div[@id='inventory_item_container']//div[@class='inventory_details_price']")
    public WebElement productPrice;

    @FindBy(xpath = "//*[@id='inventory_item_container']//button")
    public WebElement buttonAddToCart;


    public String priceProductText() {
        return productPrice.getText();
    }

    public ProductPage addProductToCart() {
        if (!buttonAddToCart.getText().equals("Remove")) {
            buttonAddToCart.click();
        } else {
            System.out.println("Product has already been added to cart");
        }
        return new ProductPage(context);
    }
}


