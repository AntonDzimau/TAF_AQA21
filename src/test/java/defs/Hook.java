package defs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.DashboardPage;
import pages.LoginPage;
import services.BrowsersService;
import steps.LoginStep;

public class Hook extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public Hook(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Before
    public void initScenario(Scenario scenario) {
        System.out.println("Hook is started...");
        BaseCucumberTest.driver = new BrowsersService().getDriver();
        BaseCucumberTest.loginPage = new LoginPage(driver);
        BaseCucumberTest.dashboardPage = new DashboardPage(driver);
        BaseCucumberTest.loginStep = new LoginStep(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Screenshot");
        }
        if (baseCucumberTest.driver != null) {
            baseCucumberTest.driver.quit();
        }
    }
}
