package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends InternalPage {
    @FindBy(css = ".btn_inventory")
    public List<WebElement> addToCartButtons;

    @FindBy (xpath = "//a[contains(@id,'title_link')]//*[@class='inventory_item_name ']")
    public List<WebElement> productName;

    public MainPage(TestContext context) {
        super(context);
    }

    public MainPage clickAllAddToCartButtons() {
        addToCartButtons.forEach(WebElement::click);
        return this;
    }
    public ProductPage goToProductsPage(String nameProduct) {
        for (WebElement product : productName) {
            if (product.getText().equals(nameProduct)) {
                product.click();
                break;
            }
        }
        return new ProductPage(context);

    }

}
