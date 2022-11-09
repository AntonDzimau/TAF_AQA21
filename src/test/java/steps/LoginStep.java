package steps;

import io.qameta.allure.Step;
import pages.DashboardPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.page;

public class LoginStep {
    LoginPage loginPage;

    public LoginStep() {
        loginPage = new LoginPage();
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

        return page(DashboardPage.class);
    }

    @Step
    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);

        return  page(LoginPage.class);
    }

    public void logout() {
    }

}
