package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    private InternalPageComponentCart internalPageComponentCart;
    private InternalPageComponentBurgerMenu internalPageComponentBurgerMenu;

    ProductPage(TestContext context) {
        super(context);
        setInternalPageComponentCart(new InternalPageComponentCart(context));
        setInternalPageComponentBurgerMenu(new InternalPageComponentBurgerMenu(context));
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
        context.logs.append("добавление товара");
               return new ProductPage(context);
    }

    public InternalPageComponentBurgerMenu getInternalPageComponentBurgerMenu() {
        return internalPageComponentBurgerMenu;
    }

    public void setInternalPageComponentBurgerMenu(InternalPageComponentBurgerMenu internalPageComponentBurgerMenu) {
        this.internalPageComponentBurgerMenu = internalPageComponentBurgerMenu;
    }

    public InternalPageComponentCart getInternalPageComponentCart() {
        return internalPageComponentCart;
    }

    public void setInternalPageComponentCart(InternalPageComponentCart internalPageComponentCart) {
        this.internalPageComponentCart = internalPageComponentCart;
    }
}


