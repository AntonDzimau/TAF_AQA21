package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    private String name;
    private String announcement;
    @JsonProperty("show_announcement")
    private boolean isShowAnnouncement;
    @JsonProperty("suite_mode")
    private int typOfProject;
    private boolean isCompleted;

}
