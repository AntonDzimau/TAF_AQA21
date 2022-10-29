package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDown {
    WebDriver driver;
    UIElement uiElement;

    public DropDown(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, webElement);
    }

    public void showDropDownMenu() {
        uiElement.click();
    }
}
