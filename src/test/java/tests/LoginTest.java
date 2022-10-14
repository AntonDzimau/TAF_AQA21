package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {
        Assert.assertTrue(
                loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password())
                .isPageOpened());
    }

    @Test
    public void incorrectUsernameTest() {
        Assert.assertEquals(
                loginStep.loginUnsuccessful("incorrectLogin", ReadProperties.password())
                        .getErrorTextElement().getText()
                ,"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void incorrectPasswordTest() {
        Assert.assertEquals(
                loginStep.loginUnsuccessful(ReadProperties.usernameStandard(), "incorrectPassword")
                        .getErrorTextElement().getText()
                ,"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginLockedUserTest() {
        Assert.assertEquals(
                loginStep.loginUnsuccessful(ReadProperties.usernameLockedOut(), ReadProperties.password())
                        .getErrorTextElement().getText()
                ,"Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void logoutUserTest() throws InterruptedException {
        successLoginTest();
        Assert.assertTrue(
                loginStep.logout()
                        .isPageOpened());
    }
}
