package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JacketPage extends InternalPage{
    JacketPage(TestContext context){
        super(context);
    }

    @FindBy(xpath = "//div[@id='inventory_item_container']//div[@class='inventory_details_price']")
    public WebElement priceJacket;

    public String priceJacketText(){
        return priceJacket.getText();
    }


}


