package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class RadioButton {
    private UIElement uiElement;
    private WebDriver driver;

    public RadioButton(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);
    }

    public RadioButton(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, webElement);
    }

    public RadioButtonOption getRadioOption(int numberOfVariant) {
        ArrayList<UIElement> list = uiElement.findUIElements(By.className("add-project-row"));
        return new RadioButtonOption(driver, list.get(numberOfVariant - 1));
    }

}
