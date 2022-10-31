package tests;

import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ProjectsStep;

public class ProjectTest {
    ProjectsStep projectsStep = new ProjectsStep();
    @Test
    public void createProjectTest(){
        projectsStep.createProject("test1", "des1", 1, false, true, true);
    }

    @Test
    public void createProjectTest2(){
        projectsStep.createProject("test2", "des2", 2, true, false, true);
    }

    @Test
    public void updateProjectTest(){
        Project project = new Project();
        project.setName("test3");
        project.setDescription("des3");
        project.setType(3);
        project.setShowAnon(true);
        project.setAccess(true);
        project.setDeleted(true);

        projectsStep.createProject(project);

    }


    @Test
    public void compareProjectTest(){
        Project project = new Project();
        project.setName("test3");
        project.setDescription("des3");
        project.setType(3);
        project.setShowAnon(true);
        project.setAccess(true);
        project.setDeleted(true);

        Project project1 = new Project();
        project1.setName("test3");
        project1.setDescription("des3");
        project1.setType(3);
        project1.setShowAnon(true);
        project1.setAccess(true);
        project1.setDeleted(true);

        Assert.assertTrue(project.equals(project1));

    }
}
