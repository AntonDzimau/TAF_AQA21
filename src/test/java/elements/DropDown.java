package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class DropDown {
    WebDriver driver;
    UIElement uiElement;

    public DropDown(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, webElement);
    }

    public DropDown(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);
    }

    public void setOptionByNumber(int value) {
        uiElement.click();
        findOptions().get(value).click();
    }

    public void setOptionByName(String value) {
        uiElement.click();
        for (int i = 0; i < findOptions().size(); i++) {
            if (findOptions().get(i).getText().contains(value)) {
                System.out.println(findOptions().get(i).getText());
                findOptions().get(i).click();
                break;
            }
        }
    }

    public void setOptionByKeys(String value) {
        uiElement.click();
        uiElement.findElement(By.cssSelector(".chzn-search input")).sendKeys(value);
        if (findOptions().size() > 1) {
            for (int i = 0; i < findOptions().size(); i++) {
                if (findOptions().get(i).getText().contains(value)) {
                    System.out.println(findOptions().get(i).getText());
                    findOptions().get(i).click();
                    break;
                }
            }
        } else {
            findOptions().get(0).click();
        }
    }

    private ArrayList<UIElement> findOptions() {
        return uiElement.findUIElements(By.className("active-result"));
    }
}
