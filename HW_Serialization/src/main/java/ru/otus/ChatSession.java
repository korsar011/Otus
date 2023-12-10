package ru.otus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data

public class ChatSession {
    @JsonProperty(value="chat_id")
    private int chatId;
    @JsonProperty(value="chat_identifier")
    private String chatIdentifier;
    @JsonProperty(value="display_name")
    private String displayName;
    @JsonProperty(value="is_deleted")
    private int isDeleted;
    @JsonProperty(value="members")
    private List<Member> members;
    @JsonProperty(value="messages")
    private List<Message> messages;
}
