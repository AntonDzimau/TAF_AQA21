package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Link {
    private UIElement uiElement;

    public Link(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public Link(WebDriver driver, WebElement webElement) {
        this.uiElement = new UIElement(driver, webElement);
    }

    public void click() {
        uiElement.click();
    }
}
