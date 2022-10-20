package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowsersService;
import services.WaitsService;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WaitsService wait;
    protected Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
        wait = new WaitsService(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }
}
