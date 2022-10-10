package pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {
    //Блок описания селекторов для элементов
    private final By emailInputLocator = By.id("name");
    /**Все элементы хранятся на той странице, на которой они используются, а не в каком-то отдельном файле*/
    private final By passwordInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("button_primary");

    //Блок инициализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return loginButtonLocator;
    }

    //Блок атомарных методов
    public WebElement getEmailInput() {
        return driver.findElement(emailInputLocator);
    }

    public WebElement getPasswordInput() {
        return driver.findElement(passwordInputLocator);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }

    public void setEmail(String value) {
        getEmailInput().sendKeys(value);
    }

    public void setPassword(String value) {
        getPasswordInput().sendKeys(value);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public void loginSuccessful(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

}
