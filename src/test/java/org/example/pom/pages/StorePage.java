package org.example.pom.pages;

import org.example.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

    private final By searchField = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void enterTextInSearchField(String text) {
        driver.findElement(searchField).sendKeys(text);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public String getTitle() {
       return driver.findElement(title).getText();
    }

    public void clickAddToCartButtonForProduct(String productName) {
        driver.findElement(getAddToCartButtonForProduct(productName)).click();
    }

    public void clickViewCartLink() {
        driver.findElement(viewCartLink).click();
    }

    private By getAddToCartButtonForProduct(String productName) {
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }

}
