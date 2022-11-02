package steps;

import baseEntities.BaseStep;
import entities.ProjectsEntities;
import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.projects.AddProjectPage;
import pages.projects.ListProjectsPage;

public class AddProjectStep extends BaseStep {
    AddProjectPage addProjectPage;
    ProjectsEntities projectsEntities;

    public AddProjectStep(WebDriver driver) {
        super(driver);
        addProjectPage = new AddProjectPage(driver);
        projectsEntities = new ProjectsEntities();
    }

    @Step
    public void openPageByUrl() {
        addProjectPage.openPageByUrl();
    }

    @Step
    public ListProjectsPage addNewProjectByRadioNumber() {
        openPageByUrl();
        addProjectPage.getNameInput().sendKeys(projectsEntities.testProject1.getName());
        addProjectPage.getAnnouncementTextarea().sendKeys(projectsEntities.testProject1.getAnnouncement());
        addProjectPage.getShowAnnouncementCheckBox().flag(projectsEntities.testProject1.isShowAnnouncement());
        addProjectPage.getRadioButton().getRadioOption(projectsEntities.testProject1.getType()).setByRadioInput();
        return new ListProjectsPage(driver);
    }


    @Step
    public ListProjectsPage addNewProjectByRadioName() {
        openPageByUrl();
        addProjectPage.getNameInput().sendKeys(projectsEntities.testProject2.getName());
        addProjectPage.getAnnouncementTextarea().sendKeys(projectsEntities.testProject1.getAnnouncement());
        addProjectPage.getShowAnnouncementCheckBox().flag(projectsEntities.testProject1.isShowAnnouncement());
        addProjectPage.getRadioButton().getRadioOption(projectsEntities.testProject1.getType()).setByName();
        addProjectPage.getAcceptButton().click();
        return new ListProjectsPage(driver);
    }
    @Step
    public ListProjectsPage addNewProjectByPicture() {
        openPageByUrl();
        addProjectPage.getNameInput().sendKeys(projectsEntities.testProject3.getName());
        addProjectPage.getAnnouncementTextarea().sendKeys(projectsEntities.testProject3.getAnnouncement());
        addProjectPage.getShowAnnouncementCheckBox().flag(projectsEntities.testProject3.isShowAnnouncement());
        addProjectPage.getRadioButton().getRadioOption(projectsEntities.testProject3.getType()).setByPicture();
        addProjectPage.getAcceptButton().click();
        return new ListProjectsPage(driver);
    }

}
