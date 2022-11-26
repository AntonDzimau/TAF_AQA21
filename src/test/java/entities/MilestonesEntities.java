package entities;

import models.MilestoneBuilder;


public class MilestonesEntities {
    public MilestoneBuilder milestoneBuilder1 = MilestoneBuilder.builder()
            .name("Milestone ver. 1.0")
            .description("This is my first milestone through restAPI")
            .startedOn(1669442400)
            .build();

    public MilestoneBuilder milestoneBuilder2 = MilestoneBuilder.builder()
            .name("Milestone ver. 2.0")
            .description("This is my second milestone through restAPI")
            .startedOn(1669446000)
            .build();

    public MilestoneBuilder milestoneBuilder3 = MilestoneBuilder.builder()
            .name("Milestone ver. 3.0")
            .description("This is my third milestone through restAPI")
            .startedOn(1669449600)
            .build();
}
