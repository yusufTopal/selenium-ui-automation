package org.example.pom.tests;

import org.example.pom.base.BaseTest;
import org.example.pom.pages.CartPage;
import org.example.pom.pages.CheckOutPage;
import org.example.pom.pages.HomePage;
import org.example.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTests extends BaseTest {

    @Test
    public void shouldCheckoutUsingDirectBankTransfer() throws InterruptedException {
        HomePage homePage = new HomePage(driver).load();

        StorePage storePage = homePage.clickStoreMenuLink();
        storePage
                .enterTextInSearchField("blue")
                .clickSearchButton();
        Assert.assertEquals(storePage.getTitle(), "Search results: “blue”");

        storePage.clickAddToCartButtonForProduct("Blue Shoes");
        Thread.sleep(5000);

        CartPage cartPage = storePage.clickViewCartLink();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckOutPage checkOutPage = cartPage.clickCheckOutButton();
        checkOutPage
                .enterFirstName("testUser")
                .enterLastName("qa")
                .enterAddress1("san francisco")
                .enterCity("San Francisco")
                .enterPostCode("94188")
                .enterEmail("test@test.com")
                .clickPlaceOrderButton();
        Thread.sleep(5000);
        Assert.assertEquals(checkOutPage.getNotice(), "Thank you. Your order has been received.");
    }

    @Test
    public void shouldCheckoutUsingBilling() throws InterruptedException {
        HomePage homePage = new HomePage(driver).load();

        StorePage storePage = homePage.clickStoreMenuLink();
        storePage
                .enterTextInSearchField("blue")
                .clickSearchButton();
        Assert.assertEquals(storePage.getTitle(), "Search results: “blue”");

        storePage.clickAddToCartButtonForProduct("Blue Shoes");
        Thread.sleep(5000);

        CartPage cartPage = storePage.clickViewCartLink();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckOutPage checkOutPage = cartPage.clickCheckOutButton();
        checkOutPage.clickHereToLoginLink();
        Thread.sleep(3000);
        checkOutPage
                .login("testUser", "samplePwd")
                .enterFirstName("test")
                .enterLastName("tester")
                .enterEmail("test@test.com")
                .enterAddress1("San Francisco")
                .enterCity("San Francisco")
                .enterPostCode("94188")
                .clickPlaceOrderButton();

        Thread.sleep(5000);
        Assert.assertEquals(checkOutPage.getNotice(), "Thank you. Your order has been received.");
    }

}