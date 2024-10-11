package com.automation.test;

import com.automation.listners.ExtentReportListener;
import com.automation.utils.DriverManager;
import com.automation.utils.ExcelUtils;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(ExtentReportListener.class)
public class DataProviderTest extends BaseTest{
    @Test(dataProvider = "userCredentials")
    public void verifyUserLogin(String username, String password){
        loginPage.openWebsite();
        loginPage.doLogin(username,password);
        Allure.addAttachment("screenshot", DriverManager.takeScreenshotAsInputStream());
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @DataProvider
    public Object[][] userCredentials() {
        ExcelUtils excelUtils=new ExcelUtils("Credentials.xlsx","ValidData");
        List<List<String>> tabledata = excelUtils.getData();
        Object[][] data= new Object[tabledata.size()][tabledata.get(0).size()];
        for (int i=0;i<tabledata.size();i++){
            List<String> row =tabledata.get(i);
            for (int j=0;j<row.size();j++){
                data[i][j]=tabledata.get(i).get(j);
            }
        }
        return data;
    }

    @Test(dataProvider = "userCredentials")
    public void verifyApplicationSavesUserState(String username, String password) {
        loginPage.openWebsite();
        loginPage.doLogin(username, password);
        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnAddToCartOfFirstItem();
        Assert.assertEquals(homePage.getCartIconQuantity(), 1);
        homePage.clickOnHamburgerMenu();
        homePage.clickOnLogoutLink();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
        loginPage.doLogin(username, password);
        Assert.assertTrue(homePage.isHomePageDisplayed());
        Assert.assertEquals(homePage.getCartIconQuantity(), 1);
    }
}
