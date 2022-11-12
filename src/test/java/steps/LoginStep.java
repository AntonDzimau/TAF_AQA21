package steps;

import io.qameta.allure.Step;
import pages.CataloguePage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.page;

public class LoginStep {
    LoginPage loginPage;
    CataloguePage cataloguePage;

    public LoginStep() {
        loginPage = new LoginPage();
        cataloguePage = new CataloguePage();
    }

    @Step
    public void login(String username, String psw) {
        loginPage.setUsername(username);
        loginPage.setPsw(psw);
        loginPage.clickLoginButton();
    }

    @Step
    public CataloguePage loginSuccessful(String email, String psw) {
        login(email, psw);
        return page(CataloguePage.class);
    }

    @Step
    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);
        return  page(LoginPage.class);
    }

    @Step
    public LoginPage logout() {
        cataloguePage.headerPage.openBurgerMenu().logout();
        return page(LoginPage.class);
    }
}
