package tests;

import baseEntities.BaseTest;
import configuration.ReadItemsProperties;
import configuration.ReadProperties;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Features(value = {@Feature(value = "Возможность добавления товаров в корзину."), @Feature(value = "Возможность удаления товаров из корзины.")})
public class CartTest extends BaseTest {

    @Test(description = "Открытие корзины")
    @Story("Test Case 1")
    @Description("Проверка возможности открытия корзины")
    public void openCartTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        Assert.assertTrue(cartStep.goToCartPage().isPageOpened());
    }

    @Test(description = "Добавление одного товара в корзину")
    @Issue("?selectedIssue=AQA21-37")
    @TmsLink("/QQZe9/4588w")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case 2")
    @Description("Проверка возможности добавления Sauce Labs Backpack в корзину")
    public void addBackpackToCartTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        cartStep.addItemToCart(ReadItemsProperties.getIdToAddBackPack());
        Assert.assertEquals(cartStep.getQuantityOfItemsInCartLabel(), "1");
        /** Правильный ожидаемый результат */
        //Assert.assertEquals(cartStep.getNameOfItemsInCart(), "Sauce Labs Backpack");
        /** Неверный ожидаемый результат, изменен специально, чтобы появился баг*/
        Assert.assertEquals(cartStep.getNameOfItemsInCart(), "Sauce Backpack");
    }

    @Test(description = "Добавление всех товаров в корзину")
    @Story("Test Case 3")
    @Description("Проверка возможности добавления всех товаров из каталога в корзину")
    public void addAllItemsToCart() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        cartStep.addAllItemsToCart();
        Assert.assertEquals(cartStep.getQuantityOfItemsInCartLabel(), "6");
        Assert.assertEquals(cartStep.getQuantityOfItemsInCartPage(), "6");
    }

    @Test(description = "Удаление одного товара из корзины")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case 4")
    @Description("Проверка возможности удаления Sauce Labs Backpack из корзины")
    public void removeBackpackFromCartPageTest() {
        addBackpackToCartTest();
        cartStep.removeItemFromCartPage(ReadItemsProperties.getIdToRemoveBackPack());
        Assert.assertEquals(cartStep.goToCartPage().getCartItemNames().size() + "", "0");
    }
}
