package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy (id = "user-name")
    public WebElement usernameInput;
    @FindBy (id = "password")
    public WebElement pswInput;
    @FindBy (id = "login-button")
    public WebElement loginButton;
    @FindBy (xpath = "//h3[@data-test='error']")
    public WebElement errorText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String value) {
        usernameInput.sendKeys(value);
    }

    public void setPsw(String value) {
        pswInput.sendKeys(value);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
