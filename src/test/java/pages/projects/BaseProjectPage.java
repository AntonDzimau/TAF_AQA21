package pages.projects;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseProjectPage extends BasePage {
    private final By nameInputLocator = By.id("name");

    public BaseProjectPage(WebDriver driver) {
        super(driver);
    }

    public By getNameInputLocator() {
        return nameInputLocator;
    }
}
