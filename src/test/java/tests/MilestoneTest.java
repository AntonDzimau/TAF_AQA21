package tests;

import models.Milestone;
import models.MilestoneBuilder;
import org.testng.annotations.Test;

public class MilestoneTest {
    @Test
    public void lombokTest1() {
        Milestone milestone = new Milestone();
        milestone.setId(1111);
        milestone.setName("mileName");
        milestone.setDescription("mileDescription");
        milestone.setCompleted(false);

        Milestone milestone1 = new Milestone();
        milestone1.setId(2222);
        milestone1.setName("mileName");
        milestone1.setDescription("mileDescription");
        milestone1.setCompleted(false);

        System.out.println(milestone.toString());
        System.out.println(milestone1.toString());
        System.out.println(milestone.equals(milestone1));

    }


    @Test
    public void lombokTest2() {
        MilestoneBuilder milestoneBuilder = MilestoneBuilder.builder()
                .id(3333)
                .completed(true)
                .description("description")
                .name("maileName3")
                .build();

        MilestoneBuilder milestoneBuilder1 = MilestoneBuilder.builder()
                .id(3333)
                .completed(true)
                .description("description")
                .name("maileName3")
                .build();

        System.out.println(milestoneBuilder.toString());
        System.out.println(milestoneBuilder1.toString());
        System.out.println(milestoneBuilder.equals(milestoneBuilder1));

    }
}
