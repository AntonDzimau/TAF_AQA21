package steps.reportsStep;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ActivitySummaryPage;

public class ActivitySummaryStep extends BaseStep {
    ActivitySummaryPage activitySummaryPage;

    public ActivitySummaryStep(WebDriver driver) {
        super(driver);
        activitySummaryPage = new ActivitySummaryPage(driver);
    }

    @Step
    public String getReportTitleText(){
        return activitySummaryPage.getReportTitle().getText();
    }

}
