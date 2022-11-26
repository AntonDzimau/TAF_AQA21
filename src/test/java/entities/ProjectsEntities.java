package entities;

import models.ProjectBuilder;


public class ProjectsEntities {
    public ProjectBuilder projectBuilderType1 = ProjectBuilder.builder()
            .name("Type 1 project")
            .announcement("LOREM IPSUM DOLOR SIT AMET")
            .isShowAnnouncement(true)
            .typOfProject(1)
            .build();

    public ProjectBuilder projectBuilderType2 = ProjectBuilder.builder()
            .name("Type 2 project")
            .announcement("LOREM IPSUM DOLOR SIT AMET")
            .isShowAnnouncement(true)
            .typOfProject(2)
            .build();

    public ProjectBuilder projectBuilderType3 = ProjectBuilder.builder()
            .name("Type 3 project")
            .announcement("LOREM IPSUM DOLOR SIT AMET")
            .isShowAnnouncement(true)
            .typOfProject(3)
            .build();
}
