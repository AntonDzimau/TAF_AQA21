package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.projects.ListProjectsPage;

public class CheckBoxAndRadiobuttonTest extends BaseTest {

    @Test
    public void addNewProjectWithCheckBoxTest() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        addProjectStep.addNewProjectByRadioName();
        Assert.assertTrue(
                new ListProjectsPage(driver).getListOfProjects().findInTable("New Test Project Name 2"));
    }

    @Test
    public void removeCheckBoxFlagTest() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        editProjectStep.editProject(false, "Rewriting Test Project Name", "Rewriting announcement");
        Assert.assertTrue(
                new ListProjectsPage(driver).getListOfProjects().findInTable("Rewriting Test Project Name"));
    }
}
