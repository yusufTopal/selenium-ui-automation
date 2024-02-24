package org.example.pom.pages;

import org.example.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {

    private final By searchField = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public StorePage enterTextInSearchField(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(text);
        return this;
    }

    public StorePage clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return this;
    }

    public String getTitle() {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public StorePage clickAddToCartButtonForProduct(String productName) {
        wait.until(ExpectedConditions.elementToBeClickable(getAddToCartButtonForProduct(productName))).click();
        return this;
    }

    public CartPage clickViewCartLink() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        return new CartPage(driver);
    }

    private By getAddToCartButtonForProduct(String productName) {
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }

}