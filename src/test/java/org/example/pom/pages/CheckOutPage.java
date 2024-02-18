package org.example.pom.pages;

import org.example.pom.base.BasePage;
import org.example.pom.models.BillingAddress;
import org.example.pom.models.User;
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
    private final By clickHereToLoginLink = By.className("showlogin");
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.name("login");


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage enterFirstName(String firstName) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public CheckOutPage enterLastName(String lastName) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public CheckOutPage enterAddress1(String address) {
        driver.findElement(address1Field).clear();
        driver.findElement(address1Field).sendKeys(address);
        return this;
    }

    public CheckOutPage enterCity(String city) {
        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);
        return this;
    }

    public CheckOutPage enterPostCode(String postCode) {
        driver.findElement(postCodeField).clear();
        driver.findElement(postCodeField).sendKeys(postCode);
        return this;
    }

    public CheckOutPage enterEmail(String email) {
        driver.findElement(emailField).clear();
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

    public CheckOutPage clickHereToLoginLink() {
        driver.findElement(clickHereToLoginLink).click();
        return this;
    }

    public CheckOutPage enterUserName(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public CheckOutPage enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public CheckOutPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }

    public CheckOutPage login(String username, String password) {
        return enterUserName(username)
                .enterPassword(password)
                .clickLoginButton();
    }

    public CheckOutPage login(User user){
        return enterUserName(user.getUsername())
                .enterPassword(user.getPassword())
                .clickLoginButton();
    }

    public CheckOutPage setBillingAddress(BillingAddress billingAddress) {
        return
                enterFirstName(billingAddress.getFirstName())
                .enterLastName(billingAddress.getLastName())
                .enterEmail(billingAddress.getEmail())
                .enterAddress1(billingAddress.getAddressLineOne())
                .enterCity(billingAddress.getCity())
                .enterPostCode(billingAddress.getPostalCode())
                .enterEmail(billingAddress.getEmail());
    }
}