package org.example.pom.tests;

import org.example.pom.base.BaseTest;
import org.example.pom.models.BillingAddress;
import org.example.pom.models.Product;
import org.example.pom.models.User;
import org.example.pom.pages.CartPage;
import org.example.pom.pages.CheckOutPage;
import org.example.pom.pages.HomePage;
import org.example.pom.pages.StorePage;
import org.example.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class EndToEndTests extends BaseTest {

    @Test
    public void shouldCheckoutUsingDirectBankTransfer() throws IOException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("billingAddress.json", BillingAddress.class );

        Product product = new Product(1215);

        HomePage homePage = new HomePage(driver.get()).load();

        StorePage storePage = homePage.clickStoreMenuLink();
        storePage
                .enterTextInSearchField("blue")
                .clickSearchButton();
        Assert.assertEquals(storePage.getTitle(), "Search results: “blue”");

        storePage.clickAddToCartButtonForProduct(product.getName());

        CartPage cartPage = storePage.clickViewCartLink();
        Assert.assertEquals(cartPage.getProductName(), product.getName());

        CheckOutPage checkOutPage = cartPage
                .clickCheckOutButton()
                .setBillingAddress(billingAddress)
                .selectDirectBankTransfer()
                .clickPlaceOrderButton();
        Assert.assertEquals(checkOutPage.getNotice(), "Thank you. Your order has been received.");
    }

    @Test
    public void shouldCheckoutUsingBilling() throws IOException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("billingAddress.json", BillingAddress.class );

        Product product = new Product(1215);

        User user = new User("tester", "somepwd");

        HomePage homePage = new HomePage(driver.get()).load();

        StorePage storePage = homePage.clickStoreMenuLink();
        storePage
                .enterTextInSearchField("blue")
                .clickSearchButton();
        Assert.assertEquals(storePage.getTitle(), "Search results: “blue”");

        storePage.clickAddToCartButtonForProduct(product.getName());

        CartPage cartPage = storePage.clickViewCartLink();
        Assert.assertEquals(cartPage.getProductName(), product.getName());

        CheckOutPage checkOutPage = cartPage.clickCheckOutButton();
        checkOutPage.clickHereToLoginLink();
        checkOutPage
                .login(user)
                .setBillingAddress(billingAddress)
                .selectDirectBankTransfer()
                .clickPlaceOrderButton();

        Assert.assertEquals(checkOutPage.getNotice(), "Thank you. Your order has been received.");
    }

}