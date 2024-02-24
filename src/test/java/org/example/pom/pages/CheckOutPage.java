package org.example.pom.pages;

import org.example.pom.base.BasePage;
import org.example.pom.models.BillingAddress;
import org.example.pom.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage enterFirstName(String firstName) {
        /* Since one operation can be applied at a time, we can not make wait.clear.sendkeys but we can get the waited
         element and perform actions there. Just be careful if clear would change the DOM, we'd have to perform the wait
         for sendKeys as well.*/
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        element.clear();
        element.sendKeys(firstName);
        return this;
    }

    public CheckOutPage enterLastName(String lastName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        element.clear();
        element.sendKeys(lastName);
        return this;
    }

    public CheckOutPage enterAddress1(String address) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(address1Field));
        element.clear();
        element.sendKeys(address);
        return this;
    }

    public CheckOutPage enterCity(String city) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(cityField));
        element.clear();
        element.sendKeys(city);
        return this;
    }

    public CheckOutPage enterPostCode(String postCode) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(postCodeField));
        element.clear();
        element.sendKeys(postCode);
        return this;
    }

    public CheckOutPage enterEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        element.clear();
        element.sendKeys(email);
        return this;
    }

    public CheckOutPage clickPlaceOrderButton() {
        waitForOverlaysToDisappear(overlay);
        driver.findElement(placeOrderButton).click();
        return this;
    }

    public String getNotice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successNoticeField)).getText();
    }

    public CheckOutPage clickHereToLoginLink() {
        waitForOverlaysToDisappear(overlay);
        wait.until(ExpectedConditions.elementToBeClickable(clickHereToLoginLink)).click();
        return this;
    }

    public CheckOutPage enterUserName(String username) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        element.clear();
        element.sendKeys(username);
        return this;
    }

    public CheckOutPage enterPassword(String password) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        element.clear();
        element.sendKeys(password);
        return this;
    }

    public CheckOutPage clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
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