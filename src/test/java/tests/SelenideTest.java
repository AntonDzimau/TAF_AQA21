package tests;

import baseEntities.BaseTest;
import com.codeborne.selenide.*;
import com.codeborne.selenide.selector.ByText;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import steps.LoginStep;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class SelenideTest extends BaseTest {
  @Test
    public void loginTest(){
        open("https://aqa2102.testrail.io/");
        SelenideElement username = $("#name");
        username.setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());

        SelenideElement loginButton = $("#button_primary");
        loginButton
                .shouldBe(exist)
                .shouldBe(enabled)
                .click();

        //коллекция элементов
        ElementsCollection list =  $$(By.tagName("div"));
        list.size();
        //пустая ли
        list.isEmpty();
        //выводит коллекцию из видимых текстовых значений элемента
        list.texts();
        //фильтр по видимости, например, и исключить спрятанные (тавтология)
        list.filter(visible).exclude(hidden);
        list.findBy(text("TestRail QA"));

        //Configuration.timeout = Duration.ofSeconds(30);
        //$(By.xpath("//div[contains(text(),'TestRail QA')]")).shouldBe(visible);
        //$(By.xpath("//div[contains(text(),'TestRail QA')]")).should(exist);
        //$(By.xpath("//div[contains(text(),'TestRail QA')]")).should(readonly);
        //$(By.xpath("//div[contains(text(),'TestRail QA')]")).should(hidden);
        //должен иметь аттрибут name
        $(By.xpath("//div[contains(text(),'TestRail QA')]")).shouldHave(name(""));
        //$(By.xpath("//div[contains(text(),'TestRail QA')]")).shouldBe(visible, Duration.ofSeconds(30));
        $(By.xpath("//div[contains(text(),'TestRail QA')]")).shouldBe(visible).shouldHave(text("TestRail QA"));
        //==
        $(byText("TestRail QA")).shouldBe(visible).shouldHave(text("TestRail QA"));
        //contains
        $(withText("TestRail QA")).shouldBe(visible).shouldHave(text("TestRail QA"));
        //attr Title
        $(byTitle("TestRail QA")).shouldBe(visible).shouldHave(text("TestRail QA"));
        //attr Value
        $(byValue("TestRail QA")).shouldBe(visible).shouldHave(text("TestRail QA"));
        //метод возращает тру если тесты запустились в том браузере, что указали
        boolean result = isChrome();


    }

    @Test
    public void openLoginPageTest(){
        LoginStep loginStep = open("",LoginStep.class);
       DashboardPage dashboardPage= loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
       dashboardPage.getHeaderLogo().shouldBe(visible);
       dashboardPage.isHeaderLogoDisplayed();
    }
    @Test
    public void openLoginPageTest1(){
        LoginStep loginStep = open("",LoginStep.class);
        DashboardPage dashboardPage= loginStep.loginSuccessful(ReadProperties.username(), "incorrectPassword");
        dashboardPage.getHeaderLogo().shouldBe(visible);
        dashboardPage.isHeaderLogoDisplayed();
//проверка во всей коллекции текстов тех и других, в каком-то такой текст, в другом такой
        $$("#employees").shouldHave(
                texts(
                        "Anton Czechau",
                        "Alina Bondarchuk",
                        "Cat Cute"
                )
        );
    }
}
