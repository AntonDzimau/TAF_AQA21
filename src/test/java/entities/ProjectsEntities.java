package entities;

import models.Project;
/**Наработка на ближайшее будущее. Хочу сделать класс, где буду хранить создание тех или иных сущностей, чтобы не создавать их каждый раз в степах*/
public class ProjectsEntities {
    public Project testProject1 = Project.builder()
            .name("testProject1")
            .announcement("Description testProject1")
            .showAnnouncement(true)
            .type(1)
            .build();

    public Project testProject2 = Project.builder()
            .name("testProject2")
            .announcement("Description testProject2")
            .showAnnouncement(false)
            .type(2)
            .build();

    public Project testProject3 = Project.builder()
            .name("testProject3")
            .announcement("Description testProject3")
            .showAnnouncement(true)
            .type(3)
            .build();
}
