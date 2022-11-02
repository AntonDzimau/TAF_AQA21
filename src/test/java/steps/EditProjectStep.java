package steps;

import baseEntities.BaseStep;
import entities.ProjectsEntities;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.projects.EditProjectPage;
import pages.projects.ListProjectsPage;

public class EditProjectStep extends BaseStep {
    ListProjectsPage listProjectsPage;
    EditProjectPage editProjectPage;
    ProjectsEntities projectsEntities;

    public EditProjectStep(WebDriver driver) {
        super(driver);
        editProjectPage = new EditProjectPage(driver);
        listProjectsPage = new ListProjectsPage(driver);
        projectsEntities = new ProjectsEntities();

    }

    @Step
    public void openPageByUrl() {
        editProjectPage.openPageByUrl();
    }

    @Step
    public ListProjectsPage editProject(String projectNameToEdit, boolean flagShowAnon, String newName, String newAnnouncement) {
        listProjectsPage.openPageByUrl();
        listProjectsPage.getListOfProjects().getRow(projectNameToEdit).getCell(0).getLinkFromCell().click();
        editProjectPage.getShowAnnouncementCheckBox().flag(flagShowAnon);
        editProjectPage.getNameInput().rewrite(newName);
        editProjectPage.getAnnouncementTextarea().rewrite(newAnnouncement);
        editProjectPage.getAcceptButton().click();
        return new ListProjectsPage(driver);
    }
}
