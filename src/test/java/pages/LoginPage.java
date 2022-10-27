package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.CheckBox;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // 1. Блок описания селекторов для элементов
    private final By emailInputLocator = By.id("name");
    private final By pswInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");

    // 2. Блок инициализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return loginButtonLocator;
    }

    // 3. Блок атомарных методов
    public WebElement getEmailInput() {
        return new UIElement(driver, waitsService.waitForVisibilityBy(emailInputLocator));
    }

    public UIElement getPswInput() {
        return new UIElement(driver, pswInputLocator);
    }

    public Button getLoginButton() {
        return new Button(driver, loginButtonLocator);
    }

    public void setEmail(String value) {
        getEmailInput().sendKeys(value);
    }

    public void setPsw(String value) {
        getPswInput().sendKeys(value);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public WebElement getErrorTextElement() {
        return waitsService.waitForVisibilityBy(errorTextLocator);
    }

    public CheckBox getCheckBox() {
        return new CheckBox(driver, loginButtonLocator);
    }

}
