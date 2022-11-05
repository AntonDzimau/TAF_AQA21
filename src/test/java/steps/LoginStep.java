package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CataloguePage;
import pages.LoginPage;
import pages.TopMenuBurgerPage;
import services.WaitsService;

public class LoginStep extends BaseStep {
    LoginPage loginPage;
    CataloguePage cataloguePage;
    WaitsService waitsService;


    public LoginStep(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
        cataloguePage = new CataloguePage(driver);
        waitsService = new WaitsService(driver);
    }

    public void login(String email, String psw) {
        loginPage.setEmail(email);
        loginPage.setPsw(psw);
        loginPage.clickLoginButton();
    }

    @Step
    public LoginPage logout() {
        cataloguePage.headerPage.openBurgerMenu();
        waitsService.waitForVisibility(cataloguePage.headerPage.topMenuBurgerPage.logoutLink);
        cataloguePage.headerPage.topMenuBurgerPage.logoutLink.click();
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
