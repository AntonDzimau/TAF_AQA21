package steps;

import baseEntities.BaseStep;
import entities.ProjectsEntities;
import io.qameta.allure.Step;
import models.Milestone;
import org.openqa.selenium.WebDriver;
import pages.milestones.AddMilestonePage;
import pages.milestones.ListMilestonesPage;
import pages.projects.ListProjectsPage;

public class AddMilestoneStep extends BaseStep {
    AddMilestonePage addMilestonePage;
    ProjectsEntities projectsEntities;

    public AddMilestoneStep(WebDriver driver) {
        super(driver);
        addMilestonePage = new AddMilestonePage(driver);
        projectsEntities = new ProjectsEntities();
    }

    @Step
    public void openPageByUrl() {
        addMilestonePage.openPageByUrl();
    }

    @Step
    public ListMilestonesPage createMilestone(Milestone milestone) {
        openPageByUrl();
        addMilestonePage.getNameInput().sendKeys(milestone.getName());
        addMilestonePage.getReferenceInput().sendKeys(milestone.getReferences());
        addMilestonePage.getDescriptionTextarea().sendKeys(milestone.getDescription());
        addMilestonePage.getIsCompletedCheckBox().flag(milestone.isCompleted());
        addMilestonePage.getAcceptButton().click();
        return new ListMilestonesPage(driver);
    }


}
