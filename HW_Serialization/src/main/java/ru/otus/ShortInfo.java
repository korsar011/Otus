package ru.otus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class ShortInfo {
    @JsonProperty(value="chat_identifier")
    private String chatIdentifier;
    @JsonProperty(value="last")
    private String last;
    @JsonProperty(value="belong_number")
    private String belongNumber;
    @JsonProperty(value="send_date")
    private String sendDate;
    @JsonProperty(value="text")
    private String text;
}
