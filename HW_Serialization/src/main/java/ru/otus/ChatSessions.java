package ru.otus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data

public class ChatSessions {
    @JsonProperty(value="chat_sessions")
    private List<ChatSession> chatSessions;
}
