package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CataloguePage;
import pages.LoginPage;

public class LoginStep extends BaseStep {
    LoginPage loginPage;
    CataloguePage cataloguePage;

    public LoginStep(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
        cataloguePage = new CataloguePage(driver);
    }

    public void login(String email, String psw) {
        loginPage.setEmail(email);
        loginPage.setPsw(psw);
        loginPage.clickLoginButton();
    }

    @Step
    public LoginPage logout() throws InterruptedException {
        cataloguePage.topMenuBurgerPage.openBurgerMenu();
        Thread.sleep(300);
        cataloguePage.topMenuBurgerPage.getLogoutLink().click();
        return loginPage;
    }

    @Step
    public CataloguePage loginSuccessful(String email, String psw) {
        login(email, psw);
        return cataloguePage;
    }

    @Step
    public LoginPage loginUnsuccessful(String email, String psw) {
        login(email, psw);
        return loginPage;
    }
}
