package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Builder
@ToString
@Getter
@Setter
public class Project {
    private String name;
    private String announcement;
    private int type;
    private boolean showAnnouncement;
    private boolean access;
    private boolean deleted;
}
