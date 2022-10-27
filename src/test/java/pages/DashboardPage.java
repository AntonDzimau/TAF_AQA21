package pages;

import baseEntities.BasePage;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage{
    //Ссылка для прямого доступа на страницу
    private final static String pagePath = "index.php?/dashboard";
    // 1. Блок описания селекторов для элементов
    //Один из них будет идентификатором открытия страницы
    private final By headerLogoLocator = By.xpath("//div[contains(text(),'TestRail QA')]");
    public TopMenuPage topMenuPage;
    // 2. Блок инициализации страницы
    public DashboardPage(WebDriver driver) {
        super(driver);
        //Когда инициализируется DashboardPage, автоматически произойдет
        //инициализация и topMenuPage, при том я к нему могу обратиться
        //непосредственно из DashboardPage
        topMenuPage = new TopMenuPage(driver);
    }

    public void openPageByUrl() {
       super.openPageByUrl(pagePath);
    }
    // 3. Блок атомарных методов
    public WebElement getHeaderLogo() {
       return waitsService.waitForVisibilityBy(headerLogoLocator);
    }

    //!!! Подход, когда проверка наличия описывается в атомарном методе на странице
    public boolean isHeaderLogoDisplayed() {
       return getHeaderLogo().isDisplayed();
    }


}
