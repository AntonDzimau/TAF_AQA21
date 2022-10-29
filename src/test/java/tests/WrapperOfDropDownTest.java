package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrapperOfDropDownTest extends BaseTest {

    @Test
    public void goToActivitySummerReportTest() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        testCasesStep.openPageByUrl();
        testCasesStep.showReportDropDownMenu();
        testCasesStep.goToActivitySummaryPage();
        Assert.assertEquals(
                activitySummaryStep.getReportTitleText()
                , "Activity Summary");
    }

}
