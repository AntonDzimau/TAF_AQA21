package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import steps.LoginStep;

public class BaseCucumberTest {
   public static WebDriver driver;
   public static LoginPage loginPage;
   public static DashboardPage dashboardPage;
   public static LoginStep loginStep;
}
