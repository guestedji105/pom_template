package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    public InternalPageComponentBurgerMenu internalPageComponentBurgerMenu;
    public InternalPageComponentCart internalPageComponentCart;

    @FindBy(css = ".btn_inventory")
    public List<WebElement> addToCartButtons;

    @FindBy(xpath = "//a[contains(@id,'title_link')]//*[@class='inventory_item_name ']")
    public List<WebElement> productNamePages;

    public MainPage(TestContext context) {
        super(context);
        internalPageComponentBurgerMenu = new InternalPageComponentBurgerMenu(context);
        internalPageComponentCart = new InternalPageComponentCart(context);
    }

    public MainPage clickAllAddToCartButtons() {
        addToCartButtons.forEach(WebElement::click);
        return this;
    }

    public ProductPage goToProductPage(String nameProduct) {
        for (WebElement product : productNamePages) {
            if (product.getText().equals(nameProduct)) {
                product.click();
                break;
            }
        }
        return new ProductPage(context);
    }

    public int numberProductsOnMainPage() {
        return addToCartButtons.size();
    }
}
