package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowsersService;
import steps.CartStep;
import steps.LoginStep;
import steps.SortStep;

public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    protected SortStep sortStep;
    protected CartStep cartStep;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
        driver.get(ReadProperties.getUrl());

        loginStep = new LoginStep(driver);
        sortStep = new SortStep(driver);
        cartStep = new CartStep(driver);
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }
}
