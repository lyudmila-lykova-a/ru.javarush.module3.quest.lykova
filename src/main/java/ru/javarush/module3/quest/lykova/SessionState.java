package ru.javarush.module3.quest.lykova;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class SessionState {
    private final LocalDateTime startSession = LocalDateTime.now() ;
    private String name;
    private String ipAddress;
    private Node currentGameNode;
    private int gamesCount;

    public String getStartSessionFormatted() {
        return startSession.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }
}
