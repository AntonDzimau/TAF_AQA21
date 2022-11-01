package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.projects.AddProjectPage;
import pages.projects.ListProjectsPage;

public class AddProjectStep extends BaseStep {
    AddProjectPage addProjectPage;
    //ProjectsEntities projectsEntities = new ProjectsEntities();

    public AddProjectStep(WebDriver driver) {
        super(driver);
        addProjectPage = new AddProjectPage(driver);
    }

    @Step
    public void openPageByUrl() {
        addProjectPage.openPageByUrl();
    }

    @Step
    public ListProjectsPage addNewProjectByRadioNumber() {
        Project project1 = Project.builder()
                .name("New Test Project Name 1")
                .announcement("This is a description of test project 1.")
                .showAnnouncement(false)
                .type(1)
                .build();
        openPageByUrl();
        addProjectPage.getNameInput().sendKeys(project1.getName());
        addProjectPage.getAnnouncementTextarea().sendKeys(project1.getAnnouncement());
        addProjectPage.getShowAnnouncementCheckBox().flag(project1.isShowAnnouncement());
        addProjectPage.getRadioButton().getRadioOption(project1.getType()).setByRadioInput();
        return new ListProjectsPage(driver);
    }


    @Step
    public ListProjectsPage addNewProjectByRadioName() {
        Project project2 = Project.builder()
                .name("New Test Project Name 2")
                .announcement("This is a description of test project 2.")
                .showAnnouncement(true)
                .type(3)
                .build();
        openPageByUrl();
        addProjectPage.getNameInput().sendKeys(project2.getName());
        addProjectPage.getAnnouncementTextarea().sendKeys(project2.getAnnouncement());
        addProjectPage.getShowAnnouncementCheckBox().flag(project2.isShowAnnouncement());
        addProjectPage.getRadioButton().getRadioOption(project2.getType()).setByName();
        addProjectPage.getAcceptButton().click();
        return new ListProjectsPage(driver);
    }
}
