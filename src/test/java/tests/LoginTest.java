package tests;

import BaseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TopMenuPage;
import steps.LoginStep;

public class LoginTest extends BaseTest {
    @Test
    public void successLoginTest() {
        LoginStep loginStep = new LoginStep(driver);

        loginStep.login(ReadProperties.username(),ReadProperties.password());

        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Test
    public void successLoginTest1() {

    Assert.assertEquals(loginStep.loginIncorrect("sdsd",ReadProperties.password()).getErrorTextElement().getText()
            ,            "");
    }

    @Test
    public void incorrectUsernameTest() {
           DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
        Assert.assertEquals(new LoginPage(driver).getErrorTextElement().getText(),"");
    }

    @Test
    public void incorrectPasswordTest() {

    }


}
