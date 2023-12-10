package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    private InternalPageComponentBurgerMenu internalPageComponentBurgerMenu;
    private InternalPageComponentCart internalPageComponentCart;

    @FindBy(css = ".btn_inventory")
    public List<WebElement> addToCartButtons;

    @FindBy(xpath = "//a[contains(@id,'title_link')]//*[@class='inventory_item_name ']")
    public List<WebElement> productNamePages;

    public MainPage(TestContext context) {
        super(context);
        setInternalPageComponentBurgerMenu(new InternalPageComponentBurgerMenu(context));
        setInternalPageComponentCart(new InternalPageComponentCart(context));
    }

    public MainPage clickAllAddToCartButtons() {
        addToCartButtons.forEach(WebElement::click);
        context.logs.append("\nThe method adds all items from the page to the cart");
        return this;
    }

    public ProductPage goToProductPage(String nameProduct) {
        for (WebElement product : productNamePages) {
            if (product.getText().equals(nameProduct)) {
                product.click();
                break;
            }
        }
        context.logs.append("\nThe method goes to the product page - ");
        context.logs.append(nameProduct);
        return new ProductPage(context);
    }

    public int numberProductsOnMainPage() {
        return addToCartButtons.size();
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
