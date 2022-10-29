package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Span {
    UIElement uiElement;

    public Span(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public Span(WebDriver driver, WebElement webElement) {
        this.uiElement = new UIElement(driver, webElement);
    }

    public String getText() {
        return uiElement.getText();
    }
}
