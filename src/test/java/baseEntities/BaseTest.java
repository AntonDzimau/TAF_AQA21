package baseEntities;

import configuration.ReadProperties;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.BrowsersService;
import steps.*;
import utils.InvokedListener;


@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    protected AddProjectStep addProjectStep;
    protected EditProjectStep editProjectStep;
    protected AddTestCaseStep addTestCaseStep;
    protected RemoveProjectStep removeProjectStep;
    protected AddMilestoneStep addMilestoneStep;

    @BeforeMethod
    @Description("Настройка")
    public void setUp(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        iTestContext.setAttribute("driver", driver);
        driver.get(ReadProperties.getUrl());

        loginStep = new LoginStep(driver);
        addProjectStep = new AddProjectStep(driver);
        editProjectStep = new EditProjectStep(driver);
        addTestCaseStep = new AddTestCaseStep(driver);
        removeProjectStep = new RemoveProjectStep(driver);
        addMilestoneStep = new AddMilestoneStep(driver);
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }
}
