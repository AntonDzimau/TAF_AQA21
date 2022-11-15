package services;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private static final WebDriver driver;

    static {
        driver = new BrowsersService().getDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
