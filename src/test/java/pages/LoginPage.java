package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final By usernameInputLocator = By.id("user-name");
    private final By pswInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");
    private final By errorTextLocator = By.xpath("//h3[@data-test='error']");

    public SelenideElement getUserNameInput() {
        return $(usernameInputLocator).shouldBe(Condition.visible);
    }

    public void setUsername(String value) {
        $(usernameInputLocator).shouldBe(Condition.visible).setValue(value);
    }

    public void setPsw(String value) {
        $(pswInputLocator).shouldBe(Condition.visible).setValue(value);
    }

    public void clickLoginButton() {
        $(loginButtonLocator).shouldBe(Condition.visible).click();
    }

    public SelenideElement getErrorTextElement() {
        return $(errorTextLocator).shouldBe(Condition.visible);
    }
}
