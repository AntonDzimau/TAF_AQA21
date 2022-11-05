package tests;

import baseEntities.BaseTest;
import configuration.ReadItemsProperties;
import configuration.ReadProperties;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;


@Features(value = {@Feature(value = "Возможность добавления товаров в корзину."), @Feature(value = "Возможность удаления товаров из корзины.")})
public class CartTest extends BaseTest {

    @Test(description = "Открытие корзины", priority = 6)
    @Story("Test Case 1")
    @Description("Проверка возможности открытия корзины")
    public void openCartTest() {
        Assert.assertTrue(loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password())
                .headerPage.cartButton
                .isDisplayed());
    }

    @Test(description = "Добавление одного товара в корзину", priority = 6)
    @Issue("?selectedIssue=AQA21-37")
    @TmsLink("/QQZe9/4588w")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case 2")
    @Description("Проверка возможности добавления Sauce Labs Backpack в корзину")
    public void addBackpackToCartTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        Assert.assertTrue(addItemToCartStep.addItemToCartAndOpenCart(ReadItemsProperties.getIdToAddBackPack())
                .cartItemsName.get(0).getText()
                .contains("Sauce Labs Backpack"));
    }

    @Test(description = "Добавление всех товаров в корзину", priority = 6)
    @Story("Test Case 3")
    @Description("Проверка возможности добавления всех товаров из каталога в корзину")
    public void addAllItemsToCartTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        Assert.assertEquals(
                addItemToCartStep.addAllItemsToCartAndOpenCart().cartItemsName.size()
                , 6);
    }

    @Test(description = "Отображение количества добавленных в корзину товаров на значке корзины", priority = 6)
    @Story("Test Case 3")
    @Description("Проверка отображения количества добавленных товаров в корзину")
    public void quantityOfItemsInCartLabelTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        Assert.assertEquals(addItemToCartStep.addItemToCartAndOpenCart(ReadItemsProperties.getIdToAddBackPack())
                .headerPage.shoppingCartBadge.getText()
                , "1");
    }


    @Test(description = "Удаление одного товара из корзины", priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case 4")
    @Description("Проверка возможности удаления Sauce Labs Backpack из корзины")
    public void removeBackpackFromCartPageTest() {
        addBackpackToCartTest();
        Assert.assertEquals(
                removeItemFromCartStep.removeItemFromCartPageAndOpenCart(ReadItemsProperties.getIdToRemoveBackPack())
                        .cartItemsName.size(),0);
    }
}
