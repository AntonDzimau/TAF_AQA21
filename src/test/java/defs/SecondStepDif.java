package defs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;
import services.WebDriverFactory;
import steps.LoginStep;

public class SecondStepDif extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public SecondStepDif(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }


    @When("User {string} with password {string} logged in")
    public void userWithPasswordLoggedIn(String username, String password) {
        LoginStep loginStep = new LoginStep(WebDriverFactory.getDriver());
        loginStep.loginSuccessful(username, password);
    }

    @Then("Dashboard page is displayed")
    public void dashboardPageIsDisplayed() {
        Assert.assertTrue(new DashboardPage(WebDriverFactory.getDriver()).isPageOpened());
    }

    @Then("project with ID = {int} is displayed")
    public void isProjectDisplayed(int id) {
        Assert.assertEquals(23, id);
    }

    @Given("a description with text")
    public void aDescriptionWithText(String text) {
        System.out.println(text);
    }
}
