package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {
    LoginPage loginPage;

    public LoginStep(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    //просто метод для логина, мы хз какие данные и что вводится, корректно или нет
    @Step
    public void login(String email, String psw) {
        loginPage.setEmail(email);
        loginPage.setPsw(psw);
        loginPage.clickLoginButton();
    }

    //помечаем этой аннотацией, чтобы в отчете были степы, то есть более подробно описывался отчет
    @Step
    public DashboardPage loginSuccessful(String email, String psw) {
        login(email, psw);

        return new DashboardPage(driver);
    }

    @Step
    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);

        return loginPage;
    }

    public void logout() {
    }

}
