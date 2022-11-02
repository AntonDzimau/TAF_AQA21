package entities;

import models.Project;


public class ProjectsEntities {
    public Project testProject1 = Project.builder()
            .name("Czechau's Test Project Name 1")
            .announcement("This is a description of the Czechau's test project 1.")
            .showAnnouncement(false)
            .type(1)
            .build();

    public Project testProject2 = Project.builder()
            .name("Czechau's Test Project Name 2")
            .announcement("This is a description of the Czechau's test project 2.")
            .showAnnouncement(true)
            .type(2)
            .build();

    public Project testProject3 = Project.builder()
            .name("Czechau's Test Project Name 3")
            .announcement("This is a description of the Czechau's test project 3.")
            .showAnnouncement(true)
            .type(3)
            .build();
}
