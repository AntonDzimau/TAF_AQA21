package models;


import lombok.*;

@Builder
//почему-то не работает ту стринг, но мы просто добавим его ниже
@ToString(exclude = "id")
public class MilestoneBuilder {
    private int id;
    private String name;
    private String references;
    private String description;
    private boolean completed;
}
