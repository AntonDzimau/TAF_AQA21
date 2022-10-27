package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.CheckBox;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.projects.AddProjectPage;
import pages.projects.UpdateProjectPage;

public class LoginTest extends BaseTest {


    @Test
    public void successLoginTest() {
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
        //пример использования и реализации
   /*     CheckBox checkBox = new CheckBox(driver, By.id("id"));
        checkBox.removeFlag();
        checkBox.setFlag();*/
    }

    @Test
    public void successLoginTest1() {
        Assert.assertTrue(
                loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                .isPageOpened());
    }

    @Test
    public void incorrectUsernameTest() {
        Assert.assertEquals(
                loginStep.loginIncorrect("sdsd", ReadProperties.password())
                        .getErrorTextElement().getText()
                ,"Email/Login or Password is incorrect. Please try again.");
    }

    @Test
    public void incorrectPswTest() {
        new UpdateProjectPage(driver).getNameInput();
        new AddProjectPage(driver).getSaveButton();
    }
}
