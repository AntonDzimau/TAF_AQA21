package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DashboardPage {
    //Ссылка для прямого доступа на страницу
    private final static String pagePath = "index.php?/dashboard";
    // 1. Блок описания селекторов для элементов
    //Один из них будет идентификатором открытия страницы
    private final By headerLogoLocator = By.xpath("//div[contains(text(),'TestRail QA')]");
    // 2. Блок инициализации страницы

    public void openPageByUrl() {
       open(pagePath);
    }
    // 3. Блок атомарных методов
    public SelenideElement getHeaderLogo() {
       return $(headerLogoLocator);
    }


    public boolean isHeaderLogoDisplayed() {
       return getHeaderLogo().isDisplayed();
    }


}
