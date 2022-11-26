package entities;

import models.Milestone;


public class MilestonesEntities {
    public Milestone milestone1 = Milestone.builder()
            .name("Milestone ver. 1.0")
            .description("This is my first milestone through restAPI")
            .startedOn(1669442400)
            .build();

    public Milestone milestone2 = Milestone.builder()
            .name("Milestone ver. 2.0")
            .description("This is my second milestone through restAPI")
            .startedOn(1669446000)
            .build();

    public Milestone milestone3 = Milestone.builder()
            .name("Milestone ver. 3.0")
            .description("This is my third milestone through restAPI")
            .startedOn(1669449600)
            .build();
}
