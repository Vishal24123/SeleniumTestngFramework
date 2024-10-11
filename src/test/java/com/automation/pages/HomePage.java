package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartLink;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    List<WebElement> addToCartBtnList;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement cartItems;

    @FindBy(id = "react-burger-menu-btn")
    WebElement hamburgerMenu;

    @FindBy(id = "logout_sidebar_link")
    WebElement logOut;

    Select dropdown;

    public boolean isHomePageDisplayed() {
        return shoppingCartLink.isDisplayed();
    }

    public void clickOnAddToCartOfFirstItem() {
        addToCartBtnList.get(0).click();
    }

    public void clickOnShoppingCartLink() {
        shoppingCartLink.click();
    }


    public int getCartIconQuantity() {
        return Integer.parseInt(cartItems.getText());
        //return shoppingCartLink.findElement(By.xpath("./span")).getText();
    }

    public void clickOnHamburgerMenu() {
        hamburgerMenu.click();
    }

    public void clickOnLogoutLink() {
        logOut.click();
    }

    public void selection(){
        dropdown = new Select(driver.findElement(By.xpath("//select[@data-test='product-sort-container']")));
    }

    public boolean priceHighToLow(){
        String productName=driver.findElements(By.cssSelector(".inventory_item")).get(0).findElement(By.cssSelector(".inventory_item_name ")).getText();;
        dropdown.selectByValue("hilo");
        String productName2 = driver.findElements(By.cssSelector(".inventory_item")).get(0).findElement(By.cssSelector(".inventory_item_name ")).getText();
        return productName.equals(productName2);
    }

    public boolean nameZToA(){
        String productName=driver.findElements(By.cssSelector(".inventory_item")).get(0).findElement(By.cssSelector(".inventory_item_name ")).getText();;
        dropdown.selectByValue("za");
        String productName2 = driver.findElements(By.cssSelector(".inventory_item")).get(0).findElement(By.cssSelector(".inventory_item_name ")).getText();
        return productName.equals(productName2);
    }

    public void clickOnAddToCartOfAllItem() {
        for(WebElement button:addToCartBtnList)
            button.click();
    }

    public int allAddToCartBtnPresent(){
        return addToCartBtnList.size();
    }
}