package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTests extends BaseTest {

    @Test
    public void Task1(){
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"),ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.selection();
        Assert.assertFalse(homePage.nameZToA());
    }

    @Test
    public void Task2(){
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"),ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.selection();
        Assert.assertFalse(homePage.priceHighToLow());
    }

    @Test
    public void Task3() {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"),ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnAddToCartOfAllItem();
        Assert.assertEquals(homePage.getCartIconQuantity(), 6);
        homePage.clickOnShoppingCartLink();

        Assert.assertEquals(cartPage.checkTotalQuantity(),6);
    }

    @Test
    public void Task4() {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"),ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnAddToCartOfAllItem();
        Assert.assertEquals(homePage.getCartIconQuantity(), 6);
        homePage.clickOnShoppingCartLink();

        Assert.assertTrue(cartPage.isCartPageDisplayed());
        cartPage.clickOnCheckoutBtn();

        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
        checkoutPage.fillShippingInfo();
        checkoutPage.clickOnContinueBtn();

        Assert.assertTrue(reviewPage.isReviewPageDisplayed());
        Assert.assertEquals(reviewPage.checkTotal(),140.34);
    }

    @Test
    public void Task5() {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"),ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnAddToCartOfAllItem();
        homePage.clickOnShoppingCartLink();

        Assert.assertTrue(cartPage.isCartPageDisplayed());
        cartPage.clickOnCheckoutBtn();

        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
        checkoutPage.fillShippingInfo();
        checkoutPage.clickOnContinueBtn();

        Assert.assertTrue(reviewPage.isReviewPageDisplayed());
        reviewPage.clickOnFinishBtn();

        Assert.assertTrue(orderConfirmationPage.isOrderConfirmationMsgDisplayed());
        orderConfirmationPage.clickBackBtn();

        Assert.assertEquals(homePage.allAddToCartBtnPresent(),6);

    }

}
