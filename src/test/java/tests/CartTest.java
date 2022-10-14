package tests;

import baseEntities.BaseTest;
import configuration.ReadItemsProperties;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void openCartTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        Assert.assertTrue(cartStep.goToCartPage().isPageOpened());
    }

    @Test
    public void addBackpackToCartTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        cartStep.addItemToCart(ReadItemsProperties.getIdToAddBackPack());
        Assert.assertEquals(cartStep.getQuantityOfItemsInCartLabel(), "1");
        Assert.assertEquals(cartStep.getNameOfItemsInCart(), "Sauce Labs Backpack");
    }

    @Test
    public void addAllItemsToCart() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        cartStep.addAllItemsToCart();
        Assert.assertEquals(cartStep.getQuantityOfItemsInCartLabel(), "6");
        Assert.assertEquals(cartStep.getQuantityOfItemsInCartPage(), "6");
    }

    @Test
    public void removeBackpackFromCartPageTest() {
        addBackpackToCartTest();
        cartStep.removeItemFromCartPage(ReadItemsProperties.getIdToRemoveBackPack());
        Assert.assertEquals(cartStep.goToCartPage().getCartItemNames().size()+"","0");
    }
}
