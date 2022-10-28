package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Сортировка товаров в каталоге.")
public class SortTest extends BaseTest {

    @Test(description = "Сортировка по алфавиту")
    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case 10")
    @Description("Проверка сортировки товаров в каталоге по алфавиту в прямом порядке")
    public void sortByAZTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        Assert.assertEquals(
                sortStep.setSortByAlphabet("az")
                , "Sauce Labs Backpack");
    }

    @Test(description = "Сортировка по алфавиту")
    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case 11")
    @Description("Проверка сортировки товаров в каталоге по алфавиту в обратном порядке")
    public void sortByZATest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        Assert.assertEquals(
                sortStep.setSortByAlphabet("za")
                , "Test.allTheThings() T-Shirt (Red)");
    }

    @Test(description = "Сортировка по цене")
    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case 12")
    @Description("Проверка сортировки товаров в каталоге по цене от меньшей к большей")
    public void sortByPriceLowToHighTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        Assert.assertEquals(
                sortStep.setSortByPrice("lohi")
                , "$7.99");
    }

    @Test(description = "Сортировка по цене")
    @Severity(SeverityLevel.NORMAL)
    @Story("Test Case 13")
    @Description("Проверка сортировки товаров в каталоге по цене от большей к меньшей")
    public void sortByPriceHighToLowTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        Assert.assertEquals(
                sortStep.setSortByPrice("hilo")
                , "$49.99");
    }
}
