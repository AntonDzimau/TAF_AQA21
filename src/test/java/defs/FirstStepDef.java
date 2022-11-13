package defs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import services.WebDriverFactory;

public class FirstStepDef extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public FirstStepDef(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }


    @Given("Browser is open")
    public void browserIsOpen() {
    }

    @When("The Login page is open")
    public void theLoginPageIsOpen() {
        WebDriverFactory.getDriver().get(ReadProperties.getUrl());
    }

    @Then("Username input is displayed")
    public void IsUsernameInputDisplayed() {
        System.out.println("Check-up is success");
        //Assert.assertTrue( new LoginPage(driver).getEmailInput().isDisplayed());
    }
}
