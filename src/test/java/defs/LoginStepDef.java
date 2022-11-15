package defs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDef extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public LoginStepDef(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("Browser is open")
    public void browserIsOpen() {
    }

    @Given("The Login page is open")
    public void theLoginPageIsOpen() {
        driver.get(ReadProperties.getUrl());
        Assert.assertTrue(loginPage.isPageOpened());
    }

    @When("User logins with correct credentials \\(login - {string}, password - {string})")
    public void userLoginsWithCorrectCredentials(String username, String password) {
        loginStep.loginSuccessful(username, password);
    }

    @When("User logins with incorrect password \\(login - {string}, password - {string})")
    public void userLoginsWithIncorrectPasswordLoginPassword(String username, String password) {
        loginStep.loginIncorrect(username, password);
    }

    @Then("Dashboard page is displayed")
    public void dashboardPageIsDisplayed() {
        Assert.assertTrue(dashboardPage.isPageOpened());
    }

    @Then("Login page is still displayed")
    public void loginPageIsDisplayed() {
        Assert.assertTrue(loginPage.isPageOpened());
    }

    @Then("The error text \\({string}) appeared on the page")
    public void errorTextIsDisplayed(String errorText) {
        Assert.assertEquals(loginPage.getErrorTextElement().getText(), errorText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
