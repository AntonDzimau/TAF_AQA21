package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonOption {

    private UIElement uiElement;

    public RadioButtonOption(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public RadioButtonOption(WebDriver driver, WebElement webElement) {
        this.uiElement = new UIElement(driver, webElement);
    }

    public RadioButtonOption(WebDriver driver, UIElement uiElement) {
        this.uiElement = uiElement;
    }

    private UIElement getRadioInput() {
        return uiElement.findElement(By.cssSelector("div.row input"));
    }

    private UIElement getRadioText() {
        return uiElement.findElement(By.cssSelector("div.radio p"));
    }

    private UIElement getRadioName() {
        return uiElement.findElement(By.cssSelector("div.radio strong"));
    }

    private UIElement getRadioPicture() {
        return uiElement.findElement(By.cssSelector("div.row a"));
    }

    public void setByRadioInput() {
        set("radioInput");
    }

    public void setByName() {
        set("radioName");
    }

    public void setByText() {
        set("radioText");
    }

    public void setByPicture() {
        set("radioPicture");
    }

    private void set(String setBy) {
        if (!getRadioInput().isSelected()) {
            switch (setBy) {
                case "radioInput":
                    getRadioInput().click();
                case "radioText":
                    getRadioText().click();
                case "radioName":
                    getRadioName().click();
                case "radioPicture":
                    getRadioPicture().click();
            }
        }
    }

    public boolean isSelected() {
        if (getRadioInput().isSelected()) {
            return true;
        } else {
            return false;
        }
    }
}
