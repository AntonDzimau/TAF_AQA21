package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    // 1. Блок описания селекторов для элементов
    private final By emailInputLocator = By.id("name");
    private final By pswInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");


    // 3. Блок атомарных методов
    public SelenideElement getEmailInput() {
        return $(emailInputLocator).shouldBe(Condition.visible);
    }
    public SelenideElement getPswInput() {
        return $(pswInputLocator).shouldBe(Condition.visible);
    }
    public SelenideElement getLoginButton() {
        return $(loginButtonLocator).shouldBe(Condition.visible);
    }
    public void setEmail(String value) {
        getEmailInput().setValue(value);
    }
    public void setPsw(String value) {
        getPswInput().setValue(value);
    }
    public void clickLoginButton() {
        getLoginButton().click();
    }
    public SelenideElement getErrorTextElement() {
        return $(errorTextLocator).shouldBe(Condition.visible);
    }
}
