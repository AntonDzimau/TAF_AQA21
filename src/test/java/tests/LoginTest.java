package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature(value = "Вход на сайт.")
public class LoginTest extends BaseTest {

    @Test(description = "Успешный вход", priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Story("Test Case 5")
    @Description("Проверка возможности успешного входа на сайт")
    public void successLoginTest() {
        Assert.assertTrue(
                loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password())
                        .sortContainer.isDisplayed());
    }

    @Test(description = "Ввод неверного логина", priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case 6")
    @Description("Проверка появления уведомления о вводе неверного логина/пароля")
    public void incorrectUsernameTest() {
        Assert.assertEquals(
                loginStep.loginUnsuccessful("incorrectLogin", ReadProperties.password())
                        .errorText.getText()
                , "Epic sadface: Username and password do not match any user in this service");
    }


    @Test(description = "Ввод неверного пароля", priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case 7")
    @Description("Проверка появления уведомления о вводе неверного логина/пароля")
    public void incorrectPasswordTest() {
        Assert.assertEquals(
                loginStep.loginUnsuccessful(ReadProperties.usernameStandard(), "incorrectPassword")
                        .errorText.getText()
                , "Epic sadface: Username and password do not match any user in this service");
    }


    @Test(description = "Попытка входа заблокированного пользователя", priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case 8")
    @Description("Проверка появления уведомления о блокировке пользователя")
    public void loginLockedUserTest() {
        Assert.assertEquals(
                loginStep.loginUnsuccessful(ReadProperties.usernameLockedOut(), ReadProperties.password())
                        .errorText.getText()
                , "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(description = "Выход пользователя из кабинета", priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Case 9")
    @Description("Проверка возможности выхода пользователя из личного кабинета")
    public void logoutUserTest() {
        successLoginTest();
        Assert.assertTrue(
                loginStep.logout()
                        .usernameInput.isDisplayed());
    }
}
