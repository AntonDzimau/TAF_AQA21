package steps;

import BaseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {
    LoginPage loginPage;

    public LoginStep(WebDriver driver, LoginPage loginPage) {
        super(driver);
        this.loginPage = loginPage;
    }

    public LoginStep(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void login(String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }

    public DashboardPage loginSuccessful(String email, String password) {
        login(email, password);

        return new DashboardPage(driver);
    }


    public LoginPage loginIncorrect(String email, String password) {
        login(email, password);

        return loginPage;
    }

    public void logout() {

    }

}
