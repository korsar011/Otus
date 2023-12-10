package ru.otus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Member {
    @JsonProperty(value="first")
    private String first;
    @JsonProperty(value="handle_id")
    private int handleId;
    @JsonProperty(value="image_path")
    private String imagePath;
    @JsonProperty(value="last")
    private String last;
    @JsonProperty(value="middle")
    private String middle;
    @JsonProperty(value="phone_number")
    private String phoneNumber;
    @JsonProperty(value="service")
    private String service;
    @JsonProperty(value="thumb_path")
    private String thumbPath;
}

