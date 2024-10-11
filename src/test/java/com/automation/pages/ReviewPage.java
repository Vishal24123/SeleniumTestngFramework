package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReviewPage extends BasePage {

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(css = ".inventory_item_price")
    List<WebElement> priceElements;

    @FindBy(css = ".summary_tax_label")
    WebElement taxLabel;

    public boolean isReviewPageDisplayed() {
        return finishBtn.isDisplayed();
    }

    public void clickOnFinishBtn() {
        finishBtn.click();
    }

    public double checkTotal(){
        double totalSum = 0.0;
        for (WebElement priceElement : priceElements)
            totalSum += Double.parseDouble(priceElement.getText().replace("$", ""));
        double taxAmount = Double.parseDouble(taxLabel.getText().replace("Tax: $", ""));
        totalSum += taxAmount;
        return totalSum;
    }
}