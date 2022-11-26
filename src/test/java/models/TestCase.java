package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {
    private String title;
    @JsonProperty("type_id")
    @SerializedName(value = "type_id")
    private int type;
    @JsonProperty("priority_id")
    @SerializedName(value = "priority_id")
    private int priority;
    @JsonProperty("refs")
    @SerializedName(value = "refs")
    private String references;
}
