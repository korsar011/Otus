package ru.otus;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "HW_Serialization/sms-348536-95ecd0.json";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ChatSessions chatSessions = objectMapper.readValue(new File(filePath), ChatSessions.class);
            List<ShortInfo> shortInfoList = getShortInfos(chatSessions);

            shortInfoList.sort(Comparator.comparing(ShortInfo::getSendDate));

            for (ShortInfo info : shortInfoList) {
                showInfo(info);
            }

            String jsonShortInfo = objectMapper.writeValueAsString(shortInfoList);
            List<ShortInfo> deserializedInfoList = objectMapper.readValue(jsonShortInfo, new TypeReference<List<ShortInfo>>() {});
            for (ShortInfo info : deserializedInfoList) {
                showInfo(info);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void showInfo (ShortInfo info){
        System.out.println("Chat Identifier: " + info.getChatIdentifier() +
                ", Last Name: " + info.getLast() +
                ", Send Date: " + info.getSendDate() +
                ", Text: " + info.getText());
    }

    private static List<ShortInfo> getShortInfos(ChatSessions chatSessions) {
        List<ShortInfo> shortInfoList = new ArrayList<>();

        for (ChatSession chatSession : chatSessions.getChatSessions()) {
            for (Message message : chatSession.getMessages()) {
                ShortInfo shortInfo = new ShortInfo();
                shortInfo.setChatIdentifier(chatSession.getChatIdentifier());
                shortInfo.setLast(chatSession.getMembers().get(0).getLast());
                shortInfo.setBelongNumber(message.getBelongNumber());
                shortInfo.setSendDate(message.getSendDate());
                shortInfo.setText(message.getText());

                shortInfoList.add(shortInfo);
            }
}
        return shortInfoList;
    }
}