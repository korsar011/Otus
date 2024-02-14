package ru.otus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class Message {
    @JsonProperty(value="ROWID")
    private long ROWID;
    @JsonProperty(value="attributedBody")
    private String attributedBody;
    @JsonProperty(value="belong_number")
    private String belongNumber;
    @JsonProperty(value="date")
    private long date;
    @JsonProperty(value="date_read")
    private long dateRead;
    @JsonProperty(value="guid")
    private String guid;
    @JsonProperty(value="handle_id")
    private int handleId;
    @JsonProperty(value="has_dd_results")
    private int hasDdResults;
    @JsonProperty(value="is_deleted")
    private int isDeleted;
    @JsonProperty(value="is_from_me")
    private int isFromMe;
    @JsonProperty(value="send_date")
    private String sendDate;
    @JsonProperty(value="send_status")
    private int sendStatus;
    @JsonProperty(value="service")
    private String service;
    @JsonProperty(value="text")
    private String text;
}
