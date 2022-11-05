package tests;

import baseEntities.BaseTest;
import configuration.ReadItemsProperties;
import configuration.ReadProperties;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HeaderPage;

@Features(value = {@Feature(value = "Возможность добавления товаров в корзину."), @Feature(value = "Возможность удаления товаров из корзины.")})
public class CartTest extends BaseTest {

    @Test(description = "Открытие корзины", priority = 6)
    @Story("Test Case 1")
    @Description("Проверка возможности открытия корзины")
    public void openCartTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        Assert.assertTrue(new CartPage(driver).cartLabel.isDisplayed());
    }

    @Test(description = "Добавление одного товара в корзину", priority = 6)
    @Issue("?selectedIssue=AQA21-37")
    @TmsLink("/QQZe9/4588w")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case 2")
    @Description("Проверка возможности добавления Sauce Labs Backpack в корзину")
    public void addBackpackToCartTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        addItemToCartStep.addItemToCart(ReadItemsProperties.getIdToAddBackPack());
        Assert.assertEquals(new HeaderPage(driver).shoppingCartBadge.getText(), "1");
        Assert.assertTrue(new CartPage(driver).cartItemsName.get(0).getText().contains("Sauce Labs Backpack"));
    }

    @Test(description = "Добавление всех товаров в корзину", priority = 6)
    @Story("Test Case 3")
    @Description("Проверка возможности добавления всех товаров из каталога в корзину")
    public void addAllItemsToCart() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        addItemToCartStep.addAllItemsToCart();
        Assert.assertEquals(new HeaderPage(driver).shoppingCartBadge.getText(), "6");
        Assert.assertEquals(new CartPage(driver).cartItemsName.size() + "", "6");
    }

    @Test(description = "Удаление одного товара из корзины", priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case 4")
    @Description("Проверка возможности удаления Sauce Labs Backpack из корзины")
    public void removeBackpackFromCartPageTest() {
        addBackpackToCartTest();
        removeItemFromCartStep.removeItemFromCartPage(ReadItemsProperties.getIdToRemoveBackPack());
        Assert.assertEquals(new CartPage(driver).cartItemsName.size(), 0);
    }
}
