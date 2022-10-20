package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

//Epic -> Feature -> Story
@Epics(value = {@Epic(value = "Epic 1"), @Epic(value = "Epic 2")})
public class AllureTest {
    @Test
    @Issue("AQA21-1")
    public void issueTest(){
        Assert.assertTrue(true);
    }

    @Test
    @TmsLink("JV4Bz")
    public void tmsTest(){
        Assert.assertTrue(true);
    }

    @Test
    @Link("http://onliner.by")
    @Link(name = "Onliner Catalogue", type = "mylink", url = "http://onliner.by")
    public void linkTest(){
        Assert.assertTrue(true);
    }

    @Test (description = "test's description")
    public void descriptionTest(){
        Assert.assertTrue(true);
    }

    @Test
    @Description("test's description from Allure")
    public void descriptionAllureTest(){
        Assert.assertTrue(true);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void severityTest(){
        Assert.assertTrue(true);
    }

    @Test
    @Story("test story 1")
    public void storyTest(){
        Assert.assertTrue(true);
    }
}
