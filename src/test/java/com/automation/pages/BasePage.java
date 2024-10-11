package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver driver;
    //WebDriverWait wait;
    public BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        //wait= new WebDriverWait(driver, Duration.ofSeconds(60));
    }

}