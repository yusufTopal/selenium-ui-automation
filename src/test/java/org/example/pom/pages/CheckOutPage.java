package org.example.pom.pages;

import org.example.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {

    private final By firstNameField = By.id("billing_first_name");
    private final By lastNameField = By.id("billing_last_name");
    private final By address1Field = By.id("billing_address_1");
    private final By cityField = By.id("billing_city");
    private final By postCodeField = By.id("billing_postcode");
    private final By emailField = By.id("billing_email");
    private final By placeOrderButton = By.cssSelector("#place_order");
    private final By successNoticeField = By.cssSelector(".woocommerce-notice");

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public CheckOutPage enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public CheckOutPage enterAddress1(String address) {
        driver.findElement(address1Field).sendKeys(address);
        return this;
    }

    public CheckOutPage enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
        return this;
    }

    public CheckOutPage enterPostCode(String postCode) {
        driver.findElement(postCodeField).sendKeys(postCode);
        return this;
    }

    public CheckOutPage enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public CheckOutPage clickPlaceOrderButton() {
        driver.findElement(placeOrderButton).click();
        return this;
    }

    public String getNotice() {
        return driver.findElement(successNoticeField).getText();
    }
}
