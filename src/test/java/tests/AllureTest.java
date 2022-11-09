package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

//Epic -> Feature -> Story
// Epic - бизнес требования
// Feature - требования по спецификации
// Story - тест-кейс
@Epic("Epic 1")
@Epics(value = {@Epic(value = "Epic 1"), @Epic(value = "Epic 2")})
@Feature("Feature 1")
public class AllureTest {
    @Test
    //часть ссылки на багтрекинговую систему (остальная часть в Allure.properties
    @Issue("AQA21-1")
    public void issueTest() {
        Assert.assertTrue(true);
    }

    @Test
    //часть ссылки на cценарную систему (остальная часть в Allure.properties)
    @TmsLink("3kyBE")
    public void tmsTest() {
        Assert.assertTrue(true);
    }

    @Test
    //Просто текст, по которой может храниться доп информация по багу, нужно указывать параметр url
    @Link("http://onliner.by")
    //name - значение, которое будет отображаться в отчете
    //type -
    //url - непосредственно ссылка
    @Link(name = "Onliner Catalogue", type = "myLink", url = "http://onliner.by")
    public void linkTest() {
        Assert.assertTrue(true);
    }

    //изменится название самого теста в отчете
    @Test(description = "Описание теста")
    public void descriptionTest() {
        Assert.assertTrue(true);
    }

    @Test
    //добавится секция Description при клике на тест
    @Description("Описание теста через аннотацию Allure")
    public void descriptionTest1() {
        Assert.assertTrue(true);
    }

    @Test
    //жестко указываем важность бага
    @Severity(SeverityLevel.BLOCKER)
    public void severityTest() {
        Assert.assertTrue(true);
    }

    @Test
    //создаст папку в behaviours "test story 1", в которую засунет этот тест в репорте
    @Story("test story 1")
    public void storyTest() {
        Assert.assertTrue(true);
    }
}
