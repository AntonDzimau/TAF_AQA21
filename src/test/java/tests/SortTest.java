package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTest extends BaseTest {

    @Test
    public void sortByAZTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(),ReadProperties.password());
        Assert.assertEquals(
                sortStep.setSortByAlphabet("az")
                ,"Sauce Labs Backpack");
    }

    @Test
    public void sortByZATest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(),ReadProperties.password());
        Assert.assertEquals(
                sortStep.setSortByAlphabet("za")
                ,"Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void sortByPriceLowToHighTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(),ReadProperties.password());
        Assert.assertEquals(
                sortStep.setSortByPrice("lohi")
                ,"$7.99");
    }

    @Test
    public void sortByPriceHighToLowTest() {
        loginStep.loginSuccessful(ReadProperties.usernameStandard(),ReadProperties.password());
        Assert.assertEquals(
                sortStep.setSortByPrice("hilo")
                ,"$49.99");
    }
}
