package entities;

import models.Project;


public class ProjectsEntities {
    public Project ProjectType1 = Project.builder()
            .name("Type 1 project")
            .announcement("LOREM IPSUM DOLOR SIT AMET")
            .isShowAnnouncement(true)
            .typOfProject(1)
            .build();

    public Project ProjectType2 = Project.builder()
            .name("Type 2 project")
            .announcement("LOREM IPSUM DOLOR SIT AMET")
            .isShowAnnouncement(true)
            .typOfProject(2)
            .build();

    public Project ProjectType3 = Project.builder()
            .name("Type 3 project")
            .announcement("LOREM IPSUM DOLOR SIT AMET")
            .isShowAnnouncement(true)
            .typOfProject(3)
            .build();
}
