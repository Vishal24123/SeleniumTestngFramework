package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(id = "checkout")
    WebElement checkOutBtn;

    @FindBy(xpath = "//div[@class='cart_item_label']")
    List<WebElement> listOfQuantity;

    public boolean isCartPageDisplayed() {
        //wait.until(ExpectedContions.visibiltyOf(checkOutBtn);
        return checkOutBtn.isDisplayed();
    }

    public void clickOnCheckoutBtn() {
        checkOutBtn.click();
    }

    public int checkTotalQuantity(){
        return listOfQuantity.size();
    }
}