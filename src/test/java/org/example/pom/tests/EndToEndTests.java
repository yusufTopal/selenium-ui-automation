package org.example.pom.tests;

import org.example.pom.base.BaseTest;
import org.example.pom.models.BillingAddress;
import org.example.pom.models.Product;
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
    public void shouldCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("billingAddress.json", BillingAddress.class );

        Product product = new Product(1215);

        HomePage homePage = new HomePage(driver).load();

        StorePage storePage = homePage.clickStoreMenuLink();
        storePage
                .enterTextInSearchField("blue")
                .clickSearchButton();
        Assert.assertEquals(storePage.getTitle(), "Search results: “blue”");

        storePage.clickAddToCartButtonForProduct(product.getName());
        Thread.sleep(5000);

        CartPage cartPage = storePage.clickViewCartLink();
        Assert.assertEquals(cartPage.getProductName(), product.getName());

        CheckOutPage checkOutPage =
                cartPage.clickCheckOutButton()
                .setBillingAddress(billingAddress)
                .clickPlaceOrderButton();
        Thread.sleep(5000);
        Assert.assertEquals(checkOutPage.getNotice(), "Thank you. Your order has been received.");
    }

    @Test
    public void shouldCheckoutUsingBilling() throws InterruptedException, IOException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("billingAddress.json", BillingAddress.class );

        Product product = new Product(1215);

        HomePage homePage = new HomePage(driver).load();

        StorePage storePage = homePage.clickStoreMenuLink();
        storePage
                .enterTextInSearchField("blue")
                .clickSearchButton();
        Assert.assertEquals(storePage.getTitle(), "Search results: “blue”");

        storePage.clickAddToCartButtonForProduct(product.getName());
        Thread.sleep(5000);

        CartPage cartPage = storePage.clickViewCartLink();
        Assert.assertEquals(cartPage.getProductName(), product.getName());

        CheckOutPage checkOutPage = cartPage.clickCheckOutButton();
        checkOutPage.clickHereToLoginLink();
        Thread.sleep(3000);
        checkOutPage
                .login("testUser", "samplePwd")
                .setBillingAddress(billingAddress)
                .clickPlaceOrderButton();

        Thread.sleep(5000);
        Assert.assertEquals(checkOutPage.getNotice(), "Thank you. Your order has been received.");
    }

}