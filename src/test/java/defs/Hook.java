package defs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import services.BrowsersService;
import services.WebDriverFactory;

public class Hook extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public Hook(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Before
    public void initScenario(Scenario scenario) {
        System.out.println("Hook is started...");
        BaseCucumberTest.driver = new BrowsersService().getDriver();
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Screenshot");
        }
        if (baseCucumberTest.driver != null) {
            WebDriverFactory.getDriver().quit();
        }
    }
}
