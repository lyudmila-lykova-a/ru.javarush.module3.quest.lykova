package ru.javarush.module3.quest.lykova;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SessionState {
    private final LocalDateTime startSession = LocalDateTime.now() ;
    private String name;
    private String ipAddress;
    private Node currentGameNode;
    private int gamesCount;
}
