package tests;

import BaseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TopMenuPage;

public class LoginTest extends BaseTest {
    @Test
    public void successLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginSuccessful(ReadProperties.username(),ReadProperties.password());
        loginPage.clickLoginButton();

        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Test
    public void incorrectUsernameTest() {
        //Какие-то действия
        DashboardPage dashboardPage = new DashboardPage(driver);

    }

    @Test
    public void incorrectPasswordTest() {

    }
}
